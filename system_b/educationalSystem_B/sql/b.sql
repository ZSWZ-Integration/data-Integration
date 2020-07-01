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

insert into student(id,name,sex,age,pwd) values ('b001','�Գ�','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b002','Ǯ��','��','21','000000')
insert into student(id,name,sex,age,pwd) values ('b003','�ﺣ','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b004','����','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b005','����','��','22','000000')
insert into student(id,name,sex,age,pwd) values ('b006','��ǫ','��','21','000000')
insert into student(id,name,sex,age,pwd) values ('b007','֣��','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b008','����','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b009','�뷫','��','22','000000')
insert into student(id,name,sex,age,pwd) values ('b010','����','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b011','����','��','21','000000')
insert into student(id,name,sex,age,pwd) values ('b012','����','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b013','����','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b014','����','��','22','000000')
insert into student(id,name,sex,age,pwd) values ('b015','�','��','21','000000')
insert into student(id,name,sex,age,pwd) values ('b016','����','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b017','����','��','19','000000')
insert into student(id,name,sex,age,pwd) values ('b018','����','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b019','����','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b020','�γ�','��','22','000000')
insert into student(id,name,sex,age,pwd) values ('b021','����','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b022','����','��','22','000000')
insert into student(id,name,sex,age,pwd) values ('b023','�Ⱥ�','��','21','000000')
insert into student(id,name,sex,age,pwd) values ('b024','�ϻ�','��','22','000000')
insert into student(id,name,sex,age,pwd) values ('b025','����','��','22','000000')
insert into student(id,name,sex,age,pwd) values ('b026','�ճ�','��','20','000000')
insert into student(id,name,sex,age,pwd) values ('b027','��½','��','22','000000')
insert into student(id,name,sex,age,pwd) values ('b028','����','��','21','000000')
insert into student(id,name,sex,age,pwd) values ('b029','����','��','22','000000')
insert into student(id,name,sex,age,pwd) values ('b030','����','��','21','000000')
insert into student(id,name,sex,age,pwd) values ('b031','л��','Ů','22','000000')
insert into student(id,name,sex,age,pwd) values ('b031','л��','Ů','22','000000')
insert into student(id,name,sex,age,pwd) values ('b032','����','Ů','21','000000')
insert into student(id,name,sex,age,pwd) values ('b033','����','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b034','���','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b035','����','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b036','��Ц','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b037','����','Ů','21','000000')
insert into student(id,name,sex,age,pwd) values ('b038','�翭','Ů','21','000000')
insert into student(id,name,sex,age,pwd) values ('b039','����','Ů','21','000000')
insert into student(id,name,sex,age,pwd) values ('b040','��ѩ','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b041','�ſ�','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b042','����','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b043','����','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b044','����','Ů','21','000000')
insert into student(id,name,sex,age,pwd) values ('b045','Ǯ��','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b046','����','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b047','����','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b048','����','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b049','�ֻ�','Ů','20','000000')
insert into student(id,name,sex,age,pwd) values ('b050','����','Ů','19','000000')

create table course
(
	id varchar(10),
	name varchar(255),
	credit varchar(2),
	teacher varchar(10),
	campus varchar(5),
	share char(1)
);

insert into course(id,name,credit,teacher,campus,share) values ('B01','���ݽṹ','4','����','����','1')
insert into course(id,name,credit,teacher,campus,share) values ('B02','C++���Ի���','5','����','��¥','1')
insert into course(id,name,credit,teacher,campus,share) values ('B03','C++�������','5','����','��¥','0')
insert into course(id,name,credit,teacher,campus,share) values ('B04','���ݿ�ѧ����','4','�»�','����','1')
insert into course(id,name,credit,teacher,campus,share) values ('B05','���ݿ�������','3','����','��¥','1')
insert into course(id,name,credit,teacher,campus,share) values ('B06','���ݿ⿪��','4','����','��¥','1')
insert into course(id,name,credit,teacher,campus,share) values ('B07','����ԭ��','2','��ĺ','��¥','0')
insert into course(id,name,credit,teacher,campus,share) values ('B08','�����ϵ�ṹ','4','�ֺ�','��¥','1')
insert into course(id,name,credit,teacher,campus,share) values ('B09','���󹤳�','3','����','��¥','1')
insert into course(id,name,credit,teacher,campus,share) values ('B10','��ҵģʽ','3','����','��¥','1')

create table choose
(
	course_id varchar(10),
	student_id varchar(20),
	course_grade varchar(5)
);