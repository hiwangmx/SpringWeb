/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : spring_web

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2014-10-28 14:36:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zip_data
-- ----------------------------
DROP TABLE IF EXISTS `zip_data`;
CREATE TABLE `zip_data` (
  `id` varchar(218) NOT NULL,
  `state` smallint(5) default NULL,
  `memory` bigint(50) default NULL,
  `pid` varchar(10) default NULL,
  `cpu` bigint(50) default NULL,
  `name` varchar(50) default NULL,
  `extime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zip_data
-- ----------------------------
