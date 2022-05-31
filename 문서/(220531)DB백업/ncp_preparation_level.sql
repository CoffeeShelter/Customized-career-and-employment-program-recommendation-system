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
-- Table structure for table `preparation_level`
--

DROP TABLE IF EXISTS `preparation_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preparation_level` (
  `university_number` varchar(9) NOT NULL,
  `capability_category` varchar(20) NOT NULL,
  `preparation_degree` float NOT NULL,
  `preparation_level` varchar(10) NOT NULL,
  `preparation_rank` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preparation_level`
--

LOCK TABLES `preparation_level` WRITE;
/*!40000 ALTER TABLE `preparation_level` DISABLE KEYS */;
INSERT INTO `preparation_level` VALUES ('201910823','자기이해',20.2,'보통',5),('201910823','진로탐색',16.5,'낮음',8),('201910823','진로결정',18.2,'낮음',6),('201910823','진로설계',17.3,'낮음',7),('201910823','경력개발',20.7,'낮음',4),('201910823','실무역량',21,'낮음',3),('201910823','맞춤취업',22.1,'낮음',2),('201910823','구직활동',22.2,'낮음',1),('202011346','자기이해',23.9,'높음',2),('202011346','진로탐색',22.9,'보통',7),('202011346','진로결정',21.3,'낮음',8),('202011346','진로설계',23.3,'보통',4),('202011346','경력개발',23,'낮음',5),('202011346','실무역량',23.4,'낮음',3),('202011346','맞춤취업',22.9,'낮음',6),('202011346','구직활동',23.9,'낮음',1);
/*!40000 ALTER TABLE `preparation_level` ENABLE KEYS */;
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
