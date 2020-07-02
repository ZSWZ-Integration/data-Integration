

class Student:  #id,name,sex,age,pwd
    def __init__(self,id,pwd,name,sex,age):
        self.id=id
        self.pwd=pwd
        self.name=name
        self.age=age
        self.sex=sex

    def getId(self):
        return self.id

    def setId(self,id):
        self.id=id

    def getPwd(self):
        return self.pwd

    def setPwd(self,pwd):
        self.pwd=pwd

    def getName(self):
        return self.name

    def setName(self,name):
        self.name=name

    def getAge(self):
        return self.age

    def setAge(self,age):
        self.age=age

    def getSex(self):
        return self.sex

    def setSex(self,sex):
        self.sex=sex