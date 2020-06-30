from django.shortcuts import render

from django.http import HttpResponse
import educationalSystem_B.service.course.courseService as course;
import educationalSystem_B.service.user.userService as user;

def index(request):
    return HttpResponse("This is SystemB index")

def addCourse(request):
    cname=request.GET.get("cname");
    place=request.GET.get("place");
    teacher=request.GET.get("teacher");
    credit=request.GET.get("credit");
    share=request.GET.get("share");
    result=course.addCourse(cname,place,teacher,credit,share);
    return HttpResponse(result)

def deleteCourse(request):
    Cno=request.GET.get("cno");
    result=course.deleteCourse(Cno);
    return HttpResponse(result)

def updateCourse(request):
    cno = request.GET.get("cno");
    cname = request.GET.get("cname");
    place = request.GET.get("place");
    teacher = request.GET.get("teacher");
    credit = request.GET.get("credit");
    share = request.GET.get("share");
    result=course.updateCourse(cno,cname,place,teacher,credit,share)
    return HttpResponse(result)

def chooseCourse(request):
    cno = request.GET.get("cno");
    sno=request.GET.get("sno");
    result=course.chooseCourse(sno,cno);
    return HttpResponse(result)

def dropCourse(request):
    cno = request.GET.get("cno");
    sno = request.GET.get("sno");
    result=course.dropCourse(sno, cno);
    return HttpResponse(result)

def getStudentCourse(request):
    sno = request.GET.get("sno");
    result=course.getStudentCourse(sno);
    return HttpResponse(result)

def getAllCourse(request):
    result=course.getAllCourse();
    return HttpResponse(result)

def getOtherCourses(request):
    type=request.GET.get("type")
    result=course.getOtherCourses(type)
    return HttpResponse(result)

def login(request):
    username=request.GET.get("username")
    password=request.GET.get("password")
    result=user.login(username,password)
    return HttpResponse(result)

#XML Controller
#Todo:完善接收xml的controller

def getSharedCourses(request):      #获取本院系的共享课程
    result=course.shareCourses()
    return HttpResponse(result)

def othersAddCourse(request):       #外院系的选课
    result=course.othersAddCourse()
    return HttpResponse(result)

def othersDeleteCourse(request):    #外院系的退课
    result=course.othersDeleteCourse()
    return HttpResponse(result)
