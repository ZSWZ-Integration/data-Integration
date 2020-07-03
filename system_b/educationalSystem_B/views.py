from django.shortcuts import render

from django.http import HttpResponse
import educationalSystem_B.service.course.courseService as course;
import educationalSystem_B.service.user.userService as user;
import educationalSystem_B.service.statistic.statisticService as statistic;
import educationalSystem_B.service.web.WebService as web;

from wsgiref.simple_server import make_server

def index(request):
    print("index")
    return HttpResponse("This is SystemB index")

def addCourse(request):
    cname=request.GET.get("cname");
    place=request.GET.get("place");
    teacher=request.GET.get("teacher");
    credit=request.GET.get("credit");
    share=request.GET.get("share");
    result=course.addCourse("",cname,place,teacher,credit,share);
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
    result=course.getOtherCourses()
    return HttpResponse(result)

def login(request):
    #发布webService
    server = make_server('127.0.0.1', 8100, web.wsgi_app)
    server.serve_forever()
    print("publish webService...")

    username=request.GET.get("username")
    password=request.GET.get("password")
    result=user.login(username,password)
    return HttpResponse(result)

#XML Controller
#Todo:完善接收xml的controller

def getSharedCourses(request):      #获取本院系的共享课程
    print("getSharedCourses...")
    result=course.shareCourses()
    return HttpResponse(result)

def othersAddCourse(request):       #外院系的选课
    print("othersAddCourse...")
    xml=request.body
    result=course.othersAddCourse(xml)
    return HttpResponse(result)

def othersDeleteCourse(request):    #外院系的退课
    xml = request.body
    # ctx = {}
    # if request.POST:
    #     ctx['rlt'] = request.POST['string']
    result=course.othersDeleteCourse(xml)
    return HttpResponse(result)

#统计模块
def getAllCourseStatistic(request):
    print("getAllCourseStatistic")
    result=statistic.getAllCourseStatistic()
    return HttpResponse(result)

def getAllStudentStatistic(request):
    print("getAllStudentStatistic")
    result = statistic.getAllStudentStatistic()
    return HttpResponse(result)

#WebService
def getAShareCoursesNum(request):
    AWebServiceUrl = "http://localhost:8099/Service/getAWebService?wsdl"
    result=web.getAWebService(AWebServiceUrl)
    return HttpResponse(result)

def getCShareCoursesNum(request):
    CWebServiceUrl = "http://localhost:8101/Service/getCWebService?wsdl"
    result = web.getCWebService(CWebServiceUrl)
    return HttpResponse(result)