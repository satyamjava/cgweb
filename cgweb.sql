/*
SQLyog - Free MySQL GUI v5.17
Host - 5.5.13 : Database - addressbook
*********************************************************************
Server version : 5.5.13
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `addressbook`;

USE `addressbook`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` int(10) NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(50) DEFAULT NULL,
  `address_line2` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `zip` int(10) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert into `address` (`address_id`,`address_line1`,`address_line2`,`city`,`street`,`phone`,`fax`,`state`,`zip`) values (1,'123 Tower B','Cyber City','Gurgaon','12','12466666','1245555','Haryana',23001),(2,'A-5 Sec 10','Dwarka','New Delhi','11','01123242',NULL,'Delhi',110077);

/*Table structure for table `company_info` */

DROP TABLE IF EXISTS `company_info`;

CREATE TABLE `company_info` (
  `company_id` varchar(100) NOT NULL,
  `company_name` varchar(150) NOT NULL,
  `establishment_year` varchar(50) NOT NULL,
  `COMPANY_SEQ` int(255) NOT NULL AUTO_INCREMENT,
  `COMPANY_DESCRIPTION` varchar(255) DEFAULT NULL,
  `CONTACT_NUMBER` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `WEBSITE` varchar(255) DEFAULT NULL,
  `address_ADDRESS_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`COMPANY_SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contains the details of organization';

/*Data for the table `company_info` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `primary_contact_number` bigint(15) DEFAULT NULL,
  `secondary_contact_number` bigint(15) DEFAULT NULL,
  `contact_number` bigint(15) DEFAULT NULL,
  `email_id` varchar(50) NOT NULL,
  `designation` varchar(50) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `pic` blob,
  `contact_list_id` varchar(100) DEFAULT NULL,
  `USER_ID` int(255) NOT NULL AUTO_INCREMENT,
  `SECONDRY_CONTACT_NUMBER` bigint(20) DEFAULT NULL,
  `address_ADDRESS_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user_info` */

insert into `user_info` (`first_name`,`middle_name`,`last_name`,`primary_contact_number`,`secondary_contact_number`,`contact_number`,`email_id`,`designation`,`gender`,`address_id`,`pic`,`contact_list_id`,`USER_ID`,`SECONDRY_CONTACT_NUMBER`,`address_ADDRESS_ID`) values ('sa','si','sp',123,456,675,'s@gmail.com','dev','m',2,NULL,'2',1,NULL,NULL),('ad','ny','ms',333,222,555,'a@gmail.com','ceo','m',NULL,NULL,'1',2,NULL,NULL);

/*Table structure for table `user_login` */

DROP TABLE IF EXISTS `user_login`;

CREATE TABLE `user_login` (
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `user_seq` int(10) NOT NULL AUTO_INCREMENT,
  `PASSWORD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='Contains the credentials of user';

/*Data for the table `user_login` */

insert into `user_login` (`user_name`,`user_password`,`role`,`user_id`,`user_seq`,`PASSWORD`) values ('s','XYZ','user','s@gmail.com',1,NULL),('a','a','admin','a@gmail.com',2,NULL);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
