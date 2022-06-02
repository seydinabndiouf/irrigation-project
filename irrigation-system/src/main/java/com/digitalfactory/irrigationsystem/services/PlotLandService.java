package com.digitalfactory.irrigationsystem.services;

import com.digitalfactory.irrigationsystem.exceptions.SensorDeviceUnavailableException;
import com.digitalfactory.irrigationsystem.models.PlotLand;
import com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PlotLandService {
    PlotLand createPlotLand(PlotLand plotLand);

    PlotLand readPlotLandByPlotLandId(Long plotLandId);

    Page<PlotLand> readPlotLandsByFilters(List<IrrigationStatus> exceptedIrrigationStatuses, Date fromNextIrrigationDate, Pageable pageable);

    PlotLand updatePlotLand(PlotLand plotLand);

    PlotLand irrigatePlotLand(Long plotLandId, boolean available);

    PlotLand recover(SensorDeviceUnavailableException e, Long plotLandId, boolean available);
}
