drop database if exists system_a;
create database system_a;
use system_a;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `Cno` varchar(255) DEFAULT NULL,
  `Cname` varchar(255) DEFAULT NULL,
  `teacher` varchar(255) DEFAULT NULL,
  `Ctime` int(11) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `share` int(11) DEFAULT NULL,
  `Ctype` varchar(255) DEFAULT NULL,
  UNIQUE KEY `uniqueData` (`Cno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table `course` convert to character set utf8;

INSERT INTO `course` VALUES ('A01','C语言基础','张涛',30,4,1,'A'),('A02','计算机导论','李阳',15,3,1,'A'),('A03','软件工程导论','李阳',15,3,1,'A'),('A04','java语言基础','王航',30,5,0,'A'),('A05','计算机组织结构','韩艺',30,4,0,'A'),('A06','离散数学','高洋',20,3,1,'A'),('A07','计算系统基础','王然',25,4,0,'A'),('A08','微积分','张晓',50,5,1,'A'),('A09','软件工程与计算','柳欧',30,5,0,'A'),('A10','算法导论','王宇',20,3,1,'A'),('B10','算法导论2','王宇',20,3,1,'A'),('C10','算法导论','王宇',20,3,0,'A');

DROP TABLE IF EXISTS `student`;


CREATE TABLE `student` (
  `acc` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Sno` varchar(255) DEFAULT NULL,
  `Sname` varchar(255) DEFAULT NULL,
  `Sex` varchar(255) DEFAULT NULL,
  UNIQUE KEY `uniqueData` (`Sno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table `student` convert to character set utf8;

INSERT INTO `student` VALUES 
('201901','123456','2019-06-30 16:00:00','A01','叶轮','男'),
('201902','123456','2019-06-30 16:00:00','A02','梁初','男'),
('201903','123456','2019-06-30 16:00:00','A03','张文','男'),
('201904','123456','2019-06-30 16:00:00','A04','路时','男'),
('201905','123456','2019-06-30 16:00:00','A05','曹藏','男'),
('201906','123456','2019-06-30 16:00:00','A06','王伟','男'),
('201907','123456','2019-06-30 16:00:00','A07','江明','男'),
('201908','123456','2019-06-30 16:00:00','A08','李涛','男'),
('201909','123456','2019-06-30 16:00:00','A09','胡杰','男'),
('201910','123456','2019-06-30 16:00:00','A10','张影','男'),
('201911','123456','2019-06-30 16:00:00','A11','刘顺','男'),
('201912','123456','2019-06-30 16:00:00','A12','赵孤','男'),
('201913','123456','2019-06-30 16:00:00','A13','邹醒','男'),
('201914','123456','2019-06-30 16:00:00','A14','石宇','男'),
('201915','123456','2019-06-30 16:00:00','A15','唐成','男'),
('201916','123456','2019-06-30 16:00:00','A16','费潮','男'),
('201917','123456','2019-06-30 16:00:00','A17','杨银','男'),
('201918','123456','2019-06-30 16:00:00','A18','杨洋','男'),
('201919','123456','2019-06-30 16:00:00','A19','王浩','男'),
('201920','123456','2019-06-30 16:00:00','A20','姚秀','男'),
('201921','123456','2019-06-30 16:00:00','A21','邱波','男'),
('201922','123456','2019-06-30 16:00:00','A22','陈科','男'),
('201923','123456','2019-06-30 16:00:00','A23','黄杨','男'),
('201924','123456','2019-06-30 16:00:00','A24','白乐','男'),
('201925','123456','2019-06-30 16:00:00','A25','王易','男'),
('201926','123456','2019-06-30 16:00:00','A26','吕香','女'),
('201927','123456','2019-06-30 16:00:00','A27','张丽','女'),
('201928','123456','2019-06-30 16:00:00','A28','苏佳','女'),
('201929','123456','2019-06-30 16:00:00','A29','顾雯','女'),
('201930','123456','2019-06-30 16:00:00','A30','郭莲','女'),
('201931','123456','2019-06-30 16:00:00','A31','吴玫','女'),
('201932','123456','2019-06-30 16:00:00','A32','谢黛','女'),
('201933','123456','2019-06-30 16:00:00','A33','李蓉','女'),
('201934','123456','2019-06-30 16:00:00','A34','杨颖','女'),
('201935','123456','2019-06-30 16:00:00','A35','孙月','女'),
('201936','123456','2019-06-30 16:00:00','A36','柳淑','女'),
('201937','123456','2019-06-30 16:00:00','A37','唐可','女'),
('201938','123456','2019-06-30 16:00:00','A38','龚艳','女'),
('201939','123456','2019-06-30 16:00:00','A39','张怡','女'),
('201940','123456','2019-06-30 16:00:00','A40','许苹','女'),
('201941','123456','2019-06-30 16:00:00','A41','袁婉','女'),
('201942','123456','2019-06-30 16:00:00','A42','邓莹','女'),
('201943','123456','2019-06-30 16:00:00','A43','乔琪','女'),
('201944','123456','2019-06-30 16:00:00','A44','丁欣','女'),
('201945','123456','2019-06-30 16:00:00','A45','杨佳','女'),
('201946','123456','2019-06-30 16:00:00','A46','于虹','女'),
('201947','123456','2019-06-30 16:00:00','A47','沈彩','女'),
('201948','123456','2019-06-30 16:00:00','A48','徐宛','女'),
('201949','123456','2019-06-30 16:00:00','A49','李萍','女'),
('201950','123456','2019-06-30 16:00:00','A50','邓枫','女'),
('root','root','2019-06-30 16:00:00','root','1','1');



DROP TABLE IF EXISTS `take_course`;

CREATE TABLE `take_course` (
  `Cno` varchar(255) DEFAULT NULL,
  `Sno` varchar(255) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  UNIQUE KEY `uniqueData` (`Cno`,`Sno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table `take_course` convert to character set utf8;


INSERT INTO `take_course` VALUES ('A01','01',90);
