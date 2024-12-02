<template>
  <div class="dicForm">
    <h1>Kanji Word Details</h1>
    <v-text-field label="Enter Kanji Word" v-model="kanji"></v-text-field>

    <v-btn class="searchBtn" @click="KanjiDetails()">
      <span v-if="!loading">Search</span>
      <v-progress-circular v-else indeterminate color="primary"></v-progress-circular>
    </v-btn>
    <div class="rmjword">Kanji Word: {{ this.kanji }}</div>
    <div v-if="found===false" class="kanjicolor">No Match word found</div>
    <div class="kanjiDetails">
      Pronounce: {{ details.rad_name_ja }}
      <br />
      Kunyomi:{{ details.kunyomi }}
      <br />
      Meaning: {{ details.meaning }}
      <br />
      History: {{ details.mn_hint }}
      <br />With Animation:
      <v-row>
        <v-col cols="2" v-for="(img,index) in animation " :key="index">
          <img :src="img" width="30%" />
        </v-col>
      </v-row>Examples:
      <br />
      <ul v-for="(example,index) in details.examples" :key="index">
        <li>
          {{ example.japanese }} : {{ example.meaning['english']}}
          <br />
          <audio controls class="player">
            <source :src="example.audio['mp3']" type="audio/mp3" />
          </audio>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import http from "../utils/http";

export default defineComponent({
  name: "RomajitoKanji",
  data: () => ({
    kanji: "",
    details: [],
    detailsEg: [],
    found: true,
    animation: [],
    loading: false,
  }),

  created() {
    this.kanji = this.getKanjiFromroute;
    if (this.kanji != "none") this.KanjiDetails(this.kanji);
    else {
      this.kanji = "";
    }
  },

  computed: {
    getKanjiFromroute() {
      return this.$route.params.kanji;
    },
  },

  methods: {
    async KanjiDetails() {
      this.loading = true;
      const resp = await http.getKanji(this.kanji);
      console.log(resp);
      if (resp) {
        const data = await resp.json();
        if (data) {
          this.details = data;
          this.animation = this.details.radical.animation;

          if (this.details.length == 0) this.found = false;
          else this.found = true;
        } else {
          console.log("error");
        }
        this.loading = false;
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
.kanjiword {
  margin-top: 1.5%;
  font-size: 30px;
}
.kanjiDetails {
  font-size: 25px;
  margin: 1%;
  line-height: 200%;
}
.player {
  padding: 0.5%;
}
</style>