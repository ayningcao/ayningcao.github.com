/*
Navicat MySQL Data Transfer

Source Server         : sejian
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : sejian

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-04-16 00:34:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `username` varchar(200) DEFAULT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthdate` varchar(40) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `platform` varchar(20) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `first_use_date` datetime DEFAULT NULL,
  `latest_use_date` datetime DEFAULT NULL,
  `first_use_geo` varchar(200) DEFAULT NULL,
  `is_registered` int(11) DEFAULT NULL,
  `is_freeze` int(11) NOT NULL DEFAULT '0' COMMENT '0 for valid user, others for invalid user flag, which mean frozen',
  `b_field` varchar(200) DEFAULT NULL,
  `b_field2` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pwd_idx` (`id`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
