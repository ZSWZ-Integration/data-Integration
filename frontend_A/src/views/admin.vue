<template>
<v-app id="keep">
    <v-app-bar
        app
        clipped-left
        color="amber"
    >
            <span class="title ml-3 mr-5">用户名</span>
            <v-spacer />
            <v-spacer />
            <v-spacer />
            <v-btn @click="logout">课程退选</v-btn>
            <v-btn @click="logout">退出登录</v-btn>
    </v-app-bar>
     <v-content>
         <v-tabs>
            <v-tab>课程列表</v-tab>
            <v-tab>获取共享课程</v-tab>
            <v-tab>学生选课情况</v-tab>
         </v-tabs>
     </v-content>
</v-app>
</template>
<script>
export default {
    data(){
        return {

        }
    },
    methods: {
        
    }
}
</script>