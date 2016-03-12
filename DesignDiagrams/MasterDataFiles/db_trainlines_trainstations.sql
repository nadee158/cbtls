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
-- Table structure for table `geo_location`
--

DROP TABLE IF EXISTS `geo_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geo_location` (
  `geo_location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `version_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`geo_location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=329 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geo_location`
--

LOCK TABLES `geo_location` WRITE;
/*!40000 ALTER TABLE `geo_location` DISABLE KEYS */;
INSERT INTO `geo_location` VALUES (1,0,0,0),(2,0,0,0),(3,0,0,0),(4,0,0,0),(5,0,0,0),(6,0,0,0),(7,0,0,0),(8,0,0,0),(9,0,0,0),(10,0,0,0),(11,0,0,0),(12,0,0,0),(13,0,0,0),(14,0,0,0),(15,0,0,0),(16,0,0,0),(17,0,0,0),(18,0,0,0),(19,0,0,0),(20,0,0,0),(21,0,0,0),(22,0,0,0),(23,0,0,0),(24,0,0,0),(25,0,0,0),(26,0,0,0),(27,0,0,0),(28,0,0,0),(29,0,0,0),(30,0,0,0),(31,0,0,0),(32,0,0,0),(33,0,0,0),(34,0,0,0),(35,0,0,0),(36,0,0,0),(37,0,0,0),(38,0,0,0),(39,0,0,0),(40,0,0,0),(41,0,0,0),(42,0,0,0),(43,0,0,0),(44,0,0,0),(45,0,0,0),(46,0,0,0),(47,0,0,0),(48,0,0,0),(49,0,0,0),(50,0,0,0),(51,0,0,0),(52,0,0,0),(53,0,0,0),(54,0,0,0),(55,0,0,0),(56,0,0,0),(57,0,0,0),(58,0,0,0),(59,0,0,0),(60,0,0,0),(61,0,0,0),(62,0,0,0),(63,0,0,0),(64,0,0,0),(65,0,0,0),(66,0,0,0),(67,0,0,0),(68,0,0,0),(69,0,0,0),(70,0,0,0),(71,0,0,0),(72,0,0,0),(73,0,0,0),(74,0,0,0),(75,0,0,0),(76,0,0,0),(77,0,0,0),(78,0,0,0),(79,0,0,0),(80,0,0,0),(81,0,0,0),(82,0,0,0),(83,0,0,0),(84,0,0,0),(85,0,0,0),(86,0,0,0),(87,0,0,0),(88,0,0,0),(89,0,0,0),(90,0,0,0),(91,0,0,0),(92,0,0,0),(93,0,0,0),(94,0,0,0),(95,0,0,0),(96,0,0,0),(97,0,0,0),(98,0,0,0),(99,0,0,0),(100,0,0,0),(101,0,0,0),(102,0,0,0),(103,0,0,0),(104,0,0,0),(105,0,0,0),(106,0,0,0),(107,0,0,0),(108,0,0,0),(109,0,0,0),(110,0,0,0),(111,0,0,0),(112,0,0,0),(113,0,0,0),(114,0,0,0),(115,0,0,0),(116,0,0,0),(117,0,0,0),(118,0,0,0),(119,0,0,0),(120,0,0,0),(121,0,0,0),(122,0,0,0),(123,0,0,0),(124,0,0,0),(125,0,0,0),(126,0,0,0),(127,0,0,0),(128,0,0,0),(129,0,0,0),(130,0,0,0),(131,0,0,0),(132,0,0,0),(133,0,0,0),(134,0,0,0),(135,0,0,0),(136,0,0,0),(137,0,0,0),(138,0,0,0),(139,0,0,0),(140,0,0,0),(141,0,0,0),(142,0,0,0),(143,0,0,0),(144,0,0,0),(145,0,0,0),(146,0,0,0),(147,0,0,0),(148,0,0,0),(149,0,0,0),(150,0,0,0),(151,0,0,0),(152,0,0,0),(153,0,0,0),(154,0,0,0),(155,0,0,0),(156,0,0,0),(157,0,0,0),(158,0,0,0),(159,0,0,0),(160,0,0,0),(161,0,0,0),(162,0,0,0),(163,0,0,0),(164,0,0,0),(165,0,0,0),(166,0,0,0),(167,0,0,0),(168,0,0,0),(169,0,0,0),(170,0,0,0),(171,0,0,0),(172,0,0,0),(173,0,0,0),(174,0,0,0),(175,0,0,0),(176,0,0,0),(177,0,0,0),(178,0,0,0),(179,0,0,0),(180,0,0,0),(181,0,0,0),(182,0,0,0),(183,0,0,0),(184,0,0,0),(185,0,0,0),(186,0,0,0),(187,0,0,0),(188,0,0,0),(189,0,0,0),(190,0,0,0),(191,0,0,0),(192,0,0,0),(193,0,0,0),(194,0,0,0),(195,0,0,0),(196,0,0,0),(197,0,0,0),(198,0,0,0),(199,0,0,0),(200,0,0,0),(201,0,0,0),(202,0,0,0),(203,0,0,0),(204,0,0,0),(205,0,0,0),(206,0,0,0),(207,0,0,0),(208,0,0,0),(209,0,0,0),(210,0,0,0),(211,0,0,0),(212,0,0,0),(213,0,0,0),(214,0,0,0),(215,0,0,0),(216,0,0,0),(217,0,0,0),(218,0,0,0),(219,0,0,0),(220,0,0,0),(221,0,0,0),(222,0,0,0),(223,0,0,0),(224,0,0,0),(225,0,0,0),(226,0,0,0),(227,0,0,0),(228,0,0,0),(229,0,0,0),(230,0,0,0),(231,0,0,0),(232,0,0,0),(233,0,0,0),(234,0,0,0),(235,0,0,0),(236,0,0,0),(237,0,0,0),(238,0,0,0),(239,0,0,0),(240,0,0,0),(241,0,0,0),(242,0,0,0),(243,0,0,0),(244,0,0,0),(245,0,0,0),(246,0,0,0),(247,0,0,0),(248,0,0,0),(249,0,0,0),(250,0,0,0),(251,0,0,0),(252,0,0,0),(253,0,0,0),(254,0,0,0),(255,0,0,0),(256,0,0,0),(257,0,0,0),(258,0,0,0),(259,0,0,0),(260,0,0,0),(261,0,0,0),(262,0,0,0),(263,0,0,0),(264,0,0,0),(265,0,0,0),(266,0,0,0),(267,0,0,0),(268,0,0,0),(269,0,0,0),(270,0,0,0),(271,0,0,0),(272,0,0,0),(273,0,0,0),(274,0,0,0),(275,0,0,0),(276,0,0,0),(277,0,0,0),(278,0,0,0),(279,0,0,0),(280,0,0,0),(281,0,0,0),(282,0,0,0),(283,0,0,0),(284,0,0,0),(285,0,0,0),(286,0,0,0),(287,0,0,0),(288,0,0,0),(289,0,0,0),(290,0,0,0),(291,0,0,0),(292,0,0,0),(293,0,0,0),(294,0,0,0),(295,0,0,0),(296,0,0,0),(297,0,0,0),(298,0,0,0),(299,0,0,0),(300,0,0,0),(301,0,0,0),(302,0,0,0),(303,0,0,0),(304,0,0,0),(305,0,0,0),(306,0,0,0),(307,0,0,0),(308,0,0,0),(309,0,0,0),(310,0,0,0),(311,0,0,0),(312,0,0,0),(313,0,0,0),(314,0,0,0),(315,0,0,0),(316,0,0,0),(317,0,0,0),(318,0,0,0),(319,0,0,0),(320,0,0,0),(321,0,0,0),(322,0,0,0),(323,0,0,0),(324,0,0,0),(325,0,0,0),(326,0,0,0),(327,0,0,0),(328,0,0,0);
/*!40000 ALTER TABLE `geo_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mobile_device`
--

DROP TABLE IF EXISTS `mobile_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mobile_device` (
  `mobile_device_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `unique_mobile_device_number` varchar(255) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`mobile_device_id`),
  UNIQUE KEY `UK_917tdf3rv4b8muutdoj4i4ee` (`unique_mobile_device_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mobile_device`
--

LOCK TABLES `mobile_device` WRITE;
/*!40000 ALTER TABLE `mobile_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `mobile_device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user`
--

DROP TABLE IF EXISTS `system_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `yes_no_status` varchar(255) DEFAULT NULL,
  `ranking` float DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `passenger_type` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `profile_image_url` varchar(255) DEFAULT NULL,
  `total_number_of_feed_backs` int(11) DEFAULT NULL,
  `user_display_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  `version_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_204b9ercidw1baj3s3m9lnr33` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user`
--

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user_alarm`
--

DROP TABLE IF EXISTS `system_user_alarm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user_alarm` (
  `system_user_alarm_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `alarm_type` varchar(255) DEFAULT NULL,
  `distance_to_station` float DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `train_station_id` bigint(20) DEFAULT NULL,
  `system_user_mobile_device_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`system_user_alarm_id`),
  KEY `FK_m6513y3rnd13r409wdjsh3pvu` (`train_station_id`),
  KEY `FK_pdgpnhsxseccgy14qr6aqsjy7` (`system_user_mobile_device_id`),
  CONSTRAINT `FK_m6513y3rnd13r409wdjsh3pvu` FOREIGN KEY (`train_station_id`) REFERENCES `train_station` (`train_station_id`),
  CONSTRAINT `FK_pdgpnhsxseccgy14qr6aqsjy7` FOREIGN KEY (`system_user_mobile_device_id`) REFERENCES `system_user_mobile_device` (`system_user_mobile_device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user_alarm`
--

LOCK TABLES `system_user_alarm` WRITE;
/*!40000 ALTER TABLE `system_user_alarm` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_user_alarm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user_favourite_schedule`
--

DROP TABLE IF EXISTS `system_user_favourite_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user_favourite_schedule` (
  `system_user_favourite_schedule_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `system_user_id` bigint(20) DEFAULT NULL,
  `train_schedule_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`system_user_favourite_schedule_id`),
  KEY `FK_ora794jxy7ecwthpyly4tk5c0` (`system_user_id`),
  KEY `FK_2ijh49e7e723n0m9eaxu3q823` (`train_schedule_id`),
  CONSTRAINT `FK_2ijh49e7e723n0m9eaxu3q823` FOREIGN KEY (`train_schedule_id`) REFERENCES `train_schedule` (`train_schedule_id`),
  CONSTRAINT `FK_ora794jxy7ecwthpyly4tk5c0` FOREIGN KEY (`system_user_id`) REFERENCES `system_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user_favourite_schedule`
--

LOCK TABLES `system_user_favourite_schedule` WRITE;
/*!40000 ALTER TABLE `system_user_favourite_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_user_favourite_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user_mobile_device`
--

DROP TABLE IF EXISTS `system_user_mobile_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user_mobile_device` (
  `system_user_mobile_device_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `total_crowd_density_updates` int(11) DEFAULT NULL,
  `total_location_updates` int(11) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `mobile_device_id` bigint(20) DEFAULT NULL,
  `system_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`system_user_mobile_device_id`),
  KEY `FK_mrl1obi509d0yq2i4aycun0ox` (`mobile_device_id`),
  KEY `FK_e5qoxyxkh61pl4tartjeva37a` (`system_user_id`),
  CONSTRAINT `FK_e5qoxyxkh61pl4tartjeva37a` FOREIGN KEY (`system_user_id`) REFERENCES `system_user` (`user_id`),
  CONSTRAINT `FK_mrl1obi509d0yq2i4aycun0ox` FOREIGN KEY (`mobile_device_id`) REFERENCES `mobile_device` (`mobile_device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user_mobile_device`
--

LOCK TABLES `system_user_mobile_device` WRITE;
/*!40000 ALTER TABLE `system_user_mobile_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_user_mobile_device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user_rankings`
--

DROP TABLE IF EXISTS `system_user_rankings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user_rankings` (
  `system_user_ranking_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `average_rate` float NOT NULL,
  `ranked_date` datetime DEFAULT NULL,
  `ranked_user` bigint(20) DEFAULT NULL,
  `ranking` int(11) NOT NULL,
  `version_id` int(11) DEFAULT NULL,
  `system_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`system_user_ranking_id`),
  KEY `FK_eevppb7oom5dxe98yueb5tqgw` (`system_user_id`),
  CONSTRAINT `FK_eevppb7oom5dxe98yueb5tqgw` FOREIGN KEY (`system_user_id`) REFERENCES `system_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user_rankings`
--

LOCK TABLES `system_user_rankings` WRITE;
/*!40000 ALTER TABLE `system_user_rankings` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_user_rankings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user_roles`
--

DROP TABLE IF EXISTS `system_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user_roles` (
  `user_id` bigint(20) NOT NULL,
  `user_role_id` bigint(20) NOT NULL,
  KEY `FK_fxpcv54da1d0lfou0d4yml9yk` (`user_role_id`),
  KEY `FK_kinfigudr0uc0a9v61hsp4wbv` (`user_id`),
  CONSTRAINT `FK_fxpcv54da1d0lfou0d4yml9yk` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`user_role_id`),
  CONSTRAINT `FK_kinfigudr0uc0a9v61hsp4wbv` FOREIGN KEY (`user_id`) REFERENCES `system_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user_roles`
--

LOCK TABLES `system_user_roles` WRITE;
/*!40000 ALTER TABLE `system_user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_price`
--

DROP TABLE IF EXISTS `ticket_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_price` (
  `ticket_price_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ticket_price` float DEFAULT NULL,
  `user_role_type` varchar(255) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `train_schedule_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ticket_price_id`),
  KEY `FK_8ceuv88c93urqany9gt8xqtob` (`train_schedule_id`),
  CONSTRAINT `FK_8ceuv88c93urqany9gt8xqtob` FOREIGN KEY (`train_schedule_id`) REFERENCES `train_schedule` (`train_schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_price`
--

LOCK TABLES `ticket_price` WRITE;
/*!40000 ALTER TABLE `ticket_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_price` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `train_line_station`
--

DROP TABLE IF EXISTS `train_line_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_line_station` (
  `train_line_station_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `distance_from_end_station` double DEFAULT NULL,
  `distance_from_start_station` double DEFAULT NULL,
  `distance_to_next_station` double DEFAULT NULL,
  `distance_to_previous_station` double DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `next_station_id` bigint(20) NOT NULL,
  `previous_station_id` bigint(20) NOT NULL,
  `train_line_id` bigint(20) NOT NULL,
  `train_station_id` bigint(20) NOT NULL,
  PRIMARY KEY (`train_line_station_id`),
  KEY `FK_l5pm74teu8k7nbdek4ao9lij1` (`next_station_id`),
  KEY `FK_s6x7mxyhy8y46ne261kbb62ds` (`previous_station_id`),
  KEY `FK_6pqcgcrb8kk48l9n8t2oschvk` (`train_line_id`),
  KEY `FK_mrgmcilby1fv9w1fdifnlow9p` (`train_station_id`),
  CONSTRAINT `FK_6pqcgcrb8kk48l9n8t2oschvk` FOREIGN KEY (`train_line_id`) REFERENCES `train_line` (`train_line_id`),
  CONSTRAINT `FK_l5pm74teu8k7nbdek4ao9lij1` FOREIGN KEY (`next_station_id`) REFERENCES `train_station` (`train_station_id`),
  CONSTRAINT `FK_mrgmcilby1fv9w1fdifnlow9p` FOREIGN KEY (`train_station_id`) REFERENCES `train_station` (`train_station_id`),
  CONSTRAINT `FK_s6x7mxyhy8y46ne261kbb62ds` FOREIGN KEY (`previous_station_id`) REFERENCES `train_station` (`train_station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_line_station`
--

LOCK TABLES `train_line_station` WRITE;
/*!40000 ALTER TABLE `train_line_station` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_line_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_schedule`
--

DROP TABLE IF EXISTS `train_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_schedule` (
  `train_schedule_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `arrival_time` time DEFAULT NULL,
  `departure_time` time DEFAULT NULL,
  `train_frequency` varchar(255) DEFAULT NULL,
  `train_name` varchar(255) DEFAULT NULL,
  `train_number` varchar(255) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `end_station_id` bigint(20) NOT NULL,
  `start_station_id` bigint(20) NOT NULL,
  `train_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`train_schedule_id`),
  KEY `FK_bn2kcqy0obn6cho6m9nj6jx0b` (`end_station_id`),
  KEY `FK_lkhjp6m01s0jdfjy0jyirfvho` (`start_station_id`),
  KEY `FK_fia2s5t4hxnqcae68t8q6g7uq` (`train_type_id`),
  CONSTRAINT `FK_bn2kcqy0obn6cho6m9nj6jx0b` FOREIGN KEY (`end_station_id`) REFERENCES `train_station` (`train_station_id`),
  CONSTRAINT `FK_fia2s5t4hxnqcae68t8q6g7uq` FOREIGN KEY (`train_type_id`) REFERENCES `train_type` (`train_type_id`),
  CONSTRAINT `FK_lkhjp6m01s0jdfjy0jyirfvho` FOREIGN KEY (`start_station_id`) REFERENCES `train_station` (`train_station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_schedule`
--

LOCK TABLES `train_schedule` WRITE;
/*!40000 ALTER TABLE `train_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_schedule_turn`
--

DROP TABLE IF EXISTS `train_schedule_turn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_schedule_turn` (
  `train_schedule_turn_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `arrival_time` datetime DEFAULT NULL,
  `departure_time` datetime DEFAULT NULL,
  `train_schedule_turn_date` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `train_schedule_id` bigint(20) NOT NULL,
  PRIMARY KEY (`train_schedule_turn_id`),
  KEY `FK_l28s197x3ijgul2etijsbukqr` (`train_schedule_id`),
  CONSTRAINT `FK_l28s197x3ijgul2etijsbukqr` FOREIGN KEY (`train_schedule_id`) REFERENCES `train_schedule` (`train_schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_schedule_turn`
--

LOCK TABLES `train_schedule_turn` WRITE;
/*!40000 ALTER TABLE `train_schedule_turn` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_schedule_turn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_schedule_turn_compartment_update`
--

DROP TABLE IF EXISTS `train_schedule_turn_compartment_update`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_schedule_turn_compartment_update` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `compartment_density` varchar(255) DEFAULT NULL,
  `compartment_number` int(11) NOT NULL,
  `overall_density` varchar(255) DEFAULT NULL,
  `total_compartments` int(11) NOT NULL,
  `updated_time` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `train_schedule_turn_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_79u2vyx2hp7gncfr6e9o98t36` (`train_schedule_turn_id`),
  KEY `FK_4743lx34ybujppiih4sy3k06u` (`user_id`),
  CONSTRAINT `FK_4743lx34ybujppiih4sy3k06u` FOREIGN KEY (`user_id`) REFERENCES `system_user` (`user_id`),
  CONSTRAINT `FK_79u2vyx2hp7gncfr6e9o98t36` FOREIGN KEY (`train_schedule_turn_id`) REFERENCES `train_schedule_turn` (`train_schedule_turn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_schedule_turn_compartment_update`
--

LOCK TABLES `train_schedule_turn_compartment_update` WRITE;
/*!40000 ALTER TABLE `train_schedule_turn_compartment_update` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_schedule_turn_compartment_update` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_schedule_turn_location_passive_update`
--

DROP TABLE IF EXISTS `train_schedule_turn_location_passive_update`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_schedule_turn_location_passive_update` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `located_time` datetime DEFAULT NULL,
  `located_type` varchar(255) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `last_station_id` bigint(20) NOT NULL,
  `train_schedule_turn_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bkio0l2j0kkvvwds0g1ajnqok` (`last_station_id`),
  KEY `FK_aeac1ccxqt5cnrd1cuub8w7b1` (`train_schedule_turn_id`),
  KEY `FK_sojdyf65iplqkd4rgoq43ptxk` (`user_id`),
  CONSTRAINT `FK_aeac1ccxqt5cnrd1cuub8w7b1` FOREIGN KEY (`train_schedule_turn_id`) REFERENCES `train_schedule_turn` (`train_schedule_turn_id`),
  CONSTRAINT `FK_bkio0l2j0kkvvwds0g1ajnqok` FOREIGN KEY (`last_station_id`) REFERENCES `train_station` (`train_station_id`),
  CONSTRAINT `FK_sojdyf65iplqkd4rgoq43ptxk` FOREIGN KEY (`user_id`) REFERENCES `system_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_schedule_turn_location_passive_update`
--

LOCK TABLES `train_schedule_turn_location_passive_update` WRITE;
/*!40000 ALTER TABLE `train_schedule_turn_location_passive_update` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_schedule_turn_location_passive_update` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_schedule_turn_location_update`
--

DROP TABLE IF EXISTS `train_schedule_turn_location_update`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_schedule_turn_location_update` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` float NOT NULL,
  `located_type` varchar(255) DEFAULT NULL,
  `longitude` float NOT NULL,
  `updated_time` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `last_station_id` bigint(20) NOT NULL,
  `train_schedule_turn_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_g7b0xmfb14bckdunb1ttjodax` (`last_station_id`),
  KEY `FK_pa1dy0htaapy2wkdotsknrfj` (`train_schedule_turn_id`),
  KEY `FK_la2h34a6dagusaibmw4mtorg3` (`user_id`),
  CONSTRAINT `FK_g7b0xmfb14bckdunb1ttjodax` FOREIGN KEY (`last_station_id`) REFERENCES `train_station` (`train_station_id`),
  CONSTRAINT `FK_la2h34a6dagusaibmw4mtorg3` FOREIGN KEY (`user_id`) REFERENCES `system_user` (`user_id`),
  CONSTRAINT `FK_pa1dy0htaapy2wkdotsknrfj` FOREIGN KEY (`train_schedule_turn_id`) REFERENCES `train_schedule_turn` (`train_schedule_turn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_schedule_turn_location_update`
--

LOCK TABLES `train_schedule_turn_location_update` WRITE;
/*!40000 ALTER TABLE `train_schedule_turn_location_update` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_schedule_turn_location_update` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_station`
--

DROP TABLE IF EXISTS `train_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_station` (
  `train_station_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `train_station_code` varchar(25) NOT NULL,
  `train_station_contact_number` varchar(10) DEFAULT NULL,
  `train_station_name` varchar(255) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `geo_location_id` bigint(20) NOT NULL,
  PRIMARY KEY (`train_station_id`),
  UNIQUE KEY `UK_2lfumtvjwme6gi3u18pxvoght` (`geo_location_id`),
  UNIQUE KEY `UK_gb4eykmwd9iooy5updsl1cl32` (`train_station_id`,`train_station_code`),
  CONSTRAINT `FK_2lfumtvjwme6gi3u18pxvoght` FOREIGN KEY (`geo_location_id`) REFERENCES `geo_location` (`geo_location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=329 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_station`
--

LOCK TABLES `train_station` WRITE;
/*!40000 ALTER TABLE `train_station` DISABLE KEYS */;
INSERT INTO `train_station` VALUES (1,'YES','ABN','0000000000','Abanpola',0,1),(2,'YES','ANM','0000000000','Ahangama',0,2),(3,'YES','AUH','0000000000','Ahungalle',0,3),(4,'YES','APR','0000000000','Akbopura',0,4),(5,'YES','AKU','0000000000','Akurala',0,5),(6,'YES','AWP','0000000000','Alawatupitiya',0,6),(7,'YES','ALW','0000000000','Alawwa',0,7),(8,'YES','ALT','0000000000','Aluthgama',0,8),(9,'YES','ABA','0000000000','Ambalangoda',0,9),(10,'YES','ABL','0000000000','Ambewela',0,10),(11,'YES','APS','0000000000','Ambeypussa',0,11),(12,'YES','AVD','0000000000','Anawilundawa',0,12),(13,'YES','AND','0000000000','Andadola',0,13),(14,'YES','AGT','0000000000','Angampitiya',0,14),(15,'YES','AGL','0000000000','Angulana',0,15),(16,'YES','ANP','0000000000','Anuradhapura',0,16),(17,'YES','APT','0000000000','Anuradhapura Town',0,17),(18,'YES','AKT','0000000000','Arachchikattuwa',0,18),(19,'YES','ARW','0000000000','Arukkuwatte',0,19),(20,'YES','ASL','0000000000','Aselapura',0,20),(21,'YES','ASG','0000000000','Asgiriya',0,21),(22,'YES','AWK','0000000000','Aukana',0,22),(23,'YES','AVS','0000000000','Avisawella',0,23),(24,'YES','BAD','0000000000','Badulla',0,24),(25,'YES','BNA','0000000000','Balana',0,25),(26,'YES','BPA','0000000000','Balapitiya',0,26),(27,'YES','BPT','0000000000','Bambalapitiya',0,27),(28,'YES','BDA','0000000000','Bandarawela',0,28),(29,'YES','BGY','0000000000','Bangadeniya',0,29),(30,'YES','BSL','0000000000','Baseline Road',0,30),(31,'YES','BOA','0000000000','Battaluoya',0,31),(32,'YES','BCO','0000000000','Batticaloa',0,32),(33,'YES','BTU','0000000000','Batuwatte',0,33),(34,'YES','BEM','0000000000','Bemmulla',0,34),(35,'YES','BNT','0000000000','Bentota',0,35),(36,'YES','BRL','0000000000','Beruwala',0,36),(37,'YES','BLT','0000000000','Bolawatte',0,37),(38,'YES','BSH','0000000000','Boossa',0,38),(39,'YES','BSA','0000000000','Borelessa',0,39),(40,'YES','BTL','0000000000','Botale',0,40),(41,'YES','BGH','0000000000','Bulugahagoda',0,41),(42,'YES','BJM','0000000000','Buthgamuwa',0,42),(43,'YES','CDK','0000000000','Cheddikulam',0,43),(44,'YES','CHL','0000000000','Chilaw',0,44),(45,'YES','CBY','0000000000','China Bey',0,45),(46,'YES','FOT','0000000000','Colombo Fort',0,46),(47,'YES','CLY','0000000000','Colombo Yard',0,47),(48,'YES','CRD','0000000000','Cotta Road',0,48),(49,'YES','DRL','0000000000','Daraluwa',0,49),(50,'YES','DWL','0000000000','Dehiwala',0,50),(51,'YES','DAG','0000000000','Dematagoda',0,51),(52,'YES','DDR','0000000000','Demodara',0,52),(53,'YES','DPM','0000000000','Dewapuram',0,53),(54,'YES','DLA','0000000000','Diyatalawa',0,54),(55,'YES','DNA','0000000000','Dodanduwa',0,55),(56,'YES','EYA','0000000000','Egoda Uyana',0,56),(57,'YES','EPS','0000000000','Eliphant Pass',0,57),(58,'YES','ELL','0000000000','Elle',0,58),(59,'YES','EDM','0000000000','Enderamulla',0,59),(60,'YES','EKM','0000000000','Erattaperiyakulam',0,60),(61,'YES','EVR','0000000000','Eravur',0,61),(62,'YES','EPN','0000000000','Erukkalam Pendu',0,62),(63,'YES','IPZ','0000000000','Free Trade Zone',0,63),(64,'YES','GBD','0000000000','Galaboda',0,64),(65,'YES','GLM','0000000000','Galgamuwa',0,65),(66,'YES','GLE','0000000000','Galle',0,66),(67,'YES','GAL','0000000000','Gallella',0,67),(68,'YES','GOA','0000000000','Galoya Junction',0,68),(69,'YES','GMA','0000000000','Gammana',0,69),(70,'YES','GPH','0000000000','Gampaha',0,70),(71,'YES','GPL','0000000000','Gampola',0,71),(72,'YES','GND','0000000000','Ganegoda',0,72),(73,'YES','GAN','0000000000','Ganemulla',0,73),(74,'YES','GNW','0000000000','Ganewatte',0,74),(75,'YES','GDA','0000000000','Gangoda',0,75),(76,'YES','GTL','0000000000','Gantalawa',0,76),(77,'YES','GEY','0000000000','Gelioya',0,77),(78,'YES','GNT','0000000000','Ginthota',0,78),(79,'YES','GRB','0000000000','Girambe',0,79),(80,'YES','GGA','0000000000','Godagama',0,80),(81,'YES','GWN','0000000000','Great Western',0,81),(82,'YES','HBD','0000000000','Habaraduwa',0,82),(83,'YES','HBN','0000000000','Habarana',0,83),(84,'YES','HEA','0000000000','Haliela',0,84),(85,'YES','HPT','0000000000','Haputale',0,85),(86,'YES','HAU','0000000000','Hatamuna',0,86),(87,'YES','HKT','0000000000','Hataras Kotuwa',0,87),(88,'YES','HTN','0000000000','Hatton',0,88),(89,'YES','HLO','0000000000','Heel Oya',0,89),(90,'YES','HDP','0000000000','Heendeniya',0,90),(91,'YES','HML','0000000000','Hettimulla',0,91),(92,'YES','HKD','0000000000','Hikkaduwa',0,92),(93,'YES','HRG','0000000000','Hingurakgoda',0,93),(94,'YES','YPP','0000000000','Hiriyala',0,94),(95,'YES','HRL','0000000000','Hiriyala',0,95),(96,'YES','HMA','0000000000','Homagama',0,96),(97,'YES','HHR','0000000000','Homagama Hospital',0,97),(98,'YES','HRP','0000000000','Horape',0,98),(99,'YES','HLA','0000000000','Horiwiala',0,99),(100,'YES','HUN','0000000000','Hunupitiya',0,100),(101,'YES','IGH','0000000000','Idalgasinna',0,101),(102,'YES','IHA','0000000000','Ihalagama',0,102),(103,'YES','IKT','0000000000','Ihalakotte',0,103),(104,'YES','IWL','0000000000','Ihalawatawala',0,104),(105,'YES','IDA','0000000000','Induruwa',0,105),(106,'YES','INO','0000000000','Inguruoya',0,106),(107,'YES','JLA','0000000000','Ja-Ela',0,107),(108,'YES','JAP','0000000000','Jayanthipura',0,108),(109,'YES','KDN','0000000000','Kadadasi Nagar',0,109),(110,'YES','KMA','0000000000','Kadigamuwa',0,110),(111,'YES','KGW','0000000000','Kadugannawa',0,111),(112,'YES','KDG','0000000000','Kadugoda',0,112),(113,'YES','KWE','0000000000','Kahawa',0,113),(114,'YES','KYA','0000000000','Kakkapalliya',0,114),(115,'YES','KLW','0000000000','Kalawewa',0,115),(116,'YES','KKH','0000000000','Kalkudah',0,116),(117,'YES','KTN','0000000000','Kalutara North',0,117),(118,'YES','KTS','0000000000','Kalutara South',0,118),(119,'YES','KMG','0000000000','Kamburugamuwa',0,119),(120,'YES','KAN','0000000000','Kandana',0,120),(121,'YES','KGD','0000000000','Kandegoda',0,121),(122,'YES','KDT','0000000000','Kandy',0,122),(123,'YES','KNI','0000000000','Kantale',0,123),(124,'YES','KAW','0000000000','Kapuwatte',0,124),(125,'YES','KPL','0000000000','Karadipuwal',0,125),(126,'YES','KTL','0000000000','Kathaluwa',0,126),(127,'YES','KAT','0000000000','Kattuwa',0,127),(128,'YES','KTG','0000000000','Katugastota',0,128),(129,'YES','KTR','0000000000','Katugastota Road',0,129),(130,'YES','KUG','0000000000','Katugoda',0,130),(131,'YES','KKD','0000000000','Katukurunda',0,131),(132,'YES','CAK','0000000000','Katunayaka Airport',0,132),(133,'YES','KTK','0000000000','Katunayake',0,133),(134,'YES','KEN','0000000000','Keenawala',0,134),(135,'YES','KRA','0000000000','Kekirawa',0,135),(136,'YES','KLA','0000000000','Kelaniya',0,136),(137,'YES','KOC','0000000000','Kilinochchi',0,137),(138,'YES','KNM','0000000000','Kinigama',0,138),(139,'YES','KPE','0000000000','Kirulapana',0,139),(140,'YES','KEL','0000000000','Kital Elle',0,140),(141,'YES','KCH','0000000000','Kochchikade',0,141),(142,'YES','KOG','0000000000','Koggala',0,142),(143,'YES','KLP','0000000000','Kollupitiya',0,143),(144,'YES','KLN','0000000000','Kolonnawa',0,144),(145,'YES','KPN','0000000000','Kompannavediya',0,145),(146,'YES','KON','0000000000','Konwewa',0,146),(147,'YES','KOR','0000000000','Koralawella',0,147),(148,'YES','KSG','0000000000','Kosgama',0,148),(149,'YES','KDA','0000000000','Kosgoda',0,149),(150,'YES','KHA','0000000000','Koshinna',0,150),(151,'YES','KGA','0000000000','Kotagala',0,151),(152,'YES','KOT','0000000000','Kottawa',0,152),(153,'YES','KWW','0000000000','Kuda Wawa',0,153),(154,'YES','KUD','0000000000','Kudahakapola',0,154),(155,'YES','KMK','0000000000','Kumarakanda',0,155),(156,'YES','KMB','0000000000','Kumbalgama',0,156),(157,'YES','KUR','0000000000','Kurana',0,157),(158,'YES','KRN','0000000000','Kurunegala',0,158),(159,'YES','LYA','0000000000','Laksauyana',0,159),(160,'YES','LGM','0000000000','Liyanagemulla',0,160),(161,'YES','LNA','0000000000','Lunawa',0,161),(162,'YES','LWL','0000000000','Lunuwaila',0,162),(163,'YES','MPA','0000000000','Madampagama',0,163),(164,'YES','MDP','0000000000','Madampe',0,164),(165,'YES','MRD','0000000000','Madhu Road',0,165),(166,'YES','MKI','0000000000','Madurankuliya',0,166),(167,'YES','MGG','0000000000','Magelegoda',0,167),(168,'YES','MGN','0000000000','Maggona',0,168),(169,'YES','MYA','0000000000','Mahaiyawa',0,169),(170,'YES','MAG','0000000000','Maharagama',0,170),(171,'YES','MHO','0000000000','Maho',0,171),(172,'YES','MPL','0000000000','Malapalle',0,172),(173,'YES','MPT','0000000000','Manampitiya',0,173),(174,'YES','MGE','0000000000','Mangalaeliya',0,174),(175,'YES','MKM','0000000000','Mankulam',0,175),(176,'YES','MNR','0000000000','Mannar',0,176),(177,'YES','MNG','0000000000','Manuwangama',0,177),(178,'YES','MDA','0000000000','Maradana',0,178),(179,'YES','MTL','0000000000','Matale',0,179),(180,'YES','MTR','0000000000','Matara',0,180),(181,'YES','MTM','0000000000','Mattotam',0,181),(182,'YES','MVD','0000000000','Mawilmada',0,182),(183,'YES','MEM','0000000000','Medagama',0,183),(184,'YES','MWH','0000000000','Medawachchiya',0,184),(185,'YES','MGD','0000000000','Meegoda',0,185),(186,'YES','MWA','0000000000','Mha Induruwa',0,186),(187,'YES','MED','0000000000','Midigama',0,187),(188,'YES','MHN','0000000000','Mihintale',0,188),(189,'YES','MHJ','0000000000','Mihintale Junction',0,189),(190,'YES','MIY','0000000000','Minneriya',0,190),(191,'YES','MIR','0000000000','Mirigama',0,191),(192,'YES','MIS','0000000000','Mirissa',0,192),(193,'YES','MLP','0000000000','Mollipatana',0,193),(194,'YES','MLG','0000000000','Moragollagama',0,194),(195,'YES','MKP','0000000000','Morakele',0,195),(196,'YES','MRT','0000000000','Moratuwa',0,196),(197,'YES','MLV','0000000000','Mount Laviniya',0,197),(198,'YES','MNL','0000000000','Mundal',0,198),(199,'YES','MRK','0000000000','Murikandy',0,199),(200,'YES','MKN','0000000000','Murunkan',0,200),(201,'YES','MTG','0000000000','Muththettugala',0,201),(202,'YES','NAG','0000000000','Nagollagama',0,202),(203,'YES','NLY','0000000000','Nailiya',0,203),(204,'YES','NOA','0000000000','Nanuoya',0,204),(205,'YES','NHP','0000000000','Narahenpita',0,205),(206,'YES','NAT','0000000000','Nattandiya',0,206),(207,'YES','NVP','0000000000','Nawalapitiya',0,207),(208,'YES','NWN','0000000000','Nawinna',0,208),(209,'YES','NGM','0000000000','Negama',0,209),(210,'YES','NGB','0000000000','Negombo',0,210),(211,'YES','NPK','0000000000','Nelumpokuna',0,211),(212,'YES','NYK','0000000000','Neriyakulam',0,212),(213,'YES','NOR','0000000000','Nooranagar',0,213),(214,'YES','NUG','0000000000','Nugegoda',0,214),(215,'YES','OHA','0000000000','Ohiya',0,215),(216,'YES','OMT','0000000000','Omanthai',0,216),(217,'YES','PDK','0000000000','Padukka',0,217),(218,'YES','PVI','0000000000','Palavi',0,218),(219,'YES','PAL','0000000000','Pallai',0,219),(220,'YES','PLL','0000000000','Pallewala',0,220),(221,'YES','PUW','0000000000','Palugaswewa',0,221),(222,'YES','PND','0000000000','Panadura',0,222),(223,'YES','PNG','0000000000','Panagoda',0,223),(224,'YES','PNL','0000000000','Panaleeya',0,224),(225,'YES','PRW','0000000000','Pangiriwatta',0,225),(226,'YES','PAN','0000000000','Pannipitiya',0,226),(227,'YES','PKU','0000000000','Parakumpura',0,227),(228,'YES','PRN','0000000000','Paranthan',0,228),(229,'YES','PHW','0000000000','Parasangahawewa',0,229),(230,'YES','PGD','0000000000','Patagamgoda',0,230),(231,'YES','PTP','0000000000','Pathanpha',0,231),(232,'YES','PPL','0000000000','Pattipola',0,232),(233,'YES','PGN','0000000000','Payagala North',0,233),(234,'YES','PGS','0000000000','Payagala South',0,234),(235,'YES','PDA','0000000000','Peradeniya',0,235),(236,'YES','PKP','0000000000','Perakumpura',0,236),(237,'YES','PRL','0000000000','Peralanda',0,237),(238,'YES','PNV','0000000000','Periyanagavillu',0,238),(239,'YES','PLD','0000000000','Piliduwa',0,239),(240,'YES','PLT','0000000000','Pilimatalawa',0,240),(241,'YES','PNW','0000000000','Pinnawala',0,241),(242,'YES','PIN','0000000000','Pinwatte',0,242),(243,'YES','PGM','0000000000','Piyadigama',0,243),(244,'YES','PYA','0000000000','Piyagama',0,244),(245,'YES','PLG','0000000000','Polgahawela',0,245),(246,'YES','PLN','0000000000','Polonnaruwa',0,246),(247,'YES','PLR','0000000000','Polwathumodara',0,247),(248,'YES','PON','0000000000','Poonewa',0,248),(249,'YES','PTA','0000000000','Potuhera',0,249),(250,'YES','PCK','0000000000','Pulachchikulam',0,250),(251,'YES','PKM','0000000000','Puliyankulam',0,251),(252,'YES','PNI','0000000000','Punani',0,252),(253,'YES','PTM','0000000000','Puttalam',0,253),(254,'YES','PWP','0000000000','Puwakpitiya',0,254),(255,'YES','RDL','0000000000','Radella',0,255),(256,'YES','RGM','0000000000','Ragama',0,256),(257,'YES','RBK','0000000000','Rambukkana',0,257),(258,'YES','RMA','0000000000','Ranamuggamuwa',0,258),(259,'YES','RGA','0000000000','Randenigama',0,259),(260,'YES','RTG','0000000000','Rathgama',0,260),(261,'YES','RML','0000000000','Ratmalana',0,261),(262,'YES','RDT','0000000000','Redeethenna',0,262),(263,'YES','RCH','0000000000','Richmond Hill',0,263),(264,'YES','RZL','0000000000','Rosella',0,264),(265,'YES','SAL','0000000000','Saliyapura',0,265),(266,'YES','SUA','0000000000','Sarasaviuyana',0,266),(267,'YES','SWR','0000000000','Sawarana',0,267),(268,'YES','SCR','0000000000','Secretartat Halt',0,268),(269,'YES','SED','0000000000','Seeduwa',0,269),(270,'YES','SMA','0000000000','Seenigama',0,270),(271,'YES','SGM','0000000000','Senarathgama',0,271),(272,'YES','SVP','0000000000','Sevanapitiya',0,272),(273,'YES','SYA','0000000000','Siyalangamuwa',0,273),(274,'YES','SRP','0000000000','Srawasthipura',0,274),(275,'YES','TLA','0000000000','Talawa',0,275),(276,'YES','TKL','0000000000','Talawakele',0,276),(277,'YES','TWG','0000000000','Talawattegedara',0,277),(278,'YES','TAN','0000000000','Tampalapopla',0,278),(279,'YES','TWT','0000000000','Telwatte',0,279),(280,'YES','TBL','0000000000','Tembligala',0,280),(281,'YES','TLP','0000000000','Thalpe',0,281),(282,'YES','TBM','0000000000','Thambuttegama',0,282),(283,'YES','TDK','0000000000','Thandikulam',0,283),(284,'YES','TDY','0000000000','Thilladiya',0,284),(285,'YES','TNA','0000000000','Thiranagama',0,285),(286,'YES','TIM','0000000000','Timbiriyagedara',0,286),(287,'YES','TSM','0000000000','Tismalpola',0,287),(288,'YES','TRH','0000000000','Train Halt 01',0,288),(289,'YES','TCO','0000000000','Trincomalle',0,289),(290,'YES','TRW','0000000000','Trirukeshwaram',0,290),(291,'YES','TUD','0000000000','Tudella',0,291),(292,'YES','TDR','0000000000','Tummodara',0,292),(293,'YES','UDL','0000000000','Udatalawinna',0,293),(294,'YES','UWL','0000000000','Udaththawala',0,294),(295,'YES','UHM','0000000000','Udhamulla',0,295),(296,'YES','UDW','0000000000','Uduwara',0,296),(297,'YES','UGL','0000000000','Uggalla',0,297),(298,'YES','UKL','0000000000','Ukuwela',0,298),(299,'YES','ULP','0000000000','Ulapone',0,299),(300,'YES','UNW','0000000000','Unawatuna',0,300),(301,'YES','VCH','0000000000','Valachchenei',0,301),(302,'YES','VML','0000000000','Vandaramullai',0,302),(303,'YES','VNA','0000000000','Vavuniya',0,303),(304,'YES','VGD','0000000000','Veyangoda',0,304),(305,'YES','WDA','0000000000','Wadduwa',0,305),(306,'YES','WGG','0000000000','Waga',0,306),(307,'YES','WKL','0000000000','Waikkala',0,307),(308,'YES','WHP','0000000000','Walahapitiya',0,308),(309,'YES','WLG','0000000000','Walgama',0,309),(310,'YES','WPA','0000000000','Walpola',0,310),(311,'YES','WSL','0000000000','Wanawasala',0,311),(312,'YES','WRW','0000000000','Wandurawa',0,312),(313,'YES','WTG','0000000000','Watagoda',0,313),(314,'YES','WAT','0000000000','Watareka',0,314),(315,'YES','WLA','0000000000','Watawala',0,315),(316,'YES','WGA','0000000000','Wattegama',0,316),(317,'YES','WDK','0000000000','Weedikulam',0,317),(318,'YES','WLM','0000000000','Weligama',0,318),(319,'YES','WKD','0000000000','Welikanda',0,319),(320,'YES','WEL','0000000000','Wellawa',0,320),(321,'YES','WTE','0000000000','Wellawatta',0,321),(322,'YES','WRD','0000000000','Wijayarajadahana',0,322),(323,'YES','WWT','0000000000','Wilwatte',0,323),(324,'YES','WKA','0000000000','Wlakubura',0,324),(325,'YES','YGD','0000000000','Yagoda',0,325),(326,'YES','YPW','0000000000','Yapahuwa',0,326),(327,'YES','YGM','0000000000','Yatagama',0,327),(328,'YES','YTG','0000000000','Yattalgoda',0,328);
/*!40000 ALTER TABLE `train_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_station_schedule`
--

DROP TABLE IF EXISTS `train_station_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_station_schedule` (
  `train_station_schedule_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `arrival_time` datetime DEFAULT NULL,
  `departure_time` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `train_schedule_id` bigint(20) NOT NULL,
  `train_station_id` bigint(20) NOT NULL,
  PRIMARY KEY (`train_station_schedule_id`),
  KEY `FK_req5673akyodc134xu2bs8sre` (`train_schedule_id`),
  KEY `FK_cmtac5637uohf04uif19xsfwf` (`train_station_id`),
  CONSTRAINT `FK_cmtac5637uohf04uif19xsfwf` FOREIGN KEY (`train_station_id`) REFERENCES `train_station` (`train_station_id`),
  CONSTRAINT `FK_req5673akyodc134xu2bs8sre` FOREIGN KEY (`train_schedule_id`) REFERENCES `train_schedule` (`train_schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_station_schedule`
--

LOCK TABLES `train_station_schedule` WRITE;
/*!40000 ALTER TABLE `train_station_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_station_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_station_schedule_turn`
--

DROP TABLE IF EXISTS `train_station_schedule_turn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_station_schedule_turn` (
  `train_station_schedule_turn_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `arrival_time` datetime DEFAULT NULL,
  `departure_time` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `train_schedule_turn_id` bigint(20) NOT NULL,
  `train_station_schedule_id` bigint(20) NOT NULL,
  PRIMARY KEY (`train_station_schedule_turn_id`),
  KEY `FK_c344c02d4ksrw13krvhxiw173` (`train_schedule_turn_id`),
  KEY `FK_p9oskaw8hlevptudjf3igl1nj` (`train_station_schedule_id`),
  CONSTRAINT `FK_c344c02d4ksrw13krvhxiw173` FOREIGN KEY (`train_schedule_turn_id`) REFERENCES `train_schedule_turn` (`train_schedule_turn_id`),
  CONSTRAINT `FK_p9oskaw8hlevptudjf3igl1nj` FOREIGN KEY (`train_station_schedule_id`) REFERENCES `train_station_schedule` (`train_station_schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_station_schedule_turn`
--

LOCK TABLES `train_station_schedule_turn` WRITE;
/*!40000 ALTER TABLE `train_station_schedule_turn` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_station_schedule_turn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_type`
--

DROP TABLE IF EXISTS `train_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_type` (
  `train_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` varchar(255) DEFAULT NULL,
  `train_type_name` varchar(255) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`train_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_type`
--

LOCK TABLES `train_type` WRITE;
/*!40000 ALTER TABLE `train_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_role_type` varchar(255) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-12 12:08:02
