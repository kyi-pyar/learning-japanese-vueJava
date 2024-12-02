<template>
  <v-navigation-drawer permanent class="nav">
    <v-list-item title="Dictionay" subtitle="translation"></v-list-item>
    <v-divider></v-divider>
    <v-list-item link to="engKan" title="English to Kanji"></v-list-item>
    <v-list-item link to="rmjKan" title="Romaji to Kanji"></v-list-item>
    <v-list-item
      link
      :to="{ name: 'KanjiDetail', params: { kanji:'none' } }"
      title="Kanji Word Details"
    ></v-list-item>
    <v-list-item link to="kjall" title="Study Kanji"></v-list-item>
    <v-list-item v-if="isLoggedIn" link to="aboutMe" title="About me"></v-list-item>
  </v-navigation-drawer>
</template>
<script>
import { defineComponent } from "vue";
import { mapGetters } from "vuex";

export default defineComponent({
  name: "NavigationDrawer",

  computed: {
    ...mapGetters(["isLoggedIn"]),
  },
  watch: {},
});
</script>
<style>
.nav {
  margin-top: 2%;
}
</style>