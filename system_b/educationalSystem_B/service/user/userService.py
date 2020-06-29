
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
