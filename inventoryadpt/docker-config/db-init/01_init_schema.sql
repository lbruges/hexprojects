-- MySQL Workbench Forward Engineering
-- -----------------------------------------------------
-- Schema galaxyrental
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `galaxyrental` DEFAULT CHARACTER SET utf8 ;
SET GLOBAL time_zone = '-5:00';
USE `galaxyrental` ;

-- -----------------------------------------------------
-- Table `galaxyrental`.`model`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `galaxyrental`.`model` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(150) NOT NULL,
  `type` VARCHAR(100) NOT NULL,
  `brand` VARCHAR(150) NOT NULL,
  `year` INT NOT NULL,
  `model` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `type_brand_year` (`brand` ASC, `model` ASC, `type` ASC, `year` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
  INDEX `code_INDEX` (`code` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `galaxyrental`.`vehicleproduct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `galaxyrental`.`vehicleproduct` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(400) NOT NULL,
  `price` FLOAT NOT NULL DEFAULT 0.0,
  `model_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `sku_UNIQUE` (`sku` ASC) VISIBLE,
  INDEX `fk_vehicleproduct_model1_idx` (`model_id` ASC) VISIBLE,
  INDEX `sku_SEARCH` (`sku` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_vehicleproduct_model1`
    FOREIGN KEY (`model_id`)
    REFERENCES `galaxyrental`.`model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `galaxyrental`.`freeze`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `galaxyrental`.`freeze` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `freeze_date` DATETIME NOT NULL DEFAULT NOW(),
  `freeze_time_minutes` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'ACTIVE',
  `freeze_code` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `freeze_code_UNIQUE` (`freeze_code` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `galaxyrental`.`renter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `galaxyrental`.`renter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(200) NOT NULL,
  `id_document` VARCHAR(200) NOT NULL,
  `origin` VARCHAR(150) NOT NULL,
  `licence_id` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_origin` (`id_document` ASC, `origin` ASC) INVISIBLE,
  INDEX `id_origin_licence_SEARCH` (`id_document` ASC, `licence_id` ASC, `origin` ASC) INVISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `id_origin_licence_UNIQUE` (`id_document` ASC, `licence_id` ASC, `origin` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `galaxyrental`.`rental`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `galaxyrental`.`rental` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rental_start_date` DATETIME NOT NULL DEFAULT NOW(),
  `rental_end_date` DATETIME NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'ACTIVE',
  `renter_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rental_renter1_idx` (`renter_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_rental_renter1`
    FOREIGN KEY (`renter_id`)
    REFERENCES `galaxyrental`.`renter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `galaxyrental`.`vehicleitem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `galaxyrental`.`vehicleitem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `plate` VARCHAR(150) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'AVAILABLE',
  `vehicleproduct_id` INT NOT NULL,
  `freeze_id` INT NULL,
  `rental_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vehicleitem_vehicleproduct1_idx` (`vehicleproduct_id` ASC) VISIBLE,
  INDEX `plate_SEARCH` (`plate` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_vehicleitem_freeze1_idx` (`freeze_id` ASC) VISIBLE,
  INDEX `fk_vehicleitem_rental1_idx` (`rental_id` ASC) VISIBLE,
  UNIQUE INDEX `plate_UNIQUE` (`plate` ASC) VISIBLE,
  CONSTRAINT `fk_vehicleitem_vehicleproduct1`
    FOREIGN KEY (`vehicleproduct_id`)
    REFERENCES `galaxyrental`.`vehicleproduct` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicleitem_freeze1`
    FOREIGN KEY (`freeze_id`)
    REFERENCES `galaxyrental`.`freeze` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicleitem_rental1`
    FOREIGN KEY (`rental_id`)
    REFERENCES `galaxyrental`.`rental` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Clean-up Stored Procedures
-- -----------------------------------------------------

DROP PROCEDURE IF EXISTS `galaxyrental`.`rentalupdate`;

DELIMITER $$
CREATE PROCEDURE `galaxyrental`.`rentalupdate` ()
BEGIN
	UPDATE `galaxyrental`.`rental` SET `status` = 'OVERDUE' WHERE NOW() > rental_end_date;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `galaxyrental`.`freezedeletion`;

DELIMITER $$
CREATE PROCEDURE `galaxyrental`.`freezedeletion` ()
BEGIN
	SET @to_delete = (SELECT `id` FROM `galaxyrental`.`freeze` WHERE NOW() > DATE_ADD(`freeze_date`, INTERVAL `freeze_time_minutes` MINUTE));
    UPDATE `galaxyrental`.`vehicleitem` SET `freeze_id` = NULL WHERE freeze_id IN (@to_delete);
    DELETE FROM `galaxyrental`.`freeze` WHERE `id` IN (@to_delete);
END $$
DELIMITER ;
-- -----------------------------------------------------
-- Clean-up Events
-- -----------------------------------------------------

DROP EVENT IF EXISTS `galaxyrental`.`rental_update`;
CREATE EVENT `galaxyrental`.`rental_update`
ON SCHEDULE EVERY 12 HOUR
DO
CALL rentalupdate();

DROP EVENT IF EXISTS `galaxyrental`.`freeze_cleanup`;
CREATE EVENT `galaxyrental`.`freeze_cleanup`
ON SCHEDULE EVERY 1 MINUTE
DO
CALL freezedeletion();