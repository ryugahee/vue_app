<template>
  <div class="home">
    <div class="album py-5 bg-body-tertiary">
      <div class="container">
        <div>
          <div class="col" v-for="(item, idx) in state.items" :key="idx">
            <Board :item="item"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import axios from "axios";
import {reactive} from "vue";
import Board from "@/components/Board.vue";

export default {
  name: 'Home',
  components: {Board},
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