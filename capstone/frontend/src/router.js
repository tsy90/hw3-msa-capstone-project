
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"

import StoreManager from "./components/listers/StoreCards"

import DeliveryManager from "./components/listers/DeliveryCards"

import PayManager from "./components/listers/PayCards"


import CustomerView from "./components/CustomerView"

import StoreView from "./components/StoreView"
export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },

            {
                path: '/stores',
                name: 'StoreManager',
                component: StoreManager
            },

            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },

            {
                path: '/pays',
                name: 'PayManager',
                component: PayManager
            },


            {
                path: '/customerViews',
                name: 'CustomerView',
                component: CustomerView
            },

            {
                path: '/storeViews',
                name: 'StoreView',
                component: StoreView
            },


    ]
})
