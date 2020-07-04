import Vue from 'vue'
import VueRouter from 'vue-router'
//import HalouCao from '@/views/HalouCao'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    // name: 'HalouCao',
    // component: HalouCao
    redirect: "/login"
  }, {
    path: '/login',
    name: 'Login',
    component: () => import("@/views/login.vue"),
    meta: {
      title: "登陆",
      keepAlive: true
    }
  }, {
    path: '/adminLogin',
    name: 'AdminLogin',
    component: () => import("@/views/AdminLogin.vue"),
    meta: {
      title: "管理员登录",
      keepAlive: true
    }
  }, {
    path: '/student',
    name: 'student',
    component: () => import("@/views/student.vue"),
    meta: {
      title: "student",
      keepAlive: true
    }
  },{
    path: '/admin',
    name: 'admin',
    component: () => import("@/views/admin.vue"),
    meta: {
      title: "admin",
      keepAlive: true
    }
  },{
    path: '/studentDropClass',
    name: 'studentDropClass',
    component: () => import("@/views/studentDropClass.vue"),
    meta: {
      title: "退选",
      keepAlive: true
    }
  },{
    path: '/404',
    name: 'faid',
    component: () => import('@/views/404.vue'),
    meta: {
      title: "404",
      keepAlive: true
    }
  }, {
    path: '*',
    redirect: "/404"
  }
]

const router = new VueRouter({
  routes
})

export default router
