package com.digitalfactory.irrigationsystem.mappers;

import com.digitalfactory.irrigationsystem.entities.PlotLandEntity;
import com.digitalfactory.irrigationsystem.mappers.plotland.AgriculturalCropMapper;
import com.digitalfactory.irrigationsystem.mappers.plotland.PlotLandConfigurationMapper;
import com.digitalfactory.irrigationsystem.models.PlotLand;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {PlotLandConfigurationMapper.class, AgriculturalCropMapper.class})
public interface PlotLandMapper {

    PlotLand asPlotLand(PlotLandEntity plotLandEntity);

    @InheritInverseConfiguration
    PlotLandEntity asPlotLandEntity(PlotLand plotLand);

    List<PlotLand> asPlotLands(List<PlotLandEntity> plotLandEntities);

    List<PlotLandEntity> asPlotLandEntities(List<PlotLand> plotLands);

}
