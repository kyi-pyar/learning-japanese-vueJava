<template>
  <div class="dicForm">
    <h1>Dictionay for Romaji to Kanji</h1>
    <v-text-field label="Enter Romaji Word" v-model="romaji"></v-text-field>

    <v-btn class="searchBtn" @click="ConvertoKanji()" :disabled="loading">
      <v-progress-circular v-if="loading" :size="30" :width="3" color="red" indeterminate></v-progress-circular>
      <span v-else>Search</span>
    </v-btn>

    <div class="rmjword">Romaji Word: {{ this.romaji }}</div>
    <div v-if="found===false" class="kanjicolor">No Match word found</div>

    <div class="kanjiword">
      <v-row>
        <v-col cols="12" v-for="(word,index) in kanji" :key="index">
          Kanji:
          <span class="kanjicolor">{{ word.kanji.character }}</span>
          <span>
            &nbsp; &nbsp; &nbsp; &nbsp;
            <router-link
              class="link"
              :to="{ name: 'KanjiDetail', params: { kanji: word.kanji.character } }"
            >details</router-link>
          </span>
          <br />
          stroke:{{ word.kanji.stroke }}
        </v-col>
      </v-row>
    </div>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import http from "../utils/http";

export default defineComponent({
  name: "RomajitoKanji",
  data: () => ({
    romaji: "",
    kanji: [],
    found: true,
    loading: false,
  }),

  created() {
    this.kanji = "";
  },
  methods: {
    async ConvertoKanji() {
      this.loading = true;
      const resp = await http.get("kun=" + this.romaji);

      if (resp) {
        const data = await resp.json();
        if (data) {
          this.kanji = data;
          if (this.kanji.length == 0) this.found = false;
          else this.found = true;
          this.loading = false;
        } else {
          console.log("error");
        }
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
  background-color: #cc2b52;
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
.link {
  font-size: 20px;
  font-style: italic;
}
</style>