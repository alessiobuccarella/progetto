CREATE USER 'app-user'@'localhost' IDENTIFIED BY 'password' ;
CREATE DATABASE IF NOT EXISTS `jUno` ;
GRANT ALL ON `jUno`.* TO 'app-user'@'localhost' ;
FLUSH PRIVILEGES ;

USE `jUno`;

DROP TABLE IF EXISTS `Profilo`;
CREATE TABLE `Profilo` (
	`idProfilo` INT AUTO_INCREMENT NOT NULL,
	`nickname` VARCHAR(45) NOT NULL,
	`avatar` VARCHAR(45) NOT NULL,
	`livello` INT DEFAULT 0,
	`partite_giocate` INT DEFAULT 0,
	`partite_vinte` INT DEFAULT 0,
	`partite_perse` INT DEFAULT 0,
	UNIQUE (`nickname`),
	PRIMARY KEY (`idProfilo`,`nickname`)
);