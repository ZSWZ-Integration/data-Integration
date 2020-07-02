
class ChoiceVO:
    def __init__(self, cno, student, grade):
        self.cno = cno
        self.student = student
        self.grade = grade

    def getCno(self):
        return self.cno

    def setCno(self, cno):
        self.cno = cno

    def getStudent(self):
        return self.student

    def setStudent(self, student):
        self.student = student

    def getGrade(self):
        return self.grade

    def setGrade(self, grade):
        self.grade = grade