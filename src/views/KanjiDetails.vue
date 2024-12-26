<template>
  <div class="dicForm">
    <h1>Kanji Word Details</h1>
    <v-text-field label="Enter Kanji Word" v-model="kanji"></v-text-field>

    <v-btn class="searchBtn" @click="KanjiDetails()">
      <span v-if="!loading">Search</span>
      <v-progress-circular v-else indeterminate color="primary"></v-progress-circular>
    </v-btn>
    <div class="rmjword">Kanji Word: {{ this.kanji }}</div>
    <v-row>
      <v-col cols="12" v-for="(each,each_index) in details " :key="each_index">
        <div v-if="found===false " class="kanjicolor">No Match word found</div>

        <v-card color="#DE7C7D">
          <v-card-title>{{ this.input_kanji_words[each_index] }}</v-card-title>
          <v-card-text>
            <div v-if="animation.length >0 " class="kanjiDetails">
              Pronounce: {{ each.kunyomi_ja }}
              <br />
              Kunyomi: {{ each.kunyomi }}
              <br />
              Meaning: {{ each.meaning }}
              <br />
              Hint: {{ each.mn_hint }}
              <br />
              Writing:
              {{ each.image }}
              <v-row>
                <v-col cols="2" v-for="(stroke,index) in images[each_index].image " :key="index">
                  <img :src="stroke" width="30%" />
                </v-col>
              </v-row>
              <br />With Animation:
              <v-row>
                <v-col cols="2" v-for="(img,index) in animation[each_index].ani " :key="index">
                  <img :src="img" width="30%" />
                </v-col>
              </v-row>Examples:
              <br />
              <ul v-for="(example,index) in each.examples" :key="index">
                <li>
                  {{ example.japanese }} : {{ example.meaning['english']}}
                  <br />
                  <audio controls class="player">
                    <source :src="example.audio['mp3']" type="audio/mp3" />
                  </audio>
                </li>
              </ul>
            </div>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
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
    images: [],
    animation: [],
    loading: false,
    input_kanji_words: [],
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
      this.Countword();
      for (let i = 0; i < this.input_kanji_words.length; i++) {
        console.log("i is", i);
        const resp = await http.getKanji(this.input_kanji_words[i]);
        if (resp) {
          const data = await resp.json();
          if (data) {
            this.details[i] = data;
            if (this.details[i].radical) {
              // Ensure `this.animation` is initialized as an array
              if (!this.animation) {
                this.animation = [];
              }

              // Ensure the `i`th index is initialized as an object
              if (!this.animation[i]) {
                this.animation[i] = {}; // Initialize as an empty object
              }

              if (!this.images) {
                this.images = [];
              }

              // Ensure the `i`th index is initialized as an object
              if (!this.images[i]) {
                this.images[i] = {}; // Initialize as an empty object
              }

              this.animation[i].ani = this.details[i].radical.animation;
              this.images[i].image = this.details[i].kanji.strokes.images;
              this.found = true;
            } else this.found = false;
          } else {
            console.log("error");
          }
          this.loading = false;
        }
      }
    },

    Countword() {
      const kanjiRegex = /[\u4E00-\u9FAF]/g;
      const input = this.kanji;
      this.input_kanji_words = input.match(kanjiRegex) || [];
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
.kanjiword {
  margin-top: 1.5%;
  font-size: 30px;
}
.kanjiDetails {
  font-size: 18px;
  margin: 1%;
  line-height: 150%;
}
.player {
  padding: 0.5%;
}
</style>