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
-- Table structure for table `recommendation_result`
--

DROP TABLE IF EXISTS `recommendation_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendation_result` (
  `code` varchar(10) NOT NULL,
  `start_day` date NOT NULL,
  `end_day` date NOT NULL,
  `university_number` varchar(9) NOT NULL,
  `capability_category` varchar(3) NOT NULL,
  `recommendation_degree` float NOT NULL,
  PRIMARY KEY (`code`,`university_number`,`start_day`,`end_day`,`capability_category`),
  KEY `code` (`code`,`start_day`,`end_day`),
  KEY `university_number` (`university_number`),
  KEY `capability_category` (`capability_category`),
  CONSTRAINT `recommendation_result_ibfk_1` FOREIGN KEY (`code`, `start_day`, `end_day`) REFERENCES `program_instance` (`code`, `start_day`, `end_day`),
  CONSTRAINT `recommendation_result_ibfk_2` FOREIGN KEY (`university_number`) REFERENCES `student` (`university_number`),
  CONSTRAINT `recommendation_result_ibfk_3` FOREIGN KEY (`capability_category`) REFERENCES `program_middle_category` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendation_result`
--

LOCK TABLES `recommendation_result` WRITE;
/*!40000 ALTER TABLE `recommendation_result` DISABLE KEYS */;
INSERT INTO `recommendation_result` VALUES ('12001','2021-03-01','2022-02-01','201910823','2',92),('12001','2021-03-01','2022-02-01','202011346','2',100),('12002','2021-04-01','2022-02-01','201910823','2',84),('12002','2021-04-01','2022-02-01','202011346','2',92),('12003','2021-12-01','2022-02-01','201910823','2',92),('12003','2021-12-01','2022-02-01','202011346','2',84),('12004','2021-05-01','2022-02-01','201910823','2',92),('12004','2021-05-01','2022-02-01','202011346','2',92),('12005','2021-05-01','2022-02-01','201910823','2',92),('12005','2021-05-01','2022-02-01','202011346','2',100),('12006','2021-05-01','2022-02-01','201910823','2',92),('12006','2021-05-01','2022-02-01','202011346','2',100),('12007','2021-05-01','2022-02-01','201910823','2',64),('12007','2021-05-01','2022-02-01','202011346','2',72),('12008','2021-05-01','2022-02-01','201910823','2',92),('12008','2021-05-01','2022-02-01','202011346','2',92),('12009','2021-05-01','2022-02-02','201910823','2',100),('12009','2021-05-01','2022-02-02','202011346','2',92),('23001','2021-05-01','2022-02-03','201910823','3',84),('23001','2021-05-01','2022-02-03','202011346','3',92),('23002','2021-05-01','2022-02-04','201910823','3',84),('23002','2021-05-01','2022-02-04','202011346','3',92),('23003','2021-05-01','2022-02-05','201910823','3',84),('23003','2021-05-01','2022-02-05','202011346','3',92),('23004','2021-05-01','2022-02-06','201910823','3',84),('23004','2021-05-01','2022-02-06','202011346','3',92),('23005','2021-05-01','2022-02-07','201910823','3',84),('23005','2021-05-01','2022-02-07','202011346','3',84),('23006','2021-05-01','2022-02-08','201910823','3',84),('23006','2021-05-01','2022-02-08','202011346','3',84),('23007','2021-05-01','2022-02-09','201910823','3',92),('23007','2021-05-01','2022-02-09','202011346','3',92),('23008','2021-05-01','2022-02-10','201910823','3',92),('23008','2021-05-01','2022-02-10','202011346','3',100),('24001','2021-05-01','2022-02-11','201910823','4',84),('24002','2021-05-01','2022-02-12','201910823','4',84),('24003','2021-04-01','2022-02-13','201910823','4',92),('24004','2021-04-02','2022-02-14','201910823','4',84),('24005','2021-04-03','2022-02-15','201910823','4',92),('24006','2021-04-04','2022-02-16','201910823','4',92),('47001','2021-03-01','2021-12-08','202011346','7',56),('47002','2021-05-01','2021-12-09','202011346','7',84),('47003','2021-05-02','2021-12-10','202011346','7',92),('47004','2021-05-03','2021-12-11','202011346','7',92),('47005','2021-05-04','2021-12-12','202011346','7',92),('47006','2021-05-05','2021-12-13','202011346','7',72);
/*!40000 ALTER TABLE `recommendation_result` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-01  4:19:53
