-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: ncp
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `preference_information`
--

DROP TABLE IF EXISTS `preference_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preference_information` (
  `university_number` varchar(9) NOT NULL,
  `NCS_part` varchar(3) NOT NULL,
  `start_day` date NOT NULL,
  `end_day` date NOT NULL,
  `operating_method` varchar(3) NOT NULL,
  PRIMARY KEY (`university_number`),
  KEY `NCS_part` (`NCS_part`),
  KEY `operating_method` (`operating_method`),
  CONSTRAINT `preference_information_ibfk_1` FOREIGN KEY (`university_number`) REFERENCES `student` (`university_number`),
  CONSTRAINT `preference_information_ibfk_2` FOREIGN KEY (`NCS_part`) REFERENCES `ncs_part` (`code`),
  CONSTRAINT `preference_information_ibfk_3` FOREIGN KEY (`operating_method`) REFERENCES `program_operating_method` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preference_information`
--

LOCK TABLES `preference_information` WRITE;
/*!40000 ALTER TABLE `preference_information` DISABLE KEYS */;
INSERT INTO `preference_information` VALUES ('201910823','06','2022-01-12','2022-12-05','5'),('202011346','19','0000-01-01','9999-01-01','2');
/*!40000 ALTER TABLE `preference_information` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-01  4:19:50
