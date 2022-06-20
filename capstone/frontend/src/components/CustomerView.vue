<template>

<v-data-table
    :headers="headers"
    :items="customerView"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'CustomerView',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "userId", value: "userId" },
            { text: "orderStatus", value: "orderStatus" },
            { text: "deliveryStatus", value: "deliveryStatus" },
            { text: "orderId", value: "orderId" },
            { text: "deliverId", value: "deliverId" },
            { text: "payStatus", value: "payStatus" },
            { text: "payId", value: "payId" },
        ],
        customerView : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/customerviews')

      this.customerView = temp.data._embedded.customerviews;

    },
    methods: {
    }
  }
</script>

