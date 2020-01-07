<template>
  <div style="min-height:730px; height:100px">
    <div id="particles-js"></div>
  </div>
</template>

<script>
  import particlesConfig from "./particles.json";
  export default {
    data() {
      return {};
    },
    mounted() {
      this.init();
    },
    methods: {
      init() {
        particlesJS("particles-js", particlesConfig);
        document.body.style.overflow = "hidden";
      }
    }
  }
</script>

<style lang="stylus" scoped>
  #particles-js
    width: 100%
    height: 130%
    background-color: dimgrey
    background-size: cover
    background-position: 50% 50%
    background-repeat: no-repeat
</style>
