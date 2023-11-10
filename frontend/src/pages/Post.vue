<template>
  <div class="container">
    <div class="row g-5">
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">상품 등록</h4>
<!--        <form class="needs-validation" novalidate>-->
          <div class="row g-3">
            <div class="col-7">
              <label for="username" class="form-label">상품명</label>
              <div class="input-group has-validation">
                <span class="input-group-text">상품명</span>
                <input
                    type="text"
                    v-model="itemNm"
                    class="form-control"
                    required
                />
              </div>
            </div>
            <div class="col-7">
              <label for="username" class="form-label">가격</label>
              <div class="input-group has-validation">
                <span class="input-group-text">가격</span>
                <input type="text" v-model="price" class="form-control"/>
              </div>
            </div>
            <div class="col-7">
              <label for="username" class="form-label">재고</label>
              <div class="input-group has-validation">
                <span class="input-group-text">재고</span>
                <input v-model="stockNumber" type="text" class="form-control"/>
              </div>
            </div>
            <div class="col-7">
              <label for="username" class="form-label">상세 설명</label>
              <div class="input-group has-validation">
                <span class="input-group-text">상세 설명</span>
                <input
                    type="text"
                    v-model="itemDetail"
                    class="form-control"
                    required
                />
              </div>
            </div>

            <div>
              <!--     사진 등록       -->
<!--              <div v-if="!files.length" class="file-upload">
&lt;!&ndash;              <div class="file-upload">&ndash;&gt;
                <div>
                  <label for="file"
                  >사진 등록
                    <input
                        type="file"
                        id="file"
                        ref="files"
                        multiple @change="imageUpload"
                    />
                  </label>
                </div>
              </div>-->
              <div>
<!--              <div>-->
                <!--     업로드 후 미리보기       -->
                <div class="file-preview-content-container">
                  <div
                      v-for="(file, index) in files"
                      :key="index"
                      class="file-preview-wrapper">
                    <!--     사진 닫기       -->
                    <div
                        class="file-close-button"
                        @click="imageDeleteButton"
                        :name="file.number"
                    >
                      x
                    </div>
                    <!--     사진 미리보기       -->
                    <img :src="file.preview"/>
                  </div>
                </div>
                <div>
                  <!--     추가 사진 등록       -->
                  <div class="file-preview-wrapper-upload">
                    <label for="file">추가 사진 등록</label>
                    <input
                        type="file"
                        id="file"
                        ref="files"
                        multiple
                        @change="imageAddUpload"
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>
          <hr class="my-4"/>
          <div class="d-flex justify-content-center">
            <button
                class="w-50 btn btn-primary btn-lg"
                type="submit"
                @click="submitPost"
            >
              저장
            </button>
          </div>
<!--        </form>-->
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
      itemNm: "",
      price: "",
      stockNumber: "",
      itemDetail: "",

      files: [],
      filesPreview: [],
      uploadImageIndex: 0,
    };
  },
  methods: {

/*    imageUpload() {
      console.log(this.$refs.files.files);
      let num = -1;
      for (let i = 0; i < this.$refs.files.files.length; i++) {
        this.files = [
          ...this.files,
          {
            file: this.$refs.files.files[i],
            preview: URL.createObjectURL(this.$refs.files.files[i]),
            number: i
          }
        ];
        num = i;
      }
      this.uploadImageIndex = num + 1;
      console.log(this.files);
    },*/
    imageAddUpload() {
      let num = -1;
      for (let i = 0; i < this.$refs.files.files.length; i++) {
        console.log(this.uploadImageIndex);
        this.files.push({
          file: this.$refs.files.files[i],
          preview: URL.createObjectURL(this.$refs.files.files[i]),
          number: i + this.uploadImageIndex,
        });

      this.uploadImageIndex = num + 1;
      }
      console.log(this.files);
    },
    async submitPost() {

        const formData = new FormData();
      for (let i = 0; i < this.files.length; i++) {
        formData.append("itemNm", encodeURIComponent(this.itemNm));
        formData.append("itemDetail", encodeURIComponent(this.itemDetail));
        formData.append("price", this.price);
        formData.append("stockNumber", this.stockNumber);

        formData.append("files", this.files[i].file);

        console.log("백으로 넘어가는 폼데이터: ", this.files[i].file);

      }
        await axios
            .post("/api/item/new", formData, {
              headers: {
                "Content-Type": "multipart/form-data;  charset=UTF-8",
              },
            })
            .then((res) => {
              console.log(res);
              if (res.status === 200) {
                console.log(res);
                window.alert("상품 등록 성공");
              }
            })
            .catch(() => {
              window.alert("상품 등록 실패");
            });

    },
  },
};
</script>

<style scoped></style>
