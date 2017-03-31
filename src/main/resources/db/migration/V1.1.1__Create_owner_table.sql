DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner`(
	`cpf` bigint(11) NOT NULL,
	`ownerName` varchar(50) NOT NULL,
	`ownerLastName` varchar(50) NOT NULL,
	`phoneNumber` bigint(20) NOT NULL,
 	`address` varchar(200) NOT NULL,
 	PRIMARY KEY(`cpf`)
);