/*
 Navicat Premium Data Transfer

 Source Server         : mysql22222
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : project_db

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_prj
-- ----------------------------
DROP TABLE IF EXISTS `tb_prj`;
CREATE TABLE `tb_prj`  (
  `prj_id` int(11) NOT NULL AUTO_INCREMENT,
  `prj_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `prj_cycle` int(11) NOT NULL,
  `prj_count` int(11) NOT NULL,
  `prj_manager` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`prj_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_prj
-- ----------------------------
INSERT INTO `tb_prj` VALUES (1, '张三', 12, 10, '李四');
INSERT INTO `tb_prj` VALUES (2, '张三2', 34, 10, '李四');
INSERT INTO `tb_prj` VALUES (3, '张三3', 65, 10, '李四');

SET FOREIGN_KEY_CHECKS = 1;
