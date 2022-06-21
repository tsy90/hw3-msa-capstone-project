<template>
    <div>
        <v-list two-line v-if="value.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    mandatory
                    color="indigo"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in value" :key="idx">
                    <v-list-item-avatar color="grey darken-1"></v-list-item-avatar>
                    
                    <v-list-item-content>
                        <v-list-item-title>{{idx+1}}</v-list-item-title>
                        <v-list-item-subtitle>
                            Id :  {{item.id }} * 
                            OrderId :  {{item.orderId }} * 
                            ProductId :  {{item.productId }} * 
                            ProductName :  {{item.productName }} * 
                            Qty :  {{item.qty }} * 
                            UserId :  {{item.userId }} * 
                            Price :  {{item.price }} * 
                            Address :  {{item.address }} * 
                            PayId :  {{item.payId }} * 
                            OrderStatus :  {{item.orderStatus }} * 
                        </v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'StorePicker',
        props: {
            store: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            value: [],
            selected: {},
        }),
        async created() {
            var temp = await axios.get(axios.fixUrl('/stores'))
            if(temp.data)
                this.value = temp.data._embedded.stores;
            if(this.store) {
                this.selected = this.store;
            }
        },
        methods: {
            select(val) {
                this.$emit('selected', this.value[val]);
            },
        },
    };
</script>


<style>
</style>
