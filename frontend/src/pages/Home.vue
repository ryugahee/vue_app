<template>
  <div class="home">
    <div class="album py-5 bg-body-tertiary">
      <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div class="col" v-for="i in 60" :key="i">
            <Card />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Card from "@/components/Card.vue";
import axios from "axios";

export default {
  name: 'Home',
  components: {Card},
  setup() {
    axios.get("/").then((res) => {
      console.log(res);
    })
  },
}
</script>

<style scoped>

</style>