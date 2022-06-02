package com.digitalfactory.irrigationsystem.repositories.custom;

import com.digitalfactory.irrigationsystem.entities.PlotLandEntity;
import com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PlotLandRepositoryCustom {

    Page<PlotLandEntity> findAllByFilters(@Param("exceptedIrrigationStatuses") List<IrrigationStatus> exceptedIrrigationStatuses, @Param("fromNextIrrigationDate") Date fromNextIrrigationDate, Pageable pageable);

}
