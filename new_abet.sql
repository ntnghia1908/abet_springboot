-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: abet
-- ------------------------------------------------------
-- Server version	8.0.18

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

drop database if exists `abet`;
create database `abet`;
use `abet`;
--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `instructor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9nkqtsydmph5nrsd3sn1f4w29` (`instructor_id`),
  CONSTRAINT `FK9nkqtsydmph5nrsd3sn1f4w29` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'$2a$10$NSP9JnwfzKOQxi9K4D8O1eQdq3PA7C9xNbj/gG0RTL5FEgpPvdqom','nttsang','admin',11),(3,'$2a$10$I8swXBokhReGn/jtUmvpOOAipvaaWef8Fv3UmQgtdFXJKkYmWFg4u','tttung','admin',10);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment`
--

DROP TABLE IF EXISTS `assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assessment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment`
--

LOCK TABLES `assessment` WRITE;
/*!40000 ALTER TABLE `assessment` DISABLE KEYS */;
INSERT INTO `assessment` VALUES (1,'Quiz/Exercise/Homework'),(3,'Labs'),(4,'Midterm examination'),(5,'Projects/Presentations/ Report'),(6,'Final examination'),(10,'Total in-class Assessment');
/*!40000 ALTER TABLE `assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_tool`
--

DROP TABLE IF EXISTS `assessment_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assessment_tool` (
  `assessment_id` int(11) NOT NULL,
  `course_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `loutcome_id` int(11) NOT NULL,
  `percentage` float DEFAULT NULL,
  PRIMARY KEY (`assessment_id`,`course_id`,`loutcome_id`),
  UNIQUE KEY `assessment_tool_id` (`course_id`,`assessment_id`,`loutcome_id`) USING BTREE,
  KEY `FK_AssessmentTool_LOutcome` (`loutcome_id`),
  KEY `FK_AssessmentTool_AssessmentCourse` (`assessment_id`,`course_id`),
  CONSTRAINT `FK_AssessmentTool_Assessment` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_AssessmentTool_Course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_AssessmentTool_LOutcome` FOREIGN KEY (`loutcome_id`) REFERENCES `learning_outcome` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_tool`
--

LOCK TABLES `assessment_tool` WRITE;
/*!40000 ALTER TABLE `assessment_tool` DISABLE KEYS */;
INSERT INTO `assessment_tool` VALUES (1,'IS021',197,NULL),(1,'IS021',198,NULL),(1,'IS021',199,NULL),(1,'IS021',201,NULL),(1,'IT013',98,NULL),(1,'IT017',261,NULL),(1,'IT017',262,NULL),(1,'IT017',263,NULL),(1,'IT017',264,NULL),(1,'IT017',265,NULL),(1,'IT024',295,NULL),(1,'IT024',296,NULL),(1,'IT045',227,NULL),(1,'IT045',228,NULL),(1,'IT045',229,NULL),(1,'IT045',230,NULL),(1,'IT045',231,NULL),(1,'IT056',157,NULL),(1,'IT056',159,NULL),(1,'IT056',160,NULL),(1,'IT064',232,NULL),(1,'IT064',233,NULL),(1,'IT064',234,NULL),(1,'IT064',235,NULL),(1,'IT064',236,NULL),(1,'IT067',248,NULL),(1,'IT067',249,NULL),(1,'IT067',250,NULL),(1,'IT067',251,NULL),(1,'IT069',95,NULL),(1,'IT076',270,NULL),(1,'IT076',271,NULL),(1,'IT076',272,NULL),(1,'IT076',273,NULL),(1,'IT089',256,NULL),(1,'IT089',257,NULL),(1,'IT089',258,NULL),(1,'IT089',259,NULL),(1,'IT089',260,NULL),(1,'IT090',102,NULL),(1,'IT090',103,NULL),(1,'IT090',104,NULL),(1,'IT090',106,NULL),(1,'IT091',309,NULL),(1,'IT092',310,NULL),(1,'IT092',311,NULL),(1,'IT092',312,NULL),(1,'IT092',313,NULL),(1,'IT092',314,NULL),(1,'IT093',269,NULL),(1,'IT094',162,NULL),(1,'IT094',163,NULL),(1,'IT094',167,NULL),(1,'IT096',280,NULL),(1,'IT096',281,NULL),(1,'IT096',282,NULL),(1,'IT097',107,NULL),(1,'IT097',108,NULL),(1,'IT099',252,NULL),(1,'IT099',253,NULL),(1,'IT099',254,NULL),(1,'IT112',213,NULL),(1,'IT112',214,NULL),(1,'IT112',215,NULL),(1,'IT112',216,NULL),(1,'IT116',237,NULL),(1,'IT116',239,NULL),(1,'IT116',240,NULL),(1,'IT116',241,NULL),(1,'IT117',207,NULL),(1,'IT117',208,NULL),(1,'IT117',209,NULL),(1,'IT117',210,NULL),(1,'IT117',211,NULL),(1,'IT117',212,NULL),(1,'IT120',175,NULL),(1,'IT120',176,NULL),(1,'IT120',177,NULL),(1,'IT120',178,NULL),(1,'IT122',220,NULL),(1,'IT130',283,NULL),(1,'IT130',284,NULL),(1,'IT130',285,NULL),(1,'IT131',301,NULL),(1,'IT131',302,NULL),(1,'IT131',303,NULL),(1,'IT131',304,NULL),(1,'IT131',305,NULL),(1,'IT131',306,NULL),(1,'IT132',128,NULL),(1,'IT134',293,NULL),(1,'IT135',77,NULL),(1,'IT135',78,NULL),(1,'IT135',80,NULL),(1,'IT136',111,NULL),(1,'IT136',112,NULL),(1,'IT137',114,NULL),(1,'IT138',117,NULL),(1,'IT138',118,NULL),(1,'IT139',120,NULL),(1,'IT139',121,NULL),(1,'IT141',179,NULL),(1,'IT142',132,NULL),(1,'IT142',133,NULL),(1,'IT142',134,NULL),(1,'IT143',136,NULL),(1,'IT143',137,NULL),(1,'IT143',138,NULL),(1,'IT144',147,NULL),(1,'IT144',148,NULL),(1,'IT145',150,NULL),(1,'IT145',151,NULL),(1,'IT145',152,NULL),(1,'IT145',153,NULL),(1,'IT146',156,NULL),(1,'IT147',169,NULL),(1,'IT147',170,NULL),(1,'IT147',171,NULL),(1,'IT148',172,NULL),(1,'IT148',173,NULL),(1,'IT149',87,NULL),(1,'IT149',89,NULL),(1,'IT149',90,NULL),(1,'IT149',91,NULL),(1,'IT150',187,NULL),(1,'IT152',183,NULL),(1,'IT153',243,NULL),(1,'IT153',244,NULL),(1,'IT153',245,NULL),(1,'IT153',246,NULL),(1,'IT153',247,NULL),(1,'IT155',191,NULL),(1,'IT155',192,NULL),(1,'IT155',193,NULL),(1,'IT155',194,NULL),(1,'IT155',195,NULL),(1,'IT155',196,NULL),(3,'IT013',97,NULL),(3,'IT013',98,NULL),(3,'IT024',295,NULL),(3,'IT024',296,NULL),(3,'IT024',297,NULL),(3,'IT069',94,NULL),(3,'IT069',95,NULL),(3,'IT079',99,30),(3,'IT079',100,40),(3,'IT079',101,30),(3,'IT091',308,NULL),(3,'IT091',309,NULL),(3,'IT093',267,NULL),(3,'IT093',268,NULL),(3,'IT093',269,NULL),(3,'IT096',277,NULL),(3,'IT096',278,NULL),(3,'IT096',279,NULL),(3,'IT096',280,NULL),(3,'IT096',281,NULL),(3,'IT097',108,NULL),(3,'IT097',109,NULL),(3,'IT112',214,NULL),(3,'IT112',215,NULL),(3,'IT112',216,NULL),(3,'IT112',217,NULL),(3,'IT116',238,NULL),(3,'IT116',239,NULL),(3,'IT116',240,NULL),(3,'IT116',241,NULL),(3,'IT116',242,NULL),(3,'IT122',219,NULL),(3,'IT122',220,NULL),(3,'IT125',221,NULL),(3,'IT125',222,NULL),(3,'IT125',223,NULL),(3,'IT125',224,NULL),(3,'IT125',225,NULL),(3,'IT130',283,NULL),(3,'IT130',284,NULL),(3,'IT130',285,NULL),(3,'IT131',301,NULL),(3,'IT131',302,NULL),(3,'IT131',303,NULL),(3,'IT131',304,NULL),(3,'IT131',305,NULL),(3,'IT131',306,NULL),(3,'IT132',130,NULL),(3,'IT132',131,NULL),(3,'IT133',286,NULL),(3,'IT133',287,NULL),(3,'IT133',288,NULL),(3,'IT133',289,NULL),(3,'IT133',290,NULL),(3,'IT134',293,NULL),(3,'IT135',79,NULL),(3,'IT136',112,NULL),(3,'IT136',113,NULL),(3,'IT137',116,NULL),(3,'IT138',118,NULL),(3,'IT138',119,NULL),(3,'IT139',121,NULL),(3,'IT139',122,NULL),(3,'IT141',181,NULL),(3,'IT141',182,NULL),(3,'IT142',133,NULL),(3,'IT142',134,NULL),(3,'IT142',135,NULL),(3,'IT143',137,NULL),(3,'IT143',138,NULL),(3,'IT144',148,NULL),(3,'IT145',150,NULL),(3,'IT145',151,NULL),(3,'IT145',152,NULL),(3,'IT145',153,NULL),(3,'IT146',155,NULL),(3,'IT146',156,NULL),(3,'IT147',170,NULL),(3,'IT147',171,NULL),(3,'IT148',173,NULL),(3,'IT148',174,NULL),(3,'IT149',88,NULL),(3,'IT149',89,NULL),(3,'IT149',90,NULL),(3,'IT149',91,NULL),(3,'IT149',92,NULL),(3,'IT150',189,NULL),(3,'IT150',190,NULL),(3,'IT151',81,NULL),(3,'IT151',82,NULL),(3,'IT151',83,NULL),(3,'IT151',84,NULL),(3,'IT151',85,NULL),(3,'IT151',86,NULL),(3,'IT152',185,NULL),(3,'IT152',186,NULL),(3,'IT155',192,NULL),(3,'IT155',193,NULL),(3,'IT155',194,NULL),(3,'IT155',195,NULL),(4,'IS021',197,NULL),(4,'IS021',198,NULL),(4,'IS021',199,NULL),(4,'IT013',96,NULL),(4,'IT013',97,NULL),(4,'IT017',261,NULL),(4,'IT017',262,NULL),(4,'IT017',263,NULL),(4,'IT024',294,NULL),(4,'IT024',295,NULL),(4,'IT045',227,NULL),(4,'IT045',228,NULL),(4,'IT045',229,NULL),(4,'IT056',157,NULL),(4,'IT056',158,NULL),(4,'IT058',144,NULL),(4,'IT058',145,NULL),(4,'IT058',146,NULL),(4,'IT064',232,NULL),(4,'IT064',233,NULL),(4,'IT064',236,NULL),(4,'IT067',248,NULL),(4,'IT067',249,NULL),(4,'IT069',93,NULL),(4,'IT069',94,NULL),(4,'IT076',270,NULL),(4,'IT076',271,NULL),(4,'IT079',99,40),(4,'IT079',101,60),(4,'IT082',139,NULL),(4,'IT082',140,NULL),(4,'IT083',141,NULL),(4,'IT083',142,NULL),(4,'IT083',143,NULL),(4,'IT089',256,NULL),(4,'IT089',257,NULL),(4,'IT089',258,NULL),(4,'IT090',102,NULL),(4,'IT090',104,NULL),(4,'IT090',105,NULL),(4,'IT090',106,NULL),(4,'IT091',307,NULL),(4,'IT091',308,NULL),(4,'IT092',310,NULL),(4,'IT092',311,NULL),(4,'IT092',312,NULL),(4,'IT093',267,NULL),(4,'IT093',268,NULL),(4,'IT094',162,NULL),(4,'IT094',163,NULL),(4,'IT094',167,NULL),(4,'IT096',277,NULL),(4,'IT096',278,NULL),(4,'IT096',279,NULL),(4,'IT097',107,NULL),(4,'IT097',108,NULL),(4,'IT112',213,NULL),(4,'IT112',217,NULL),(4,'IT116',237,NULL),(4,'IT116',238,NULL),(4,'IT116',239,NULL),(4,'IT116',240,NULL),(4,'IT116',241,NULL),(4,'IT117',207,NULL),(4,'IT117',208,NULL),(4,'IT117',209,NULL),(4,'IT120',175,NULL),(4,'IT120',176,NULL),(4,'IT122',218,NULL),(4,'IT122',219,NULL),(4,'IT125',221,NULL),(4,'IT125',222,NULL),(4,'IT125',223,NULL),(4,'IT130',283,NULL),(4,'IT130',284,NULL),(4,'IT131',301,NULL),(4,'IT131',302,NULL),(4,'IT131',303,NULL),(4,'IT131',306,NULL),(4,'IT132',128,NULL),(4,'IT132',129,NULL),(4,'IT133',286,NULL),(4,'IT133',287,NULL),(4,'IT133',288,NULL),(4,'IT134',292,NULL),(4,'IT134',293,NULL),(4,'IT135',77,NULL),(4,'IT135',80,NULL),(4,'IT136',111,NULL),(4,'IT136',112,NULL),(4,'IT137',114,NULL),(4,'IT137',115,NULL),(4,'IT138',117,NULL),(4,'IT138',118,NULL),(4,'IT139',120,NULL),(4,'IT139',121,NULL),(4,'IT141',179,NULL),(4,'IT141',180,NULL),(4,'IT142',132,NULL),(4,'IT142',133,NULL),(4,'IT143',136,NULL),(4,'IT143',137,NULL),(4,'IT144',147,NULL),(4,'IT144',148,NULL),(4,'IT145',150,NULL),(4,'IT145',151,NULL),(4,'IT146',154,NULL),(4,'IT146',155,NULL),(4,'IT147',169,NULL),(4,'IT147',170,NULL),(4,'IT148',172,NULL),(4,'IT148',173,NULL),(4,'IT149',87,NULL),(4,'IT149',88,NULL),(4,'IT149',89,NULL),(4,'IT149',90,NULL),(4,'IT149',91,NULL),(4,'IT150',187,NULL),(4,'IT150',188,NULL),(4,'IT151',81,NULL),(4,'IT151',82,NULL),(4,'IT151',83,NULL),(4,'IT152',183,NULL),(4,'IT152',184,NULL),(4,'IT153',243,NULL),(4,'IT153',244,NULL),(4,'IT153',245,NULL),(4,'IT153',246,NULL),(4,'IT155',191,NULL),(4,'IT155',192,NULL),(4,'IT155',193,NULL),(5,'IS021',198,NULL),(5,'IS021',199,NULL),(5,'IS021',200,NULL),(5,'IS021',201,NULL),(5,'IT013',98,NULL),(5,'IT017',261,NULL),(5,'IT017',262,NULL),(5,'IT017',264,NULL),(5,'IT017',266,NULL),(5,'IT056',158,NULL),(5,'IT056',159,NULL),(5,'IT056',160,NULL),(5,'IT056',161,NULL),(5,'IT064',232,NULL),(5,'IT064',233,NULL),(5,'IT064',234,NULL),(5,'IT064',235,NULL),(5,'IT064',236,NULL),(5,'IT069',95,NULL),(5,'IT076',270,NULL),(5,'IT076',271,NULL),(5,'IT076',272,NULL),(5,'IT076',273,NULL),(5,'IT076',274,NULL),(5,'IT076',275,NULL),(5,'IT076',276,NULL),(5,'IT079',99,35),(5,'IT079',100,45),(5,'IT079',101,20),(5,'IT090',102,NULL),(5,'IT090',103,NULL),(5,'IT090',104,NULL),(5,'IT090',105,NULL),(5,'IT090',106,NULL),(5,'IT091',307,NULL),(5,'IT091',309,NULL),(5,'IT093',267,NULL),(5,'IT093',268,NULL),(5,'IT093',269,NULL),(5,'IT094',163,NULL),(5,'IT094',164,NULL),(5,'IT094',165,NULL),(5,'IT094',166,NULL),(5,'IT094',168,NULL),(5,'IT112',214,NULL),(5,'IT112',215,NULL),(5,'IT112',216,NULL),(5,'IT112',217,NULL),(5,'IT122',218,NULL),(5,'IT122',220,NULL),(5,'IT125',222,NULL),(5,'IT125',223,NULL),(5,'IT125',224,NULL),(5,'IT125',225,NULL),(5,'IT125',226,NULL),(5,'IT133',289,NULL),(5,'IT133',290,NULL),(5,'IT133',291,NULL),(5,'IT134',292,NULL),(5,'IT146',154,NULL),(5,'IT146',156,NULL),(5,'IT151',84,NULL),(5,'IT151',85,NULL),(5,'IT151',86,NULL),(6,'IS021',197,NULL),(6,'IS021',198,NULL),(6,'IS021',199,NULL),(6,'IS021',200,NULL),(6,'IS021',201,NULL),(6,'IS021',202,NULL),(6,'IT013',96,NULL),(6,'IT013',97,NULL),(6,'IT017',263,NULL),(6,'IT017',264,NULL),(6,'IT017',265,NULL),(6,'IT024',294,NULL),(6,'IT024',295,NULL),(6,'IT045',229,NULL),(6,'IT045',230,NULL),(6,'IT045',231,NULL),(6,'IT056',159,NULL),(6,'IT056',160,NULL),(6,'IT058',144,NULL),(6,'IT058',145,NULL),(6,'IT058',146,NULL),(6,'IT064',232,NULL),(6,'IT064',233,NULL),(6,'IT064',234,NULL),(6,'IT064',235,NULL),(6,'IT064',236,NULL),(6,'IT067',250,NULL),(6,'IT067',251,NULL),(6,'IT069',93,NULL),(6,'IT069',94,NULL),(6,'IT076',271,NULL),(6,'IT076',272,NULL),(6,'IT076',274,NULL),(6,'IT079',100,100),(6,'IT082',139,NULL),(6,'IT082',140,NULL),(6,'IT083',141,NULL),(6,'IT083',142,NULL),(6,'IT083',143,NULL),(6,'IT089',258,NULL),(6,'IT089',259,NULL),(6,'IT089',260,NULL),(6,'IT090',105,NULL),(6,'IT091',307,NULL),(6,'IT091',308,NULL),(6,'IT092',313,NULL),(6,'IT092',314,NULL),(6,'IT093',267,NULL),(6,'IT093',268,NULL),(6,'IT094',162,NULL),(6,'IT094',163,NULL),(6,'IT094',167,NULL),(6,'IT096',279,NULL),(6,'IT096',280,NULL),(6,'IT096',281,NULL),(6,'IT097',108,NULL),(6,'IT099',252,NULL),(6,'IT099',253,NULL),(6,'IT099',254,NULL),(6,'IT112',214,NULL),(6,'IT112',215,NULL),(6,'IT112',216,NULL),(6,'IT112',217,NULL),(6,'IT116',238,NULL),(6,'IT116',239,NULL),(6,'IT116',240,NULL),(6,'IT116',241,NULL),(6,'IT117',209,NULL),(6,'IT117',210,NULL),(6,'IT117',211,NULL),(6,'IT117',212,NULL),(6,'IT120',177,NULL),(6,'IT120',178,NULL),(6,'IT122',218,NULL),(6,'IT122',219,NULL),(6,'IT125',223,NULL),(6,'IT125',224,NULL),(6,'IT125',225,NULL),(6,'IT130',284,NULL),(6,'IT130',285,NULL),(6,'IT131',303,NULL),(6,'IT131',304,NULL),(6,'IT131',305,NULL),(6,'IT131',306,NULL),(6,'IT132',129,NULL),(6,'IT132',130,NULL),(6,'IT133',288,NULL),(6,'IT133',289,NULL),(6,'IT133',290,NULL),(6,'IT134',292,NULL),(6,'IT134',293,NULL),(6,'IT135',78,NULL),(6,'IT135',79,NULL),(6,'IT136',112,NULL),(6,'IT137',115,NULL),(6,'IT137',116,NULL),(6,'IT138',118,NULL),(6,'IT138',119,NULL),(6,'IT139',120,NULL),(6,'IT139',121,NULL),(6,'IT139',122,NULL),(6,'IT141',180,NULL),(6,'IT141',191,NULL),(6,'IT142',134,NULL),(6,'IT142',135,NULL),(6,'IT143',136,NULL),(6,'IT143',137,NULL),(6,'IT143',138,NULL),(6,'IT144',148,NULL),(6,'IT144',149,NULL),(6,'IT145',151,NULL),(6,'IT145',152,NULL),(6,'IT145',153,NULL),(6,'IT146',154,NULL),(6,'IT146',155,NULL),(6,'IT147',169,NULL),(6,'IT147',170,NULL),(6,'IT147',171,NULL),(6,'IT148',173,NULL),(6,'IT148',174,NULL),(6,'IT149',88,NULL),(6,'IT149',89,NULL),(6,'IT149',90,NULL),(6,'IT149',91,NULL),(6,'IT150',188,NULL),(6,'IT150',189,NULL),(6,'IT151',83,NULL),(6,'IT151',84,NULL),(6,'IT151',85,NULL),(6,'IT151',86,NULL),(6,'IT152',184,NULL),(6,'IT152',185,NULL),(6,'IT153',244,NULL),(6,'IT153',245,NULL),(6,'IT153',246,NULL),(6,'IT153',247,NULL),(6,'IT155',191,NULL),(6,'IT155',192,NULL),(6,'IT155',193,NULL),(6,'IT155',194,NULL),(6,'IT155',195,NULL),(6,'IT155',196,NULL);
/*!40000 ALTER TABLE `assessment_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_assessment`
--

DROP TABLE IF EXISTS `class_assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_assessment` (
  `assessment_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `learning_outcome_id` int(11) NOT NULL,
  `precentage` float DEFAULT NULL,
  PRIMARY KEY (`assessment_id`,`class_id`,`learning_outcome_id`),
  KEY `FKmevtb7furfoqcnjqn5wuafdx5` (`class_id`),
  KEY `FKgvbc7qhba0d7odssq6rtompih` (`learning_outcome_id`),
  CONSTRAINT `FKcdrm0f8q2dbqmsrwi90lcjthx` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`id`),
  CONSTRAINT `FKgvbc7qhba0d7odssq6rtompih` FOREIGN KEY (`learning_outcome_id`) REFERENCES `learning_outcome` (`id`),
  CONSTRAINT `FKmevtb7furfoqcnjqn5wuafdx5` FOREIGN KEY (`class_id`) REFERENCES `class_session` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_assessment`
--

LOCK TABLES `class_assessment` WRITE;
/*!40000 ALTER TABLE `class_assessment` DISABLE KEYS */;
INSERT INTO `class_assessment` VALUES (3,55,99,30),(3,55,100,40),(3,55,101,30),(4,55,99,40),(4,55,101,60),(5,55,99,35),(5,55,100,45),(5,55,101,20),(6,55,100,100);
/*!40000 ALTER TABLE `class_assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_assessment_course`
--

DROP TABLE IF EXISTS `class_assessment_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_assessment_course` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `assessment_id` int(11) NOT NULL,
  `percentage` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`,`assessment_id`),
  KEY `fk_class_assessment_course_assessment` (`assessment_id`) USING BTREE,
  KEY `fk_class_assessment_course_class` (`class_id`) USING BTREE,
  CONSTRAINT `FK_class_assessment_course_assessment` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKcyj9bkrwiw4p0itp05mtfodyp` FOREIGN KEY (`class_id`) REFERENCES `class_session` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_assessment_course`
--

LOCK TABLES `class_assessment_course` WRITE;
/*!40000 ALTER TABLE `class_assessment_course` DISABLE KEYS */;
INSERT INTO `class_assessment_course` VALUES (54,1,5),(54,3,20),(54,4,30),(54,5,10),(54,6,35),(54,10,35),(55,3,10),(55,4,30),(55,5,20),(55,6,40),(55,10,30),(58,1,5),(58,3,10),(58,4,25),(58,5,15),(58,6,45),(58,10,30),(59,1,5),(59,3,10),(59,4,25),(59,5,15),(59,6,45),(59,10,30),(66,3,20),(66,4,30),(66,6,40),(66,10,30),(67,3,20),(67,4,30),(67,6,40),(67,10,30),(68,4,30),(68,5,20),(68,6,40),(68,10,30);
/*!40000 ALTER TABLE `class_assessment_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_session`
--

DROP TABLE IF EXISTS `class_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_session` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `instructor_id` int(11) NOT NULL,
  `group` int(11) DEFAULT NULL,
  `group_lab` int(11) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `academic_year` varchar(255) DEFAULT NULL,
  `group_theory` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_class_instructor` (`instructor_id`) USING BTREE,
  KEY `FK_class_course` (`course_id`),
  CONSTRAINT `FK_class_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_class_instructor` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_session`
--

LOCK TABLES `class_session` WRITE;
/*!40000 ALTER TABLE `class_session` DISABLE KEYS */;
INSERT INTO `class_session` VALUES (54,'IT013',2,NULL,NULL,2,'2020-2021',1),(55,'IT079',4,NULL,NULL,2,'2020-2021',1),(58,'IT093',1,NULL,NULL,2,'2020-2021',1),(59,'IT093',1,NULL,NULL,2,'2020-2021',2),(65,'IT011UN',7,NULL,NULL,2,'2020-2021',1),(66,'IT149',12,NULL,NULL,2,'2020-2021',1),(67,'IT132',11,NULL,NULL,2,'2020-2021',1),(68,'IT090',13,NULL,NULL,2,'2020-2021',2);
/*!40000 ALTER TABLE `class_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_slo_clo`
--

DROP TABLE IF EXISTS `class_slo_clo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_slo_clo` (
  `class_id` int(11) NOT NULL,
  `clo_id` int(11) NOT NULL,
  `slo_id` int(11) NOT NULL,
  `percentage` float DEFAULT NULL,
  PRIMARY KEY (`class_id`,`clo_id`,`slo_id`),
  KEY `FKecnfqj0x90g694r9lpkch9v65` (`clo_id`),
  KEY `FKpfxxfwt6crqhsnjdhn8ltf4cu` (`slo_id`),
  CONSTRAINT `FKecnfqj0x90g694r9lpkch9v65` FOREIGN KEY (`clo_id`) REFERENCES `learning_outcome` (`id`),
  CONSTRAINT `FKg1858kfovl46bais7h0263fgb` FOREIGN KEY (`class_id`) REFERENCES `class_session` (`id`),
  CONSTRAINT `FKpfxxfwt6crqhsnjdhn8ltf4cu` FOREIGN KEY (`slo_id`) REFERENCES `slo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_slo_clo`
--

LOCK TABLES `class_slo_clo` WRITE;
/*!40000 ALTER TABLE `class_slo_clo` DISABLE KEYS */;
INSERT INTO `class_slo_clo` VALUES (55,99,1,100),(55,100,2,100),(55,101,2,30),(55,101,6,70);
/*!40000 ALTER TABLE `class_slo_clo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clo_slo`
--

DROP TABLE IF EXISTS `clo_slo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clo_slo` (
  `slo_id` int(11) NOT NULL,
  `lo_id` int(11) NOT NULL,
  `percentage` float DEFAULT NULL,
  PRIMARY KEY (`lo_id`,`slo_id`),
  KEY `fk_clo_slo_learning_outcome` (`lo_id`),
  KEY `fk_clo_slo_slo` (`slo_id`),
  CONSTRAINT `FKnu0yp3vha8fgl05wo50ak1iwq` FOREIGN KEY (`slo_id`) REFERENCES `slo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_clo_slo_learning_outcome` FOREIGN KEY (`lo_id`) REFERENCES `learning_outcome` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clo_slo`
--

LOCK TABLES `clo_slo` WRITE;
/*!40000 ALTER TABLE `clo_slo` DISABLE KEYS */;
INSERT INTO `clo_slo` VALUES (1,99,100),(2,100,100),(2,101,30),(6,101,70);
/*!40000 ALTER TABLE `clo_slo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` varchar(255) NOT NULL,
  `course_level_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `name_vn` varchar(255) NOT NULL,
  `credit_theory` int(11) DEFAULT NULL,
  `credit_lab` int(11) DEFAULT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Course_CourseLevel` (`course_level_id`),
  CONSTRAINT `FK_course_course_level` FOREIGN KEY (`course_level_id`) REFERENCES `course_level` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('EE093',1,'Digital Signal Processing Laboratory','Thực hành Xử lý tín hiệu số',0,1,'This course is an introduction to the basic principles, methods, and applications of digital signal processing, emphasizing its algorithmic, computational, and programming aspects.'),('IS021',1,'Deterministic models in Operations Research','Các mô hình tất định',3,1,'This course is to introduce the fundamental methods used in deterministic operations research and to use of numerical analysis and linear algebra to solve industrial engineering problems. Topics to be covered include: problem formulations, simplex method in table form, duality theory, an introduction to the geometry of the simplex method, sensitivity analysis, and transportation and network flow problems.'),('IT007UN',1,'Skills for Communicating Information','',3,0,''),('IT011UN',1,'Functional Programming','',3,0,''),('IT011WE',1,'Skills for Communication','',3,0,''),('IT013',1,'Algorithms and Data Structure','Cấu trúc dữ liệu và giải thuật',3,1,'Provide an introduction to data structures and algorithms, including their design, analysis, and implementation.'),('IT017',1,'Operating Systems','Hệ điều hành',3,1,'This course presents the theory, design, implementation, and analysis of computer operating systems. Through classroom lectures, labs, projects and exercises, students learn the fundamentals of concurrency and process management, inter-process communication and synchronization, memory management, job scheduling algorithms, input/output management, file systems, security in operating systems. Course labs use the C/C++ language and include the design and implementation of portions of an operating system.'),('IT024',1,'Computer Graphics','Đồ hoạ máy tính',3,1,'This course provides students the fundamentals of computer graphics concepts, methodologies, and processes. It develop an understanding of the algorithms and fundamental techniques for generating and modifying pictures with a digital computer, including the handling of color, and the generation of visible-surface projections of three dimensional scenes, for applications in science, engineering, and the entertainment world.This course provides students the fundamentals of computer graphics concepts, methodologies, and processes. It develop an understanding of the algorithms and fundamental techniques for generating and modifying pictures with a digital computer, including the handling of color, and the generation of visible-surface projections of three dimensional scenes, for applications in science, engineering, and the entertainment world.prerequisitesIT116IU - C/C++ Programming,'),('IT044',1,'User Interface Design and Evaluation','',3,1,''),('IT045',1,'Network Design and Evaluation','Thiết kế và đánh giá mạng',3,1,'The course focuses on utilizing the top-down network design principle: designing a logical network to accommodate your current and future business plans. It addresses the technical and management aspects related to data networks design and use. It also equips the students with the technical skills required to compare and contrast between the various techniques related to data networking and the ability to develop selection criteria to choose from the available alternatives.'),('IT056',1,'Software Project Management','Quản trị dự án phần mềm',3,1,'This course provides students the fundamental software project management knowledge, with particular emphasis on software products, project management and contemporary issues in the delivery of software solutions to business. It considers plan-driven and agile methodologies, estimating techniques, change management, risk management, and the role of project management in business. And it identifies the managerial control and reporting aspects necessary from inception to implementation of a software development project.'),('IT058',1,'Thesis','Luận văn tốt nghiệp',0,10,'Dissertations are industrial projects designed to ensure that students have mastered their subjects in the program. All projects are based on \"real projects\" provided by the industry to students to develop skills and apply knowledge gained from all courses throughout the program. Students will work independently to develop requirements, design, implement and provide solutions to business problems. Students can follow any appropriate process model, must self-manage the project, follow all appropriate project management techniques. The success of the project is largely determined by whether the student adequately solves the client\'s problem.Students will provide the final product with all artifacts that match the process model being used (e.g. project plan, technical requirements, system architecture, design documentation, test plan, source code and installed software products).'),('IT064',1,'Introduction to Computing','Nhập môn tin học',3,0,'This course is to provide fundamentals and basic concepts of computer science and engineering, basics of Computing such as basic concepts, models, trends in industry. Introduction to majors and curricula, career path of all majors in computing, career orientation, job requirements and career opportunities in industry are also included in this course.'),('IT067',1,'Digital Logic Design','Thiết kế logic số',3,0,'This course is to provide fundamentals of logic design, such as: number presentation and codes, Boolean algebra and basic tools for design with combinational and sequential digital logic.'),('IT068',1,'Principles of Electrical Engineering I','Nguyên lý mạch điện 1',3,0,'This course covers the following topics: Circuit elements; Independent sources; Dependent sources; Circuit analysis in DC and AC steady state; Operational amplifiers; Power Computations; Two-port circuits; Balanced three-phase circuits. Special seminar(s)'),('IT069',1,'Object-Oriented Programming','Lập trình hướng đối tượng',3,1,'Introduction to object-oriented programming and design. Topics include: abstraction and encapsulation, classes and objects, method overloading, inheritance, method overriding, polymorphism and dynamic binding, abstract classes and interfaces, generic and container classes, exception handling and thread.'),('IT070',1,'Principles of Electrical Engineering II','Nguyên lý mạch điện 2',3,0,'This course covers the following topics: Transient analysis by classical methods and by Laplace transform analysis, step and impulse response. Passive and active filter circuit design. Introduction to Fourier series. Special seminars'),('IT074',1,'Electronics Devices','Linh kiện điện tử',3,0,'Fundamentals of semiconductor devices and microelectronic circuits, characteristics of p-n, Zener diodes, and analog diode circuits. Principles of MOSFET and BJT operation, biasing, transistor analysis at midband frequencies.'),('IT075',1,'Signals and Systems','Tín hiệu và hệ thống',3,0,'This course provides fundamentals of signals and systems and develops skills to analyze linear dynamic systems in both continuous and discrete-time domains. It covers the methods used to obtain the system response in both time domain (using convolution methods) and frequency domain (using Fourier, Laplace, and Z transform), and examine the stability of system. Special seminar(s)'),('IT076',1,'Software Engineering','Công nghệ phần mềm',3,1,'This course provides students the fundamentals of software engineering concepts, methodologies, and processes. It covers the subjects on software process models, agile development methodologies, requirements engineering and analysis models, software design and implementation methods, test strategies, and software evolution. Students apply contemporary agile requirements analysis, planning, architecture, design, implementation and testing practices to software engineering project work in small teams.'),('IT079',1,'Principles of Database Management','Nguyên lý quản trị cơ sở dữ liệu',3,1,'This subject introduces the students to basic database design and implementation concepts. Database design techniques, including relational design and E-R analysis, are presented. Database queries using SQL are covered in lectures and supported by practical exercises.'),('IT081',1,'Digital Electronics','Điện tử kỹ thuật số',3,0,'This course provides the background in digital electronics and gives an understanding of the fundamentals of digital hardware based on the principles of digital electronics and the implementation of logic gates with MOSFETs and BJTs. The course develops an understanding and the analysis of different logic families including NMOS, CMOS, TTL and ECL, and it provides the fundamentals of digital memory circuits. PSpice simulations'),('IT082',1,'Internship','Thực tập công nghiệp',0,3,'This course requires students to work in IT-related organizations or businesses from June to September. Each student has supervised by a faculty member at the School and an instructor at the organization. The student will join/run a technical project, and/or participate in soft skills courses. The internship lasts minimum 8 weeks and 3 sessions per week. Students have to report progress to instructors after 3 weeks of receiving the project. Depending on the project requirements of the organization or business, students may arrange for longer time. At the end of the internship, students will submit internship reports and assessment reports from the instructor at the organization or business to the School. Instructors read the reports and confirm the internship marks for the students. Students can also register this course in main semesters or take part in internships abroad for a period of 6 months. The registration and evaluation process are similar.'),('IT083',1,'Special Study of the Field','Thực tập tốt nghiệp',0,3,'Students are advised to select a subject under the guidance of a faculty member. Project content might be a research topic or building a new application that underlies the graduation thesis. Research topics include fields of academic program that are academic or practical.'),('IT089',1,'Computer Architecture','Cấu trúc máy tính',3,1,'This course provides students the principles of computer architecture and organization. It covers the subjects on assembly language and machine code, computer arithmetic and ALU design, computer performance, datapath and control, pipelining, memory hierarchy, I/O devices, multi-processor architectures, and mobile and multi-core processors.'),('IT090',1,'Object-oriented analysis and design','Phân tích và thiết kế hướng đối tượng',3,1,'This course help students learn about system life cycle development and the knowledge and skills required to develop object-oriented system. The course tries to solve the following questions•	What are design approaches other than object-oriented design? What is object-oriented design? •	What is a good design? How do you differentiate between a good and a bad design? What are the important characteristics of a good design?'),('IT091',1,'Computer Networks','Mạng máy tính',3,1,'This course covers the fundamental knowledge of computer networks such as OSI, TCP/IP models, network architectures, LAN, WAN, the typical network protocols. The students will also study to design, implement and monitor a small / medium scale network.'),('IT092',1,'Principles of Programming Languages','Nguyên lý ngôn ngữ lập trình',3,1,'This course helps students: Learn important principles of programming languages; Learn basic components of programming languages; Learn programming language paradigms; Improve programming and software engineering skills'),('IT093',1,'Web Application Development','Phát triển ứng dụng Web',3,1,'This course provides students the fundamentals of web design and web programming. It provide the concepts and models of HTML, Java Server Page, Java Bean, MVC model, Java utilities and development environments, extended Java frameworks as Ajax and Struts. To develop skills in understanding and evaluating web-based systems, as well as to develop skills in designing and developing web-based applications.'),('IT094',1,'Information System Management','Quản lý hệ thống thông tin',3,1,'This course will aim to provide students with:The concepts of information systems and their applications to business processes.Use of computer-based information systems in functional areas of business. Understanding of computer and information technology, resources, management and end-user decision making, and system development.'),('IT096',1,'Net-centric Programming','Lập trình mạng',3,1,'Advanced programming with a focus on developing software for networked systems using UNIX as a reference platform. Topics: Programming Tools, Software Design, Programming Techniques, Environment of a UNIX Process, Memory Allocation, Garbage Collection, Process Control, Process Relationships, Signals, Reliable Signals, Threads, I/O Multiplexing, Datagram and Stream Sockets, Multicasting, Device Driver and Kernel Programming, Secure Programming'),('IT097',1,'Introduction to Artificial Intelligence','Nhập môn trí tuệ nhân tạo',3,1,'This course introduces students to the basic knowledge on Artificial intelligence. Artificial intelligence (AI) is a research field that studies how to realize the intelligent human behaviors on a computer. The ultimate goal of AI is to make a computer that can learn, plan, and solve problems autonomously. In this course, student will learn the foundational principles and practice implementing some of these applications including representation, problem solving, and learning methods of artificial intelligence. Accordingly, students should be able to develop intelligent systems by assembling solutions to concrete computational problems; understand the role of knowledge representation, problem solving, and learning in intelligent-system engineering; and appreciate the role of problem solving, vision, and language in understanding human intelligence from a computational perspective.'),('IT098',1,'Principles of Electrical Engineering I Laboratory','Thực hành Nguyên lý mạch điện 1',0,1,'This course helps students to understand better the course Principles of Electrical Engineering I. Experimental exercises in use of laboratory instruments. Voltage, current, impedance, frequency, and waveform measurements. Rudiments of circuit modeling and design.'),('IT099',1,'Digital Logic Design Lab','Thực hành thiết kế logic số',0,1,'This course provides students the fundamentals of digital logic design concepts, a sequence of laboratory experiments to present and illustrate theory of digital logic design involving Logic gates, Combinational logic circuit, MSI combinational logic circuit, Flip Flops and Counters, Counter ICs, and Shift register. Students apply contemporary agile requirements analysis, implementation and testing practices to digital logic design project work in small teams.'),('IT100',1,'Signals and Systems Laboratory','Thực hành Tín hiệu và hệ thống',0,1,'This course covers the following topics: Experimental exercises via simulation using MATLAB to get understanding of frequency and time domain analysis of linear dynamic systems and corresponding signals. Finding the response of continuous- and discrete-time linear systems via simulation'),('IT101',1,'Electronics Devices Laboratory','Thực hành Linh kiện điện tử',0,1,'Laboratory experiments in microelectronic circuits using semiconductor devices, including diodes, MOSFETs and BJTs. Employing a learn-by-doing approach, emphasizing the hands-on-experimental experiences and computer simulation.'),('IT102',1,'Principles of Electrical Engineering II Laboratory','Thực hành Nguyên lý mạch điện 2',0,1,'This course covers the following topics: Experimental exercises in use of laboratory instruments; Filter design, construction, and simulation; measuring Fourier components of a periodic signal.'),('IT103',1,'Digital Signal Processing','Xử lý tín hiệu số',3,0,'This course is an introduction to the basic principles, methods, and applications of digital signal processing, emphasizing its algorithmic, computational, and programming aspects. In particular, the students will learn the conversion from analog to digital, the concepts of discrete time linear systems, filtering, spectral analysis of discrete time signals and filter design.'),('IT105',1,'Digital System Design','Thiết kế hệ thống số',3,0,'This course introduces methodology and techniques to design digital systems. The topics including the basic concepts, analysis, and system design with hardware description languages (HDL). The course provides an insight of the design of asynchronous sequential circuits and complex synchronous systems. Design process is introduced by concepts, documents, and simulation. .'),('IT106',1,'Digital System Design Lab','Thực hành Thiết kế hệ thống số',0,1,'This lab helps students understand better about techniques to design digital systems. This lab includes software and hardware topics: Introduction to Maxplus II software, Counter, Introduction to VHDL in Maxplus II, Digital Clock.'),('IT110',1,'Concepts in VLSI Design','Khái niệm thiết kế VLSI',3,0,'This course provides an introduction to digital VLSI chip design based on CMOS technology and including dynamic clocked logic, analog MOSFET timing analysis, and layout design rules. The course develops the use of computer-aided design software tools and cell library construction as well as an understanding of elementary circuit testing.'),('IT112',1,'Introduction to Distributed Computing','Giới thiệu tính toán phân tán',3,1,'This course presents the theory, design, implementation, and analysis of distributed systems. Through classroom lectures, labs, projects and exercises, students learn the fundamentals of distributed systems, system models, remote procedure call, distributed objects, operating system support, security in distributed systems, distributed file systems, concurrency, transaction and synchronization, replication. Course labs use the C/C++ language and include the design and implementation of portions of a distributed system.'),('IT114',1,'Software Architecture','Kiến trúc phần mềm',3,1,'Provides the student with a thorough understanding of varying methodologies and techniques in analysis, design and implementation of information system by using UML.'),('IT115',1,'Embedded Systems','Hệ thống nhúng',3,0,'This course addresses the considerations in designing real-time embedded systems, both from a hardware and software perspective. The primary emphasis is on real-time processing for communications and signal processing systems. Programming projects in a high level language like C/C++ will be an essential component of the course, as well as hardware design with modern design tools.'),('IT116',1,'C Programming','Lập trình C/C++',3,1,'This course concentrates on learning the basics of programming languages which is the foundations for further studies in IT. The course enables students to get familiar with C programming language. The course covers all basic C data structures, control flows, simple data structures as well as other advanced topics which include pointers, bit operators, file processing, dynamic data types.'),('IT117',1,'System and Network Security','Bảo mật hệ thống và mạng',3,1,'This course introduces students to cryptography systems (symmetric and public key encryptions), basic information theory, authentication and authorization, database security, malicious software, denial of service attacks, intrusion detection and prevention systems, firewalls, buffer overflow attack and software security, Internet security protocols and standards, Internet authentication applications, and wireless security.'),('IT120',1,'Entrepreneurship','Khởi nghiệp',3,0,'An introduction to the creative and innovative managerial practices of successful entrepreneurship. This course reviews the significant economic and social contributions entrepreneurs provide to society, the intense lifestyle commitment, and the skills necessary for entrepreneurial success. It explores how to identify and develop solutions to the most common leadership and personal challenges faced by entrepreneurs when starting new ventures or launching new products. It also promotes a deeper understanding of what is required to be a successful entrepreneur, highlights the skills and tools necessary to start a new business and explores alternatives to common pitfalls.This course applies entrepreneurial marketing approaches used by successful entrepreneurs. These include utilizing industry sector trends, identifying emerging customer niches, developing new products/services, using guerilla marketing strategies, and Internet and social marketing strategies. It emphasizes importance of managing cash flows, ratio analysis, pro forma development, and the basics of deal structure and harvesting a business venture. Students will identify and interpret sources of information from company financial reports, financial publications, industry benchmarks, the media, and web sites.An introduction to the process of researching, writing, and presenting a business plan. Students identify and screen ideas using a business feasibility study that describes the product features, market opportunity, customer profile, sales forecast, competitive advantage, and profit potential. Following a successful feasibility study, students may use business plan software as each develops their own complete business plan.'),('IT122',1,'Introduction to wireless networks','Nhập môn mạng không dây',3,1,'This course covers the fundamental knowledge of wireless and mobile networks such as wireless signal propagation, the techniques in wireless transmission, modulation, coding,... Several wireless networks are covered such as wi-fi, blueooth, zigbee, LTE, ... The MAC protocols, routing protocols used in wireless networks are also studied.Introduce new networking technologies, covering network topologies, example deployment concepts, protocols, and management techniques. Explains the different elements and technologies that are used in enterprise network and how they relate to each other. Focus on fundamental concepts and principles. Provides a solid technical foundation to successfully navigate network management topics and apply those concepts to particular situations.'),('IT123',1,'Digital Electronic Laboratory','Thực hành Điện tử kỹ thuật số',0,1,'This laboratory demonstrates transistor-level implementations of CMOS, TTL, and ECL logic gates, employing a learning-by-doing approach and emphasizing hands-on experimental experiences and computer simulations.'),('IT125',1,'System and Network Administration','Quản trị hệ thống mạng',3,1,'Introduce new networking technologies, covering network topologies, example deployment concepts, protocols, and management techniques. Explains the different elements and technologies that are used in enterprise network and how they relate to each other. Focus on fundamental concepts and principles. Provides a solid technical foundation to successfully navigate network management topics and apply those concepts to particular situations.'),('IT126',1,'Concepts in VLSI Design Laboratory','Thực hành Khái niệm thiết kế VLSI',0,1,'This laboratory provides an introduction to digital VLSI chip design based on the use of VLSI design tools to design a MIPS microprocessor chip. The laboratory employs a learning-by-doing approach, emphasizing hands-on practical design experiences and computer simulations.'),('IT127',1,'Embedded Systems Laboratory','Thực hành Hệ thống nhúng',0,1,'This course integrates microprocessors into digital systems. The course includes hardware interfacing, bus protocols and peripheral systems, embedded and real-time operating systems, real-time constraints, networking, and memory system.'),('IT128',1,'Micro-processing Systems','Hệ thống vi xử lý',3,0,'This course provides students the fundamentals of microprocessors and microcomputers; data flow; machine programming; assembly languages, architectures and instructions sets; stacks, subroutines, I/O, and interrupts; interfacing fundamentals; designing with microprocessors, and applications of micro-processing systems to some practical problems.'),('IT129',1,'Micro-processing Systems Lab','Thực hành Hệ thống vi xử lý',0,1,'In this course the students will study and do experiments with AVR microcontroller development KIT. Student will be able to practice with following topics : assembly languages, architectures and instructions sets; stacks, subroutines, I/O, and interrupts; peripheral interfacing fundamentals; designing with microprocessors, and applications of micro-processing systems to some practical problems.'),('IT130',1,'Digital Image Processing','Xử lý ảnh số',3,1,'This course helps students discuss on digital image processing fundamentals; review of Digital Signal Processing algorithms such as Discrete Fourier Transform; intensity transforms, frequency domain filtering; image restoration and reconstruction; color image processing; multiresolution processing; image compression; morphological image processing.'),('IT131',1,'Theoretical Models in Computing','Mô hình toán cho tin học',3,1,'This course is oriented to those undergraduate students who require a working knowledge of numerical methods. Topics to be covered include solving nonlinear equations and linear systems, interpolation and least square method, numerical evaluation of derivatives, integral and solution of differential equation. The focus will be on understanding the solving techniques and the engineering meaning of diver problems, and not on rigorous profs. �'),('IT132',1,'Introduction to data mining','Nhập môn khai thác dữ liệu',3,1,'This subject introduces the students to principles and algorithms of data mining, and requirements of a data mining process. Students will study data mining concepts and algorithms to solve problems of knowledge discovery. Students can develop skills of using recent data mining software for solving practical problems, and gain experience of doing independent study and research.'),('IT133',1,'Mobile Applicaton Development','Phát triển ứng dụng di động',3,1,'This course is designed to introduce and familiarize students with programming in the mobile environment: Android platform will be used throughout the course. The course start with introductions to basic components, concepts, structures of Android applications then move on with common user interface elements, persistent storage, database for mobile etc. Introduction to most common tools and techniques for writing Android application is also included with hands on experience in form of lab exercise programming project.'),('IT134',1,'Internet of Things','Internet vạn vật',3,1,'The course explains the architecture, components of Internet of Thing networks. The students will study the communication techniques between the components from short range to long range such as Bluetooth, Zigbee, Wi-fi, Lora, NB-IoT,… Moreover, the data storage, organization and analytics are also studied in this course.'),('IT135',1,'Introduction to Data Science','Nhập môn khoa học dữ liệu',3,0,'This subject will provide a broad introduction to four key aspects of data science: data retrieval and manipulation, data visualization, statistical computation and machine learning, and presentation and communication. Students will use data from a variety of sources, be introduced to contemporary computing and database environments such as R/Python and SQL, and be exposed to case studies from outside the classroom. Through this unit students will become acquainted with the challenges of contemporary data science and gain an appreciation of the foundational skills necessary to turn data into information.'),('IT136',1,'Regression Analysis','Phân tích hồi quy',3,1,'Regression analysis is one of the most powerful methods in statistics for determining the relationships between variables and using these relationships to forecast future observations. The foundation of regression analysis is very helpful for any kind of modelling exercises. Regression models are used to predict and forecast future outcomes. Its popularity in finance is very high; it is also very popular in other disciplines like life and biological sciences, management, engineering, etc.'),('IT137',1,'Data Analysis','Phân tích dữ liệu',3,1,'This course introduces fundamentals of data analysis by learning data analysis process together with descriptive statistics and inferential statistics. Students will study how to collect data, process and turn them into useful information and knowledge which are important to decision making. From raw data to useful information then to knowledge, students will examine a number of datasets and case studies from different perspectives. Students are able to develop practical solutions to problems in business and engineering, and gain hands-on experience of using contemporary data analysis tools.'),('IT138',1,'Data Science and Visualization','Khoa học dữ liệu và trực quan hoá dữ liệu',3,1,'The goal of this course is to introduce students to the key principles, methods, and techniques for effective visual analysis of data. The course begins with aims and key principles of data visualization. The course continues with different aspects of visualization including techniques and method for presenting different data types, and for discussing and analyzing visualizations. Thorough the course, students will be introduced to many visualization systems and visual tools via hand-on exercises.'),('IT139',1,'Scalable and Distributed Computing','Tính toán khả năng mở rộng và phân bố',3,1,'This course presents the theory, design, implementation, and analysis of distributed systems. Through classroom lectures, labs, projects and exercises, students learn the fundamentals of distributed systems, system models, remote procedure call, distributed objects, operating system support, security in distributed systems, distributed file systems, concurrency, transaction and synchronization, replication. The course also covers advanced topics related to cloud and distributed data processing technologies: data partitioning, storage schemes, stream processing, and parallel algorithms. Course labs explore modern Internet and cloud computing services running on multiple geographically distributed data centers: Google, Yahoo, Facebook, iTunes, Amazon, eBay, Bing, etc.'),('IT140',1,'Fundamental Concepts of Data Security','Khái niệm cơ bản về bảo mật dữ liệu',3,1,'This course introduces students to cryptographic principals and systems (symmetric and public key encryptions), and their applications in data security, secure communications, authentication and authorization. These core principles will be applied to the concepts of information risk management, and the analysis and handling of compromised systems. The ethics around computer crime, privacy, and intellectual property are covered in detail. Finally, the unit will cover the criteria and controls for information classification.'),('IT141',1,'Big Data Applications - Machine Learning at Scale','Ứng dụng dữ liệu lớn: Máy học ở qui mô lớn',3,1,'The goal of this course is to equip students with the understanding, knowledge, and practical skills to develop big data solutions with the state-of-the-art big data management tools, particularly those in the Hadoop ecosystem, with a focus on programming models including MapReduce, Hive, Pig, and Apache Spark. .'),('IT142',1,'Analytics for Observational Data','Phân tích dữ liệu quan sát',3,1,'This subject explains the principles and practice of modelling and analysing observational data, with an emphasis on practical application. The core concepts are probability modelling and prediction. Probability models for various kinds of data are introduced, including models for counts of events, categorical values and waiting times. The main focus is on analysing several or many variables, including techniques, such as, correlation, discrimination, principal components, model selection, and classification methods.'),('IT143',1,'Fundamentals of Big Data Technology','Nền tảng công nghệ dữ liệu lớn',3,1,'Fundamentals of Big Data Technology provides baseline general knowledge of the technologies used in Big Data solutions. It covers the development of  solutions using the Hadoop ecosystem, including MapReduce, HDFS, Apache Pig and Hive programming frameworks. This course helps students build a foundation for working with Apache Big Data solutions.'),('IT144',1,'Business Process Analysis','Phân tích quy trình nghiệp vụ',3,1,'Every organization thrives to implement effective business processes to increase employee and customer satisfaction, enhance business performance, reduce costs and boost productivity. All activities including altering critical processes, merging or splitting business units require a consistent framework to manage the changes. The course aims to provide fundamental knowledge of business process analysis, improvement and evaluation. Various approaches, techniques and software tools used to analyze and manage business process improvement are also introduced in the course.'),('IT145',1,'Decision support systems','Hệ thống hỗ trợ quyết định',3,1,'A Decision Support System (DSS) is an interactive computer-based system or subsystem intended to help decision makers use communications technologies, data, documents, knowledge and/or models to identify and solve problems, complete decision process tasks, and make decisions. DSS simulate cognitive decision-making functions of humans based on artificial intelligence methodologies (including expert systems, data mining, machine learning, connectionism, logistical reasoning, etc.) in order to perform decision support functions. DSS is a general term for any computer application that enhances a person or group’s ability to make decisions. Also, DSS refers to an academic field of research that involves designing and studying DSS in their context of using.'),('IT146',1,'Theory of networks','Lý thuyết mạng máy tính',3,1,'The course introduces the interconnectedness of modern life, answers the fundamental questions about how our social, economic, and technological worlds are connected. Students will study the modern network models, such as, game theory, the structure of the Internet, social contagion, the spread of social power and popularity, and information cascades.'),('IT147',1,'Mobile Cloud Computing','Điện toán đám mây di động',3,1,'This course introduces the fundamentals of mobile cloud computing including mobile computing on smartphones, cloud computing on the data center, the combination of mobile, cloud computing and applications, and programming on smartphones using cloud services. Through classroom lectures, hands-on exercises, small and large assignments, students have knowledge of smartphone programming, cloud computing platforms, and support for cloud computing and applications. The exercises focus on the Java platform, Android and cloud computing and Internet services that run on a number of globally distributed data centers such as Google, Yahoo, Facebook, iTunes, Amazon, eBay, Bing, etc.'),('IT148',1,'Experimental Design','Thiết kế thực nghiệm',3,1,'This subject provides students with skills of carrying out fully designed experiments, which can be used in a research paper, thesis, or dissertation proposal. Students will walk through controlled experiments and field experiments, single factor experiments and factorial designs, manipulation checks, etc., and be able to decide which of these experiments is best used in the creation of their own experiments, including making the stimuli and questionnaire.'),('IT149',1,'Fundamentals of Programming','Lập trình cơ bản',3,1,'This course concentrates on learning the basics of programming languages which is the foundations for further studies in IT. The course enables students to get familiar with C programming language in UNIX environment. The course covers all basic C data structures, control flows, simple data structures as well as other advanced topics which include pointers, bit operators, file processing, dynamic data types.'),('IT150',1,'Blockchain','Blockchain',3,1,'This subject introduces the students the foundation of blockchain technology and its applications. Students will study blockchain concepts and principles how it works. This course covers relevant topics blockchain space. The course starts with the basics of blockchain, cryptography, fundamental understanding of bitcoins. Then, the applications of blockchain technology is introduced in different areas of finance, healthcare, supply chain, etc. A complete picture of the ecosystem surrounding blockchain technology and development trends are also discussed.'),('IT151',1,'Statistical Method','Phương pháp thống kê',3,0,'Provides students with a background in the statistical methods that assist in the analysis of data, including summarizing and describing data and techniques for inference. Topics include basic probability distributions (e.g. normal, binomial), expected value, estimation (maximum likelihood, confidence intervals), hypothesis testing, and multiple regression analysis.'),('IT152',1,'Data Mining for IOTs','Khai thác dữ liệu trong IOT',3,1,'This subject introduces the students to principles and algorithms of data mining for internet of things applications. Students will study basic concepts, working principles and general architectures of different IOT frame works for practical applications such as smart healthcare, smart manufacturing, smart agriculture, etc. Students can develop practical data mining for solving practical problems, and gain experience of doing independent study and research.'),('IT153',1,'Discrete Mathematics','Toán rời rạc',3,0,'This course provides students the based knowledge of discrete mathematics. To develop the ability to reason and think mathematically and logically; and to apply this ability to analyzing and solving discrete practical problems in computer science. This is an application-oriented course based upon the study of events that occur in small, or discrete in computer science, segments in business, industry, government and the digital areas. Students will be introduced to the mathematical tools of logic and set theory, counting, number theory, and graph theory. Practical applications will be introduced throughout the course'),('IT154',1,'Linear Algebra','Đại số tuyến tính cho khoa học dữ liệu',3,0,''),('IT155',1,'Optimization','Tối ưu hoá',3,0,'This course is to introduce the fundamental methods used in deterministic operations research and to use of numerical analysis and linear algebra to solve industrial engineering problems. Topics to be covered include: problem formulations, simplex method in table form, duality theory, an introduction to the geometry of the simplex method, sensitivity analysis, transportation and network flow problems.'),('IT501',2,'Advanced Networking','Mạng máy tính nâng cao',3,1,''),('IT502',2,'Advanced Database','Cơ sở dữ liệu nâng cao',3,1,''),('IT503',2,'Programming Methodology','Phương pháp lập trình',2,0,''),('IT521',2,'Software Designs and Architectures','Thiết kế và kiến trúc phần mềm',3,1,''),('IT522',2,'Data Warehousing and Data Mining','Kho dữ liệu và Khai phá dữ liệu',3,1,''),('IT523',2,'User Interface','Giao diện Người dùng',3,1,''),('IT524',2,'Web Application Development','Phát triển ứng dụng Web',3,1,''),('IT525',2,'Information System Security','An ninh Hệ thống Thông tin',3,1,''),('IT531',2,'Network Management','Quản lý mạng',3,1,''),('IT532',2,'Distributed Computing','Tính toán phân bố',3,1,''),('IT533',2,'Wireless and Mobile Network','Mạng không dây',3,1,''),('IT534',2,'Network Application Development','Phát triển ứng dụng mạng',3,1,''),('IT535',2,'Advanced Operating System','Hệ điều hành nâng cao',3,1,''),('IT541',2,'E-Commerce','Thương mại điện tử',3,1,''),('IT542',2,'Information System Management','Quản trị Hệ thống Thông tin',3,1,''),('IT543',2,'IT Project Management','Quản trị dự án CNTT',3,1,''),('IT544',2,'Network Security','An toàn Mạng Máy tính',3,1,''),('IT545',2,'Algorithm Optimization','Tối ưu hóa giải thuật',3,1,''),('IT561_1',2,'Thesis (Research)','Luận văn tốt nghiệp',0,32,''),('IT561_2',2,'Thesis (Course Work)','Luận văn tốt nghiệp',0,12,''),('PE501',2,'Research Methodology','Phương pháp luận NCKH',2,0,''),('PE502',2,'Professional Ethics','Đạo đức nghề nghiệp',2,0,''),('UFCF7H-15-3',1,'Mobile Applications','',15,0,''),('UFCFB5-15-3',1,'Ethical and Professional Issues in','',15,0,''),('UFCFEL-15-3',1,'Security Data Analytics and Visualization','',15,0,''),('UFCFFC-30-3',1,'Information Technology Project','',30,0,''),('UFCFJP-15-3',1,'Big Data Analytics','',15,0,''),('UFCFRB-15-3',1,'Security Management in Practice','',15,0,''),('UFCFX3-15-3',1,'Advanced Topics in Web Development','',15,0,'');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_assessment`
--

DROP TABLE IF EXISTS `course_assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_assessment` (
  `assessment_id` int(11) NOT NULL,
  `course_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `percentage` int(11) NOT NULL,
  PRIMARY KEY (`assessment_id`,`course_id`),
  KEY `Fk_AssessmentCourse_Course` (`course_id`),
  CONSTRAINT `FK_course_assessment_assessment` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Fk_AssessmentCourse_Course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_assessment`
--

LOCK TABLES `course_assessment` WRITE;
/*!40000 ALTER TABLE `course_assessment` DISABLE KEYS */;
INSERT INTO `course_assessment` VALUES (1,'IS021',20),(1,'IT013',5),(1,'IT017',10),(1,'IT024',10),(1,'IT045',30),(1,'IT056',10),(1,'IT064',10),(1,'IT067',30),(1,'IT068',30),(1,'IT069',5),(1,'IT070',30),(1,'IT076',10),(1,'IT089',30),(1,'IT090',10),(1,'IT091',5),(1,'IT092',30),(1,'IT093',5),(1,'IT094',20),(1,'IT096',10),(1,'IT097',10),(1,'IT099',60),(1,'IT105',15),(1,'IT106',40),(1,'IT110',20),(1,'IT112',10),(1,'IT115',30),(1,'IT116',10),(1,'IT117',30),(1,'IT120',30),(1,'IT122',5),(1,'IT126',30),(1,'IT127',70),(1,'IT130',10),(1,'IT131',10),(1,'IT132',10),(1,'IT134',5),(1,'IT135',10),(1,'IT136',10),(1,'IT137',10),(1,'IT138',10),(1,'IT139',10),(1,'IT141',10),(1,'IT142',10),(1,'IT143',10),(1,'IT144',10),(1,'IT145',10),(1,'IT146',5),(1,'IT147',10),(1,'IT148',10),(1,'IT149',10),(1,'IT150',10),(1,'IT152',10),(1,'IT153',20),(1,'IT155',30),(3,'IT013',20),(3,'IT024',20),(3,'IT069',20),(3,'IT079',10),(3,'IT091',20),(3,'IT093',10),(3,'IT096',20),(3,'IT097',20),(3,'IT098',70),(3,'IT105',15),(3,'IT106',20),(3,'IT112',10),(3,'IT116',20),(3,'IT122',20),(3,'IT125',20),(3,'IT126',30),(3,'IT130',20),(3,'IT131',20),(3,'IT132',20),(3,'IT133',25),(3,'IT134',20),(3,'IT135',20),(3,'IT136',20),(3,'IT137',20),(3,'IT138',20),(3,'IT139',20),(3,'IT141',20),(3,'IT142',20),(3,'IT143',20),(3,'IT144',20),(3,'IT145',25),(3,'IT146',20),(3,'IT147',20),(3,'IT148',20),(3,'IT149',20),(3,'IT150',20),(3,'IT151',20),(3,'IT152',20),(4,'IS021',30),(4,'IT013',30),(4,'IT017',30),(4,'IT024',25),(4,'IT045',30),(4,'IT056',30),(4,'IT058',30),(4,'IT064',30),(4,'IT067',30),(4,'IT068',30),(4,'IT069',30),(4,'IT070',30),(4,'IT076',30),(4,'IT079',30),(4,'IT082',50),(4,'IT083',50),(4,'IT089',30),(4,'IT090',30),(4,'IT091',30),(4,'IT092',30),(4,'IT093',25),(4,'IT094',20),(4,'IT096',30),(4,'IT097',30),(4,'IT105',30),(4,'IT110',30),(4,'IT112',30),(4,'IT115',30),(4,'IT116',30),(4,'IT117',30),(4,'IT120',30),(4,'IT122',30),(4,'IT125',30),(4,'IT130',30),(4,'IT131',30),(4,'IT132',30),(4,'IT133',30),(4,'IT134',30),(4,'IT135',30),(4,'IT136',30),(4,'IT137',30),(4,'IT138',30),(4,'IT139',30),(4,'IT141',30),(4,'IT142',30),(4,'IT143',30),(4,'IT144',30),(4,'IT145',30),(4,'IT146',30),(4,'IT147',30),(4,'IT148',30),(4,'IT149',30),(4,'IT150',30),(4,'IT151',30),(4,'IT152',30),(4,'IT153',30),(4,'IT155',30),(5,'IS021',10),(5,'IT013',10),(5,'IT017',20),(5,'IT056',20),(5,'IT064',20),(5,'IT069',10),(5,'IT076',20),(5,'IT079',20),(5,'IT090',20),(5,'IT091',10),(5,'IT093',15),(5,'IT094',20),(5,'IT106',40),(5,'IT112',10),(5,'IT122',10),(5,'IT125',10),(5,'IT126',40),(5,'IT133',15),(5,'IT134',10),(5,'IT146',10),(5,'IT151',10),(6,'IS021',40),(6,'IT013',35),(6,'IT017',40),(6,'IT024',45),(6,'IT045',40),(6,'IT056',40),(6,'IT058',70),(6,'IT064',40),(6,'IT067',40),(6,'IT068',40),(6,'IT069',35),(6,'IT070',40),(6,'IT076',40),(6,'IT079',40),(6,'IT082',50),(6,'IT083',50),(6,'IT089',40),(6,'IT090',40),(6,'IT091',35),(6,'IT092',40),(6,'IT093',45),(6,'IT094',40),(6,'IT096',40),(6,'IT097',40),(6,'IT098',30),(6,'IT099',40),(6,'IT105',40),(6,'IT110',50),(6,'IT112',40),(6,'IT115',40),(6,'IT116',40),(6,'IT117',40),(6,'IT120',40),(6,'IT122',35),(6,'IT125',40),(6,'IT127',30),(6,'IT130',40),(6,'IT131',40),(6,'IT132',40),(6,'IT133',40),(6,'IT134',35),(6,'IT135',40),(6,'IT136',40),(6,'IT137',40),(6,'IT138',40),(6,'IT139',40),(6,'IT141',40),(6,'IT142',40),(6,'IT143',40),(6,'IT144',40),(6,'IT145',35),(6,'IT146',35),(6,'IT147',40),(6,'IT148',40),(6,'IT149',40),(6,'IT150',40),(6,'IT151',40),(6,'IT152',40),(6,'IT153',50),(6,'IT155',40),(10,'IS021',30),(10,'IT013',35),(10,'IT017',30),(10,'IT024',30),(10,'IT045',30),(10,'IT056',30),(10,'IT064',30),(10,'IT067',30),(10,'IT068',30),(10,'IT069',35),(10,'IT070',30),(10,'IT076',30),(10,'IT079',30),(10,'IT089',30),(10,'IT090',30),(10,'IT091',35),(10,'IT092',30),(10,'IT093',30),(10,'IT094',40),(10,'IT096',30),(10,'IT097',30),(10,'IT098',70),(10,'IT099',60),(10,'IT105',30),(10,'IT106',100),(10,'IT110',20),(10,'IT112',30),(10,'IT115',30),(10,'IT116',30),(10,'IT117',30),(10,'IT120',30),(10,'IT122',35),(10,'IT125',30),(10,'IT126',100),(10,'IT127',70),(10,'IT130',30),(10,'IT131',30),(10,'IT132',30),(10,'IT133',40),(10,'IT134',35),(10,'IT135',30),(10,'IT136',30),(10,'IT137',30),(10,'IT138',30),(10,'IT139',30),(10,'IT141',30),(10,'IT142',30),(10,'IT143',30),(10,'IT144',30),(10,'IT145',35),(10,'IT146',35),(10,'IT147',30),(10,'IT148',30),(10,'IT149',30),(10,'IT150',30),(10,'IT151',30),(10,'IT152',30),(10,'IT153',20),(10,'IT155',30);
/*!40000 ALTER TABLE `course_assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_level`
--

DROP TABLE IF EXISTS `course_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_level`
--

LOCK TABLES `course_level` WRITE;
/*!40000 ALTER TABLE `course_level` DISABLE KEYS */;
INSERT INTO `course_level` VALUES (1,'Undergraduate'),(2,'Master');
/*!40000 ALTER TABLE `course_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_program`
--

DROP TABLE IF EXISTS `course_program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_program` (
  `course_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `program_id` int(11) NOT NULL,
  `course_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_type_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`,`program_id`),
  KEY `course_id` (`course_id`),
  KEY `fk2_idx` (`program_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_program`
--

LOCK TABLES `course_program` WRITE;
/*!40000 ALTER TABLE `course_program` DISABLE KEYS */;
INSERT INTO `course_program` VALUES ('EE093',2,'EE093IU',3),('IS021',1,'IS021IU',3),('IT007UN',17,'IT007UN',4),('IT007UN',18,'IT007UN',4),('IT007UN',21,'IT007UN',4),('IT011UN',17,'IT011UN',4),('IT011UN',18,'IT011UN',4),('IT011UN',21,'IT011UN',4),('IT011UN',36,'IT011DE',4),('IT011WE',22,'IT011WE',4),('IT013',1,'IT013IU',4),('IT013',2,'IT013IU',4),('IT013',3,'IT013IU',4),('IT013',4,'IT013IU',4),('IT013',9,'IT013IU',4),('IT013',10,'IT013IU',4),('IT013',11,'IT013IU',4),('IT013',12,'IT013IU',4),('IT013',13,'IT072RG',4),('IT013',14,'IT072RG',4),('IT013',15,'IT072SB',4),('IT013',16,'IT072SB',4),('IT013',19,'IT072WE',4),('IT013',20,'IT072WE',4),('IT013',22,'IT013WE',4),('IT013',31,'IT013DE',4),('IT013',32,'IT013DE',4),('IT013',33,'IT013DE',4),('IT013',34,'IT013DE',4),('IT013',35,'IT013DE',4),('IT013',36,'IT013DE',4),('IT017',2,'IT017IU',2),('IT017',3,'IT017IU',2),('IT017',4,'IT017IU',2),('IT017',10,'IT017IU',2),('IT017',11,'IT017IU',2),('IT017',12,'IT017IU',2),('IT017',22,'IT017WE',2),('IT017',36,'IT017DE',2),('IT024',4,'IT024IU',3),('IT024',22,'IT024WE',3),('IT044',22,'IT044WE',3),('IT045',3,'IT045IU',3),('IT056',1,'IT056IU',3),('IT056',2,'IT056IU',3),('IT056',3,'IT056IU',3),('IT056',4,'IT056IU',3),('IT058',1,'IT058IU',5),('IT058',2,'IT058IU',5),('IT058',3,'IT058IU',5),('IT058',4,'IT058IU',5),('IT058',9,'IT058IU',5),('IT058',10,'IT058IU',5),('IT058',11,'IT058IU',5),('IT058',12,'IT058IU',5),('IT064',2,'IT064IU',4),('IT064',3,'IT064IU',4),('IT064',4,'IT064IU',4),('IT064',10,'IT064IU',4),('IT064',11,'IT064IU',4),('IT064',12,'IT064IU',4),('IT064',13,'IT064RG',4),('IT064',14,'IT064RG',4),('IT064',15,'IT064SB',4),('IT064',16,'IT064SB',4),('IT064',17,'IT064UN',4),('IT064',18,'IT064UN',4),('IT064',19,'IT064WE',4),('IT064',20,'IT064WE',4),('IT064',21,'IT064UN',4),('IT064',22,'IT064WE',4),('IT064',31,'IT064DE',4),('IT064',32,'IT064DE',4),('IT064',33,'IT064DE',4),('IT064',34,'IT064DE',4),('IT064',35,'IT064DE',4),('IT064',36,'IT064DE',4),('IT067',2,'IT067IU/EE053IU',4),('IT067',3,'IT067IU/EE053IU',4),('IT067',4,'IT067IU/EE053IU',4),('IT067',10,'IT067IU',4),('IT067',11,'IT067IU',4),('IT067',12,'IT067IU',4),('IT067',13,'EE053RG',4),('IT067',14,'EE053RG',4),('IT067',15,'EE053SB',4),('IT067',16,'EE053SB',4),('IT067',17,'IT067UN',4),('IT067',18,'IT067UN',4),('IT067',19,'EE053WE',4),('IT067',20,'EE053WE',4),('IT067',21,'IT067UN',4),('IT067',22,'IT067WE',4),('IT067',34,'IT067DE',4),('IT067',35,'IT067DE',4),('IT068',2,'IT068IU/EE051IU',2),('IT068',10,'EE051IU',2),('IT068',13,'EE051RG',2),('IT068',14,'EE051RG',2),('IT068',15,'EE051SB',2),('IT068',16,'EE051SB',2),('IT068',19,'EE051WE',2),('IT068',20,'EE051WE',2),('IT068',33,'EE051DE',2),('IT068',36,'EE051DE',2),('IT069',1,'IT069IU',4),('IT069',2,'IT069IU',4),('IT069',3,'IT069IU',4),('IT069',4,'IT069IU',4),('IT069',9,'IT069IU',4),('IT069',10,'IT069IU',4),('IT069',11,'IT069IU',4),('IT069',12,'IT069IU',4),('IT069',13,'IT069RG',4),('IT069',14,'IT069RG',4),('IT069',15,'IT069SB',4),('IT069',16,'IT069SB',4),('IT069',17,'IT069UN',4),('IT069',18,'IT069UN',4),('IT069',19,'IT069WE',4),('IT069',20,'IT069WE',4),('IT069',21,'IT069UN',4),('IT069',22,'IT069WE',4),('IT069',31,'IT069DE',4),('IT069',32,'IT069DE',4),('IT069',33,'IT069DE',4),('IT069',34,'IT069DE',4),('IT069',35,'IT069DE',4),('IT069',36,'IT069DE',4),('IT070',2,'IT070IU/EE055IU',2),('IT070',10,'EE055IU',2),('IT070',13,'EE055RG',2),('IT070',14,'EE055RG',2),('IT070',15,'EE055SB',2),('IT070',16,'EE055SB',2),('IT070',19,'EE055WE',2),('IT070',20,'EE055WE',2),('IT070',33,'EE055DE',2),('IT070',36,'EE055DE',2),('IT074',2,'IT074IU/EE090IU',2),('IT074',10,'EE090IU',2),('IT075',2,'IT075IU/EE088IU',2),('IT075',10,'EE088IU',2),('IT076',2,'IT076IU',2),('IT076',3,'IT076IU',2),('IT076',4,'IT076IU',2),('IT076',10,'IT076IU',2),('IT076',11,'IT076IU',2),('IT076',12,'IT076IU',2),('IT076',17,'IT076UN',2),('IT076',18,'IT076UN',2),('IT076',21,'IT076UN',2),('IT076',22,'IT076WE',2),('IT076',36,'IT076DE',2),('IT079',1,'IT079IU',4),('IT079',3,'IT079IU',4),('IT079',4,'IT079IU',4),('IT079',9,'IT079IU',4),('IT079',11,'IT079IU',4),('IT079',12,'IT079IU',4),('IT079',17,'IT079UN',4),('IT079',18,'IT079UN',4),('IT079',21,'IT079UN',4),('IT079',22,'IT079WE',4),('IT079',31,'IT079DE',4),('IT079',32,'IT079DE',4),('IT079',33,'IT079DE',4),('IT079',34,'IT079DE',4),('IT079',35,'IT079DE',4),('IT079',36,'IT079DE',4),('IT081',2,'IT081IU/EE094IU',2),('IT081',10,'EE094IU',2),('IT082',1,'IT082IU',5),('IT082',2,'IT082IU',5),('IT082',3,'IT082IU',5),('IT082',4,'IT082IU',5),('IT082',9,'IT082IU',5),('IT082',10,'IT082IU',5),('IT082',11,'IT082IU',5),('IT082',12,'IT082IU',5),('IT082',22,'IT082WE',5),('IT083',1,'IT083IU',5),('IT083',2,'IT083IU',5),('IT083',3,'IT083IU',5),('IT083',4,'IT083IU',5),('IT083',9,'IT083IU',5),('IT083',10,'IT083IU',5),('IT083',11,'IT083IU',5),('IT083',12,'IT083IU',5),('IT089',2,'IT089IU',4),('IT089',3,'IT089IU',4),('IT089',4,'IT089IU',4),('IT089',10,'IT089IU',4),('IT089',11,'IT089IU',4),('IT089',12,'IT089IU',4),('IT089',13,'IT089RG',4),('IT089',14,'IT089RG',4),('IT089',15,'IT089SB',4),('IT089',16,'IT089SB',4),('IT089',17,'IT089UN',4),('IT089',18,'IT089UN',4),('IT089',19,'IT089WE',4),('IT089',20,'IT089WE',4),('IT089',21,'IT089UN',4),('IT089',22,'IT089WE',4),('IT089',31,'IT089DE',4),('IT089',32,'IT089DE',4),('IT089',33,'IT089DE',4),('IT089',34,'IT089DE',4),('IT089',35,'IT089DE',4),('IT089',36,'IT089DE',4),('IT090',1,'IT090IU',4),('IT090',3,'IT090IU',4),('IT090',4,'IT090IU',4),('IT090',9,'IT090IU',4),('IT090',11,'IT090IU',4),('IT090',12,'IT090IU',4),('IT090',22,'IT090WE',4),('IT090',31,'IT090DE',4),('IT090',32,'IT090DE',4),('IT090',34,'IT090DE',4),('IT090',35,'IT090DE',4),('IT091',3,'IT091IU',4),('IT091',4,'IT091IU',4),('IT091',11,'IT091IU',4),('IT091',12,'IT091IU',4),('IT091',22,'IT091WE',4),('IT091',31,'IT091DE',4),('IT091',32,'IT091DE',4),('IT091',33,'IT091DE',4),('IT091',36,'IT091DE',4),('IT092',4,'IT092IU',2),('IT092',12,'IT092IU',2),('IT092',22,'IT092WE',2),('IT093',3,'IT093IU',2),('IT093',4,'IT093IU',2),('IT093',11,'IT093IU',2),('IT093',12,'IT093IU',2),('IT093',17,'IT093UN',2),('IT093',18,'IT093UN',2),('IT093',21,'IT093UN',2),('IT093',22,'IT093WE',2),('IT094',1,'IT094IU',3),('IT094',3,'IT094IU',2),('IT094',4,'IT094IU',3),('IT094',11,'IT094IU',2),('IT094',22,'IT094WE',3),('IT096',3,'IT096IU',2),('IT096',4,'IT096IU',3),('IT096',11,'IT096IU',2),('IT096',22,'IT096WE',3),('IT097',1,'IT097IU',4),('IT097',4,'IT097IU',2),('IT097',9,'IT097IU',4),('IT097',12,'IT097IU',2),('IT097',17,'IT097UN',4),('IT097',18,'IT097UN',4),('IT097',21,'IT097UN',4),('IT097',22,'IT097WE',2),('IT098',2,'IT098IU/EE052IU',2),('IT098',10,'EE052IU',2),('IT098',13,'EE052RG',2),('IT098',14,'EE052RG',2),('IT098',15,'EE052SB',2),('IT098',16,'EE052SB',2),('IT098',19,'EE052WE',2),('IT098',20,'EE052WE',2),('IT098',33,'EE052DE',2),('IT098',36,'EE052DE',2),('IT099',2,'IT099IU/EE054IU',4),('IT099',3,'IT099IU/EE054IU',4),('IT099',4,'IT099IU/EE054IU',4),('IT099',10,'IT099IU',4),('IT099',11,'IT099IU',4),('IT099',12,'IT099IU',4),('IT099',13,'EE054RG',4),('IT099',14,'EE054RG',4),('IT099',15,'EE054SB',4),('IT099',16,'EE054SB',4),('IT099',17,'IT099UN',4),('IT099',18,'IT099UN',4),('IT099',19,'EE054WE',4),('IT099',20,'EE054WE',4),('IT099',21,'IT099UN',4),('IT099',22,'IT099WE',4),('IT099',34,'IT099DE',4),('IT099',35,'IT099DE',4),('IT100',2,'IT100IU/EE089IU',2),('IT100',10,'EE089IU',2),('IT101',2,'IT101IU/EE091IU',2),('IT101',10,'EE091IU',2),('IT102',2,'IT102IU/EE056IU',2),('IT102',10,'EE056IU',2),('IT102',13,'EE056RG',2),('IT102',14,'EE056RG',2),('IT102',15,'EE056SB',2),('IT102',16,'EE056SB',2),('IT102',19,'EE056WE',2),('IT102',20,'EE056WE',2),('IT102',33,'EE056DE',2),('IT102',36,'EE056DE',2),('IT103',2,'EE092IU',3),('IT105',2,'IT105IU/EE063IU',2),('IT105',10,'EE063IU',2),('IT106',2,'IT106IU/EE117IU',2),('IT106',10,'EE117IU',2),('IT110',2,'EE066IU',3),('IT112',3,'IT112IU',3),('IT114',4,'IT114IU',3),('IT115',2,'EE104IU',3),('IT116',2,'IT116IU',4),('IT116',3,'IT116IU',4),('IT116',4,'IT116IU',4),('IT116',10,'IT116IU',4),('IT116',11,'IT016IU',4),('IT116',12,'IT116IU',4),('IT116',13,'IT116RG',4),('IT116',14,'IT116RG',4),('IT116',15,'IT116SB',4),('IT116',16,'IT116SB',4),('IT116',17,'IT065UN',4),('IT116',18,'IT065UN',4),('IT116',19,'IT116WE',4),('IT116',20,'IT116WE',4),('IT116',21,'IT065UN',4),('IT116',22,'IT116WE',4),('IT116',31,'IT116DE',4),('IT116',32,'IT116DE',4),('IT116',33,'IT116DE',4),('IT116',34,'IT116DE',4),('IT116',35,'IT116DE',4),('IT116',36,'IT116DE',4),('IT117',3,'IT117IU',2),('IT117',11,'IT117IU',2),('IT120',1,'IT120IU',3),('IT120',2,'IT120IU',6),('IT120',3,'IT120IU',6),('IT120',4,'IT120IU',6),('IT120',10,'IT120IU',6),('IT120',11,'IT120IU',6),('IT120',12,'IT120IU',6),('IT120',22,'IT120WE',6),('IT122',3,'IT122IU',3),('IT123',2,'IT123IU/EE095IU',2),('IT123',10,'EE095IU',2),('IT125',3,'IT125IU',3),('IT126',2,'EE121IU',3),('IT127',2,'EE118IU',3),('IT128',2,'IT128IU/EE083IU',2),('IT128',10,'EE083IU',2),('IT129',2,'IT129IU/EE084IU',2),('IT129',10,'EE084IU',2),('IT130',3,'IT130IU',3),('IT130',4,'IT130IU',3),('IT131',3,'IT131IU',4),('IT131',4,'IT131IU',4),('IT131',11,'IT131IU',4),('IT131',12,'IT131IU',4),('IT131',17,'IT063UN',4),('IT131',18,'IT063UN',4),('IT131',21,'IT063UN',4),('IT131',22,'IT131WE',4),('IT131',31,'IT131DE',4),('IT131',32,'IT131DE',4),('IT131',34,'IT131DE',4),('IT131',35,'IT131DE',4),('IT132',1,'IT132IU',2),('IT132',2,'IT132IU',3),('IT132',3,'IT132IU',3),('IT132',4,'IT132IU',3),('IT132',9,'IT132IU',2),('IT132',10,'IT132IU',3),('IT133',2,'IT133IU',3),('IT133',3,'IT133IU',3),('IT133',4,'IT133IU',3),('IT133',10,'IT133IU',3),('IT134',2,'IT134IU',3),('IT134',3,'IT134IU',3),('IT134',4,'IT134IU',3),('IT134',10,'IT134IU',3),('IT135',1,'IT135IU',4),('IT135',9,'IT135IU',4),('IT136',1,'IT136IU',2),('IT136',9,'IT136IU',2),('IT137',1,'IT137IU',2),('IT137',9,'IT137IU',2),('IT138',1,'IT138IU',2),('IT138',4,'IT138IU',2),('IT138',9,'IT138IU',2),('IT139',1,'IT139IU',2),('IT139',9,'IT139IU',2),('IT140',1,'IT140IU',2),('IT140',9,'IT140IU',2),('IT141',1,'IT141IU',3),('IT142',1,'IT142IU',2),('IT142',9,'IT142IU',2),('IT143',1,'IT143IU',2),('IT143',9,'IT143IU',2),('IT144',1,'IT144IU',3),('IT145',1,'IT145IU',3),('IT146',1,'IT146IU',3),('IT147',1,'IT147IU',3),('IT148',1,'IT148IU',3),('IT149',1,'IT149IU',4),('IT149',9,'IT149IU',4),('IT150',1,'IT150IU',3),('IT151',1,'IT151IU',4),('IT151',9,'IT151IU',4),('IT152',1,'IT152IU',3),('IT153',2,'IT153IU',4),('IT153',3,'IT153IU',4),('IT153',4,'IT153IU',4),('IT153',10,'IT153IU',4),('IT153',11,'IT153IU',4),('IT153',12,'IT153IU',4),('IT153',17,'MA020UN',4),('IT153',18,'IT153UN',4),('IT153',21,'IT153UN',4),('IT153',22,'IT153WE',4),('IT153',31,'IT153DE',4),('IT153',32,'IT153DE',4),('IT153',33,'IT153DE',4),('IT153',34,'IT153DE',4),('IT153',35,'IT153DE',4),('IT153',36,'IT153DE',4),('IT154',1,'IT155IU',1),('IT155',1,'ISME105IU',3),('IT501',23,'IT501',2),('IT501',24,'IT501',2),('IT501',25,'IT501',2),('IT501',26,'IT501',2),('IT501',27,'IT501',2),('IT501',28,'IT501',2),('IT501',29,'IT501',2),('IT501',30,'IT501',2),('IT502',23,'IT502',2),('IT502',24,'IT502',2),('IT502',25,'IT502',2),('IT502',26,'IT502',2),('IT502',27,'IT502',2),('IT502',28,'IT502',2),('IT502',29,'IT502',2),('IT502',30,'IT502',2),('IT503',23,'IT503',2),('IT503',24,'IT503',2),('IT503',25,'IT503',2),('IT503',26,'IT503',2),('IT503',27,'IT503',2),('IT503',28,'IT503',2),('IT503',29,'IT503',2),('IT503',30,'IT503',2),('IT561_1',25,'IT561',5),('IT561_1',26,'IT561',5),('IT561_1',29,'IT561',5),('IT561_1',30,'IT561',5),('IT561_2',23,'IT561',5),('IT561_2',24,'IT561',5),('IT561_2',27,'IT561',5),('IT561_2',28,'IT561',5),('PE501',23,'PE501',2),('PE501',24,'PE501',2),('PE501',25,'PE501',2),('PE501',26,'PE501',2),('PE501',27,'PE501',2),('PE501',28,'PE501',2),('PE501',29,'PE501',2),('PE501',30,'PE501',2),('PE502',23,'PE502',2),('PE502',24,'PE502',2),('PE502',25,'PE502',2),('PE502',26,'PE502',2),('PE502',27,'PE502',2),('PE502',28,'PE502',2),('PE502',29,'PE502',2),('PE502',30,'PE502',2),('UFCF7H-15-3',22,'UFCF7H-15-3',2),('UFCFB5-15-3',22,'UFCFB5-15-3',2),('UFCFEL-15-3',22,'UFCFEL-15-3',2),('UFCFFC-30-3',22,'UFCFFC-30-3',2),('UFCFJP-15-3',22,'UFCFJP-15-3',2),('UFCFRB-15-3',22,'UFCFRB-15-3',2),('UFCFX3-15-3',22,'UFCFX3-15-3',2);
/*!40000 ALTER TABLE `course_program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discipline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discipline`
--

LOCK TABLES `discipline` WRITE;
/*!40000 ALTER TABLE `discipline` DISABLE KEYS */;
INSERT INTO `discipline` VALUES (1,'Data Science'),(2,'Information Technology'),(3,'Computer Science'),(4,'Master of Information Technology Management');
/*!40000 ALTER TABLE `discipline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (6);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'Nguyễn Văn Sinh','Dr.','nvsinh@hcmiu.edu.vn'),(2,'Trần Thanh Tùng','Dr.','tttung@hcmiu.edu.vn'),(3,'Nguyễn Quang Phú','MSc.','nqphu@hcmiu.edu.vn'),(4,'Nguyễn Thị Thuý Loan','Assof.Dr.','nttloan@hcmiu.edu.vn'),(5,'Phạm Quốc Sơn Lâm','MSc.','pqslam@hcmiu.edu.vn'),(6,'Huỳnh Khả Tú','Dr.','hktu@hcmiu.edu.vn'),(7,'Đào Trần Hoàng Châu','MSc.','dthchau@hcmiu.edu.vn'),(8,'Lý Tú Nga','Dr.','ltnga@hcmiu.edu.vn'),(9,'Võ Thị Lưu Phương','Assof.Dr.','vtlphuong@hcmiu.edu.vn'),(10,'Huỳnh Khả Tú','Dr.','hktu@hcmiu.edu.vn'),(11,'Nguyễn Thị Thanh Sang','Dr.','nttsang@hcmiu.edu.vn'),(12,'Lê Thanh Sơn','MSc.','ltson@hcmiu.edu.vn'),(13,'Hà Việt Uyên Synh','Dr.','hvusynh@hcmiu.edu.vn'),(14,'Lê Duy Tân','Dr.','ldtan@hcmiu.edu.vn'),(15,'Mai Hoàng Bảo Ân','Dr.','mhban@hcmiu.edu.vn');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `learning_outcome`
--

DROP TABLE IF EXISTS `learning_outcome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `learning_outcome` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description_vn` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_LearningOutcome` (`course_id`),
  CONSTRAINT `FK_LearningOutcome` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=416 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learning_outcome`
--

LOCK TABLES `learning_outcome` WRITE;
/*!40000 ALTER TABLE `learning_outcome` DISABLE KEYS */;
INSERT INTO `learning_outcome` VALUES (77,'IT135','Describe what Data Science is and the skill sets needed to be a data scientist.',''),(78,'IT135','Explain the role of a Data Science Process in data analytics.',''),(79,'IT135','Carry out basic statistical modeling and analysis using open source data analysis tools.',''),(80,'IT135','Reason around ethical and privacy issues in data science conduct and apply ethical practices.',''),(81,'IT151','Describe similarities and differences between data collection techniques, such as simple random samples, stratified or cluster samples, completely randomized experiments, matched-pairs or block designs.',''),(82,'IT151','Summarize data using appropriate graphical and numerical techniques, including using common probability distributions as models for datasets.',''),(83,'IT151','Calculate expected values, variances, and probabilities for common probability distributions (e.g. normal, binomial)',''),(84,'IT151','Estimate a population parameter by finding the maximum likelihood estimator or calculating the appropriate confidence interval.',''),(85,'IT151','Make inference about a population using an appropriate hypothesis test, confidence interval, or regression model.',''),(86,'IT151','Fit, interpret, and assess regression models with one or more predictors.�',''),(87,'IT149','Understand programming languages and applications, how applications work',''),(88,'IT149','Able to write applications using C under UNIX environment',''),(89,'IT149','Understand basic data structure of C programming',''),(90,'IT149','Understand basic control flows of C programming',''),(91,'IT149','How to solve a particular programming problem',''),(92,'IT149','Team working�',''),(93,'IT069','Analyze a problem based on its natural language description and design an object-oriented solution.�',''),(94,'IT069','Implement an object-oriented solution in JAVA programming language.�',''),(95,'IT069','Explain and use object-oriented programming concepts of classes, methods, objects, encapsulation, information hiding, polymorphism, inheritance, abstraction and exception handling.�',''),(96,'IT013','To solidify students understanding of data structures and algorithms in Java.',''),(97,'IT013','To provide exposure to a broad range of data structures and algorithms including Arrays, Linked Lists, and Recursion, Analysis Tools, Stacks and Queues, Lists and Iterators, Trees, Priority Queues, Maps and Dictionaries, Search Trees, Sorting, Sets, and Selection, Text Processing, Graphs.',''),(98,'IT013','To provide team programming experience.',''),(99,'IT079','Produce an (Extended) Entity-Relationship (E-R) model from specifications.',''),(100,'IT079','Apply data normalization principles to transforming an ER model into a database schema.',''),(101,'IT079','Construct efficient SQL queries to retrieve and manipulate data as required.',''),(102,'IT090','Use UML to describe system artefacts;',''),(103,'IT090','Know how to get requirements from customers;',''),(104,'IT090','Identify client needs based on a written or verbal specification;',''),(105,'IT090','Know how analyze and design a system with object-oriented concepts and design patterns;',''),(106,'IT090','Learn how to write a technical report and work in a team.',''),(107,'IT097','Apply knowledge of AI techniques and synthesize solutions to the discipline and ability to develop a range of typical applications using artificial intelligence methods',''),(108,'IT097','Represent knowledge corresponding to practical problems, design, implement, and evaluate a computer-based system, process, component, or program to meet desired needs by properly using classical search algorithms, including breadth-first, depth-first, A*, and heuristic search',''),(109,'IT097','Produce intelligent applications of machine learning with statistical learning methods (Na�ve Bayes), supervised and unsupervised learning models: decision tree, neural networks, single-layer (perceptron) and multilayer networks',''),(110,'IT097','Communicate effectively with a range of audiences, ability to use current techniques, skills, and tools necessary for computing practice, ability to apply mathematical foundations, algorithmic principles, and computer science theory in the modeling and design of computer-based systems in a way that demonstrates comprehension of the trade-offs involved in design choices and ability to apply design and development principles in the construction of software systems of varying complexity',''),(111,'IT136','Determine the relationships between variables and using these relationships to forecast future observations�',''),(112,'IT136','Apply regression models to predict and forecast future outcomes�',''),(113,'IT136','Apply knowledge to any kind of modelling exercises�',''),(114,'IT137','Understand fundamental concepts of data analysis.',''),(115,'IT137','Explain how to perform data analysis with descriptive statistics and inferential statistics.',''),(116,'IT137','Apply data analysis techniques and tools to some practical cases in business/engineering.',''),(117,'IT138','Understand the principles of data and graphic design.',''),(118,'IT138','Create well-designed data visualizations with appropriate tools.',''),(119,'IT138','Evaluate a visualization design.',''),(120,'IT139','Understand the concept and design of distributed systems',''),(121,'IT139','Apply distributed data processing models and technologies',''),(122,'IT139','Design and implement components of a scalable and distributed system (millions of users and petabytes of data)',''),(123,'IT140','Gain understanding of the cryptography concepts including symmetric key encryption, hash function, message authentication code, public key encryption, digital signature and digital envelope;',''),(124,'IT140','Apply the concepts of authentication and authorization in implementing secure systems and networks;',''),(125,'IT140','Understand and categorize the malicious software and their attacking mechanisms;',''),(126,'IT140','Explore the buffer overflow attacks and fuzzing to find software vulnerabilities, and obtain the knowledge of software and operating system security;',''),(127,'IT140','Understand and practice Internet security protocols and authentication applications;',''),(128,'IT132','Understand basic contents of data warehousing and data mining.',''),(129,'IT132','Explain modern algorithms in the area of data mining and knowledge discovery.',''),(130,'IT132','Apply data mining techniques to some case studies using existing datasets.',''),(131,'IT132','Work in a team to build a data mining process.',''),(132,'IT142','Calculate probability distributions and fitting to experimental data including noise and systematics.',''),(133,'IT142','Apply Bayesian analysis in observational data.',''),(134,'IT142','Use Monte-Carlo integration in observational data analysis.',''),(135,'IT142','Analyze dynamical multi-scale time series in experiments.',''),(136,'IT143','Identify common tools and technologies that can be used to create Big Data solutions.',''),(137,'IT143','Design the MapReduce programming framework, including the map, shuffle and sort, and reduce components.',''),(138,'IT143','Implement Big Data solutions using different big data programming frameworks.',''),(139,'IT082','Recognize the roles of an engineer in practical environment.',''),(140,'IT082','Develop practical products or run product development projects in industry',''),(141,'IT083','Research a specific topic in the field.',''),(142,'IT083','Design the model or system architecture of the application product',''),(143,'IT083','Develop and improve the product in the thesis.',''),(144,'IT058','Research a specific topic in the field.',''),(145,'IT058','Design the model or system architecture of the application product',''),(146,'IT058','Develop the product for the thesis.',''),(147,'IT144','Practice the Framework for Process Improvement�',''),(148,'IT144','Identify and analyze an organization�s business process using different techniques such as ANSI, Swim Lane, Business Process Diagrams, UML, SIPOC, and Value Stream Maps',''),(149,'IT144','Evaluate process improvement effectiveness',''),(150,'IT145','Understand the goals and different forms of decision support, and gain knowledge of the practical issues of implementation',''),(151,'IT145','Examine systems based on statistical and logical approaches to decision making that include statistical prediction, rule-based systems, case-based reasoning, neural networks, fuzzy logic, etc.',''),(152,'IT145','Obtain an overview of the various computerized decision support techniques together with a detailed assessment of successful and unsuccessful applications developed',''),(153,'IT145','Examine the actual and potential impact of the technology together with the challenges associated with this kind of application',''),(154,'IT146','Use the tools of graph theory as a basis for studying the Internet social networks, and the process of Web search.',''),(155,'IT146','Apply game theory to analyze strategic behavior in a variety of settings including auction design, Web advertising, network routing, and social marketing.�',''),(156,'IT146','Analyze the processes by which ideas, beliefs, opinions, products, technologies, and social conventions spread through social networks.�',''),(157,'IT056','explain the project management process;�',''),(158,'IT056','identify the areas of knowledge required for successful software project management;�',''),(159,'IT056','apply techniques appropriate for successful software project management;�',''),(160,'IT056','communicate effectively to diverse audiences; and',''),(161,'IT056','construct project related documentation while working in a team environment;�',''),(162,'IT094','understand basic information system concepts as applied to business operations and management.',''),(163,'IT094','identify the major components of a computer system, including hardware, software, operating systems and operating environments as they apply to information systems.',''),(164,'IT094','evaluate computer-based information systems from a management perspective.',''),(165,'IT094','interpret the interdependence and functionality of the hardware and software components of information systems�',''),(166,'IT094','develop basic MIS applications such as spreadsheet, database, and web development.',''),(167,'IT094','understand how to utilize large-scale computer applications systems to assist with business management and operations.',''),(168,'IT094','accomplish all objectives as an individual or in a team environment.',''),(169,'IT147','Understand the underlying architecture of smartphones',''),(170,'IT147','Understand the foundation of cloud computing',''),(171,'IT147','Design and implement a mobile cloud application and service',''),(172,'IT148','Develop an understanding of experimental methods and major experimental designs in some particular case studies.',''),(173,'IT148','Learn how to plan, design and conduct experiments efficiently and effectively, and analyze the resulting data to obtain objective conclusions.�',''),(174,'IT148','Implement Experimental Design solutions using different experimental design programming frameworks.',''),(175,'IT120','Understand entrepreneurial processes;',''),(176,'IT120','Apply new technology to boost business performance;',''),(177,'IT120','Manage financial statements in a company;',''),(178,'IT120','Know how to write a proposal and call for investment.',''),(179,'IT141','gain understanding of the MapReduce paradigm and Hadoop ecosystem.',''),(180,'IT141','develop data analysis skills with Hive and Pig.',''),(181,'IT141','be able to analyze temporal, geospatial, text, and graph data with Spark.�',''),(182,'IT141','Learn how to use machine learning algorithms on large datasets and analyze outcomes with Hadoop and MLlib (Spark)',''),(183,'IT152','Understand basic contents of IOT technologies.',''),(184,'IT152','Explain modern applications of IOT: healthcare, manufacturing, agriculture, transportation.',''),(185,'IT152','Apply data mining techniques to some IOT case studies.',''),(186,'IT152','Work in a team to build a data mining process for a chosen IOT application.',''),(187,'IT150','Understand basic contents of blockchain technology.',''),(188,'IT150','Explain different types of blockchain development: Ethereum, smart contract security, bitcoin �..',''),(189,'IT150','Apply blockchain techniques to setup the development environment to writing and deploying smart contracts, the workhorse of blockchain applications, integrating cryptocurrency micropayments into web apps�',''),(190,'IT150','Work in a team to build a blockchain application project.',''),(191,'IT155','Able to formulate the linear programming models with two variables and solve it by using graphical methods Integer programming, transportation, assignment, shortest paths, maximum flow, minimize costs models�',''),(192,'IT155','Able to formulate the linear programming models with more than two variables and solve it by using simplex method�',''),(193,'IT155','Able to define initial solutions for the linear programming models by using big M and two phases techniques.�',''),(194,'IT155','Able to formulate Integer programming, transportation, assignment, shortest paths, maximum flow, minimize costs models and solve them in large scale by using LINGO, CPLEX software�',''),(195,'IT155','Able to analyses output from the linear programming model by using sensitivity analysis�',''),(196,'IT155','Able to formulate the practical problems via case studies�',''),(197,'IS021','formulate the linear programming models with two variables and solve it by using graphical methods Integer programming, transportation, assignment, shortest paths, maximum flow, minimize costs models.',''),(198,'IS021','formulate the linear programming models with more than two variables and solve it by using simplex method.',''),(199,'IS021','define initial solutions for the linear programming models by using big M and two phases techniques.',''),(200,'IS021','formulate Integer programming, transportation, assignment, shortest paths, maximum flow, minimize costs models and solve them in large scale by using LINGO, CPLEX software.',''),(201,'IS021','analyses output from the linear programming model by using sensitivity analysis.',''),(202,'IS021','formulate the practical problems via case studies.',''),(207,'IT117','Gain understanding of the cryptography concepts including symmetric key encryption, hash function, message authentication code, public key encryption, digital signature and digital envelope;',''),(208,'IT117','Apply the concepts of authentication and authorization in implementing secure systems and networks;',''),(209,'IT117','Understand and categorize the malicious software and their attacking mechanisms;',''),(210,'IT117','Explore the buffer overflow attacks and fuzzing to find software vulnerabilities, and obtain the knowledge of software and operating system security;',''),(211,'IT117','Understand and practice Internet security protocols and authentication applications;',''),(212,'IT117','Analyze the wireless security.',''),(213,'IT112','Understand the architectural design and software layers of distributed systems',''),(214,'IT112','Understand distributed file systems',''),(215,'IT112','Understand distributed transactions and synchronization issues',''),(216,'IT112','Understand concurrency issues in distributed systems',''),(217,'IT112','Design and implement portions of a distributed system',''),(218,'IT122','Analyze the components, architecture, and protocols in wireless networks;',''),(219,'IT122','Apply the theory in designing a small/medium wireless networks;',''),(220,'IT122','Show the ability to work in teams;',''),(221,'IT125','Understand key elements of networked systems in enterprise environments',''),(222,'IT125','Understand the topologies and services in enterprise environments',''),(223,'IT125','Understand the technologies used in enterprise networks and how they related to each other',''),(224,'IT125','Understand the role and responsibility of system administrator�',''),(225,'IT125','Able to use various network administration tools�',''),(226,'IT125','Team working�',''),(227,'IT045','Theoratical knowledge and understanding of current issues as well as practical experience of network design',''),(228,'IT045','Explain the network design process as well as scalability and security concepts',''),(229,'IT045','Construct network designs that provide high bandwidth and low delay required for real-time applications',''),(230,'IT045','Apply techniques to develop a baseline for measuring performance of a new network design',''),(231,'IT045','Ability to evaluate performance of wired and wireless computer networks using analytical and/or simulation tools',''),(232,'IT064','Demonstrate an in-depth understanding of fundamental knowledge and history of computing, all career paths in computing and learning methodologies in university.',''),(233,'IT064','Describe basic hardware and software concepts and basic computing terminologies',''),(234,'IT064','Make a plan for his/her own future career and his/her works',''),(235,'IT064','Seek information from Internet and manage his/her information.',''),(236,'IT064','Follow the discussions of instructors and classmates.�',''),(237,'IT116','Understand programming languages and applications, how applications work',''),(238,'IT116','Able to write applications using C under UNIX environment',''),(239,'IT116','Understand basic data structure of C programming',''),(240,'IT116','Understand basic control flows of C programming',''),(241,'IT116','How to solve a particular programming problem',''),(242,'IT116','Team working�',''),(243,'IT153','Understand and apply count/enumerate objects in a systematic way.',''),(244,'IT153','Understand mathematical reasoning in order to read, comprehend and construct mathematical arguments',''),(245,'IT153','Understand to work with discrete structures and practical problems in computer science.',''),(246,'IT153','Apply algorithm thinking and modeling',''),(247,'IT153','Apply knowledge in computer science for problems solving',''),(248,'IT067','Explain the presentation of number, codes systems.�',''),(249,'IT067','Demonstrate the operation of arbitrarily basic combinational and sequential circuits.',''),(250,'IT067','Design basic combinational and sequential circuits.',''),(251,'IT067','Follow the discussions of instructors and classmates.',''),(252,'IT099','use laboratory equipment in digital logic design.',''),(253,'IT099','design, construct, analyze, and troubleshoot simple combinational and sequential circuits.',''),(254,'IT099','measure and record the experimental data, analyze the results, and prepare a laboratory report for submission.�',''),(255,'IT099','explicitly indicate which of the student outcomes listed in Criterion 3 or any other outcomes are addressed by the course.',''),(256,'IT089','Understand the principles of computer architecture and the interfaces between its hardware and software components;',''),(257,'IT089','Understand computer arithmetic (both integer and floating point), datapath, control , pipelining, pipeline hazards and their remedies, computer buses and I/O peripherals, and multiprocessor architecture;',''),(258,'IT089','Create assembly programs and their machine code equivalent;',''),(259,'IT089','Analyze the performance of computer;',''),(260,'IT089','Analyze computer memory and its organization, especially the interaction between cache and main memory.',''),(261,'IT017','Understand processes and process management',''),(262,'IT017','Understand synchronization and communication',''),(263,'IT017','Understand memory management',''),(264,'IT017','Given a scheduling algorithm, determine time line of actions�',''),(265,'IT017','Understand internals of file system�',''),(266,'IT017','Design and implement portions of an operating system',''),(267,'IT093','Understand web design, web programming concepts and models.',''),(268,'IT093','Apply to design and develop static/dynamic web application with HTML, Java Server Pages, Java Bean, extended Java frameworks as Ajax and Struts in the MVC model.',''),(269,'IT093','Apply knowledge and ability to manage and use Java, XML utilities and developed environments for developing web applications that access data stored in database servers.',''),(270,'IT076','Apply the principles and methods of software engineering in practice;�',''),(271,'IT076','Apply critical and analytic thinking to the planning of the software development process;�',''),(272,'IT076','Apply critical and analytic thinking to the execution and evaluation of the software development process;�',''),(273,'IT076','Use automated tools to support the software development process;�',''),(274,'IT076','Demonstrate creative thinking in the design of software solutions;�',''),(275,'IT076','Communicate effectively to diverse audiences; and�',''),(276,'IT076','Apply teamwork skills in a software engineering project.�',''),(277,'IT096','Understand the structure of network applications',''),(278,'IT096','Understand the communication paradigm of network applications',''),(279,'IT096','Understand TCP and UDP sockets',''),(280,'IT096','Able to develop network applications using TCP and UDP sockets',''),(281,'IT096','Understand and implement network applications using popular internet protocols: HTTP, DNS, FTP, �',''),(282,'IT096','Team working�',''),(283,'IT130','Understand bases of digital image formation.',''),(284,'IT130','Understand the colour image foundations.�',''),(285,'IT130','Apply special-domain image filtering.',''),(286,'IT133','Understand the process of making mobile application',''),(287,'IT133','Understand the structure of mobile application, especially Android application',''),(288,'IT133','Understand most common user interface elements applying for mobile application',''),(289,'IT133','Understand mobile storage strategies, mobile database, tasks and services�',''),(290,'IT133','Able to develop mobile application using most common tool�',''),(291,'IT133','Team working�',''),(292,'IT134','The ability of designing and implementing some Internet of Thing systems;',''),(293,'IT134','The ability of applying some data mining techniques to analyze the data in some IoT applications.',''),(294,'IT024','Understand and apply the algorithms and fundamental techniques for generating and modifying pictures, 2D/3D objects with a digital computer.',''),(295,'IT024','Understand and apply the handling of color, and the generation of visible-surface projections of three dimensional scenes, for applications in science, engineering, and the entertainment world.',''),(296,'IT024','Apply to begin developing Computer Graphics software.',''),(297,'IT024','Apply knowledge of mathematics and ability in graphical programming to develop games, construct and reconstruct 2D/3D graphical objects, process images, etc.',''),(298,'IT114','Understand the steps of the System Development Life Cycle and the techniques for each step',''),(299,'IT114','Using a CASE tool in analysis and design a system.',''),(300,'IT114','Apply to a real system',''),(301,'IT131','Solve numerically nonlinear equation by bisection, iterative and Newton methods.',''),(302,'IT131','Solve big linear systems by exact and iterative methods.',''),(303,'IT131','Fit data by interpolation polynomials, Spline � polynomials and least square methods.',''),(304,'IT131','Evaluate numerically derivatives and integrals.',''),(305,'IT131','Solve numerically Boundary value problems by Euler, Euler improved and Finite Difference methods.',''),(306,'IT131','Study diverse engineering problems by numerical methods',''),(307,'IT091','Analyze the components, architecture, and protocols in computer networks;',''),(308,'IT091','Apply the theory in designing a small/medium computer networks;',''),(309,'IT091','Show the ability to work in teams;',''),(310,'IT092','Understand a wide range of programming paradigms',''),(311,'IT092','Understand how different programming languages evolved',''),(312,'IT092','Understand the differences in problem domains and language suitability',''),(313,'IT092','Understand the basic features of programming language translation',''),(314,'IT092','Understand implementation techniques for selected language constructs',''),(321,'IT068','Apply Knowledge of Mathematics, Science, and Engineering for solving electrical engineering circuit.',''),(322,'IT068','Apply critical and analytic thinking to the principles of electrical engineering process;',''),(323,'IT068','Demonstrate creative thinking in the design of electrical engineering solutions;',''),(324,'IT068','Have ability to engage life-long learning.',''),(325,'IT068','Have an opportunity to participate in seminars to understand the impact of electrical engineering solutions in a global, economic, environmental and social context.�',''),(326,'IT098','Develop skills in using electric equipment, meters, multi-meters, power supplies, oscilloscopes and counters; To study the behavior of some specified circuits',''),(327,'IT098','Apply critical and analytic thinking to the principles of electrical engineering process;',''),(328,'IT098','Demonstrate creative thinking in the design of electrical engineering solutions;',''),(329,'IT098','Have an opportunity to exam case studies to understand the professional and ethical responsibility as an engineer.',''),(330,'IT070','Apply Knowledge of Mathematics, Science, and Engineering for solving electrical engineering circuit.',''),(331,'IT070','Apply critical and analytic thinking to the principles of electrical engineering process;',''),(332,'IT070','Demonstrate creative thinking in the design of electrical engineering solutions;',''),(333,'IT070','Have ability to engage life-long learning',''),(334,'IT070','Have an opportunity to participate in seminars to understand the impact of electrical engineering solutions in a global, economic, environmental and social context.�',''),(335,'IT102','Design and conduct experiment, analyze results',''),(336,'IT102','Cooperate with team-mate in conducting experiment',''),(337,'IT102','Use one software (such as: Multisim, Pspice, Altium,�) to simulate electrical circuits and know how to write lab report.',''),(338,'IT102','Have an opportunity to exam case studies to understand the professional and ethical responsibility as an engineer.',''),(339,'IT105','An ability to define different number systems, binary addition and subtraction, 2�s complement representation and operations with this representation.',''),(340,'IT105','An ability to understand the different switching algebra theorems and apply them for logic functions.',''),(341,'IT105','An ability to define the Karnaugh map for a few variables and perform an algorithmic reduction of logic functions.',''),(342,'IT105','An ability to understand sequential circuits, such as counters and shift registers, and to perform simple projects using standard logic and integrated chips.',''),(343,'IT105','An ability to analyze and design asynchronous sequential digital elements',''),(344,'IT105','An ability to analyze and design synchronous digital elements',''),(345,'IT105','An ability to write and verify synthesizable VHDL models',''),(346,'IT105','An ability to effectively use VHDL simulator',''),(347,'IT110','design logic circuit layouts for both static CMOS and dynamic clocked CMOS circuits',''),(348,'IT110','build a cell library to be used by other chip designers',''),(349,'IT110','extract the analog parasitic elements from the layout and analyze the circuit timing',''),(350,'IT110','analyze VLSI circuit timing using Logic Effort',''),(351,'IT110','compare the tradeoffs of sequencing elements including flip-flops, transparent latches, and pulsed latches',''),(352,'IT110','describe the sources and effects of clock skew',''),(353,'IT110','insert elementary testing hardware into the VLSI chip',''),(354,'IT110','estimate the power consumption of a VLSI chip',''),(355,'IT110','assemble an entire chip and add the appropriate pads to a layout',''),(356,'IT110','explain the chip technology scaling process',''),(357,'IT128','Understand the operation of a basic computer organization.',''),(358,'IT128','Apply the assembly language to solve a specific problem.',''),(359,'IT128','Design the micro-processing systems for a specific purpose',''),(360,'IT129','An ability to design and conduct experiments with microcontroller as well as to analyze and interpret data',''),(361,'IT129','An ability to identify, formulate, and solve engineering problems using microcontroller based solutions',''),(362,'IT129','Implement assembly language to solve a specific problem',''),(363,'IT129','ability to work in team or group',''),(364,'IT129','Have an opportunity to exam case studies to understand the professional and ethical responsibility as an engineer.',''),(365,'IT075','Understand the fundamentals of signals and systems in both discrete time and continuous time domains and their representatives in practice',''),(366,'IT075','Apply knowledge of methods (Fourier transform, Laplace transform, z transform) to analyze the characteristics of signals and systems',''),(367,'IT075','Differentiating the nature of discrete time and continuous time systems in order to devise proper methods to solve engineering problems related to these systems',''),(368,'IT075','Have ability to engage life-long learning',''),(369,'IT100','Design and conduct experiment, analyze results',''),(370,'IT100','Use Matlab software to write programs about some signals and systems topics and know how to write lab report.',''),(371,'IT100','Understand the basic knowledge about the main parts of a typical communication system.',''),(372,'IT100','Have an opportunity to exam case studies to understand the professional and ethical responsibility as an engineer.',''),(373,'IT074','Apply the principles and operations of electronics in practice;',''),(374,'IT074','Apply critical and analytic thinking to the planning of electronic devices;',''),(375,'IT074','Demonstrate creative thinking in the design of electronic devices;',''),(376,'IT074','Have an opportunity to participate in seminars to understand the impact of electrical engineering solutions in a global, economic, environmental and social context.�',''),(377,'IT101','Apply the principles and operations of electronics in practice;',''),(378,'IT101','Apply critical and analytic thinking to the planning of electronic devices;',''),(379,'IT101','Demonstrate creative thinking in the design of electronic devices;',''),(380,'IT101','Have an opportunity to exam case studies to understand the professional and  ethical responsibility as an engineer.',''),(381,'IT103','Apply knowledge of mathematics, science and engineering to solve digital signal processing problem;',''),(382,'IT103','Understand the sampling, quantization process as well as the basic discrete-time systems concepts;',''),(383,'IT103','Illustrate the design of digital filter by various methods to meet prescribed specifications;',''),(384,'EE093','Design and implement digital signal processing algorithms using DSP TMS320C6713 Kit ethically in C and Matlab software.',''),(385,'EE093','Optimize the programming code for having better performance of DSP projects.',''),(386,'EE093','Present the application of DSP projects in signal processing filed.',''),(387,'EE093','Solve the problems effeciently by individual and by group',''),(388,'IT081','Apply the principles and operations of electronics in practice;',''),(389,'IT081','Apply critical and analytic thinking to the planning of electronic devices;',''),(390,'IT081','Demonstrate creative thinking in the design of electronic devices;',''),(391,'IT081','Have an opportunity to participate in seminars to understand the impact of electrical engineering solutions in a global, economic, environmental and social context.',''),(392,'IT123','Apply the principles and operations of electronics in practice;',''),(393,'IT123','Apply critical and analytic thinking to the planning of electronic devices;',''),(394,'IT123','Demonstrate creative thinking in the design of electronic devices;',''),(395,'IT123','Have an opportunity to participate in seminars to understand the impact of electrical engineering solutions in a global, economic, environmental and social context.',''),(396,'IT115','An ability to understand the \"big ideas\" in embedded systems',''),(397,'IT115','An ability to obtain direct hands-on experience on both hardware and software elements commonly used in embedded system design.',''),(398,'IT115','An ability to understand basic real-time resource management theory',''),(399,'IT115','An ability to understand the basics of embedded system application concepts such as signal processing.',''),(400,'IT106','Ability to describe a digital system in VHDL',''),(401,'IT106','Ability to simulate and debug a digital system described in VHDL',''),(402,'IT106','Ability to interface electronic components with custom hardware .',''),(403,'IT106','Ability to implement logic on an FPGA',''),(404,'IT106','Ability to analyze timing of digital systems, including cross-boundary, asynchronous timing',''),(405,'IT127','An ability to design complex electronic systems interfacing multiple integrated circuits.',''),(406,'IT127','An ability to design and conduct experiments, as well as analyze and interpret data.',''),(407,'IT127','An ability to identify, formulate, and solve engineering problems in designing and implementing embedded systems.',''),(408,'IT127','An ability to use the techniques, skills, and modern engineering tools necessary for implementing embedded systems.',''),(409,'IT126','use the Electric VLSI design tool to build an 8-bit MIPS microprocessor including: schematic entry, layout, transistor-level cell design, gate-level logic design, hierarchical design, switch-level simulation (IRSIM and ModelSim), design rule checking (DRC), electrical rule checking (ERC), network consistency checking (NCC), HDL design (Verilog), pad frame generation and routing, pre-tapeout verification',''),(410,'IT126','design a custom integrated circuit from concept to tapeout',''),(411,'IT126','describe and avoid common CMOS circuit pitfalls',''),(412,'IT126','design functional units such as adders, multipliers, and PLAs','');
/*!40000 ALTER TABLE `learning_outcome` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discipline_id` int(11) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_major_discipline` (`discipline_id`) USING BTREE,
  CONSTRAINT `FK_major_discipline` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (1,2,'Network Engineering','NE'),(2,2,'Computer Engineering','CE'),(3,1,'Data Science','DS'),(4,3,'Computer Science','CS'),(5,4,'Infomation System Management','ISM'),(6,4,'Network Engineering System','NES');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` datetime NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `version` varchar(4) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_program_major` (`major_id`),
  CONSTRAINT `FK_program_major` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,4,'DS_2019',4,'2019','IU'),(2,2,'CE_2019',4,'2019','IU'),(3,1,'NE_2019',4,'2019','IU'),(4,4,'CS_2019',4,'2019','IU'),(9,3,'DS_2018',4,'2018','IU'),(10,2,'CE_2018',4,'2018','IU'),(11,1,'NE_2018',4,'2018','IU'),(12,4,'CS_2018',4,'2018','IU'),(13,2,'CE_RG_2017',2,'2017','GR'),(14,2,'CE_RG_2018',2,'2018','GR'),(15,2,'CE_SB_2017',2,'2017','SB'),(16,2,'CE_SB_2018',2,'2018','SB'),(17,4,'CS_UN_2017',2,'2017','UN'),(18,4,'CS_UN_2018',2,'2018','UN'),(19,2,'IT_WE_2017',2,'2017','WE'),(20,2,'IT_WE_2018',2,'2018','WE'),(21,4,'CS_UN_2019',2,'2019','UN'),(22,2,'IT_WE_2020',4,'2020','WE'),(23,5,'ISM_CW_2020',2,'2020','IU'),(24,6,'NES_CW_2020',2,'2020','IU'),(25,5,'ISM_RS_2020',2,'2020','IU'),(26,6,'NES_RS_2020',2,'2020','IU'),(27,5,'ISM_CW_2020',3,'2020','IU'),(28,6,'NES_CW_2020',3,'2020','IU'),(29,5,'ISM_RS_2020',3,'2020','IU'),(30,6,'NES_RS_2020',3,'2020','IU'),(31,4,'CS_DE(2:2)_2020',2,'2020','DE'),(32,1,'NE_DE(2:2)_2020',2,'2020','DE'),(33,2,'CE_DE(2:2)_2020',2,'2020','DE'),(34,4,'CS_DE(3:1)_2020',3,'2020','DE'),(35,1,'NE_DE(3:1)_2020',3,'2020','DE'),(36,2,'CE_DE(2.5:1.5)_2020',3,'2020','DE'),(37,4,'CS_2020',4,'2020','IU'),(38,3,'DS_2020',4,'2020','IU'),(39,2,'CE_2020',4,'2020','IU'),(40,1,'NE_2020',4,'2020','IU'),(41,NULL,'SB(2:2)_2020',2,'2020','SB'),(42,NULL,'UN(2:2)_2020',2,'2020','UN'),(43,2,'WE(2:2)_2020',2,'2020','WE');
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `student_id` varchar(50) NOT NULL,
  `class_id` int(11) NOT NULL,
  `mid_score` int(11) DEFAULT NULL,
  `final_score` int(11) DEFAULT NULL,
  `in_class_score` int(11) DEFAULT NULL,
  `GPA` int(11) DEFAULT NULL,
  `abet_score` int(11) DEFAULT NULL,
  `abet_1` int(11) DEFAULT NULL,
  `abet_2` int(11) DEFAULT NULL,
  `abet_3` int(11) DEFAULT NULL,
  `abet_4` int(11) DEFAULT NULL,
  `abet_5` int(11) DEFAULT NULL,
  `abet_6` int(11) DEFAULT NULL,
  `avg` float DEFAULT NULL,
  PRIMARY KEY (`student_id`,`class_id`),
  KEY `FK_result_class` (`class_id`),
  CONSTRAINT `FK28nikj6sivnxwnciod1kyq907` FOREIGN KEY (`class_id`) REFERENCES `class_session` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_result_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES ('ITITIU18102',55,50,40,20,37,38,36,36,NULL,NULL,NULL,42,NULL),('ITITIU18115',55,30,60,70,54,49,48,58,NULL,NULL,NULL,41,NULL),('ITITIU18247',55,95,90,90,92,92,93,91,NULL,NULL,NULL,94,NULL),('ITITIU18269',55,50,75,85,71,67,66,74,NULL,NULL,NULL,60,NULL),('ITITIU18270',55,10,20,85,37,38,44,38,NULL,NULL,NULL,31,NULL),('ITITIU19046',55,95,50,75,71,80,86,65,NULL,NULL,NULL,89,NULL),('ITITIU19070',55,80,92,70,82,79,75,83,NULL,NULL,NULL,77,NULL),('ITITIU19073',55,87,64,40,64,67,66,61,NULL,NULL,NULL,74,NULL),('ITITIU19075',55,45,81,80,70,63,61,75,NULL,NULL,NULL,55,NULL),('ITITIU19088',55,63,73,50,63,60,57,65,NULL,NULL,NULL,59,NULL),('ITITIU19092',55,46,35,60,46,49,52,44,NULL,NULL,NULL,50,NULL),('ITITIU19111',55,70,100,90,88,82,79,92,NULL,NULL,NULL,76,NULL),('ITITIU19195',55,100,100,85,96,95,93,96,NULL,NULL,NULL,96,NULL),('ITITIU19196',55,35,20,90,46,51,60,43,NULL,NULL,NULL,50,NULL),('ITITIU19201',55,80,100,100,94,90,89,97,NULL,NULL,NULL,86,NULL),('ITITUN18011',55,95,90,90,92,92,93,91,NULL,NULL,NULL,94,NULL);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slo`
--

DROP TABLE IF EXISTS `slo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `criteria` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slo`
--

LOCK TABLES `slo` WRITE;
/*!40000 ALTER TABLE `slo` DISABLE KEYS */;
INSERT INTO `slo` VALUES (1,'Analyze a complex computing problem and to apply principles of computing and other relevant disciplines to identify solutions.',1),(2,'Design, implement, and evaluate a computing-based solution to meet a given set of computing requirements in the context of the program\'s discipline.',2),(3,'Communicate effectively in a variety of professional contexts.',3),(4,'Recognize professional responsibilities and make informed judgments in computing practice based on legal and ethical principles.',4),(5,'Function effectively as a member or leader of a team engaged in activities appropriate to the program\'s discipline.',5),(6,'Apply computer science theory and software development fundamentals to produce computing-based solutions.',6);
/*!40000 ALTER TABLE `slo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `major` varchar(45) DEFAULT NULL,
  `batch` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('ITITIU18102','Cáp Kim Quang','Information Technology',18),('ITITIU18115','Nguyễn Huỳnh Phương Thanh','Information Technology',18),('ITITIU18247','Trần Trung Dũng','Information Technology',18),('ITITIU18269','Phan Tiến Tài','Information Technology',18),('ITITIU18270','Lê Tấn Đạt','Information Technology',18),('ITITIU19046','Bùi Thế Sáng','Information Technology',19),('ITITIU19070','Nguyễn Minh An','Information Technology',19),('ITITIU19073','Nguyễn Tiến Anh','Information Technology',19),('ITITIU19075','Lê Tuấn Anh','Information Technology',19),('ITITIU19088','Nguyễn Thành Công','Information Technology',19),('ITITIU19092','Huỳnh Quốc Cường','Information Technology',19),('ITITIU19111','Nguyễn Hoàng Đạt','Information Technology',19),('ITITIU19195','Lê Văn Quang','Information Technology',19),('ITITIU19196','Hồ Tú Quyên','Information Technology',19),('ITITIU19201','Trần Thanh Sơn','Information Technology',19),('ITITUN18011','Đỗ Bình Duy','Twinning Program',18);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uuid`
--

DROP TABLE IF EXISTS `uuid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uuid` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uuid`
--

LOCK TABLES `uuid` WRITE;
/*!40000 ALTER TABLE `uuid` DISABLE KEYS */;
INSERT INTO `uuid` VALUES (1);
/*!40000 ALTER TABLE `uuid` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-28 10:47:17
