<template>
  <div>
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
