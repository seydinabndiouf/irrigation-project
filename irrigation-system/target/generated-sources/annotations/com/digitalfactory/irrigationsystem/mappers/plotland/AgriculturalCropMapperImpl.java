package com.digitalfactory.irrigationsystem.mappers.plotland;

import com.digitalfactory.irrigationsystem.entities.plotland.AgriculturalCropEntity;
import com.digitalfactory.irrigationsystem.models.plotland.AgriculturalCrop;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-02T23:07:05+0000",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class AgriculturalCropMapperImpl implements AgriculturalCropMapper {

    @Override
    public AgriculturalCrop asAgriculturalCrop(AgriculturalCropEntity agriculturalCropEntity) {
        if ( agriculturalCropEntity == null ) {
            return null;
        }

        AgriculturalCrop agriculturalCrop = new AgriculturalCrop();

        agriculturalCrop.setAgriculturalCropId( agriculturalCropEntity.getAgriculturalCropId() );
        agriculturalCrop.setName( agriculturalCropEntity.getName() );

        return agriculturalCrop;
    }

    @Override
    public AgriculturalCropEntity asAgriculturalCropEntity(AgriculturalCrop agriculturalCrop) {
        if ( agriculturalCrop == null ) {
            return null;
        }

        AgriculturalCropEntity agriculturalCropEntity = new AgriculturalCropEntity();

        agriculturalCropEntity.setAgriculturalCropId( agriculturalCrop.getAgriculturalCropId() );
        agriculturalCropEntity.setName( agriculturalCrop.getName() );

        return agriculturalCropEntity;
    }

    @Override
    public List<AgriculturalCrop> asAgriculturalCrops(List<AgriculturalCropEntity> agriculturalCropEntities) {
        if ( agriculturalCropEntities == null ) {
            return null;
        }

        List<AgriculturalCrop> list = new ArrayList<AgriculturalCrop>( agriculturalCropEntities.size() );
        for ( AgriculturalCropEntity agriculturalCropEntity : agriculturalCropEntities ) {
            list.add( asAgriculturalCrop( agriculturalCropEntity ) );
        }

        return list;
    }

    @Override
    public List<AgriculturalCropEntity> asAgriculturalCropEntities(List<AgriculturalCrop> agriculturalCrops) {
        if ( agriculturalCrops == null ) {
            return null;
        }

        List<AgriculturalCropEntity> list = new ArrayList<AgriculturalCropEntity>( agriculturalCrops.size() );
        for ( AgriculturalCrop agriculturalCrop : agriculturalCrops ) {
            list.add( asAgriculturalCropEntity( agriculturalCrop ) );
        }

        return list;
    }
}
