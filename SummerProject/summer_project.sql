CREATE DATABASE  IF NOT EXISTS `ecall` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ecall`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: ecall
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent` (
  `idAgent` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  `landline` varchar(7) NOT NULL,
  `mobile` varchar(11) NOT NULL,
  `birthDate` date NOT NULL,
  `gender` varchar(6) NOT NULL,
  `applicationDate` date NOT NULL,
  `agentStatus` varchar(45) NOT NULL,
  `idUser` int(11) NOT NULL,
  `zipCode` int(4) NOT NULL,
  `street` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY (`idAgent`),
  KEY `fk_Agent_User1` (`idUser`),
  CONSTRAINT `fk_Agent_User1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (1,'Bernales','Mayrein','Ramos','7831805','09169804710','1991-01-30','Female','2000-05-17','Deployed',5,1123,'Apple','Quezon'),(2,'Agrigar','Vanessa','Campos','4143327','09087396178','1987-12-15','Female','2005-04-12','Discontinued',6,2120,'Mango','Manila'),(3,'Liberato','Erlinda','','9278939','09157839252','1984-02-29','Female','2014-03-26','Application',7,1984,'Peach','Caloocan'),(4,'Morales','Donabel','Eustaquio','9359873','09167839244','1979-05-20','Female','2007-02-10','Ready for Deployment',8,1464,'Strawberry','Navotas'),(5,'Reyes','Karina','Cabral','9848274','09183849245','1980-03-10','Female','2001-01-23','Company Screening',9,1375,'Orange','Malabon');
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `idClass` int(11) NOT NULL AUTO_INCREMENT,
  `agentCount` int(11) NOT NULL,
  `startingDate` date NOT NULL,
  `endingDate` date NOT NULL,
  `schedule` varchar(45) NOT NULL,
  `venue` varchar(45) NOT NULL,
  `classStatus` varchar(45) NOT NULL,
  `idCourse` int(11) NOT NULL,
  PRIMARY KEY (`idClass`),
  KEY `fk_Class_Course1` (`idCourse`),
  CONSTRAINT `fk_Class_Course1` FOREIGN KEY (`idCourse`) REFERENCES `course` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `idCompany` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(45) NOT NULL,
  `zipCode` int(4) NOT NULL,
  `contactNumber` varchar(11) NOT NULL,
  `registrationDate` date NOT NULL,
  `companyStatus` varchar(45) NOT NULL,
  `idUser` int(11) NOT NULL,
  `street` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY (`idCompany`),
  KEY `fk_Company_User1` (`idUser`),
  CONSTRAINT `fk_Company_User1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `idCourse` int(11) NOT NULL AUTO_INCREMENT,
  `courseDescription` varchar(45) NOT NULL,
  `courseCode` varchar(7) NOT NULL,
  `courseName` varchar(45) NOT NULL,
  `hourCount` int(2) NOT NULL,
  PRIMARY KEY (`idCourse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educationbg`
--

DROP TABLE IF EXISTS `educationbg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educationbg` (
  `idEducationBG` int(11) NOT NULL AUTO_INCREMENT,
  `degree` varchar(45) NOT NULL,
  `yearCompletion` int(4) NOT NULL,
  `university` varchar(45) NOT NULL,
  `idAgent` int(11) NOT NULL,
  PRIMARY KEY (`idEducationBG`),
  KEY `fk_EducationBG_Agent1` (`idAgent`),
  CONSTRAINT `fk_EducationBG_Agent1` FOREIGN KEY (`idAgent`) REFERENCES `agent` (`idAgent`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educationbg`
--

LOCK TABLES `educationbg` WRITE;
/*!40000 ALTER TABLE `educationbg` DISABLE KEYS */;
/*!40000 ALTER TABLE `educationbg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `idGrade` int(11) NOT NULL AUTO_INCREMENT,
  `grade` float NOT NULL,
  `idClass` int(11) NOT NULL,
  `idAgent` int(11) NOT NULL,
  PRIMARY KEY (`idGrade`),
  KEY `fk_grade_class1_idx` (`idClass`),
  KEY `fk_grade_agent1_idx` (`idAgent`),
  CONSTRAINT `fk_grade_agent1` FOREIGN KEY (`idAgent`) REFERENCES `agent` (`idAgent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grade_class1` FOREIGN KEY (`idClass`) REFERENCES `class` (`idClass`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobopening`
--

DROP TABLE IF EXISTS `jobopening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobopening` (
  `idJobOpening` int(11) NOT NULL AUTO_INCREMENT,
  `requestDate` date NOT NULL,
  `dueDate` date NOT NULL,
  `completeDate` date NOT NULL,
  `openingStatus` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `idCompany` int(11) NOT NULL,
  PRIMARY KEY (`idJobOpening`),
  KEY `fk_JobOpening_Company1` (`idCompany`),
  CONSTRAINT `fk_JobOpening_Company1` FOREIGN KEY (`idCompany`) REFERENCES `company` (`idCompany`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobopening`
--

LOCK TABLES `jobopening` WRITE;
/*!40000 ALTER TABLE `jobopening` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobopening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listcourses`
--

DROP TABLE IF EXISTS `listcourses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listcourses` (
  `idListCourses` int(11) NOT NULL AUTO_INCREMENT,
  `idCourse` int(11) NOT NULL,
  `idAgent` int(11) NOT NULL,
  PRIMARY KEY (`idListCourses`),
  KEY `fk_ListCourses_Course1` (`idCourse`),
  KEY `fk_listcourses_agent1_idx` (`idAgent`),
  CONSTRAINT `fk_listcourses_agent1` FOREIGN KEY (`idAgent`) REFERENCES `agent` (`idAgent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ListCourses_Course1` FOREIGN KEY (`idCourse`) REFERENCES `course` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listcourses`
--

LOCK TABLES `listcourses` WRITE;
/*!40000 ALTER TABLE `listcourses` DISABLE KEYS */;
/*!40000 ALTER TABLE `listcourses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `idRating` int(11) NOT NULL AUTO_INCREMENT,
  `rating` float NOT NULL,
  `idWorkExperience` int(11) NOT NULL,
  PRIMARY KEY (`idRating`),
  KEY `fk_rating_workexperience1_idx` (`idWorkExperience`),
  CONSTRAINT `fk_rating_workexperience1` FOREIGN KEY (`idWorkExperience`) REFERENCES `workexperience` (`idWorkExperience`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrar`
--

DROP TABLE IF EXISTS `registrar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrar` (
  `idRegistrar` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idRegistrar`),
  KEY `fk_Registrar_User1` (`idUser`),
  CONSTRAINT `fk_Registrar_User1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrar`
--

LOCK TABLES `registrar` WRITE;
/*!40000 ALTER TABLE `registrar` DISABLE KEYS */;
INSERT INTO `registrar` VALUES (1,'Fang','Bao','Li',1),(2,'Basilio','Yolanda','Yu',2),(3,'Garcia','Leogildo','De Los Reyes',3),(4,'Perez','Sherry Ann','Salgado',10);
/*!40000 ALTER TABLE `registrar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `userPassword` varchar(45) NOT NULL,
  `userType` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'bao.fang','password','Registrar'),(2,'yolanda.basilio','password','Registrar'),(3,'leogildo.garcia','password','Registrar'),(4,'chiara.de.la.paz','password','Admin'),(5,'mayrein.bernales','password','Agent'),(6,'vanessa.agrigar','password','Agent'),(7,'erlinda.liberato','password','Agent'),(8,'donabel.morales','password','Agent'),(9,'karina.reyes','password','Agent'),(10,'shery.ann.perez','password','Registrar');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workexperience`
--

DROP TABLE IF EXISTS `workexperience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workexperience` (
  `idWorkExperience` int(11) NOT NULL AUTO_INCREMENT,
  `startingDate` date NOT NULL,
  `yearEffective` int(11) NOT NULL,
  `agentSalary` float NOT NULL,
  `idJobOpening` int(11) NOT NULL,
  `idAgent` int(11) NOT NULL,
  PRIMARY KEY (`idWorkExperience`),
  KEY `fk_WorkExperience_JobOpening1` (`idJobOpening`),
  KEY `fk_workexperience_agent1_idx` (`idAgent`),
  CONSTRAINT `fk_workexperience_agent1` FOREIGN KEY (`idAgent`) REFERENCES `agent` (`idAgent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_WorkExperience_JobOpening1` FOREIGN KEY (`idJobOpening`) REFERENCES `jobopening` (`idJobOpening`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workexperience`
--

LOCK TABLES `workexperience` WRITE;
/*!40000 ALTER TABLE `workexperience` DISABLE KEYS */;
/*!40000 ALTER TABLE `workexperience` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-17 14:59:30
