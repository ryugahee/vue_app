<template>
  <div class="container">
    <div class="col-md-7 col-lg-8">
      <form  @submit.prevent="join" class="row g-3">
        <br>
        <h3>회원 가입</h3>
        <div class="col-8">
          <label class="form-label">이름</label>
          <div class="input-group has-validation">
            <input v-model="name" type="text" class="form-control" required>
          </div>
        </div>
        <div class="col-8">
          <label class="form-label">이메일</label>
          <div class="input-group has-validation">
            <input v-model="email" type="text" class="form-control" required>
          </div>
        </div>
        <div class="col-8">
          <label class="form-label">비밀번호</label>
          <div class="input-group has-validation">
            <input v-model="password" type="password" class="form-control" required>
          </div>
        </div>
      </form>
      <hr class="my-4">
      <span>주소 </span>
      <div class="address">
        <input v-model="zipcode" placeholder="우편번호" readonly>
        <button @click="search()">우편번호 찾기</button>
        <br>
        <br>
        <p>{{zipcode}}</p>
        <input v-model="streetadr" type="text" id="roadAddress" placeholder="도로명주소" style="width: 300px" readonly>
        <br>
        <br>
        <p>{{streetadr}}</p>
        <span id="guide" style="color:#000;display:none" ></span>
        <input v-model="detailadr" type="text" id="detailAddress"  placeholder="상세주소" style="width: 300px">
        <p>{{detailadr}}</p>
      </div>
      <hr class="my-4">
      <div class="d-flex justify-content-center">
        <button class="w-50 btn btn-primary btn-lg" type="submit" @click="join">회원가입</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import router from "@/scripts/router";

export default {
  name: "Join",

  data() {
    return {
      name: "",
      email: "",
      password: "",
      zipcode: "",
      streetadr: "",
      detailadr: "",
    }
  },

  methods : {
    search(){
      new window.daum.Postcode({
        oncomplete: (data) => {
          var roadAddr = data.roadAddress;
          var extraRoadAddr = '';

          if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
            extraRoadAddr += data.bname;
          }

          if(data.buildingName !== '' && data.apartment === 'Y'){
            extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
          }

          if(extraRoadAddr !== ''){
            extraRoadAddr = ' (' + extraRoadAddr + ')';
          }

          if(roadAddr !== ''){
            roadAddr += extraRoadAddr;
          }

          this.zipcode = data.zonecode;
          this.streetadr = roadAddr;

        }
      }).open();

    },
    join() {
      axios.post("/api/new", {
        name: this.name,
        email: this.email,
        password: this.password,
        zipcode: this.zipcode,
        streetadr: this.streetadr,
        detailadr: this.detailadr,
      }).then((res) => {
        console.log(res)
        if (res.status === 200) {
          console.log(res)
          alert("회원 가입 성공");
          router.push("/login");
        }
      }).catch(()=>{
            window.alert("회원 가입 실패");
          }
      )
    },

  },
}

</script>

<style scoped>

</style>