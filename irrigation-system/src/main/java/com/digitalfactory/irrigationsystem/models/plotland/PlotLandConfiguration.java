package com.digitalfactory.irrigationsystem.models.plotland;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlotLandConfiguration {
    private Long plotLandId;

    @NotNull
    Double waterAmount;

    @NotNull
    int irrigationTimeSlot;

    Date nextIrrigationDate;

    IrrigationStatus status;

}
