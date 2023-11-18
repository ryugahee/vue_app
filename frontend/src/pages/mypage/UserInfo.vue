<template>
  <div class="wrapper">
    <div class="header">
      <button>X</button>
      <span>프로필 수정</span>
      <button>완료</button>
    </div>
    <div class="upload-img">
      <img class="img-profile" />
      <label for="uploadImg"><img/></label>
      <input type="file" id="uploadImg"/>
    </div>
    <div class="profile">
      <div>
        <label for="userName"> 이름</label>
        <input type="text" id="userName" :value="info.name">
      </div>
      <div>
        <label for="userNickname">닉네임</label>
        <input type="text" id="userId" :value="info.nickName">
      </div>
      <div>
        <label for="password">비밀번호</label>
        <input type="password" id="password" placeholder="비밀번호 입력" >
        <label for="check-password">비밀번호 확인</label>
        <input type="password" id="check-password" placeholder="비밀번호 입력" >
        <button class="btn-password">인증 확인</button>
      </div>
      <div>
        <label for="email">이메일</label>
        <input type="email" id="email" :value="info.email">
      </div>
      <div>
        <label for="phoneNumber">전화번호</label>
        <input type="text" id="phoneNumber" :value="info.phone">
      </div>
      <div>
        <label for="zipcode">우편번호</label>
        <input type="text" id="zipcode" :value="info.zipcode" placeholder="우편번호 입력">
        <button>우편번호 찾기</button>
        <label for="address">주소</label>
        <input type="text" id="address" :value="info.streetadr" placeholder="도로명 주소 입력">
        <input type="text" id="address" :value="info.detailadr" placeholder="상세 주소 입력" >
      </div>
      <div>
        <label for="">상점소개</label>
        <textarea></textarea>
      </div>
    </div>
    <button>확인</button>
  </div>


</template>

<script>

import axios from "axios";

export default {
  name: 'UserInfo',
  data() {
    return{
      info: [],
    }
  },
  created() {
    axios.get("/api/member/update/2").then((res) => {
      this.info = res.data;
    })
  }

 /* setup() {
    const state = reactive({
      info: []
    })

    axios.get("/api/member/update").then(({data}) => {
      state.info = data;
      console.log(data);
    })

    return {state}

  },*/

}
</script>

<style scoped>
.wrapper  {
  min-width: 380px;
  max-width: 600px;
}
div label{
  display: block;
}
#address {
  display: block;
}
.btn-password {
  display: block;

}
</style>
