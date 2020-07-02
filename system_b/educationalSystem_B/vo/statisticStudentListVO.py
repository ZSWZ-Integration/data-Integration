class StatisticStudentListVO:
    statisticStudents = {};

    def __init__(self, statisticStudents):
        self.statisticStudents = statisticStudents

    def getStatisticStudents(self):
        return self.statisticStudents

    def setStatisticStudents(self, statisticStudents):
        self.statisticStudents = statisticStudents