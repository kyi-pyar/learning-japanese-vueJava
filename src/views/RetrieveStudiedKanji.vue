<template>
  <v-container>
    <h1>
      <center>~~~~~~ Memorized Kanji ~~~~~~</center>
    </h1>
    <br />

    <div ref="masonryGrid" class="masonry-grid">
      <div v-for="(each,index) in memorizedwords" :key="index">
        <v-card class="masonry-item" :style="{ backgroundColor: each.color, color: 'brown', }">
          <v-card-title>{{ each.word }}</v-card-title>
          <v-card-text>{{ truncateText(each.memo,20) }}</v-card-text>
          <v-card-actions class="actions">
            <v-btn @click="detailsKanji(each)">details</v-btn>
            <v-icon @class="trash" @click="deleteWord(each)" icon="fa-solid fa-trash"></v-icon>
          </v-card-actions>
        </v-card>
      </div>
    </div>
  </v-container>
</template>
    
    <script>
import http from "../utils/http";
export default {
  name: "RetrieveStudiedKanji",

  data: () => ({
    words: [],
    memorizedwords: [],
    numberOfCards: 0,
    word: [],
  }),

  async created() {
    await this.getKanjiwords();
    this.initializeCartColors();
  },

  methods: {
    async getKanjiwords() {
      const resp = await http.getStudiedKanji(
        "/getAll/" + this.$store.getters.getUser.id
      );
      if (resp) {
        const data = await resp.json();
        this.words = data;
        console.log("data from bend", this.words);
      } else {
        console.log("error");
      }
    },
    generateHexColor() {
      const letters = "0123456789ABCDEF";
      let color = "#888";
      for (let i = 0; i < 3; i++) {
        color += letters[Math.floor(Math.random() * 16)];
      }

      return color;
    },

    initializeCartColors() {
      this.numberOfCards = this.words.length;
      console.log("how many data", this.words.length);
      this.memorizedwords = this.words.map((w) => ({
        id: w.id,
        word: w.kanji, // Assign text from the texts array
        memo: w.memo,
        color: this.generateHexColor(), // Generate a random color
      }));
    },
    truncateText(text, limit) {
      return text.length > limit ? text.substring(0, limit) + "..." : text;
    },

    async deleteWord(word) {
      console.log("hello", word, word.id);
      const resp = await http.deleteWord("/deleteById/" + word.id);
      if (resp.status == 200) {
        await this.getKanjiwords();
        this.initializeCartColors();
      } else {
        console.log("something wrong");
      }
    },
    detailsKanji(each) {
      // this.$router.push({
      //   name: "detailsMemorizedKanji",
      //   params: { each },
      // });

      this.$router.push({
        name: "detailsMemorizedKanji",
        params: { id: each.id },
      });
    },
  },
};
</script>
  <style scoped>
.masonry-grid {
  display: flex;
  margin: 2 auto;
  flex-wrap: wrap; /* Ensures items wrap to the next line */
  gap: 16px; /* Optional: adds spacing between items */
}

.masonry-item {
  border-radius: 4px;
  text-align: center;
  padding: 5px;
  font-size: 25px;
  height: 100%;
}
.actions {
  margin-bottom: 5px;
}
.trash {
  color: "brown";
  font-size: 20px;
}
</style>
  
  