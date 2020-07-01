from educationalSystem_B.vo import student as s
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

def login(username,password):
    print("login...")
    sql="select * from student where id='%s' and pwd='%s'"
    cur.execute(sql % (username,password))
    rows = cur.fetchall()
    if(len(rows)==1):
        print("登录成功")
        return True
    else:
        print("登录失败")
        return False

def getStudentInfo(id):
    print("getStudentInfo...")
    try:
        sql="select * from student where id='%s'"
        studentInfo=(cur.execute(sql % id).fetchall())[0]
        student=s.Student(studentInfo[0],studentInfo[4],studentInfo[1],studentInfo[2],studentInfo[3])
        return student
    except BaseException as e:
        print(e)
        return None

def addStudent(id,name,sex,age,pwd):
    print("addStudent...")
    try:
        sql="insert into student(id,name,sex,age,pwd) values ('%s','%s','%s','%s','%s')"
        cur.execute(sql % (id,name,sex,age,pwd))
        conn.commit()
        return True
    except BaseException as e:
        print(e)
        return False

def deleteStudent(id):
    print("deleteStudent...")
    try:
        sql = "delete from student where id='%s'"
        cur.execute(sql % id)
        conn.commit()
        return True
    except BaseException as e:
        print(e)
        return False

