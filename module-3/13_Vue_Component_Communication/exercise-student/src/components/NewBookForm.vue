<template>
  <form v-on:submit.prevent="addNewBook">
    <div class="new-book-form">
      <label for="title-input">Book Title:</label>
      <input class="title-input" type="text" v-model="newBook.title" />

      <label for="author-input">Author:</label>
      <input class="author-input" type="text" v-model="newBook.author" />

      <label for="isbn-input">ISBN Number:</label>
      <input class="isbn-input" type="text" v-model="newBook.isbn" />

      <input type="submit" value="Submit" />
    </div>
  </form>
</template>

<script>
export default {
  name: "new-book-form",
  data() {
    return {
      newBook: {
        read: false,
      },
    };
  },
  methods: {
    addNewBook() {
      this.$store.commit("ADD_BOOK", this.newBook);
      this.resetForm();
    },
    resetForm() {
      this.newBook = {};
    },
  },
};
</script>

<style>
</style>