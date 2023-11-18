<template>
  <div class="wrapper">
    <div class="header">
      <button>뒤로</button>
      <span>경매 등록</span>
    </div>
    <div class="img-upload">
      <!--     업로드 후 미리보기       -->
      <div class="img-preview">
        <div
            v-for="(file, index) in files"
            :key="index" class="img-file">
          <div
              class="img-close-button"
              @click="imageDeleteButton(index)">
            x
          </div>
          <img :src="file.preview" class="preview"/>
        </div>
        <!--     사진 추가       -->
        <div v-if="!files.length">
          <label for="file" class="filelabel"><img src="../../assets/img/camera%201.png" class="icon"></label>
          <input
              type="file"
              id="file"
              ref="files"
              multiple
              @change="imageAddUpload"
              style="display: none"/>
        </div>
        <div v-else>
          <label for="file" class="filelabel"><img src="../../assets/img/add.png" class="icon"></label>
          <input
              type="file"
              id="file"
              ref="files"
              multiple
              @change="imageAddUpload"
              style="display: none"/>
        </div>
      </div>

    </div>
    <div class="content">
      <div>
        <input type="text" v-model="itemName" placeholder="제목">
      </div>
      <div>
        <input type="number" v-model="price" placeholder="최소 입찰 가격"><span>원 ~ </span>
        <input type="number" placeholder="최대 입찰 가격"><span>원</span>
      </div>
      <div>
        <select>
          <option>시간</option>
          <option>30분</option>
          <option>1시간</option>
          <option>2시간</option>
        </select>
      </div>
      <div>
      <textarea type="text"
                v-model="itemDetail" placeholder="상품 설명"></textarea>
      </div>
      <div>
        <input placeholder="#품목명">
      </div>
      <div>
        <select>
          <option>대분류</option>
          <option>딸기</option>
          <option>수박</option>
          <option>토마토</option>
        </select>
      </div>
      <div>
        <select>
          <option>무게(kg)</option>
          <option>1kg</option>
          <option>2kg</option>
          <option>3kg</option>
        </select>
      </div>
    </div>
    <div>
      <button type="submit" @click="submitPost">
        경매 시작!
      </button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Post",
  data() {
    return {
      itemName: "",
      price: "",
      stockNumber: "",
      itemDetail: "",

      files: [],
      filesPreview: [],
      uploadImageIndex: 0,
    };
  },
  methods: {
    imageAddUpload() {

      let num = -1;
      for (let i = 0; i < this.$refs.files.files.length; i++) {

        const fileType = this.$refs.files.files[i].name.toLowerCase();
        if (!fileType.includes('jpg') && !fileType.includes('png') && !fileType.includes('gif') && !fileType.includes('JPEG')) {
          alert(
              `이미지 파일(JPG,JPEG,GIF,PNG)만 첨부해주세요.`
          )
          return
        }

        this.files.push({
          file: this.$refs.files.files[i],
          preview: URL.createObjectURL(this.$refs.files.files[i]),
          number: i + this.uploadImageIndex,
        });

        this.uploadImageIndex = num + 1;
      }
      console.log(this.files);
    },
    imageDeleteButton(index) {
      this.files = this.files.filter((data, i) => i !== index);
      console.log(this.files);
    },
    async submitPost() {

      const formData = new FormData();

      formData.append("itemName", this.itemName);
      formData.append("itemDetail", this.itemDetail);
      formData.append("price", this.price);
      formData.append("stockNumber", this.stockNumber);

      for (let i = 0; i < this.files.length; i++) {
        formData.append("files", this.files[i].file);

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

<style scoped>
.filelabel {
  border: solid #98CB98 2px;
  border-radius: 10px;
  width: 80px;
  height: 80px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 5px;
}

.icon {
  width: 30px;
  height: 30px;
}

.img-upload {
  display: flex;
  margin-top: 5px;
}

.img-preview {
  display: flex;
  margin: 5px;

}

.preview {
  width: 80px;
  height: 80px;
  border-radius: 10px;
}

.img-file {
  margin: 5px;
}
.img-close-button {
  position: absolute;
  z-index: 2;
  font-size: large;
  font-weight: bold;
  color: white;
  margin-left: 5px;
}
</style>
