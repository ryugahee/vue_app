<template>
  <div class="container">
    <div class="row g-5">
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">상품 등록</h4>
        <form class="needs-validation" novalidate>
          <div class="row g-3">
            <div class="col-12">
              <label for="username" class="form-label">상품명</label>
              <div class="input-group has-validation">
                <span class="input-group-text">상품명</span>
                <input type="text" class="form-control" id="username" required>
              </div>
            </div>
            <div class="col-12">
              <label for="username" class="form-label">가격</label>
              <div class="input-group has-validation">
                <span class="input-group-text">가격</span>
                <input type="text" class="form-control" id="username" required>
              </div>
            </div>
            <div class="col-12">
              <label for="username" class="form-label">상세 설명</label>
              <div class="input-group has-validation">
                <span class="input-group-text">상세 설명</span>
                <input type="text" class="form-control" id="username" required>
              </div>
            </div>
            <div class="col-12">
              <label for="username" class="form-label">사진 등록</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="username" placeholder="상품 이미지" required>
                <button class="input-group-text">업로드</button>
              </div>
            </div>
            <div class="col-12">
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="username" placeholder="상품 이미지">
                <button class="input-group-text">업로드</button>
              </div>
            </div>
            <div class="col-12">
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="username" placeholder="상품 이미지">
                <button class="input-group-text">업로드</button>
              </div>
            </div>
          </div>
          <hr class="my-4">
          <div class="d-flex justify-content-center">
            <button class="w-50 btn btn-primary btn-lg" type="submit">저장</button>
          </div>
        </form>
      </div>
    </div>
  </div>

</template>

<script>

export default {
  name: "Post",
}
</script>

<style scoped>

</style>