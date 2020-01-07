<template>
  <div>
    <div id="back" @click="back()"></div>
    <particles></particles>
    <login-body :statue="statue"></login-body>
  </div>
</template>

<script>
  import particles from 'particles.js'
  import Vue from 'vue'
  import particlesJS from '@/components/particles/ParticlesLogin'
  import LoginBody from './component/LoginBody'
  Vue.use(particles)
    export default {
      name: "Login",
      components:{
        Particles: particlesJS,
        LoginBody
      },
      data(){
        return{
          statue: ''
        }
      },
      created(){
        this.getRouterData()
      },
      methods:{
        back : function () {
          window.location.href = '/';
        },
        getRouterData(){
          this.statue = this.$route.params.statue
          console.log(this.statue)
        }
      }
    }
</script>

<style lang="stylus" scoped>
  #back
    position absolute
    width: 0;
    height: 0;
    border-top: 100px solid gray;
    border-right: 100px solid transparent;
  #back:hover
    position absolute
    width: 0;
    height: 0;
    border-top: 120px solid white;
    border-right: 120px solid transparent;
  #particles-js
    background-color grey
</style>
