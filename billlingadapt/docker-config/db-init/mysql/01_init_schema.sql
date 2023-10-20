-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema galaxybilling
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `galaxybilling` DEFAULT CHARACTER SET utf8 ;
USE `galaxybilling` ;

-- -----------------------------------------------------
-- Table `galaxybilling`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `galaxybilling`.`bill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(150) NOT NULL,
  `rental_start_date` DATETIME NOT NULL,
  `rental_end_date` DATETIME NOT NULL,
  `return_date` DATETIME NOT NULL,
  `concept` VARCHAR(250) NULL,
  `item_code` VARCHAR(150) NOT NULL,
  `base_price` FLOAT NOT NULL,
  `total_price` FLOAT NOT NULL,
  `units` INT NOT NULL DEFAULT 1,
  `overdue_charges` INT NOT NULL DEFAULT 0,
  `purchaser_full_name` VARCHAR(200) NOT NULL,
  `purchaser_dni` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE)
ENGINE = InnoDB;