<template>
  <div class="card shadow-sm">
    <div class="card-body">
      <p class="card-text">상품</p>
      <div class="d-flex justify-content-between align-items-center">
        <button class="btn btn-primary">구입하기</button>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "Card",
  props: {
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