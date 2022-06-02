package com.digitalfactory.irrigationsystem.entities;

import com.digitalfactory.irrigationsystem.entities.plotland.AgriculturalCropEntity;
import com.digitalfactory.irrigationsystem.entities.plotland.PlotLandConfigurationEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "plot_land")

public class PlotLandEntity {

    @Id
    @Column(name = "plot_land_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plotLandId;

    @Column(name = "name", nullable = false)
    private String plotLandName;

    @Column(name = "area", nullable = false)
    private Double plotLandArea;

    @OneToOne(mappedBy = "plotLand", cascade = CascadeType.ALL, orphanRemoval=true)
    private PlotLandConfigurationEntity plotLandConfiguration;


    @ManyToOne
    @JoinColumn(name = "agricultural_crop_id")
    AgriculturalCropEntity agriculturalCrop;
}
