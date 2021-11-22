<template>
  <table id="tblUsers">
    <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>
          <input type="text" id="firstNameFilter" v-model="filter.firstName" />
        </td>
        <td>
          <input type="text" id="lastNameFilter" v-model="filter.lastName" />
        </td>
        <td>
          <input type="text" id="usernameFilter" v-model="filter.username" />
        </td>
        <td>
          <input type="text" id="emailFilter" v-model="filter.emailAddress" />
        </td>
        <td>
          <select id="statusFilter" v-model="filter.status">
            <option value="">Show All</option>
            <option value="Active">Active</option>
            <option value="Disabled">Disabled</option>
          </select>
        </td>
      </tr>
      <!-- user listing goes here -->
      <tr
        v-for="user in users"
        v-bind:key="user.username"
        v-bind:class="{ disabled: user.status === 'Disabled' }"
      >
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.emailAddress }}</td>
        <td>{{ user.status }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "user-list",
  data() {
    return {
      filter: {
        firstName: "",
        lastName: "",
        uername: "",
        emailAddress: "",
        status: "",
      },

      users: [
        {
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active",
        },
        {
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active",
        },
        {
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Disabled",
        },
        {
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active",
        },
        {
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active",
        },
        {
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Disabled",
        },
      ],
    };
  },

  computed: {
    filteredList() {
      // i am just supremely stuck and have no idea how to do this in a way that will let you compare each key value pair to each other
      // I can get it figured out easily to look at a single filter (i.e. firstName) and I can even extend it out to 2 filters, but I can't figure out how to do them all
      // using a filter on the users makes sense, but I have no idea where to go from there as every single example I google is only comparing one filter value, not all of them
      return true;
    },
  },
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input,
select {
  font-size: 16px;
}
</style>
