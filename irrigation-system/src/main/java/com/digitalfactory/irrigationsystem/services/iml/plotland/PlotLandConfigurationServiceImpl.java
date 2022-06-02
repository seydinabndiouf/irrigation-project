package com.digitalfactory.irrigationsystem.services.iml.plotland;

import com.digitalfactory.irrigationsystem.mappers.plotland.PlotLandConfigurationMapper;
import com.digitalfactory.irrigationsystem.models.plotland.PlotLandConfiguration;
import com.digitalfactory.irrigationsystem.repositories.plotland.PlotLandConfigurationRepository;
import com.digitalfactory.irrigationsystem.services.plotland.PlotLandConfigurationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PlotLandConfigurationServiceImpl implements PlotLandConfigurationService {
    final PlotLandConfigurationMapper plotLandConfigurationMapper;
    final PlotLandConfigurationRepository plotLandConfigurationRepository;

    @Override
    public PlotLandConfiguration addPlotLandConfiguration(PlotLandConfiguration plotLandConfiguration) {
        return null;
    }

    @Override
    public PlotLandConfiguration updatePlotLandConfiguration(PlotLandConfiguration plotLandConfiguration) {
        return null;
    }
}
