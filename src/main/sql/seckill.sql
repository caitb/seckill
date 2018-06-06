-- 数据库初始化脚本

-- 删除数据库seckill如果存在
DROP DATABASE IF EXISTS seckill;

-- 创建数据库
CREATE DATABASE seckill;

-- 使用数据库
use seckill;

-- 创建秒杀库存表
CREATE TABLE seckill(
seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
name varchar(120) NOT NULL COMMENT '商品名称',
number int NOT NULL COMMENT '库存数量',
start_time timestamp NOT NULL COMMENT '秒杀开启时间',
end_time timestamp NOT NULL COMMENT '秒杀结束时间',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
KEY idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- 初始化数据
INSERT INTO
  seckill (name, number, start_time, end_time)
  VALUES
  ('1000元秒杀iphone6', 100, '2018-06-06 00:00:00', '2018-06-10 23:59:59'),
  ('1000元秒杀ipad2', 100, '2018-06-07 00:00:00', '2018-06-12 23:59:59'),
  ('1000元秒杀小米4', 100, '2018-06-08 00:00:00', '2018-06-14 23:59:59'),
  ('1000元秒杀红米note', 100, '2018-06-09 00:00:00', '2018-06-15 23:59:59');

-- 秒杀成功明细表
-- 用户登录认证相关的信息
CREATE TABLE success_killed(
seckill_id bigint NOT NULL COMMENT '秒杀商品id',
user_phone bigint NOT NULL COMMENT '用户手机号',
state tinyint NOT NULL DEFAULT -1 COMMENT '状态标示:-1:无效 0:成功 1:已付款 2:已发货',
create_time timestamp NOT NULL COMMENT '创建时间',
PRIMARY KEY (seckill_id, user_phone),/*联合主键*/
KEY idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';