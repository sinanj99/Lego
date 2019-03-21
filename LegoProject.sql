  
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `LegoDB`.`user` (
  `user_id` INT(50) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL UNIQUE,
  `password` VARCHAR(45) NOT NULL,
  `balance` INT NOT NULL,
  `isAdmin` INT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`));


CREATE TABLE `LegoDB`.`order` (
  `order_id` INT(50) NOT NULL AUTO_INCREMENT,
  `user_id` INT(50) NOT NULL,
  `height` INT(16) NOT NULL,
  `width` INT(45) NOT NULL,
  `length` INT(45) NOT NULL,
  `shipped` DATETIME,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`));

ALTER TABLE `LegoDB`.`order` 
DROP FOREIGN KEY `order_ibfk_1`;
ALTER TABLE `LegoDB`.`order` 
ADD CONSTRAINT `order_ibfk_1`
  FOREIGN KEY (`user_id`)
  REFERENCES `LegoDB`.`user` (`user_id`)
  ON UPDATE CASCADE;
  
  insert into user values(1, 'sne', 'prespa01', 0, 1);
  