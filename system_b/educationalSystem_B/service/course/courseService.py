import dicttoxml

from educationalSystem_B.service.user import userService
from educationalSystem_B.vo.choiceVO import Choice
from educationalSystem_B.vo.courseVO import Course
from educationalSystem_B.service.xml.xmlService import Converter
from educationalSystem_B.service.xml import xmlService as xs



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





def addCourse(Cname,place,teacher,credit,share):
    print("addCourse...")
    try:
        sql=" select count(*) from course where id like 'b%'"
        num=(cur.execute(sql).fetchall())[0][0];
        Cno="b"+str(num+1);
        print("Cno is "+Cno);
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
            student=userService.getStudentInfo(Sno)   #studentVO
            student.setPwd("noPassword")  #重设密码
            choice=Choice(Cno,student,"0")  #choiceVO



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
            student = userService.getStudentInfo(Sno)  # studentVO
            choice = Choice(Cno, student, "0")  # choiceVO
            dict_a = xs.convert2dict(choice)
            print(dict_a)
            xml=Converter.collectionToXML(dict_a)
            #xml = dicttoxml.dicttoxml(dict_a, attr_type=False,ensure_ascii=False)
            #cList={};
            #cList["choice"]=choice
            #root=Converter.collectionToXML(cList)
            #root=Converter.classToXML(choice)
            #xml=Converter.getXmlString(root)
            print(xml)


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
        courses = cur.fetchall()  # list
        print("获取选课成功!")
        return courses
    except BaseException as e:
        print(e)
        print ("获取选课失败...")
        return False

def getAllCourse():
    print("getAllCourse...")
    try:
        sql="select * from [course]"
        cur.execute(sql )
        courses = cur.fetchall()  # list
        print("获取全部课程成功！")
        return courses
    except BaseException as e:
        print(e)
        print("获取全部课程失败...")
        return False

def getOtherCourses(type):  #获取外院的共享课程
    print("getOtherCourses")
    try:        #Todo:使用集成服务器获取外院系课程
        if(type=="A"):  #获取外院A的共享课程


            return False

        elif(type=="C"):    #获取外院C的共享课程


            return False

    except BaseException as e:
        print(e)
        print ("获取外院系课程失败...")
        return False

def getShareCourses():      #获取本院系的共享课程
    try:
        sql="select * from course where share='1'"
        coursesInfo=cur.execute(sql).fetchall()   #list,每个元素是tuple元组
        courses=[]
        for courseInfo in coursesInfo:
            c=Course(courseInfo[0],courseInfo[1],courseInfo[2],courseInfo[3],courseInfo[4],courseInfo[5])
            courses.append(c)
        return courses;
    except BaseException as e:
        print(e)
        return None

def getChoiceInfo(sno,cno):    #获取选课信息
    try:
        sql="select * from choose where course_id='%s' and student_id='%s'"
        choiceInfo = (cur.execute(sql % (cno,sno)).fetchall())[0]   #元组tuple
        return choiceInfo
    except BaseException as e:
        print(e)
        return None

def shareCourses():     #共享本院系的课程
    courses=getShareCourses()       #是list，每个元素是courseVO对象
    for c in courses:
        c.setShare("0")
    #Todo:调用集成服务器

    return False

def othersAddCourse():  #外院系学生的选课
    #Todo:解析xml文件，转成StudentVO和ChoiceVO对象


    #将外院系学生的信息加入本院系的学生表里，并把选课信息加入本院的选课表里(周沛辰写)

    return False

def othersDeleteCourse():   #外院系学生的退课
    #Todo: 解析xml文件，获取学生编号sno和课程编号cno即可


    #调用deleteCourse，若该学生没有选本院系的课了，则删除该学生的学生信息(周沛辰写)

    return False

