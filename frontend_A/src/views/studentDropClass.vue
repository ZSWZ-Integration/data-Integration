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
            <span class="title ml-3 mr-5">课程退选</span>
            <v-spacer />
            <v-spacer />
            <v-spacer />
            <v-btn @click="toChoose">选课</v-btn>
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
                    <th class="text-left">退选</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="item in classes" :key="item.cno">
                        <td>{{ item.cname }}</td>
                        <td>{{ item.teacher }}</td>
                        <td>{{ item.ctime }}</td>
                        <td>{{ item.credit }}</td>
                        <td><v-btn @click="dropClass(item.cno)">退选</v-btn></td>
                    </tr>
                </tbody>
            </template>
        </v-simple-table>
     </v-content>
</v-app>

</template>
<script>
import {GetStudentCourse, dropCourse} from "../request/api";
export default {
    data() {
        return {
            classes: [
                {cno: "1", cname: "数据集成", teacher: "刘峰", ctime: "2019-01-01", credit: "1", share: "0", ctype: "b"},
                {cno: "2", cname: "数据集成2", teacher: "刘峰2", ctime: "2019-01-02", credit: "2", share: "1", ctype: "c"},
                {cno: "3", cname: "数据集成3", teacher: "刘峰3", ctime: "2019-01-03", credit: "3", share: "0", ctype: "a"},
                {cno: "4", cname: "数据集成4", teacher: "刘峰4", ctime: "2019-01-04", credit: "4", share: "0", ctype: "a"},
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
        dropClass(cno){
            
            dropCourse(cno, this.sno).then(res => {
                if(res.data.content == true){
                    this.classes = this.classes.filter(item => item.cno != cno);
                    this.Alert("退课成功");
                }else {
                    this.Alert("退课失败")
                }
            }).catch(err => {
                err;
                this.Alert("something went wronge.");
            })
        },
        toChoose(){
            this.$router.push("/student");
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
        GetStudentCourse(this.sno).then(res => {
            this.classes = res.data.content;
        }).catch(err => {
            err;
            console.log(err);
            this.Alert("something went wronge.");
        })
    }
}
</script>