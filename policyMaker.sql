-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sellerpolicy
-- ------------------------------------------------------
-- Server version	5.7.40-log

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
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brands` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES (1,NULL,'Oppo','oppo',NULL),(2,NULL,'Samsung','samsung',NULL);
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorys`
--

DROP TABLE IF EXISTS `categorys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorys` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorys`
--

LOCK TABLES `categorys` WRITE;
/*!40000 ALTER TABLE `categorys` DISABLE KEYS */;
INSERT INTO `categorys` VALUES (1,'Video Games',NULL,'Video Games',NULL),(2,'Digital Music',NULL,'Digital Music',NULL),(3,'Health and household items',NULL,'Health and household items',NULL),(4,'Patio, lawn, and garden',NULL,'Patio, lawn, and garden',NULL),(5,'Sports, outdoor, and fitness supplies',NULL,'Sports, outdoor, and fitness supplies',NULL),(6,'Books',NULL,'Books',NULL),(7,'Clothing, shoes, and jewelry',NULL,'Clothing, shoes, and jewelry',NULL),(8,'Home and kitchen items',NULL,'Home and kitchen items',NULL),(9,'Pet supplies',NULL,'Pet supplies',NULL),(10,'Beauty and personal care',NULL,NULL,NULL),(11,'Cell phone accessories',NULL,NULL,NULL),(12,'Toys and games',NULL,NULL,NULL),(13,'Tools and home improvement items',NULL,NULL,NULL),(14,'Kitchen and dining items',NULL,NULL,NULL),(15,'Grocery and gourmet food',NULL,NULL,NULL),(16,'Office products',NULL,NULL,NULL),(17,'Others',NULL,NULL,NULL);
/*!40000 ALTER TABLE `categorys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (3);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `market_place`
--

DROP TABLE IF EXISTS `market_place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `market_place` (
  `market_placeid` int(11) NOT NULL,
  `gst_no` varchar(255) DEFAULT NULL,
  `bussiness_addr` varchar(255) DEFAULT NULL,
  `compony_url` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `name_of_company` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type_of_company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`market_placeid`),
  UNIQUE KEY `UK_bbbh8mo800o39rx4uhffda2ul` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `market_place`
--

LOCK TABLES `market_place` WRITE;
/*!40000 ALTER TABLE `market_place` DISABLE KEYS */;
INSERT INTO `market_place` VALUES (1,'123455432112345','this is ramesh address','flipcart.com','Australia','Ramesh@gmail.com','Ramesh','chawala','Flipcart','ram123','7889788967','432167','Northern Territory','Pvt Ltd Company'),(2,'123456789012345','this is bhati sir addr','GeaksForgeak.com','India','Taimor@gmail.com','taimor','bhatia','Geaks for geak','1234','9876565577','765434','Goa','Public Ltd Company');
/*!40000 ALTER TABLE `market_place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marketplace_categorys`
--

DROP TABLE IF EXISTS `marketplace_categorys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marketplace_categorys` (
  `marketplace_list_market_placeid` int(11) NOT NULL,
  `categorys_listm_category_id` int(11) NOT NULL,
  KEY `FKsy1n0uiyo8j541m8e4x2c20mx` (`categorys_listm_category_id`),
  KEY `FK1u2afabovxlh0ymicmn9mcr3g` (`marketplace_list_market_placeid`),
  CONSTRAINT `FK1u2afabovxlh0ymicmn9mcr3g` FOREIGN KEY (`marketplace_list_market_placeid`) REFERENCES `market_place` (`market_placeid`),
  CONSTRAINT `FKsy1n0uiyo8j541m8e4x2c20mx` FOREIGN KEY (`categorys_listm_category_id`) REFERENCES `categorys` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marketplace_categorys`
--

LOCK TABLES `marketplace_categorys` WRITE;
/*!40000 ALTER TABLE `marketplace_categorys` DISABLE KEYS */;
INSERT INTO `marketplace_categorys` VALUES (1,3),(1,4),(1,5),(1,6),(1,7),(1,16),(1,17),(2,6),(2,17);
/*!40000 ALTER TABLE `marketplace_categorys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_ref_id` varchar(255) NOT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  `createt_date_time` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `hsn_code` varchar(255) DEFAULT NULL,
  `seller_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_ref_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('PRD_RF_ID_1972737213','2','2022-12-28 17:17:56.596000',NULL,'1234',NULL,'Recorder mp3');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_reviews`
--

DROP TABLE IF EXISTS `product_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_reviews` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_time` datetime(6) DEFAULT NULL,
  `feedback` varchar(500) DEFAULT NULL,
  `img_urls` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `reviwer_id` varchar(255) DEFAULT NULL,
  `product_product_ref_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FKiry2i2pui7h3vqser7j57q9t9` (`product_product_ref_id`),
  CONSTRAINT `FKiry2i2pui7h3vqser7j57q9t9` FOREIGN KEY (`product_product_ref_id`) REFERENCES `product` (`product_ref_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_reviews`
--

LOCK TABLES `product_reviews` WRITE;
/*!40000 ALTER TABLE `product_reviews` DISABLE KEYS */;
INSERT INTO `product_reviews` VALUES (1,'2022-12-31 13:15:05.000000','Feedback occurs when outputs of a system are routed back as inputs as part of a chain of cause-and-effect that forms a circuit or loop. The system can then ...',NULL,'3.5',NULL,'PRD_RF_ID_1972737213');
/*!40000 ALTER TABLE `product_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller` (
  `sellerid` int(11) NOT NULL AUTO_INCREMENT,
  `gst_no` varchar(255) DEFAULT NULL,
  `bussiness_addr` varchar(3000) DEFAULT NULL,
  `compony_url` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `name_of_company` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type_of_company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sellerid`),
  UNIQUE KEY `UK_crgbovyy4gvgsum2yyb3fbfn7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES (1,'123456789009876','this john addr','VisionBooks.com','Angola','John123@gmail.com','John','D','Vision publication','john','8978675645','675645','Huila','Pvt Ltd Company'),(2,'123456789012345','this is bhati sir addr','GeaksForgeak.com','India','Taimor@gmail.com','taimor','bhatia','Geaks for geak','1234','9876565577','765434','Goa','Public Ltd Company');
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller_categorys`
--

DROP TABLE IF EXISTS `seller_categorys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller_categorys` (
  `seller_list_sellerid` int(11) NOT NULL,
  `categorys_list_category_id` int(11) NOT NULL,
  KEY `FKnp2vx4nqhaeth0pg1vm1ojlpv` (`categorys_list_category_id`),
  KEY `FKrayopun4gayc0uaokq6les2pc` (`seller_list_sellerid`),
  CONSTRAINT `FKnp2vx4nqhaeth0pg1vm1ojlpv` FOREIGN KEY (`categorys_list_category_id`) REFERENCES `categorys` (`category_id`),
  CONSTRAINT `FKrayopun4gayc0uaokq6les2pc` FOREIGN KEY (`seller_list_sellerid`) REFERENCES `seller` (`sellerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller_categorys`
--

LOCK TABLES `seller_categorys` WRITE;
/*!40000 ALTER TABLE `seller_categorys` DISABLE KEYS */;
INSERT INTO `seller_categorys` VALUES (1,6),(1,17),(2,6),(2,17);
/*!40000 ALTER TABLE `seller_categorys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  `contact_no` varchar(16) DEFAULT NULL,
  `cud` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enable` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `gstin` varchar(255) DEFAULT NULL,
  `gst_filing_method` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `jio_client_id` varchar(255) DEFAULT NULL,
  `jio_client_skey` varchar(255) DEFAULT NULL,
  `login_id` varchar(255) DEFAULT NULL,
  `logo_url` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `product_stock_mapping` varchar(255) DEFAULT NULL,
  `purchase_info_mail` varchar(255) DEFAULT NULL,
  `status` varchar(511) DEFAULT NULL,
  `support_contact_no` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `wms` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-01 11:13:03
