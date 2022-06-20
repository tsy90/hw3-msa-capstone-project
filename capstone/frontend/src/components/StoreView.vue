<template>

<v-data-table
    :headers="headers"
    :items="storeView"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'StoreView',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "userId", value: "userId" },
            { text: "orderId", value: "orderId" },
            { text: "orderStatus", value: "orderStatus" },
            { text: "payId", value: "payId" },
            { text: "payStatus", value: "payStatus" },
            { text: "deliveryId", value: "deliveryId" },
            { text: "deliveryStatus", value: "deliveryStatus" },
        ],
        storeView : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/storeviews')

      this.storeView = temp.data._embedded.storeviews;

    },
    methods: {
    }
  }
</script>

