
class Course:
    def __init__(self,id,name,credit,teacher,campus,share):
        self.id=id
        self.name=name
        self.credit=credit
        self.teacher=teacher
        self.campus = campus
        self.share = share

    def getId(self):
        return self.id

    def setId(self,id):
        self.id=id

    def getName(self):
        return self.name

    def setName(self,name):
        self.name=name

    def getCredit(self):
        return self.credit

    def setCredit(self,credit):
        self.credit=credit

    def getTeacher(self):
        return self.teacher

    def setTeacher(self,teacher):
        self.teacher=teacher

    def getCampus(self):
        return self.campus

    def setCampus(self,campus):
        self.campus=campus

    def getShare(self):
        return self.share

    def setShare(self,share):
        self.share=share