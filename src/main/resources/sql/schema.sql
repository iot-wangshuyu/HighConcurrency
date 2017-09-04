-- 数据库初始化脚本
CREATE DATABASE seckill;

USE seckill;


CREATE TABLE `seckill` (
  `seckill_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  `name` VARCHAR(120) NOT NULL COMMENT '商品名称',
  `number` INT(11) NOT NULL COMMENT '库存数量',
  `start_time` TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
  `end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';


-- 始化数据
INSERT INTO seckill(NAME,number,start_time,end_time)VALUE 
('1000元秒杀iPhone7',100,'2017-10-01 00:00:00','2017-10-02 00:00:00'),
('500元秒杀iPad2',200,'2017-10-01 00:00:00','2017-10-02 00:00:00'),
('300元秒杀小米5',300,'2017-10-01 00:00:00','2017-10-02 00:00:00'),
('200元秒杀红米note',400,'2017-10-01 00:00:00','2017-10-02 00:00:00');


CREATE TABLE `success_killed` (
  `seckill_id` bit(1) NOT NULL,
  `user_phone` bit(1) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '-1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`seckill_id`,`user_phone`),
  KEY `idx_start_time` (`create_time`),
  KEY `idx_end_time` (`update_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- 连接数据库控制台
 mysql -uroot -p123456
 
 -- 为什么手写DDL
 -- 记录每一次上线的DDL修改
 -- 上线V1.1
 ALTER TABLE seckill
 DROP INDEX idx_create_time,
 ADD index idx_c_s(`start_time`,`create_time`);