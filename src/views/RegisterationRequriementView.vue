<template>
  <div class="regForm">
    <v-row>
      <v-col cols="12">
        <h2>{{fullName}} Information Concerning with Japanese Knowledge</h2>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="4">
        <v-label>Do you Know how to type japanese :</v-label>
        <v-switch v-model="typing" :color="typingColor"></v-switch>
      </v-col>
      <v-col cols="4">
        <v-label>Japanese Level :</v-label>
        <v-radio-group v-model="level">
          <v-radio label="Beginner Level" value="1"></v-radio>
          <v-radio label="Advance Level" value="2"></v-radio>
        </v-radio-group>
      </v-col>
      <v-col cols="4">
        <v-label>Choose pattern want to learn :</v-label>
        <v-checkbox
          v-model="selectedlan"
          v-for="(lan,index) in language"
          :key="index"
          :value="lan"
          :label="lan"
        ></v-checkbox>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="6">
        <v-text-field
          label="Date of Birth"
          v-model="customText"
          readonly
          @click="showDatePicker = true"
        ></v-text-field>

        <!-- Date picker component -->
        <v-dialog v-model="showDatePicker" width="290px" @keydown.enter="updateCustomTextAndClose">
          <v-date-picker v-model="selectedDate" :no-title="true" @change="updateCustomTextAndClose"></v-date-picker>
        </v-dialog>
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="12">
        <v-btn @click="saveUserInfo()">Save</v-btn>
      </v-col>
    </v-row>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import http from "../utils/http";

export default defineComponent({
  name: "RegisterationRequriementView",
  data: () => ({
    fullName: "",
    typing: false,
    level: "",
    language: ["romaji", "ひらがな", "漢字"],
    selectedlan: [],
    selectedDate: null, // Actual selected date
    customText: "", // Custom formatted text for display
    showDatePicker: false, // Dialog state for date picker
  }),

  created() {
    this.fullName = this.$store.getters.getUser.fullName;
  },
  computed: {
    typingColor() {
      return this.typing ? "red" : "grey";
    },
  },
  methods: {
    updateCustomTextAndClose() {
      const dateObj = new Date(this.selectedDate);
      if (!isNaN(dateObj.getDate())) {
        this.customText = this.formatDate(dateObj);
      } else {
        this.customText = "";
      }
      //this.updateCustomText(date);
      this.showDatePicker = false;
    },
    formatDate(date) {
      if (!date) return "";
      const options = { year: "numeric", month: "long", day: "numeric" };
      return new Date(date).toLocaleDateString("en-US", options); // Customize date format here
    },
    async saveUserInfo() {
      console.log(this.typing, this.level, this.selectedlan);
      const resp = await http.save("info/save", {
        typing: this.typing,
        level: this.level,
        preferredLanguage: this.selectedlan,
        dob: this.customText,
        user: {
          id: this.$store.getters.getUser.id,
        },
      });
      if (resp) {
        console.log("save success");
      }
      console.log(resp);
    },
  },
});
</script>
<style scoped>
.regForm {
  margin-top: 3%;
  margin-left: -15%;
  margin-right: 5%;
}
</style>