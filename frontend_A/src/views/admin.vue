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
            <span class="title ml-3 mr-5">用户名</span>
            <v-spacer />
            <v-spacer />
            <v-spacer />
            <v-btn>退出登录</v-btn>
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
                            <th class="text-left">课程时间</th>
                            <th class="text-left">学分</th>
                            <th class="text-left">操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="item in classes" :key="item.cno">
                                <td>{{ item.cname }}</td>
                                <td>{{ item.teacher }}</td>
                                <td>{{ item.ctime }}</td>
                                <td>{{ item.credit }}</td>
                                <td>
                                     <div class="text-center">
                                        <v-menu offset-y>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn
                                            color="primary"
                                            dark
                                            v-bind="attrs"
                                            v-on="on"
                                            >
                                            Dropdown
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
            <v-tab>学生选课情况</v-tab>
         </v-tabs>
     </v-content>
</v-app>
</template>
<script>
import {deleteCourse} from "../request/api";
export default {
    data(){
        return {
            classes: [
                {cno: "1", cname: "数据集成", teacher: "刘峰", ctime: "2019-01-01", credit: "1", share: "0", ctype: "b"},
                {cno: "2", cname: "数据集成2", teacher: "刘峰2", ctime: "2019-01-02", credit: "2", share: "1", ctype: "c"},
                {cno: "3", cname: "数据集成3", teacher: "刘峰3", ctime: "2019-01-03", credit: "3", share: "0", ctype: "a"},
                {cno: "4", cname: "数据集成4", teacher: "刘峰4", ctime: "2019-01-04", credit: "4", share: "0", ctype: "a"},
            ],
            errMsg: "",
            dialogErr: false,
        }
    },
    methods: {
        updateClass(cno){
            cno;
            //TODO:
        },
        deleteClass(cno){
            deleteCourse(cno).then(res => {
                if(res.data == true){
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
        }
    }
}
</script>