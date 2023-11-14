<template>
  <div class="header">
    <button>X</button>
    <span>프로필 수정</span>
    <button>완료</button>
  </div>
  <div class="userprofileImg">
    <img class="img-profile" />
    <label for="uploadImg"><img/></label>
    <input type="file" id="uploadImg"/>
  </div>
  <div class="userProfile">
    <div>
      <label for="userNickname">닉네임</label>
      <input type="text" id="userId" >
    </div>
    <div>
      <label for="userName"> 이름</label>
      <input type="text" id="userName" >
    </div>
    <div>
      <label for="userId">아이디</label>
      <input type="text" id="userId" >
    </div>
    <div>
      <label for="password">비밀번호</label>
      <input type="password" id="password" >
    </div>
    <div>
      <label for="email">이메일</label>
      <input type="email" id="email" >
    </div>
    <div>
      <label for="phoneNumber">전화번호</label>
      <input type="text" id="phoneNumber" >
    </div>
    <div>
      <label for="address">주소</label>
      <input type="text" id="address" >
    </div>
    <div>
      <label for="">상점소개</label>
      <textarea></textarea>
    </div>
  </div>



</template>

<script>

export default {
  name: 'Info',
  data() {
    return {
      name: "",
      email: "",
      password: "",

    }
  },
  created() {
    this.loadUserInfo();
  },
  methods: {
    loadUserInfo() {
    },
  }

}
</script>

<style scoped>

</style>
<script setup>
</script>