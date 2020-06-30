import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from './router'
import store from './store'

// highlight.js代码高亮插件
import Highlight from './plugins/highlight'; // from 路径是highlight.js的路径，纯属自定义

Vue.config.productionTip = false

new Vue({
  vuetify,
  render: h => h(App),
  store,
  router
}).$mount('#app')

Vue.use(Highlight);