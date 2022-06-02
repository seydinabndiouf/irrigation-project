package com.digitalfactory.irrigationsystem.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlotLandEntity is a Querydsl query type for PlotLandEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlotLandEntity extends EntityPathBase<PlotLandEntity> {

    private static final long serialVersionUID = 1492666682L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlotLandEntity plotLandEntity = new QPlotLandEntity("plotLandEntity");

    public final com.digitalfactory.irrigationsystem.entities.plotland.QAgriculturalCropEntity agriculturalCrop;

    public final NumberPath<Double> plotLandArea = createNumber("plotLandArea", Double.class);

    public final com.digitalfactory.irrigationsystem.entities.plotland.QPlotLandConfigurationEntity plotLandConfiguration;

    public final NumberPath<Long> plotLandId = createNumber("plotLandId", Long.class);

    public final StringPath plotLandName = createString("plotLandName");

    public QPlotLandEntity(String variable) {
        this(PlotLandEntity.class, forVariable(variable), INITS);
    }

    public QPlotLandEntity(Path<? extends PlotLandEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlotLandEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlotLandEntity(PathMetadata metadata, PathInits inits) {
        this(PlotLandEntity.class, metadata, inits);
    }

    public QPlotLandEntity(Class<? extends PlotLandEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.agriculturalCrop = inits.isInitialized("agriculturalCrop") ? new com.digitalfactory.irrigationsystem.entities.plotland.QAgriculturalCropEntity(forProperty("agriculturalCrop")) : null;
        this.plotLandConfiguration = inits.isInitialized("plotLandConfiguration") ? new com.digitalfactory.irrigationsystem.entities.plotland.QPlotLandConfigurationEntity(forProperty("plotLandConfiguration"), inits.get("plotLandConfiguration")) : null;
    }

}

