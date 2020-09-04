-- 初始化数据库
create database if not exists cool;

-- 创建用户表
CREATE TABLE `members`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) COMMENT = '用户表';
