<template>
  <div class="card shadow-sm">
    <div class="card-body">
      <p class="card-text">{{ item }} </p>
      <div class="d-flex justify-content-between align-items-center">
        <router-link to="/board/detail"><button class="btn btn-primary">상세보기</button></router-link>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "Board",
  props: {
    item: String
  }

}
</script>

<style scoped>
.card .img {
  display: inline-block;
  width: 100%;
  height: 350px;
  background-size: cover;
  background-position: center;
}
.card .card-body .price {
  text-decoration: line-through;
}
</style>