from django.db import models

# Create your models here.
class Choose(models.Model):
    course_id=models.CharField(max_length=32)
    student_id=models.CharField(max_length=32)
    course_grade=models.CharField(max_length=32)

    # def __str__(self):
    #     return "选课表"
