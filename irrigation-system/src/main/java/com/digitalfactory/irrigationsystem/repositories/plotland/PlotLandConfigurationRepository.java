package com.digitalfactory.irrigationsystem.repositories.plotland;

import com.digitalfactory.irrigationsystem.entities.plotland.PlotLandConfigurationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotLandConfigurationRepository extends CrudRepository<PlotLandConfigurationEntity, Long> {
}
