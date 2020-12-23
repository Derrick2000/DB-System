-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: jtsys
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `sys_depts`
--
DROP  DATABASE IF EXISTS dbms;
CREATE DATABASE IF NOT EXISTS dbms DEFAULT character SET utf8;
USE dbms;

DROP TABLE IF EXISTS `sys_depts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_depts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `parentId` int(11) DEFAULT NULL COMMENT '上级部门',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='部门管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_depts`
--

LOCK TABLES `sys_depts` WRITE;
/*!40000 ALTER TABLE `sys_depts` DISABLE KEYS */;
INSERT INTO `sys_depts` VALUES (2,'集团教研部',NULL,1,'集团教学和研发','2018-04-19 18:59:09','2020-01-12 14:13:22','admin',NULL),(4,'课程研发部',2,22,'负责课程研发','2018-04-22 18:10:58','2020-01-12 14:13:56',NULL,NULL),(5,'集团MIS部',NULL,13,'负责集团网络环境运维','2020-01-12 14:14:26','2020-01-12 14:14:26',NULL,NULL),(6,'市场部',NULL,6,'ccc','2020-04-28 15:53:23','2020-04-28 15:54:08',NULL,NULL),(7,'MIS-1部',5,5,'111','2020-04-28 15:53:46','2020-04-28 15:53:46',NULL,NULL);
/*!40000 ALTER TABLE `sys_depts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_logs`
--

DROP TABLE IF EXISTS `sys_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8 COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_logs`
--

LOCK TABLES `sys_logs` WRITE;
/*!40000 ALTER TABLE `sys_logs` DISABLE KEYS */;
INSERT INTO `sys_logs` VALUES (11,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',1,'0:0:0:0:0:0:0:1','2018-04-17 19:54:36'),(12,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',155,'0:0:0:0:0:0:0:1','2018-04-18 15:14:44'),(13,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',165,'0:0:0:0:0:0:0:1','2018-04-19 18:52:35'),(14,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',75,'0:0:0:0:0:0:0:1','2018-04-19 19:10:36'),(15,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-19 19:12:46'),(16,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',187,'0:0:0:0:0:0:0:1','2018-04-19 23:27:14'),(17,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',103,'0:0:0:0:0:0:0:1','2018-04-20 13:11:37'),(18,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',85,'0:0:0:0:0:0:0:1','2018-04-20 13:55:04'),(19,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',89,'0:0:0:0:0:0:0:1','2018-04-20 13:57:12'),(20,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-20 13:58:32'),(21,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',291,'0:0:0:0:0:0:0:1','2018-04-20 15:22:55'),(22,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',158,'0:0:0:0:0:0:0:1','2018-04-22 16:20:56'),(23,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',94,'0:0:0:0:0:0:0:1','2018-04-22 17:05:34'),(24,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',138,'0:0:0:0:0:0:0:1','2018-04-22 17:20:32'),(25,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',124,'0:0:0:0:0:0:0:1','2018-04-22 17:24:12'),(26,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',75,'0:0:0:0:0:0:0:1','2018-04-22 17:31:51'),(27,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',148,'0:0:0:0:0:0:0:1','2018-04-22 17:33:25'),(28,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-22 17:39:26'),(29,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',120,'0:0:0:0:0:0:0:1','2018-04-22 19:10:28'),(39,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',13,'0:0:0:0:0:0:0:1','2020-01-12 08:54:53'),(40,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',9,'0:0:0:0:0:0:0:1','2020-01-12 09:29:59'),(41,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',6,'0:0:0:0:0:0:0:1','2020-01-12 09:35:25'),(42,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"admin\",1]',5,'0:0:0:0:0:0:0:1','2020-01-12 09:35:30'),(43,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',7,'0:0:0:0:0:0:0:1','2020-01-12 09:35:44'),(44,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',5,'0:0:0:0:0:0:0:1','2020-01-12 09:35:46'),(45,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',5,'0:0:0:0:0:0:0:1','2020-01-12 09:36:07'),(46,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,0,\"admin\"]',1,'0:0:0:0:0:0:0:1','2020-01-12 09:36:19'),(47,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,1,\"admin\"]',1,'0:0:0:0:0:0:0:1','2020-01-12 09:36:55'),(48,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,0,\"admin\"]',1,'0:0:0:0:0:0:0:1','2020-01-12 09:37:05'),(49,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',25,'0:0:0:0:0:0:0:1','2020-01-12 09:42:35'),(50,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,1,\"admin\"]',2,'0:0:0:0:0:0:0:1','2020-01-12 09:42:38'),(51,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,0,\"admin\"]',4,'0:0:0:0:0:0:0:1','2020-01-12 09:43:23'),(52,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[15,0,\"admin\"]',1,'0:0:0:0:0:0:0:1','2020-01-12 09:45:04'),(53,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',25,'0:0:0:0:0:0:0:1','2020-01-12 09:53:54'),(54,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,1,\"admin\"]',2,'0:0:0:0:0:0:0:1','2020-01-12 09:53:55'),(55,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,0,\"admin\"]',1,'0:0:0:0:0:0:0:1','2020-01-12 09:54:18'),(56,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',6,'0:0:0:0:0:0:0:1','2020-01-12 09:55:00'),(57,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,1,\"admin\"]',4,'0:0:0:0:0:0:0:1','2020-01-12 09:55:01'),(58,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,0,\"admin\"]',2,'0:0:0:0:0:0:0:1','2020-01-12 09:55:04'),(59,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',10,'0:0:0:0:0:0:0:1','2020-01-12 09:55:23'),(60,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',10,'0:0:0:0:0:0:0:1','2020-01-12 10:37:24'),(61,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',9,'0:0:0:0:0:0:0:1','2020-01-12 10:37:49'),(62,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',27,'0:0:0:0:0:0:0:1','2020-01-12 11:04:16'),(63,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',9,'0:0:0:0:0:0:0:1','2020-01-12 11:05:58'),(64,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',9,'0:0:0:0:0:0:0:1','2020-01-12 11:07:22'),(68,'admin','operation','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',30,'192.168.1.112','2020-05-07 09:46:55'),(69,'admin','operation','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',17,'192.168.1.112','2020-05-07 09:47:10'),(70,'admin','operation','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',17,'192.168.1.112','2020-05-07 09:47:49'),(71,'admin','operation','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16, 1]',72,'192.168.1.112','2020-05-07 09:47:58'),(72,'admin','operation','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',16,'192.168.1.112','2020-05-07 09:52:18'),(73,'admin','operation','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',16,'192.168.1.112','2020-05-07 09:52:27'),(74,'admin','operation','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16, 0]',66,'192.168.1.112','2020-05-07 09:52:34'),(75,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',16,'192.168.1.112','2020-05-07 09:57:52'),(76,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',14,'192.168.1.112','2020-05-07 09:58:01'),(77,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[17, 0]',73,'192.168.1.112','2020-05-07 09:58:06'),(78,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',19,'0:0:0:0:0:0:0:1','2020-05-07 10:02:14'),(79,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',12,'192.168.2.101','2020-05-07 10:02:55'),(81,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',20,'192.168.2.101','2020-05-07 10:29:19'),(82,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',15,'192.168.2.101','2020-05-07 10:34:32'),(83,'admin','添加用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.saveObject','[SysUser(id=19, username=liqiang, password=302b67d0710e887cf8164426cd59da28, salt=4ddeb5b4-96dc-4def-a2d7-c6c924701b76, email=lq@t.com, mobile=1111111111111, valid=1, deptId=6, createdTime=null, modifiedTime=null, createdUser=null, modifiedUser=null), [Ljava.lang.Integer;@38d5aa5d]',536,'192.168.2.101','2020-05-07 10:35:08'),(84,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[, 1]',11,'192.168.2.101','2020-05-07 10:35:11'),(85,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',23,'192.168.2.101','2020-05-07 10:38:48'),(87,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',11,'192.168.2.101','2020-05-07 10:39:22'),(88,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',20,'192.168.2.101','2020-05-07 10:58:43'),(89,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',10,'192.168.2.101','2020-05-07 10:59:06'),(90,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',12,'192.168.2.101','2020-05-07 11:13:09'),(91,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',10,'192.168.2.101','2020-05-07 11:13:26'),(92,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',15,'192.168.2.101','2020-05-07 11:14:45'),(93,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',475,'192.168.2.101','2020-05-07 11:15:13'),(94,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[20,0]',198111,'192.168.2.101','2020-05-07 11:18:37'),(95,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',35,'192.168.2.101','2020-05-07 11:51:08'),(96,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',21,'192.168.2.101','2020-05-07 11:51:09'),(97,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',23,'192.168.2.101','2020-05-07 11:51:10'),(98,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',20,'192.168.2.101','2020-05-07 11:51:11'),(99,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',14,'192.168.2.101','2020-05-07 11:51:11'),(100,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',15,'192.168.2.101','2020-05-07 11:51:12'),(101,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',17,'192.168.2.101','2020-05-07 11:59:32'),(102,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',11,'192.168.2.101','2020-05-07 11:59:34'),(103,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',12,'192.168.2.101','2020-05-07 11:59:35'),(104,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',18,'192.168.2.101','2020-05-07 11:59:36'),(105,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',11,'192.168.2.101','2020-05-07 11:59:39'),(106,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',13,'192.168.2.101','2020-05-07 14:01:25'),(107,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',11,'192.168.2.101','2020-05-07 14:01:34'),(108,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',17,'192.168.2.101','2020-05-07 14:03:46'),(109,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',11,'192.168.2.101','2020-05-07 14:04:57'),(110,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',133,'192.168.2.101','2020-05-07 14:06:50'),(111,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',17,'192.168.2.101','2020-05-07 14:06:59'),(112,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',17,'192.168.2.101','2020-05-07 14:07:47'),(113,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',26,'192.168.2.101','2020-05-07 14:07:52'),(114,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',14,'192.168.2.101','2020-05-07 14:17:59'),(115,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',14,'192.168.2.101','2020-05-07 14:21:45'),(116,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',16,'192.168.2.101','2020-05-07 14:23:40'),(117,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',13,'192.168.2.101','2020-05-07 14:32:09'),(118,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',164,'192.168.2.101','2020-05-07 15:39:35'),(119,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',16,'192.168.2.101','2020-05-07 15:39:53'),(120,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',16,'192.168.2.101','2020-05-07 15:39:54'),(121,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',18,'192.168.2.101','2020-05-07 15:39:54'),(122,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',31,'192.168.2.101','2020-05-07 15:39:55'),(123,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',11,'192.168.2.101','2020-05-07 15:39:55'),(124,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',11,'192.168.2.101','2020-05-07 15:39:56'),(125,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',14,'192.168.2.101','2020-05-07 15:39:56'),(126,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',17,'192.168.2.101','2020-05-07 15:39:57'),(127,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',19,'192.168.2.101','2020-05-07 15:39:57'),(128,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',10,'192.168.2.101','2020-05-07 15:39:58'),(129,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',204,'192.168.2.101','2020-05-07 15:46:18'),(131,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',24,'0:0:0:0:0:0:0:1','2020-05-08 15:35:44'),(132,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[20,1]',6,'0:0:0:0:0:0:0:1','2020-05-08 15:36:12'),(133,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',21,'0:0:0:0:0:0:0:1','2020-05-08 17:21:26'),(134,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"admin\",1]',10,'0:0:0:0:0:0:0:1','2020-05-08 17:21:36'),(136,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"admin\",1]',12,'0:0:0:0:0:0:0:1','2020-05-09 09:51:16'),(137,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',12,'0:0:0:0:0:0:0:1','2020-05-09 10:23:55'),(162,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',28,'127.0.0.1','2020-05-11 13:03:18'),(163,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',24,'0:0:0:0:0:0:0:1','2020-05-11 14:34:10'),(164,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',20,'0:0:0:0:0:0:0:1','2020-05-11 17:50:48'),(165,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",2]',20,'0:0:0:0:0:0:0:1','2020-05-11 17:50:52'),(166,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',13,'0:0:0:0:0:0:0:1','2020-05-11 17:50:53'),(167,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",2]',23,'0:0:0:0:0:0:0:1','2020-05-11 17:50:55'),(168,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",6]',10,'0:0:0:0:0:0:0:1','2020-05-11 17:50:57'),(169,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',13,'0:0:0:0:0:0:0:1','2020-05-11 17:55:24'),(170,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',149,'0:0:0:0:0:0:0:1','2020-05-12 08:26:02'),(171,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',12,'0:0:0:0:0:0:0:1','2020-05-12 10:44:58'),(172,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',71,'0:0:0:0:0:0:0:1','2020-05-27 14:28:20'),(173,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',11,'0:0:0:0:0:0:0:1','2020-05-27 14:28:29'),(174,'admin','查询用户','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',10,'0:0:0:0:0:0:0:1','2020-05-27 14:28:36');
/*!40000 ALTER TABLE `sys_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menus`
--

DROP TABLE IF EXISTS `sys_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(500) DEFAULT NULL COMMENT '授权(如：user:create)',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8 COMMENT='资源管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menus`
--

LOCK TABLES `sys_menus` WRITE;
/*!40000 ALTER TABLE `sys_menus` DISABLE KEYS */;
INSERT INTO `sys_menus` VALUES (8,'系统管理','请求路径',1,8,NULL,NULL,'','2017-07-12 15:15:59','2020-01-12 14:11:15','admin',NULL),(25,'日志管理','log/log_list',1,25,NULL,8,'sys:log:view','2017-07-12 15:15:59','2020-04-28 14:55:33','admin',NULL),(45,'用户管理','user/user_list',1,45,NULL,8,'sys:user:view','2017-07-12 15:15:59','2020-01-12 14:10:10','admin',NULL),(46,'菜单管理','menu/menu_list',1,46,NULL,8,'sys:menu:view','2017-07-12 15:15:59','2020-01-12 14:10:28','admin',NULL),(47,'角色管理','role/role_list',1,47,NULL,8,'sys:role:view','2017-07-12 15:15:59','2020-01-12 14:10:48','admin',NULL),(115,'查询','menu/doFindObjects',2,1,NULL,46,'sys:menu:view','2017-07-13 16:33:41','2020-01-12 14:21:29',NULL,NULL),(116,'添加','menu/doSaveObject',2,2,NULL,46,'sys:menu:add','2017-07-13 16:34:02','2020-01-12 14:21:56',NULL,NULL),(117,'修改','menu/doUpdateObject',2,3,NULL,46,'sys:menu:update','2017-07-13 16:34:25','2020-01-12 14:22:12',NULL,NULL),(118,'删除','role/doDeleteObject',2,4,NULL,46,'sys:menu:delete','2017-07-13 16:34:46','2020-01-12 14:22:41',NULL,NULL),(119,'查询','user/doFindPageObjects',2,1,NULL,45,'sys:user:view','2017-07-13 16:35:05','2020-01-12 14:20:28',NULL,NULL),(120,'查询','role/doFindPageObjects',2,1,NULL,47,'sys:role:view','2017-07-13 16:35:26','2020-01-12 14:23:05',NULL,NULL),(126,'新增','user/doSaveObject',2,2,NULL,45,'sys:user:add','2017-07-21 11:11:34','2020-01-12 14:20:45',NULL,NULL),(127,'修改','user/doUpdateObject',2,3,NULL,45,'sys:user:update','2017-07-21 11:11:56','2020-01-12 14:21:05',NULL,NULL),(128,'添加','role/doSaveObject',2,2,NULL,47,'sys:role:add','2017-07-21 11:14:24','2020-01-12 14:23:29',NULL,NULL),(129,'修改','role/doUpdateObject',2,3,NULL,47,'sys:role:update','2017-07-21 11:14:48','2020-01-12 14:23:44',NULL,NULL),(130,'删除','role/doDeleteObject',2,4,NULL,47,'sys:role:delete','2017-07-21 11:15:09','2020-01-12 14:24:05',NULL,NULL),(131,'删除','log/doDeleteObjects',2,27,NULL,25,'sys:log:delete','2020-01-10 17:34:31','2020-01-10 17:34:31',NULL,NULL),(137,'禁用启用','user/doValidById',2,123,NULL,45,'sys:user:update','2020-01-12 09:34:58','2020-01-12 09:34:58',NULL,NULL),(143,'查询','log/doFindPageObjects',2,210,NULL,25,'sys:log:view','2020-01-12 14:20:02','2020-01-12 14:20:02',NULL,NULL),(145,'修改密码','user/pwd_edit',1,17,NULL,8,'sys_pwd_edit','2020-05-09 14:35:48','2020-05-09 14:35:48',NULL,NULL),(146,'商品管理','',1,19,NULL,NULL,'sys:goods:view','2020-05-09 14:38:32','2020-05-09 14:38:32',NULL,NULL),(147,'基础管理','goods/goodles_list',1,22,NULL,146,'sys:goods:view','2020-05-09 14:39:46','2020-05-09 14:39:46',NULL,NULL),(148,'类目管理','category/category_list',1,23,NULL,146,'goods:category:view','2020-05-09 14:40:34','2020-05-09 14:40:34',NULL,NULL);
/*!40000 ALTER TABLE `sys_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menus`
--

DROP TABLE IF EXISTS `sys_role_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1400 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menus`
--

LOCK TABLES `sys_role_menus` WRITE;
/*!40000 ALTER TABLE `sys_role_menus` DISABLE KEYS */;
INSERT INTO `sys_role_menus` VALUES (1334,NULL,8),(1335,NULL,25),(1336,NULL,131),(1337,NULL,143),(1338,NULL,45),(1339,NULL,119),(1340,NULL,126),(1341,NULL,127),(1342,NULL,137),(1349,49,8),(1350,49,47),(1351,49,120),(1352,49,128),(1353,49,129),(1354,49,130),(1361,47,8),(1362,47,25),(1363,47,131),(1364,47,143),(1365,47,45),(1366,47,119),(1367,47,126),(1368,47,127),(1369,47,137),(1370,47,46),(1371,47,115),(1372,47,116),(1373,47,117),(1374,47,118),(1375,47,47),(1376,47,120),(1377,47,128),(1378,47,129),(1379,47,130),(1380,47,145),(1381,47,146),(1382,47,147),(1383,47,148),(1391,48,8),(1392,48,25),(1393,48,143),(1394,48,47),(1395,48,120),(1396,48,128),(1397,48,129),(1398,48,130),(1399,48,145);
/*!40000 ALTER TABLE `sys_role_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_roles`
--

DROP TABLE IF EXISTS `sys_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_roles`
--

LOCK TABLES `sys_roles` WRITE;
/*!40000 ALTER TABLE `sys_roles` DISABLE KEYS */;
INSERT INTO `sys_roles` VALUES (47,'超级管理员','负责系统所有模块的管理','2020-04-29 10:59:45','2020-05-09 16:22:24',NULL,NULL),(48,'初级软件工程师','负责代码实现','2020-04-29 11:02:01','2020-05-11 11:29:26',NULL,NULL),(49,'中级软件工程师','负责需求分析，模块设计','2020-04-29 16:05:58','2020-04-29 17:03:20',NULL,NULL);
/*!40000 ALTER TABLE `sys_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_roles`
--

DROP TABLE IF EXISTS `sys_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_roles`
--

LOCK TABLES `sys_user_roles` WRITE;
/*!40000 ALTER TABLE `sys_user_roles` DISABLE KEYS */;
INSERT INTO `sys_user_roles` VALUES (70,18,49),(71,17,48),(72,16,47),(74,20,48),(75,1,47),(76,19,49);
/*!40000 ALTER TABLE `sys_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_users`
--

DROP TABLE IF EXISTS `sys_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐  密码加密时前缀，使加密后的值不同',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `valid` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常  默认值 ：1',
  `deptId` int(11) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_users`
--

LOCK TABLES `sys_users` WRITE;
/*!40000 ALTER TABLE `sys_users` DISABLE KEYS */;
INSERT INTO `sys_users` VALUES (1,'admin','c4c33035c5d8e840616c128db9f87b25','016a0948-b581-43aa-8a5f-9bb76a80e737','admin@t.cn','13624356789',1,2,NULL,'2020-05-08 17:21:55',NULL,NULL),(2,'zhangli','bdcf69375bdb532e50279b91eb00940d','5e7cbd36-e897-4951-b42b-19809caf3caa','zhangli@t.cn','13678909876',0,3,'2017-07-18 10:01:51','2018-04-22 20:49:19',NULL,'admin'),(3,'wangke','c5dc32ec66041aeddf432b3146bd2257','5e3e1475-1ea9-4a6a-976e-b07545827139','wangke@t.cn','18678900987',1,3,'2017-07-18 11:40:53','2018-04-22 20:48:52',NULL,NULL),(4,'zhangql','+HBpqtPuj9KLBIpneR5X0A==','ed487fac-9952-45c9-acaa-21dab9c689cc','zhangql@t.cn','13678909876',1,2,'2017-07-18 12:17:30','2018-04-22 20:48:04',NULL,NULL),(5,'fanwei','1acab7425d6dfae670f26bd160518902','34fbedb2-e135-4f8d-b595-24360edc348d','fanwei@t.cn','13876545678',1,3,'2017-07-20 17:03:22','2018-04-22 20:47:49',NULL,NULL),(6,'wumei','431ebdcccf3404787a144f9ba669a8e2','8a14f46f-7a17-4dfe-85ab-08e63cb618ce','wumei@t.cn','13567898765',1,2,'2017-07-21 10:57:40','2018-04-22 20:46:49',NULL,NULL),(7,'user-003','689c673a0d8bda7ee795dd45a126ae96','3faa1d2b-a99f-4ffb-9d29-0e71563258af','t@t.com','123',1,3,'2018-01-12 23:19:58','2018-04-22 20:46:07',NULL,'admin'),(9,'user-002','e10adc3949ba59abbe56e057f20f883e',NULL,'t@t.com','123',1,3,'2018-01-12 23:20:31','2018-04-22 20:45:55',NULL,NULL),(12,'user-001','5bf6593afd106aa544000d559f0c2241','9528e727-2901-4746-8558-9010d9607da2','t@t.com','123',1,3,'2018-01-13 01:48:32','2018-04-22 20:45:37',NULL,NULL),(13,'user-c','2630d8bd50c76abf001a9daceeae97e6','30fff766-e245-4a93-9f5e-6eb2c2cec494','t@t.com','123456',1,3,'2018-01-13 02:01:56','2020-04-30 12:02:24',NULL,'admin'),(15,'user-b','2ce586af95c6431112092f653659c85f','eaedbaee-d760-40e4-b71e-ccecf01b6187','t@t.com','123456',1,3,'2018-01-13 02:02:06','2020-04-30 12:01:31',NULL,'admin'),(16,'lifa','710058cf374a38d76510d009f63bf28d','e8e35b96-bbdd-4090-81ee-b71a36141760','lf@t.com','1111111111',0,2,'2018-04-22 19:43:11','2020-05-07 09:52:33',NULL,'admin'),(17,'xiaoli','dd93e70c79e12b5c734080fb9ee91229','e0036733-1378-4ff0-a5c3-8ddc5f8e0db2','xl@t.com','11122222',0,6,'2020-01-12 10:37:47','2020-05-07 09:58:05',NULL,'admin'),(18,'wangzhen','9b12c8e94530a0d95d9e91f4d1429c4b','4d54a593-6da5-44a8-87ca-4db7d92a526c','wz@t.com','1111111111111',1,6,'2020-04-30 14:45:10','2020-05-06 11:19:35',NULL,'admin'),(19,'liqiang','302b67d0710e887cf8164426cd59da28','4ddeb5b4-96dc-4def-a2d7-c6c924701b76','lq@t.com','1111111111111',1,6,'2020-05-07 10:35:07','2020-05-11 10:48:18',NULL,NULL),(20,'guoqing','d16322520b08734174e271e263ace655','65ec8f97-ec0f-45ff-a63d-9a7f8061c6dc','gq@t.com','1111111111',1,2,'2020-05-07 10:39:19','2020-05-09 15:24:15',NULL,'admin');
/*!40000 ALTER TABLE `sys_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-27 14:46:25
