<template>
  <div id="Welcome">
    <div class="W_background">
      <img id="logo" src="../../assets/picture/bannerLogo.png">
    <home-body></home-body>
    </div>
    <home-footer></home-footer>
  </div>
</template>

<script>
import HomeBody from './component/Welcome_Body'
import HomeFooter from './component/Welcome_Footer'
export default {
  name: "Welcome",
  components:{
      HomeBody,
      HomeFooter
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
    animation:star1 5.5s both infinite linear;
    -webkit-animation:star1 5.5s both infinite linear;
    -moz-animation:star1 5.5s both infinite linear;
    -ms-animation:star1 5.5s both infinite linear;
  }

  .W_background
    position absolute
    width 100%
    height 180%
    overflow hidden
    background-image url(".././../assets/picture/welcome/welcome.jpg")
    background-size cover
    background-repeat: no-repeat no-repeat;
    background-position center bottom
  #logo
    position: absolute;
    left: 40px;
    top: 45px;
    width: 450px;
    height: 133px;
</style>
