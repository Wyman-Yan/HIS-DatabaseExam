<template>
  <div>
    <div id="N_Nav">
      <div id="N_turn">
        <div id="Img1"><img id="listImg" src="../../../assets/list.png"></div>
      </div>
      <transition name="show1">
      <button id="N_book" @click="Book1()" v-if="flag">
        <img src="../../../assets/order_unread.png">
        预约时间</button>
      </transition>
      <transition name="show2">
      <button id="N_medicine" @click="GiveMedi()" v-if="flag">
        <img src="../../../assets/sub_account.png">
        开药</button>
      </transition>
      <transition name="show3">
      <button id="N_doctor"  @click="Book2()" v-if="flag">
        <img src="../../../assets/check.png">
        确定就诊</button>
      </transition>
      <transition name="show4">
      <button id="N_out" @click="quit()" v-if="flag">
        <img src="../../../assets/exit.png">
        退出</button>
      </transition>
    </div>
    <booking-list :No="No" v-if="isShow1"></booking-list>
    <bookconfirm v-if="isShow2"></bookconfirm>
    <give-medicine v-if="isShow3"></give-medicine>
  </div>
</template>

<script>
  import BookingList from '@/page/Nurse/component/BookingList'
  import Bookconfirm from '@/page/Nurse/component/Bookconfirm'
  import GiveMedicine from '@/page/Nurse/component/GiveMedicine'
    export default {
        name: "NurseNav",
      data(){
        return{
          No: '',
          isShow1:false,
          isShow2:false,
          isShow3:false,
          flag:false
        }
      },
      components:{
        BookingList,
        Bookconfirm,
        GiveMedicine
      },
      mounted(){
        this.flag = true
      },
      methods:{
        quit(){
          window.location.href = '/'
        },
        Book1(){
          if(this.isShow1){
            this.isShow1 = false
          }else{
            this.isShow1 = true
            this.isShow2 = false
            this.isShow3 = false
          }
        },
        Book2(){
          if(this.isShow2){
            this.isShow2 = false
          }else{
            this.isShow2 = true
            this.isShow1 = false
            this.isShow3 = false
          }
        },
        GiveMedi(){
          if(this.isShow3){
            this.isShow3 = false
          }else{
            this.isShow3 = true
            this.isShow1 = false
            this.isShow2 = false
          }
        }
      }
    }
</script>

<style lang="stylus" scoped>

  .show1-enter
    opacity: 0
    transform: translateX(350px)
  .show1-enter-active
    transition: all 1.2s ease
  .show2-enter
    opacity: 0
    transform: translateX(350px)
  .show2-enter-active
    transition: all 2.2s ease
  .show3-enter
    opacity: 0
    transform: translateX(350px)
  .show3-enter-active
    transition: all 3.2s ease
  .show4-enter
    opacity: 0
    transform: translateX(650px)
  .show4-enter-active
    transition: all 4.2s ease

  #N_Nav
    position absolute
    top 37px
    left 0px
    width 300px
    height 730px
    background-color black
    z-index 100
    opacity 0.8
    img
      height 40px
      width 40px
      line-height 100px
      margin-right 15px
  #N_turn
    height 50px
    background-color black
    border 0.5px solid white
    #Img1
      position relative
      float right
      height 50px
      width 60px
    #listImg
      position relative
      float right
      margin-top 5px
      margin-right 5px
      height 40px
      width 40px
  #N_book
    width 300px
    height 100px
    background-color black
    color white
    border 1px solid
    font-size 35px
    text-align center
    line-height 100px
  #N_book:hover
    font-size 45px
    color #333333
    background-color white
  #N_medicine
    width 300px
    height 100px
    background-color black
    color white
    border 1px solid
    font-size 35px
    text-align center
    line-height 100px
  #N_medicine:hover
    font-size 45px
    color #333333
    background-color white
  #N_doctor
    width 300px
    height 100px
    background-color black
    color white
    border 1px solid
    font-size 35px
    text-align center
    line-height 100px
  #N_doctor:hover
    font-size 45px
    color #333333
    background-color white
  #N_out
    width 300px
    height 100px
    background-color black
    color white
    border 1px solid
    font-size 35px
    text-align center
    line-height 100px
  #N_out:hover
    font-size 45px
    color #333333
    background-color white
</style>
