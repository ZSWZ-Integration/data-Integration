package com.example.a_system.service;

import com.example.a_system.dao.Repository.CourseRepository;
import com.example.a_system.dao.Repository.UserRepository;
import com.example.a_system.po.Course.Choice;
import com.example.a_system.po.Course.Course;
import com.example.a_system.vo.ChoiceVO;
import com.example.a_system.vo.CourseVO;
import com.example.a_system.vo.StudentVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    XmlService xmlService;


    public boolean addCourse(String Cname,String ctime,String teacher,String credit,String type,String share) {
        int num=courseRepository.getACoursesNum();
        String Cno="A"+(num+1);
        return courseRepository.addCourse(Cno, Cname, ctime, teacher, credit, type, share);
    }

    public boolean deleteCourse(String Cno){
        return courseRepository.deleteCourse(Cno);
    }

    public boolean updateCourse(String Cno,String Cname,String ctime,String teacher,String credit,String type,String share){
        return courseRepository.updateCourse(Cno,Cname,ctime,teacher,credit,type,share);
    }

    public boolean chooseCourse(String Sno,String Cno){
        if(Cno.substring(0,1).equals("A"))          //选择本院系的课
            return courseRepository.chooseCourse(Sno,Cno);
        else{               //选择外院系的课
            try {
                StudentVO student = userRepository.getStudentInfo(Sno); //StudentVO
                student.setPassword("noPassword");     //修改掉password,不让学生登录外院系的教务系统
                ChoiceVO choiceVO = new ChoiceVO(Cno, student, "0");  //ChoiceVO
                //给集成服务器发送xml
                String result="fail";
                String xml = xmlService.object2Xml(choiceVO);
                System.out.println("xml is "+xml);
                if(Cno.substring(0,1).equals("B")){  //选B院系的课
                    result=xmlService.postRequest(xml,"http://localhost:8080/transfer/A_choose_B");
                }
                else if(Cno.substring(0,1).equals("C")){  //选C院系的课
                    result=xmlService.postRequest(xml,"http://localhost:8080/transfer/A_choose_C");
                }
                if(result.equals("fail"))
                    return false;
                else
                    return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }

    public boolean dropCourse(String Sno,String Cno) throws JsonProcessingException {
        if(Cno.substring(0,1).equals("A"))          //退本院系的课
            return courseRepository.dropCourse(Sno,Cno);
        else{               //退外院系的课
            try {
                StudentVO student=userRepository.getStudentInfo(Sno); //StudentVO
                ChoiceVO choice =new ChoiceVO(Cno,student,"0");  //ChoiceVO
                //给集成服务器发送xml
                String result="fail";
                String xml = xmlService.object2Xml(choice);
                if(Cno.substring(0,1).equals("B")){  //退B院系的课
                    result= xmlService.postRequest(xml,"http://localhost:8080/transfer/A_drop_B");
                }
                else if(Cno.substring(0,1).equals("C")){  //选C院系的课
                    result=xmlService.postRequest(xml,"http://localhost:8080/transfer/A_drop_C");
                }
                if(result.equals("fail"))
                    return false;
                else
                    return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }

    }

    public List<Course> getStudentCourse(String Sno){
        return courseRepository.getStudentCourse(Sno);
    }

    public List<Course> getAllCourse(){
        return courseRepository.getAllCourse();
    }

    public boolean getOtherCourses(String type){    //获取外院系的共享课程，type是外院B或C。注意：此处要把外院系课程的share变为0后才能存入本地数据库
        try {
            if (type.equals("B")) {   //获取外院B的共享课程
                //从集成服务器获取xml
                String xml = xmlService.getRequest("http://localhost:8080/transfer/get_B_courses");
                //Todo:解析xml成CourseVO对象


                //将课程数据存入本院数据库

            } else if (type.equals("C")) {      //获取外院C的共享课程
                //从集成服务器获取xml
                String xml = xmlService.getRequest("http://localhost:8080/transfer/get_C_courses");
                //Todo:解析xml成CourseVO对象


                //将课程数据存入本院数据库


            }
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public String shareCourses(){  //共享本院系的课程
        try {
            List<CourseVO> courses = courseRepository.getSharedCourse();
            for (CourseVO c : courses) {
                c.setShare("0");
            }
            //Todo:封装成大的xml文件，发送给集成服务器
            String xml = "";      //大的xml文件

            return xml;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public String othersAddCourse(String xml){  //外院系学生的选课
        try {
            //Todo:解析xml文件，转成StudentVO和ChoiceVO对象


            //将外院系学生的信息加入本院系的学生表里，并把选课信息加入本院的选课表里(周沛辰写)
            //1.调用userRepository的addStudent接口

            //2.调用courseRepository的chooseCourse接口


            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }

    public String othersDeleteCourse(String xml){    //外院系学生的退课
        try {
            //Todo:解析xml文件，获取学生编号sno和课程编号cno即可


            //调用deleteCourse，若该学生没有选本院系的课了，则删除该学生的学生信息(周沛辰写)

            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }
}
