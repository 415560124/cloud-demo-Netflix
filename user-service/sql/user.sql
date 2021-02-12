/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : cloud_rhy_user

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 12/02/2021 14:51:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `men_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `men_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '菜单标题',
  PRIMARY KEY (`men_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 'userList');
INSERT INTO `menu` VALUES (2, 'userShow');
INSERT INTO `menu` VALUES (3, 'adminList');
INSERT INTO `menu` VALUES (4, 'adminShow');
INSERT INTO `menu` VALUES (5, 'itemList');
INSERT INTO `menu` VALUES (6, 'itemShow');
INSERT INTO `menu` VALUES (7, 'itemDelete');
INSERT INTO `menu` VALUES (8, 'userChange');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `rol_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `rol_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '角色名',
  `rol_note` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '角色备注',
  PRIMARY KEY (`rol_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_ADMIN', '管理员');
INSERT INTO `role` VALUES (2, 'ROLE_USER', '普通用户');
INSERT INTO `role` VALUES (3, 'ROLE_TOURIST', '游客');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `rol_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色编号',
  `men_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜单编号',
  PRIMARY KEY (`rol_id`, `men_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (1, 5);
INSERT INTO `role_menu` VALUES (1, 6);
INSERT INTO `role_menu` VALUES (1, 7);
INSERT INTO `role_menu` VALUES (1, 8);
INSERT INTO `role_menu` VALUES (2, 2);
INSERT INTO `role_menu` VALUES (2, 5);
INSERT INTO `role_menu` VALUES (2, 6);
INSERT INTO `role_menu` VALUES (2, 8);
INSERT INTO `role_menu` VALUES (3, 2);
INSERT INTO `role_menu` VALUES (3, 5);
INSERT INTO `role_menu` VALUES (3, 6);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `use_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `use_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户名',
  `use_pwd` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '密码',
  `use_note` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`use_id`) USING BTREE,
  UNIQUE INDEX `user_name`(`use_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$QqZ3mQcL8VMk9p1N6wM4OuT9VvLhyTaVG3DcUk6B7f8j4eZVKX6sK', '管理员');
INSERT INTO `user` VALUES (2, 'user', '$2a$10$QqZ3mQcL8VMk9p1N6wM4OuT9VvLhyTaVG3DcUk6B7f8j4eZVKX6sK', '用户');
INSERT INTO `user` VALUES (3, 'tourist', '$2a$10$QqZ3mQcL8VMk9p1N6wM4OuT9VvLhyTaVG3DcUk6B7f8j4eZVKX6sK', '游客');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `rol_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色编号',
  `use_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户编号',
  PRIMARY KEY (`rol_id`, `use_id`) USING BTREE,
  UNIQUE INDEX `role_id`(`rol_id`, `use_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 1);
INSERT INTO `user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
