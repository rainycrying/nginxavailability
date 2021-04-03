/*
Navicat MySQL Data Transfer

Source Server         : wk_op_xxl_job
Source Server Version : 50728
Source Host           : 10.4.47.33:3306
Source Database       : wk_op_xxl_job

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2021-03-23 16:33:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xxl_job_nginx_domain
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_nginx_domain`;
CREATE TABLE `xxl_job_nginx_domain` (
  `Domain_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Domain_Name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`Domain_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=265 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of xxl_job_nginx_domain
-- ----------------------------
INSERT INTO `xxl_job_nginx_domain` VALUES ('1', 'rta.rainycrying.com');
INSERT INTO `xxl_job_nginx_domain` VALUES ('2', 'creator.rainycrying.com');
INSERT INTO `xxl_job_nginx_domain` VALUES ('3', 'dnsadmin.rainycrying.com');
INSERT INTO `xxl_job_nginx_domain` VALUES ('4', 'dnsserver.rainycrying.com');
INSERT INTO `xxl_job_nginx_domain` VALUES ('5', 'kvms.rainycrying.com');

