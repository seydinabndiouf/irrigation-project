package com.digitalfactory.irrigationsystem.models;
import com.digitalfactory.irrigationsystem.models.plotland.AgriculturalCrop;
import com.digitalfactory.irrigationsystem.models.plotland.PlotLandConfiguration;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlotLand {

    Long plotLandId;

    @NotEmpty
    String plotLandName;

    @NotEmpty
    Double plotLandArea;

    @Valid
    PlotLandConfiguration plotLandConfiguration;

    @Valid
    AgriculturalCrop agriculturalCrop;
}
