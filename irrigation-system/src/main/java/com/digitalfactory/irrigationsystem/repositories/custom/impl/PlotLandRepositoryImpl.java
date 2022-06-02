package com.digitalfactory.irrigationsystem.repositories.custom.impl;

import com.digitalfactory.irrigationsystem.entities.PlotLandEntity;
import com.digitalfactory.irrigationsystem.entities.QPlotLandEntity;
import com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus;
import com.digitalfactory.irrigationsystem.repositories.PlotLandRepository;
import com.digitalfactory.irrigationsystem.repositories.custom.PlotLandRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import lombok.NonNull;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public class PlotLandRepositoryImpl implements PlotLandRepositoryCustom {

    @Autowired
    @Lazy
    private PlotLandRepository plotlandRepository;

    @Override
    public Page<PlotLandEntity> findAllByFilters(
            List<IrrigationStatus> exceptedIrrigationStatuses,
            Date fromNextIrrigationDate,
            @NonNull Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        if (fromNextIrrigationDate != null ) {
           builder.and(QPlotLandEntity.plotLandEntity.plotLandConfiguration.nextIrrigationDate.eq(fromNextIrrigationDate)
                   .or(QPlotLandEntity.plotLandEntity.plotLandConfiguration.nextIrrigationDate.before(fromNextIrrigationDate)));
        }

        if (CollectionUtils.isNotEmpty(exceptedIrrigationStatuses)){
            builder.and(QPlotLandEntity.plotLandEntity.plotLandConfiguration.status.in(exceptedIrrigationStatuses));
        }

        return plotlandRepository.findAll(builder, pageable);
    }

}
