<template>
  <v-container>
    <h1>
      <center>~~~~~~ LET'S MEMORIZED ~~~~~~</center>
    </h1>
    <br />
    <br />
    <div ref="masonryGrid" class="masonry-grid">
      <div v-for="(w,index) in cardcolor" :key="index">
        <v-card
          class="masonry-item"
          :style="{ backgroundColor: w.color, color: 'brown', height: w.height}"
        >
          <p>{{ w.text }}</p>
        </v-card>
      </div>
    </div>
  </v-container>
</template>
  
  <script>
export default {
  name: "WelcomePage",

  data: () => ({
    words:
      "駐車する（ちゅうしゃする, 独裁（どくさい, 警視庁（けいしちょう, 秋（あき), 温泉（おんせん, 善人（ぜんにん,研ぐ（とぐ）,挟み撃ち（はさみうち）,小学校（しょうがっこう）,薄弱な（はくじゃくな）,受講する（じゅこうする）,返戻する（へんれいする）,沿線（えんせん）,二泊三日（にはくみっか）,偶数（ぐうすう）,押し問答（おしもんどう）,真言宗（しんごんしゅう）,贈答品（ぞうとうひん）,認識する（にんしきす）,意識する（いしきする）,特別な（とくべつな）,別な（べつな）,選ぶ（えらぶ）,小麦（こむぎ）,小鳥（ことり）,方向（ほうこう）,較差（かくさ）,比較的（ひかくてき）,決定する（けっていする）,決心す（けっしんする）,特色（とくしょく）,特徴（とくちょう）",
    cardcolor: [],
    numberOfCards: 0,
    word: [],
  }),

  created() {
    this.getKanjiword();
    this.initializeCartColors();
  },

  methods: {
    getKanjiword() {
      this.word = this.words.split(",");
      for (let i = this.word.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [this.word[i], this.word[j]] = [this.word[j], this.word[i]];
      }
      console.log(this.word.length);
    },
    generateHexColor() {
      const letters = "0123456789ABCDEF";
      let color = "#888";
      for (let i = 0; i < 3; i++) {
        color += letters[Math.floor(Math.random() * 16)];
      }

      return color;
    },
    generateHeight() {
      return Math.floor(Math.random() * 200) + 100 + "px";
    },

    initializeCartColors() {
      this.numberOfCards = this.word.length;
      this.cardcolor = this.word.map((w) => ({
        text: w, // Assign text from the texts array
        color: this.generateHexColor(), // Generate a random color
        height: this.generateHeight(), //for ramdom height
      }));
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
}
</style>

