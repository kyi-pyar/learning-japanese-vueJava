import { createStore } from 'vuex'

export default createStore({
  state: {
    user: null,
    isLogin: false
  },
  getters: {
    isLoggedIn: (state) => state.isLogin, //!!state.user, // Return true if the user is logged in
    getUser: (state) => state.user
  },
  mutations: {
    setUser(state, user) {
      state.user = user
      state.isLogin = true
    },
    clearUser(state) {
      state.user = null
      state.isLogin = false
    }
  },
  actions: {
    saveUser({ commit }, user) {
      commit("setUser", user);
    },
    logOut({ commit }) {
      commit("clearUser");
    }
  },
  modules: {
  }
})
