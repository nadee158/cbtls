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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geo_location`
--

LOCK TABLES `geo_location` WRITE;
/*!40000 ALTER TABLE `geo_location` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_line`
--

LOCK TABLES `train_line` WRITE;
/*!40000 ALTER TABLE `train_line` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_station`
--

LOCK TABLES `train_station` WRITE;
/*!40000 ALTER TABLE `train_station` DISABLE KEYS */;
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

-- Dump completed on 2016-03-12 12:02:44
