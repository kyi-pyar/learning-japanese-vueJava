<template>
  <div class="text-center">
    <v-menu :location="location">
      <template v-slot:activator="{ props }">
        <v-btn color="primary" dark v-bind="props">Dropdown</v-btn>
      </template>

      <v-list>
        <v-list-item>AA</v-list-item>
        <v-list-item>AA</v-list-item>
      </v-list>
    </v-menu>
  </div>
</template>
<script>
export default {
  data: () => ({}),
};
</script>