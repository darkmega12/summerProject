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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (1,'Bernales','Mayrein','Ramos','7831805','09169804710','1991-01-30','Female','2010-05-17','Deployed',5,1123,'Apple','Quezon'),(2,'Agrigar','Vanessa','Campos','4143327','09087396178','1987-12-15','Female','2005-04-12','Discontinued',6,2120,'Mango','Manila'),(3,'Liberato','Erlinda','','9278939','09157839252','1984-02-29','Female','2014-03-26','Application',7,1984,'Peach','Caloocan'),(4,'Morales','Donabel','Eustaquio','9359873','09167839244','1979-05-20','Female','2007-02-10','Ready for Deployment',8,1464,'Strawberry','Navotas'),(5,'Reyes','Karina','Cabral','9848274','09183849245','1980-03-10','Female','2001-01-23','Company Screening',9,1375,'Orange','Malabon'),(6,'Uytengsu','Martin','Eusebio','9535731','09335678584','1978-04-27','Male','2013-06-10','Application',11,1235,'Lemon','Quezon');
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
  `idCourse` int(11) NOT NULL,
  `agentCount` int(11) NOT NULL,
  `startingDate` date NOT NULL,
  `endingDate` date NOT NULL,
  `startTime` varchar(45) NOT NULL,
  `endTime` varchar(45) NOT NULL,
  `schedule` varchar(45) NOT NULL,
  `venue` varchar(45) NOT NULL,
  `classStatus` varchar(45) NOT NULL,
  PRIMARY KEY (`idClass`),
  KEY `fk_Class_Course1` (`idCourse`),
  CONSTRAINT `fk_Class_Course1` FOREIGN KEY (`idCourse`) REFERENCES `course` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,2,20,'2014-01-08','2014-04-17','09:40','12:40','MWF','A1007','Full'),(2,2,5,'2014-01-09','2014-04-18','08:00','11:00','TH','A903','Dissolved'),(3,2,15,'2014-01-10','2014-04-19','13:30','16:30','MWF','A905','Free'),(4,3,20,'2014-01-08','2014-04-17','14:00','17:00','MWF','G201','Full'),(5,3,10,'2014-01-09','2014-04-18','15:00','18:00','TH','G202','Dissolved'),(6,4,9,'2014-01-10','2014-04-19','08:00','13:00','MWF','G203','Dissolved'),(7,5,6,'2014-01-08','2014-04-17','13:15','20:15','MWF','G204','Dissolved'),(8,5,19,'2014-01-09','2014-04-18','13:10','20:10','TH','G205','Free'),(9,5,17,'2014-01-10','2014-04-19','13:05','20:05','MWF','G206','Free'),(10,5,12,'2014-01-08','2014-04-17','13:20','20:20','MWF','G207','Free'),(11,5,11,'2014-01-09','2014-04-18','08:10','15:10','TH','G208','Free'),(12,5,10,'2014-01-10','2014-04-19','08:00','15:00','MWF','G209','Free'),(13,5,13,'2014-01-09','2014-04-18','08:15','15:15','TH','G210','Free'),(14,5,16,'2014-01-10','2014-04-19','08:20','15:20','MWF','G211','Free');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'TeleTech',1113,'09158723467','2000-02-10','On Going',12,'Bonifacio High','Taguig'),(2,'Telus',1101,'09158972838','2001-03-27','Discontinued',13,'Bel-Air','Makati'),(3,'Convergys',1100,'09328759532','2002-04-28','On Going',14,'Paseo De Roxas','Makati'),(4,'Sitel',1102,'09338583759','2004-05-03','Discontinued',15,'Metropolitan','Makati'),(5,'StarTek',1103,'09158375672','2010-06-23','On Going',16,'V.A Rufino','Makati'),(6,'Teleperformance',1104,'09167375925','2011-07-27','On Going',17,'E.P Leviste','Makati'),(7,'Sykes',1112,'09274739656','2006-08-23','On Going',18,'Salcedo','Makati');
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
  `courseDescription` varchar(100) NOT NULL,
  `courseCode` varchar(7) NOT NULL,
  `courseName` varchar(45) NOT NULL,
  `hourCount` int(2) NOT NULL,
  PRIMARY KEY (`idCourse`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'The student completed his/her list of courses','ISFINAL','Finalized All Courses',0),(2,'The course covers the basics for fluent English Communication such as grammar.','ENGLCOM','English Communication Skills',3),(3,'The course covers the basics for customer care protocols used in call center companies.','CUSTCOM','Customer Care',3),(4,'The course covers the computer operations used in a call center company such as Microsoft Word.','COMOPER','Computer Operations',5),(5,'The course covers the products and services of a specific company. ','BUSOPER','Business Operations',7);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educationbg`
--

LOCK TABLES `educationbg` WRITE;
/*!40000 ALTER TABLE `educationbg` DISABLE KEYS */;
INSERT INTO `educationbg` VALUES (1,'',2005,'Saint Joseph\'s College',1),(2,'Computer Science',2005,'Trinity University of Asia',2),(3,'Marketing',2002,'San Beda College',3),(4,'Business Administration',2003,'Far Eastern University',4),(5,'',1995,'Saint Paul University',5),(6,'Tourism',1997,'Centro Escolar University',6);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,2.5,1,3),(2,3,4,3),(3,3.5,3,6),(4,1,4,6);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobopening`
--

LOCK TABLES `jobopening` WRITE;
/*!40000 ALTER TABLE `jobopening` DISABLE KEYS */;
INSERT INTO `jobopening` VALUES (1,'2014-01-08','2014-02-08','2014-01-10','Completed','Male',20,1),(2,'2014-05-03','2014-06-03','0000-00-00','Selecting by Ecall','Female',15,2),(3,'2014-02-04','2014-02-19','0000-00-00','Screening by Company','Male, Female',10,3),(4,'2013-02-11','2013-02-25','0000-00-00','Cancelled','Female',5,4),(5,'2012-03-28','2012-04-28','2012-04-15','Completed','Male, Female',6,5),(6,'2014-04-20','2014-06-20','0000-00-00','New','Male',30,6),(7,'2014-05-17','2014-07-17','0000-00-00','New','Female',50,7);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listcourses`
--

LOCK TABLES `listcourses` WRITE;
/*!40000 ALTER TABLE `listcourses` DISABLE KEYS */;
INSERT INTO `listcourses` VALUES (1,1,1),(2,1,2),(3,2,3),(4,3,3),(5,4,3),(6,5,3),(7,1,4),(8,1,5),(9,2,6),(10,3,6);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,4,1),(2,1.5,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'bao.fang','password','Registrar'),(2,'yolanda.basilio','password','Registrar'),(3,'leogildo.garcia','password','Registrar'),(4,'chiara.delapaz','password','Admin'),(5,'mayrein.bernales','password','Agent'),(6,'vanessa.agrigar','password','Agent'),(7,'erlinda.liberato','password','Agent'),(8,'donabel.morales','password','Agent'),(9,'karina.reyes','password','Agent'),(10,'shery.perez','password','Registrar'),(11,'martin.uytengsu','password','Agent'),(12,'teletech_1113','password','Company'),(13,'telus_1101','password','Company'),(14,'convergys_1100','password','Company'),(15,'sitel_1102','password','Company'),(16,'startek_1103','password','Company'),(17,'teleperformance_1104','password','Company'),(18,'sykes_1112','password','Company');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workexperience`
--

LOCK TABLES `workexperience` WRITE;
/*!40000 ALTER TABLE `workexperience` DISABLE KEYS */;
INSERT INTO `workexperience` VALUES (1,'2014-01-10',2,20000,1,1),(2,'2012-04-16',2,15000,5,2),(3,'2012-04-16',1,10000,5,1);
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

-- Dump completed on 2014-05-18  4:05:23
