declare 
      num   number; 
begin 
      select count(1) into num from all_tables where TABLE_NAME = 'STUDENT';
      if   num=1   then 
          execute immediate 'drop table STUDENT'; 
      end   if; 
end; 
/ 
create table STUDENT(
	no varchar(20),
	name varchar(10),
	username varchar(20),
	passwd varchar(20),
	sex varchar(2),
	CONSTRAINT Sno UNIQUE (no)
);
/

begin
insert into STUDENT(no,name,username,passwd,sex)   values('0001','张三','170001','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0002','李康','170002','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0003','王涵','170003','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0004','杜榕','170004','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0005','胡彰','170005','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0006','吴裕','170006','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0007','袁伦','170007','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0008','汪舱','170008','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0009','熊胜','170009','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0010','萧乾','170010','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0011','于谦','170011','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0012','王澔','170012','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0013','冯御','170013','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0014','袁众','170014','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0015','唐轩','170015','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0016','沈彦','170016','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0017','孔波','170017','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0018','侯泰','170018','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0019','许磊','170019','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0020','郝冀','170020','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0021','常宁','170021','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0022','周星','170022','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0023','万清','170023','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0024','方志','170024','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0025','龚亨','170025','000000','男');
insert into STUDENT(no,name,username,passwd,sex)   values('0026','许婕','170026','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0027','何暄','170027','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0028','吕菀','170028','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0029','周桂','170029','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0030','景晴','170030','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0031','张甜','170031','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0032','郭咏','170032','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0033','董欢','170033','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0034','毛兰','170034','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0035','李欣','170035','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0036','柳青','170036','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0037','潘菲','170037','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0038','段莲','170038','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0039','黄婕','170039','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0040','欧玫','170040','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0041','赖盈','170041','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0042','张璇','170042','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0043','叶玫','170043','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0044','任鹃','170044','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0045','韩画','170045','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0046','卓雯','170046','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0047','苏芃','170047','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0048','范馨','170048','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0049','顾霓','170049','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('0050','贾冰','170050','000000','女');
insert into STUDENT(no,name,username,passwd,sex)   values('root','root','root','root','1');
end;
/

declare 
      num   number; 
begin 
      select count(1) into num from all_tables where TABLE_NAME = 'COURSE';
      if   num=1   then 
          execute immediate 'drop table COURSE'; 
      end   if; 
end; 
/ 
create table COURSE(
	No varchar(10),
	Name varchar(20),
	Teacher varchar(10),
	Credit varchar(1),
	isShare char(1),
	CONSTRAINT Cno UNIQUE (No)
);
/

begin
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C01','互联网计算','杨英','2','0');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C02','Web开发运用','白雪','2','0');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C03','云计算','任客','2','0');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C04','大数据科学基础','费奇','2','1');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C05','计算机视觉','张超','2','1');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C06','电子商务','黄威','2','1');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C07','服务端计算开发','王冲','2','0');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C08','大数据集成开发','鲁慎','2','1');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C09','自动化开发','王伟','2','1');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C10','嵌入式开发','陶瑞','2','1');
end;
/

declare
      num   number; 
begin 
      select count(1) into num from all_tables where TABLE_NAME = 'ELECTIVE';
      if   num=1   then 
          execute immediate 'drop table ELECTIVE'; 
      end   if; 
end; 
/ 
create table ELECTIVE(
	Sno varchar(20),
	Cno varchar(10),
	grade varchar(3),
	CONSTRAINT Eno UNIQUE (Sno,Cno)
);
/