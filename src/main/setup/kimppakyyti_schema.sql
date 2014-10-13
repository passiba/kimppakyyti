

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema autoreitti
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `autoreitti` ;

-- -----------------------------------------------------
-- Schema autoreitti
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `autoreitti` DEFAULT CHARACTER SET utf8 ;
USE `autoreitti` ;

-- -----------------------------------------------------
-- Table `autoreitti`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `autoreitti`.`users` ;

CREATE TABLE IF NOT EXISTS `autoreitti`.`users` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `Phonenumber` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `Phonenumber` ON `autoreitti`.`users` (`Phonenumber` ASC);


-- -----------------------------------------------------
-- Table `autoreitti`.`drivers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `autoreitti`.`drivers` ;

CREATE TABLE IF NOT EXISTS `autoreitti`.`drivers` (
  `driver_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) NOT NULL,
  `firstName` VARCHAR(60) NOT NULL,
  `lastName` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`driver_id`),
  CONSTRAINT `fk_driver_userid`
    FOREIGN KEY (`user_id`)
    REFERENCES `autoreitti`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_driver_userid` ON `autoreitti`.`drivers` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `autoreitti`.`travelldestination`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `autoreitti`.`travelldestination` ;

CREATE TABLE IF NOT EXISTS `autoreitti`.`travelldestination` (
  `traveldestination_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `travelling_from` VARCHAR(60) NULL DEFAULT NULL,
  `travelling_to` VARCHAR(60) NULL DEFAULT NULL,
  `traveltime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`traveldestination_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `autoreitti`.`drivers_destination`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `autoreitti`.`drivers_destination` ;

CREATE TABLE IF NOT EXISTS `autoreitti`.`drivers_destination` (
  `drivers_destination_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `driver_id` BIGINT(20) NOT NULL,
  `traveldestination_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`drivers_destination_id`),
  CONSTRAINT `fk_drivers_destination1`
    FOREIGN KEY (`traveldestination_id`)
    REFERENCES `autoreitti`.`travelldestination` (`traveldestination_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_drivers_id1`
    FOREIGN KEY (`driver_id`)
    REFERENCES `autoreitti`.`drivers` (`driver_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_drivers_id1` ON `autoreitti`.`drivers_destination` (`driver_id` ASC);

CREATE INDEX `fk_drivers_destination1` ON `autoreitti`.`drivers_destination` (`traveldestination_id` ASC);


-- -----------------------------------------------------
-- Table `autoreitti`.`travellers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `autoreitti`.`travellers` ;

CREATE TABLE IF NOT EXISTS `autoreitti`.`travellers` (
  `traveller_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(50) NOT NULL,
  `LastName` VARCHAR(60) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`traveller_id`),
  CONSTRAINT `fk_traveller_userid`
    FOREIGN KEY (`user_id`)
    REFERENCES `autoreitti`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_traveller_userid` ON `autoreitti`.`travellers` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `autoreitti`.`traveller_destination`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `autoreitti`.`traveller_destination` ;

CREATE TABLE IF NOT EXISTS `autoreitti`.`traveller_destination` (
  `traveller_destination_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `traveller_id` BIGINT(20) NOT NULL,
  `traveldestination_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`traveller_destination_id`),
  CONSTRAINT `fk_traveller_destination1`
    FOREIGN KEY (`traveldestination_id`)
    REFERENCES `autoreitti`.`travelldestination` (`traveldestination_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_traveller_id1`
    FOREIGN KEY (`traveller_id`)
    REFERENCES `autoreitti`.`travellers` (`traveller_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_traveller_id1` ON `autoreitti`.`traveller_destination` (`traveller_id` ASC);

CREATE INDEX `fk_traveller_destination1` ON `autoreitti`.`traveller_destination` (`traveldestination_id` ASC);


-- -----------------------------------------------------
-- Table `autoreitti`.`travellagreement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `autoreitti`.`travellagreement` ;

CREATE TABLE IF NOT EXISTS `autoreitti`.`travellagreement` (
  `travellagreement_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `traveller_destination_id` BIGINT(20) NULL DEFAULT NULL,
  `drivers_destination_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`travellagreement_id`),
  CONSTRAINT `fk_travellagreement_1`
    FOREIGN KEY (`drivers_destination_id`)
    REFERENCES `autoreitti`.`drivers_destination` (`drivers_destination_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_travellagreement_2`
    FOREIGN KEY (`traveller_destination_id`)
    REFERENCES `autoreitti`.`traveller_destination` (`traveller_destination_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `traveller_destination_id` ON `autoreitti`.`travellagreement` (`traveller_destination_id` ASC);

CREATE UNIQUE INDEX `drivers_destination_id` ON `autoreitti`.`travellagreement` (`drivers_destination_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
