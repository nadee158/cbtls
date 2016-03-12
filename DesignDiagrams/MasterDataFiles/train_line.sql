-- MySQL dump 10.13  Distrib 5.6.26, for Win64 (x86_64)
--
-- Host: localhost    Database: cbtlsdb
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `train_line`
--

DROP TABLE IF EXISTS `train_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_line` (
  `train_line_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `train_line_integration_id` int(11) DEFAULT NULL,
  `train_line_name` varchar(255) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `end_station_id` bigint(20) DEFAULT NULL,
  `start_station_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`train_line_id`),
  KEY `FK_34q0dru6n649ujxmi6qv658u5` (`end_station_id`),
  KEY `FK_pni4g5ohjstynkph2cwd4uv00` (`start_station_id`),
  CONSTRAINT `FK_34q0dru6n649ujxmi6qv658u5` FOREIGN KEY (`end_station_id`) REFERENCES `train_station` (`train_station_id`),
  CONSTRAINT `FK_pni4g5ohjstynkph2cwd4uv00` FOREIGN KEY (`start_station_id`) REFERENCES `train_station` (`train_station_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_line`
--

LOCK TABLES `train_line` WRITE;
/*!40000 ALTER TABLE `train_line` DISABLE KEYS */;
INSERT INTO `train_line` VALUES (1,'YES',1,'Colombo - Badulla',0,NULL,NULL),(2,'YES',2,'Colombo - Matale',0,NULL,NULL),(3,'YES',3,'Colombo - Puttlam',0,NULL,NULL),(4,'YES',4,'Colombo - Thandikulam',0,NULL,NULL),(5,'YES',5,'Colombo - Talaimannar',0,NULL,NULL),(6,'YES',6,'Colombo - Batticaloa',0,NULL,NULL),(7,'YES',7,'Colombo - Trincomalee',0,NULL,NULL),(8,'YES',8,'Colombo - Matara',0,NULL,NULL),(9,'YES',9,'Colombo - Avissawella',0,NULL,NULL),(10,'YES',10,'Colombo - Mihintale',0,NULL,NULL);
/*!40000 ALTER TABLE `train_line` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-12 11:03:13
