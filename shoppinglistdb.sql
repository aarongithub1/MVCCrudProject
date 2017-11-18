-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema shoppinglistdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `shoppinglistdb` ;

-- -----------------------------------------------------
-- Schema shoppinglistdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shoppinglistdb` DEFAULT CHARACTER SET utf8 ;
USE `shoppinglistdb` ;

-- -----------------------------------------------------
-- Table `item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item` ;

CREATE TABLE IF NOT EXISTS `item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `list_item` VARCHAR(100) NOT NULL,
  `number_of_items` INT NOT NULL DEFAULT 0,
  `item_price` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO shopper@localhost;
 DROP USER shopper@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'shopper'@'localhost' IDENTIFIED BY 'shopper';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'shopper'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `item`
-- -----------------------------------------------------
START TRANSACTION;
USE `shoppinglistdb`;
INSERT INTO `item` (`id`, `list_item`, `number_of_items`, `item_price`) VALUES (1, 'Eggs', 1, 1.50);
INSERT INTO `item` (`id`, `list_item`, `number_of_items`, `item_price`) VALUES (2, 'Spinach', 2, 2.50);
INSERT INTO `item` (`id`, `list_item`, `number_of_items`, `item_price`) VALUES (3, 'Milk', 3, 3.50);
INSERT INTO `item` (`id`, `list_item`, `number_of_items`, `item_price`) VALUES (4, 'Hash browns', 4, 4.50);
INSERT INTO `item` (`id`, `list_item`, `number_of_items`, `item_price`) VALUES (5, 'Bacon', 5, 5.50);

COMMIT;
