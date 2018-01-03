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
  `STAFF_ID` int(11) DEFAULT NULL,
  `LOGIN` varchar(16) NOT NULL,
  `PASSWORD` varchar(16) NOT NULL,
  `EMAIL` varchar(20) NOT NULL,
  `ISACTIVE` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`ID_AUTH`),
  UNIQUE KEY `email_UNIQUE` (`EMAIL`),
  UNIQUE KEY `LOGIN_UNIQUE` (`LOGIN`),
  UNIQUE KEY `id_auth_UNIQUE` (`STAFF_ID`),
  CONSTRAINT `AUTH_ID_PK` FOREIGN KEY (`STAFF_ID`) REFERENCES `staff` (`ID_SATFF`) ON DELETE NO ACTION ON UPDATE CASCADE
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
  `LASTNAME` varchar(20) NOT NULL,
  `FIRSTNAME` varchar(20) NOT NULL,
  `SURNAME` varchar(20) DEFAULT NULL,
  `BIRTH_DATE` date NOT NULL,
  `ADRESS` varchar(45) NOT NULL,
  `CREATE_DATE` date NOT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID_PATIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
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
  `ID_STAFF` int(11) NOT NULL,
  KEY `id_patient_prescription_fk_idx` (`IDPATIENT_PRESCRIPTION`),
  KEY `id_staff_fk_idx` (`ID_STAFF`),
  CONSTRAINT `id_patient_prescription_fk` FOREIGN KEY (`IDPATIENT_PRESCRIPTION`) REFERENCES `reception_prescription` (`ID_REC_PRESC`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_staff_fk` FOREIGN KEY (`ID_STAFF`) REFERENCES `staff` (`ID_SATFF`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `NAME_PRESCRIPTION` varchar(20) NOT NULL,
  `TYPE_PRESCRIPTION` varchar(10) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_PRESCRIPTION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
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
  `PRELIMINARY_DIAGNOSIS` varchar(60) NOT NULL,
  `ID_STAFF` int(11) NOT NULL,
  `DISCHARGE_DATE` date DEFAULT NULL,
  `FINAL_DIAGNOSIS` varchar(60) DEFAULT NULL,
  `IS_DISCHARGE` bit(1) DEFAULT b'0',
  PRIMARY KEY (`ID_RESEPTION`),
  KEY `patient_fk_idx` (`PATIENT_ID`),
  KEY `staff_fk_idx` (`ID_STAFF`),
  CONSTRAINT `patient_fk` FOREIGN KEY (`PATIENT_ID`) REFERENCES `patient` (`ID_PATIENT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staff_fk` FOREIGN KEY (`ID_STAFF`) REFERENCES `staff` (`ID_SATFF`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `ID_SATFF` int(11) NOT NULL AUTO_INCREMENT,
  `LASTNAME` varchar(20) NOT NULL,
  `FIRSTNAME` varchar(20) NOT NULL,
  `SURNAME` varchar(20) DEFAULT NULL,
  `TYPE_STAFF` varchar(10) NOT NULL,
  `CREATE_DATE` date NOT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID_SATFF`),
  UNIQUE KEY `id_staff_UNIQUE` (`ID_SATFF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-03 12:13:15
