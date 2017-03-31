DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`(
	`patientId` int NOT NULL,
	`patientName` varchar(55) NOT NULL,
	`species` varchar(55) NOT NULL,
	`race` varchar(55) NOT NULL,
	`size` char(1) NOT NULL,
	`gender` char(1) NOT NULL,
	`birthDate` DATE NOT NULL,
	`furCharacteristics` varchar(55) NOT NULL,
	`weight` float NOT NULL,	
	PRIMARY KEY(`patientId`)
);
	
