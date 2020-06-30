import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userId: 0,
  },
  mutations: {
    
    setUserId(state, id) {
      state.userId = id;
      localStorage.userId = id;
    },
   
  },
  actions: {
  },
  modules: {
  },
  getters: {
    userId(state) {
      if (!state.userId || state.userId == 0) {
        state.userId = localStorage.getItem('userId');
      }
      return state.userId;
    },
  }
})
