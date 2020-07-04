<template>
    <v-app id="keep">
        <v-dialog
            v-model="dialogErr"
            width="500">
                <v-card>
                    <v-card-title>{{errMsg}}</v-card-title>
                    <v-card-text>
                    <v-btn color="error" @click="dialogErr=false">确定</v-btn>
                    </v-card-text>
                </v-card>
        </v-dialog>
        <v-dialog
            v-model="dialogStudentClass"
            width="700">
                <v-card>
                    <v-card-title>{{studentName}}的课程</v-card-title>
                    <v-card-text>
                        <v-data-table
                                :headers="coursetHeaders"
                                :items="courseChosen"
                                :items-per-page="10"
                                class="elevation-1"
                        ></v-data-table>
                    </v-card-text>
                    <!-- <v-card-text>
                    <v-btn color="error" @click="dialogStudentClass=false">确定</v-btn>
                    </v-card-text> -->
                </v-card>
        </v-dialog>
        <v-app-bar
            app
            clipped-left
            color="amber"
            >
                <span class="title ml-3 mr-5">选课</span>
                <v-spacer />
                <v-spacer />
                <v-spacer />
        </v-app-bar>
        <v-content>
            <v-tabs
                centered
            >
                <v-tab>课程数据</v-tab>
                    <v-tab-item>
                        <v-data-table
                            :headers="coursetHeaders"
                            :items="courseData"
                            :items-per-page="10"
                            class="elevation-1"
                        ></v-data-table>
                    </v-tab-item>
                <v-tab>学生数据</v-tab>
                    <v-tab-item>
                        <v-text-field
                            v-model="search"
                            append-icon="mdi-magnify"
                            label="Search"
                            single-line
                            hide-details
                        ></v-text-field>
                        <v-data-table
                            :headers="studentHeaders"
                            :items="studentData"
                            :items-per-page="10"
                            class="elevation-1"
                            :search="search"
                        >
                            <template v-slot:item.check="props">
                                <v-icon @click="checkStudentClass(props.item.sno);studentName=props.item.sname">mdi-plus</v-icon>
                            </template>
                        </v-data-table>
                    </v-tab-item>
            </v-tabs>

            
        </v-content>
    </v-app>
</template>
<script>
import {showStatisticData} from "../request/api";
export default {
    name: 'mainpage',
    data(){
        return {
            courseData:[
                {cno: "A01", cname: "name1", teacher: "teacher01", credit: "1", count: 10},
                {cno: "A02", cname: "name2", teacher: "teacher02", credit: "1", count: 10},
                {cno: "A03", cname: "name3", teacher: "teacher03", credit: "1", count: 10}
            ],
            coursetHeaders:[
                { text: '课程编号', value: 'cno' },
                { text: '课程名', value: 'cname' },
                { text: '教师名', value: 'teacher' },
                { text: '学分', value: 'credit' },
                { text: '选课人数', value: 'count' },
            ],
            studentCourseData:[
                {sno:"1", sname: "haha",sex: "male", cno: "A01", cname: "name1", grade: "1", check: 0},
                {sno:"1", sname: "haha",sex: "male", cno: "A02", cname: "name2", grade: "1", check: 0},
                {sno:"2", sname: "leo",sex: "male", cno: "A01", cname: "name1", grade: "2", check: 0}
            ],
            studentHeaders: [
                        { text: '学生编号', value: 'sno',},
                        { text: '学生名', value: 'sname' },
                        { text: '性别', value: 'sex' },
                        { text: '年级', value: 'grade' },
                        { text: '查看所选课程', value: 'check'}
            ],
            studentData: [
                {sno:"1", sname: "haha",sex: "male", grade: "1", check: 0},
                {sno:"2", sname: "leo",sex: "male", grade: "2", check: 0}
            ],
            courseChosen: [
                {cno: "A01", cname: "name1", teacher: "teacher01", credit: "1", count: 10},
                {cno: "A01", cname: "name1", teacher: "teacher01", credit: "1", count: 10},
                {cno: "A01", cname: "name1", teacher: "teacher01", credit: "1", count: 10}
            ],
            dialogStudentClass: false,
            dialogErr: false,
            errMsg: "",
            search: "",
            studentName: "??",
            sno: 0
        }
    },
    methods: {
        checkStudentClass(sno){
            
            this.courseChosen = [];
            var _this = this;
            this.studentCourseData.forEach(item => {
                if(item.sno === sno){
                    let c = _this.courseData.find(course => course.cno === item.cno);
                    
                    _this.courseChosen.push(c);
                }
            })
            this.dialogStudentClass = true;
        }
    },
    mounted(){

        showStatisticData().then(res => {
            var _this = this;
            this.courseData = res.data.content.statisticCourseData.statisticCourseList;
            this.studentCourseData = res.data.content.statisticStudentData.studentList;
            this.studentData = [];
            this.studentCourseData.forEach(item => {
                item.check = 0;//用于多一个格子
                if(_this.studentData.findIndex(student => student.sno === item.sno) == -1){
                    let s = Object.assign({}, item);
                    delete s.cno;
                    delete s.cname;
                    _this.studentData.push(s);
                }
            })

        }).catch(err => {
            err;
            console.log(err);
            this.Alert("something went wrong1.");
        })
    }
}
</script>