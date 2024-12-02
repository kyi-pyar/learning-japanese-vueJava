<template>
  <div class="dicForm">
    <h1>Registeration</h1>

    <v-text-field label="Email" v-model="email"></v-text-field>
    <v-text-field label="Password" v-model="password" type="password"></v-text-field>
    <v-text-field label="Full Name" v-model="fullname"></v-text-field>

    <v-btn class="searchBtn" @click="SignupAuth()">Signup</v-btn>
  </div>
</template>
  <script>
import { defineComponent } from "vue";
import http from "../utils/http";

export default defineComponent({
  name: "RegistrationView",
  data: () => ({
    email: "",
    password: "",
    fullname: "",
    userData: {},
  }),

  methods: {
    async SignupAuth() {
      const resp = await http.authSingup("/signup", {
        email: this.email,
        password: this.password,
        fullName: this.fullname,
      });
      if (resp) {
        const data = await resp.json();
        this.userData.email = data.email;
        this.userData.fullName = data.fullName;
        this.userData.id = data.id;
        this.$store.dispatch("saveUser", this.userData);
        this.$router.push({ path: "/userInfo" });
      }
    },
  },
});
</script>
  
  <style>
.dicForm {
  margin-top: 3%;
  margin-left: -15%;
  margin-right: 5%;
}
.searchBtn {
  background-color: rgb(190, 0, 0);
  font-family: "Courier New, Courier, monospace";
  font-size: 30px;
  margin-left: 40%;
  width: 20%;
}
.rmjword {
  margin-top: 1%;
  font-size: 30px;
}
.kanjiword {
  margin-top: 1.5%;
  font-size: 30px;
}
.kanjicolor {
  color: rgb(190, 0, 0);
}
</style>