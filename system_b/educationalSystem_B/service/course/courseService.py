import dicttoxml
import xmlformatter


from educationalSystem_B.service.user import userService
from educationalSystem_B.vo.choiceVO import ChoiceVO
from educationalSystem_B.vo.courseListVO import CourseListVO
from educationalSystem_B.vo.course import Course
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
        if(Cno[0:1]=="B"): #选的是本院系的课
            sql = "insert into choose(course_id,student_id,course_grade) values ('%s','%s','0')"
            cur.execute(sql % (Cno, Sno))
            conn.commit()
            print("选课成功！")
            return True
        else:   #选的是外院系的课，需要调用集成服务器
            student=userService.getStudentInfo(Sno)   #studentVO
            student.setPwd("noPassword")  #重设密码
            choice=ChoiceVO(Cno,student,"0")  #choiceVO
            xml=xs.objectToXml(choice)
            result="";
            if(Cno[0:1]=="A"): #选A院系的课
                result=xs.postRequest(xml,"http://localhost:8080/transfer/B_choose_A")
            elif(Cno[0:1]=="C"):   #选C院系的课
                result=xs.postRequest(xml, "http://localhost:8080/transfer/B_choose_C")

            if(result=="fail"):
                return False
            else:
                return True
    except BaseException as e:
        print(e)
        print("选课失败...")
        return False


def dropCourse(Sno,Cno):
    print("dropCourse...")
    try:
        if (Cno[0:1] == "B"):  # 退的是本院系的课
            sql="delete from [choose] where  course_id='%s' and student_id='%s'"
            cur.execute(sql % (Cno,Sno))
            conn.commit()
            print("删除选课成功！")
            return True
        else:       #退外院系的课，给集成服务器发送xml
            student = userService.getStudentInfo(Sno)  # studentVO
            choice = ChoiceVO(Cno, student, "0")  # choiceVO
            xml=xs.objectToXml(choice)
            if (Cno[0:1] == "A"):  # 退A院系的课
                result = xs.postRequest(xml, "http://localhost:8080/transfer/B_drop_A")
            elif (Cno[0:1] == "C"):  # 退C院系的课
                result = xs.postRequest(xml, "http://localhost:8080/transfer/B_drop_C")

            if (result == "fail"):
                return False
            else:
                return True

            # result=xs.getRequest("http://localhost:8080/transfer/get_test")
            # print(result)
            # obj=xs.xmlToObject(result);
            # print(obj)

            # obj=xs.xmlToObject(xml)
            # print(obj)
            # print((obj.xml.student.name).decode())
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
    try:        #使用集成服务器获取外院系课程
        if(type=="A"):  #获取外院A的共享课程
            xml=xs.getRequest("http://localhost:8080/transfer/get_A_courses")
        elif(type=="C"):    #获取外院C的共享课程
            xml = xs.getRequest("http://localhost:8080/transfer/get_C_courses")
        courseList=(xs.xmlToObject(xml)).Request.courses.item;
        for course in courseList:
            addCourse(course.get("name").decode(),course.get("place").decode(),course.get("teacher").decode(),course.get("credit").decode(),course.get("share").decode())
        return True
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
            c=Course(courseInfo[0],courseInfo[1],courseInfo[2],courseInfo[3],courseInfo[4],"0")
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
    try:
        courses=getShareCourses()       #是list，每个元素是courseVO对象
        courseList=CourseListVO(courses)
        xml=""
        #封装成大的xml文件，发送给集成服务器
        if(courses!=None):
            xml=xs.objectToXml2(courseList);
            #print(xml)
        # obj=xs.xmlToObject(xml);
        # print("------------")
        # print(obj)
        # print((obj.Request.courses.item[2].get("id")).decode())
        # print((obj.Request.courses.item[2].get("name")).decode())
        return xml
    except BaseException as e:
        print(e)
        return ""

def othersAddCourse(xml):  #外院系学生的选课
    try:
        #解析xml文件，转成StudentVO和ChoiceVO对象
        obj=xs.xmlToObject(xml)
        cno=obj.xml.cno.decode()
        grade=obj.xml.grade.decode()
        age=obj.xml.student.age.decode()
        id = obj.xml.student.id.decode()
        name = obj.xml.student.name.decode()
        pwd = obj.xml.student.pwd.decode()
        sex = obj.xml.student.sex.decode()
        #将外院系学生的信息加入本院系的学生表里，并把选课信息加入本院的选课表里(周沛辰写)
        userService.addStudent(id,name,sex,age,pwd)
        chooseCourse(id,cno)
        return "success"
    except BaseException as e:
        print(e)
        return "fail"

def othersDeleteCourse(xml):   #外院系学生的退课
    try:
        # 解析xml文件，获取学生编号sno和课程编号cno即可
        obj = xs.xmlToObject(xml)
        cno = obj.xml.cno.decode()
        id = obj.xml.student.id.decode()
        dropCourse(id,cno)
        courseList=getStudentCourse(id)
        if (len(courseList)== 0):
            userService.deleteStudent(id)
        return "success"
    except BaseException as e:
        print(e)
        return "fail"






