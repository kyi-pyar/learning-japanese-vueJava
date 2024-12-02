<template>
  <v-sheet class="mx-auto" max-width="300">
    <v-form>
      <v-text-field v-model="email" :rules="rules" label="email"></v-text-field>
      <v-text-field v-model="password" :rules="rules" label="Password" input="password"></v-text-field>
      <v-btn :loading="loading" class="mt-2" text="Login" block @click="login()"></v-btn>
      <v-label>{{ msg }}</v-label>
      <br />
      <router-link
        to="/registration"
        style="color: red; margin-left: 35%; margin-top: 50px;"
      >registeration</router-link>
    </v-form>
  </v-sheet>
</template>
<script>
import { defineComponent } from "vue";
import http from "../utils/http";

export default defineComponent({
  name: "RegistrationView",
  data: () => ({
    loading: false,
    email: "",
    password: "",
    msg: "",
    token: "",
  }),

  methods: {
    // async submit(event) {
    async login() {
      this.loading = true;

      console.log("hello ");

      const resp = await http.loginAuth("/login", {
        email: this.email,
        password: this.password,
      });
      if (resp) {
        this.loading = false;
        if (resp.status == 200) {
          const data = await resp.json();
          this.token = data.token;
          console.log("Token is", this.token);
          localStorage.setItem("token", this.token);

          this.$store.dispatch("saveUser", this.email);
        } else if (resp.status == 403) {
          this.msg = "email and password does not match";
        } else this.$router.push({ path: "/takeExam" });
      } else console.log(resp);

      // alert(JSON.stringify(results, null, 2));
    },
  },
});
</script>