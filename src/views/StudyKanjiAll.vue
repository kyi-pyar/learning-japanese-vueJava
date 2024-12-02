<template>
  <div class="dicForm">
    <v-progress-circular v-if="loading" indeterminate color="primary" style="margin-left: 40%; ;"></v-progress-circular>
    <v-data-table v-else :headers="headers" :items="kanjiall" class="elevation-1">
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Study Kanji with Examples</v-toolbar-title>
        </v-toolbar>
      </template>
      <template v-slot:[`item.action`]="{ item }">
        <router-link :to="{ name: 'KanjiDetail', params: { kanji: item.ka_utf } }">details</router-link>
      </template>
    </v-data-table>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import http from "../utils/http";

export default defineComponent({
  name: "RomajitoKanji",
  data: () => ({
    headers: [
      { title: "Kanji", value: "ka_utf" },
      { title: "Pronounce", value: "rad_name_ja" },
      { title: "Kunyomi", value: "kunyomi" },
      { title: "Meaning", value: "meaning" },
      { text: "Actions", value: "action", sortable: false },
    ],
    kanjiall: [],
    loading: true,
  }),

  async created() {
    const resp = await http.getKanji("all");
    if (resp) {
      const data = await resp.json();
      if (data) {
        this.kanjiall = data;
      } else {
        console.log("error");
      }
    }
    this.loading = false;
  },
});
</script>

<style>
.dicForm {
  margin-top: 3%;
  margin-left: -15%;
  margin-right: 5%;
}
.player {
  padding: 0.5%;
}
</style>