/*
SQLyog Ultimate v8.32 
MySQL - 5.6.17 : Database - youjia
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`youjia` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `youjia`;

/*Table structure for table `cartable` */

DROP TABLE IF EXISTS `cartable`;

CREATE TABLE `cartable` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `shoeName` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `store` int(11) NOT NULL DEFAULT '0',
  `marUrl` varchar(1000) DEFAULT NULL,
  `shoeSize` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cartable` */

insert  into `cartable`(`id`,`username`,`shoeName`,`price`,`store`,`marUrl`,`shoeSize`) values (2,'qwe','帆布鞋',299,100,'https://img14.360buyimg.com/n7/jfs/t1/36152/25/11175/144829/5cef43d8E6382f6c3/769a03051937d730.jpg',41),(2,'qwe','帆布鞋',299,100,'https://img14.360buyimg.com/n7/jfs/t1/36152/25/11175/144829/5cef43d8E6382f6c3/769a03051937d730.jpg',41),(2,'qwe','帆布鞋',299,100,'https://img14.360buyimg.com/n7/jfs/t1/36152/25/11175/144829/5cef43d8E6382f6c3/769a03051937d730.jpg',41),(2,'qwe','帆布鞋',299,100,'https://img14.360buyimg.com/n7/jfs/t1/36152/25/11175/144829/5cef43d8E6382f6c3/769a03051937d730.jpg',41),(3,'qwe','123',199,100,'https://img10.360buyimg.com/n7/jfs/t27268/280/1544175481/221242/a8859519/5be556adNdac5597d.jpg',43);

/*Table structure for table `commoditytype` */

DROP TABLE IF EXISTS `commoditytype`;

CREATE TABLE `commoditytype` (
  `ctId` int(11) NOT NULL AUTO_INCREMENT,
  `ctName` varchar(20) NOT NULL,
  PRIMARY KEY (`ctId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `commoditytype` */

insert  into `commoditytype`(`ctId`,`ctName`) values (1,'跑步鞋'),(2,'训练鞋'),(3,'足球鞋'),(4,'篮球鞋'),(5,'户外鞋'),(6,'其他运动');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `empId` int(11) NOT NULL AUTO_INCREMENT,
  `empName` varchar(20) NOT NULL,
  `empPwd` varchar(20) NOT NULL,
  `empSalary` decimal(8,2) NOT NULL,
  `empCard` varchar(20) NOT NULL,
  `empAddress` varchar(40) NOT NULL,
  `empPhone` varchar(15) NOT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`empId`,`empName`,`empPwd`,`empSalary`,`empCard`,`empAddress`,`empPhone`) values (1,'石中意','123456','199.00','430682199711230215','长沙市','13812345567'),(2,'李卫','123456','199.00','430682199712261213','长沙市','13844322342'),(3,'曾默涵','123456','199.00','430682199705251234','长沙市','13832137694'),(4,'赵函','123456','199.00','430682199707152325','长沙市','13833219887'),(5,'钱升','123456','199.00','430682199711051236','长沙市','13844677563'),(6,'王翌','123456','199.00','430682199712241127','长沙市','13877882212'),(7,'汤洪','123456','199.00','430682199711232636','长沙市','13899993443'),(8,'邓威','123456','199.00','430682199701111417','长沙市','13888885322'),(9,'罗煜霖','123456','199.00','430682199709122374','长沙市','13888763321'),(10,'刘登升','123456','199.00','430682199702131122','长沙市','13866111331');

/*Table structure for table `fiscalexpend` */

DROP TABLE IF EXISTS `fiscalexpend`;

CREATE TABLE `fiscalexpend` (
  `feId` int(11) NOT NULL AUTO_INCREMENT,
  `poId` int(11) NOT NULL,
  `feTime` datetime NOT NULL,
  `empId` int(11) NOT NULL,
  `feMoney` double NOT NULL,
  PRIMARY KEY (`feId`),
  KEY `poId` (`poId`),
  KEY `empId` (`empId`),
  CONSTRAINT `fiscalexpend_ibfk_1` FOREIGN KEY (`poId`) REFERENCES `purchaseorder` (`poId`),
  CONSTRAINT `fiscalexpend_ibfk_2` FOREIGN KEY (`empId`) REFERENCES `employee` (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `fiscalexpend` */

insert  into `fiscalexpend`(`feId`,`poId`,`feTime`,`empId`,`feMoney`) values (1,1,'2019-10-14 17:07:03',1,199),(2,2,'2019-10-14 16:27:12',2,199),(3,3,'2019-10-14 17:07:03',2,199),(4,4,'2019-10-14 16:27:12',1,199),(5,5,'2019-10-14 17:07:03',1,199),(6,6,'2019-10-14 16:27:12',3,199),(7,7,'2019-10-14 17:07:03',1,199),(8,8,'2019-10-14 16:27:12',4,199),(9,9,'2019-10-14 17:07:03',1,199),(10,10,'2019-10-14 16:27:12',1,199),(11,13,'2019-10-23 17:07:03',1,199),(12,14,'2019-10-25 16:27:12',1,199),(13,16,'2019-10-30 17:07:03',1,199),(14,17,'2019-10-16 15:50:55',1,199),(15,20,'2019-10-27 16:04:17',1,199),(16,21,'2019-10-27 16:04:17',1,199),(17,22,'2019-10-27 16:11:27',1,199),(18,23,'2019-10-27 16:17:59',1,199),(19,24,'2019-10-27 16:27:12',1,199),(20,25,'2019-10-27 16:27:12',1,199),(21,26,'2019-10-27 16:28:50',1,199),(22,27,'2019-10-27 17:04:02',1,199),(23,31,'2019-10-29 19:09:47',1,1110),(24,32,'2019-10-29 19:10:20',1,99900),(25,33,'2019-10-29 19:17:14',1,99900);

/*Table structure for table `fiscalrevenue` */

DROP TABLE IF EXISTS `fiscalrevenue`;

CREATE TABLE `fiscalrevenue` (
  `frId` int(11) NOT NULL AUTO_INCREMENT,
  `soId` int(11) NOT NULL,
  `frTime` datetime NOT NULL,
  `frMoney` double NOT NULL,
  PRIMARY KEY (`frId`),
  KEY `soId` (`soId`),
  CONSTRAINT `fiscalrevenue_ibfk_1` FOREIGN KEY (`soId`) REFERENCES `salesorder` (`soId`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

/*Data for the table `fiscalrevenue` */

insert  into `fiscalrevenue`(`frId`,`soId`,`frTime`,`frMoney`) values (1,1,'2019-10-14 13:58:54',199),(2,2,'2019-10-14 13:58:54',199),(3,3,'2019-10-14 13:58:54',199),(4,4,'2019-10-14 13:58:54',199),(5,5,'2019-10-14 13:58:54',199),(6,6,'2019-10-14 13:58:54',199),(7,7,'2019-10-14 13:58:54',199),(8,8,'2019-10-14 13:58:54',199),(9,9,'2019-10-14 13:58:54',199),(10,10,'2019-10-14 13:58:54',199),(11,2,'0000-00-00 13:58:54',199),(12,2,'2019-10-27 11:55:12',199),(13,2,'2019-10-27 11:59:50',199),(14,3,'2019-10-27 13:55:24',199),(15,2,'2019-10-27 13:58:54',199),(16,2,'2019-10-27 13:58:54',199),(17,3,'2019-10-27 14:03:45',199),(18,1,'2019-10-27 14:32:00',199),(19,1,'2019-10-27 14:32:00',199),(20,1,'2019-10-27 14:32:00',199),(21,1,'2019-10-27 14:32:00',199),(22,1,'2019-10-27 14:32:00',199),(23,1,'2019-10-27 14:39:55',199),(24,1,'2019-10-27 14:39:55',199),(25,1,'2019-10-27 14:39:55',199),(26,1,'2019-10-27 14:39:55',199),(27,1,'2019-10-27 14:39:55',199),(28,1,'2019-10-27 14:39:55',199),(29,1,'2019-10-27 14:39:55',199),(30,1,'2019-10-27 14:39:55',199),(31,1,'2019-10-27 14:39:55',199),(32,1,'2019-10-27 14:39:55',199),(33,1,'2019-10-27 14:39:55',199),(34,1,'2019-10-27 14:39:55',199),(35,1,'2019-10-27 14:39:55',199),(36,1,'2019-10-27 14:39:55',199),(37,1,'2019-10-27 14:39:55',199),(38,1,'2019-10-27 14:39:55',199),(39,1,'2019-10-27 14:39:55',199),(40,1,'2019-10-27 14:39:55',199),(41,1,'2019-10-27 16:30:22',199);

/*Table structure for table `fiscalsummary` */

DROP TABLE IF EXISTS `fiscalsummary`;

CREATE TABLE `fiscalsummary` (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `fName` varchar(20) NOT NULL,
  `fState` varchar(10) NOT NULL,
  `countTime` datetime NOT NULL,
  `fPrice` decimal(8,2) NOT NULL,
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `fiscalsummary` */

insert  into `fiscalsummary`(`fId`,`fName`,`fState`,`countTime`,`fPrice`) values (1,'卖出小白鞋','已收入','2019-10-24 16:30:22','199.00'),(2,'卖出小白鞋','已收入','2019-10-24 16:30:23','199.00'),(3,'卖出小白鞋','已收入','2019-10-24 16:30:24','199.00'),(4,'卖出小白鞋','已收入','2019-10-24 16:30:25','199.00'),(5,'卖出小白鞋','已收入','2019-10-24 16:30:27','199.00'),(6,'卖出小白鞋','已收入','2019-10-24 16:30:29','199.00'),(7,'卖出小白鞋','已收入','2019-10-24 16:30:30','199.00'),(8,'卖出小白鞋','已收入','2019-10-24 16:30:31','199.00'),(9,'卖出小白鞋','已收入','2019-10-24 16:30:32','199.00'),(10,'卖出小白鞋','已收入','2019-10-24 16:30:33','199.00'),(11,'12','12','2019-10-14 10:02:21','12.00'),(12,'卖出的鞋子','已卖出','2019-10-29 17:09:03','499.00'),(13,'卖出的鞋子','已卖出','2019-10-29 17:10:37','399.00'),(14,'卖出的鞋子','已卖出','2019-10-29 17:12:23','199.00'),(15,'卖出的鞋子','已卖出','2019-10-29 17:21:04','399.00'),(16,'123','12','2019-10-14 10:02:21','12.00'),(17,'卖出的鞋子','已卖出','2019-10-29 17:32:38','399.00'),(18,'卖出的鞋子','已卖出','2019-10-29 17:33:27','399.00'),(19,'卖出的鞋子','已卖出','2019-10-29 17:36:59','299.00'),(20,'卖出的鞋子','已卖出','2019-10-29 18:05:17','399.00'),(21,'卖出的鞋子','已卖出','2019-10-29 18:23:26','399.00'),(22,'卖出的鞋子','已卖出','2019-10-29 19:13:50','299.00'),(23,'卖出的鞋子','已卖出','2019-10-29 19:52:07','299.00');

/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `itId` int(11) NOT NULL AUTO_INCREMENT,
  `itNumber` int(11) NOT NULL,
  `ctId` int(11) NOT NULL,
  PRIMARY KEY (`itId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `inventory` */

insert  into `inventory`(`itId`,`itNumber`,`ctId`) values (1,1212,1),(2,999,2),(3,999,3),(4,999,4),(5,999,5),(6,999,6),(7,1,2);

/*Table structure for table `marque` */

DROP TABLE IF EXISTS `marque`;

CREATE TABLE `marque` (
  `marId` int(11) NOT NULL AUTO_INCREMENT,
  `marName` varchar(20) NOT NULL,
  `marYardage` int(11) NOT NULL,
  `marIntroduce` varchar(40) NOT NULL,
  `marUrl` varchar(1000) NOT NULL,
  `marPrice` decimal(8,2) NOT NULL,
  `marConvert` decimal(8,2) NOT NULL,
  `ctId` int(11) NOT NULL,
  `stores` int(50) DEFAULT '0',
  PRIMARY KEY (`marId`),
  KEY `ctId` (`ctId`),
  CONSTRAINT `marque_ibfk_1` FOREIGN KEY (`ctId`) REFERENCES `commoditytype` (`ctId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `marque` */

insert  into `marque`(`marId`,`marName`,`marYardage`,`marIntroduce`,`marUrl`,`marPrice`,`marConvert`,`ctId`,`stores`) values (1,'跑步鞋',40,'男生跑步鞋','https://img11.360buyimg.com/n7/jfs/t27268/280/1544175481/221242/a8859519/5be556adNdac5597d.jpg','399.00','299.00',1,1),(2,'帆布鞋',41,'男生帆布鞋','https://img14.360buyimg.com/n7/jfs/t1/36152/25/11175/144829/5cef43d8E6382f6c3/769a03051937d730.jpg','299.00','199.00',5,92),(3,'拖鞋',43,'男生拖鞋','https://img10.360buyimg.com/n7/jfs/t27268/280/1544175481/221242/a8859519/5be556adNdac5597d.jpg','199.00','159.00',6,98),(4,'复古鞋',40,'男生复古鞋','https://img14.360buyimg.com/n7/jfs/t1/97778/19/244/224464/5da9e1caE993b0c0c/63f8a14d1e060370.jpg','399.00','299.00',6,99),(5,'篮球鞋',40,'男生篮球鞋','https://img11.360buyimg.com/n7/jfs/t27268/280/1544175481/221242/a8859519/5be556adNdac5597d.jpg','499.00','399.00',4,99),(6,'足球鞋',40,'男生足球鞋','https://img10.360buyimg.com/n7/jfs/t1/51938/33/13255/401222/5da01a8dEf0ddb106/41f9d4fe362b6b5e.jpg','399.00','299.00',3,99),(7,'女生跑步鞋',37,'女生跑步鞋','https://img10.360buyimg.com/n7/jfs/t1/47744/34/1168/135611/5cef421aE9a51decb/b2caa62b624cf159.jpg','399.00','299.00',1,98),(8,'小白鞋',37,'女生跑步鞋','https://img13.360buyimg.com/n7/jfs/t29017/355/10857862/452203/5774786c/5be542e5Nc9109919.jpg','199.00','159.00',5,99),(9,'女生复古鞋',37,'女生复古鞋','https://img14.360buyimg.com/n7/jfs/t1/42146/12/5416/143839/5cef4644E130bf66a/7ebd603f1f7f2d15.jpg','299.00','239.00',6,99),(10,'女生拖鞋',37,'女生拖鞋','https://img14.360buyimg.com/n7/jfs/t16741/228/755558157/130865/cc3330e0/5aa0ac84N925bcfa2.jpg','99.00','79.00',5,99),(11,'女生户外鞋',37,'女生户外鞋','https://img11.360buyimg.com/n7/jfs/t29524/301/1540052235/267951/f768beaa/5ce3c57bN7fb90289.jpg','399.00','299.00',5,98);

/*Table structure for table `outbound` */

DROP TABLE IF EXISTS `outbound`;

CREATE TABLE `outbound` (
  `obId` int(11) NOT NULL AUTO_INCREMENT,
  `obTime` datetime NOT NULL,
  `soId` int(11) NOT NULL,
  `odNumber` int(11) NOT NULL,
  `marId` int(11) DEFAULT NULL,
  `itId` int(11) DEFAULT NULL,
  PRIMARY KEY (`obId`),
  KEY `soId` (`soId`),
  KEY `marId` (`marId`),
  KEY `itId` (`itId`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

/*Data for the table `outbound` */

insert  into `outbound`(`obId`,`obTime`,`soId`,`odNumber`,`marId`,`itId`) values (1,'2019-10-13 14:32:00',1,1,1,1),(2,'2019-10-13 13:58:54',2,1,2,2),(3,'2019-10-13 14:32:00',3,1,3,3),(4,'2019-10-13 13:58:54',4,1,4,4),(5,'2019-10-13 14:32:00',5,1,1,1),(6,'2019-10-14 13:58:54',6,1,2,2),(7,'2019-10-14 14:32:00',7,1,3,3),(8,'2019-10-14 13:58:54',8,1,4,4),(9,'2019-10-14 14:32:00',9,1,5,5),(10,'2019-10-14 13:58:54',10,1,1,1),(11,'2019-10-27 11:55:12',24,1,2,2),(12,'2019-10-27 11:59:50',31,2,1,2),(13,'2019-10-27 13:55:24',32,2,2,2),(14,'2019-10-27 13:58:54',33,2,2,2),(15,'2019-10-27 13:58:54',34,2,2,2),(16,'2019-10-27 14:03:45',35,23,2,1),(17,'2019-10-27 14:32:00',36,1,1,1),(18,'2019-10-27 14:32:00',37,1,1,1),(19,'2019-10-27 14:32:00',38,1,1,1),(20,'2019-10-27 14:32:00',39,1,1,1),(21,'2019-10-27 14:32:00',40,1,1,1),(22,'2019-10-27 14:39:55',41,1,1,1),(23,'2019-10-27 14:39:55',42,1,1,1),(24,'2019-10-27 14:39:55',43,1,1,1),(25,'2019-10-27 14:39:55',44,1,1,1),(26,'2019-10-27 14:39:55',45,1,1,1),(27,'2019-10-27 14:39:55',46,1,1,1),(28,'2019-10-27 14:39:55',47,1,1,1),(29,'2019-10-27 14:39:55',48,1,1,1),(30,'2019-10-27 14:39:55',49,1,1,1),(31,'2019-10-27 14:39:55',50,1,1,1),(32,'2019-10-27 14:39:55',51,1,1,1),(33,'2019-10-27 14:39:55',52,1,1,1),(34,'2019-10-27 14:39:55',53,1,1,1),(37,'2019-10-27 14:39:55',56,1,1,1),(38,'2019-10-27 14:39:55',57,1,1,1),(39,'2019-10-27 14:39:55',58,1,1,1),(40,'2019-10-27 16:30:22',59,1,1,1),(44,'2019-10-29 16:28:59',66,1,0,NULL),(45,'2019-10-29 16:31:34',67,1,NULL,NULL),(46,'2019-10-29 16:37:50',60,1,NULL,NULL),(47,'2019-10-29 16:40:28',60,1,NULL,NULL),(48,'2019-10-14 10:02:21',2,3,NULL,NULL),(49,'2019-10-29 16:47:37',60,1,NULL,NULL),(50,'2019-10-29 16:51:09',60,1,NULL,NULL),(51,'2019-10-29 16:55:38',60,1,NULL,NULL),(52,'2019-10-29 16:58:25',60,1,NULL,NULL),(53,'2019-10-29 17:04:07',60,1,NULL,NULL),(54,'2019-10-29 17:09:08',60,1,NULL,NULL),(55,'2019-10-29 17:10:40',60,1,NULL,NULL),(56,'2019-10-29 17:12:39',60,1,NULL,NULL),(57,'2019-10-29 17:21:04',60,1,NULL,NULL),(58,'2019-10-14 10:02:21',112,3,NULL,NULL),(59,'2019-10-29 17:32:39',60,1,NULL,NULL),(60,'2019-10-29 17:33:27',60,1,NULL,NULL),(61,'2019-10-29 17:37:00',60,1,NULL,NULL),(62,'2019-10-29 18:05:17',60,1,NULL,NULL),(63,'2019-10-29 18:23:26',60,1,NULL,NULL),(64,'2019-10-29 19:13:52',60,1,NULL,NULL),(65,'2019-10-29 19:52:07',60,1,NULL,NULL);

/*Table structure for table `proin` */

DROP TABLE IF EXISTS `proin`;

CREATE TABLE `proin` (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `pTime` datetime NOT NULL,
  `poId` int(11) NOT NULL,
  `pNumber` int(11) NOT NULL,
  `marId` int(11) NOT NULL,
  `itId` int(11) NOT NULL,
  PRIMARY KEY (`pId`),
  KEY `poId` (`poId`),
  KEY `marId` (`marId`),
  KEY `itId` (`itId`),
  CONSTRAINT `proin_ibfk_1` FOREIGN KEY (`poId`) REFERENCES `purchaseorder` (`poId`),
  CONSTRAINT `proin_ibfk_2` FOREIGN KEY (`marId`) REFERENCES `marque` (`marId`),
  CONSTRAINT `proin_ibfk_3` FOREIGN KEY (`itId`) REFERENCES `inventory` (`itId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `proin` */

insert  into `proin`(`pId`,`pTime`,`poId`,`pNumber`,`marId`,`itId`) values (1,'2019-10-13 16:27:12',1,1,1,1),(2,'2019-10-13 16:27:12',2,1,2,2),(3,'2019-10-13 16:27:12',3,1,3,3),(4,'2019-10-13 16:27:12',4,1,4,4),(5,'2019-10-13 16:27:12',5,1,1,1),(6,'2019-10-14 16:27:12',6,1,2,2),(7,'2019-10-14 16:27:12',7,1,3,3),(8,'2019-10-14 16:27:12',8,1,4,4),(9,'2019-10-14 16:27:12',9,1,5,5),(10,'2019-10-14 16:27:12',10,1,1,1),(13,'2019-10-23 16:27:12',13,50,9,4),(14,'2019-10-25 00:00:00',14,2,1,2),(15,'2019-10-16 15:50:55',17,2,2,2),(16,'2019-10-27 16:04:17',20,1,1,1),(17,'2019-10-27 16:04:17',21,1,1,1),(18,'2019-10-27 16:11:27',22,23,3,1),(19,'2019-10-27 16:17:59',23,3,3,3),(20,'2019-10-27 16:27:12',24,1,1,1),(21,'2019-10-27 16:27:12',25,1,1,1),(22,'2019-10-27 16:28:50',26,2,1,1),(23,'2019-10-27 17:04:02',27,1,1,1),(24,'2019-10-29 19:09:47',31,10,1,1),(25,'2019-10-29 19:10:20',32,100,1,1),(26,'2019-10-29 19:17:14',33,100,1,1);

/*Table structure for table `purchaseorder` */

DROP TABLE IF EXISTS `purchaseorder`;

CREATE TABLE `purchaseorder` (
  `poId` int(11) NOT NULL AUTO_INCREMENT,
  `marId` int(11) NOT NULL,
  `poName` varchar(20) NOT NULL,
  `poTime` datetime NOT NULL,
  `spId` int(11) NOT NULL,
  `poCounts` int(11) NOT NULL,
  `poPrice` decimal(8,2) NOT NULL,
  PRIMARY KEY (`poId`),
  KEY `marId` (`marId`),
  KEY `spId` (`spId`),
  CONSTRAINT `purchaseorder_ibfk_1` FOREIGN KEY (`marId`) REFERENCES `marque` (`marId`),
  CONSTRAINT `purchaseorder_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `supplier` (`spId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `purchaseorder` */

insert  into `purchaseorder`(`poId`,`marId`,`poName`,`poTime`,`spId`,`poCounts`,`poPrice`) values (1,1,'罗煜霖','2019-10-14 17:04:57',1,199,'100.00'),(2,2,'罗煜霖','2019-10-14 17:04:57',1,199,'100.00'),(3,3,'罗煜霖','2019-10-14 17:04:57',1,199,'100.00'),(4,4,'罗煜霖','2019-10-14 17:04:57',1,199,'100.00'),(5,5,'罗煜霖','2019-10-14 17:04:57',1,199,'100.00'),(6,1,'罗煜霖','2019-10-14 17:04:57',1,199,'100.00'),(7,2,'罗煜霖','2019-10-14 17:04:57',1,199,'100.00'),(8,3,'罗煜霖','2019-10-14 17:04:57',1,199,'100.00'),(9,4,'罗煜霖','2019-10-14 17:04:57',1,199,'100.00'),(10,5,'罗煜霖','2019-10-14 17:04:57',1,199,'100.00'),(13,9,'罗煜霖','2019-10-23 17:04:57',3,50,'780.00'),(14,1,'罗煜霖','2019-10-25 17:04:57',2,2,'2.00'),(15,1,'罗煜霖','2019-10-29 17:04:57',1,1,'1.00'),(16,2,'罗煜霖','2019-10-30 17:07:03',2,2,'2.00'),(17,2,'罗煜霖','2019-10-16 15:50:55',2,2,'2.00'),(20,1,'罗煜霖','2019-10-27 16:04:17',1,1,'1.00'),(21,1,'罗煜霖','2019-10-27 16:04:17',1,1,'1.00'),(22,3,'罗煜霖','2019-10-27 16:11:27',1,23,'23.00'),(23,3,'罗煜霖','2019-10-27 16:17:59',3,3,'3.00'),(24,1,'罗煜霖','2019-10-27 16:27:12',1,1,'122.00'),(25,1,'罗煜霖','2019-10-27 16:27:12',1,1,'122.00'),(26,1,'罗煜霖','2019-10-27 16:28:50',1,2,'1.00'),(27,1,'罗煜霖','2019-10-27 17:04:02',1,1,'1.00'),(28,1,'李卫','2019-10-29 00:00:00',1,10,'1.00'),(29,1,'李卫','2019-10-29 00:00:00',1,100,'222.00'),(30,1,'李卫','2019-11-04 00:00:00',1,11,'111.00'),(31,1,'李卫','2019-10-29 19:09:47',1,10,'111.00'),(32,1,'李卫','2019-10-29 19:10:20',1,100,'999.00'),(33,1,'李卫','2019-10-29 19:17:14',1,100,'999.00');

/*Table structure for table `salesorder` */

DROP TABLE IF EXISTS `salesorder`;

CREATE TABLE `salesorder` (
  `soId` int(11) NOT NULL AUTO_INCREMENT,
  `soTime` datetime NOT NULL,
  `usId` int(11) NOT NULL,
  `marId` int(11) DEFAULT NULL,
  `counts` int(11) NOT NULL,
  `subtotal` decimal(8,2) NOT NULL,
  `spId` int(11) DEFAULT NULL,
  PRIMARY KEY (`soId`),
  KEY `usId` (`usId`),
  KEY `spId` (`spId`),
  CONSTRAINT `salesorder_ibfk_1` FOREIGN KEY (`usId`) REFERENCES `usershoe` (`usId`),
  CONSTRAINT `salesorder_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `shopping` (`spId`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

/*Data for the table `salesorder` */

insert  into `salesorder`(`soId`,`soTime`,`usId`,`marId`,`counts`,`subtotal`,`spId`) values (1,'2019-10-14 10:02:21',1,1,1,'199.00',1),(2,'2019-10-14 10:02:21',1,1,1,'199.00',1),(3,'2019-10-14 10:02:21',1,1,1,'199.00',1),(4,'2019-10-14 10:02:21',1,1,1,'199.00',4),(5,'2019-10-14 10:02:21',1,1,1,'199.00',2),(6,'2019-10-14 10:02:21',1,1,1,'199.00',1),(7,'2019-10-14 10:02:21',1,1,1,'199.00',1),(8,'2019-10-14 10:02:21',1,1,1,'199.00',1),(9,'2019-10-14 10:02:21',1,1,1,'199.00',1),(10,'2019-10-14 10:02:21',1,1,1,'199.00',1),(11,'2019-10-24 14:42:39',40,NULL,1,'399.00',NULL),(12,'2019-10-24 14:45:32',40,NULL,1,'399.00',NULL),(13,'2019-10-24 14:57:10',40,NULL,1,'399.00',NULL),(14,'2019-10-24 15:02:41',40,NULL,1,'399.00',NULL),(15,'2019-10-24 15:05:04',40,NULL,1,'199.00',NULL),(16,'2019-10-24 15:11:38',40,NULL,1,'99.00',NULL),(17,'2019-10-24 15:12:21',40,NULL,1,'299.00',NULL),(18,'2019-10-24 15:26:41',40,NULL,1,'399.00',NULL),(19,'2019-10-24 15:30:13',40,NULL,1,'399.00',NULL),(20,'2019-10-24 16:29:35',42,NULL,1,'399.00',NULL),(21,'2019-10-25 10:02:21',40,NULL,1,'399.00',NULL),(22,'2019-10-25 11:33:20',40,1,1,'296.00',1),(23,'2019-10-27 11:34:47',1,1,1,'298.00',1),(24,'2019-10-27 11:55:12',1,2,1,'344.00',2),(31,'2019-10-27 11:59:50',2,1,2,'322.00',2),(32,'2019-10-27 13:55:24',20,2,2,'500.00',3),(33,'2019-10-27 13:58:54',30,2,2,'500.00',2),(34,'2019-10-27 13:58:54',30,2,2,'500.00',2),(35,'2019-10-27 14:03:45',34,2,23,'234.00',3),(36,'2019-10-27 14:32:00',1,1,1,'1.00',1),(37,'2019-10-27 14:32:00',1,1,1,'1.00',1),(38,'2019-10-27 14:32:00',1,1,1,'1.00',1),(39,'2019-10-27 14:32:00',1,1,1,'1.00',1),(40,'2019-10-27 14:32:00',1,1,1,'1.00',1),(41,'2019-10-27 14:39:55',1,1,1,'1.00',1),(42,'2019-10-27 14:39:55',1,1,1,'1.00',1),(43,'2019-10-27 14:39:55',1,1,1,'1.00',1),(44,'2019-10-27 14:39:55',1,1,1,'1.00',1),(45,'2019-10-27 14:39:55',1,1,1,'1.00',1),(46,'2019-10-27 14:39:55',1,1,1,'1.00',1),(47,'2019-10-27 14:39:55',1,1,1,'1.00',1),(48,'2019-10-27 14:39:55',1,1,1,'1.00',1),(49,'2019-10-27 14:39:55',1,1,1,'1.00',1),(50,'2019-10-27 14:39:55',1,1,1,'1.00',1),(51,'2019-10-27 14:39:55',1,1,1,'1.00',1),(52,'2019-10-27 14:39:55',1,1,1,'1.00',1),(53,'2019-10-27 14:39:55',1,1,1,'1.00',1),(54,'2019-10-27 14:39:55',1,1,1,'1.00',1),(55,'2019-10-27 14:39:55',1,1,1,'1.00',1),(56,'2019-10-27 14:39:55',1,1,1,'1.00',1),(57,'2019-10-27 14:39:55',1,1,1,'1.00',1),(58,'2019-10-27 14:39:55',1,1,1,'1.00',1),(59,'2019-10-27 16:30:22',1,1,1,'122.00',1),(60,'2019-10-29 14:11:56',44,NULL,1,'399.00',NULL),(61,'2019-10-29 15:10:58',44,NULL,1,'399.00',NULL),(62,'2019-10-29 15:46:19',44,NULL,1,'399.00',NULL),(63,'2019-10-29 15:52:53',44,NULL,1,'299.00',NULL),(64,'2019-10-29 15:54:48',44,NULL,1,'399.00',NULL),(65,'2019-10-29 16:26:01',44,NULL,1,'299.00',NULL),(66,'2019-10-29 16:28:59',44,NULL,1,'399.00',NULL),(67,'2019-10-29 16:31:34',44,NULL,1,'399.00',NULL),(68,'2019-10-29 16:37:50',44,NULL,1,'399.00',NULL),(69,'2019-10-29 16:39:23',44,NULL,1,'99.00',NULL),(70,'2019-10-29 16:47:19',44,NULL,1,'299.00',NULL),(71,'2019-10-29 16:50:50',44,NULL,1,'399.00',NULL),(72,'2019-10-29 16:55:32',44,NULL,1,'299.00',NULL),(73,'2019-10-29 16:58:17',44,NULL,1,'399.00',NULL),(74,'2019-10-29 17:03:52',44,NULL,1,'199.00',NULL),(75,'2019-10-29 17:09:03',44,NULL,1,'499.00',NULL),(76,'2019-10-29 17:10:37',44,NULL,1,'399.00',NULL),(77,'2019-10-29 17:12:23',44,NULL,1,'199.00',NULL),(78,'2019-10-29 17:21:04',44,NULL,1,'399.00',NULL),(79,'2019-10-29 17:32:38',44,NULL,1,'399.00',NULL),(80,'2019-10-29 17:33:27',44,NULL,1,'399.00',NULL),(81,'2019-10-29 17:36:59',44,NULL,1,'299.00',NULL),(82,'2019-10-29 18:05:17',44,NULL,1,'399.00',NULL),(83,'2019-10-29 18:23:26',44,NULL,1,'399.00',NULL),(84,'2019-10-29 19:13:50',44,NULL,1,'299.00',NULL),(85,'2019-10-29 19:52:07',44,NULL,1,'299.00',NULL);

/*Table structure for table `shopping` */

DROP TABLE IF EXISTS `shopping`;

CREATE TABLE `shopping` (
  `spId` int(11) NOT NULL AUTO_INCREMENT,
  `marId` int(11) NOT NULL,
  `spNum` int(11) NOT NULL,
  `spCount` decimal(8,2) NOT NULL,
  PRIMARY KEY (`spId`),
  KEY `marId` (`marId`),
  CONSTRAINT `shopping_ibfk_1` FOREIGN KEY (`marId`) REFERENCES `marque` (`marId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `shopping` */

insert  into `shopping`(`spId`,`marId`,`spNum`,`spCount`) values (1,1,1,'399.00'),(2,2,1,'399.00'),(3,3,1,'399.00'),(4,4,1,'399.00'),(5,5,1,'399.00'),(6,6,1,'399.00'),(7,7,1,'399.00'),(8,8,1,'399.00');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `spId` int(11) NOT NULL AUTO_INCREMENT,
  `spName` varchar(20) NOT NULL,
  `spPhone` varchar(11) NOT NULL,
  `spAddress` varchar(40) NOT NULL,
  PRIMARY KEY (`spId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `supplier` */

insert  into `supplier`(`spId`,`spName`,`spPhone`,`spAddress`) values (1,'跑鞋供应商','13877889900','长沙市'),(2,'运动鞋供应商','13877889900','长沙市'),(3,'小白鞋供应商','13877889900','长沙市'),(4,'拖鞋供应商','13877889900','长沙市'),(5,'凉鞋供应商','13877889900','长沙市'),(6,'老爹鞋供应商','13877889900','长沙市'),(7,'足球鞋供应商','13877889900','长沙市'),(8,'篮球鞋供应商','13877889900','长沙市'),(9,'帆布鞋供应商','13877889900','长沙市'),(10,'复古鞋供应商','13877889900','长沙市');

/*Table structure for table `usershoe` */

DROP TABLE IF EXISTS `usershoe`;

CREATE TABLE `usershoe` (
  `usId` int(11) NOT NULL AUTO_INCREMENT,
  `usName` varchar(50) NOT NULL,
  `usPwd` varchar(130) NOT NULL,
  `usSex` varchar(6) NOT NULL,
  `usEmail` varchar(25) NOT NULL,
  `usAddress` varchar(30) NOT NULL,
  `usPhone` varchar(11) NOT NULL,
  `usPostal` varchar(6) NOT NULL,
  PRIMARY KEY (`usId`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Data for the table `usershoe` */

insert  into `usershoe`(`usId`,`usName`,`usPwd`,`usSex`,`usEmail`,`usAddress`,`usPhone`,`usPostal`) values (1,'罗煜霖','123456','男','3123327042@qq.com','长沙市雨花区井湾子街道三湘小区11楼','13566667788','410000'),(2,'张大帅','123456','男','2312327042@qq.com','长沙市雨花区井湾子街道三湘小区23楼','13566667788','410000'),(3,'赵敏','123456','女','1223327042@qq.com','武汉市洪山区文荟街三鸿家园6栋','13566667788','430000'),(4,'梅超风','123456','女','2223227042@qq.com','武汉市洪山区文荟街三鸿家园南区7号楼','13566667788','430000'),(5,'郭靖','123456','男','1123227042@qq.com','武汉市洪山区文荟街三鸿家园南区5号楼','13566667788','430000'),(6,'陆小凤','123456','男','1232227042@qq.com','开封市鼓楼区内环南路锦绣皇城8号楼','13566667788','475000'),(7,'方世玉','123456','男','2133327042@qq.com','广州市白云区三元里兴泰路华兴苑6栋12楼','13566667788','510000'),(8,'洪熙官','123456','男','1233127042@qq.com','广州市白云区三元里兴泰路华兴苑4栋8楼','13566667788','510000'),(9,'雷老虎','123456','男','2331227042@qq.com','广州市白云区三元里兴泰路华兴苑8栋6楼','13566667788','510000'),(10,'黄飞鸿','123456','男','5522127042@qq.com','广州市白云区三元里兴泰路华兴苑3栋9楼','13566667788','410000'),(11,'张三丰','123456','男','3243427042@qq.com','北京市西城区南半壁胡同丰汇园小区7号楼','12344556677','100000'),(15,'曾默涵','123456','女','1332527042@qq.com','北京市西城区南半壁胡同丰汇园小区9号楼','13566667788','100000'),(16,'SDK','123456','男','4322527042@qq.com','苏州市姑苏区江乾路怡景花园4栋','13533217788','215000'),(17,'SSD','123456','男','3423527042@qq.com','苏州市姑苏区江乾路怡景花园9栋','13523127788','215000'),(18,'萨达','123456','男','1332527042@qq.com','苏州市姑苏区江乾路怡景花园2栋','13534527788','215000'),(19,'啥达','123456','男','4323527042@qq.com','苏州市姑苏区江乾路怡景花园6栋','13523127788','215000'),(20,'石中意','123456','男','3422527042@qq.com','杭州市江干区新塘路钱江七苑2号楼','13523127788','310000'),(21,'邓威','123456','男','2234527042@qq.com','杭州江干区新塘路钱江七苑5栋','13511237788','310000'),(22,'张文亮','123456','男','3246527042@qq.com','杭州江干区新塘路钱江七苑8栋','13523127788','310000'),(23,'田亮','123456','男','3213527042@qq.com','杭州江干区新塘路钱江七苑13栋','13532127788','310000'),(24,'李君桥','123456','男','3321527042@qq.com','杭州江干区新塘路钱江七苑15号楼','13532117788','310000'),(25,'哔哔','123456','男','2211527042@qq.com','上海市黄埔区盛泽小区金陵东路246弄13号','13533157788','200000'),(26,'汤洪','123456','男','3225527042@qq.com','上海市黄埔区盛泽小区金陵东路246弄12号','13522127788','200000'),(27,'王翌','123456','男','2317527042@qq.com','上海市黄埔区盛泽小区金陵东路246弄16号','13511227788','200000'),(28,'陈金','123456','男','1165527042@qq.com','上海市黄埔区盛泽小区金陵东路246弄1号','13523117788','200000'),(29,'黄世文','123456','男','3321527042@qq.com','上海市黄埔区盛泽小区盛泽路80弄5号','13533117788','200000'),(30,'何希龙','123456','男','1233527042@qq.com','深圳市福田区金田路皇岗村49号楼','13533127788','518000'),(31,'张彩云','123456','男','3231527042@qq.com','深圳市福田区金田路皇岗村2号楼','13533227788','518000'),(32,'杜佳威','123456','男','22312527042@qq.com','深圳市福田区金田路皇岗村200号楼','13531233212','518000'),(33,'唐龙','123456','男','3123527042@qq.com','深圳市福田区金田路皇岗村187号楼','13532113333','518000'),(34,'李安','123456','男','3213527042@qq.com','深圳市福田区金田路皇岗村88号楼','13532112222','518000'),(35,'向思雨','123456','女','1211527042@qq.com','深圳市福田区金田路皇岗村64号楼','13532111122','518000'),(36,'向雨红','123456','女','2313527042@qq.com','深圳市福田区金田路皇岗村76号楼','13532111111','518000'),(37,'刘瑞','123456','男','2311527042@qq.com','深圳市福田区金田路皇岗村84号楼','13532112121','518000'),(38,'刘荣','123456','女','4123527042@qq.com','厦门市集美区塘埔路四季芳园41号楼','13532113328','361000'),(39,'王群','123456','女','3212527042@qq.com','厦门市集美区塘埔路四季芳园2号楼','13532113211','361000'),(40,'王庭','123456','女','2311527042@qq.com','厦门市集美区塘埔路四季芳园29号楼','13532113123','361000'),(41,'卫大帅','123456','男','2311527042@qq.com','厦门市集美区塘埔路四季芳园31号楼','13532112322','361000'),(43,'李小卫','123456','男','3123527042@qq.com','长沙市雨花区井湾子街道三湘小区17楼','13532117788','410000'),(44,'qqq','e10adc3949ba59abbe56e057f20f883e','男','123','123','12332323232','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
