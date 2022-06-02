package com.digitalfactory.irrigationsystem.entities.plotland;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAgriculturalCropEntity is a Querydsl query type for AgriculturalCropEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAgriculturalCropEntity extends EntityPathBase<AgriculturalCropEntity> {

    private static final long serialVersionUID = -1592812151L;

    public static final QAgriculturalCropEntity agriculturalCropEntity = new QAgriculturalCropEntity("agriculturalCropEntity");

    public final NumberPath<Long> agriculturalCropId = createNumber("agriculturalCropId", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Double> waterAmountPerSquareMeter = createNumber("waterAmountPerSquareMeter", Double.class);

    public QAgriculturalCropEntity(String variable) {
        super(AgriculturalCropEntity.class, forVariable(variable));
    }

    public QAgriculturalCropEntity(Path<? extends AgriculturalCropEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAgriculturalCropEntity(PathMetadata metadata) {
        super(AgriculturalCropEntity.class, metadata);
    }

}

