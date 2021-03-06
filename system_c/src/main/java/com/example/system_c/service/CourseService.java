package com.example.system_c.service;

import com.example.system_c.dao.Repository.CourseRepository;
import com.example.system_c.dao.Repository.UserRepository;
import com.example.system_c.po.Course.CoursePO;
import com.example.system_c.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    XmlService xmlService;


    public boolean addCourse(String Cno,String Cname,String teacher,String credit,String share) {
        if(Cno.equals("")) {
            int num = courseRepository.getCCoursesNum();
            Cno = "A" + (num + 1);
        }
        return courseRepository.addCourse(Cno,Cname,teacher,credit,share);
    }

    public boolean deleteCourse(String Cno){
        return courseRepository.deleteCourse(Cno);
    }

    public boolean updateCourse(String Cno,String Cname,String teacher,String credit,String share){
        return courseRepository.updateCourse(Cno,Cname,teacher,credit,share);
    }

    public boolean chooseCourse(String Sno,String Cno){
        if(Cno.substring(0,1).equals("C"))          //选择本院系的课
            return courseRepository.chooseCourse(Sno,Cno);
        else{               //选择外院系的课
            try {
                boolean isChosen=courseRepository.chooseCourse(Sno,Cno);
                if(!isChosen)
                    return false;
                Student student = userRepository.getStudentInfo(Sno); //Student
                student.setPassword("noPassword");     //修改掉password,不让学生登录外院系的教务系统
                ChoiceVO choiceVO = new ChoiceVO(Cno, student, "0");  //ChoiceVO
                //给集成服务器发送xml
                String result="fail";
                String xml = xmlService.object2Xml(choiceVO);
                System.out.println("xml is "+xml);
                if(Cno.substring(0,1).equals("A")){  //选B院系的课
                    System.out.println("A");
                    result=xmlService.postRequest(xml,"http://localhost:8080/elective/C_choose_A");
                }
                else if(Cno.substring(0,1).equals("B")){  //选C院系的课
                    System.out.println("B");
                    result=xmlService.postRequest(xml,"http://localhost:8080/elective/C_choose_B");
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

    public boolean dropCourse(String Sno,String Cno)  {
        if(Cno.substring(0,1).equals("C"))          //退本院系的课
            return courseRepository.dropCourse(Sno,Cno);
        else{               //退外院系的课
            try {
                courseRepository.dropCourse(Sno,Cno);//删除在本院的数据库数据

                Student student=userRepository.getStudentInfo(Sno); //StudentVO
                ChoiceVO choice =new ChoiceVO(Cno,student,"0");  //ChoiceVO

                //给集成服务器发送xml
                String result="fail";
                String xml = xmlService.object2Xml(choice);
                if(Cno.substring(0,1).equals("A")){  //退A院系的课
                    result= xmlService.postRequest(xml,"http://localhost:8080/elective/C_drop_A");
                }
                else if(Cno.substring(0,1).equals("B")){  //选B院系的课
                    result=xmlService.postRequest(xml,"http://localhost:8080/elective/C_drop_B");
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

    public List<com.example.system_c.po.Course.CoursePO> getStudentCourse(String Sno){
        return courseRepository.getStudentCourse(Sno);
    }

    public List<com.example.system_c.po.Course.CoursePO> getAllCourse(){
        List<com.example.system_c.po.Course.CoursePO> courses= courseRepository.getAllCourse();
        return courses;
    }

    public boolean getOtherCourses(String type){    //获取外院系的共享课程，type是外院B或C。注意：此处要把外院系课程的share变为0后才能存入本地数据库
        try {
            String xml="";
            //获取其他两个院系的课
            //if (type.equals("B")) {   //获取外院B的共享课程
                //从集成服务器获取xml
            xml = xmlService.getRequest("http://localhost:8080/share/getSharedCourseForC");

           // } else if (type.equals("C")) {      //获取外院C的共享课程
                //从集成服务器获取xml
               // xml = xmlService.getRequest("http://localhost:8080/transfer/get_C_courses");
           // }
            //解析xml成CourseListVO对象
            System.out.println("GetOthersCourses...");
            System.out.println(xml);
            CourseListVO courseListVO= (CourseListVO) xmlService.xml2Object(xml,CourseListVO.class);
            //将课程数据存入本院数据库
            for(Course c:courseListVO.getCourseList()){
                courseRepository.addCourse(c.getCno(),c.getCname(),c.getTeacher(),c.getCredit(),c.getShare());
            }
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String shareCourses(){  //共享本院系的课程
        try {
            List<Course> courses = courseRepository.getSharedCourse();
            for (Course c : courses) {
                c.setShare("0");
            }
            //封装成大的xml文件，发送给集成服务器
            CourseListVO courseListVO=new CourseListVO(courses);
            String xml = xmlService.object2Xml(courseListVO);//大的xml文件
            System.out.println(xml);

//            String test=xmlService.getRequest("http://localhost:8080/transfer/get_test");
//            System.out.println("test is : "+test);

            return xml;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public String othersAddCourse(String xml){  //外院系学生的选课
        try {
            //解析xml文件，转成ChoiceVO对象
            ChoiceVO choiceVO= (ChoiceVO) xmlService.xml2Object(xml,ChoiceVO.class);
            //将外院系学生的信息加入本院系的学生表里，并把选课信息加入本院的选课表里(周沛辰写)
            //1.调用userRepository的addStudent接口
            Student student=choiceVO.getStudent();
            userRepository.addStudent(student.getAcc(),student.getPassword(),student.getSno(),student.getSname(),student.getSex());
            //2.调用courseRepository的chooseCourse接口
            courseRepository.chooseCourse(student.getSno(),choiceVO.getCno());
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }

    public String othersDeleteCourse(String xml){    //外院系学生的退课
        try {
            //解析xml文件，转成ChoiceVO对象(获取学生编号sno和课程编号cno即可)
            ChoiceVO choiceVO= (ChoiceVO) xmlService.xml2Object(xml,ChoiceVO.class);
            //调用dropCourse，若该学生没有选本院系的课了，则删除该学生的学生信息(周沛辰写)
            Student student=choiceVO.getStudent();
            courseRepository.dropCourse(student.getSno(),choiceVO.getCno());
            List<CoursePO> courses=courseRepository.getStudentCourse(student.getSno());
            if(courses.size()==0)
                userRepository.deleteStudent(student.getSno());
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }


}
