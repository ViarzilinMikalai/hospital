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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth`
--

LOCK TABLES `auth` WRITE;
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
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
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_PATIENT`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (2,'erwer','werwer','werwer',NULL,'ooo','2018-01-20 00:00:00.000000',NULL),(3,'werwer2','werwer2','werwer2',NULL,'asdasdasd',NULL,NULL),(4,'erwer','werwer','werwerwer',NULL,'sdfsdfsdfsdf',NULL,NULL),(5,'qqqqqq','wwwww','eeeee',NULL,'rrrrrrrrrr&#1082;',NULL,NULL),(9,'rrrwerwer','rrr','rrr',NULL,'rrr','2018-01-20 10:42:39.017000','2018-01-20 10:42:46.983000');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presc_executor`
--

DROP TABLE IF EXISTS `presc_executor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `presc_executor` (
  `IDPATIENT_PRESCRIPTION` int(11) NOT NULL,
  `ID_USER` int(11) NOT NULL,
  KEY `id_patient_prescription_fk_idx` (`IDPATIENT_PRESCRIPTION`),
  KEY `id_staff_fk_idx` (`ID_USER`),
  CONSTRAINT `id_patient_prescription_fk` FOREIGN KEY (`IDPATIENT_PRESCRIPTION`) REFERENCES `reception_prescription` (`ID_REC_PRESC`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_staff_fk` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presc_executor`
--

LOCK TABLES `presc_executor` WRITE;
/*!40000 ALTER TABLE `presc_executor` DISABLE KEYS */;
/*!40000 ALTER TABLE `presc_executor` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,'Bla bla','MEDICAMENT','bla bla bla'),(2,'Bla bla2','MEDICAMENT','PROCEDURE'),(3,'sdf sf sd fsd f','PROCEDURE','sdf sdf sdf sdf sdf '),(4,'rrrrr','OPERATION','ttttt'),(6,'yyy','MEDICAMENT','yyyy'),(7,'ertert','MEDICAMENT','ertertertert'),(8,'werwer','PROCEDURE','werwerwer');
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
  `PATIENT_ID` int(11) NOT NULL,
  `RECEPTION_DATE` date NOT NULL,
  `PRELIMINARY_DIAGNOSIS` varchar(255) NOT NULL,
  `ID_USER` int(11) NOT NULL,
  `DISCHARGE_DATE` date DEFAULT NULL,
  `FINAL_DIAGNOSIS` varchar(255) DEFAULT NULL,
  `IS_DISCHARGE` bit(1) DEFAULT b'0',
  PRIMARY KEY (`ID_RESEPTION`),
  KEY `patient_fk_idx` (`PATIENT_ID`),
  KEY `staff_fk_idx` (`ID_USER`),
  CONSTRAINT `patient_fk` FOREIGN KEY (`PATIENT_ID`) REFERENCES `patient` (`ID_PATIENT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staff_fk` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reception`
--

LOCK TABLES `reception` WRITE;
/*!40000 ALTER TABLE `reception` DISABLE KEYS */;
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
  `ID_PRESCRIPTION` int(11) NOT NULL,
  `ID_RECEPTION` int(11) NOT NULL,
  `ISCANCELL` bit(1) DEFAULT b'0',
  `PRESCRIPTION_DATE` date NOT NULL,
  PRIMARY KEY (`ID_REC_PRESC`),
  UNIQUE KEY `idpatient_prescription_UNIQUE` (`ID_REC_PRESC`),
  KEY `id_prescription_fk_idx` (`ID_PRESCRIPTION`),
  KEY `id_receptiont_fk_idx` (`ID_RECEPTION`),
  CONSTRAINT `id_prescription_fk` FOREIGN KEY (`ID_PRESCRIPTION`) REFERENCES `prescription` (`ID_PRESCRIPTION`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_reception_fk` FOREIGN KEY (`ID_RECEPTION`) REFERENCES `reception` (`ID_RESEPTION`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reception_prescription`
--

LOCK TABLES `reception_prescription` WRITE;
/*!40000 ALTER TABLE `reception_prescription` DISABLE KEYS */;
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
  `CREATEDATE` datetime NOT NULL,
  `UPDATEDATE` datetime DEFAULT NULL,
  `ID_AUTH` int(11) NOT NULL,
  PRIMARY KEY (`ID_USER`),
  UNIQUE KEY `ID_AUTH_UNIQUE` (`ID_AUTH`),
  CONSTRAINT `AUTH_ID_FK` FOREIGN KEY (`ID_AUTH`) REFERENCES `auth` (`ID_AUTH`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2018-01-20 12:40:21
