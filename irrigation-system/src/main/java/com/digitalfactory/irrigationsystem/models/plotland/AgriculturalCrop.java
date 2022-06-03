package com.digitalfactory.irrigationsystem.models.plotland;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AgriculturalCrop {

    private Long agriculturalCropId;

    @NotEmpty
    String name;

    @NotNull
    Double waterAmount;
}
