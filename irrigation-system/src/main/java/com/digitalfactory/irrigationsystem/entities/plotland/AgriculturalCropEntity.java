package com.digitalfactory.irrigationsystem.entities.plotland;


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
@Table(name = "agricultural_crop")
public class AgriculturalCropEntity {
    @Id
    @Column(name = "agricultural_crop_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agriculturalCropId;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "water_amount_per_square_meter")
    Double waterAmountPerSquareMeter;
}
