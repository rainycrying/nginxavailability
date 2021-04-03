/*
Navicat MySQL Data Transfer

Source Server         : wk_op_xxl_job
Source Server Version : 50728
Source Host           : 10.4.47.33:3306
Source Database       : wk_op_xxl_job

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2021-03-23 16:28:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xxl_job_jt_nginx_availability
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_jt_nginx_availability`;
CREATE TABLE `xxl_job_jt_nginx_availability` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Es_index` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Domain_Name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Reliability` float(10,6) DEFAULT NULL,
  `Total_Throughput` int(255) DEFAULT '0',
  `Total_Code_500` int(255) DEFAULT '0',
  `Total_Code_502` int(255) DEFAULT '0',
  `Total_Code_503` int(255) DEFAULT '0',
  `Total_Code_504` int(255) DEFAULT '0',
  `Total_Code_400` int(255) DEFAULT '0',
  `Total_Code_403` int(255) DEFAULT '0',
  `Total_Code_404` int(255) DEFAULT '0',
  `Total_Code_405` int(255) DEFAULT '0',
  `Total_Code_408` int(255) DEFAULT '0',
  `Total_Code_301` int(255) DEFAULT '0',
  `Total_Code_302` int(255) DEFAULT '0',
  `Total_Code_304` int(255) DEFAULT '0',
  `Total_Code_200` int(255) DEFAULT '0',
  `Total_Code_204` int(255) DEFAULT '0',
  `Total_Code_206` int(255) DEFAULT '0',
  `From_Hours` datetime DEFAULT NULL,
  `From_Daytime` date DEFAULT NULL,
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10771 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of xxl_job_jt_nginx_availability
-- ----------------------------
INSERT INTO `xxl_job_jt_nginx_availability` VALUES ('224', 'ngpool', 'vbs.rainycrying.com', '99.999702', '752306333', '0', '87', '0', '0', '54', '65', '2029', '0', '0', '0', '3288167', '0', '749015931', '0', '0', null, '2021-03-09', '2021-03-10 18:47:22', '2021-03-10 18:47:22');
INSERT INTO `xxl_job_jt_nginx_availability` VALUES ('225', 'ngpool', 'vbsu.internal.rainycrying.com', '99.998978', '148405416', '0', '1322', '0', '197', '0', '0', '0', '0', '0', '0', '0', '0', '148403897', '0', '0', null, '2021-03-09', '2021-03-10 18:47:22', '2021-03-10 18:47:22');
INSERT INTO `xxl_job_jt_nginx_availability` VALUES ('226', 'ngpool', 'smallvideo-log.rainycrying.com', '99.998573', '104739914', '0', '407', '0', '0', '35', '0', '1030', '0', '23', '0', '0', '0', '104738419', '0', '0', null, '2021-03-09', '2021-03-10 18:47:22', '2021-03-10 18:47:22');
INSERT INTO `xxl_job_jt_nginx_availability` VALUES ('227', 'ngpool', 'vc.rainycrying.com', '99.988571', '9110367', '0', '0', '0', '0', '29', '66', '946', '0', '0', '0', '0', '0', '9109326', '0', '0', null, '2021-03-09', '2021-03-10 18:47:22', '2021-03-10 18:47:22');
INSERT INTO `xxl_job_jt_nginx_availability` VALUES ('228', 'ngpool', 'vbsu.rainycrying.com', '99.936874', '1598499', '0', '10', '0', '0', '31', '72', '896', '0', '0', '0', '0', '0', '1597490', '0', '0', null, '2021-03-09', '2021-03-10 18:47:22', '2021-03-10 18:47:22');
INSERT INTO `xxl_job_jt_nginx_availability` VALUES ('229', 'ngpool', 'smallvideo-log.rainycrying.com', '99.790009', '565747', '11', '1', '0', '0', '33', '0', '1143', '0', '0', '0', '0', '0', '564559', '0', '0', null, '2021-03-09', '2021-03-10 18:47:22', '2021-03-10 18:47:22');
INSERT INTO `xxl_job_jt_nginx_availability` VALUES ('10769', 'ngpool', 'dcmdaa.rainycrying.com', '0.000000', '1', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2021-03-23 14:00:00', null, '2021-03-23 16:00:02', '2021-03-23 16:00:02');
INSERT INTO `xxl_job_jt_nginx_availability` VALUES ('10770', 'ngpool', 'video-push.rainycrying.com', '100.000000', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '2021-03-23 14:00:00', null, '2021-03-23 16:00:02', '2021-03-23 16:00:02');
