<template>
  <div class="wrapper">
    <div class="header">
      <button>X</button>
      <span>프로필 수정</span>
      <button>완료</button>
    </div>

    <div class="upload-img" v-if="!file">
      <div class="img-profile">
        <img src="../../assets/img/person.png"/>
      </div>
      <div class="img-icon">
        <label for="file">
          <img src="../../assets/img/camera%201.png" class="icon"/>
        </label>
        <input type="file" id="file" ref="file" @change="imageUpload" style="display: none"/>
      </div>
    </div>
    <div class="upload-img" v-else>
      <label for="file">
        <img :src="preview" class="preview"/>
      </label>
      <input type="file" id="file" ref="file" @change="imageUpload" style="display: none"/>
    </div>
    <div class="profile">
      <div>
        <label for="userName"> 이름</label>
        <input type="text" id="userName" v-model="name">
      </div>
      <div>
        <label for="userNickname">닉네임</label>
        <input type="text" id="userNickname" v-model="nickName">
      </div>
      <div>
        <label for="password">비밀번호</label>
        <input type="password" id="password" placeholder="비밀번호 입력">
        <label for="check-password">비밀번호 확인</label>
        <input type="password" id="check-password" placeholder="비밀번호 입력">
        <button class="btn-password">인증 확인</button>
      </div>
      <div>
        <label for="email">이메일</label>
        <input type="email" id="email" v-model="email">
      </div>
      <div>
        <label for="phoneNumber">전화번호</label>
        <input type="text" id="phoneNumber" v-model="phone">
      </div>
      <div>
        <label for="zipcode">우편번호</label>
        <input type="text" id="zipcode" v-model="zipcode" placeholder="우편번호 입력">
        <button>우편번호 찾기</button>
        <label for="address">주소</label>
        <input type="text" id="address" v-model="streetadr" placeholder="도로명 주소 입력">
        <input type="text" id="address" v-model="detailadr" placeholder="상세 주소 입력">
      </div>
      <div>
        <label for="">상점소개</label>
        <textarea></textarea>
      </div>
    </div>
    <button type="submit" @click="UpdateInfo">확인</button>
  </div>


</template>

<script>

import axios from "axios";

export default {
  name: 'UserInfo',
  data() {
    return {
      name: "",
      nickName: "",
      email: "",
      phone: "",
      password: "",
      zipcode: "",
      streetadr: "",
      detailadr: "",

      file: "",
      preview: ""
    }
  },
  created() {
    this.loadUserInfo();
    console.log("nickName:", this.nickName);
    console.log("name:", this.name);
  },
  methods: {

    imageUpload() {

      const fileType = this.$refs.file.files[0].name.toLowerCase();
      if (!fileType.includes('jpg') && !fileType.includes('png') && !fileType.includes('gif') && !fileType.includes('JPEG')) {
        alert(
            `이미지 파일(JPG,JPEG,GIF,PNG)만 첨부해주세요.`
        )
        return
      }

      this.file = this.$refs.file.files[0]
      this.preview = URL.createObjectURL(this.file)
    },


    async UpdateInfo() {
      const formData = new FormData();

      formData.append("nickName", this.nickName);
      formData.append("name", this.name);
      formData.append("email", this.email);
      formData.append("phone", this.phone);
      formData.append("password", this.password);
      formData.append("zipcode", this.zipcode);
      formData.append("streetadr", this.streetadr);
      formData.append("detailadr", this.detailadr);
      formData.append("file", this.file);

      console.log("nickName:", this.nickName);

      await axios
          .post("/api/member/update/1", formData, {
            headers: {
              "Content-Type": "application/json; charset=UTF-8",
            },
          })
          .then((res) => {
            console.log(res);
            if (res.status === 200) {
              console.log(res);
              window.alert("프로필 수정 성공");
              this.loadUserInfo();
            }
          })
          .catch(() => {
            window.alert("프로필 수정 실패");
          });

    },
    loadUserInfo() {
      axios.get("/api/member/update/1").then((res) => {
        this.name = res.data.name;
        this.nickName = res.data.nickName;
        this.email = res.data.email;
        this.phone = res.data.phone;
        this.password = res.data.password;
        this.zipcode = res.data.zipcode;
        this.streetadr = res.data.streetadr;
        this.detailadr = res.data.detailadr;

      })
    },

  }


}
</script>

<style scoped>
.wrapper {
  min-width: 390px;
  max-width: 600px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.header {
  display: flex;
  justify-content: center;
  align-items: center;
}

div label {
  display: block;
}

#address {
  display: block;
}

.btn-password {
  display: block;
}

.upload-img {
  display: flex;
  justify-content: center;
  align-items: center;
}

.img-profile {
  background-color: #D9D9D9;
  border-radius: 75px;
  width: 100px;
  height: 100px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.preview {
  border-radius: 75px;
  width: 100px;
  height: 100px;
}

.icon {
  width: 30px;
  height: 30px;
  z-index: 2;
  margin-left: 80px;
  margin-top: 50px;
}

.img-icon {
  position: absolute;
}
</style>
