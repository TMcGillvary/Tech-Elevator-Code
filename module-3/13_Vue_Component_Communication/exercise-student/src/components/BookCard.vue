<template>
  <div class="card" v-bind:key="book.isbn" v-bind:class="{ read: book.read }">
    <h2 class="book-title">{{ book.title }}</h2>

    <img
      v-if="book.isbn"
      v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
      "
    />
    <h3 class="book-author">{{ book.author }}</h3>

    <button v-on:click="onReadChange" v-bind:class="toggleReadClass">
      {{ book.read === true ? "Mark Unread" : "Mark Read" }}
    </button>
  </div>
</template>

<script>
export default {
  name: "book-card",
  props: ["book"],
  methods: {
    onReadChange() {
      this.$store.commit("FLIP_READ_STATUS", this.book);
    },
  },
  computed: {
    toggleReadClass() {
      const readStatus = this.book.read;
      if (readStatus === true) {
        return { "mark-unread": this.book.read };
      } else {
        return { "mark-read": !this.book.read };
      }
    },
  },
};
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
}

.card.read {
  background-color: lightgray;
}

.card .book-title {
  font-size: 1.5rem;
}

.card .book-author {
  font-size: 1rem;
}
</style>