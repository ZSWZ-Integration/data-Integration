from educationalSystem_B import models;
from educationalSystem_B.models import Choose


# import pymssql
# # serverName = "127.0.0.1" # 连接服务器地址
# # user = "sa" #用户名
# # password = "root"  #密码
# # #conn = pymssql.connect(serverName,user, password, "b_system") #获取连接
# # #conn=pymssql.connect(host='127.0.0.1:1433',user='sa',password='root',database='b_system')
# # conn = pymssql.connect(server="MSSQLSERVER", port='1433', user='sa', password='root', database='b_system')
# # cursor = conn.cursor() # 获取光标

import pyodbc

# 数据库服务器信息
driver = 'SQL Server Native Client 11.0'
# 因版本不同而异
server = 'BENSON的电脑'
user = 'sa'
password = 'root'
database = 'b_system'
conn = pyodbc.connect(driver=driver, server=server, user=user, password=password, database=database)

cur = conn.cursor()





def addCourse(Cno,Cname,place,teacher,credit,share):
    print("addCourse...")
    try:
        sql="insert into course(id,name,credit,teacher,campus,share) values ('%s','%s','%s','%s','%s','%s')"
        cur.execute(sql % (Cno,Cname,credit,teacher,place,share))
        conn.commit()
        print( "添加课程成功！")
        return True
    except BaseException as e:
        print(e)
        print( "添加课程失败...")
        return False

def deleteCourse(Cno):
    print("deleteCourse...")
    try:
        sql="delete from [course] where  id='%s'"
        cur.execute(sql % Cno)
        conn.commit()
        print("删除课程成功！")

        sql = "select * from [course]"  # 查询语句
        cur.execute(sql)
        rows = cur.fetchall()  # list
        for row in rows:
            print(row)
        return True;
    except BaseException as e:
        print(e)
        print("删除课程失败...")
        return False

def updateCourse(Cno,Cname,place,teacher,credit,share):
    print("updateCourse...")
    print("share is "+share)
    try:
        sql="update [course] SET name='%s',credit='%s',teacher='%s',campus='%s',share='%s' where id='%s';"
        cur.execute(sql % (Cname, credit, teacher, place, share,Cno))
        conn.commit()
        print("更新课程成功！")
        return True
        # sql = "select * from [course]"  # 查询语句
        # cur.execute(sql)
        # rows = cur.fetchall()  # list
        # for row in rows:
        #     print(row)
    except BaseException as e:
        print(e)
        print("更新课程失败...")
        return False

def chooseCourse(Sno,Cno):
    print("chooseCourse...")
    #models.Choose.objects.create(course_id=Cno,student_id=Sno,course_grade="4")
    try:
        if(Cno[0:1]=="b"): #选的是本院系的课
            sql = "insert into choose(course_id,student_id,course_grade) values ('%s','%s','0')"
            cur.execute(sql % (Cno, Sno))
            conn.commit()
            print("选课成功！")
            return True
        else:   #Todo:选的是外院系的课，需要调用集成服务器
            pass
            return False

    except BaseException as e:
        print(e)
        print("选课失败...")
        return False


def dropCourse(Sno,Cno):
    print("dropCourse...")
    try:
        if (Cno[0:1] == "b"):  # 退的是本院系的课
            sql="delete from [choose] where  course_id='%s' and student_id='%s'"
            cur.execute(sql % (Cno,Sno))
            conn.commit()
            print("删除选课成功！")
            return True
        else:       #Todo:退外院系的课，需要调用集成服务器
            pass
            return False

    except BaseException as e:
        print(e)
        print ("删除选课失败...")
        return False

def getStudentCourse(Sno):
    print("getStudentCourse...")
    try:
        sql="select * from [course] where id=(select course_id from choose where student_id='%s')"
        cur.execute(sql % Sno)
        rows = cur.fetchall()  # list
        print("获取选课成功!")
        return rows
    except BaseException as e:
        print(e)
        print ("获取选课失败...")
        return False

def getAllCourse():
    print("getAllCourse...")
    try:
        sql="select * from [course]"
        cur.execute(sql )
        rows = cur.fetchall()  # list
        print("获取全部课程成功！")
        return rows
    except BaseException as e:
        print(e)
        print("获取全部课程失败...")
        return False

def getOtherCourses(type):
    print("getOtherCourses")
    try:        #Todo:使用集成服务器获取外院系课程
        if(type=="A"):  #获取外院A的共享课程
            pass
            return False

        elif(type=="C"):    #获取外院C的共享课程
            pass
            return False

    except BaseException as e:
        print(e)
        print ("获取外院系课程失败...")
        return False