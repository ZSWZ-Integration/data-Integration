

import pyodbc
from educationalSystem_B.vo.statisticCourse import StatisticCourse
from educationalSystem_B.vo.statisticCourseListVO import StatisticCourseListVO
from educationalSystem_B.vo.statisticStudent import StatisticStudent
from educationalSystem_B.vo.statisticStudentListVO import StatisticStudentListVO
import educationalSystem_B.service.xml.xmlService as xs

# 数据库服务器信息
driver = 'SQL Server Native Client 11.0'
# 因版本不同而异
server = 'BENSON的电脑'
user = 'sa'
password = 'root'
database = 'b_system'
conn = pyodbc.connect(driver=driver, server=server, user=user, password=password, database=database)

cur = conn.cursor()


def getAllCourseStatistic():
    print("getAllCourseStatistic...")
    try:
        sql = "select c.id,c.name,c.credit,c.teacher,(CASE WHEN count IS NOT NULL THEN count ELSE 0 END)as count from course c left join (select course_id,count(*) as count from choose group by course_id)t on c.id=t.course_id;"
        cur.execute(sql )
        courses = cur.fetchall()  # list
        statisticCourseList=[]
        for course in courses:
            statisticCourseList.append(StatisticCourse(course[0],course[1],course[2],course[3],course[4]))
            print(course)
        statisticCourseListVO=StatisticCourseListVO(statisticCourseList)
        xml=xs.objectToXml2(statisticCourseListVO)
        print(xml)
        print("统计课程成功!")
        return xml
    except BaseException as e:
        print(e)
        print("统计课程失败...")
        return ""


def getAllStudentStatistic():
    print("getAllStudentStatistic...")
    try:
        sql='select s.id,s.name,s.sex,(CASE WHEN p.id IS NOT NULL THEN p.id ELSE 0 END)as cno,(CASE WHEN p.name IS NOT NULL THEN p.name ELSE 0 END)as cname from student s left join (select t.student_id,c.id,c.name from course c,choose t where c.id=t.course_id)p on s.id=p.student_id;'
        sql = 'select s.id,s.name,s.sex,p.id as cno,p.name as cname from student s left join (select t.student_id,c.id,c.name from course c,choose t where c.id=t.course_id)p on s.id=p.student_id;'
        cur.execute(sql )
        students = cur.fetchall()  # list
        statisticStudentList=[]
        for student in students:
            statisticStudentList.append(StatisticStudent(student[0],student[1],student[2],student[3],student[4],"0"))
            print(student)
        statisticStudentListVO=StatisticStudentListVO(statisticStudentList)
        xml=xs.objectToXml2(statisticStudentListVO)
        print(xml)
        print("统计学生成功!")
        return xml
    except BaseException as e:
        print(e)
        print("统计学生失败...")
        return ""


