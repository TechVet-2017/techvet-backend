DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner`(
	`id_owner` bigint(10) NOT NULL AUTO_INCREMENT,
	`cpf` bigint(11) NOT NULL,
	`owner_name` varchar(50) NOT NULL,
	`owner_last_name` varchar(50) NOT NULL,
	`phone_number` bigint(20) NOT NULL,
 	`zip_code` bigint(8) NULL,
 	`district` varchar(50) NOT NULL,
 	`public_place` varchar(50) NOT NULL,
 	`address_number` bigint(10) NOT NULL,
 	PRIMARY KEY(`id_owner`)
);