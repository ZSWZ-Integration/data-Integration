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
        v-model="dialogEdit"
        width="800"
        persistent
        no-click-animation
    >
        <v-card>
            <v-card-title>编辑课程</v-card-title>
            <v-card-text>
                <v-form>
                    <v-text-field
                        v-model="classEditing.cname"
                        label="课程名称"
                        clearable
                        required
                        flat
                        outlined
                    ></v-text-field>
                    <v-text-field
                        v-model="classEditing.teacher"
                        label="课程教师"
                        clearable
                        required
                        flat
                        outlined
                    ></v-text-field>
                    <v-text-field
                        v-model="classEditing.credit"
                        label="学分"
                        clearable
                        required
                        flat
                        outlined
                    ></v-text-field>
                    <v-btn
                        class="mb-5"
                        color="success"
                        @click="confirmEdit"
                    >确定
                    </v-btn>
                    <v-btn
                        class="mr-5 ml-5 mb-5"
                        color="error"
                        @click="dialogEdit=false"
                    >取消
                    </v-btn>
                </v-form>
            </v-card-text>
        </v-card>
    </v-dialog>
    <v-dialog
        v-model="dialogNew"
        width="800"
        persistent
        no-click-animation
    >
        <v-card>
            <v-card-title>新建课程</v-card-title>
            <v-card-text>
                <v-form
                    v-model="valid"
                >
                    <v-text-field
                        v-model="newClass.cname"
                        label="课程名称"
                        :rules="nameRule"
                        clearable
                        required
                        flat
                        outlined
                    ></v-text-field>
                    <v-text-field
                        v-model="newClass.teacher"
                        label="课程教师"
                        :rules="teacherRule"
                        clearable
                        required
                        flat
                        outlined
                    ></v-text-field>
                    <v-text-field
                        v-model="newClass.credit"
                        label="学分"
                        :rules="creditRule"
                        clearable
                        required
                        flat
                        outlined
                    ></v-text-field>
                    <v-switch
                        v-model="newClass.share"
                        :label="newClass.share?('可共享'):('不可共享')"
                    ></v-switch>
                    <v-btn
                        class="mb-5"
                        color="success"
                        @click="confirmNew"
                        :disabled="!valid"
                    >确定
                    </v-btn>
                    <v-btn
                        class="mr-5 ml-5 mb-5"
                        color="error"
                        @click="cancelNew"
                    >取消
                    </v-btn>
                </v-form>
            </v-card-text>
        </v-card>
    </v-dialog>
    <v-app-bar
        app
        clipped-left
        color="amber"
    >
            <span class="title ml-3 mr-5">管理员</span>
            <v-spacer />
            <v-spacer />
            <v-spacer />
            <v-btn @click="logout">退出登录</v-btn>
    </v-app-bar>
     <v-content>
         <v-tabs>
            <v-tab>课程列表</v-tab>
            <v-tab-item>
                <v-simple-table>
                    <template v-slot:default>
                        <thead>
                            <tr>
                            <th class="text-left">课程名</th>
                            <th class="text-left">教师</th>
                            <th class="text-left">学分</th>
                            <th class="text-left">操作</th>                            
                            </tr>
                            
                        </thead>                    
                        <tbody>
                            <tr @click="dialogNew=true">
                                <td></td>
                                <td></td>
                                <td><v-icon>mdi-plus</v-icon></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr v-for="item in classes" :key="item.cno">
                                <td>{{ item.cname }}</td>
                                <td>{{ item.teacher }}</td>
                                <td>{{ item.credit }}</td>
                                <td>
                                     <div>
                                        <v-menu offset-y :disabled="!item.editable">
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn
                                            color="primary"
                                            dark
                                            v-bind="attrs"
                                            v-on="on"
                                            v-if="item.editable"
                                            >
                                            <v-icon>mdi-wrench</v-icon>
                                            </v-btn>
                                        </template>

                                        <v-list>
                                            <v-list-item 
                                                @click="updateClass(item.cno)"                                           
                                            >
                                            <v-list-item-title>编辑</v-list-item-title>
                                            </v-list-item>
                                            <v-list-item   
                                                @click="deleteClass(item.cno)"                                         
                                            >
                                            <v-list-item-title>删除</v-list-item-title>
                                            </v-list-item>
                                        </v-list>
                                        </v-menu>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </template>
                </v-simple-table>
                
            </v-tab-item>
            <v-tab>获取共享课程</v-tab>
            <v-tab-item>
                    <v-col cols="6"> <v-btn @click="getShare('A')">获取A院系课程</v-btn></v-col>
                    <v-col cols="6"> <v-btn @click="getShare('C')">获取C院系课程</v-btn></v-col>
                    <v-col cols="6"> <v-btn @click="checkShare('A')">查看A院系共享课程数量</v-btn></v-col>
                    <v-col cols="6"> <v-btn @click="checkShare('C')">查看C院系共享课程数量</v-btn></v-col>
                
            </v-tab-item>
               
         </v-tabs>
     </v-content>
</v-app>
</template>
<script>
import {deleteCourse, updateCourse, addCourse, getShareCoursesNum1, getShareCoursesNum2, getAllCourses, getOtherCourses} from "../request/api";
export default {
    data(){
        return {
            classes: [
                {cno: "1", cname: "数据集成", teacher: "刘峰", credit: "1", share: "0", couldChoose: true},
                {cno: "2", cname: "数据集成2", teacher: "刘峰2", credit: "2", share: "1", couldChoose: true},
                {cno: "3", cname: "数据集成3", teacher: "刘峰3", credit: "3", share: "0", couldChoose: true},
                {cno: "4", cname: "数据集成4", teacher: "刘峰4", credit: "4", share: "0", couldChoose: false},
            ],
            errMsg: "",
            dialogErr: false,
            dialogEdit: false,
            dialogNew: false,
            //正被编辑的课程
            classEditing: {},
            //新课程
            newClass:{},
            valid: false,
            nameRule: [
                v => !!v || "请填写课程名称"
            ],
            teacherRule: [
                v => !!v || "请填写教师名称"
            ],
            creditRule: [
                v => !!v || "请填写学分",
                v => !isNaN(v) || "学分应为数值",
                v => Number.isInteger(Number(v)) || "学分应为整数"
            ],
        }
    },
    methods: {
        updateClass(cno){
            //TODO:
            this.dialogEdit = true;
            var c = this.classes.filter(item => item.cno == cno)[0];
            this.classEditing = JSON.parse(JSON.stringify(c));
            
        },
        deleteClass(cno){
            deleteCourse(cno).then(res => {
                if(res.data.content == true){
                    this.classes = this.classes.filter(item => item.cno != cno);
                    this.Alert("删除成功");
                }else {
                    this.Alert("删除失败");
                }
            }).catch(err => {
            
                this.Alert("something went wrong.");
                err;
            })
        },
        Alert(msg){
            this.errMsg = msg;
            this.dialogErr = true;
        },
        confirmEdit(){
            //TODO:点击后不能关闭dialog
            this.dialogEdit = false;
            var c = this.classEditing;
            updateCourse(c).then(res => {
                if(res.data.content == true){
                    this.Alert("更新成功");
                    //将本地的列表修改
                    this.classes.forEach(item => {
                    if(item.cno == c.cno){
                        item.cname = c.cname;
                        item.teacher = c.teacher;
                        item.ctime = c.ctime;
                        item.credit = c.credit;
                    }
            })
                }else {
                    this.Alert("更新失败");
                }
            }).catch(err => {
                this.Alert("something went wrong.");
                err;
            });
            
            
        },
        confirmNew(){
            this.dialogNew = false;
            this.newClass.ctype = "A";
            if(this.newClass.share){
                this.newClass.share = "1"
            }else {
                this.newClass.share = "0"
            }
            console.log(this.newClass);
            addCourse(this.newClass).then(res => {
                if(res.data.content == true){
                    this.Alert("添加成功");
                    this.newClass = {};
                    this.getClasses();
                }else {
                    this.Alert("添加失败")
                    this.newClass = {};
                }
            }).catch(err => {
                err;
                this.Alert("something went wrong.");
                this.newClass = {};
            })
        },
        cancelNew(){
            this.newClass = {};
            this.dialogNew = false;
        },
        getShare(type){
            getOtherCourses(type).then(res => {
                if(res.data.content == true){
                    this.Alert("成功");
                    this.getClasses();
                }else {
                    this.Alert("失败")
                }
            }).catch(err => {
                err;
                this.Alert("Something went wrong.");
            })
        },
        getClasses(){
            getAllCourses().then(res => {
                this.classes = res.data.content;
                console.log("getAllCourses result:");
                console.log(res.data);
                this.classes.forEach(course => {
                if(course.cno.substring(0, 1) == "C"){
                    course.editable = true;
                }else {
                    course.editable = false;
                }
            })
            }).catch(err => {
                err;
                this.Alert("something went wronge.");
            })
        },
        logout(){
            this.$store.commit("setUserId", 0);
            this.$router.push('/adminLogin');
        },
        checkShare(type){
            if(type == "A"){
                getShareCoursesNum1().then(res => {
                     this.Alert(res.data.content);
                }).catch(err => {
                        err;
                        this.Alert("something went wronge.");
                });
            }else {
                getShareCoursesNum2().then(res => {
                     this.Alert(res.data.content);
                }).catch(err => {
                        err;
                        this.Alert("something went wronge.");
                });
            }
        }
    },
    mounted(){
        this.getClasses();
    }
}
</script>