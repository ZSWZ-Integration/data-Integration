from django.urls import path

from educationalSystem_B import views

urlpatterns = [
    path('', views.index, name='index'),
    path('addCourse',views.addCourse),
    path('deleteCourse',views.deleteCourse),
    path('chooseCourse',views.chooseCourse),
    path('updateCourse',views.updateCourse),
    path('dropCourse',views.dropCourse),
    path('getStudentCourse',views.getStudentCourse),
    path('getAllCourse',views.getAllCourse),
    path('getOtherCourses',views.getOtherCourses),
    path('login',views.login),
    path('getSharedCourses',views.getSharedCourses),
    path('othersAddCourse',views.othersAddCourse),
    path('othersDeleteCourse',views.othersDeleteCourse),
    path('getAllCourseStatistic',views.getAllCourseStatistic),
    path('getAllStudentStatistic',views.getAllStudentStatistic),
]