class StatisticStudent:
    def __init__(self, id, name,sex,cno,cname,grade):
        self.id = id
        self.name = name
        self.sex = sex
        self.cno = cno
        self.cname = cname
        self.grade = grade

    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id

    def getName(self):
        return self.name

    def setName(self, name):
        self.name = name

    def getSex(self):
        return self.sex

    def setSex(self, sex):
        self.sex = sex

    def getCno(self):
        return self.cno

    def setCno(self, cno):
        self.cno = cno

    def getCname(self):
        return self.cname

    def setCname(self, cname):
        self.v = cname

    def getGrade(self):
        return self.grade

    def setGrade(self, grade):
        self.v = grade