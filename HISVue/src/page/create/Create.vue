<template>
  <div>
    <div id="back" @click="back()"></div>
    <particles>
    </particles>
    <create-body></create-body>
  </div>
</template>

<script>
  import particles from 'particles.js'
  import Vue from 'vue'
  import particlesJS from '@/components/particles/ParticlesCreate'
  import CreateBody from './component/CreateBody'

  Vue.use(particles)
    export default {
        name: "Create",
      components:{
        Particles: particlesJS,
        CreateBody
      },
      methods:{
        back : function () {
          window.location.href = '/';
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
</style>
