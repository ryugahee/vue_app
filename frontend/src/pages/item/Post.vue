<template>
  <div class="wrapper">
    <div class="header">
      <div>
        <button class="btn-left"><img src="../../assets/img/left%202.png"></button>
      </div>
      <div class="register">
        <p>경매 등록</p>
      </div>
    </div>
    <div class="img-upload">
      <!--     미리보기       -->
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
          <label for="file" class="filelabel"><img src="../../assets/img/camera%201.png" class="icon-camera"></label>
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
    <div class="main">
      <div>
        <input class="title-box" type="text" v-model="itemTitle" placeholder=" 제목">
      </div>
      <div>
        <input class="price-box" type="text" v-model="minPrice" placeholder=" 최소 입찰 가격"> 원
      </div>
      <div>
        <select class="time-box">
          <option>시간</option>
          <option>30분</option>
          <option>1시간</option>
          <option>2시간</option>
          <option>3시간</option>
          <option>6시간</option>
          <option>12시간</option>
          <option>24시간</option>
        </select>
      </div>
      <div class="content">
      <textarea class="itemDetail-box"
          type="text"
                v-model="itemDetail" placeholder=" 상품 설명"></textarea>
      </div>
      <div>
        <input type="text"
               v-model="itemTag" @input="handleInput" class="tag-box" placeholder=" #품목명">
      </div>
      <div>
        <select v-model="itemType" class="type-box">
          <option>대분류</option>
          <option>딸기</option>
          <option>수박</option>
          <option>토마토</option>
        </select>
      </div>
      <div>
        <input v-model="weight" class="weight-box" type="text" placeholder=" 무게"> kg
      </div>
    </div>
    <div class="btn-container">
      <button class="btn-start" type="submit" @click="submitPost">
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
      itemTitle: "",
      minPrice: "",
      itemDetail: "",
      itemTag: "",
      itemType: "",
      weight: "",

      files: [],
      filesPreview: [],
      uploadImageIndex: 0,
    };
  },
  watch: {
    'itemTag': function() {

}
  },

  methods: {
    handleInput() {
      if (typeof this.itemTag === 'string') {
        this.itemTag = this.itemTag.trim().split(/\s+/);
      }
    },


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

      formData.append("itemTitle", this.itemTitle);
      formData.append("minPrice", this.minPrice);
      formData.append("itemDetail", this.itemDetail);
      formData.append("itemTag", this.itemTag);
      formData.append("itemType", this.itemType);
      formData.append("weight", this.weight);

      console.log("이거 확인해보자: " + this.itemTag);

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
.wrapper {
  width: 390px;
  height: 844px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-direction: column;

}
.header {
  width: 90%;
  height: 100px;
  display: flex;
  justify-content: flex-start;
  padding-top: 70px;
}
.register {
  margin-left: 10px;
  font-weight: bold;
}
.btn-left {
  border: none;
  background-color: white;
}
/* 상품 이미지 */

.filelabel {
  border: solid #98CB98 1px;
  border-radius: 10px;
  width: 80px;
  height: 80px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 5px;
}

.icon-camera {
  width: 30px;
  height: 30px;
}

.img-upload {
  width: 100%;
  padding: 5% 5% 0% 5%;
  display: flex;
  border-top: solid 1px #d9d9d9;
  white-space:nowrap;
  overflow: auto;
}

.img-preview {
  display: flex;
  margin-right: 3px;

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

/* main */

.main {
  width: 100%;
  padding: 5%;
}
.title-box, .time-box, .tag-box, .type-box{
  width: 100%;
  height: 35px;
  border: solid #98CB98 1px;
  border-radius: 5px;
  margin-bottom: 15px;
}
.itemDetail-box {
  width: 100%;
  height: 200px;
  border: solid #98CB98 1px;
  border-radius: 5px;
  margin-bottom: 15px;
}
.price-box, .weight-box {
  width: 90%;
  height: 40px;
  border: solid #98CB98 1px;
  border-radius: 5px;
  margin-bottom: 15px;
}

/* 경매 버튼 */

.btn-container {
  width: 100%;
  height: 50px;
  background-color: #98CB98;
  display: flex;
  justify-content: center;

}
.btn-start {
  border: none;
  color: white;
  font-weight: bold;
  font-size: larger;
  background-color: #98CB98;
}

</style>
