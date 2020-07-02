
class CourseListVO:
    courses={};

    def __init__(self, courses):
        self.courses = courses


    def getCourses(self):
        return self.courses

    def setCno(self, courses):
        self.courses = courses


