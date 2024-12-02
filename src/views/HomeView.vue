<template>
  <div>
    <!-- <v-row>
      <v-col cols="2">
        <NavigationDrawer></NavigationDrawer>
      </v-col>
      <v-col cols="10"><WelcomePage /></v-col>
    </v-row>-->
    <WelcomePage />
  </div>
</template>

<script>
import { defineComponent } from "vue";

// Components
import WelcomePage from "../components/WelcomePage.vue";
// import NavigationDrawer from'../components/NavigationDrawer.vue';

export default defineComponent({
  name: "HomeView",

  components: {
    WelcomePage,

    // NavigationDrawer
  },
});
</script>
