/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.25 : Database - hunt_admin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hunt_admin` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `hunt_admin`;

/*Table structure for table `impower` */

DROP TABLE IF EXISTS `impower`;

CREATE TABLE `impower` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_id` bigint(20) DEFAULT NULL COMMENT '授权人id',
  `to_id` bigint(20) DEFAULT NULL COMMENT '被授权人id',
  `impower_time` datetime DEFAULT NULL COMMENT '授权时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `impower` */

/*Table structure for table `power_detail` */

DROP TABLE IF EXISTS `power_detail`;

CREATE TABLE `power_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `power` int(11) DEFAULT NULL COMMENT '权限代号',
  `resource` varchar(500) DEFAULT NULL COMMENT '可以访问的url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `power_detail` */

insert  into `power_detail`(`id`,`power`,`resource`) values 
(1,1,'添加'),
(2,2,'删除'),
(3,3,'修改'),
(4,4,'查找');

/*Table structure for table `user_hunt` */

DROP TABLE IF EXISTS `user_hunt`;

CREATE TABLE `user_hunt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `job_id` varchar(100) DEFAULT NULL COMMENT '工号',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `role` varchar(50) NOT NULL COMMENT '角色',
  `organ` varchar(100) DEFAULT NULL COMMENT '组织',
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `user_hunt` */

insert  into `user_hunt`(`id`,`job_id`,`username`,`password`,`role`,`organ`,`phone`,`email`,`create_time`,`update_time`) values 
(1,'1700301235','admin','427338237BD929443EC5D48E24FD2B1A','1,2,3,4','worxfr','13800138000','admin@happymmall.com','2016-11-06 16:56:45','2017-04-04 19:27:36'),
(13,'1700301221','geely','08E9A6EA287E70E7E3F7C982BF7923AC','1,2,4','worxfr','13800138000','geely@happymmall.com','2016-11-19 22:19:25','2016-11-19 22:19:25'),
(17,'1700301625','rosen','095AC193FE2212EEC7A93E8FEFF11902','1,3,4','csdn','13800138000','rosen1@happymmall.com','2017-03-17 10:51:33','2017-04-09 23:13:26'),
(21,'1700300215','soonerbetter','DE6D76FE7C40D5A1A8F04213F2BEFBEE','1','csdn','13800138000','test06@happymmall.com','2017-04-13 21:26:22','2017-04-13 21:26:22');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;