/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `profile` (
	`profile_id` int (11),
	`active` char (9),
	`added_date` datetime ,
	`modified_date` datetime ,
	`name` varchar (405),
	`added_by` int (11),
	`modified_by` int (11),
	`description` varchar (2295),
	`profile_code` varchar (405)
); 
insert into `profile` (`profile_id`, `active`, `added_date`, `modified_date`, `name`, `added_by`, `modified_by`, `description`, `profile_code`) values('1','Y','2015-08-23 17:27:48',NULL,'Super User','10',NULL,'Super User Profile','SU');
insert into `profile` (`profile_id`, `active`, `added_date`, `modified_date`, `name`, `added_by`, `modified_by`, `description`, `profile_code`) values('2','Y','2015-08-23 17:28:09',NULL,'Project Manager','10',NULL,'Project Manager Profile','PM');
insert into `profile` (`profile_id`, `active`, `added_date`, `modified_date`, `name`, `added_by`, `modified_by`, `description`, `profile_code`) values('3','Y','2015-08-23 17:28:27',NULL,'Regular User','10',NULL,'Regular User','RU');
