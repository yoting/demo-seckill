--数据库初始化脚本

--创建数据库表
use demo;
CREATE TABLE seckill(
'seckill_id' bigint not null auto_increment comment '商品id',
'name' varchar(120) not null comment '商品名称',
'number' int not null comment '剩余库存',
'start_time' timestamp not null comment '开始时间',
'end_time' timestamp not null comment '结束时间',
'create_time' timestamp not null  default current_timestamp comment '创建时间' ,
primary key (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=Innodb auto_increment=1000 default charset=utf8 comment='秒杀库存表';

--初始化数据
insert into seckill (name,number,start_time,end_time)
values('iphone7',7,'2017-04-14 16:00:00','2017-04-14 18:00:00'),('iphone8',8,'2017-04-14 16:00:00','2017-04-14 18:00:00'),('iphone9',9,'2017-04-14 16:00:00','2017-04-14 18:00:00');

create table seckill_result(
'seckill_id' bigint not null comment '商品Id',
'user_mobile' varchar(20) not null comment '用户电话',
'state' tinyint not null default 0 comment '状态，0无效，1成功，2，已经付款',
'create_time' timestamp not null comment '创建时间',
primary key (seckill_id, user_mobile),
key idx_create_time(create_time)
) engine=Innodb default charset=utf8 comment='秒杀结果表';


--连接数据库
mysql -uroot -proot
