package com.digitalfactory.irrigationsystem.schedulers;

import com.digitalfactory.irrigationsystem.models.PlotLand;
import com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus;
import com.digitalfactory.irrigationsystem.services.PlotLandService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class IrrigationSystemScheduler {

    final PlotLandService plotLandService;

    @Scheduled(cron = "${scheduler.cronExpression}")
    public void irrigatePlotLand(){
        log.info("irrigatePlotLand scheduler started");
        /* Initializing hasResult boolean */
        boolean hasResult = true;

         /* While initialized plotlands exist */
        while (hasResult) {

            /* Getting outdated initialized plotlands */
            List<IrrigationStatus> exceptedIrrigationStatuses = new ArrayList<>();
            exceptedIrrigationStatuses.add(IrrigationStatus.NOT_IRRIGATED);
            exceptedIrrigationStatuses.add(IrrigationStatus.TO_BE_IRRIGATED);

            Page<PlotLand> plotLands = plotLandService.readPlotLandsByFilters(exceptedIrrigationStatuses,new Date(), Pageable.unpaged());

            /* Iterate over plotlands */
            for (PlotLand plotLand : plotLands) {

                /* irrigate of plot of land */
                plotLandService.irrigatePlotLand(plotLand.getPlotLandId(), true);

            }

            /* Setting hasResult boolean */
            hasResult = plotLands.hasNext();

        }

    }
}
