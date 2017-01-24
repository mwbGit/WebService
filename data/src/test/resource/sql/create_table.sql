/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-01-24 16:38:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('1', '北京');

-- ----------------------------
-- Table structure for `t_grade`
-- ----------------------------
DROP TABLE IF EXISTS `t_grade`;
CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `score` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_grade_user` (`user_id`) USING BTREE,
  CONSTRAINT `fk_grade_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grade
-- ----------------------------
INSERT INTO `t_grade` VALUES ('1', '数学', '99', '1');
INSERT INTO `t_grade` VALUES ('2', '语文', '1', '1');

-- ----------------------------
-- Table structure for `t_status`
-- ----------------------------
DROP TABLE IF EXISTS `t_status`;
CREATE TABLE `t_status` (
  `id` int(11) NOT NULL,
  `code` varchar(64) NOT NULL,
  `description` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_status
-- ----------------------------
INSERT INTO `t_status` VALUES ('1', 'ACTIVE', 'Active');
INSERT INTO `t_status` VALUES ('2', 'LOCKED', 'Locked');
INSERT INTO `t_status` VALUES ('3', 'SUSPENDED', 'Suspended');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `mobile` char(16) NOT NULL,
  `marital` char(1) NOT NULL,
  `status_id` int(1) NOT NULL,
  `address_id` int(1) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_status` (`status_id`),
  KEY `fk_user_address` (`address_id`),
  CONSTRAINT `fk_user_address` FOREIGN KEY (`address_id`) REFERENCES `t_address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_status` FOREIGN KEY (`status_id`) REFERENCES `t_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', '222227792031', 'N', '1', '1', '2017-01-24 11:29:36');
INSERT INTO `t_user` VALUES ('2', '李四', '76772792031', 'N', '1', '1', '2017-01-24 15:18:07');
INSERT INTO `t_user` VALUES ('3', '李四', '76772792031', 'N', '1', '1', '2017-01-24 11:29:36');
INSERT INTO `t_user` VALUES ('4', '李四', '76772792031', 'N', '1', '1', '2017-01-24 15:12:15');
INSERT INTO `t_user` VALUES ('5', '王五', '76772792031', 'N', '1', '1', '2017-01-24 15:16:38');
INSERT INTO `t_user` VALUES ('6', '张三', '77777792031', 'N', '1', '1', '2017-01-24 16:35:21');
