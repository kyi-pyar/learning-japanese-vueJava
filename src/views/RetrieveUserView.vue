<template>
  <div class="dicForm">
    <h1>About Me</h1>
    {{ email }}
    {{ fullName }}
    {{ formattedTime }}
  </div>
</template>
  <script>
import { defineComponent } from "vue";
import http from "../utils/http";
import { Date } from "core-js";

export default defineComponent({
  name: "RetrieveUserView",
  data: () => ({
    email: "",
    fullName: "",
    createAt: "",
    formattedTime: "",
  }),

  async created() {
    const resp = await http.getAboutme("/me");
    if (resp) {
      const data = await resp.json();
      this.email = data.email;
      this.fullName = data.fullName;
      this.createAtdata = data.createdAt;
      this.formattedTime = this.formatTime(this.createAtdata);
    } else {
      console.log(resp);
    }
  },
  methods: {
    formatTime(timestamp) {
      if (!timestamp) return "Invalid Date";
      const date = new Date(timestamp.replace(" ", "T")); // Ensure ISO-8601 format
      if (isNaN(date)) {
        console.error("Invalid date format:", timestamp);
        return "Invalid Date";
      }
      return date.toLocaleString("en-US", {
        year: "numeric",
        month: "long",
        day: "numeric",
        hour: "2-digit",
        minute: "2-digit",
        second: "2-digit",
      });
    },
  },
});
</script>
  
  