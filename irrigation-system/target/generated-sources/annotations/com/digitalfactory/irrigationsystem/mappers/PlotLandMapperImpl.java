package com.digitalfactory.irrigationsystem.mappers;

import com.digitalfactory.irrigationsystem.entities.PlotLandEntity;
import com.digitalfactory.irrigationsystem.mappers.plotland.AgriculturalCropMapper;
import com.digitalfactory.irrigationsystem.mappers.plotland.PlotLandConfigurationMapper;
import com.digitalfactory.irrigationsystem.models.PlotLand;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-02T23:07:05+0000",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class PlotLandMapperImpl implements PlotLandMapper {

    @Autowired
    private PlotLandConfigurationMapper plotLandConfigurationMapper;
    @Autowired
    private AgriculturalCropMapper agriculturalCropMapper;

    @Override
    public PlotLand asPlotLand(PlotLandEntity plotLandEntity) {
        if ( plotLandEntity == null ) {
            return null;
        }

        PlotLand plotLand = new PlotLand();

        plotLand.setPlotLandId( plotLandEntity.getPlotLandId() );
        plotLand.setPlotLandName( plotLandEntity.getPlotLandName() );
        plotLand.setPlotLandArea( plotLandEntity.getPlotLandArea() );
        plotLand.setPlotLandConfiguration( plotLandConfigurationMapper.asPlotLandConfiguration( plotLandEntity.getPlotLandConfiguration() ) );
        plotLand.setAgriculturalCrop( agriculturalCropMapper.asAgriculturalCrop( plotLandEntity.getAgriculturalCrop() ) );

        return plotLand;
    }

    @Override
    public PlotLandEntity asPlotLandEntity(PlotLand plotLand) {
        if ( plotLand == null ) {
            return null;
        }

        PlotLandEntity plotLandEntity = new PlotLandEntity();

        plotLandEntity.setPlotLandId( plotLand.getPlotLandId() );
        plotLandEntity.setPlotLandName( plotLand.getPlotLandName() );
        plotLandEntity.setPlotLandArea( plotLand.getPlotLandArea() );
        plotLandEntity.setPlotLandConfiguration( plotLandConfigurationMapper.asPlotLandConfigurationEntity( plotLand.getPlotLandConfiguration() ) );
        plotLandEntity.setAgriculturalCrop( agriculturalCropMapper.asAgriculturalCropEntity( plotLand.getAgriculturalCrop() ) );

        return plotLandEntity;
    }

    @Override
    public List<PlotLand> asPlotLands(List<PlotLandEntity> plotLandEntities) {
        if ( plotLandEntities == null ) {
            return null;
        }

        List<PlotLand> list = new ArrayList<PlotLand>( plotLandEntities.size() );
        for ( PlotLandEntity plotLandEntity : plotLandEntities ) {
            list.add( asPlotLand( plotLandEntity ) );
        }

        return list;
    }

    @Override
    public List<PlotLandEntity> asPlotLandEntities(List<PlotLand> plotLands) {
        if ( plotLands == null ) {
            return null;
        }

        List<PlotLandEntity> list = new ArrayList<PlotLandEntity>( plotLands.size() );
        for ( PlotLand plotLand : plotLands ) {
            list.add( asPlotLandEntity( plotLand ) );
        }

        return list;
    }
}
