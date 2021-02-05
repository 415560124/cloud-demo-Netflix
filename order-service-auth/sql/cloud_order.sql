/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : cloud_rhy_order

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 02/02/2021 16:24:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `ord_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `mem_id` int(11) UNSIGNED NOT NULL COMMENT '会员id',
  `mem_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员名',
  `ord_code` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编码',
  `ord_money` decimal(10, 2) UNSIGNED NOT NULL COMMENT '订单总计',
  PRIMARY KEY (`ord_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, 1, '张三', '20210202', 1.00);
INSERT INTO `order_info` VALUES (2, 1, '张三', '20210203', 2.00);

SET FOREIGN_KEY_CHECKS = 1;
