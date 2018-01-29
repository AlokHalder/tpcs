/*
SQLyog - Free MySQL GUI v5.17
Host - 5.5.27 : Database - tpcsglob_db
*********************************************************************
Server version : 5.5.27
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `tpcsglob_db`;

USE `tpcsglob_db`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `assign_job_details` */

DROP TABLE IF EXISTS `assign_job_details`;

CREATE TABLE `assign_job_details` (
  `assign_job_id` int(10) NOT NULL,
  `assign_to_emp_id` int(10) NOT NULL,
  `assign_job_status` char(1) DEFAULT NULL,
  `assign_job_urgency` char(1) DEFAULT NULL,
  `assign_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `assign_job_details` */

insert into `assign_job_details` (`assign_job_id`,`assign_to_emp_id`,`assign_job_status`,`assign_job_urgency`,`assign_date`) values (1,109,'P','L','2013-06-21');

/*Table structure for table `associates_contact_number` */

DROP TABLE IF EXISTS `associates_contact_number`;

CREATE TABLE `associates_contact_number` (
  `associate_contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `asssociate_name` varchar(200) DEFAULT NULL,
  `associate_category` varchar(100) DEFAULT NULL,
  `associate_contact_number` varchar(200) DEFAULT NULL,
  `associate_nick_name` varchar(200) DEFAULT NULL,
  `associate_email_id` varchar(200) DEFAULT NULL,
  `associate_alternate_number` varchar(200) DEFAULT NULL,
  `associate_alternate_email_id` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`associate_contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

/*Data for the table `associates_contact_number` */

insert into `associates_contact_number` (`associate_contact_id`,`asssociate_name`,`associate_category`,`associate_contact_number`,`associate_nick_name`,`associate_email_id`,`associate_alternate_number`,`associate_alternate_email_id`) values (20,'Alok Halder','Mentor','9830376126','Alok','alokhalder@gmail.com','',''),(21,'Satya  Dey','Accounts','9330045566','Satyada','satyadey.09@gmail.com','',''),(22,'Senapati ','Electrician','9831145027','Senapati','Senapati@gmail.com','',''),(23,'Airtel Customer Care','Broadband','03344444121','Airtel','','',''),(24,'Mangal  Bhandari','Electrician','8768871504','Mangal','','',''),(25,'Samsudin','Printing','9883321816','Samsuddin','','',''),(26,'Sankha  Nandi','Airtel Broadband Issues','9903451454','Sankha','','',''),(27,'Om Enterprise','Printing','8981770204','Bapan','om11enterprise@gmail.com','9433555984',''),(28,'Shamita Mukherjee','HDFC Banking','9051424400','Shamita','','',''),(29,'Sudip Saha','Computer Hardware','8296798453','Sudip','','7890011347',''),(30,'Suvendu acharyya','','9477753346','suve','','',''),(31,'Suvendu acharyya','','9477753346','suve','','',''),(32,'Suvendu acharyya','','9477753346','suve','','',''),(33,'Partha Gaswami','','8017506898','','','',''),(34,'AK Masud','','9007612624','Masud','','',''),(35,'pankaj Ghosh','','9474375681','Pankaj','','',''),(36,'Rajasree Chakraborty','','9903457110','Rajasree',NULL,'',''),(37,'Pritam Mukharjee','','8017281235','Pritam','','',''),(38,'Jeet Chatterjee','','9748108991','Jeet','','',''),(39,'Aniruddha Bhattacharjee','J2EE ','7679942949','Anik','me.ani03@hotmail.com','',''),(40,'Sumit Prakash Dubey','J2EE','8906615173','Sumit','sumitprakashdubey@gmail.com','',''),(41,'Upendra Sarma','','8482053363','Upendra','upendrasharma14@gmail.com','9038966777',''),(42,'Upendra Sarma','','8482053363','Upendra','upendrasharma14@gmail.com','9038966777',''),(43,'Asim Biswas','','8926733693','Asim','asimbiswas1989@gmail.com','',''),(44,'Priyanka','Sulekha.Com  website listing','9051305104','Priyanka','','',''),(45,'Subhojit(Airtel)','Airtel','990351153','subhojit','subhojit@gmail.com','990351153','NA'),(46,'Roni','Interior Design','9830613282','do','roni@gmail.com','9830613282','NA'),(47,'Sanando Banerjee','J2EE','9477214931','Sanando','sanando.personal@gmail.com',NULL,NULL),(49,'Uttam Das','J2EE','8906685908','Uttam','uttamdas07@yahoo.co.in','',''),(50,'','','','','','','');

/*Table structure for table `country_details` */

DROP TABLE IF EXISTS `country_details`;

CREATE TABLE `country_details` (
  `country_code` varchar(3) NOT NULL,
  `county_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`country_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `country_details` */

insert into `country_details` (`country_code`,`county_name`) values ('10','Antarctica'),('100','Hong Kong'),('101','Hungary'),('102','Canary Islands'),('103','Islamic Conference'),('104','Indonesia'),('105','India'),('106','Ireland'),('107','Iran'),('108','Iraq'),('109','Iceland'),('11','Argentina'),('110','Italy'),('111','Kazakhstan'),('112','Kenya'),('113','Kyrgyzstan'),('114','Kiribati'),('115','Korea'),('116','Kuwait'),('117','Laos'),('118','Latvia'),('119','Liberia'),('12','Arab League'),('120','Libya'),('121','Lebanon'),('122','Liechtenstein'),('123','Jamaica'),('124','Japan'),('125','Channel Islands'),('126','Jordan'),('127','Lithuania'),('128','Lesotho'),('129','Luxembourg'),('13','Armenia'),('130','Macau'),('131','Madagascar'),('132','Isle of Man'),('133','Morocco'),('134','Monaco'),('135','Madeira'),('136','Mexico'),('137','Marshall Islands'),('138','Micronesia'),('139','Macedonia'),('14','Aruba'),('140','Maldives'),('141','Mali'),('142','Malaysia'),('143','Malta'),('144','Burma (Myanmar)'),('145','Mongolia'),('146','Moldova'),('147','Mozambique'),('148','Mauritius'),('149','Mariana Islands'),('15','Asean'),('150','Mauritania'),('151','Montserrat'),('152','Montenegro'),('153','Martinique'),('154','Malawi'),('155','Mayotte'),('156','Namibia'),('157','New Caledonia'),('158','Northern Cyprus'),('159','Netherlands'),('16','Antigua & Barbuda'),('160','Nepal'),('161','Norfolk'),('162','Niger'),('163','Nicaragua'),('164','Nigeria'),('165','Northern Ireland'),('166','Niue'),('167','North Korea'),('168','Norway'),('169','Nauru'),('17','Netherlands Antilles'),('170','Norway-Flag'),('171','New Zealand'),('172','Oman'),('173','Pakistan'),('174','Panama'),('175','Paraguay'),('176','Peru'),('177','French Polynesia'),('178','Philippines'),('179','Pitcairn'),('18','Australia'),('180','Palestine'),('181','Palau'),('182','Papua New Guinea'),('183','Poland'),('184','Puerto Rico'),('185','Portugal'),('186','Qatar'),('187','Reunion'),('188','Romania'),('189','Russia'),('19','Austria'),('190','Rwanda'),('191','American Samoa'),('192','South Africa'),('193','Samoa (Western)'),('194','Saudi Arabia'),('195','Sudan'),('196','Senegal'),('197','Seychelles'),('198','Singapore'),('199','Saint Helena'),('2','Afganistan '),('20','Azerbaijan'),('200','St Kitts and Nevis'),('201','South Korea'),('202','Sierra Leone'),('203','Solomon'),('204','Slovakia'),('205','Saint Lucia'),('206','Salvador'),('207','San Marino'),('208','Somalia'),('209','St Pierre & Miquelon'),('21','Azores'),('210','Serbia'),('211','Sri Lanka'),('212','Sao Tome & Principe'),('213','Switzerland'),('214','Suriname'),('215','Slovenia'),('216','Swaziland'),('217','Sweden'),('218','Syria'),('219','Taiwan'),('22','Bahamas'),('220','Turks & Caicos Isl. '),('221','Chad'),('222','Czech Rep. '),('223','Thailand'),('224','East Timor'),('225','Tajikistan'),('226','Turkmenistan'),('227','Togo'),('228','Tokelau'),('229','Tonga'),('23','Burundi'),('230','Trinidad & Tobago'),('231','Tunisia'),('232','Turkey'),('233','Tuvalu'),('234','Tanzania'),('235','United Arab Emirates'),('236','USA / Hawaii'),('237','United Kingdom'),('238','Uganda'),('239','Ukraine'),('24','Belgium'),('240','USA / Alaska'),('241','Uruguay'),('242','USA'),('243','Uzbekistan'),('244','Vanuatu'),('245','Vatican'),('246','St Vincent & Grenad.'),('247','Venezuela'),('248','Virgin Island US'),('249','Virgin Island GB'),('25','Benin'),('250','Viet Nam'),('251','Wallis & Futuna'),('252','Yemen'),('253','Yugoslavia'),('254','Congo Dem. Rep'),('255','Zambia'),('256','Zimbabwe'),('26','Bermuda'),('27','Burkina Faso'),('28','Bahrain'),('29','Bhutan'),('3','African Union'),('30','Belarus'),('31','Belize'),('32','Bangladesh'),('33','Bolivia'),('34','Bosnia & Herzegovina'),('35','Botswana'),('36','Brazil'),('37','Barbados'),('38','Brunei'),('39','Bulgaria'),('4','Anguilla'),('40','Central African Rep.'),('41','Cameroon'),('42','Canada'),('43','Caricom'),('44','Cape Verde'),('45','Cambodia'),('46','Chile'),('47','China'),('48','Christmas Island'),('49','Cis'),('5','Angola'),('50','Ivory Coast'),('51','Congo'),('52','Cook Islands'),('53','Colombia'),('54','Comoros'),('55','Costa Rica'),('56','Croatia'),('57','Cuba'),('58','Commonwealth of Nati'),('59','Cayman Islands'),('6','Alaska'),('60','Cyprus'),('61','Djibouti'),('62','Dominica'),('63','Denmark'),('64','Dominican Rep. '),('65','Ecuador'),('66','Egypt'),('67','England'),('68','European Union'),('69','Eritrea'),('7','Albania'),('70','El Salvador'),('71','Spain'),('72','Estonia'),('73','Ethiopia'),('74','Fiji'),('75','Finland'),('76','Falkland Islands'),('77','France'),('78','Faroe Islands'),('79','Gabon'),('8','Algeria'),('80','Gambia'),('81','Great Britain'),('82','Guadeloupe'),('83','Georgia'),('84','Germany'),('85','Ghana'),('86','French Guiana'),('87','Gibraltar'),('88','Guinea-Bissau'),('89','Equatorial Guinea'),('9','Andorra'),('90','Grenada'),('91','Greece'),('92','Greenland'),('93','Guatemala'),('94','Guinea'),('95','Guam'),('96','Guyana'),('97','Haiti'),('98','Hawaii'),('99','Honduras');

/*Table structure for table `daily_status_report` */

DROP TABLE IF EXISTS `daily_status_report`;

CREATE TABLE `daily_status_report` (
  `daily_status_report_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `status_report_description` varchar(3000) DEFAULT NULL,
  `status_report_date` date DEFAULT NULL,
  `billable_hours` varchar(45) DEFAULT NULL,
  `non_billable_hours` varchar(45) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`daily_status_report_id`),
  KEY `FK_USER_ID` (`user_id`),
  CONSTRAINT `FK_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `daily_status_report` */

/*Table structure for table `emp_attendance_register` */

DROP TABLE IF EXISTS `emp_attendance_register`;

CREATE TABLE `emp_attendance_register` (
  `emp_id` int(10) NOT NULL,
  `emp_office_entry_time` time DEFAULT NULL,
  `emp_office_leave_time` time DEFAULT NULL,
  `current_date_value` date NOT NULL,
  `office_hours_spent` time DEFAULT NULL,
  PRIMARY KEY (`emp_id`,`current_date_value`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `emp_attendance_register` */

/*Table structure for table `emp_leave_register` */

DROP TABLE IF EXISTS `emp_leave_register`;

CREATE TABLE `emp_leave_register` (
  `emp_id` int(10) NOT NULL,
  `emp_leave_type` varchar(200) DEFAULT NULL,
  `emp_leave_start_date` date DEFAULT NULL,
  `emp_leave_end_date` date DEFAULT NULL,
  `emp_leave_duration` varchar(100) DEFAULT NULL,
  `emp_leave_days_count` double(10,1) DEFAULT NULL,
  `emp_leave_reason` varchar(2000) DEFAULT NULL,
  `emp_leave_apply_date` date DEFAULT NULL,
  `emp_leave_approval_status` varchar(100) NOT NULL DEFAULT 'Pending'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `emp_leave_register` */

/*Table structure for table `employee_account_details` */

DROP TABLE IF EXISTS `employee_account_details`;

CREATE TABLE `employee_account_details` (
  `employee_id` int(10) NOT NULL,
  `pan_number` varchar(20) DEFAULT NULL,
  `primary_bank_accout_no` varchar(50) DEFAULT NULL,
  `secondary_bank_account_no` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  CONSTRAINT `employee_account_details_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `user_profile` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `employee_account_details` */

insert into `employee_account_details` (`employee_id`,`pan_number`,`primary_bank_accout_no`,`secondary_bank_account_no`) values (128,'','1256325412',''),(132,'','1256325412',''),(162,'','1111111111',''),(164,'','123456789',''),(178,'145212245855','12365478963214','1112122'),(186,'','31235645654123','');

/*Table structure for table `employee_education_details` */

DROP TABLE IF EXISTS `employee_education_details`;

CREATE TABLE `employee_education_details` (
  `employee_id` int(10) DEFAULT NULL,
  `ug_qualification` int(10) DEFAULT NULL,
  `ug_specialization` int(10) DEFAULT NULL,
  `ug_year_of_passout` varchar(4) DEFAULT NULL,
  `ug_university` int(10) DEFAULT NULL,
  `pg_qualification` int(10) DEFAULT NULL,
  `pg_specialization` int(10) DEFAULT NULL,
  `pg_year_of_passout` varchar(4) DEFAULT NULL,
  `pg_university` int(10) DEFAULT NULL,
  KEY `FK_employee_education_details` (`employee_id`),
  KEY `FK_employee_education_details1` (`ug_qualification`),
  KEY `FK_employee_education_details3` (`ug_specialization`),
  KEY `FK_employee_education_details4` (`ug_university`),
  KEY `FK_employee_education_details5` (`pg_qualification`),
  KEY `FK_employee_education_details6` (`pg_specialization`),
  KEY `FK_employee_education_details7` (`pg_university`),
  CONSTRAINT `employee_education_details_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `user_profile` (`user_id`),
  CONSTRAINT `employee_education_details_ibfk_2` FOREIGN KEY (`ug_qualification`) REFERENCES `ug_qualification` (`ug_qualification_id`),
  CONSTRAINT `employee_education_details_ibfk_3` FOREIGN KEY (`ug_specialization`) REFERENCES `ug_specialozation` (`ug_specialization_id`),
  CONSTRAINT `employee_education_details_ibfk_4` FOREIGN KEY (`ug_university`) REFERENCES `ug_university` (`ug_university_id`),
  CONSTRAINT `employee_education_details_ibfk_5` FOREIGN KEY (`pg_qualification`) REFERENCES `pg_qualification` (`pg_qualification_id`),
  CONSTRAINT `employee_education_details_ibfk_6` FOREIGN KEY (`pg_specialization`) REFERENCES `pg_specialization` (`pg_specialization_id`),
  CONSTRAINT `employee_education_details_ibfk_7` FOREIGN KEY (`pg_university`) REFERENCES `pg_university` (`pg_university_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `employee_education_details` */

insert into `employee_education_details` (`employee_id`,`ug_qualification`,`ug_specialization`,`ug_year_of_passout`,`ug_university`,`pg_qualification`,`pg_specialization`,`pg_year_of_passout`,`pg_university`) values (178,1,11,'2012',3,2,17,'2012',17),(186,1,1,'2012',6,1,1,'',1),(187,2,1,'2012',16,1,1,'',1),(188,3,15,'2010',9,5,9,'2011',9),(188,3,15,'2010',9,5,9,'2011',9),(189,3,15,'2010',9,5,9,'2011',9),(128,1,1,'2011',5,1,1,'',1),(132,1,2,'2012',2,1,1,'',1),(162,1,2,'2012',6,1,1,'',1),(164,1,1,'2012',6,1,1,'',1);

/*Table structure for table `employee_office_details` */

DROP TABLE IF EXISTS `employee_office_details`;

CREATE TABLE `employee_office_details` (
  `employee_id` int(10) NOT NULL,
  `date_of_joining` date DEFAULT NULL,
  `employee_status` int(1) DEFAULT NULL,
  `grade_id` int(10) DEFAULT NULL,
  `employee_type` varchar(20) DEFAULT NULL,
  `deputed_location_id` int(10) DEFAULT NULL,
  `base_branch_id` int(10) DEFAULT NULL,
  `supervisor_id` int(10) DEFAULT NULL,
  `parent_iou_id` int(10) DEFAULT NULL,
  `sub_iou_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FK_employee_office_details_2` (`parent_iou_id`),
  CONSTRAINT `employee_office_details_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `user_profile` (`user_id`),
  CONSTRAINT `FK_employee_office_details_2` FOREIGN KEY (`parent_iou_id`) REFERENCES `tpcs_parent_iou` (`parent_iou_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `employee_office_details` */

insert into `employee_office_details` (`employee_id`,`date_of_joining`,`employee_status`,`grade_id`,`employee_type`,`deputed_location_id`,`base_branch_id`,`supervisor_id`,`parent_iou_id`,`sub_iou_id`) values (128,'2012-08-02',1,1,'Trainee',1,1,1,1,1),(132,'2013-05-08',1,1,'Permanent',1,1,1,1,1),(162,'2012-08-02',1,1,'Permanent',1,1,110,4,109),(164,'2012-08-27',1,1,'Permanent',1,1,1,1,1),(178,'2012-08-02',1,1,'Permanent',1,1,107,5,103),(186,'2012-08-27',1,4,'Permanent',1,1,2,5,108),(187,'2012-08-11',1,1,'Permanent',1,1,106,1,110),(188,'2009-08-09',1,1,'Trainee',1,1,111,4,5),(189,'2009-08-09',1,1,'Trainee',1,1,111,4,5);

/*Table structure for table `employee_personal_details` */

DROP TABLE IF EXISTS `employee_personal_details`;

CREATE TABLE `employee_personal_details` (
  `employee_id` int(10) DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  `location_id` int(10) DEFAULT NULL,
  `pin` int(10) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `alternate_phone` varchar(15) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `country_id` int(10) DEFAULT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `marital_status` char(1) DEFAULT NULL,
  `nationality` char(3) DEFAULT NULL,
  KEY `location_id` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `employee_personal_details` */

insert into `employee_personal_details` (`employee_id`,`address`,`location_id`,`pin`,`phone`,`alternate_phone`,`gender`,`country_id`,`email_id`,`date_of_birth`,`marital_status`,`nationality`) values (1,'',0,700031,'2147483647',NULL,'F',0,'manasi.dashalder@tpcsglobal.com','0000-00-00','m',NULL),(101,'',0,700030,'2147483647',NULL,'M',0,'dipayan.dasgupta@ptutors.org','0000-00-00','u',NULL),(119,'',0,712232,'2147483647',NULL,'M',0,'sanondo@gmail.com','0000-00-00','d',NULL),(122,'',0,712232,'2147483647',NULL,'M',0,'sourav.banerjee@gmail.com','0000-00-00','u',NULL),(124,'',0,712232,'2147483647',NULL,'M',0,'sourav.banerjee@gmail.com','0000-00-00','u',NULL),(125,'',0,712232,'2147483647',NULL,'M',0,'sa@gmail.com','0000-00-00','u',NULL),(126,'',0,711232,'2147483647',NULL,NULL,0,'sa@gmail.com','0000-00-00','u',NULL),(127,'',0,712232,'2147483647',NULL,'M',0,'sa@gmail.com','0000-00-00','u',NULL),(129,'',0,700101,'2147483647',NULL,'M',0,'pankaj.dutta@gmail.com','0000-00-00','d',NULL),(130,'',0,700059,'2147483647',NULL,'M',0,'uttamdas07@yahoo.co.in','0000-00-00','u',NULL),(140,'',0,758858,'2147483647',NULL,'n',0,'chandan@gmail.com','0000-00-00','u',NULL),(141,'',0,7000012,'2147483647',NULL,'n',0,'indrani@tpcsglobal.com','0000-00-00','u',NULL),(178,'Kolkata',5,712232,'9477259632','','M',105,'sanando.banerjee@gmail.com','1989-05-11','M','IND'),(186,'Uttarpara',5,712232,'9477214931','','M',105,'sanando.personal@gmail.com','1989-08-11','U','IND'),(187,'Kolkata',16,712232,'9744586321','','M',108,'san@gmail.com','1989-08-11','U','IND'),(128,'Kolkata',1,711232,'9477259632','9477585962','M',105,'uttamdas@gmail.com','1989-05-11','U','IND'),(132,'Kolkata',1,711232,'9477259632','9477585962','M',105,'jevandeep@hma.com','2013-05-09','U','IND'),(162,'dumdum',1,700050,'8981358856','8013766854','F',105,'email2sreyashi@gmail.com','1990-03-28','U','IND'),(164,'87,Kabi Kiran Dhan,road,Bhadrakali,\r\nUttarpara',659,712232,'9477214931','7278637515','M',105,'sanando.personal@gmail.com','1989-08-11','U','IND');

/*Table structure for table `employee_professional_details` */

DROP TABLE IF EXISTS `employee_professional_details`;

CREATE TABLE `employee_professional_details` (
  `employee_id` int(10) DEFAULT NULL,
  `employment_name` varchar(100) DEFAULT NULL,
  `employment_duration` varchar(20) DEFAULT NULL,
  `joining_date` varchar(20) DEFAULT NULL,
  `release_date` varchar(20) DEFAULT NULL,
  KEY `FK_employee_professional_details` (`employee_id`),
  CONSTRAINT `employee_professional_details_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `user_profile` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `employee_professional_details` */

/*Table structure for table `future_task` */

DROP TABLE IF EXISTS `future_task`;

CREATE TABLE `future_task` (
  `emp_id` int(10) NOT NULL,
  `future_task_id` int(20) NOT NULL AUTO_INCREMENT,
  `task_title` varchar(200) NOT NULL,
  `task_des` varchar(500) NOT NULL,
  `task_stating_date` varchar(20) NOT NULL,
  `task_comp_date` varchar(20) NOT NULL,
  `task_priority` varchar(20) NOT NULL,
  PRIMARY KEY (`future_task_id`),
  KEY `FK_future_task` (`emp_id`),
  CONSTRAINT `FK_future_task` FOREIGN KEY (`emp_id`) REFERENCES `user_profile` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `future_task` */

/*Table structure for table `interview_applyed_profile` */

DROP TABLE IF EXISTS `interview_applyed_profile`;

CREATE TABLE `interview_applyed_profile` (
  `interview_profile_id` int(20) NOT NULL,
  `interview_profile_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`interview_profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `interview_applyed_profile` */

insert into `interview_applyed_profile` (`interview_profile_id`,`interview_profile_name`) values (1,'JAVA/J2EE'),(2,'ASP.NET');

/*Table structure for table `interview_key_skills` */

DROP TABLE IF EXISTS `interview_key_skills`;

CREATE TABLE `interview_key_skills` (
  `interview_skills_id` int(20) NOT NULL,
  `interview_skills_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`interview_skills_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `interview_key_skills` */

insert into `interview_key_skills` (`interview_skills_id`,`interview_skills_name`) values (1,'J2SE/J2EE'),(2,'Oracle 10g');

/*Table structure for table `interview_schedule_date` */

DROP TABLE IF EXISTS `interview_schedule_date`;

CREATE TABLE `interview_schedule_date` (
  `interview_schedule_date` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `interview_schedule_date` */

insert into `interview_schedule_date` (`interview_schedule_date`) values ('29th June,2013');

/*Table structure for table `interviewee_info` */

DROP TABLE IF EXISTS `interviewee_info`;

CREATE TABLE `interviewee_info` (
  `interviewee_sl_no` int(10) NOT NULL,
  `interviewee_email_id` varchar(100) NOT NULL,
  `interviewee_name` varchar(200) DEFAULT NULL,
  `interviewee_contact_no` varchar(35) DEFAULT NULL,
  `interviewee_applied_for_id` int(10) DEFAULT NULL,
  `interviewee_academic_qualification_id` int(10) DEFAULT NULL,
  `interviewee_key_skils` varchar(100) DEFAULT NULL,
  `interviewee_status` varchar(50) DEFAULT NULL,
  `interviewee_status_date` date DEFAULT NULL,
  `intervieweee_remarks` varchar(500) DEFAULT NULL,
  `interviewee_alternate_email_id` varchar(45) DEFAULT NULL,
  `pass_out_yr` date DEFAULT NULL,
  `institute_interview_id` int(10) DEFAULT NULL,
  `interview_exp` varchar(10) DEFAULT NULL,
  `cv_receive_date` date DEFAULT NULL,
  `add_to_our_system_date` date DEFAULT NULL,
  PRIMARY KEY (`interviewee_email_id`),
  UNIQUE KEY `email_id_UNIQUE` (`interviewee_email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `interviewee_info` */

insert into `interviewee_info` (`interviewee_sl_no`,`interviewee_email_id`,`interviewee_name`,`interviewee_contact_no`,`interviewee_applied_for_id`,`interviewee_academic_qualification_id`,`interviewee_key_skils`,`interviewee_status`,`interviewee_status_date`,`intervieweee_remarks`,`interviewee_alternate_email_id`,`pass_out_yr`,`institute_interview_id`,`interview_exp`,`cv_receive_date`,`add_to_our_system_date`) values (1,'chandanksasmal@gmail.com','Chandan Kumar Sasmal','9432818045',2,16,'J2SE/J2EE,Oracle 10g','Interview Scheduled','2013-06-16','Ok','chandankrsasmal@gmail.com','2013-06-02',123,'0-1','2013-06-08','2013-06-21');

/*Table structure for table `interviewee_work_flow` */

DROP TABLE IF EXISTS `interviewee_work_flow`;

CREATE TABLE `interviewee_work_flow` (
  `work_flow_interviewee_sl_no` int(10) NOT NULL,
  `employee_id` varchar(4) NOT NULL,
  `employee_name` varchar(50) NOT NULL,
  `employee_role` varchar(20) NOT NULL,
  `employee_action_on` varchar(50) NOT NULL,
  `employee_remark` varchar(100) NOT NULL,
  `work_flow_status` varchar(10) NOT NULL,
  `work_flow_status_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `interviewee_work_flow` */

insert into `interviewee_work_flow` (`work_flow_interviewee_sl_no`,`employee_id`,`employee_name`,`employee_role`,`employee_action_on`,`employee_remark`,`work_flow_status`,`work_flow_status_date`) values (1,'109','Chandan Kumar Sasmal','Software Developer','Profile Rejected','Ok','Close','2013-06-21'),(1,'109','Chandan Kumar Sasmal','Software Developer','Aptitude Round Taken','Ok','Active','2013-06-21');

/*Table structure for table `location_details` */

DROP TABLE IF EXISTS `location_details`;

CREATE TABLE `location_details` (
  `location_id` int(10) NOT NULL AUTO_INCREMENT,
  `location_name` varchar(50) NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=692 DEFAULT CHARSET=latin1;

/*Data for the table `location_details` */

insert into `location_details` (`location_id`,`location_name`) values (1,'Kolkata'),(2,'Siligury'),(3,'Saltlake'),(4,'Kestopur'),(5,'Uttarpara'),(6,'Ruby'),(7,'New Town'),(8,'Shyam Bazar'),(9,'Kolkata'),(10,'Delhi'),(11,'Aboha'),(12,'Achalpur'),(13,'Addankin'),(14,'Adipur'),(15,'Adra(Purulia)'),(16,'Agartala'),(17,'Agra'),(18,'Ahmedabad '),(19,'Ahmednagar '),(20,'Aizawl'),(21,'Ajmer'),(22,'Akola '),(23,'Aligarh '),(24,'Allahabad '),(25,'Alwar'),(26,'Ambala '),(27,'Amethi '),(28,'Ammakandakara '),(29,'Amravati '),(30,'Amreli '),(31,'Amritsar '),(32,'Amroha '),(33,'Anakapalle'),(34,'Anand '),(35,'Anantapur'),(36,'Angul'),(37,'Anklesvar '),(38,'Anuppur'),(39,'Arakkonam'),(40,'Araria '),(41,'Arcot '),(42,'Arrah '),(43,'Aruppukkottai '),(44,'Asansol '),(45,'Ashok Nagar '),(46,'Ashtamichira '),(47,'Asurbandh(Jharkhand) '),(48,'Aurangabad(Bihar) '),(49,'Aurangabad(Maharashtra) '),(50,'Azamgarh'),(51,'Bahadurgarh'),(52,'Baharampur'),(53,'Bahraich'),(54,'Balaghat'),(55,'Balangir '),(56,'Balasore'),(57,'Bali '),(58,'Ballabhgarh'),(59,'Ballia'),(60,'Balrampur '),(61,'Bamra'),(62,'Banda'),(63,'Banganapalle'),(64,'Banswara'),(65,'Banur '),(66,'Bapatla '),(67,'Baramati '),(68,'Baran '),(69,'Bardhaman Burdwan '),(70,'Bareilly '),(71,'Bargarh '),(72,'Barh'),(73,'Baripada'),(74,'Barmer'),(75,'Barnala '),(76,'Barrackpur '),(77,'Barwani'),(78,'Bawal'),(79,'Beawar'),(80,'Belgaum '),(81,'Bellary'),(82,'Belpahar'),(83,'Bengaluru Bangalore'),(84,'Berhampur'),(85,'Betul Goa'),(86,'Betul Madhya Pradesh'),(87,'Bhagalpur'),(88,'Bhajanpura'),(89,'Bhandara '),(90,'Bharatpur'),(91,'Bharthana'),(92,'Bharthana'),(93,'Bharuch '),(94,'Bhavani'),(95,'Bhavnagar '),(96,'Bhilai'),(97,'Bhilwara '),(98,'Bhimavaram '),(99,'Bhinmal'),(100,'Bhiwandi'),(101,'Bhiwani'),(102,'Bhopal'),(103,'Bhubaneswar'),(104,'Bhuj'),(105,'Bhusawal '),(106,'Bidar'),(107,'Bihar Sharif'),(108,'Bijnor'),(109,'Bikaner'),(110,'Bilara'),(111,'Bilaspur Chhattisgarh'),(112,'Bilaspur Himachal Pradesh'),(113,'Bodh Gaya '),(114,'Bokaro Steel City'),(115,'Bongaigaon'),(116,'Brajrajnagar'),(117,'Budaun '),(118,'Bulandshahr '),(119,'Burhanpur'),(120,'Burla '),(121,'Buxar'),(122,'Cambay'),(123,'Mithapur'),(124,'Moga'),(125,'Champawat'),(126,'Chamrajnagar'),(127,'Chandannagar'),(128,'Chandigarh'),(129,'Chandausi'),(130,'Chapirevula'),(131,'Chapra Nadia'),(132,'Charkhari'),(133,'Charkhi Dadri'),(134,'Chandrapur'),(135,'Chengalpattu'),(136,'Chennai'),(137,'Chhatarpur'),(138,'Chhindwara'),(139,'Chikmagalur'),(140,'Chiplun'),(141,'Chirala'),(142,'Chitradurga'),(143,'Chitrakoot'),(144,'Chittoor'),(145,'Coimbatore'),(146,'Contai'),(147,'Cooch Behar'),(148,'Coonoor'),(149,'Cuddalore'),(150,'Cuddapah'),(151,'Cuttack'),(152,'Dabra, Gwalior'),(153,'Dadri'),(154,'Dahod'),(155,'Dalhousie'),(156,'Daltonganj'),(157,'Daman'),(158,'Damoh'),(159,'Darbhanga'),(160,'Darjeeling'),(161,'Datia'),(162,'Daund'),(163,'Davanagere'),(164,'Debagarh'),(165,'Dehgam'),(166,'Dehradun'),(167,'Dehri'),(168,'Devang'),(169,'Deoghar'),(170,'Deoria'),(171,'Devgarh Maharashtra'),(172,'Devgarh Rajasthan'),(173,'Dewas'),(174,'Dhamtari'),(175,'Dhanbad'),(176,'Dhar'),(177,'Dharampur'),(178,'Hanumangarh'),(179,'Harda'),(180,'Hardoi'),(181,'Haridwar'),(182,'Harsawa'),(183,'Hassan'),(184,'Hastinapur'),(185,'Hathras'),(186,'Himatnagar'),(187,'Hisar'),(188,'Hodal'),(189,'Howrah'),(190,'Hubli'),(191,'Hugli chuchura'),(192,'Hyderabad (Andhra Pradesh)'),(193,'Ichalkaranji'),(194,'Idar'),(195,'Indore'),(196,'Imphal'),(197,'Islampur (Nalanda)'),(198,'Islampur (Bihar)'),(199,'Islampur (Uttar Dinajpur)'),(200,'Islampur (West Bengal)'),(201,'Itanagar'),(202,'Jabalpur'),(203,'Jagadhri'),(204,'Jagdalpur'),(205,'Jagraon'),(206,'Jagtial'),(207,'Jaipur'),(208,'Jais'),(209,'Jaisalmer'),(210,'Jaitaran'),(211,'Jalalabad (Firozpur)'),(212,'Jalandhar'),(213,'Jalgaon'),(214,'Gujarat'),(215,'Dharamsala'),(216,'Dharwad'),(217,'Dhenkanal'),(218,'Dholka'),(219,'Dhule'),(220,'Dhulian'),(221,'Dhuri'),(222,'Dibrugarh'),(223,'Dindigul'),(224,'Dispur'),(225,'Diu'),(226,'Dombivli'),(227,'Dumdum'),(228,'Durg'),(229,'Durgapur Chandrapur'),(230,'Durgapur Maharashtra'),(231,'Durgapur West Bengal'),(232,'Dwarka'),(233,'Ernakulam'),(234,'Erode'),(235,'Etah'),(236,'Etawah'),(237,'Eluru'),(238,'Faizabad'),(239,'Falna'),(240,'Faridabad'),(241,'Faridkot'),(242,'Farrukhabad'),(243,'Fatehabad Haryana'),(244,'Fatehabad Madhya Pradesh'),(245,'Fatehabad Agra'),(246,'Fatehabad Uttar Pradesh'),(247,'Fatehgarh'),(248,'Fatehpur Chaurasi'),(249,'Fatehpur Sikri'),(250,'Fatehpur Rajasthan'),(251,'Fatehpur Barabanki'),(252,'Fatehpur Fatehpur'),(253,'Fazilka'),(254,'Firozabad'),(255,'Firozpur'),(256,'Gadag'),(257,'Gadchiroli'),(258,'Gandhidham'),(259,'Gandhinagar'),(260,'Gangtok'),(261,'Ganjam'),(262,'Gaya'),(263,'Ghatampur'),(264,'Ghaziabad'),(265,'Ghazipur'),(266,'Goa Velha'),(267,'Godhra'),(268,'Gondiya'),(269,'Gorakhpur'),(270,'Greater Noida'),(271,'Gudalur Coimbatore district'),(272,'Gudalur Nilgiris district'),(273,'Gudalur Theni district'),(274,'Gudivada'),(275,'Gulbarga'),(276,'Gumla'),(277,'Guna'),(278,'Gundlupet'),(279,'Guntur'),(280,'Gurgaon'),(281,'Guwahati'),(282,'Gwalior'),(283,'Godda'),(284,'Hoshiarpur '),(285,'Haldia '),(286,'Haldwani'),(287,'Halisahar'),(288,'Hamirpur (Himachal Pradesh)'),(289,'Hamirpur (Uttar Pradesh)'),(290,'Hansi'),(291,'Jalore'),(292,'Jamakhandi'),(293,'Jammu'),(294,'Jamnagar'),(295,'Jamshedpur'),(296,'Jaunpur (Uttar Pradesh)'),(297,'Jhabua'),(298,'Jhajjar'),(299,'Jhalawar'),(300,'Jhansi'),(301,'Jharsuguda'),(302,'Jhunjhunu'),(303,'Jodhpur'),(304,'Jorhat'),(305,'Junagadh'),(306,'Kadapa'),(307,'Kailaras'),(308,'Kaithal'),(309,'Kakinada'),(310,'Kalburgi'),(311,'Kalyan'),(312,'Kamthi'),(313,'Kanchipuram'),(314,'Kanker'),(315,'Kannur'),(316,'Kanpur'),(317,'Kapurthala'),(318,'Karad'),(319,'Karaikudi'),(320,'Karimganj'),(321,'Karimnagar'),(322,'Karur'),(323,'Karwar'),(324,'Katihar'),(325,'Katni'),(326,'Keylong'),(327,'Khagaria'),(328,'Khanna'),(329,'Kharagpur'),(330,'Khurai'),(331,'Kochi(Cochin)'),(332,'Kolar'),(333,'Kolhapur'),(334,'Kashinagar'),(335,'Kollam (Formerly Quilon)'),(336,'Kondagaon'),(337,'Konnagar'),(338,'Kota(Bilaspur)'),(339,'Kota (Chhattisgarh)'),(340,'Kota (Karnataka)'),(341,'Kota (Rajasthan)'),(342,'Kota (Uttar Pradesh)'),(343,'Kotdwara'),(344,'Kotma'),(345,'Kottayam'),(346,'Koyilandy'),(347,'Kozhikode'),(348,'Krishnanagar(Nadia)'),(349,'Kuchinda'),(350,'Kurnoo'),(351,'Kurukshetra'),(352,'Ladwa'),(353,'Lakhisarai'),(354,'Lalitpur'),(355,'Lamka'),(356,'Latur'),(357,'Leh'),(358,'Lonavla'),(359,'Lucknow'),(360,'Ludhiana'),(361,'Machilipatnam'),(362,'Madanapalle'),(363,'Madgaon'),(364,'Madhyamgram'),(365,'Madikeri'),(366,'Madurai'),(367,'Mahabaleswar'),(368,'Mahabubnagar'),(369,'Mahad'),(370,'Mahe'),(371,'Mahuva (Bhavnagar district)'),(372,'Mahoba'),(373,'Mahuva (Surat district)'),(374,'Mahwa'),(375,'Malegaon'),(376,'Malout'),(377,'Manavadar'),(378,'Mancherial'),(379,'Mandla'),(380,'Mandsaur'),(381,'Mandya'),(382,'Manesar'),(383,'Mangalagiri'),(384,'Mangalore'),(385,'Mapusa'),(386,'Marmagao'),(387,'Mathura'),(388,'Meerut'),(389,'Mehsana'),(390,'Mira-Bhayandar'),(391,'Miraj'),(392,'Mirzapur'),(393,'Modasa'),(394,'Mohali'),(395,'Mohania'),(396,'Mokama'),(397,'Moradabad'),(398,'Morshi'),(399,'Motihari'),(400,'Mount Abu'),(401,'Mukatsar'),(402,'Mullanpur (Ludhiana district)'),(403,'Mullanpur (Rupnagar district)'),(404,'Mumbai (formerly Bombay)'),(405,'Murshidabad'),(406,'Murwara'),(407,'Mussoorie'),(408,'Muzaffarnagar'),(409,'Muzaffarpur'),(410,'Mysore'),(411,'Nadiad'),(412,'Nagapattinam'),(413,'Nagarkurnool'),(414,'Nagaur'),(415,'Nagercoil'),(416,'Nagpur'),(417,'Nainital'),(418,'Nalagarh'),(419,'Nalgonda'),(420,'Namakkal'),(421,'Nanded'),(422,'Nandyal'),(423,'Nandurbar'),(424,'Nangal'),(425,'Narasaraopet'),(426,'Narnaul'),(427,'Narsimhapur'),(428,'Narsinghgarh (Damoh district)'),(429,'Narsinghgarh (Rajgarh district)'),(430,'Narsingarh (Tripura)'),(431,'Nashik'),(432,'Navi Mumbai'),(433,'Navsari'),(434,'Nawalgarh (Rajasthan)'),(435,'Nawanshahr'),(436,'Neemuch'),(437,'Nellore'),(438,'New Delhi'),(439,'New Guntur'),(440,'Noida'),(441,'New Guntur'),(442,'New Okhla Industrial Development Authority|NOIDA'),(443,'Nizamabad (Andhra Pradesh)'),(444,'Nizamabad (Uttar Pradesh)'),(445,'Noorpur (Uttar Pradesh)'),(446,'Nuzvid'),(447,'Ongole'),(448,'Ootacamund (Ooty)'),(449,'Orai'),(450,'Padampur'),(451,'Palai'),(452,'Palakkad'),(453,'Palanpur'),(454,'Pali (Rajasthan)'),(455,'Palwal'),(456,'Panaji'),(457,'Panchkula'),(458,'Pandharpur'),(459,'Panipat'),(460,'Panna'),(461,'Panvel'),(462,'Paratwada'),(463,'Patan'),(464,'Pathanamthitta'),(465,'Pathankot'),(466,'Patiala'),(467,'Patna'),(468,'Patratu'),(469,'Phaltan'),(470,'Piduguralla'),(471,'Pilibhit'),(472,'Pimpri Chinchwad'),(473,'Pithoragarh'),(474,'Pokaran'),(475,'Pollachi'),(476,'Ponda'),(477,'Pondicherry'),(478,'Porbandar'),(479,'Port Blair'),(480,'Pratapgarh (Rajasthan)'),(481,'Pratapgarh (Tripura)'),(482,'Pratapgarh (Uttar Pradesh)'),(483,'Pudukkottai'),(484,'Punalur'),(485,'Pune'),(486,'Puri (Orissa)'),(487,'Purnia'),(488,'Purulia'),(489,'Pushkar'),(490,'Qazigund '),(491,'Rae Bareli'),(492,'Raichur'),(493,'Raigarh'),(494,'Raipur'),(495,'Rairangpur'),(496,'Raisen'),(497,'Rajahmundry'),(498,'Rajampet'),(499,'Rajapalayam'),(500,'Rajgangpur'),(501,'Rajgarh (Alwar district)'),(502,'Rajgarh (Churu district)'),(503,'Dhar district'),(504,'Rajgarh (Himachal Pradesh)'),(505,'Rajgarh (Madhya Pradesh)'),(506,'Rajgir'),(507,'Rajgir'),(508,'Rajkot'),(509,'Rajnandgaon'),(510,'Ram Garh'),(511,'Ramanagara'),(512,'Ramanathapuram'),(513,'Ramapuram (Kottayam)'),(514,'Ramapuram (Malappuram)'),(515,'Rameshwaram'),(516,'Ramgarh Cantonment'),(517,'Ramgarh (Rajasthan)'),(518,'Ramgarh (Uttarakhand)'),(519,'Ramnagar (Agartala)'),(520,'Ramnagar (Kulti)'),(521,'Ramnagar (Barabanki)'),(522,'Ramnagar (Paschim Champaran)'),(523,'Ramnagar (Pandaveswar)'),(524,'Ramnagar (Udhampur)'),(525,'Ramnagar (Madhya Pradesh)'),(526,'Ramnagar (Purba Medinipur district)'),(527,'Ramnagar (Uttarakhand)'),(528,'Ramnagar (Varanasi)'),(529,'Rampur Bhawanipur'),(530,'Rampur Karkhana'),(531,'Rampur Maniharan'),(532,'Rampur Naikin'),(533,'Rampur (Himachal Pradesh)'),(534,'Rampur (Jharkhand)'),(535,'Rampur (Uttar Pradesh)'),(536,'Ranaghat'),(537,'Ranchi'),(538,'Rani (Rajasthan)'),(539,'Ranikhet'),(540,'Ratangarh (Neemuch)'),(541,'Ratangarh (Churu)'),(542,'Ratlam'),(543,'Ratnagiri'),(544,'Ravulapalem'),(545,'Renukoot'),(546,'Rewari'),(547,'Rishikesh'),(548,'Rishra'),(549,'Roorkee'),(550,'Rourkela'),(551,'Sadri'),(552,'Sagar (Madhya Pradesh)'),(553,'Sagara (Karnataka)'),(554,'Saharanpur'),(555,'Salem (Tamil Nadu)'),(556,'Samastipur'),(557,'Sambalpur'),(558,'Sanawad'),(559,'Sanchore'),(560,'Sangli'),(561,'Sangamner'),(562,'Sangrur'),(563,'Sardarshahar'),(564,'Sathyamangalam'),(565,'Satara'),(566,'Satna'),(567,'Sehore'),(568,'Seohara'),(569,'Seoni'),(570,'Shahada (Maharashtra)'),(571,'Shajapur'),(572,'Shegaon'),(573,'Sheopur'),(574,'Shevgaon'),(575,'Shillong'),(576,'Shimla'),(577,'Shimoga'),(578,'Shirala'),(579,'Shivani (Tarikere)'),(580,'Solan'),(581,'Sholapur'),(582,'Shrigonda'),(583,'Shrirampur'),(584,'Shrivardhan'),(585,'Siddipet'),(586,'Sidhpur'),(587,'Sihor'),(588,'Sikar'),(589,'Silchar'),(590,'Siliguri'),(591,'Silvassa'),(592,'Sindhanur'),(593,'Sinnar'),(594,'Sitapur'),(595,'Singrauli'),(596,'Sirohi'),(597,'Sironj'),(598,'Sirsa (Haryana)'),(599,'Sirsa (Uttar Pradesh)'),(600,'Sitamarhi'),(601,'Sivakasi'),(602,'Siwan (Bihar)'),(603,'Sojat'),(604,'Sonipat'),(605,'Ganganagar (Sriganganagar)'),(606,'Srikakulam'),(607,'Srikalahasti'),(608,'Srinagar'),(609,'Surat'),(610,'Sumerpur'),(611,'Suratgarh'),(612,'Surendranagar'),(613,'Suri (Birbhum)'),(614,'Suryapet'),(615,'Secundrabad'),(616,'Takhatgarh'),(617,'Talwara'),(618,'Tamluk'),(619,'Tandur'),(620,'Tanuku'),(621,'Tenali'),(622,'Tezpur'),(623,'Thalassery'),(624,'Thane'),(625,'Thanjavur'),(626,'Thathawata'),(627,'Thirthahalli'),(628,'Thiruvallur'),(629,'Thiruvananthapuram'),(630,'Thrikkannamangal'),(631,'Thrissur'),(632,'Thodupuzha'),(633,'Thoothukudi'),(634,'Tikamgarh'),(635,'Tindivanam'),(636,'Tinsukia'),(637,'Tirthahalli'),(638,'Tiruchengode'),(639,'Tiruchirappalli'),(640,'Tirunelveli'),(641,'Tirupati '),(642,'Tirupattur'),(643,'Tirupur'),(644,'Tiruvalla'),(645,'Tiruvannamalai'),(646,'Tiruvarur'),(647,'Tumkur'),(648,'Udaipur (Rajasthan)'),(649,'Udaipur (Tripura)'),(650,'Udgir'),(651,'Udhagamandalam'),(652,'Udhampur'),(653,'Udupi'),(654,'Ujjain'),(655,'Ulhasnagar'),(656,'Umred'),(657,'Unnao'),(658,'Uran Islampur'),(659,'Uttarpara'),(660,'Vadodara'),(661,'Vatakara'),(662,'Vallabh Vidhyanagar'),(663,'Valsad'),(664,'Vandavasi'),(665,'Vapi'),(666,'Varanasi'),(667,'Vasai'),(668,'Vasco da Gama(Goa)'),(669,'Vellore'),(670,'Vidisha'),(671,'Vijayawada'),(672,'Viluppuram'),(673,'Virar'),(674,'Visakhapatnam'),(675,'Vizianagaram'),(676,'Virudhachalam'),(677,'Vyara]'),(678,'Wadi'),(679,'Warangal'),(680,'Wardha'),(681,'Yamunanagar'),(682,'Yavatmal'),(683,'Zira '),(684,'Ziro'),(685,'Kandahar'),(686,'Dhaka'),(687,'Khulna'),(688,'Pabna'),(689,'Jashore'),(690,'Chattagram'),(691,'Hooghly Serampore');

/*Table structure for table `new_job_details` */

DROP TABLE IF EXISTS `new_job_details`;

CREATE TABLE `new_job_details` (
  `job_id` int(10) NOT NULL,
  `job_description` varchar(400) NOT NULL,
  `job_created_by_emp_id` int(10) NOT NULL,
  `job_status` char(1) NOT NULL,
  `job_urgency` char(1) NOT NULL,
  `job_creation_date` date NOT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `new_job_details` */

insert into `new_job_details` (`job_id`,`job_description`,`job_created_by_emp_id`,`job_status`,`job_urgency`,`job_creation_date`) values (1,'Bulkupload Application',2,'A','L','2013-06-21');

/*Table structure for table `pg_qualification` */

DROP TABLE IF EXISTS `pg_qualification`;

CREATE TABLE `pg_qualification` (
  `pg_qualification_id` int(10) NOT NULL AUTO_INCREMENT,
  `pg_qualification` varchar(200) NOT NULL,
  PRIMARY KEY (`pg_qualification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `pg_qualification` */

insert into `pg_qualification` (`pg_qualification_id`,`pg_qualification`) values (1,'Select From table'),(2,'M.TECH'),(3,'MA'),(4,'MSC'),(5,'MBA'),(6,'MCA'),(7,'MCOM'),(8,'Post Graduate Diploma'),(9,'PGDMA');

/*Table structure for table `pg_specialization` */

DROP TABLE IF EXISTS `pg_specialization`;

CREATE TABLE `pg_specialization` (
  `pg_specialization_id` int(10) NOT NULL AUTO_INCREMENT,
  `pg_specialization` varchar(200) NOT NULL,
  PRIMARY KEY (`pg_specialization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

/*Data for the table `pg_specialization` */

insert into `pg_specialization` (`pg_specialization_id`,`pg_specialization`) values (1,'Select Correct Option'),(2,'Accounting'),(3,'Electrinics'),(4,'CSE'),(5,'Appled Electronics'),(6,'I.T'),(7,'Telecomunication'),(8,'Electrical'),(9,'Math'),(10,'Microbilogy'),(11,'Goology'),(12,'physiology'),(13,'Physics'),(14,'Chemistry'),(15,'Geography'),(16,'History'),(17,'Psychology'),(18,'Administration'),(19,'Dance'),(20,'Music'),(21,'Instrumental'),(22,'English'),(23,'Bengali'),(24,'Business Intelligence'),(25,'Entrepreneurship'),(26,'Environmental Management'),(27,'Finance'),(28,'Healthcare Management  '),(29,'Human Resource Management'),(30,'Internet Marketing'),(31,'Marketing'),(32,'Supply Chain Services Management'),(33,'Nonprofit Management'),(34,'Journalism'),(35,'Operations');

/*Table structure for table `pg_university` */

DROP TABLE IF EXISTS `pg_university`;

CREATE TABLE `pg_university` (
  `pg_university_id` int(10) NOT NULL,
  `pg_university` varchar(200) NOT NULL,
  PRIMARY KEY (`pg_university_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pg_university` */

insert into `pg_university` (`pg_university_id`,`pg_university`) values (1,'Select The Correct Option'),(2,'Calcutta University'),(3,'Jadavpur University'),(4,'Rabindrabharati University'),(5,'Vidyasagar University'),(6,'North Bengal University'),(7,'West Bengal University Of Technology'),(8,'IGNOU'),(9,'Sikkim Manipal University'),(10,'Ranchi University'),(11,'Agra University'),(12,'AIMA'),(13,'Aligarh Muslim University'),(14,'Allahabad University'),(15,'Amaravati University'),(16,'Amity Business School'),(17,'Andhra University'),(18,'Anna University'),(19,'Annamalai University'),(20,'Apeejay School of Marketing'),(21,'APTECH'),(22,'Banaras Hindu University'),(23,'Bangalore University'),(24,'Barkatullah University'),(25,'Berhampur University'),(26,'Bharathiar University'),(27,'Bharathidasan University'),(28,'BITS (Mesra)'),(29,'BITS (Pilani)'),(30,'Board of Technical Education'),(31,'Calicut University'),(32,'Chennai University'),(33,'DAVV, Indore'),(34,'Delhi College of Engineering'),(35,'Delhi University'),(36,'Devi Ahilya University'),(37,'DOEACC'),(38,'FMS,Delhi'),(39,'Fore School of Management'),(40,'Goa Institute of Management'),(41,'Goa University'),(42,'Gujarat University'),(43,'Gulbarga University'),(44,'Hyderabad University'),(45,'ICFAI'),(46,'ICSI'),(47,'ICWA'),(48,'IIM, Ahmedabad'),(49,'IIM, Bangalore'),(50,'IIM, Calcutta'),(51,'IIM, Indore'),(52,'IIM, Kozhikode'),(53,'IIM, Lucknow'),(54,'IIPM'),(55,'IISWBM, Calcutta'),(56,'IIT,Chennai'),(57,'IIT,Delhi'),(58,'IIT,Guwahati'),(59,'IIT,Kanpur'),(60,'IIT,Kharagpur'),(61,'IIT,Mumbai'),(62,'IIT,Roorkee'),(63,'IMI, Delhi'),(64,'IMT,Ghaziabad'),(65,'Indian Institute of Foreign Trade'),(66,'Indian Institute of Science'),(67,'Indian Statistical Institute'),(68,'Institute of Chartered Accountants of India'),(69,'IRM, Anand'),(70,'IT,BHU'),(71,'Jamia Millia Islamia'),(72,'Jawaharlal Nehru University'),(73,'Jiwaji University'),(74,'JNTU,Hyderabad'),(75,'Kakatiya University'),(76,'Kanpur University'),(77,'Karanataka University'),(78,'Kerala University'),(79,'Kurukshetra University'),(80,'Kuvempu University'),(81,'Lucknow University'),(82,'Madurai Kamaraj University'),(83,'Mahatma Gandhi University'),(84,'Mangalore University'),(85,'MDI,Gurgaon'),(86,'Meerut University'),(87,'Mumbai University'),(88,'Nagarjuna University'),(89,'Nagpur University'),(90,'NIFT'),(91,'NIIT'),(92,'NMIMS,Mumbai'),(93,'North Maharashtra University'),(94,'OSMANIA UNIVERSITY'),(95,'Panjab University'),(96,'Pondicherry University'),(97,'Pune University'),(98,'Punjab Technical University'),(99,'Rajasthan University'),(100,'Ranchi University'),(101,'RECs'),(102,'Sambalpur University'),(103,'Saurashtra University'),(104,'Shivaji University'),(105,'South Gujarat University,Surat'),(106,'SP Jain Institute of Management Studies'),(107,'Sri Venkateshwara University'),(108,'Symbiosis,Pune'),(109,'TA Pai Management Institute'),(110,'Tata Institute of Social Sciences'),(111,'University of Mysore'),(112,'Utkal University'),(113,'Vidyasagar University'),(114,'Visveshwaraiah University'),(115,'XIM, Bhubaneswar'),(116,'XISS,  Ranchi'),(117,'XLRI, Jamshedpur'),(118,'YMCA'),(119,'Kalyani University'),(120,'Patna University'),(121,'Chartered Accountants Institute'),(122,'Barasat University');

/*Table structure for table `reg_trainee` */

DROP TABLE IF EXISTS `reg_trainee`;

CREATE TABLE `reg_trainee` (
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `altemail` varchar(50) NOT NULL,
  `phno` varchar(20) NOT NULL,
  `altphno` varchar(20) NOT NULL,
  `message` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reg_trainee` */

/*Table structure for table `task_assignment` */

DROP TABLE IF EXISTS `task_assignment`;

CREATE TABLE `task_assignment` (
  `task_id` int(10) NOT NULL AUTO_INCREMENT,
  `task_assigned_by` int(10) NOT NULL,
  `task_resource_id` int(10) DEFAULT NULL,
  `task_category_id` int(10) DEFAULT NULL,
  `task_description` varchar(1000) DEFAULT NULL,
  `task_target_date` date DEFAULT NULL,
  `task_status_id` int(10) DEFAULT NULL,
  `task_project_id` int(10) DEFAULT NULL,
  `task_closing_date` date DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `task_assignment` */

insert into `task_assignment` (`task_id`,`task_assigned_by`,`task_resource_id`,`task_category_id`,`task_description`,`task_target_date`,`task_status_id`,`task_project_id`,`task_closing_date`) values (1,109,2,1,'ok You do it!','2013-06-01',1,1,NULL),(2,109,2,1,'Ok I am finally test the application.','2013-06-22',2,1,NULL),(3,109,124,1,'Ok 2 You do it','2013-06-22',1,1,NULL),(4,109,2,1,'Ok I do it','2013-06-22',1,1,NULL),(5,109,4,1,'Ok','2013-06-23',1,1,NULL),(6,109,109,1,'qwqwqwqw','2013-06-23',1,1,NULL),(7,2,109,1,'Bulkupload Application','2013-06-22',1,1,NULL);

/*Table structure for table `task_category` */

DROP TABLE IF EXISTS `task_category`;

CREATE TABLE `task_category` (
  `task_category_id` int(10) NOT NULL,
  `task_category_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`task_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `task_category` */

insert into `task_category` (`task_category_id`,`task_category_name`) values (1,'Hr Management'),(2,'Office Management'),(3,'Web Development'),(4,'Content Writing'),(5,'Web Design'),(6,'Testing'),(7,'Web Hosting');

/*Table structure for table `task_planner` */

DROP TABLE IF EXISTS `task_planner`;

CREATE TABLE `task_planner` (
  `assign_task_no` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `assign_task_desc` varchar(500) DEFAULT NULL,
  `assign_task_date` datetime DEFAULT NULL,
  PRIMARY KEY (`assign_task_no`),
  KEY `FK_task_planner` (`user_id`),
  CONSTRAINT `FK_task_planner` FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

/*Data for the table `task_planner` */

insert into `task_planner` (`assign_task_no`,`user_id`,`assign_task_desc`,`assign_task_date`) values (11,118,'','2012-10-31 00:00:00'),(12,118,'','2012-10-31 00:00:00'),(13,124,'','2012-10-31 00:00:00'),(14,124,'','2012-10-31 00:00:00'),(15,124,'','2012-10-31 00:00:00'),(16,124,'','2012-10-31 00:00:00'),(17,118,'','2012-11-01 00:00:00'),(18,118,'','2012-11-01 00:00:00'),(19,118,'','2012-11-01 00:00:00'),(20,124,' a c d','2012-11-09 00:00:00'),(21,124,'0your','2012-11-09 00:00:00'),(22,124,'0.plan1.your','2012-11-09 00:00:00'),(23,124,' 1.plan 2.your','2012-11-09 00:00:00'),(24,124,'plan','2012-11-09 00:00:00'),(25,124,'your','2012-11-09 00:00:00'),(26,124,'aaa','2012-11-09 00:00:00'),(27,124,'baba','2012-11-09 00:00:00'),(28,124,'sanando doing work','2012-11-09 00:00:00'),(29,124,'chandan da ','2012-11-09 00:00:00'),(30,124,'sanando','2012-11-10 00:00:00'),(31,124,'kolkata','2012-11-10 00:00:00'),(32,124,'aaa','2012-12-03 00:00:00'),(33,124,'bb','2012-12-03 00:00:00'),(34,124,'done','2012-12-28 00:00:00'),(35,124,'done','2012-12-28 00:00:00'),(36,124,'Good','2012-12-28 00:00:00'),(37,124,'aaa','2012-12-29 00:00:00'),(38,178,'jkjkkljo','2013-04-19 00:00:00'),(39,178,'jhvjh','2013-04-19 00:00:00'),(40,178,'uuuuuuu','2013-04-26 00:00:00'),(41,178,'uuuuuyyyyyyyy','2013-04-26 00:00:00'),(42,178,'','2013-05-15 00:00:00');

/*Table structure for table `task_project` */

DROP TABLE IF EXISTS `task_project`;

CREATE TABLE `task_project` (
  `task_project_id` int(3) NOT NULL,
  `task_project_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`task_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `task_project` */

insert into `task_project` (`task_project_id`,`task_project_name`) values (1,'Office Management'),(2,'The Professional Tutors'),(3,'Admission Vista'),(4,'The Professional Jobs'),(5,'Dial 2 Doctor'),(6,'Technoschools.org');

/*Table structure for table `task_status` */

DROP TABLE IF EXISTS `task_status`;

CREATE TABLE `task_status` (
  `task_status_id` int(3) NOT NULL,
  `task_status_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`task_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `task_status` */

insert into `task_status` (`task_status_id`,`task_status_name`) values (1,'Assigned'),(2,'In Progress'),(3,'Completed'),(4,'Facing Issues');

/*Table structure for table `tpcs_asset` */

DROP TABLE IF EXISTS `tpcs_asset`;

CREATE TABLE `tpcs_asset` (
  `cno` varchar(10) DEFAULT NULL,
  `desc` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_asset` */

/*Table structure for table `tpcs_balancesheet_kolkata` */

DROP TABLE IF EXISTS `tpcs_balancesheet_kolkata`;

CREATE TABLE `tpcs_balancesheet_kolkata` (
  `item_name` varchar(20) DEFAULT NULL,
  `item_quantity` varchar(20) DEFAULT NULL,
  `item_type` varchar(20) DEFAULT NULL,
  `item_price` varchar(20) DEFAULT NULL,
  `item_date` varchar(20) DEFAULT NULL,
  `item_bal` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_balancesheet_kolkata` */

insert into `tpcs_balancesheet_kolkata` (`item_name`,`item_quantity`,`item_type`,`item_price`,`item_date`,`item_bal`) values ('Flower','2','Credit','20','12-09-12',20),('Cheaps','1','debit','3','15-02-89',3),('Flower','2','debit','3','27-05-88',3),('Flowervas','2','Debit','250','17-09-12',250),('Resume','1','debit','12','17-09-12',1988),('Resume','1','Credit','12','17-09-12',2012),('g','1','debit','20','17-09-12',1980),('coverfile','1','debit','1000','17-09-12',980),('scale','1','debit','20','12-09-12',960),('computer','1','debit','960','18-09-12',0),('computer','1','debit','960','18-09-12',-960),('computer','1','credit','960','18-09-12',0),('','','credit','2000','',2000),('UPS','1','debit','200','18-09-12',1800),('hhh','22','debit','41252','27-05-88',-39452),('File','2','Credit','100000','4.12.12',60548),('file_sanando','20','debit','5000','10/11/12',60648),('file_sanando','2','debit','50000','10.12.2012',10648),('Books','5','credit','10000','12/12/2012',20648),('Food','10','debit','5000','06/12/2012',15648),('Food','10','debit','5000','06/12/2012',10648),('Food','10','debit','5000','06/12/2012',5648),('hhahahahah','12','credit','1200','10/12/2012',6848),('file','2','debit','5000','04/12/2012',1848);

/*Table structure for table `tpcs_balancesheet_siligury` */

DROP TABLE IF EXISTS `tpcs_balancesheet_siligury`;

CREATE TABLE `tpcs_balancesheet_siligury` (
  `item_name` varchar(20) DEFAULT NULL,
  `item_quantity` varchar(20) DEFAULT NULL,
  `item_type` varchar(20) DEFAULT NULL,
  `item_price` varchar(20) DEFAULT NULL,
  `item_date` varchar(20) DEFAULT NULL,
  `item_bal` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_balancesheet_siligury` */

insert into `tpcs_balancesheet_siligury` (`item_name`,`item_quantity`,`item_type`,`item_price`,`item_date`,`item_bal`) values ('Flower','2','Credit','20','12-09-12',20),('Cheaps','1','debit','3','15-02-89',3),('Flower','2','debit','3','27-05-88',3),('Flowervas','2','Debit','250','17-09-12',250),('Resume','1','debit','12','17-09-12',1988),('Resume','1','Credit','12','17-09-12',2012),('g','1','debit','20','17-09-12',1980),('coverfile','1','debit','1000','17-09-12',980),('scale','1','debit','20','12-09-12',960),('computer','1','debit','960','18-09-12',0),('computer','1','debit','960','18-09-12',-960),('computer','1','credit','960','18-09-12',0),('','','credit','2000','',2000),('UPS','1','debit','200','18-09-12',1800),('hhh','22','debit','41252','27-05-88',-39452),('File','2','Credit','100000','4.12.12',60548),('file','2','credit','100','10/10/12',60648),('file','2','credit','5000','10/10/12',65648),('1234','12','debit','500','04/12/2012',65148),('File ','2','credit','1000','08/12/2012',66148),('Food','10','debit','5000','06/12/2012',61148),('Food','10','debit','5000','06/12/2012',56148);

/*Table structure for table `tpcs_bank_details` */

DROP TABLE IF EXISTS `tpcs_bank_details`;

CREATE TABLE `tpcs_bank_details` (
  `user_id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `bname` varchar(200) NOT NULL,
  `anumber` varchar(200) NOT NULL,
  KEY `FK_tpcs_bank_details` (`user_id`),
  CONSTRAINT `FK_tpcs_bank_details` FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_bank_details` */

insert into `tpcs_bank_details` (`user_id`,`name`,`bname`,`anumber`) values (124,'aa','aa','aa');

/*Table structure for table `tpcs_contact` */

DROP TABLE IF EXISTS `tpcs_contact`;

CREATE TABLE `tpcs_contact` (
  `contact_no` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `company` varchar(100) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `message` varchar(500) NOT NULL,
  PRIMARY KEY (`contact_no`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_contact` */

insert into `tpcs_contact` (`contact_no`,`name`,`email`,`company`,`subject`,`message`) values (15,'sanando','sanando.banerjee@gmail.com','TPCS','','good'),(16,'sanando','sananado.personal@gmail.com','','','aaaaa'),(17,'Pankaj','pankaj@gmail.com','','','pankaj da is a dhop baaj boy');

/*Table structure for table `tpcs_designation` */

DROP TABLE IF EXISTS `tpcs_designation`;

CREATE TABLE `tpcs_designation` (
  `designation_id` int(10) NOT NULL AUTO_INCREMENT,
  `designation` varchar(50) NOT NULL,
  PRIMARY KEY (`designation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_designation` */

insert into `tpcs_designation` (`designation_id`,`designation`) values (1,'HR Manager'),(2,'Telecaller'),(3,'Software Developer'),(4,'Senior Software Developer'),(5,'Team Lead'),(6,'Project Manager'),(7,'Software Trainee'),(8,'Proprietor'),(9,'Trainee Software Develop');

/*Table structure for table `tpcs_enquiry_details` */

DROP TABLE IF EXISTS `tpcs_enquiry_details`;

CREATE TABLE `tpcs_enquiry_details` (
  `enquiry_no` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `contactno` varchar(10) NOT NULL,
  `altcontactno` varchar(10) NOT NULL,
  `emailId` varchar(100) NOT NULL,
  `qualification` varchar(100) NOT NULL,
  `remarks` varchar(500) NOT NULL,
  PRIMARY KEY (`enquiry_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_enquiry_details` */

insert into `tpcs_enquiry_details` (`enquiry_no`,`name`,`contactno`,`altcontactno`,`emailId`,`qualification`,`remarks`) values (1,'sanando','9477214931','9477214932','ss','b.tech','nothing');

/*Table structure for table `tpcs_grade` */

DROP TABLE IF EXISTS `tpcs_grade`;

CREATE TABLE `tpcs_grade` (
  `grade_id` int(10) NOT NULL AUTO_INCREMENT,
  `grade_value` varchar(10) NOT NULL,
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_grade` */

insert into `tpcs_grade` (`grade_id`,`grade_value`) values (1,'6A'),(2,'6B'),(3,'7A'),(4,'7B'),(5,'8A'),(6,'8B'),(7,'9A'),(8,'9B');

/*Table structure for table `tpcs_grivences` */

DROP TABLE IF EXISTS `tpcs_grivences`;

CREATE TABLE `tpcs_grivences` (
  `employee_id` int(10) NOT NULL,
  `grivence` varchar(200) NOT NULL,
  `grivence_time` time NOT NULL,
  `grivence_date` date NOT NULL,
  KEY `FK_tpcs_grivences` (`employee_id`),
  CONSTRAINT `tpcs_grivences_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `user_profile` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_grivences` */

insert into `tpcs_grivences` (`employee_id`,`grivence`,`grivence_time`,`grivence_date`) values (124,'aaa','17:07:26','2013-01-15'),(124,'aaa','17:08:19','2013-01-15'),(124,'','17:11:40','2013-01-15'),(124,'aaaa','17:13:03','2013-01-15'),(125,'dddd','14:50:35','2013-03-15'),(125,'dddd','14:50:41','2013-03-15'),(124,'aaa','13:33:37','2013-04-12'),(124,'aaa','13:45:46','2013-04-12'),(124,'aaaa','13:53:07','2013-04-12'),(178,'bbbbb','13:55:54','2013-04-12'),(178,'pppp','14:33:58','2013-04-17'),(178,'kkll','14:42:47','2013-04-17'),(178,'kkll','14:42:54','2013-04-17'),(178,'kkll','14:42:56','2013-04-17'),(178,'kkll','14:42:57','2013-04-17'),(178,'sssss\r\n','10:59:23','2013-05-09'),(178,'sasas','11:12:39','2013-05-09'),(186,'aaa','10:53:21','2013-05-15'),(178,'aaa','14:37:59','2013-05-27');

/*Table structure for table `tpcs_ledger_check` */

DROP TABLE IF EXISTS `tpcs_ledger_check`;

CREATE TABLE `tpcs_ledger_check` (
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_ledger_check` */

insert into `tpcs_ledger_check` (`user_name`,`password`) values ('Siligury_admin','1234'),('Kolkata_admin','5678');

/*Table structure for table `tpcs_location` */

DROP TABLE IF EXISTS `tpcs_location`;

CREATE TABLE `tpcs_location` (
  `location_id` int(10) NOT NULL AUTO_INCREMENT,
  `location_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_location` */

insert into `tpcs_location` (`location_id`,`location_name`) values (1,'Kolkata'),(2,'Siligury');

/*Table structure for table `tpcs_news_event` */

DROP TABLE IF EXISTS `tpcs_news_event`;

CREATE TABLE `tpcs_news_event` (
  `news_no` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `title` varchar(50) NOT NULL,
  `date` varchar(10) NOT NULL,
  `newsdetails` varchar(500) NOT NULL,
  PRIMARY KEY (`news_no`),
  KEY `FK_tpcs_news_event` (`user_id`),
  CONSTRAINT `FK_tpcs_news_event` FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_news_event` */

insert into `tpcs_news_event` (`news_no`,`user_id`,`title`,`date`,`newsdetails`) values (8,124,'Farewell','2010-07-13','Farewell organize in the office '),(9,124,'Tution','2012-12-09','Sir teach us today Struts 1'),(10,124,'Training','2012-12-23','Uttam da and me(Sanando) were trained by sir'),(11,124,'Christmas','2012-12-25','Merry Christmas to All'),(12,124,'Insert Check','2012-02-11','Sanando check The news portion'),(13,124,'insert ','2012-02-11','sANANDO CHECK IT..'),(14,124,'insert ','2012-02-11','sANANDO CHECK IT..'),(15,124,'dada','2012-05-11','Sanando...'),(16,178,'Software','2013-05-01','1st May,2013 Our office is closed'),(17,178,'Software','2013-05-01','Today us iahg hakka hhhdhd bkdd bahhs hskks jknndkand kkhdashh hhhdhjjJ HHDJJADJJDN kljsjha hhfhljasd nsdaddsajads kndljd ndljdld nddhd mnddl hdhhdlhlhlhd khdhda dhldh nkdsdjld klhdhds ldjjdn ljddj');

/*Table structure for table `tpcs_parent_iou` */

DROP TABLE IF EXISTS `tpcs_parent_iou`;

CREATE TABLE `tpcs_parent_iou` (
  `parent_iou_id` int(10) NOT NULL AUTO_INCREMENT,
  `parent_iou_name` varchar(200) NOT NULL,
  PRIMARY KEY (`parent_iou_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_parent_iou` */

insert into `tpcs_parent_iou` (`parent_iou_id`,`parent_iou_name`) values (1,'Banking And Finance'),(2,'Construction'),(3,'Energy And Utility'),(4,'Goverment'),(5,'Healthcare'),(6,'Insurence'),(7,'Life Insurence'),(8,'Manufacturing'),(9,'Media And Information Service'),(10,'Metal And Mining '),(11,'Retail And Consumer Product'),(12,'Telecom'),(13,'Travel Transportation And Hospitality  ');

/*Table structure for table `tpcs_salary_slip` */

DROP TABLE IF EXISTS `tpcs_salary_slip`;

CREATE TABLE `tpcs_salary_slip` (
  `salary_no` int(10) NOT NULL AUTO_INCREMENT,
  `employee_id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `salary` varchar(100) NOT NULL,
  `startingdate` varchar(10) NOT NULL,
  `endingdate` varchar(10) NOT NULL,
  `paymenttype` varchar(100) NOT NULL,
  `paymentdate` varchar(100) NOT NULL,
  PRIMARY KEY (`salary_no`),
  KEY `FK_tpcs_salary_slip` (`employee_id`),
  CONSTRAINT `tpcs_salary_slip_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `user_profile` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_salary_slip` */

insert into `tpcs_salary_slip` (`salary_no`,`employee_id`,`name`,`salary`,`startingdate`,`endingdate`,`paymenttype`,`paymentdate`) values (8,1,'','','','','',''),(9,124,'Sanando Banerjee','4500','','13/07/2012','',''),(10,1,'Manasi Das(Halder)','100','','','',''),(11,124,'Sanando Banerjee','4500','01/12/2012','31/12/2012','scaca','4/01/2013'),(12,1,'Manasi Das(Halder)','4822','01/02/2012','31/02/2012','456985145','04/03/2012');

/*Table structure for table `tpcs_testimonials` */

DROP TABLE IF EXISTS `tpcs_testimonials`;

CREATE TABLE `tpcs_testimonials` (
  `user_id` int(10) NOT NULL,
  `testimonial_no` int(10) NOT NULL AUTO_INCREMENT,
  `designation` varchar(50) NOT NULL,
  `date` varchar(20) NOT NULL,
  `details` varchar(500) NOT NULL,
  PRIMARY KEY (`testimonial_no`),
  KEY `FK_tpcs_testimonials` (`user_id`),
  CONSTRAINT `tpcs_testimonials_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_testimonials` */

insert into `tpcs_testimonials` (`user_id`,`testimonial_no`,`designation`,`date`,`details`) values (124,1,'aaa','07/11/2012','aaaa'),(124,2,'aaaa','06/11/2012','aaaaaa'),(124,3,'aaa','23/11/2012','akakaka\r\n');

/*Table structure for table `tpcs_traningschedule` */

DROP TABLE IF EXISTS `tpcs_traningschedule`;

CREATE TABLE `tpcs_traningschedule` (
  `traning_no` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `emailid` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `trainer` varchar(100) NOT NULL,
  `traning_id` varchar(10) NOT NULL,
  `timing` varchar(100) NOT NULL,
  `day` varchar(100) NOT NULL,
  `technology` varchar(100) NOT NULL,
  PRIMARY KEY (`traning_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_traningschedule` */

insert into `tpcs_traningschedule` (`traning_no`,`user_id`,`name`,`emailid`,`phone`,`trainer`,`traning_id`,`timing`,`day`,`technology`) values (1,124,'sanando','sanando.banerjee@gmail.com','9477214932','chandan','124','10am-1pm','sunday','j2ee'),(2,124,'sanando','sanando.banerjee@gmail.com','9477214932','chandan','124','10am-1pm','sunday','j2ee'),(3,124,'sanando','sanando.banerjee@gmail.com','9477214932','chandan','124','10am-1pm','sunday','j2ee'),(4,124,'sanando','sanando.banerjee@gmail.com','9477214932','chandan','124','10am-1pm','','j2ee');

/*Table structure for table `tpcs_uploadcv` */

DROP TABLE IF EXISTS `tpcs_uploadcv`;

CREATE TABLE `tpcs_uploadcv` (
  `uploadcvid` int(10) NOT NULL AUTO_INCREMENT,
  `filename` varchar(210) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `experience` varchar(10) NOT NULL,
  `technology` varchar(100) NOT NULL,
  PRIMARY KEY (`uploadcvid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `tpcs_uploadcv` */

insert into `tpcs_uploadcv` (`uploadcvid`,`filename`,`name`,`email`,`phone`,`experience`,`technology`) values (5,'sanando.banerjee@gmail.comHike Letter.doc','Sanando','sanando.banerjee@gmail.com','9477214931','1 year',''),(6,'spike3211@gmail.comHike Letter.docx','amrita kundu','spike3211@gmail.com','9477214931','1 year',''),(7,'sanando.banerjee@gmail.comFri May 17 12:59:25 NPT 2013Hike Letter.doc','Sanando','sanando.banerjee@gmail.com','9477214931','1 year',''),(8,'sanando.banerjee@gmail.com1368774984203Hike Letter.doc','amrita kundu','sanando.banerjee@gmail.com','9477214931','1 year',''),(9,'sanando.banerjee@gmail.com1368775012406Hike Letter.doc','Sanando','sanando.banerjee@gmail.com','9477214931','1 year',''),(10,'sanando.banerjee@gmail.com1368775209984Hike Letter.doc','amrita kundu','sanando.banerjee@gmail.com','9477214931','1 year',''),(11,'spike3211@gmail.com1368952564687Hike Letter.doc','Sanando','spike3211@gmail.com','9477214931','1 year','Java'),(12,'amrita.meme@gmail.com1368952657000Hike Letter.doc','amrita kundu','amrita.meme@gmail.com','9477214931','1 year','Java'),(13,'spike3211@gmail.com1369392297687Hike Letter.doc','amrita kundu','spike3211@gmail.com','9477214931','1 year','J2ee'),(14,'ererer@hham.com1370255664147Notice_for_April m.docx','Sanando','ererer@hham.com','9477214931','1 Year','J2EE'),(15,'ererer@hham.com1370255668017Notice_for_April m.docx','Sanando','ererer@hham.com','9477214931','1 Year','J2EE');

/*Table structure for table `ug_qualification` */

DROP TABLE IF EXISTS `ug_qualification`;

CREATE TABLE `ug_qualification` (
  `ug_qualification_id` int(10) NOT NULL,
  `ug_qualification` varchar(200) NOT NULL,
  PRIMARY KEY (`ug_qualification_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ug_qualification` */

insert into `ug_qualification` (`ug_qualification_id`,`ug_qualification`) values (1,'B.TECH'),(2,'B.E'),(3,'B.SC'),(4,'B.COM'),(5,'B.A'),(6,'DIPLOMA'),(7,'BBA'),(8,'B.S'),(9,'BME'),(10,'BPhil'),(11,'BFA'),(12,'LLB'),(13,'O lable'),(14,'MSc'),(15,'MSW'),(16,'AAAA');

/*Table structure for table `ug_specialozation` */

DROP TABLE IF EXISTS `ug_specialozation`;

CREATE TABLE `ug_specialozation` (
  `ug_specialization_id` int(10) NOT NULL AUTO_INCREMENT,
  `ug_specialization` varchar(200) NOT NULL,
  PRIMARY KEY (`ug_specialization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

/*Data for the table `ug_specialozation` */

insert into `ug_specialozation` (`ug_specialization_id`,`ug_specialization`) values (1,'I.T'),(2,'CSE'),(3,'EE'),(4,'ECE'),(5,'AEIE'),(6,'ICE'),(7,'Mechanical'),(8,'Civil'),(9,'Textiles'),(10,'Wireless Engg'),(11,'Information Systems'),(12,'Coreography'),(13,'Math'),(14,'Chemistry'),(15,'Micrology'),(16,'Goology'),(17,'Physics'),(18,'History'),(19,'Geography'),(20,'Bengali'),(21,'English'),(22,'Psychology'),(23,'Physiology'),(24,'Hindi'),(25,'Urdu'),(26,'ARTS'),(27,'DANCING'),(28,'CMMERCE'),(29,'Music'),(30,'Nursery'),(31,'Agriculture'),(32,'Architecture and Design'),(33,'Business and management'),(34,'Physiotherapy'),(35,'Optometry'),(36,'Veterinary Science'),(37,'Fine arts'),(38,'Journalism'),(39,'Library science'),(40,'Forestry'),(41,'Law'),(42,'Public affairs and policy management');

/*Table structure for table `ug_university` */

DROP TABLE IF EXISTS `ug_university`;

CREATE TABLE `ug_university` (
  `ug_university_id` int(10) NOT NULL AUTO_INCREMENT,
  `ug_university` varchar(200) NOT NULL,
  PRIMARY KEY (`ug_university_id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=latin1;

/*Data for the table `ug_university` */

insert into `ug_university` (`ug_university_id`,`ug_university`) values (1,'Calcutta University'),(2,'Jadavpur University'),(3,'Rabindrabharati University'),(4,'Vidyasagar University'),(5,'North Bengal University'),(6,'West Bengal University Of Technology'),(7,'Barasat University'),(8,'IGNOU'),(9,'Sikkim Manipal University'),(10,'Ranchi University'),(11,'Agra University'),(12,'AIMA'),(13,'Aligarh Muslim University'),(14,'Allahabad University'),(15,'Amaravati University'),(16,'Amity Business School'),(17,'Andhra University'),(18,'Anna University'),(19,'Annamalai University'),(20,'Apeejay School of Marketing'),(21,'APTECH'),(22,'Banaras Hindu University'),(23,'Bangalore University'),(24,'Barkatullah University'),(25,'Berhampur University'),(26,'Bharathiar University'),(27,'Bharathidasan University'),(28,'BITS (Mesra)'),(29,'BITS (Pilani)'),(30,'Board of Technical Education'),(31,'Calicut University'),(32,'Chennai University'),(33,'DAVV, Indore'),(34,'Delhi College of Engineering'),(35,'Delhi University'),(36,'Devi Ahilya University'),(37,'DOEACC'),(38,'FMS,Delhi'),(39,'Fore School of Management'),(40,'Goa Institute of Management'),(41,'Goa University'),(42,'Gujarat University'),(43,'Gulbarga University'),(44,'Hyderabad University'),(45,'ICFAI'),(46,'ICSI'),(47,'ICWA'),(48,'IIM, Ahmedabad'),(49,'IIM, Bangalore'),(50,'IIM, Calcutta'),(51,'IIM, Indore'),(52,'IIM, Kozhikode'),(53,'IIM, Lucknow'),(54,'IIPM'),(55,'IISWBM, Calcutta'),(56,'IIT,Chennai'),(57,'IIT,Delhi'),(58,'IIT,Guwahati'),(59,'IIT,Kanpur'),(60,'IIT,Kharagpur'),(61,'IIT,Mumbai'),(62,'IIT,Roorkee'),(63,'IMI, Delhi'),(64,'IMT,Ghaziabad'),(65,'Indian Institute of Foreign Trade'),(66,'Indian Institute of Science'),(67,'Indian Statistical Institute'),(68,'Institute of Chartered Accountants of India'),(69,'IRM, Anand'),(70,'IT,BHU'),(71,'Jamia Millia Islamia'),(72,'Jawaharlal Nehru University'),(73,'Jiwaji University'),(74,'JNTU,Hyderabad'),(75,'Kakatiya University'),(76,'Kanpur University'),(77,'Karanataka University'),(78,'Kerala University'),(79,'Kurukshetra University'),(80,'Kuvempu University'),(81,'Lucknow University'),(82,'Madurai Kamaraj University'),(83,'Mahatma Gandhi University'),(84,'Mangalore University'),(85,'MDI,Gurgaon'),(86,'Meerut University'),(87,'Mumbai University'),(88,'Nagarjuna University'),(89,'Nagpur University'),(90,'NIFT'),(91,'NIIT'),(92,'NMIMS,Mumbai'),(93,'North Maharashtra University'),(94,'OSMANIA UNIVERSITY'),(95,'Panjab University'),(96,'Pondicherry University'),(97,'Pune University'),(98,'Punjab Technical University'),(99,'Rajasthan University'),(100,'Ranchi University'),(101,'RECs'),(102,'Sambalpur University'),(103,'Saurashtra University'),(104,'Shivaji University'),(105,'South Gujarat University,Surat'),(106,'SP Jain Institute of Management Studies'),(107,'Sri Venkateshwara University'),(108,'Symbiosis,Pune'),(109,'TA Pai Management Institute'),(110,'Tata Institute of Social Sciences'),(111,'University of Mysore'),(112,'Utkal University'),(113,'Vidyasagar University'),(114,'Visveshwaraiah University'),(115,'XIM, Bhubaneswar'),(116,'XISS,  Ranchi'),(117,'XLRI, Jamshedpur'),(118,'YMCA'),(119,'Kalyani University'),(120,'Patna University'),(121,'Chartered Accountants Institute');

/*Table structure for table `university_institute` */

DROP TABLE IF EXISTS `university_institute`;

CREATE TABLE `university_institute` (
  `COUNTRY_CODE` varchar(4) DEFAULT NULL,
  `LOCATION_ID` int(10) DEFAULT NULL,
  `university_institute_id` int(10) NOT NULL,
  `university_institute_name` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`university_institute_id`),
  KEY `FK_UNIVERSITY_INST_COUNTRY_CODE` (`COUNTRY_CODE`),
  KEY `FK_UNIVERSITY_INST_LOCATION_ID` (`LOCATION_ID`),
  CONSTRAINT `FK_UNIVERSITY_INST_COUNTRY_CODE` FOREIGN KEY (`COUNTRY_CODE`) REFERENCES `country_name` (`COUNTRY_CODE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_UNIVERSITY_INST_LOCATION_ID` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location_name` (`LOCATION_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `university_institute` */

insert into `university_institute` (`COUNTRY_CODE`,`LOCATION_ID`,`university_institute_id`,`university_institute_name`) values ('IND',1,1,'Calcutta University'),('IND',1,2,'Jadavpur University'),('IND',1,3,'Rabindrabharati University'),('IND',1,4,'Burdwan University'),('IND',1,5,'Vidyasagar University'),('IND',1,6,'North Bengal University'),('IND',1,7,'West Bengal University Of Technology'),('IND',1,8,'Barasat University'),('IND',1,9,'IGNOU'),('IND',1,10,'Sikkim Manipal University'),('IND',528,11,'Ranchi University'),('IND',1,12,'Agra University'),('IND',1,13,'AIMA'),('IND',1,14,'Aligarh Muslim University'),('IND',1,15,'Allahabad University'),('IND',1,16,'Amaravati University'),('IND',1,17,'Amity Business School'),('IND',1,18,'Andhra University'),('IND',1,19,'Anna University'),('IND',1,20,'Annamalai University'),('IND',1,21,'Apeejay School of Marketing'),('IND',1,22,'APTECH'),('IND',1,23,'Banaras Hindu University'),('IND',1,24,'Bangalore University'),('IND',1,25,'Barkatullah University'),('IND',1,26,'Berhampur University'),('IND',1,27,'Bharathiar University'),('IND',1,28,'Bharathidasan University'),('IND',1,29,'BITS (Mesra)'),('IND',1,30,'BITS (Pilani)'),('IND',1,31,'Board of Technical Education'),('IND',1,32,'Calicut University'),('IND',1,33,'Chennai University'),('IND',1,34,'DAVV, Indore'),('IND',1,35,'Delhi College of Engineering'),('IND',1,36,'Delhi University'),('IND',1,37,'Devi Ahilya University'),('IND',1,38,'DOEACC'),('IND',1,39,'FMS,Delhi'),('IND',1,40,'Fore School of Management'),('IND',1,41,'Goa Institute of Management'),('IND',1,42,'Goa University'),('IND',1,43,'Gujarat University'),('IND',1,44,'Gulbarga University'),('IND',1,45,'Hyderabad University'),('IND',1,46,'ICFAI'),('IND',1,47,'ICSI'),('IND',1,48,'ICWA'),('IND',1,49,'IIM, Ahmedabad'),('IND',1,50,'IIM, Bangalore'),('IND',1,51,'IIM, Calcutta'),('IND',1,52,'IIM, Indore'),('IND',1,53,'IIM, Kozhikode'),('IND',1,54,'IIM, Lucknow'),('IND',1,55,'IIPM'),('IND',1,56,'IISWBM, Calcutta'),('IND',1,57,'IIT,Chennai'),('IND',1,58,'IIT,Delhi'),('IND',1,59,'IIT,Guwahati'),('IND',1,60,'IIT,Kanpur'),('IND',1,61,'IIT,Kharagpur'),('IND',1,62,'IIT,Mumbai'),('IND',1,63,'IIT,Roorkee'),('IND',1,64,'IMI, Delhi'),('IND',1,65,'IMT,Ghaziabad'),('IND',1,66,'Indian Institute of Foreign Trade'),('IND',1,67,'Indian Institute of Science'),('IND',1,68,'Indian Statistical Institute'),('IND',1,69,'Institute of Chartered Accountants of India'),('IND',1,70,'IRM, Anand'),('IND',1,71,'IT,BHU'),('IND',1,72,'Jamia Millia Islamia'),('IND',1,73,'Jawaharlal Nehru University'),('IND',1,74,'Jiwaji University'),('IND',1,75,'JNTU,Hyderabad'),('IND',1,76,'Kakatiya University'),('IND',1,77,'Kanpur University'),('IND',1,78,'Karanataka University'),('IND',1,79,'Kerala University'),('IND',1,80,'Kurukshetra University'),('IND',1,81,'Kuvempu University'),('IND',1,82,'Lucknow University'),('IND',1,83,'Madurai Kamaraj University'),('IND',1,84,'Mahatma Gandhi University'),('IND',1,85,'Mangalore University'),('IND',1,86,'MDI,Gurgaon'),('IND',1,87,'Meerut University'),('IND',1,88,'Mumbai University'),('IND',1,89,'Nagarjuna University'),('IND',1,90,'Nagpur University'),('IND',1,91,'NIFT'),('IND',1,92,'NIIT'),('IND',1,93,'NMIMS,Mumbai'),('IND',1,94,'North Maharashtra University'),('IND',1,95,'OSMANIA UNIVERSITY'),('IND',1,96,'Panjab University'),('IND',1,97,'Pondicherry University'),('IND',1,98,'Pune University'),('IND',1,99,'Punjab Technical University'),('IND',1,100,'Rajasthan University'),('IND',1,101,'Ranchi University'),('IND',1,102,'RECs'),('IND',1,103,'Sambalpur University'),('IND',1,104,'Saurashtra University'),('IND',1,105,'Shivaji University'),('IND',1,106,'South Gujarat University,Surat'),('IND',1,107,'SP Jain Institute of Management Studies'),('IND',1,108,'Sri Venkateshwara University'),('IND',1,109,'Symbiosis,Pune'),('IND',1,110,'TA Pai Management Institute'),('IND',1,111,'Tata Institute of Social Sciences'),('IND',1,112,'University of Mysore'),('IND',1,113,'Utkal University'),('IND',1,114,'Vidyasagar University'),('IND',1,115,'Visveshwaraiah University'),('IND',1,116,'XIM, Bhubaneswar'),('IND',1,117,'XISS,  Ranchi'),('IND',1,118,'XLRI, Jamshedpur'),('IND',1,119,'YMCA'),('IND',NULL,120,'Kalyani University'),('IND',458,121,'Patna University'),(NULL,NULL,122,'Chartered Accountants Institute'),(NULL,NULL,123,'SSS');

/*Table structure for table `user_profile` */

DROP TABLE IF EXISTS `user_profile`;

CREATE TABLE `user_profile` (
  `user_id` int(10) NOT NULL,
  `user_name` varchar(40) DEFAULT NULL,
  `user_password` varchar(40) DEFAULT NULL,
  `user_call_name` varchar(40) NOT NULL,
  `user_role` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_profile` */

insert into `user_profile` (`user_id`,`user_name`,`user_password`,`user_call_name`,`user_role`) values (1,'manasi','manasi@1978','Manasi Das(Halder)','Proprietor'),(2,'alok','alok@1978','Alok Halder','HR Manager'),(3,'priyanka','priya123456','Priyanka Debnath','Content Writer'),(4,'tonmoy','tonmoy','Tonmoy','0'),(5,'sankar','sankar','Sankar Barui','0'),(6,'dipak','dipakmca','Dipak Maity','Mentor'),(7,'shekhar','siliguri@72','Shekhar Kr. Saha','Center In Charge (Siliguri)'),(101,'dipayan','dipayan','Dipayan Dasgupta','Software Developer'),(102,'amzad','9830526322','Amzad','0'),(103,'rajasree','rajasree001@2','Rajasree Chakroborty','Receptionist'),(104,'pradipta','7878','Pradipta Majumder','Software Developer'),(105,'pritam','jackeyRony','Pritam Mukherjee','Software Developer'),(106,'pankaj','pankaj','Pankaj Ghosh','Software Developer'),(107,'masud','masud','Masud Ahmed Khan','Software Developer'),(108,'suvendu','statebank','Suvendu Acharyya','Software Developer'),(109,'chandan','1212','Chandan Kumar Sasmal','Software Developer'),(110,'debashis','shibpur@89','Debashis Sheet','Software Developer'),(111,'bandana','hooghly','Bandana Chakrabarti','Software Developer'),(112,'joydeb','mca@4123','Joydeb','Software Developer'),(113,'vivek','vivek@3214','Vivek','Software Developer'),(114,'bhaskar','bhaskar@6854','Bhaskar','Software Developer'),(115,'santosh','santosh@9867','Santosh','Software Developer'),(116,'abhishek','abhi#54','Abhishek','Software Developer'),(117,'sushama','sush@2891','Sushama Dhar','Senior Software Developer'),(118,'jeet','inconsolable123','Jeet','Software Developer'),(119,'madhurima','m1989*','Madhurima Dutta','HR Manager'),(120,'Avidipta Ghosh','Kolkata@2012','Avidipta','Software Developer'),(121,'Somnath','Kolkata@2012','Somnath','Software Developer'),(122,'Nilanjan','Kolkata@2012','Nilanjan Dasgupta','Software Developer'),(123,'barun','Kolkata@2012','Barun Roy','Software Developer'),(124,'sanando','Kolkata@2012','Sanando Banerjee','Software Developer'),(125,'uttam','uttam','Uttam Das','Software Developer'),(126,'Siligury_admin','1234','Siligury_admin','Administrator Siligury'),(127,'Kolkata_admin','5678','Kolkata_admin','Administrator Kolkata'),(128,NULL,'123','Palash','4'),(130,NULL,'1234','cccccccc','2'),(131,NULL,'1234','cccccccc','2'),(132,NULL,'1234','Jevan Deep','3'),(162,NULL,'sreyashi','Sreyashi Das','1'),(164,NULL,'1234','Sanando Banerjee','3'),(169,NULL,'Kolkata@2012','Sanando','3'),(170,NULL,'12345','Sanando Bane','1'),(171,NULL,'1234','Sanando banerj','3'),(172,NULL,'1234','Pankaj Ghosh','4'),(176,NULL,'fdf','dff','2'),(178,'uttamdas','123','Uttam Das','1'),(179,NULL,'sameep','sameep','7'),(180,NULL,'aaaa','aaaaa','2'),(181,NULL,'aaa','aaa','1'),(182,NULL,'aaa','aaa','1'),(183,NULL,'aaa','aaa','1'),(184,NULL,'fff','fff','1'),(185,NULL,'1234','sanandoaaa','1'),(186,NULL,'1234','Sanando Banerjee','3'),(187,NULL,'aaaa','aaaa','1'),(188,NULL,'kk','aa','3'),(189,NULL,'kk','aa','1'),(190,NULL,'12345','Sanando','3'),(191,NULL,'1234','amrita kundu','1'),(209,NULL,'fdghfdh','Cgbfd','3');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
