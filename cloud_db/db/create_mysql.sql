SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS SYS_LOG;




/* Create Tables */

-- 日志表 : 日志表
CREATE TABLE SYS_LOG
(
	-- 编号
	`ID` bigint NOT NULL AUTO_INCREMENT COMMENT '编号 : 编号',
	`TYPE` char(1) DEFAULT '' COMMENT '日志类型（1：支付成功同步Hy；2：退款成功同步Hy）',
	`TITLE` varchar(500) COMMENT '日志标题（请求第三方的URL）',
	-- 创建时间
	`CREATE_DATE` timestamp DEFAULT NOW() COMMENT '创建时间 : 创建时间',
	-- 操作提交的数据
	`PARAMS` text COMMENT '操作提交的数据 : 操作提交的数据',
	-- 异常信息
	`EXCEPTION` text COMMENT '异常信息 : 异常信息',
	`STATE` varchar(2) DEFAULT '2' COMMENT '状态(1:成功 2:失败)',
	`TOTAL_TIMES` varchar(5) COMMENT '执行总次数',
	`CURRENT_TIMES` varchar(5) COMMENT '当前次数',
	PRIMARY KEY (ID)
) COMMENT = '日志表 : 日志表';



