DROP PROCEDURE IF EXISTS rentalupdate;

DELIMITER $$

CREATE PROCEDURE `rentalupdate` ()
BEGIN
	UPDATE `rental` SET `status` = 'OVERDUE' WHERE DATE_ADD(`rental_time`, INTERVAL `rental_period_days` DAY) < NOW();
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS freezedeletion;

DELIMITER $$

CREATE PROCEDURE `freezedeletion` ()
BEGIN
	SET @to_delete = (SELECT `id` FROM `freeze` WHERE DATE_ADD(`freeze_date`, INTERVAL `freeze_time_minutes` MINUTE) < NOW());
    UPDATE `vehicleitem` SET `freeze_id` = NULL WHERE freeze_id IN (@to_delete);
    DELETE FROM `freeze` WHERE `id` IN (@to_delete); 
END $$
DELIMITER ;

DROP EVENT IF EXISTS `rental_update`;
CREATE EVENT `rental_update`
ON SCHEDULE EVERY 12 HOUR
DO
CALL rentalupdate();

DROP EVENT IF EXISTS `freeze_cleanup`;
CREATE EVENT `freeze_cleanup`
ON SCHEDULE EVERY 1 MINUTE
DO
CALL freezedeletion();