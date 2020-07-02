
class StatisticCourse:
    def __init__(self, id, name,credit,teacher,count):
        self.id = id
        self.name = name
        self.teacher = teacher
        self.credit = credit
        self.count = count

    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id

    def getName(self):
        return self.name

    def setName(self, name):
        self.name = name

    def getCredit(self):
        return self.credit

    def setCredit(self, credit):
        self.credit = credit

    def getTeacher(self):
        return self.teacher

    def setTeacher(self, teacher):
        self.teacher = teacher

    def getCount(self):
        return self.count

    def setCount(self, count):
        self.count = count