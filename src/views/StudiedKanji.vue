<template>
  <v-container class="memoForm">
    <v-text-field label="Enter Studied Kanji" v-model="kanji"></v-text-field>
    <v-textarea label="memo" v-model="memo"></v-textarea>
    <v-btn class="saveBtn" @click="saveMemo()" :disabled="loading">Save</v-btn>
  </v-container>
</template>

<script>
import { defineComponent } from "vue";
import http from "../utils/http";
export default defineComponent({
  name: "StudiedKanji",
  data: () => ({
    word: "",
    memo: "",
    loading: false,
  }),

  methods: {
    async saveMemo() {
      this.loading = true;
      const resp = await http.saveMemo("/saveMemo", {
        kanji: this.kanji,
        memo: this.memo,
        user: this.$store.getters.getUser,
      });

      if (resp) {
        const data = await resp.json();
        if (data) {
          console.log("save memo", data);
          this.loading = false;
        } else {
          console.log("error");
        }
      }
    },
  },
});
</script>

<style scoped>
.memoForm {
  margin-top: 3%;
  margin-left: -15%;
  margin-right: 5%;
}
.saveBtn {
  background-color: #cc2b52;
  font-family: "Courier New, Courier, monospace";
  font-size: 30px;
  margin-left: 40%;
  width: 20%;
}
</style>

  