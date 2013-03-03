CREATE TABLE `User_Login` (  `user_name` VARCHAR(50) NOT NULL,  `password` VARCHAR(50) NOT NULL,  `role` VARCHAR(50) NOT NULL,  `user_id` VARCHAR(50) NOT NULL ) COMMENT='Contains the credentials of user' COLLATE='latin1_swedish_ci' ENGINE=InnoDB ROW_FORMAT=DEFAULT AUTO_INCREMENT=4;

CREATE TABLE `addressbook`.`user_info`( `first_name` VARCHAR(50) NOT NULL, `middle_name` VARCHAR(50), `last_name` VARCHAR(50), `primary_contact_number` BIGINT(15), `secondary_contact_number` BIGINT(15), `contact_number` BIGINT(15), `email_id` VARCHAR(50) NOT NULL, `designation` VARCHAR(50), `gender` CHAR(1), `address_id` INT ); 

CREATE TABLE `address` (  `address_id` int(10) NOT NULL AUTO_INCREMENT,  `address_line1` varchar(50) DEFAULT NULL,  `address_line2` varchar(50) DEFAULT NULL,  `city` varchar(50) DEFAULT NULL,  `street` varchar(50) DEFAULT NULL,  `phone` varchar(50) DEFAULT NULL,  `fax` varchar(50) DEFAULT NULL,  `state` varchar(50) DEFAULT NULL,  `zip` int(10) DEFAULT NULL,  PRIMARY KEY (`address_id`) ) ;

ALTER TABLE `user_info`  ADD CONSTRAINT `address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE `addressbook`.`user_info` ADD COLUMN `pic` BLOB(5000) NULL AFTER `address_id`; 

alter table `addressbook`.`user_info` add column `contact_list_id` varchar (100)   NULL  after `pic`

CREATE TABLE `company_info` (  `company_id` INT(10) NOT NULL,  `company_name` VARCHAR(150) NOT NULL,  `address_id` INT(10) NOT NULL,  `establishment_year` VARCHAR(50) NOT NULL ) COMMENT='Contains the details of organization' COLLATE='latin1_swedish_ci' ENGINE=InnoDB ROW_FORMAT=DEFAULT AUTO_INCREMENT=1;

