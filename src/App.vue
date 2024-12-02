<template>
  <v-app>
    <v-main>
      <HeaderView/>      
      
      <v-row>
      <v-col cols="2">
        <NavigationDrawer></NavigationDrawer>
      </v-col>
      <v-col cols="10"><router-view/></v-col>
    </v-row>
    </v-main>
  </v-app>
</template>

<script>
import HeaderView from './components/HeaderView.vue'
import NavigationDrawer from './components/NavigationDrawer.vue'
export default {
  name: 'App',
  components:{
    HeaderView,
    NavigationDrawer
  },

  data: () => ({
    //
  }),
}
</script>
