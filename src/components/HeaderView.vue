<template>
  <v-app-bar height="100" color="#AF1740">
    <v-label class="logo">Learning Japanese in General</v-label>
    <v-spacer></v-spacer>
    <!-- <v-btn icon >
        
    </v-btn>-->
    <router-link to="/login">
      <v-icon class="login" v-if="!isLoggedIn" icon="fa:fas fa-user"></v-icon>
    </router-link>

    <v-menu>
      <!-- Activator button -->
      <template v-slot:activator="{ props }">
        <!-- <v-btn v-if="isLoggedIn" v-bind="props" color="primary" dark>Profile</v-btn> -->
        <v-icon
          class="login"
          v-if="isLoggedIn"
          icon="fa:fas fa-user-check"
          v-bind="props"
          color="primary"
          dark
        ></v-icon>
      </template>

      <!-- Dropdown menu -->
      <v-list>
        <v-list-item @click="goToAboutMe">
          <v-list-item-title>About Me</v-list-item-title>
        </v-list-item>
        <v-list-item @click="logout">
          <v-list-item-title>Logout</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <!-- <router-link to="/aboutMe">
      <v-icon class="login" v-if="isLoggedIn" icon="fa:fas fa-user-check"></v-icon>
    </router-link>-->
  </v-app-bar>
</template>
<script>
import { defineComponent } from "vue";
import { mapGetters } from "vuex";

export default defineComponent({
  name: "HeaderView",
  computed: {
    ...mapGetters(["isLoggedIn"]),
  },
  methods: {
    goToAboutMe() {
      this.$router.push("/aboutMe");
    },
    logout() {
      this.$store.dispatch("logOut");
      localStorage.removeItem("token");
      this.$router.push("/");
    },
  },
});
</script>
<style>
.logo {
  color: black;
  font-weight: bold;
  font-size: 40px;
  padding-top: 100px;
  padding-bottom: 80px;
  margin-left: 30px;
}
.login {
  margin-right: 30px;
  color: black;
  font-size: 35px;
}
.menu {
  margin-top: 30px;
}
</style>