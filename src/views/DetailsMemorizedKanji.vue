<template>
  <v-container class="memoForm">
    <v-text>Kanji</v-text>
    <v-text-field v-model="word.kanji" disabled="true"></v-text-field>
    <v-row>
      <v-col cols="10">
        <v-text>Memo</v-text>
        <v-textarea v-model="word.memo" :disabled="!active"></v-textarea>
      </v-col>
      <v-col cols="2">
        <v-icon @click="editMemo" icon="fa:fas fa-edit"></v-icon>
      </v-col>
    </v-row>

    <v-Text>Date</v-Text>
    <v-text-field v-model="word.date" disabled="true"></v-text-field>
    <v-text>Revision</v-text>
    <v-text-field v-model="word.count" disabled="true"></v-text-field>
    <v-row>
      <v-col cols="6">
        <v-btn class="saveBtn" @click="saveMemo()" :disabled="loading">Save</v-btn>
      </v-col>
      <v-col cols="6">
        <v-btn class="saveBtn" @click="back()" :disabled="loading">Back</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>
  
  <script>
import { defineComponent } from "vue";
import http from "@/utils/http";

export default defineComponent({
  name: "StudiedKanji",
  props: ["each"],
  data: () => ({
    loading: false,
    id: "",
    word: "",
    active: false,
  }),
  async created() {
    this.id = this.$route.params.id;
    await this.fetchMemorizedKanji();
  },
  methods: {
    async fetchMemorizedKanji() {
      const resp = await http.getStudiedKanjiDetils("/get/" + this.id);
      if (resp && resp.status == 200) {
        const data = await resp.json();
        this.word = data;
      } else {
        console.log("sth wrong ");
      }
    },
    editMemo() {
      this.active = true;
    },
    async saveMemo() {
      const repo = await http.updateMemo("/edit/", {
        id: this.word.id,
        memo: this.word.memo,
      });
      if (repo & (repo.status == 200)) {
        const data = await repo.json;
        console.log(data);
      } else {
        console.log("sth wrong");
      }
    },
    back() {
      this.$router.push("/retrieveStudiedKanji");
    },
  },
});
</script>
  
  <style scoped>
.memoForm {
  margin-top: 2%;
  margin-left: -13%;
  margin-right: 5%;
  font-size: 25px;
}
.saveBtn {
  background-color: #cc2b52;
  font-family: "Courier New, Courier, monospace";
  font-size: 30px;
  margin-left: 40%;
  width: 20%;
}
</style>
  
    