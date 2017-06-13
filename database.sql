CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `account` varchar(64) DEFAULT NULL COMMENT '用户账号',
  `username` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(64) DEFAULT NULL COMMENT '登陆密码',
  `sex` char(2) DEFAULT NULL COMMENT '性别0女1男',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `modified_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO `lhb`.`tbl_user` (`account`, `username`, `password`, `sex`, `age`, `modified_time`) VALUES ('admin', 'admin', '123456', '1', '10',now());
INSERT INTO `lhb`.`tbl_user` (`account`, `username`, `password`, `sex`, `age`, `modified_time`) VALUES ('lhb', '梁怀宾', '123456', '1', '12',now());
INSERT INTO `lhb`.`tbl_user` (`account`, `username`, `password`, `sex`, `age`, `modified_time`) VALUES ('test1', '测试1', '123456', '1', '20',now());
INSERT INTO `lhb`.`tbl_user` (`account`, `username`, `password`, `sex`, `age`, `modified_time`) VALUES ('test2', '测试2', '123456', '1', '10',now());
INSERT INTO `lhb`.`tbl_user` (`account`, `username`, `password`, `sex`, `age`, `modified_time`) VALUES ('test3', '测试3', '123456', '0', '10',now());
INSERT INTO `lhb`.`tbl_user` (`account`, `username`, `password`, `sex`, `age`, `modified_time`) VALUES ('test4', '测试4', '123456', '0', '50',now());
INSERT INTO `lhb`.`tbl_user` (`account`, `username`, `password`, `sex`, `age`, `modified_time`) VALUES ('test5', '测试5', '123456', '0', '10',now());