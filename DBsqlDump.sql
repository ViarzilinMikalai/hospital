-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: hospital
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auth`
--

DROP TABLE IF EXISTS `auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth` (
  `ID_AUTH` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `USER_ROLE` varchar(45) NOT NULL DEFAULT 'NURSE',
  `ISACTIVE` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`ID_AUTH`),
  UNIQUE KEY `email_UNIQUE` (`EMAIL`),
  UNIQUE KEY `LOGIN_UNIQUE` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth`
--

LOCK TABLES `auth` WRITE;
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` VALUES (1,'ivanovw','ivanov','ivanov@ivanov.ru','ROLE_DOCTOR',''),(2,'ivanov','ivanov','iivanov@iivanov.ty','ROLE_ADMIN',''),(3,'sdfsdfsdf','sdfsdfsdf','sdfsdfsdf@sd.ty','ROLE_NURSE',''),(10,'uuuuuuu','uuuuuuu','uuuuuuu@ww.uu','ROLE_DOCTOR',''),(14,'77777777777777','77777777777777','777777@777.77777','ROLE_DOCTOR',''),(15,'Petrov','Petrov','Petrov@ww.ww','ROLE_DOCTOR',''),(16,'Vasiliev','Vasiliev','Vasiliev@ww.ww','ROLE_DOCTOR','');
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `ID_PATIENT` int(11) NOT NULL AUTO_INCREMENT,
  `LASTNAME` varchar(255) NOT NULL,
  `FIRSTNAME` varchar(255) NOT NULL,
  `SURNAME` varchar(255) DEFAULT NULL,
  `BIRTH_DATE` date DEFAULT NULL,
  `ADRESS` varchar(255) DEFAULT NULL,
  `CREATE_DATE` datetime(6) DEFAULT NULL,
  `UPDATE_DATE` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID_PATIENT`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (3,'FirstPatient','FirstPatient','FirstPatient',NULL,'asdasdasd',NULL,'2018-02-02 14:51:04.000000'),(4,'erwer','werwer','werwerwer',NULL,'sdfsdfsdfsdf',NULL,'2018-02-02 23:37:26.000000'),(5,'qqqqqq','wwwww','eeeee',NULL,'фыва',NULL,'2018-02-02 23:46:15.000000'),(9,'rrrwerwer','rrr','rrr',NULL,'rrr','2018-01-20 10:42:39.017000','2018-02-04 00:50:30.000000'),(11,'asdasd','asdasd','asdasd',NULL,'asdasd','2018-01-20 18:53:18.512000','2018-02-04 00:22:07.000000'),(12,'asd','asd','asd',NULL,'asd','2018-01-20 18:53:28.368000','2018-01-25 23:37:28.503000'),(15,'ccccccc','ccccccc','ccccccc',NULL,'ccccccc','2018-02-01 17:07:26.000000',NULL);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription` (
  `ID_PRESCRIPTION` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_PRESCRIPTION` varchar(255) NOT NULL,
  `TYPE_PRESCRIPTION` varchar(10) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_PRESCRIPTION`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,'Bla bla','MEDICAMENT','bla bla bla'),(2,'Bla bla2','MEDICAMENT','PROCEDURE'),(3,'sdf sf sd fsd f','PROCEDURE','sdf sdf sdf sdf sdf '),(4,'rrrrr','OPERATION','ttttt'),(6,'yyy','MEDICAMENT','yyyy'),(7,'ertert','MEDICAMENT','ertertertert'),(8,'werwer','PROCEDURE','werwerwer'),(9,'апв паравп ','MEDICAMENT','uyiyuiyui');
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reception`
--

DROP TABLE IF EXISTS `reception`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reception` (
  `ID_RESEPTION` int(11) NOT NULL AUTO_INCREMENT,
  `PATIENT_ID` int(11) DEFAULT NULL,
  `RECEPTION_DATE` date DEFAULT NULL,
  `PRELIMINARY_DIAGNOSIS` varchar(255) NOT NULL,
  `ID_USER` int(11) DEFAULT NULL,
  `DISCHARGE_DATE` date DEFAULT NULL,
  `FINAL_DIAGNOSIS` varchar(255) DEFAULT NULL,
  `IS_DISCHARGE` bit(1) DEFAULT b'0',
  `ID_STAFF` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_RESEPTION`),
  KEY `patient_fk_idx` (`PATIENT_ID`),
  KEY `staff_fk_idx` (`ID_USER`),
  KEY `FKj8fh1m7jg9553f68uigj1noki` (`ID_STAFF`),
  CONSTRAINT `FKaunqnv1qfww4vst8j794rwthr` FOREIGN KEY (`PATIENT_ID`) REFERENCES `patient` (`ID_PATIENT`),
  CONSTRAINT `FKj8fh1m7jg9553f68uigj1noki` FOREIGN KEY (`ID_STAFF`) REFERENCES `user` (`ID_USER`),
  CONSTRAINT `FKq3y5ws6oejbfy0odhkf2bg0c4` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`),
  CONSTRAINT `patient_fk` FOREIGN KEY (`PATIENT_ID`) REFERENCES `patient` (`ID_PATIENT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staff_fk` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reception`
--

LOCK TABLES `reception` WRITE;
/*!40000 ALTER TABLE `reception` DISABLE KEYS */;
INSERT INTO `reception` VALUES (1,3,NULL,'вапвапвапвапвапва',15,'2018-02-03','sfsdf','',NULL),(3,4,NULL,'ааа',15,NULL,'','\0',NULL),(4,5,NULL,'вапвап',15,NULL,'','\0',NULL),(12,12,NULL,'sdfdfsdfsdf',13,NULL,'','\0',NULL),(13,12,NULL,'вапва',14,NULL,'цукцукцук','',NULL),(14,4,NULL,'asdasdasd',13,NULL,'сачпрапрапр','',NULL),(15,9,NULL,'ttttttttttt',15,'2018-02-03','вапвап','',NULL);
/*!40000 ALTER TABLE `reception` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reception_prescription`
--

DROP TABLE IF EXISTS `reception_prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reception_prescription` (
  `ID_REC_PRESC` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PRESCRIPTION` int(11) DEFAULT NULL,
  `ID_RECEPTION` int(11) DEFAULT NULL,
  `PRESCRIPTION_DATE` date DEFAULT NULL,
  `IS_EXECUTED` bit(1) DEFAULT b'0',
  `EXECUTION_DATE` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID_REC_PRESC`),
  UNIQUE KEY `idpatient_prescription_UNIQUE` (`ID_REC_PRESC`),
  KEY `id_receptiont_fk_idx` (`ID_RECEPTION`),
  KEY `FKvxjptssus8ylohnikjvhehyr` (`ID_PRESCRIPTION`),
  CONSTRAINT `FK9niv4glpmnyjl5ksq5v5fytto` FOREIGN KEY (`ID_RECEPTION`) REFERENCES `reception` (`ID_RESEPTION`),
  CONSTRAINT `FKvxjptssus8ylohnikjvhehyr` FOREIGN KEY (`ID_PRESCRIPTION`) REFERENCES `prescription` (`ID_PRESCRIPTION`),
  CONSTRAINT `id_reception_fk` FOREIGN KEY (`ID_RECEPTION`) REFERENCES `reception` (`ID_RESEPTION`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reception_prescription`
--

LOCK TABLES `reception_prescription` WRITE;
/*!40000 ALTER TABLE `reception_prescription` DISABLE KEYS */;
INSERT INTO `reception_prescription` VALUES (4,1,1,NULL,'','2018-02-03 00:00:00.000000'),(5,1,3,NULL,'','2018-02-03 00:00:00.000000'),(8,1,4,NULL,'','2018-02-03 00:00:00.000000'),(21,6,1,'2018-02-03','\0',NULL),(22,1,12,'2018-02-03','','2018-02-03 00:00:00.000000'),(23,1,13,'2018-02-03','','2018-02-04 00:00:00.000000'),(24,4,4,'2018-02-03','\0',NULL),(25,3,4,'2018-02-03','','2018-02-03 00:00:00.000000'),(26,1,4,'2018-02-03','','2018-02-04 00:00:00.000000'),(27,1,4,'2018-02-03','\0',NULL),(28,1,4,'2018-02-03','\0',NULL),(29,2,4,'2018-02-03','\0',NULL),(30,1,4,'2018-02-03','\0',NULL),(31,1,4,'2018-02-03','\0',NULL),(32,1,4,'2018-02-03','\0',NULL),(33,1,4,'2018-02-03','\0',NULL),(34,1,4,'2018-02-03','\0',NULL),(35,4,14,'2018-02-03','\0',NULL),(36,1,15,NULL,'','2018-02-04 00:00:00.000000'),(37,8,1,'2018-02-03','\0',NULL),(38,9,4,NULL,'\0',NULL),(39,1,3,'2018-02-03','','2018-02-04 00:00:00.000000'),(40,1,12,'2018-02-04','\0',NULL);
/*!40000 ALTER TABLE `reception_prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT,
  `LASTNAME` varchar(45) NOT NULL,
  `FIRSTNAME` varchar(45) NOT NULL,
  `SURNAME` varchar(45) DEFAULT NULL,
  `CREATEDATE` datetime(6) NOT NULL,
  `UPDATEDATE` datetime(6) DEFAULT NULL,
  `ID_AUTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_USER`),
  UNIQUE KEY `ID_AUTH_UNIQUE` (`ID_AUTH`),
  UNIQUE KEY `UK_onr123laryxgyu4or2dr53vce` (`ID_AUTH`),
  CONSTRAINT `AUTH_ID_FK` FOREIGN KEY (`ID_AUTH`) REFERENCES `auth` (`ID_AUTH`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK90f0n4b8stk79m9re5eq69uc0` FOREIGN KEY (`ID_AUTH`) REFERENCES `auth` (`ID_AUTH`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ivanovw','Ivan','Ivanovich','2018-01-22 12:34:38.757000','2018-01-30 13:39:57.000000',1),(2,'веквукпвап','вапвапвап','tttttttttttttt','2018-01-22 12:37:11.159000','2018-02-04 00:21:31.000000',2),(3,'sdfsdfsdf','sdfsdfsdf','sdfsdfsdf','2018-01-24 10:40:46.802000','2018-01-24 10:43:52.217000',3),(8,'uuuuuuu','uuuuuuu','uuuuuuu','2018-01-24 11:09:07.110000','2018-02-01 21:17:28.000000',10),(13,'77777777777777','77777777777777','77777777777777','2018-01-25 23:19:42.907000','2018-02-01 21:32:21.000000',14),(14,'Petrov','Petr','Petrovich','2018-02-02 17:42:22.000000','2018-02-02 17:49:04.000000',15),(15,'Vasiliev','Vasili','Vasilievich','2018-02-02 17:48:45.000000','2018-02-03 06:36:10.000000',16);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-04 11:53:06
