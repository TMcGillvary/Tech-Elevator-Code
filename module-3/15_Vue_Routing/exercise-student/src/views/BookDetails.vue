<template>
  <div class="book-details">
    <book-details />
  </div>
</template>

<script>
import BookDetails from "../components/BookDetails.vue";
export default {
  components: { BookDetails },
  created() {
    const bookISBN = this.$route.params.isbn;
    this.$store.commit("SET_ACTIVE_BOOK", bookISBN);
  },
};
</script>

<style>
</style>