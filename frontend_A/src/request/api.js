import { get} from './http'

/**
 * 获取全部课程，其中可能包含非共享课程
 */
export const getAllCourses = () => get("/getAllCourses");

/**
 * 选课
 * @param {*} cno 
 * @param {*} sno 
 */
export const chooseCourse = (cno, sno) => get("/chooseCourse", {cno, sno});

/**
 * 获得某个学生所有已选课列表
 * @param {*} sno 
 */
export const GetStudentCourse = (sno) => get("/GetStudentCourses", sno);

/**
 * 学生退选某课
 * @param {*} cno 
 * @param {*} sno 
 */
export const dropCourse = (cno, sno) => get("/dropCourse", {cno, sno});

/**
 * 删除某个课程
 * @param {*} cno 
 */
export const deleteCourse = (cno) => get("/deleteCourse", cno);

/**
 * 更新课程
 * @param {} course 
 */
export const updateCourse = (course) => get("/updateCourse", course.cno, course.cname, course.ctime, course.teacher, course.credit, course.type, course.share)

/**
 * 添加课程
 * @param {*} course 
 */
export const addCourse = (course) => get("/addCourse", course.cname, course.ctime, course.teacher, course.credit, course.type, course.share)

