package com.digitalfactory.irrigationsystem.services.iml;

import com.digitalfactory.irrigationsystem.entities.PlotLandEntity;
import com.digitalfactory.irrigationsystem.exceptions.ResourceAlreadyExistException;
import com.digitalfactory.irrigationsystem.exceptions.ResourceNotFoundException;
import com.digitalfactory.irrigationsystem.exceptions.SensorDeviceUnavailableException;
import com.digitalfactory.irrigationsystem.mappers.PlotLandMapper;
import com.digitalfactory.irrigationsystem.models.PlotLand;
import com.digitalfactory.irrigationsystem.models.device.IrrigationRequest;
import com.digitalfactory.irrigationsystem.models.device.IrrigationResponse;
import com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus;
import com.digitalfactory.irrigationsystem.models.plotland.PlotLandConfiguration;
import com.digitalfactory.irrigationsystem.repositories.PlotLandRepository;
import com.digitalfactory.irrigationsystem.services.PlotLandService;
import com.digitalfactory.irrigationsystem.services.device.SensorDeviceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PlotLandServiceImpl implements PlotLandService {
    private static final String PLOTLAND_NOT_FOUND_MESSAGE = "Plot of land not found with the id: {0}";
    private static final String PLOTLAND_ALREADY_EXIST_MESSAGE = "Plot of land with name: {0} already exists";

    final PlotLandMapper plotLandMapper;
    final PlotLandRepository plotLandRepository;
    final SensorDeviceService sensorDeviceService;

    @Override
    public PlotLand createPlotLand(PlotLand plotLand) {

        /* Checking if resource already exists */
        if (plotLandRepository.existsByPlotLandName(plotLand.getPlotLandName())) {
            throw new ResourceAlreadyExistException(MessageFormat.format(PLOTLAND_ALREADY_EXIST_MESSAGE, plotLand.getPlotLandName()));
        }
        /* Initializing plotland*/
        PlotLandConfiguration plotLandConfiguration = plotLand.getPlotLandConfiguration();
        plotLandConfiguration.setStatus(IrrigationStatus.NOT_IRRIGATED);
        plotLandConfiguration.setNextIrrigationDate(DateUtils.addHours(new Date(), plotLandConfiguration.getIrrigationTimeSlot()));
        plotLand.setPlotLandConfiguration(plotLandConfiguration);


        /* Getting entity and save plotland*/
        PlotLandEntity plotLandEntity = plotLandMapper.asPlotLandEntity(plotLand);

        /* Setting plotland entity reference*/
        plotLandEntity.getPlotLandConfiguration().setPlotLand(plotLandEntity);

        return plotLandMapper.asPlotLand(plotLandRepository.save(plotLandEntity));
    }

    @Override
    public PlotLand readPlotLandByPlotLandId(Long plotLandId) {
       PlotLandEntity plotLandEntity = plotLandRepository.findById(plotLandId)
                .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format(PLOTLAND_NOT_FOUND_MESSAGE, plotLandId)));
        return plotLandMapper.asPlotLand(plotLandEntity);
    }

    @Override
    public Page<PlotLand> readPlotLandsByFilters(List<IrrigationStatus> exceptedIrrigationStatuses, Date fromNextIrrigationDate, Pageable pageable) {
        return plotLandRepository.findAllByFilters(exceptedIrrigationStatuses,fromNextIrrigationDate, pageable).map(plotLandMapper::asPlotLand);
    }

    @Override
    public PlotLand updatePlotLand(PlotLand plotLand) {
        /* Getting plotLandId */
        Long plotLandId = plotLand.getPlotLandId();

        /* Checking plotLand exists */
        if (!plotLandRepository.existsById(plotLandId)) {
            throw new ResourceNotFoundException(MessageFormat.format(PLOTLAND_NOT_FOUND_MESSAGE, plotLandId));
        }

        /* Retrieve plotland configuration to update using given id*/
        PlotLandConfiguration plotLandConfigurationToUpdate = readPlotLandByPlotLandId(plotLandId).getPlotLandConfiguration();

        /* Retrieve new plotland configuration */
        PlotLandConfiguration newPlotLandConfiguration = plotLand.getPlotLandConfiguration();

        /* Update next irrigation date if necessary*/
        if (plotLandConfigurationToUpdate.getIrrigationTimeSlot() != newPlotLandConfiguration.getIrrigationTimeSlot()){
            int hoursDifference = newPlotLandConfiguration.getIrrigationTimeSlot() - plotLandConfigurationToUpdate.getIrrigationTimeSlot();
            newPlotLandConfiguration.setNextIrrigationDate(DateUtils.addHours(plotLandConfigurationToUpdate.getNextIrrigationDate(),hoursDifference));
        }
        /* Getting related Entity */
        plotLand.setPlotLandConfiguration(newPlotLandConfiguration);
        PlotLandEntity plotlandEntity = plotLandMapper.asPlotLandEntity(plotLand);

        /* Saving entity */
        return plotLandMapper.asPlotLand(plotLandRepository.save(plotlandEntity));
    }


    @Override
    @Retryable(value = {SensorDeviceUnavailableException.class }, maxAttemptsExpression = "${retry.maxAttempts}", backoff = @Backoff(maxDelayExpression = "${retry.maxDelay}"))
    public PlotLand irrigatePlotLand(Long plotLandId, boolean available) {
        /* Getting plotLandConfiguration informations */
        PlotLand plotLand = readPlotLandByPlotLandId(plotLandId);
        PlotLandConfiguration plotLandConfiguration = plotLand.getPlotLandConfiguration();

        /* Create irrigation request */
        IrrigationRequest irrigationRequest = new IrrigationRequest();
        irrigationRequest.setPlotLandId(plotLand.getPlotLandId());
        irrigationRequest.setWaterAmount(plotLandConfiguration.getWaterAmount());

        /* Call sensor device to irrigate */
        IrrigationResponse irrigationResponse = sensorDeviceService.irrigate(irrigationRequest,available);

        /* Update plotLandConfiguration informations */
        plotLandConfiguration.setStatus(irrigationResponse.getStatus());
        Date nextIrrigationDate = DateUtils.addHours(plotLandConfiguration.getNextIrrigationDate(), plotLand.getPlotLandConfiguration().getIrrigationTimeSlot());
        plotLandConfiguration.setNextIrrigationDate(nextIrrigationDate);
        plotLand.setPlotLandConfiguration(plotLandConfiguration);

        /* Getting related Entity */
        PlotLandEntity plotlandEntity = plotLandMapper.asPlotLandEntity(plotLand);

        /* Saving entity */
        return plotLandMapper.asPlotLand(plotLandRepository.save(plotlandEntity));
    }

    @Override
    @Recover
    public PlotLand recover(SensorDeviceUnavailableException e, Long plotLandId, boolean available){
        PlotLand plotLand = readPlotLandByPlotLandId(plotLandId);
        PlotLandConfiguration plotLandConfiguration = plotLand.getPlotLandConfiguration();
        plotLandConfiguration.setStatus(IrrigationStatus.NOT_IRRIGATED);

        PlotLandEntity plotLandEntity = plotLandMapper.asPlotLandEntity(plotLand);

        return plotLandMapper.asPlotLand(plotLandRepository.save(plotLandEntity));
    }


}
