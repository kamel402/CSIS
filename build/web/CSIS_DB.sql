-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: CSIS_DB
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Cars`
--

DROP TABLE IF EXISTS `Cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cars` (
  `CarID` int NOT NULL AUTO_INCREMENT,
  `Manufacturer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Model` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `YearOfManufacturing` int NOT NULL,
  `Miles` int NOT NULL,
  `Price` float NOT NULL,
  `HasAC` char(1) NOT NULL,
  `HasDVD` char(1) NOT NULL,
  `Comments` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CreationDateTime` datetime NOT NULL,
  PRIMARY KEY (`CarID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cars`
--

LOCK TABLES `Cars` WRITE;
/*!40000 ALTER TABLE `Cars` DISABLE KEYS */;
INSERT INTO `Cars` VALUES (1,'Toyota','Camery','Normal',2018,200,25000,'T','F','The car is almost new, The reasion why i want to sell it is because i have got a new one.','2021-04-22 11:17:03'),(2,'Mercedes','Metris','Van',2019,150,70000,'T','T','The van is in good shape, and its AC works fine.','2021-04-22 11:22:50'),(3,'Ford','Ford Edge','SUV',2019,24,65000,'T','T','The car is very stable when you ride it in the road.','2021-04-22 20:52:27'),(4,'Toyota','Corola','Normal',2017,2000,15500,'T','T','The car is very good for traveling. ','2021-04-22 21:05:53'),(5,'Ford','Expedition','SUV',2020,40,87900,'T','T','The car is very cozy ','2021-04-22 21:08:22');
/*!40000 ALTER TABLE `Cars` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-22 21:46:05
