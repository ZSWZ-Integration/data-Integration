if db_id('b_system') is not null
	drop database b_system
go
create database b_system;
go
use b_system
go

create table student
(
	id varchar(20),
	name varchar(10),
	sex varchar(2),
	age varchar(3),
	pwd varchar(20)	
);

insert into student(id,name,sex,age,pwd) values ('b001','赵冲','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b002','钱清','男','21','000000')
insert into student(id,name,sex,age,pwd) values ('b003','孙海','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b004','李游','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b005','周行','男','22','000000')
insert into student(id,name,sex,age,pwd) values ('b006','吴谦','男','21','000000')
insert into student(id,name,sex,age,pwd) values ('b007','郑丘','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b008','王豪','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b009','冯帆','男','22','000000')
insert into student(id,name,sex,age,pwd) values ('b010','陈翔','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b011','卫亮','男','21','000000')
insert into student(id,name,sex,age,pwd) values ('b012','蒋和','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b013','申万','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b014','沈明','男','22','000000')
insert into student(id,name,sex,age,pwd) values ('b015','杨凡','男','21','000000')
insert into student(id,name,sex,age,pwd) values ('b016','韩恒','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b017','朱力','男','19','000000')
insert into student(id,name,sex,age,pwd) values ('b018','秦武','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b019','华阳','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b020','何池','男','22','000000')
insert into student(id,name,sex,age,pwd) values ('b021','陈翔','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b022','曹翔','男','22','000000')
insert into student(id,name,sex,age,pwd) values ('b023','尤浩','男','21','000000')
insert into student(id,name,sex,age,pwd) values ('b024','严华','男','22','000000')
insert into student(id,name,sex,age,pwd) values ('b025','金若','男','22','000000')
insert into student(id,name,sex,age,pwd) values ('b026','陶成','男','20','000000')
insert into student(id,name,sex,age,pwd) values ('b027','姜陆','男','22','000000')
insert into student(id,name,sex,age,pwd) values ('b028','唐瑞','男','21','000000')
insert into student(id,name,sex,age,pwd) values ('b029','蒋俊','男','22','000000')
insert into student(id,name,sex,age,pwd) values ('b030','戚威','男','21','000000')
insert into student(id,name,sex,age,pwd) values ('b031','谢雅','女','22','000000')
insert into student(id,name,sex,age,pwd) values ('b031','谢雅','女','22','000000')
insert into student(id,name,sex,age,pwd) values ('b032','吕怜','女','21','000000')
insert into student(id,name,sex,age,pwd) values ('b033','云梦','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b034','王璐','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b035','刘畅','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b036','韩笑','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b037','苗明','女','21','000000')
insert into student(id,name,sex,age,pwd) values ('b038','苗凯','女','21','000000')
insert into student(id,name,sex,age,pwd) values ('b039','苏柔','女','21','000000')
insert into student(id,name,sex,age,pwd) values ('b040','范雪','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b041','张可','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b042','蓝清','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b043','兰洋','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b044','顾梦','女','21','000000')
insert into student(id,name,sex,age,pwd) values ('b045','钱敏','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b046','王钰','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b047','候佩','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b048','齐珏','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b049','林慧','女','20','000000')
insert into student(id,name,sex,age,pwd) values ('b050','丁艺','女','19','000000')

create table course
(
	id varchar(10),
	name varchar(255),
	credit varchar(2),
	teacher varchar(10),
	campus varchar(5),
	share char(1)
);

insert into course(id,name,credit,teacher,campus,share) values ('B01','数据结构','4','何章','仙林','1')
insert into course(id,name,credit,teacher,campus,share) values ('B02','C++语言基础','5','潘李','鼓楼','1')
insert into course(id,name,credit,teacher,campus,share) values ('B03','C++程序设计','5','贺阳','鼓楼','0')
insert into course(id,name,credit,teacher,campus,share) values ('B04','数据科学基础','4','陈焕','仙林','1')
insert into course(id,name,credit,teacher,campus,share) values ('B05','数据库管理基础','3','杨晓','鼓楼','1')
insert into course(id,name,credit,teacher,campus,share) values ('B06','数据库开发','4','杨晓','鼓楼','1')
insert into course(id,name,credit,teacher,campus,share) values ('B07','编译原理','2','费暮','鼓楼','0')
insert into course(id,name,credit,teacher,campus,share) values ('B08','软件体系结构','4','林涵','鼓楼','1')
insert into course(id,name,credit,teacher,campus,share) values ('B09','需求工程','3','韩华','鼓楼','1')
insert into course(id,name,credit,teacher,campus,share) values ('B10','商业模式','3','李延','鼓楼','1')

create table choose
(
	course_id varchar(10),
	student_id varchar(20),
	course_grade varchar(5)
);