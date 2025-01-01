<template>
  <v-app-bar height="100" color="#AF1740">
    <v-label class="logo">Learning Japanese in General</v-label>
    <v-spacer></v-spacer>
    <!-- <v-btn icon >
        
    </v-btn>-->
    <router-link to="/login">
      <v-icon @click="editMemo" icon="fa:fas fa-user"></v-icon>
    </router-link>
  </v-app-bar>
</template>
<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "HeaderView",
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
</style>