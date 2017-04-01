DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`(
	`id_patient` int NOT NULL,
	`name_patient` varchar(50) NOT NULL,
	`specie` char(1) NOT NULL,
	`breed` varchar(20) NOT NULL,
	`size` char(1) NOT NULL,
	`gender` char(1) NOT NULL,
	`birthday` DATE NOT NULL,
	`coat` varchar(10) NOT NULL,
	`weight` float NOT NULL,	
	PRIMARY KEY(`id_patient`)
);
	
