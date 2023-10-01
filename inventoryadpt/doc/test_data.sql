INSERT INTO renter(id, full_name, id_document, origin, licence_id) VALUES (1, 'User 1', '1234567890', 'Bogota', '1111111111');
INSERT INTO freeze(id, freeze_date, freeze_time_minutes) VALUES (1, '2023-09-28 08:57:00', 5);
INSERT INTO rental(id, rental_time, rental_period_days,Renter_id) VALUES (1, '2023-09-28 09:00:00', 1, 1);
INSERT INTO model(id, `type`, brand, `year`, model) VALUES (1, 'SEDAN', 'KIA', 2021, 'Rio'); 
INSERT INTO vehicleproduct(id, sku, price, model_id) VALUES (1, "VH001", 130, 1);
INSERT INTO vehicleitem(id, plate, origin, vehicleproduct_id, freeze_id, rental_id) VALUES (1, "AAA111", "Bogota", 1, 1, 1);