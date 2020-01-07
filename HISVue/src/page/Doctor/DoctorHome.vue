<template>
<div id="DoctorHome">
  <div class="ani-star1" id="D_id">你好！{{name}}医生</div>
  <div class="D_background"></div>
  <doctor-nav :Dno="Dno"></doctor-nav>
</div>
</template>

<script>
  import DoctorNav from '@/page/Doctor/component/DoctorNav'
  import qs from 'qs'
    export default {
        name: "DoctorHome",
        data(){
          return{
            loginuser: '',
            name: '',
            Dno: '',
            SearchName:{
              InUno:''
            }
          }
        },
        created(){
          this.getRouterData()
        },
        components:{
          DoctorNav
        },
        methods:{
          getRouterData(){
            this.loginuser = this.$route.params.loginuser
            this.name = this.loginuser.Uname,
            this.Dno = this.loginuser.Uno
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
  #D_id
    margin-top 10px
    margin-left 100px
    font-size 20px
    color white
  #DoctorHome
    background-color #787878
    position absolute
    width 100%
    height 100%
    overflow hidden
    opacity 0.8
  .D_background
    position absolute
    width 100%
    height 100%
    overflow hidden
    background-image url("../../assets/picture/doctor/doctor.jpg")
    background-size cover
    background-repeat: no-repeat no-repeat;
    background-position center bottom
    opacity 0.6
</style>
