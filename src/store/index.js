import { createStore } from 'vuex'

export default createStore({
  state: {
    user: null
  },
  getters: {
    isLoggedIn: (state) => !!state.user, // Return true if the user is logged in
    getUser: (state) => state.user
  },
  mutations: {
    setUser(state, user) {
      state.user = user
    },
    clearUser(state) {
      state.user = null
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
