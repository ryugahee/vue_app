<!-- https://loy124.tistory.com/203 -->
<div class="main-container">
<div class="room-deal-information-container">
  <div class="room-deal-information-title">사진 등록</div>
  <div class="room-file-upload-wrapper">
    <div v-if="!files.length" class="room-file-upload-example-container">
      <div class="room-file-upload-example">
        <div class="room-file-notice-item room-file-upload-button">
          <div class="image-box">
            <!-- <div class="image-profile">
<img :src="profileImage" />
</div>-->
            <label for="file">일반 사진 등록</label>
            <input type="file" id="file" ref="files" @change="imageUpload" multiple />
          </div>
        </div>
      </div>
    </div>
    <div v-else class="file-preview-content-container">
      <div class="file-preview-container">
        <div v-for="(file, index) in files" :key="index" class="file-preview-wrapper">
          <div class="file-close-button" @click="fileDeleteButton" :name="file.number">
            x
          </div>
          <img :src="file.preview" />
        </div>
        <div class="file-preview-wrapper-upload">
          <div class="image-box">
            <label for="file">추가 사진 등록</label>
            <input type="file" id="file" ref="files" @change="imageAddUpload" multiple />
          </div>
          <!-- <div class="file-close-button" @click="fileDeleteButton" :name="file.number">x</div> -->
        </div>
      </div>
    </div>
  </div>
</div>
</div>

<script>

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
          //이미지 업로드용 프리뷰
          // this.filesPreview = [
          //   ...this.filesPreview,
          //   { file: URL.createObjectURL(this.$refs.files.files[i]), number: i }
          // ];
        }
        this.uploadImageIndex = num + 1; //이미지 index의 마지막 값 + 1 저장
        console.log(this.files);
        // console.log(this.filesPreview);

      },

      imageAddUpload() {
        console.log(this.$refs.files.files);

        let num = -1;
        for (let i = 0; i < this.$refs.files.files.length; i++) {
          console.log(this.uploadImageIndex);
          this.files = [
            ...this.files,
            //이미지 업로드
            {
              //실제 파일
              file: this.$refs.files.files[i],
              //이미지 프리뷰
              preview: URL.createObjectURL(this.$refs.files.files[i]),
              //삭제및 관리를 위한 number
              number: i + this.uploadImageIndex
            }
          ];
          num = i;
        }
        this.uploadImageIndex = this.uploadImageIndex + num + 1;

        console.log(this.files);
        // console.log(this.filesPreview);
      },
      fileDeleteButton(e) {
        const name = e.target.getAttribute('name');
        this.files = this.files.filter(data => data.number !== Number(name));
        // console.log(this.files);
      },
      submitPost() {

      },
    }
  }
</script>

<style scoped>

</style>
