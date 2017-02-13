/*
SQLyog Community v11.52 (64 bit)
MySQL - 5.6.35-log : Database - school
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`school` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `school`;

/*Table structure for table `academicyear` */

DROP TABLE IF EXISTS `academicyear`;

CREATE TABLE `academicyear` (
  `academicYearID` int(11) NOT NULL,
  `academicYearName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`academicYearID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `academicyear` */

insert  into `academicyear`(`academicYearID`,`academicYearName`) values (1,'2011-2012'),(2,'2012-2013'),(3,'2013-2014'),(4,'2014-2015'),(5,'2015-2016'),(6,'2016-2017'),(7,'2017-2018');

/*Table structure for table `admission` */

DROP TABLE IF EXISTS `admission`;

CREATE TABLE `admission` (
  `rollNumber` int(11) NOT NULL,
  `classRoomID` bigint(20) DEFAULT NULL,
  `studID` int(11) DEFAULT NULL,
  PRIMARY KEY (`rollNumber`),
  KEY `FK791437E98C60A1CE` (`classRoomID`),
  KEY `FK791437E93F887FF3` (`studID`),
  CONSTRAINT `FK791437E93F887FF3` FOREIGN KEY (`studID`) REFERENCES `student` (`studID`),
  CONSTRAINT `FK791437E98C60A1CE` FOREIGN KEY (`classRoomID`) REFERENCES `classroom` (`classRoomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admission` */

insert  into `admission`(`rollNumber`,`classRoomID`,`studID`) values (1011001,1011,4),(1011002,1011,5),(1011003,1011,6),(1041001,1041,1),(1041002,1041,2),(1041003,1041,3),(1041004,1041,7),(1041005,1041,8);

/*Table structure for table `classroom` */

DROP TABLE IF EXISTS `classroom`;

CREATE TABLE `classroom` (
  `classRoomID` bigint(20) NOT NULL,
  `academicYearID` int(11) DEFAULT NULL,
  `divisionID` int(11) DEFAULT NULL,
  `roomID` int(11) DEFAULT NULL,
  `stdID` int(11) DEFAULT NULL,
  PRIMARY KEY (`classRoomID`),
  KEY `FK76DD425367F16EE` (`stdID`),
  KEY `FK76DD42531D6C3F44` (`roomID`),
  KEY `FK76DD425362A820E8` (`divisionID`),
  KEY `FK76DD4253C9E00BF6` (`academicYearID`),
  CONSTRAINT `FK76DD42531D6C3F44` FOREIGN KEY (`roomID`) REFERENCES `room` (`roomID`),
  CONSTRAINT `FK76DD425362A820E8` FOREIGN KEY (`divisionID`) REFERENCES `division` (`divisionID`),
  CONSTRAINT `FK76DD425367F16EE` FOREIGN KEY (`stdID`) REFERENCES `standard` (`stdID`),
  CONSTRAINT `FK76DD4253C9E00BF6` FOREIGN KEY (`academicYearID`) REFERENCES `academicyear` (`academicYearID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `classroom` */

insert  into `classroom`(`classRoomID`,`academicYearID`,`divisionID`,`roomID`,`stdID`) values (1011,1,1,101,1),(1021,1,1,102,2),(1031,1,1,103,3),(1041,1,1,104,4),(1042,1,2,105,4);

/*Table structure for table `classroom_subject` */

DROP TABLE IF EXISTS `classroom_subject`;

CREATE TABLE `classroom_subject` (
  `classRoomID` bigint(20) NOT NULL,
  `subjectDetailID` int(11) NOT NULL,
  PRIMARY KEY (`classRoomID`,`subjectDetailID`),
  KEY `FK811DD32096937522` (`subjectDetailID`),
  KEY `FK811DD3208C60A1CE` (`classRoomID`),
  CONSTRAINT `FK811DD3208C60A1CE` FOREIGN KEY (`classRoomID`) REFERENCES `classroom` (`classRoomID`),
  CONSTRAINT `FK811DD32096937522` FOREIGN KEY (`subjectDetailID`) REFERENCES `subjectdetail` (`subjectDetailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `classroom_subject` */

insert  into `classroom_subject`(`classRoomID`,`subjectDetailID`) values (1011,101),(1041,101),(1011,201),(1041,201),(1011,301),(1041,301),(1011,401),(1041,401),(1041,402),(1011,501),(1041,501),(1041,502),(1011,601),(1041,601),(1041,602),(1041,603);

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `countryID` int(11) NOT NULL,
  `countryName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`countryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `country` */

insert  into `country`(`countryID`,`countryName`) values (1,'INDIA'),(2,'US'),(3,'UK'),(4,'GERMANY');

/*Table structure for table `district` */

DROP TABLE IF EXISTS `district`;

CREATE TABLE `district` (
  `districtID` int(11) NOT NULL,
  `districtName` varchar(50) DEFAULT NULL,
  `stateID` int(11) DEFAULT NULL,
  PRIMARY KEY (`districtID`),
  KEY `FK151397AECCD8212A` (`stateID`),
  CONSTRAINT `FK151397AECCD8212A` FOREIGN KEY (`stateID`) REFERENCES `state` (`stateID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `district` */

insert  into `district`(`districtID`,`districtName`,`stateID`) values (1,'PUNE',1),(2,'KOLHAPUR',1),(3,'SANGLI',1),(4,'SATARA',1),(5,'SOLAPUR',1),(6,'AHAMED NAGAR',1),(7,'RAIGAD',1),(8,'NASHIK',1),(9,'NAGPUR',1),(10,'LATUR',1);

/*Table structure for table `division` */

DROP TABLE IF EXISTS `division`;

CREATE TABLE `division` (
  `divisionID` int(11) NOT NULL,
  `divisionName` varchar(10) NOT NULL,
  PRIMARY KEY (`divisionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `division` */

insert  into `division`(`divisionID`,`divisionName`) values (1,'A'),(2,'B'),(3,'C'),(4,'D');

/*Table structure for table `exam` */

DROP TABLE IF EXISTS `exam`;

CREATE TABLE `exam` (
  `examID` int(11) NOT NULL,
  `examName` varchar(50) NOT NULL,
  PRIMARY KEY (`examID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exam` */

insert  into `exam`(`examID`,`examName`) values (1,'UNIT TEST I'),(2,'UNIT TEST II'),(3,'SEMISTER I'),(4,'UNIT TEST III'),(5,'UNIT TEST IV'),(6,'SEMISTER II');

/*Table structure for table `examdetail` */

DROP TABLE IF EXISTS `examdetail`;

CREATE TABLE `examdetail` (
  `examDetailID` int(11) NOT NULL,
  `examDetailName` varchar(50) NOT NULL,
  `academicYearID` int(11) DEFAULT NULL,
  `examID` int(11) DEFAULT NULL,
  PRIMARY KEY (`examDetailID`),
  KEY `FKB407C5707AFECCC` (`examID`),
  KEY `FKB407C570C9E00BF6` (`academicYearID`),
  CONSTRAINT `FKB407C5707AFECCC` FOREIGN KEY (`examID`) REFERENCES `exam` (`examID`),
  CONSTRAINT `FKB407C570C9E00BF6` FOREIGN KEY (`academicYearID`) REFERENCES `academicyear` (`academicYearID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `examdetail` */

insert  into `examdetail`(`examDetailID`,`examDetailName`,`academicYearID`,`examID`) values (1101,'UNIT TEST I 2011-2012',1,1);

/*Table structure for table `examform` */

DROP TABLE IF EXISTS `examform`;

CREATE TABLE `examform` (
  `seatNumber` int(11) NOT NULL,
  `examDetailID` int(11) DEFAULT NULL,
  `rollNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`seatNumber`),
  KEY `FK774475A3214FF08E` (`examDetailID`),
  KEY `FK774475A37FA96EBC` (`rollNumber`),
  CONSTRAINT `FK774475A3214FF08E` FOREIGN KEY (`examDetailID`) REFERENCES `examdetail` (`examDetailID`),
  CONSTRAINT `FK774475A37FA96EBC` FOREIGN KEY (`rollNumber`) REFERENCES `admission` (`rollNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `examform` */

insert  into `examform`(`seatNumber`,`examDetailID`,`rollNumber`) values (11041001,1101,1041001),(11041002,1101,1041002),(11041003,1101,1041003),(11041004,1101,1041004),(11041005,1101,1041005);

/*Table structure for table `examresult` */

DROP TABLE IF EXISTS `examresult`;

CREATE TABLE `examresult` (
  `resultID` int(11) NOT NULL AUTO_INCREMENT,
  `marksObtained` int(11) DEFAULT NULL,
  `examTxnID` int(11) DEFAULT NULL,
  `seatNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`resultID`),
  KEY `FKCBEB753C781C8CC4` (`seatNumber`),
  KEY `FKCBEB753CCE4A4072` (`examTxnID`),
  CONSTRAINT `FKCBEB753C781C8CC4` FOREIGN KEY (`seatNumber`) REFERENCES `examform` (`seatNumber`),
  CONSTRAINT `FKCBEB753CCE4A4072` FOREIGN KEY (`examTxnID`) REFERENCES `examtransaction` (`examTxnID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `examresult` */

insert  into `examresult`(`resultID`,`marksObtained`,`examTxnID`,`seatNumber`) values (12,80,2,11041001),(13,78,3,11041001),(14,95,2,11041002),(15,95,3,11041002),(16,80,2,11041003),(17,89,3,11041003),(18,46,2,11041004),(19,50,3,11041004),(20,65,2,11041005),(21,68,3,11041005);

/*Table structure for table `examtransaction` */

DROP TABLE IF EXISTS `examtransaction`;

CREATE TABLE `examtransaction` (
  `examTxnID` int(11) NOT NULL,
  `examTxnDate` date NOT NULL,
  `examTxnEndTime` time NOT NULL,
  `examTxnMaxMarks` int(11) NOT NULL,
  `examTxnMinMarks` int(11) NOT NULL,
  `examTxnStartTime` time NOT NULL,
  `classRoomID` bigint(20) DEFAULT NULL,
  `examDetailID` int(11) DEFAULT NULL,
  `subjectDetailID` int(11) DEFAULT NULL,
  PRIMARY KEY (`examTxnID`),
  KEY `FKA16D811F96937522` (`subjectDetailID`),
  KEY `FKA16D811F214FF08E` (`examDetailID`),
  KEY `FKA16D811F8C60A1CE` (`classRoomID`),
  CONSTRAINT `FKA16D811F214FF08E` FOREIGN KEY (`examDetailID`) REFERENCES `examdetail` (`examDetailID`),
  CONSTRAINT `FKA16D811F8C60A1CE` FOREIGN KEY (`classRoomID`) REFERENCES `classroom` (`classRoomID`),
  CONSTRAINT `FKA16D811F96937522` FOREIGN KEY (`subjectDetailID`) REFERENCES `subjectdetail` (`subjectDetailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `examtransaction` */

insert  into `examtransaction`(`examTxnID`,`examTxnDate`,`examTxnEndTime`,`examTxnMaxMarks`,`examTxnMinMarks`,`examTxnStartTime`,`classRoomID`,`examDetailID`,`subjectDetailID`) values (1,'2011-10-14','05:30:00',100,35,'02:30:00',1011,1101,101),(2,'2011-11-17','01:30:00',100,35,'10:30:00',1041,1101,101),(3,'2011-11-17','05:30:00',100,35,'02:30:00',1041,1101,201);

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `roomID` int(11) NOT NULL AUTO_INCREMENT,
  `roomName` varchar(50) DEFAULT NULL,
  `roomStrength` int(11) DEFAULT NULL,
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

/*Data for the table `room` */

insert  into `room`(`roomID`,`roomName`,`roomStrength`) values (101,'SHIVNERI',40),(102,'TORANA',40),(103,'KONDHANA',40),(104,'RAIGAD',40),(105,'RAJGAD',40),(106,'PURANDAR',40),(107,'RAJMACHI',40);

/*Table structure for table `standard` */

DROP TABLE IF EXISTS `standard`;

CREATE TABLE `standard` (
  `stdID` int(11) NOT NULL,
  `stdName` varchar(15) NOT NULL,
  `stdStrength` int(11) NOT NULL,
  PRIMARY KEY (`stdID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `standard` */

insert  into `standard`(`stdID`,`stdName`,`stdStrength`) values (1,'I ST',40),(2,'II ND',40),(3,'III RD',40),(4,'IV TH',40),(5,'V TH',40),(6,'VI TH',40),(7,'VII TH',40);

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `stateID` int(11) NOT NULL,
  `stateName` varchar(50) DEFAULT NULL,
  `countryID` int(11) DEFAULT NULL,
  PRIMARY KEY (`stateID`),
  KEY `FK4C7D4716E6A82B4` (`countryID`),
  CONSTRAINT `FK4C7D4716E6A82B4` FOREIGN KEY (`countryID`) REFERENCES `country` (`countryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `state` */

insert  into `state`(`stateID`,`stateName`,`countryID`) values (1,'MAHARASHTRA',1),(2,'GUJRATH',1),(3,'KERAL',1),(4,'ANDRA PRADESH',1),(5,'PANJAB',1),(6,'KARNATAKA',1);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studID` int(11) NOT NULL,
  `studAddress1` varchar(200) NOT NULL,
  `studAddress2` varchar(200) NOT NULL,
  `studContact` varchar(50) NOT NULL,
  `studDOB` date DEFAULT NULL,
  `studEmail` varchar(50) NOT NULL,
  `studGender` char(1) NOT NULL,
  `studName` varchar(50) NOT NULL,
  `studPhotoPath` longtext NOT NULL,
  `studSignPath` longtext NOT NULL,
  `talukaID` int(11) DEFAULT NULL,
  PRIMARY KEY (`studID`),
  KEY `FKF3371A1B5C7AEDA6` (`talukaID`),
  KEY `FKF3371A1B4B1E90CA` (`studID`),
  CONSTRAINT `FKF3371A1B4B1E90CA` FOREIGN KEY (`studID`) REFERENCES `taluka` (`talukaID`),
  CONSTRAINT `FKF3371A1B5C7AEDA6` FOREIGN KEY (`talukaID`) REFERENCES `taluka` (`talukaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`studID`,`studAddress1`,`studAddress2`,`studContact`,`studDOB`,`studEmail`,`studGender`,`studName`,`studPhotoPath`,`studSignPath`,`talukaID`) values (1,'at galand','AT GALANDWADI','9960849299','1984-08-14','vikramgalande@gmail.com','M','HRITHIK ROSHAN','','',1),(2,'Taluka INDAPUR, Dist PUNE, MAHARASHTRA 413106','GALANDWADI NO 1','9960849299','1984-08-14','vikramgalande@gmail.com','M','VIKRAM KISAN GALANDE','C:\\Users\\a548191\\PERSONAL\\eSchool\\build\\web\\images\\student\\StudentPhoto2.jpeg','C:\\Users\\a548191\\PERSONAL\\eSchool\\build\\web\\images\\student\\StudentSign2.jpeg',1),(3,'Taluka GADHINGLAJ, Dist KOLHAPUR, MAHARASHTRA 416506','HASUR SASGIRI','9960849299','1982-06-03','vikramgalande@gmail.com','M','PRAVINKUMAR  KADUKAR','C:\\Users\\a548191\\PERSONAL\\eSchool\\build\\web\\images\\student\\StudentPhoto3.jpeg','C:\\Users\\a548191\\PERSONAL\\eSchool\\build\\web\\images\\student\\StudentSign3.jpeg',8),(4,'AT KOTHRUD PUNE 411038','AT KOTHRUD PUNE 411038','9922487923','1984-08-14','yashwant17_09@yahoo.com','M','YASHWANT PANDURANG GAIKWAD','','',1),(5,'AT GALANDWADI NO.1 TAL INDAPUR DIST PUNE 413106','AT DHAKWADI PUNE 411043','9960849299','1984-08-14','vikramgalande@gmail.com','M','VIKRAM KISAN GALANDE','','',1),(6,'BIBWEWADI ','AT SUPPER','9595660122','1984-08-14','bablugaikwad@gmail.com','M','NIRMALKUMAR ANKUSH GAIKWAD','','',1),(7,'AT GALANDWADI','AT GALANDWADI','9890635241','1984-08-14','shrimanges@gmail.com','M','MANGESH MADHUKAR GALANDE','','',1),(8,'Taluka INDAPUR, Dist PUNE, MAHARASHTRA 413106','GALANDWADI NO 1','9960849299','1982-09-11','vikramgalande@gmail.com','M','RANJIT P GALANDE','C:\\Users\\a548191\\PERSONAL\\eSchool\\build\\web\\images\\student\\StudentPhoto8.jpeg','C:\\Users\\a548191\\PERSONAL\\eSchool\\build\\web\\images\\student\\StudentSign8.jpeg',1);

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `subjectID` int(11) NOT NULL,
  `subjectName` varchar(50) NOT NULL,
  PRIMARY KEY (`subjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `subject` */

insert  into `subject`(`subjectID`,`subjectName`) values (1,'MARATHI'),(2,'HINDI'),(3,'ENGLISH'),(4,'MATHEMATICS'),(5,'SCIENCE'),(6,'SCOCIAL SCIENCE');

/*Table structure for table `subjectdetail` */

DROP TABLE IF EXISTS `subjectdetail`;

CREATE TABLE `subjectdetail` (
  `subjectDetailID` int(11) NOT NULL,
  `subjectDetailName` varchar(50) NOT NULL,
  `subjectID` int(11) DEFAULT NULL,
  PRIMARY KEY (`subjectDetailID`),
  KEY `FK1BD6F87D84C77060` (`subjectID`),
  CONSTRAINT `FK1BD6F87D84C77060` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`subjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `subjectdetail` */

insert  into `subjectdetail`(`subjectDetailID`,`subjectDetailName`,`subjectID`) values (101,'MARATHI',1),(201,'HINDI',2),(301,'ENGLISH',3),(401,'MATHEMATICS GEOMETRY',4),(402,'MATHEMATICS ALGEBRA',4),(501,'SCIENCE I',5),(502,'SCHENCE II',5),(601,'SCOCIAL SCIENCE',6),(602,'SCOCIAL SCIENCE II',6),(603,'SCOCIAL SCIENCE III',6);

/*Table structure for table `taluka` */

DROP TABLE IF EXISTS `taluka`;

CREATE TABLE `taluka` (
  `talukaID` int(11) NOT NULL,
  `talukaName` varchar(50) DEFAULT NULL,
  `districtID` int(11) DEFAULT NULL,
  PRIMARY KEY (`talukaID`),
  KEY `FK94E0D8AC6AAAF26A` (`districtID`),
  CONSTRAINT `FK94E0D8AC6AAAF26A` FOREIGN KEY (`districtID`) REFERENCES `district` (`districtID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `taluka` */

insert  into `taluka`(`talukaID`,`talukaName`,`districtID`) values (1,'INDAPUR',1),(2,'BARAMATI',1),(3,'DAUND',1),(4,'PURANDAR',1),(5,'JUNNAR',1),(6,'HAVELI',1),(7,'SHIRUR',1),(8,'GADHINGLAJ',2);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `teachID` int(11) NOT NULL,
  `teachAddress1` varchar(50) NOT NULL,
  `teachAddress2` varchar(50) NOT NULL,
  `teachContact` varchar(50) NOT NULL,
  `teachDOB` date DEFAULT NULL,
  `teachEmail` varchar(50) NOT NULL,
  `teachGender` char(1) NOT NULL,
  `teachName` varchar(50) NOT NULL,
  `teachPhotoPath` varchar(50) NOT NULL,
  `teachSignPath` varchar(50) NOT NULL,
  PRIMARY KEY (`teachID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(10) DEFAULT NULL,
  `userNickName` varchar(30) DEFAULT NULL,
  `userPass` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userID`,`userName`,`userNickName`,`userPass`) values (1,'admin','admin','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
