package com.digitalfactory.irrigationsystem.entities.plotland;

import com.digitalfactory.irrigationsystem.entities.PlotLandEntity;
import com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "plot_land_configuration")
public class PlotLandConfigurationEntity {
    @Id
    private Long plotLandId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plot_land_id")
    @MapsId
    @ToString.Exclude
    PlotLandEntity plotLand;


    @Column(name = "water_amount", nullable = false)
    Double waterAmount;

    @Column(name = "irrigation_time_slot", nullable = false)
    int irrigationTimeSlot;

    @Column(name = "next_irrigation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date nextIrrigationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "irrigation_status", nullable = false)
    IrrigationStatus status;

}
