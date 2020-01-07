<template>
  <div class="foot">
    <p>友情链接</p>
    <a href="http://www.nhc.gov.cn/" target="_blank">中华人民共和国国家卫生健康委员会</a>
    <a href="http://www.cams.ac.cn/" target="_blank">中国医学科学院</a>
    <p>关于我们</p>
    <p>地址：广东省广州市番禺区中环西路100号</p>
    <p>服务热线：15913106264</p>
    <p>京ICP 备 05067313号-1 文保网安备案号：1101010023 京卫网审字【2014】第39号</p>
  </div>
</template>

<script>
    export default {
        name: "Welcome_Footer"
    }
</script>

<style lang="stylus" scoped>
  .foot
    position absolute
    display block
    height 238px
    width 100%
    color #b2b2b2
    line-height 20px
    font-size 12px
    background-color #333
    top 1120px
    background-size cover
    opacity 0.9
    a
      text-decoration none
      color #b2b2b2
      margin-left 25px
    p
      margin-left 25px
</style>
