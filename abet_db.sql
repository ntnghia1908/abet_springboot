-- MySQL dump 10.13  Distrib 5.7.34, for Linux (x86_64)
--
-- Host: localhost    Database: abet
-- ------------------------------------------------------
-- Server version	5.7.34

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
-- Table structure for table `assessment`
--

drop database if exists `abet`;
create database `abet`;
use `abet`;

DROP TABLE IF EXISTS `assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment` (
  `id` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment`
--

LOCK TABLES `assessment` WRITE;
/*!40000 ALTER TABLE `assessment` DISABLE KEYS */;
INSERT INTO `assessment` VALUES (1,'Quiz'),(2,'Homework/ Assigment'),(3,'Labs'),(4,'Midterm examination'),(5,'Projects/Presentations/ Report'),(6,'Final examination'),(7,'Prelab'),(8,'In-class ongoing assessment'),(9,'Exercises/ Quiz'),(10,'Combo in class');
/*!40000 ALTER TABLE `assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_tool`
--

DROP TABLE IF EXISTS `assessment_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment_tool` (
  `assessment_id` int(11) NOT NULL,
  `course_id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `loutcome_id` int(11) NOT NULL,
  `percentage` float DEFAULT NULL,
  PRIMARY KEY (`assessment_id`,`course_id`,`loutcome_id`),
  UNIQUE KEY `assessment_tool_id` (`course_id`,`assessment_id`,`loutcome_id`) USING BTREE,
  KEY `FK_AssessmentTool_LOutcome` (`loutcome_id`),
  KEY `FK_AssessmentTool_AssessmentCourse` (`assessment_id`,`course_id`),
  CONSTRAINT `FK_AssessmentTool_Assessment` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_AssessmentTool_Course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_AssessmentTool_LOutcome` FOREIGN KEY (`loutcome_id`) REFERENCES `learning_outcome` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_tool`
--

LOCK TABLES `assessment_tool` WRITE;
/*!40000 ALTER TABLE `assessment_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `assessment_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_assessment`
--

DROP TABLE IF EXISTS `class_assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_assessment` (
  `class_id` int(11) NOT NULL,
  `assessment_id` int(11) NOT NULL,
  `learning_outcome_id` int(11) NOT NULL,
  `precentage` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  UNIQUE KEY `UK_4rl0dnl0bu15tbx8bws7jbuxr` (`class_id`),
  KEY `fk_class_assemssment_assessment` (`assessment_id`) USING BTREE,
  KEY `fk_class_assemssment_learning_outcome` (`learning_outcome_id`) USING BTREE,
  CONSTRAINT `FK_class_assemssment_assessment` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_class_assemssment_class` FOREIGN KEY (`class_id`) REFERENCES `class_session` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_class_assemssment_learning_outcome` FOREIGN KEY (`learning_outcome_id`) REFERENCES `learning_outcome` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_assessment`
--

LOCK TABLES `class_assessment` WRITE;
/*!40000 ALTER TABLE `class_assessment` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_assessment_course`
--

DROP TABLE IF EXISTS `class_assessment_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_assessment_course` (
  `class_id` int(11) NOT NULL,
  `assessment_id` int(11) NOT NULL,
  `percentage` int(11) DEFAULT NULL,
  `lo_id` int(11) NOT NULL,
  `slo_id` int(11) NOT NULL,
  PRIMARY KEY (`class_id`,`assessment_id`),
  KEY `fk_class_assessment_course_assessment` (`assessment_id`) USING BTREE,
  KEY `fk_class_assessment_course_class` (`class_id`) USING BTREE,
  CONSTRAINT `FK_class_assessment_course_assessment` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_class_assessment_course_class` FOREIGN KEY (`class_id`) REFERENCES `class_session` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_assessment_course`
--

LOCK TABLES `class_assessment_course` WRITE;
/*!40000 ALTER TABLE `class_assessment_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_assessment_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_session`
--

DROP TABLE IF EXISTS `class_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_session` (
  `id` int(11) NOT NULL,
  `course_id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `instructor_id` int(11) NOT NULL,
  `group` int(11) DEFAULT NULL,
  `group_lab` int(11) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `academic_year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_class_course` (`course_id`),
  KEY `FKb3kre1tkyin4lxif7iy4jfxb0` (`instructor_id`),
  CONSTRAINT `FK_class_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKb3kre1tkyin4lxif7iy4jfxb0` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_session`
--

LOCK TABLES `class_session` WRITE;
/*!40000 ALTER TABLE `class_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clo_slo`
--

DROP TABLE IF EXISTS `clo_slo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clo_slo` (
  `slo_id` int(11) NOT NULL,
  `lo_id` int(11) NOT NULL,
  `percentage` float DEFAULT NULL,
  PRIMARY KEY (`lo_id`,`slo_id`),
  KEY `fk_clo_slo_learning_outcome` (`lo_id`),
  KEY `fk_clo_slo_slo` (`slo_id`),
  CONSTRAINT `FKnu0yp3vha8fgl05wo50ak1iwq` FOREIGN KEY (`slo_id`) REFERENCES `slo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_clo_slo_learning_outcome` FOREIGN KEY (`lo_id`) REFERENCES `learning_outcome` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clo_slo`
--

LOCK TABLES `clo_slo` WRITE;
/*!40000 ALTER TABLE `clo_slo` DISABLE KEYS */;
/*!40000 ALTER TABLE `clo_slo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `course` VALUES ('IT501',2,'Advanced Networking','Mạng máy tính nâng cao',3,1,''),('IT502',2,'Advanced Database','Cơ sở dữ liệu nâng cao',3,1,''),('IT503',2,'Programming Methodology','Phương pháp lập trình',2,0,''),('IT521',2,'Software Designs and Architectures','Thiết kế và kiến trúc phần mềm',3,1,''),('IT522',2,'Data Warehousing and Data Mining','Kho dữ liệu và Khai phá dữ liệu',3,1,''),('IT523',2,'User Interface','Giao diện Người dùng',3,1,''),('IT524',2,'Web Application Development','Phát triển ứng dụng Web',3,1,''),('IT525',2,'Information System Security','An ninh Hệ thống Thông tin',3,1,''),('IT531',2,'Network Management','Quản lý mạng',3,1,''),('IT532',2,'Distributed Computing','Tính toán phân bố',3,1,''),('IT533',2,'Wireless and Mobile Network','Mạng không dây',3,1,''),('IT534',2,'Network Application Development','Phát triển ứng dụng mạng',3,1,''),('IT535',2,'Advanced Operating System','Hệ điều hành nâng cao',3,1,''),('IT541',2,'E-Commerce','Thương mại điện tử',3,1,''),('IT542',2,'Information System Management','Quản trị Hệ thống Thông tin',3,1,''),('IT543',2,'IT Project Management','Quản trị dự án CNTT',3,1,''),('IT544',2,'Network Security','An toàn Mạng Máy tính',3,1,''),('IT545',2,'Algorithm Optimization','Tối ưu hóa giải thuật',3,1,''),('IT561_1',2,'Thesis (Research)','Luận văn tốt nghiệp',0,32,''),('IT561_2',2,'Thesis (Course Work)','Luận văn tốt nghiệp',0,12,''),('MITM_IM_1',2,'Elective 1 (Information Management Major)','Môn tự chọn 1 (chuyên ngành quản trị hệ thống thông tin)',3,1,''),('MITM_IM_2',2,'Elective 2 (Information Management Major)','Môn tự chọn 2 (chuyên ngành quản trị hệ thống thông tin)',3,1,''),('MITM_IM_3',2,'Elective 3 (Information Management Major)','Môn tự chọn 3 (chuyên ngành quản trị hệ thống thông tin)',3,1,''),('MITM_IM_4',2,'Elective 4 (Information Management Major)','Môn tự chọn 4 (chuyên ngành quản trị hệ thống thông tin)',3,1,''),('MITM_IM_5',2,'Elective 5 (Information Management Major)','Môn tự chọn 5 (chuyên ngành quản trị hệ thống thông tin)',3,1,''),('MITM_IM_6',2,'Elective 6 (Information Management Major)','Môn tự chọn 6 (chuyên ngành quản trị hệ thống thông tin)',3,1,''),('MITM_IM_7',2,'Elective 7 (Information Management Major)','Môn tự chọn 7 (chuyên ngành quản trị hệ thống thông tin)',3,1,''),('MITM_IM_8',2,'Elective 8 (Information Management Major)','Môn tự chọn 8 (chuyên ngành quản trị hệ thống thông tin)',3,1,''),('MITM_NM_1',2,'Elective 1 (Network Management Major)','Môn tự chọn 1 (chuyên ngành quản trị hệ thống mạng)',3,1,''),('MITM_NM_2',2,'Elective 2 (Network Management Major)','Môn tự chọn 2 (chuyên ngành quản trị hệ thống mạng)',3,1,''),('MITM_NM_3',2,'Elective 3 (Network Management Major)','Môn tự chọn 3 (chuyên ngành quản trị hệ thống mạng)',3,1,''),('MITM_NM_4',2,'Elective 4 (Network Management Major)','Môn tự chọn 4 (chuyên ngành quản trị hệ thống mạng)',3,1,''),('MITM_NM_5',2,'Elective 5 (Network Management Major)','Môn tự chọn 5 (chuyên ngành quản trị hệ thống mạng)',3,1,''),('MITM_NM_6',2,'Elective 6 (Network Management Major)','Môn tự chọn 6 (chuyên ngành quản trị hệ thống mạng)',3,1,''),('MITM_NM_7',2,'Elective 7 (Network Management Major)','Môn tự chọn 7 (chuyên ngành quản trị hệ thống mạng)',3,1,''),('MITM_NM_8',2,'Elective 8 (Network Management Major)','Môn tự chọn 8 (chuyên ngành quản trị hệ thống mạng)',3,1,''),('PE501',2,'Research Methodology','Phương pháp luận NCKH',2,0,''),('PE502',2,'Professional Ethics','Đạo đức nghề nghiệp',2,0,''),('PE505',2,'Philosophy','Triết',3,0,'');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_assessment`
--

DROP TABLE IF EXISTS `course_assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_assessment` (
  `assessment_id` int(11) NOT NULL,
  `course_id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `percentage` int(11) NOT NULL,
  PRIMARY KEY (`assessment_id`,`course_id`),
  KEY `Fk_AssessmentCourse_Course` (`course_id`),
  CONSTRAINT `FK_course_assessment_assessment` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Fk_AssessmentCourse_Course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_assessment`
--

LOCK TABLES `course_assessment` WRITE;
/*!40000 ALTER TABLE `course_assessment` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_level`
--

DROP TABLE IF EXISTS `course_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_level` (
  `id` int(11) NOT NULL,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_course_level_course` FOREIGN KEY (`id`) REFERENCES `course` (`course_level_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_level`
--

LOCK TABLES `course_level` WRITE;
/*!40000 ALTER TABLE `course_level` DISABLE KEYS */;
INSERT INTO `course_level` VALUES (2,'Master');
/*!40000 ALTER TABLE `course_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_program`
--

DROP TABLE IF EXISTS `course_program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_program` (
  `course_id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `program_id` int(11) NOT NULL,
  `course_code` varchar(255) CHARACTER SET utf8 NOT NULL,
  `course_type_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`,`program_id`),
  KEY `course_id` (`course_id`),
  KEY `fk2_idx` (`program_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_program`
--

LOCK TABLES `course_program` WRITE;
/*!40000 ALTER TABLE `course_program` DISABLE KEYS */;
INSERT INTO `course_program` VALUES ('IT501',23,'IT501',2),('IT501',24,'IT501',2),('IT501',25,'IT501',2),('IT501',26,'IT501',2),('IT501',27,'IT501',2),('IT501',28,'IT501',2),('IT501',29,'IT501',2),('IT501',30,'IT501',2),('IT502',23,'IT502',2),('IT502',24,'IT502',2),('IT502',25,'IT502',2),('IT502',26,'IT502',2),('IT502',27,'IT502',2),('IT502',28,'IT502',2),('IT502',29,'IT502',2),('IT502',30,'IT502',2),('IT503',23,'IT503',2),('IT503',24,'IT503',2),('IT503',25,'IT503',2),('IT503',26,'IT503',2),('IT503',27,'IT503',2),('IT503',28,'IT503',2),('IT503',29,'IT503',2),('IT503',30,'IT503',2),('IT561_1',25,'IT561',5),('IT561_1',26,'IT561',5),('IT561_1',29,'IT561',5),('IT561_1',30,'IT561',5),('IT561_2',23,'IT561',5),('IT561_2',24,'IT561',5),('IT561_2',27,'IT561',5),('IT561_2',28,'IT561',5),('MITM_IM_1',23,'MITM_IM_1',3),('MITM_IM_1',27,'MITM_IM_1',3),('MITM_IM_1',29,'MITM_IM_1',3),('MITM_IM_2',23,'MITM_IM_2',3),('MITM_IM_2',27,'MITM_IM_2',3),('MITM_IM_2',29,'MITM_IM_2',3),('MITM_IM_3',23,'MITM_IM_3',3),('MITM_IM_3',27,'MITM_IM_3',3),('MITM_IM_4',23,'MITM_IM_4',3),('MITM_IM_4',27,'MITM_IM_4',3),('MITM_IM_4',29,'MITM_IM_4',3),('MITM_IM_5',23,'MITM_IM_5',3),('MITM_IM_5',27,'MITM_IM_5',3),('MITM_IM_6',27,'MITM_IM_6',3),('MITM_IM_7',27,'MITM_IM_7',3),('MITM_IM_8',27,'MITM_IM_8',3),('MITM_NM_1',24,'MITM_NM_1',3),('MITM_NM_1',28,'MITM_NM_1',3),('MITM_NM_1',30,'MITM_NM_1',3),('MITM_NM_2',24,'MITM_NM_2',3),('MITM_NM_2',28,'MITM_NM_2',3),('MITM_NM_2',30,'MITM_NM_2',3),('MITM_NM_3',24,'MITM_NM_3',3),('MITM_NM_3',28,'MITM_NM_3',3),('MITM_NM_4',24,'MITM_NM_4',3),('MITM_NM_4',28,'MITM_NM_4',3),('MITM_NM_4',30,'MITM_NM_4',3),('MITM_NM_5',24,'MITM_NM_5',3),('MITM_NM_5',28,'MITM_NM_5',3),('MITM_NM_6',28,'MITM_NM_6',3),('MITM_NM_7',28,'MITM_NM_7',3),('MITM_NM_8',28,'MITM_NM_8',3),('PE501',23,'PE501',2),('PE501',24,'PE501',2),('PE501',25,'PE501',2),('PE501',26,'PE501',2),('PE501',27,'PE501',2),('PE501',28,'PE501',2),('PE501',29,'PE501',2),('PE501',30,'PE501',2),('PE502',23,'PE502',2),('PE502',24,'PE502',2),('PE502',25,'PE502',2),('PE502',26,'PE502',2),('PE502',27,'PE502',2),('PE502',28,'PE502',2),('PE502',29,'PE502',2),('PE502',30,'PE502',2),('PE505',23,'PE505',1),('PE505',24,'PE505',1),('PE505',25,'PE505',1),('PE505',26,'PE505',1),('PE505',27,'PE505',1),('PE505',28,'PE505',1),('PE505',29,'PE505',1),('PE505',30,'PE505',1);
/*!40000 ALTER TABLE `course_program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'Nguyen Van Sinh','Dr.','nvsinh@hcmiu.edu.vn'),(2,'Tran Thanh Tung','Dr.','tttung@hcmiu.edu.vn'),(3,'Nguyen Quang Phu','MSc.','nqphu@hcmiu.edu.vn'),(4,'Nguyen Thi Thuy Loan','Dr.','nttloan@hcmiu.edu.vn'),(5,'Pham Quoc Son Lam','MSc.','pqslam@hcmiu.edu.vn'),(6,'Huynh Kha Tu','Dr.','hktu@hcmiu.edu.vn'),(7,'Dao Tran Hoang Chau','MSc.','dthchau@hcmiu.edu.vn'),(8,'Ly Tu Nga','Dr.','ltnga@hcmiu.edu.vn'),(9,'Vo Thi Luu Phuong','Assof.Dr.','vtlphuong@hcmiu.edu.vn'),(10,'Ha Viet Uyen Synh','Dr.','hvusynh@hcmiu.edu.vn'),(11,'Nguyen Thi Thanh Sang','Dr.','nttsang@hcmiu.edu.vn'),(12,'Le Thanh Son','MSc.','ltson@hcmiu.edu.vn'),(13,'Nguyen Ngoc Hai','Dr.','nnhai@hcmiu.edu.vn'),(14,'Huynh Kim Lam','Dr.','hklam@hcmiu.edu.vn'),(15,'Mai Duc Thanh','Dr.','mdthanh@hcmiu.edu.vn'),(16,'Nguyen Van Thu','Prof.D.Sc','nvthu@hcmiu.edu.vn'),(17,'Pham Huynh Tram','Dr.','phtram@hcmiu.edu.vn'),(18,'Nguyen Hong Duc','MSc.','nhduc@hcmiu.edu.vn'),(19,'Phan Bao Ngoc','Assof.Dr.','pbngoc@hcmiu.edu.vn'),(20,'Do Xuan Hoi ','Dr.','dxhoi@hcmiu.edu.vn'),(21,'Mai Linh','Dr.','mlinh@hcmiu.edu.vn'),(22,'Vo Tan Phuoc','Dr.','vtphuoc@hcmiu.edu.vn'),(23,'Do Ngoc Hung','MSc.','dnhung@hcmiu.edu.vn'),(24,'Ton That Long','Dr.','ttlong@hcmiu.edu.vn'),(25,'Tran Xuan Phuoc','Dr.','txphuoc@hcmiu.edu.vn'),(26,'Nguyen Dinh Uyen','Dr.','nduyen@hcmiu.edu.vn'),(27,'Vo Minh Thanh','MSc.','vmthanh@hcmiu.edu.vn'),(28,'Nguyen Tien Dung','MSc.','ntdung@hcmiu.edu.vn'),(29,'Phan Nguyen Ky Phuc','Dr.','pnkphuc@hcmiu.edu.vn'),(30,'Dao Vu Truong Son','Dr.','dvtson@hcmiu.edu.vn'),(31,'Nguyen Van Hop','Dr.','nvhop@hcmiu.edu.vn'),(32,'Ha Thi Xuan Chi','Dr.','htxchi@hcmiu.edu.vn'),(33,'Bui Xuan Anh Dao','MSc.','bxadao@hcmiu.edu.vn'),(38,'Do Pham Minh Thu Cute','MSc','dpmthu@hcmiu.edu.vn'),(39,'Do Pham Minh Thu','MSc','dpmthu@hcmiu.edu.vn');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `learning_outcome`
--

DROP TABLE IF EXISTS `learning_outcome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `learning_outcome` (
  `id` int(11) NOT NULL,
  `course_id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `description` text CHARACTER SET utf8 NOT NULL,
  `description_vn` text CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_LearningOutcome` (`course_id`),
  CONSTRAINT `FK_LearningOutcome` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learning_outcome`
--

LOCK TABLES `learning_outcome` WRITE;
/*!40000 ALTER TABLE `learning_outcome` DISABLE KEYS */;
/*!40000 ALTER TABLE `learning_outcome` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `program` (
  `id` int(11) NOT NULL,
  `major_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `version` varchar(4) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_program_major` (`major_id`),
  CONSTRAINT `FK_program_major` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
/*!40101 SET character_set_client = utf8 */;
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
  CONSTRAINT `FK_result_class` FOREIGN KEY (`class_id`) REFERENCES `class_session` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_result_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slo`
--

DROP TABLE IF EXISTS `slo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `major` varchar(45) DEFAULT NULL,
  `batch` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('ITDSIU18012','Phạm Hoàng Minh','DS',2018),('ITDSIU18023','Nguyễn Quỳnh Hương','DS',2018),('ITITIU17084','Nguyễn Lê Thanh Tùng','IT',2017),('ITITIU17106','Dư Duy Bảo','IT',2017),('ITITIU18102','Cáp Kim Quang','IT',2018),('ITITIU18115','Nguyễn Huỳnh Phương Thanh','IT',2018),('ITITIU19002','Trịnh Quang Anh','IT',2019);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uuid`
--

DROP TABLE IF EXISTS `uuid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uuid` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
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

-- Dump completed on 2021-05-15 11:28:48
