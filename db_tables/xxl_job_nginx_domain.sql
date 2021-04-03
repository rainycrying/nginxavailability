/*
 Navicat MySQL Data Transfer

 Source Server         : AliYun
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 10.8.0.1:3306
 Source Schema         : wk_op_xxl_job

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 03/04/2021 15:27:29
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

