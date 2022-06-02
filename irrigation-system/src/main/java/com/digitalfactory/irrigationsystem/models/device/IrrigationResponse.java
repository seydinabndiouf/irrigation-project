package com.digitalfactory.irrigationsystem.models.device;

import com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IrrigationResponse {
    Long plotLandId;

    IrrigationStatus status;
}
