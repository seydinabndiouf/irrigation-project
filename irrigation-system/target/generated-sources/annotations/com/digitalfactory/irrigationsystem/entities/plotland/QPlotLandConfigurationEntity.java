package com.digitalfactory.irrigationsystem.entities.plotland;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlotLandConfigurationEntity is a Querydsl query type for PlotLandConfigurationEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlotLandConfigurationEntity extends EntityPathBase<PlotLandConfigurationEntity> {

    private static final long serialVersionUID = -1014244586L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlotLandConfigurationEntity plotLandConfigurationEntity = new QPlotLandConfigurationEntity("plotLandConfigurationEntity");

    public final NumberPath<Integer> irrigationTimeSlot = createNumber("irrigationTimeSlot", Integer.class);

    public final DateTimePath<java.util.Date> nextIrrigationDate = createDateTime("nextIrrigationDate", java.util.Date.class);

    public final com.digitalfactory.irrigationsystem.entities.QPlotLandEntity plotLand;

    public final NumberPath<Long> plotLandId = createNumber("plotLandId", Long.class);

    public final EnumPath<com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus> status = createEnum("status", com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus.class);

    public final NumberPath<Double> waterAmount = createNumber("waterAmount", Double.class);

    public QPlotLandConfigurationEntity(String variable) {
        this(PlotLandConfigurationEntity.class, forVariable(variable), INITS);
    }

    public QPlotLandConfigurationEntity(Path<? extends PlotLandConfigurationEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlotLandConfigurationEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlotLandConfigurationEntity(PathMetadata metadata, PathInits inits) {
        this(PlotLandConfigurationEntity.class, metadata, inits);
    }

    public QPlotLandConfigurationEntity(Class<? extends PlotLandConfigurationEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.plotLand = inits.isInitialized("plotLand") ? new com.digitalfactory.irrigationsystem.entities.QPlotLandEntity(forProperty("plotLand"), inits.get("plotLand")) : null;
    }

}

