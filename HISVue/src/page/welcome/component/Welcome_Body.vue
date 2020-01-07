<template>
  <div class="W_body">
    <ul class="W_link">
      <transition name="show1">
      <li class="L1" v-if="flag">
        <span>
          <img src="@/assets/picture/welcome/patience.png" class="star1 ani-star1">
          <div>患者</div>
          <a @click="PatientIn()" class="W_In">进入</a>
        </span>
      </li>
      </transition>
      <transition name="show2">
      <li class="L2" v-if="flag">
        <span>
          <img src="@/assets/picture/welcome/doctor.png" class="star1 ani-star2">
          <div>医生</div>
          <a class="W_In" @click="DoctorIn()">进入</a>
        </span>
      </li>
      </transition>
      <transition name="show3">
      <li class="L3" v-if="flag">
        <span>
          <img src="@/assets/picture/welcome/nurse.png" class="star1 ani-star3">
          <div>护士</div>
          <a class="W_In" @click="NurseIn()">进入</a>
        </span>
      </li>
      </transition>
      <transition name="show4">
      <li class="L4" v-if="flag">
        <span>
          <img src="@/assets/picture/welcome/create.png" class="star1 ani-star4">
          <div>注册</div>
          <router-link :to="{name:'Create'}">
          <a href="/create" class="W_In">进入</a>
          </router-link>
        </span>
      </li>
      </transition>
    </ul>
  </div>
</template>

<script>
  import FadeAnimation from '@/common/fade/FadeAnimation'
    export default {
      name: "Welcome_Body",
      data(){
        return{
          flag:false
        }
      },
      components: {
        FadeAnimation
      },
      mounted(){
        this.flag = true
      },
      methods : {
        PatientIn(){
          this.$router.push({
            name: 'Login',
            params:{
              statue: 'patient'
            }
          })
        },
        DoctorIn(){
          this.$router.push({
            name: 'Login',
            params: {
              statue: 'doctor'
            }
          })
        },
        NurseIn(){
          this.$router.push({
            name: 'Login',
            params: {
              statue: 'nurse'
            }
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
    animation:star1 3.8s both infinite linear;
    -webkit-animation:star1 3.8s both infinite linear;
    -moz-animation:star1 3.8s both infinite linear;
    -ms-animation:star1 3.8s both infinite linear;
  }
  .ani-star2{
    animation:star1 4.2s both infinite linear;
    -webkit-animation:star1 4.2s both infinite linear;
    -moz-animation:star1 4.2s both infinite linear;
    -ms-animation:star1 4.2s both infinite linear;
  }
  .ani-star3{
    animation:star1 4.6s both infinite linear;
    -webkit-animation:star1 4.6s both infinite linear;
    -moz-animation:star1 4.6s both infinite linear;
    -ms-animation:star1 4.6s both infinite linear;
  }
  .ani-star4{
    animation:star1 5.0s both infinite linear;
    -webkit-animation:star1 5.0s both infinite linear;
    -moz-animation:star1 5.0s both infinite linear;
    -ms-animation:star1 5.0s both infinite linear;
  }

  .show1-enter
    opacity: 0
    transform: translateX(350px)
  .show1-enter-active
    transition: all 0.8s ease
  .show2-enter
    opacity: 0
    transform: translateX(350px)
  .show2-enter-active
    transition: all 1.8s ease
  .show3-enter
    opacity: 0
    transform: translateX(350px)
  .show3-enter-active
    transition: all 2.8s ease
  .show4-enter
    opacity: 0
    transform: translateX(650px)
  .show4-enter-active
    transition: all 3.8s ease


  #Welcome
    position absolute
    width 100%
    height 130%
    overflow hidden
    background-image url("../.././../assets/picture/welcome/welcome.jpg")
    background-size cover
    background-repeat: no-repeat no-repeat;
    background-position center bottom
    #logo
      position: absolute;
      left: 40px;
      top: 45px;
      width: 156px;
      height: 133px;
    .W_link
      position: absolute;
      left: 0;
      right: 0;
      top: 312px;
    .W_link li
      position absolute
      border-radius 8px
      -webkit-box-shadow 0px 16px 24px 0px rgba(0, 0, 0, 0.4)
      box-shadow 0px 16px 24px 0px rgba(0, 0, 0, 0.4)
      text-align center
      overflow hidden
      color #fff
    .W_link li img
      margin-top: 54px;
    .L1
      right 50%
      top 42px
      width 291px
      height 265px
      margin-right 183px
      background-color #5fbac0
      opacity 0.8
      div
        font-size 30px
        margin-top 10px
        margin-bottom 15px
      a
        background-color #5fbac0
        color white
        padding-bottom 20px
        text-decoration none
    .L2
      right 50%
      top 124px
      width 281px
      height 261px
      margin-right -62px
      background-color #f5d58d
      opacity 0.8
      div
        font-size 30px
        margin-top 10px
        margin-bottom 15px
      a
        background-color #f5d58d
        color white
        padding-bottom 20px
        text-decoration none
    .L3
      left 50%
      top 0
      width 241px
      height 261px
      margin-left 21px
      background-color #fff
      opacity 0.8
      div
        font-size 30px
        color black
        margin-top 10px
        margin-bottom 15px
      a
        background-color #fff
        color black
        padding-bottom 20px
        text-decoration none
    .L4
      left: 50%
      top: 82px
      width: 251px
      height: 263px
      margin-left: 221px
      background: #00a04e;
      opacity 0.8
      img
        width 78px
        height 76px
      div
        font-size 30px
        color white
        margin-top 10px
        margin-bottom 15px
      a
        background-color #00a04e
        color white
        padding-bottom 20px
        text-decoration none
    .W_In
      display: block
      width: 112px
      height: 35px
      margin: auto
      border-radius: 15px
      -webkit-box-shadow: 0px 0px 16px 0px rgba(2, 2, 2, 0.35)
      box-shadow: 0px 0px 16px 0px rgba(2, 2, 2, 0.35)
      font-size: 20px
      line-height: 55px
      text-decoration: none
      opacity 1 !important
    .W_In:hover
      width 120px
      height 45px
      font-size 25px
      line-height 60px
      border-radius 15px 15px 0 0
    .L1:hover
      opacity 1
      z-index 10
      box-shadow: 20px 20px 5px rgba(2, 2, 2, 0.35)
    .L2:hover
      opacity 1
      z-index 10
      box-shadow: 20px 20px 5px rgba(2, 2, 2, 0.35)
    .L3:hover
      opacity 1
      z-index 10
      box-shadow: 20px 20px 5px rgba(2, 2, 2, 0.35)
    .L4:hover
      opacity 1
      z-index 10
      box-shadow: 20px 20px 5px rgba(2, 2, 2, 0.35)
</style>
