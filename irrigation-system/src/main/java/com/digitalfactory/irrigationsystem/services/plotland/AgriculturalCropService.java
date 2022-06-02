package com.digitalfactory.irrigationsystem.services.plotland;

import com.digitalfactory.irrigationsystem.models.plotland.AgriculturalCrop;

import java.util.List;

public interface AgriculturalCropService {

    List<AgriculturalCrop> readAllAgriculturalCrop();

    AgriculturalCrop readAgriculturalCropById(Long agriculturalCrop);

}
