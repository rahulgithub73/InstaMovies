-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: cod
-- ------------------------------------------------------
-- Server version	5.6.41

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
-- Table structure for table `sub_series`
--

DROP TABLE IF EXISTS `sub_series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_series` (
  `id` bigint(20) NOT NULL,
  `cast` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `genres` varchar(255) DEFAULT NULL,
  `imdb_rating` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `releasae_year` varchar(255) DEFAULT NULL,
  `runtime_minutes` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `thumpnail_path` varchar(255) DEFAULT NULL,
  `trailer_path` varchar(255) DEFAULT NULL,
  `series_id` bigint(20) DEFAULT NULL,
  `episode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_series`
--

LOCK TABLES `sub_series` WRITE;
/*!40000 ALTER TABLE `sub_series` DISABLE KEYS */;
INSERT INTO `sub_series` VALUES (1,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,1,'episode 1'),(2,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,1,'episode 2'),(3,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,1,'episode 3'),(4,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,1,'episode 4'),(5,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,1,NULL),(6,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,1,NULL),(7,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,1,NULL),(8,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,8,NULL),(9,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,9,NULL),(10,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,10,NULL),(11,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,11,NULL),(12,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,12,NULL),(13,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,13,NULL),(14,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,14,NULL),(15,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,15,NULL),(16,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,16,NULL),(17,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,17,NULL),(18,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,18,NULL),(19,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,19,NULL),(20,'Test case','Horror films often aim to evoke viewers\' nightmares, fears, revulsions and terror of the unknown. Plots within the horror genre often involve the intrusion of an evil force, event, or personage into the everyday world. Prevalent elements include ghosts, e','Test','Harrior','4.1','Hindi,English','Horror Movie','files/series/subseries/tiktok.mp4','Aug 2013','2.34','Test1,Tag2,Tage3','files/series/thumpnail/webseries123.png',NULL,20,NULL);
/*!40000 ALTER TABLE `sub_series` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-07 15:01:11
