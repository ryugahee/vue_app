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
                <input type="text" v-model="title"  class="form-control" required>
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
                <input type="text" v-model="content" class="form-control" required>
              </div>
            </div>
<!--            <div class="file-upload">
              <div class="col-7">
                <label for="username" class="form-label">사진 등록</label>
                <div class="input-group has-validation">
                  <input type="file" id="file" ref="files" @change="imageUpload" multiple class="form-control" required readonly>
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
            </div>-->
            <!--     사진 등록       -->
            <div v-if="!files.length" class="file-upload">
              <div>
                <label for="file">사진 등록
                  <input type="file" id="file" ref="files" @change="imageUpload" multiple />
                </label>
              </div>
            </div>
            <!--     업로드 후 미리보기       -->
            <div class="file-preview-content-container">
              <div v-for="(file, index) in images" :key="index" class="file-preview-wrapper">
                <!--     사진 닫기       -->
                <div class="file-close-button" @click="imageDeleteButton" :name="file.number">
                  x
                </div>
                <!--     사진 미리보기       -->
                <img :src="file.preview" />
              </div>
            </div>
            <!--     추가 사진 등록       -->
            <div class="file-preview-wrapper-upload">
              <label for="file">추가 사진 등록</label>
              <input  type="file" id="file" ref="files" @change ='imageAddUpload'/>
            </div>

          </div>
          <hr class="my-4">
          <div class="d-flex justify-content-center">
            <button class="w-50 btn btn-primary btn-lg" type="submit" @click="submitPost">저장</button>
          </div>
        </form>
      </div>
    </div>
  </div>

</template>

<script>

import axios from "axios";

export default {
  name: "Post",
  data() {
    return {
      title: '',
      price: '',
      stockNumber: '',
      content: '',

      files: [], //업로드용 파일
      filesPreview: [],
      uploadImageIndex: 0 // 이미지 업로드를 위한 변수
    };
  },
  methods: {
    submitPost() {
      let formData = new FormData();

      for (let i = 0; i < this.files.length; i++) {

        formData.append('title', encodeURIComponent(this.title));
        formData.append('content', encodeURIComponent(this.content));
        formData.append('price', encodeURIComponent(this.price));
        formData.append('stockNumber', encodeURIComponent(this.stockNumber));

        formData.append('files', this.files[i]);

        axios.post("/api/item/new", formData, {
              headers: {
                'Content-Type': 'multipart/form-data; charset=UTF-8',
              }
            })
            .then((res) => {
          console.log(res)
          if (res.status === 200) {
            console.log(res)
            alert("상품 등록 성공");
          }
        }).catch(()=>{
              window.alert("상품 등록 실패");
            }
        )
      }
    },
    imageUpload() {
      console.log(this.$refs.files.files);
      // this.files = [...this.files, this.$refs.files.files];
      //하나의 배열로 넣기
      let num = -1;
      for (let i = 0; i < this.$refs.files.files.length; i++) {
        this.files = [
          ...this.files,
          //이미지 업로드
          {
            //실제 파일
            file: this.$refs.files.files[i],
            //이미지 프리뷰
            preview: URL.createObjectURL(this.$refs.files.files[i]),
            //삭제및 관리를 위한 number
            number: i
          }
        ];
        num = i;
      }
      this.uploadImageIndex = num + 1; //이미지 index의 마지막 값 + 1 저장
      console.log(this.files);
      // console.log(this.filesPreview);
    }
  }
}
</script>

<style scoped>

</style>