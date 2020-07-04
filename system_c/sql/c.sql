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
insert into STUDENT(no,name,username,passwd,sex)   values('0001','����','170001','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0002','�','170002','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0003','����','170003','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0004','����','170004','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0005','����','170005','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0006','��ԣ','170006','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0007','Ԭ��','170007','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0008','����','170008','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0009','��ʤ','170009','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0010','��Ǭ','170010','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0011','��ǫ','170011','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0012','����','170012','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0013','����','170013','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0014','Ԭ��','170014','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0015','����','170015','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0016','����','170016','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0017','�ײ�','170017','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0018','��̩','170018','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0019','����','170019','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0020','�¼�','170020','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0021','����','170021','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0022','����','170022','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0023','����','170023','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0024','��־','170024','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0025','����','170025','000000','��');
insert into STUDENT(no,name,username,passwd,sex)   values('0026','���','170026','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0027','����','170027','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0028','����','170028','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0029','�ܹ�','170029','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0030','����','170030','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0031','����','170031','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0032','��ӽ','170032','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0033','����','170033','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0034','ë��','170034','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0035','����','170035','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0036','����','170036','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0037','�˷�','170037','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0038','����','170038','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0039','���','170039','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0040','ŷõ','170040','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0041','��ӯ','170041','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0042','���','170042','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0043','Ҷõ','170043','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0044','�ξ�','170044','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0045','����','170045','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0046','׿��','170046','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0047','���M','170047','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0048','��ܰ','170048','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0049','����','170049','000000','Ů');
insert into STUDENT(no,name,username,passwd,sex)   values('0050','�ֱ�','170050','000000','Ů');
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
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C01','����������','��Ӣ','2','0');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C02','Web��������','��ѩ','2','0');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C03','�Ƽ���','�ο�','2','0');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C04','�����ݿ�ѧ����','����','2','1');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C05','������Ӿ�','�ų�','2','1');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C06','��������','����','2','1');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C07','����˼��㿪��','����','2','0');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C08','�����ݼ��ɿ���','³��','2','1');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C09','�Զ�������','��ΰ','2','1');
insert into COURSE(No,Name,Teacher,Credit,isShare) values ('C10','Ƕ��ʽ����','����','2','1');
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