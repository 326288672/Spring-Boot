/*
Navicat MySQL Data Transfer

Source Server         : Hello World
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : db_person

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-09-25 21:01:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for girl
-- ----------------------------
DROP TABLE IF EXISTS `girl`;
CREATE TABLE `girl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cup_Size` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of girl
-- ----------------------------
INSERT INTO `girl` VALUES ('1', 'd', '800', '18');
INSERT INTO `girl` VALUES ('2', 'd', '800', '18');
