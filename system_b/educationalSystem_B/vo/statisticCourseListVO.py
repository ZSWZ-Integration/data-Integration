
class StatisticCourseListVO:
    statisticCourses = {};

    def __init__(self, statisticCourses):
        self.statisticCourses = statisticCourses

    def getStatisticCourses(self):
        return self.statisticCourses

    def setStatisticCourses(self, statisticCourses):
        self.statisticCourses = statisticCourses