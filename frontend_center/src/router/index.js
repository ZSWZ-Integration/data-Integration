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
    path: '/MainPage',
    name: 'MainPage',
    component: () => import("@/views/MainPage.vue"),
    meta: {
      title: "主界面",
      keepAlive: true
    }
  }, {
    path: '/login',
    name: 'AdminLogin',
    component: () => import("@/views/AdminLogin.vue"),
    meta: {
      title: "管理员登录",
      keepAlive: true
    }
  }, {
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
