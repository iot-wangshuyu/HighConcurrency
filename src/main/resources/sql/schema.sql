-- ���ݿ��ʼ���ű�
CREATE DATABASE seckill;

USE seckill;


CREATE TABLE `seckill` (
  `seckill_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '��Ʒ���id',
  `name` VARCHAR(120) NOT NULL COMMENT '��Ʒ����',
  `number` INT(11) NOT NULL COMMENT '�������',
  `start_time` TIMESTAMP NOT NULL COMMENT '��ɱ����ʱ��',
  `end_time` TIMESTAMP NOT NULL COMMENT '��ɱ����ʱ��',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '���һ�θ���ʱ��',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='��ɱ����';


-- ʼ������
INSERT INTO seckill(NAME,number,start_time,end_time)VALUE 
('1000Ԫ��ɱiPhone7',100,'2017-10-01 00:00:00','2017-10-02 00:00:00'),
('500Ԫ��ɱiPad2',200,'2017-10-01 00:00:00','2017-10-02 00:00:00'),
('300Ԫ��ɱС��5',300,'2017-10-01 00:00:00','2017-10-02 00:00:00'),
('200Ԫ��ɱ����note',400,'2017-10-01 00:00:00','2017-10-02 00:00:00');


CREATE TABLE `success_killed` (
  `seckill_id` bit(1) NOT NULL,
  `user_phone` bit(1) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '-1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`seckill_id`,`user_phone`),
  KEY `idx_start_time` (`create_time`),
  KEY `idx_end_time` (`update_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɱ�ɹ���ϸ��';

-- �������ݿ����̨
 mysql -uroot -p123456