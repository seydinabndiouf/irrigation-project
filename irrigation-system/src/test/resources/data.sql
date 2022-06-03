INSERT INTO agricultural_crop (agricultural_crop_id, name, water_amount_per_square_meter) VALUES
(11, 'Melon', 2.0),
(12, 'Banana', 5.0);

INSERT INTO plot_land (plot_land_id, name, area, agricultural_crop_id) VALUES
(11, 'CairLand', 2000.0, 11),
(12, 'Myland', 2000.0, 12);


INSERT INTO plot_land_configuration (plot_land_id, water_amount, irrigation_time_slot, next_irrigation_date,irrigation_status) VALUES
(11, 2000.0, 24, '2022-06-01T23:00:00', 'TO_BE_IRRIGATED'),
(12, 3000.0, 48, '2022-06-01T23:00:00', 'TO_BE_IRRIGATED');
