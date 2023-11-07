<template>
  <div class="container">
    <div class="row g-5">
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">상품 등록</h4>
        <form class="needs-validation" novalidate>
          <div class="row g-3">
            <div class="col-7">
              <label for="username" class="form-label">상품명</label>
              <div class="input-group has-validation">
                <span class="input-group-text">상품명</span>
                <input type="text" @change="limitStringLength(title,49)" v-model="title"  class="form-control" required>
              </div>
            </div>
            <div class="col-7">
              <label for="username" class="form-label">가격</label>
              <div class="input-group has-validation">
                <span class="input-group-text">가격</span>
                <input type="text" v-model="price" class="form-control">
              </div>
            </div>
            <div class="col-7">
              <label for="username" class="form-label">재고</label>
              <div class="input-group has-validation">
                <span class="input-group-text">재고</span>
                <input v-model="stockNumber"  type="text" class="form-control">
              </div>
            </div>
            <div class="col-7">
              <label for="username" class="form-label">상세 설명</label>
              <div class="input-group has-validation">
                <span class="input-group-text">상세 설명</span>
                <input type="text" v-model="content" @change="limitStringLength(content,999)" class="form-control" required>
              </div>
            </div>
            <div class="file-upload">
              <div class="col-7">
                <label for="username" class="form-label">사진 등록</label>
                <div class="input-group has-validation">
                  <input type="file" class="form-control" required readonly>
                  <button class="input-group-text">업로드</button>
                </div>
              </div>
              <div class="col-7">
                <div class="input-group has-validation">
                  <input type="file" class="form-control" readonly>
                  <button class="input-group-text">업로드</button>
                </div>
              </div>
              <div class="col-7">
                <div class="input-group has-validation">
                  <input type="file" class="form-control" readonly>
                  <button class="input-group-text" @click="upload">업로드</button>
                </div>
              </div>
            </div>
          </div>
          <hr class="my-4">
          <div class="d-flex justify-content-center">
            <button class="w-50 btn btn-primary btn-lg" type="submitPost">저장</button>
          </div>
        </form>
      </div>
    </div>
  </div>

</template>

<script>

export default {
  name: "Post",
  data() {
    return {
      title: '',
      price: '',
      stockNumber: '',
      content: '',
      fileName: '',
      fileName2: '',
      fileName3: '',
      thumbnailFile: null,
      imageFile: null,
    };
  },
  methods: {
    upload() {

    },
    submitPost() {

    },
  }
}
</script>

<style scoped>

</style>