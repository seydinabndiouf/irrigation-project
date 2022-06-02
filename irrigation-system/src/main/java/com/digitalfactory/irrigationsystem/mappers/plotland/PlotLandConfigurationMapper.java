package com.digitalfactory.irrigationsystem.mappers.plotland;
import com.digitalfactory.irrigationsystem.entities.plotland.PlotLandConfigurationEntity;
import com.digitalfactory.irrigationsystem.models.plotland.PlotLandConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PlotLandConfigurationMapper {

    PlotLandConfiguration asPlotLandConfiguration(PlotLandConfigurationEntity plotLandConfigurationEntity);

    @InheritInverseConfiguration
    PlotLandConfigurationEntity asPlotLandConfigurationEntity(PlotLandConfiguration plotLandConfiguration);

    List<PlotLandConfiguration> asPlotLandConfigurations(List<PlotLandConfigurationEntity> plotLandConfigurationEntities);

    List<PlotLandConfigurationEntity> asPlotLandConfigurationEntities(List<PlotLandConfiguration> plotLandConfigurations);
}
