DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `account` varchar(64) DEFAULT NULL COMMENT '用户账号',
  `username` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(64) DEFAULT NULL COMMENT '登陆密码',
  `sex` char(2) DEFAULT NULL COMMENT '性别0女1男',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', 'admin', 'admin', '1', '10');