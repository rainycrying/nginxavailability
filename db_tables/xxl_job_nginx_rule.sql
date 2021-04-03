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

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xxl_job_nginx_rule
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_nginx_rule`;
CREATE TABLE `xxl_job_nginx_rule` (
  `Rlue_id` int(11) NOT NULL,
  `Rlue_name` varchar(255) DEFAULT NULL,
  `Rlue_user` varchar(255) DEFAULT NULL,
  `Rlue_group` varchar(255) DEFAULT NULL,
  `Rlue_es_index` varchar(255) DEFAULT NULL,
  `Rlue_domain_name` varchar(255) DEFAULT NULL,
  `Rlue_not_domain_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Rlue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_nginx_rule
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_nginx_rule` VALUES (1, '运维默认策略', 'zhangzh', 'zhangzh@rainycrying.com', 'ngpool', '1,2,3,4,5,6', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
