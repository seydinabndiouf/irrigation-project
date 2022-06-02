package com.digitalfactory.irrigationsystem.mappers.plotland;

import com.digitalfactory.irrigationsystem.entities.plotland.AgriculturalCropEntity;
import com.digitalfactory.irrigationsystem.models.plotland.AgriculturalCrop;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AgriculturalCropMapper {

    AgriculturalCrop asAgriculturalCrop(AgriculturalCropEntity agriculturalCropEntity);

    @InheritInverseConfiguration
    AgriculturalCropEntity asAgriculturalCropEntity(AgriculturalCrop agriculturalCrop);

    List<AgriculturalCrop> asAgriculturalCrops(List<AgriculturalCropEntity> agriculturalCropEntities);

    List<AgriculturalCropEntity> asAgriculturalCropEntities(List<AgriculturalCrop> agriculturalCrops);
}
