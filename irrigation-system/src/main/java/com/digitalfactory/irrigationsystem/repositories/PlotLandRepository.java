package com.digitalfactory.irrigationsystem.repositories;

import com.digitalfactory.irrigationsystem.entities.PlotLandEntity;
import com.digitalfactory.irrigationsystem.repositories.custom.PlotLandRepositoryCustom;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotLandRepository extends CrudRepository<PlotLandEntity, Long>, PlotLandRepositoryCustom, QuerydslPredicateExecutor<PlotLandEntity> {
    boolean existsByPlotLandName(String name)    ;
}
