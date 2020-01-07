<template>
  <div id="NurseHome">
    <div class="ani-star1" id="N_id">你好！{{name}}护士</div>
    <div class="N_background"></div>
    <nurse-nav></nurse-nav>
  </div>
</template>

<script>
  import NurseNav from '@/page/Nurse/component/NurseNav'
  import qs from 'qs'
    export default {
        name: "NurseHome",
      data(){
        return{
          loginuser: '',
          name: '',
          Nno: '',
          SearchName:{
            InUno:''
          }
        }
      },
      created(){
        this.getRouterData()
      },
      components:{
        NurseNav
      },
      methods:{
        getRouterData(){
          this.loginuser = this.$route.params.loginuser
          this.name = this.loginuser.Uname,
            this.Nno = this.loginuser.Uno
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
  #N_id
    margin-top 10px
    margin-left 100px
    font-size 20px
    color white
  #NurseHome
    background-color #787878
    position absolute
    width 100%
    height 100%
    overflow hidden
    opacity 0.8
  .N_background
    position absolute
    width 100%
    height 100%
    overflow hidden
    background-image url("../../assets/picture/nurse/nurse.jpg")
    background-size cover
    background-repeat: no-repeat no-repeat;
    background-position center bottom
    opacity 0.6
</style>
