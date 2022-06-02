package com.digitalfactory.irrigationsystem.repositories.plotland;

import com.digitalfactory.irrigationsystem.entities.plotland.AgriculturalCropEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface AgriculturalCropRepository extends CrudRepository<AgriculturalCropEntity, Long> {

    Page<AgriculturalCropEntity> findAll(Pageable pageable);
}
