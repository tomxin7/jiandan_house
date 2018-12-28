/*
Navicat MySQL Data Transfer

Source Server         : tomxin
Source Server Version : 50723
Source Host           : sql.tomxin.cn:3306
Source Database       : jiandan_house

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-12-28 14:09:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '城市id',
  `city_name` varchar(10) DEFAULT NULL COMMENT '城市名称',
  `dou_ban_url` varchar(1000) DEFAULT NULL COMMENT '豆瓣链接',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` varchar(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `content` longtext,
  `add_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` varchar(32) NOT NULL COMMENT '记录id',
  `city_name` varchar(10) DEFAULT NULL COMMENT '城市名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  `key_word` varchar(100) DEFAULT NULL COMMENT '关键字',
  `open_id` varchar(50) DEFAULT NULL COMMENT '用户openId',
  `remind` varchar(100) DEFAULT NULL COMMENT '提醒地址',
  `remind_type` varchar(10) DEFAULT NULL COMMENT '提醒方式',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for remind
-- ----------------------------
DROP TABLE IF EXISTS `remind`;
CREATE TABLE `remind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `record_id` varchar(20) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=556 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `open_id` varchar(50) NOT NULL COMMENT 'openId',
  `city` varchar(10) DEFAULT NULL COMMENT '城市',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `province` varchar(10) DEFAULT NULL COMMENT '省份',
  `year` varchar(10) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`open_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
