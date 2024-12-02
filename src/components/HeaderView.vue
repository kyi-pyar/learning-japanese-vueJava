<template>
 
    <v-app-bar height="100" color="rgb(120,0,0)">
      <v-label class="logo">Japanese Learning</v-label>
      <v-spacer></v-spacer>
      <!-- <v-btn icon >
        
      </v-btn> -->
      <router-link to="/login"><v-icon>mdi-login</v-icon></router-link>

      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
    </v-app-bar>
   
  
</template>
<script>
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'HeaderView',
  });
</script>
<style>
.logo{
  color:black;
  font-weight: bold;
  font-size: 40px;
  padding-top: 100px;
  padding-bottom: 80px;
}
</style>