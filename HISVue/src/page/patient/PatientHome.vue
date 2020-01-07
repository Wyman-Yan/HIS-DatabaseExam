<template>
  <div id="PatientHome">
    <div class="ani-star1" id="P_id">你好！{{name}}</div>
    <div class="P_background"></div>
    <patient-nav :Pno="Pno"></patient-nav>
  </div>
</template>

<script>
  import PatientNav from '@/page/patient/component/PatientNav'
  import qs from 'qs'
    export default {
        name: "PatientHome",
        components:{
          PatientNav
        },data(){
        return{
          loginuser: '',
          name: '',
          Pno: '',
          SearchName:{
            InUno:''
          }
        }
      },
      created(){
        this.getRouterData()
      },
      methods:{
        getRouterData(){
          this.loginuser = this.$route.params.loginuser
          /*this.name = this.loginuser.Uname*/
          this.Pno = this.loginuser.Uno
          this.SearchName.InUno = this.loginuser.Uno
          let params = this.SearchName
          let _this = this
          this.$axios.post('/api/user/username',qs.stringify(params)).then(function (response) {
            _this.name = response.data
          })
        }
      }
    }
</script>

<style lang="stylus" scoped>
  @keyframes star1{
    0%, 100%, 50% {
      opacity: 1;
    }
    25%, 75% {
      opacity: .1;
    }
  }
  @-webkit-keyframes star1{
    0%, 100%, 50% {
      opacity: 1;
    }
    25%, 75% {
      opacity: .1;
    }
  }
  .ani-star1{
    animation:star1 4.5s both infinite linear;
    -webkit-animation:star1 4.5s both infinite linear;
    -moz-animation:star1 4.5s both infinite linear;
    -ms-animation:star1 4.5s both infinite linear;
  }

  patient-nav
    position absolute
    top 0px
  #P_id
    margin-top 10px
    margin-left 100px
    font-size 20px
    color white
  #PatientHome
    background-color #787878
    position absolute
    width 100%
    height 100%
    overflow hidden
    opacity 0.8
  .P_background
    position absolute
    width 100%
    height 100%
    overflow hidden
    background-image url("../../assets/picture/patient/patient.jpg")
    background-size cover
    background-repeat: no-repeat no-repeat;
    background-position center bottom
    opacity 0.6
</style>
