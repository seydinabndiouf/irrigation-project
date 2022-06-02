package com.digitalfactory.irrigationsystem.mappers.plotland;

import com.digitalfactory.irrigationsystem.entities.plotland.PlotLandConfigurationEntity;
import com.digitalfactory.irrigationsystem.models.plotland.PlotLandConfiguration;
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
public class PlotLandConfigurationMapperImpl implements PlotLandConfigurationMapper {

    @Override
    public PlotLandConfiguration asPlotLandConfiguration(PlotLandConfigurationEntity plotLandConfigurationEntity) {
        if ( plotLandConfigurationEntity == null ) {
            return null;
        }

        PlotLandConfiguration plotLandConfiguration = new PlotLandConfiguration();

        plotLandConfiguration.setPlotLandId( plotLandConfigurationEntity.getPlotLandId() );
        plotLandConfiguration.setWaterAmount( plotLandConfigurationEntity.getWaterAmount() );
        plotLandConfiguration.setIrrigationTimeSlot( plotLandConfigurationEntity.getIrrigationTimeSlot() );
        plotLandConfiguration.setNextIrrigationDate( plotLandConfigurationEntity.getNextIrrigationDate() );
        plotLandConfiguration.setStatus( plotLandConfigurationEntity.getStatus() );

        return plotLandConfiguration;
    }

    @Override
    public PlotLandConfigurationEntity asPlotLandConfigurationEntity(PlotLandConfiguration plotLandConfiguration) {
        if ( plotLandConfiguration == null ) {
            return null;
        }

        PlotLandConfigurationEntity plotLandConfigurationEntity = new PlotLandConfigurationEntity();

        plotLandConfigurationEntity.setPlotLandId( plotLandConfiguration.getPlotLandId() );
        plotLandConfigurationEntity.setWaterAmount( plotLandConfiguration.getWaterAmount() );
        plotLandConfigurationEntity.setIrrigationTimeSlot( plotLandConfiguration.getIrrigationTimeSlot() );
        plotLandConfigurationEntity.setNextIrrigationDate( plotLandConfiguration.getNextIrrigationDate() );
        plotLandConfigurationEntity.setStatus( plotLandConfiguration.getStatus() );

        return plotLandConfigurationEntity;
    }

    @Override
    public List<PlotLandConfiguration> asPlotLandConfigurations(List<PlotLandConfigurationEntity> plotLandConfigurationEntities) {
        if ( plotLandConfigurationEntities == null ) {
            return null;
        }

        List<PlotLandConfiguration> list = new ArrayList<PlotLandConfiguration>( plotLandConfigurationEntities.size() );
        for ( PlotLandConfigurationEntity plotLandConfigurationEntity : plotLandConfigurationEntities ) {
            list.add( asPlotLandConfiguration( plotLandConfigurationEntity ) );
        }

        return list;
    }

    @Override
    public List<PlotLandConfigurationEntity> asPlotLandConfigurationEntities(List<PlotLandConfiguration> plotLandConfigurations) {
        if ( plotLandConfigurations == null ) {
            return null;
        }

        List<PlotLandConfigurationEntity> list = new ArrayList<PlotLandConfigurationEntity>( plotLandConfigurations.size() );
        for ( PlotLandConfiguration plotLandConfiguration : plotLandConfigurations ) {
            list.add( asPlotLandConfigurationEntity( plotLandConfiguration ) );
        }

        return list;
    }
}
