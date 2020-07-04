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
    <v-app-bar
        app
        clipped-left
        color="amber"
        >
            <span class="title ml-3 mr-5">选课</span>
            <v-spacer />
            <v-spacer />
            <v-spacer />
            <v-btn @click="toDrop">课程退选</v-btn>
            <v-btn @click="logout">退出登录</v-btn>
    </v-app-bar>
     <v-content>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                    <tr>
                    <th class="text-left">课程名</th>
                    <th class="text-left">教师</th>
                    <th class="text-left">课程时间</th>
                    <th class="text-left">学分</th>
                    <th class="text-left">选课</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="item in classes" :key="item.cno">
                        <td>{{ item.cname }}</td>
                        <td>{{ item.teacher }}</td>
                        <td>{{ item.ctime }}</td>
                        <td>{{ item.credit }}</td>
                        <td>
                            <v-btn 
                                @click="chooseClass(item.cno)"
                                v-if="item.couldChoose"
                            >选课</v-btn>
                            <v-btn
                                v-else
                                disabled
                            >非共享课</v-btn>
                        </td>
                    </tr>
                </tbody>
            </template>
        </v-simple-table>
     </v-content>
</v-app>

</template>
<script>
import {getAllCourses, chooseCourse} from "../request/api";
export default {
    data() {
        return {
            //couldChoose为是否可以选，主要判断share和cno中的type，如果是非本院且share为0，则不可选，其他情况都可选
            classes: [
                {cno: "1", cname: "数据集成", teacher: "刘峰", ctime: "2019-01-01", credit: "1", share: "0", ctype: "b", couldChoose: true},
                {cno: "2", cname: "数据集成2", teacher: "刘峰2", ctime: "2019-01-02", credit: "2", share: "1", ctype: "c", couldChoose: true},
                {cno: "3", cname: "数据集成3", teacher: "刘峰3", ctime: "2019-01-03", credit: "3", share: "0", ctype: "a", couldChoose: true},
                {cno: "4", cname: "数据集成4", teacher: "刘峰4", ctime: "2019-01-04", credit: "4", share: "0", ctype: "a", couldChoose: false},
            ],
            errMsg: "",
            dialogErr: false,
            sno: 0//学生编号
        }
    },
    methods:{
        Alert(msg){
        this.errMsg = msg;
        this.dialogErr = true;
        },
        haha(msg){
            console.log(msg);
        },
        chooseClass(cno){
            chooseCourse(cno, this.sno).then(res => {
                if(res.data.content == true){
                    this.Alert("选课成功");
                }else {
                    this.Alert("此课已选，不可重复选课")
                }
            }).catch(err => {
                err;
                this.Alert("something went wronge.");
            })
        },
        toDrop(){
            this.$router.push("/studentDropClass");
        },
        logout(){
            this.$store.commit("setUserId", 0);
            this.$router.push('/login');
        }

    }, mounted(){
        this.sno = this.$store.getters.userId;
        if(this.sno == 0){
            this.$router.push("/login");
        }
        
        getAllCourses().then(res => {
            this.classes = res.data.content;
            this.classes.forEach(course => {
                //判断课程是否可选，非本院且share为0则不可选。
                // if(course.cno.substring(0, 1) != "A" && course.share == "0"){
                //     course.couldChoose = false;
                // }else {
                //     course.couldChoose = true;
                // }
                //所有看得见的都可选
                course.couldChoose = true;
            })
        }).catch(err => {
            err;
            console.log(err);
            this.Alert("something went wrong1.");
        })
    }
}
</script>