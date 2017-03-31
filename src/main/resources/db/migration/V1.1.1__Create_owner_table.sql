DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner`(
	`cpf` int(10) NOT NULL,
	`ownerName` varchar(50) NOT NULL,
	`ownerLastName` varchar(50) NOT NULL,
	`phoneNumber` int(20) NOT NULL,
 	`address` varchar(200) NOT NULL,
 	PRIMARY KEY(`cpf`)
);