<template>
  <div class="home">
    <div class="album py-5 bg-body-tertiary">
      <div class="container">
        <div>
          <div class="col" v-for="(item, idx) in state.items" :key="idx">
            <Product :item="item"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import axios from "axios";
import {reactive} from "vue";
import Product from "@/components/Product.vue";

export default {
  name: 'Home',
  components: {Product},
  setup() {
    const state = reactive({
      items: []
    })

    axios.get("/api/items").then(({data}) => {
      state.items = data;
      console.log(data);
  })

    return {state}

  },
}
</script>

<style scoped>

</style>