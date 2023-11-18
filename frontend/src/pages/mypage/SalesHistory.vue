<template>
  <div class="wrapper">
    <div class="header">
      <button>뒤로</button>
      <span>판매 내역</span>
    </div>
    <div class="main">
      <div class="thumbnail-box">
        <img class="thumbnailImg">
      </div>
      <div class="container">
        <h3></h3>
        <p></p>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'SalesHistory',

}
</script>

<style scoped>
.main {
  display: flex;
}
</style>