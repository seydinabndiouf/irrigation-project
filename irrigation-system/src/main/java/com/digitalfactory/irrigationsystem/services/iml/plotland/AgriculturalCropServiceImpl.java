package com.digitalfactory.irrigationsystem.services.iml.plotland;

import com.digitalfactory.irrigationsystem.entities.PlotLandEntity;
import com.digitalfactory.irrigationsystem.entities.plotland.AgriculturalCropEntity;
import com.digitalfactory.irrigationsystem.exceptions.ResourceNotFoundException;
import com.digitalfactory.irrigationsystem.mappers.plotland.AgriculturalCropMapper;
import com.digitalfactory.irrigationsystem.models.plotland.AgriculturalCrop;
import com.digitalfactory.irrigationsystem.repositories.plotland.AgriculturalCropRepository;
import com.digitalfactory.irrigationsystem.services.plotland.AgriculturalCropService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AgriculturalCropServiceImpl implements AgriculturalCropService {

    private static final String AGRICULTURAL_CROP_NOT_FOUND_MESSAGE = " Agricultural crop not found with the id: {0}";


    final AgriculturalCropRepository agriculturalCropRepository;

    final AgriculturalCropMapper agriculturalCropMapper;

    @Override
    public List<AgriculturalCrop> readAllAgriculturalCrop() {
        return agriculturalCropRepository.findAll(Pageable.unpaged())
                .map(agriculturalCropMapper::asAgriculturalCrop)
                .getContent();
    }

    @Override
    public AgriculturalCrop readAgriculturalCropById(Long agriculturalCropId) {
        AgriculturalCropEntity agriculturalCropEntity = agriculturalCropRepository.findById(agriculturalCropId)
                .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format(AGRICULTURAL_CROP_NOT_FOUND_MESSAGE, agriculturalCropId)));
        return agriculturalCropMapper.asAgriculturalCrop(agriculturalCropEntity);
    }
}
