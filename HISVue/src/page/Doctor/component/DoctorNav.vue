<template>
  <div>
    <div id="D_Nav">
      <div id="D_turn">
        <div id="Img1"><img id="listImg" src="../../../assets/list.png"></div>
      </div>
      <transition name="show1">
      <button id="D_book" @click="Book()" v-if="flag">
        <img src="../../../assets/time.png">
        预约时间</button>
      </transition>
      <transition name="show2">
      <button id="D_medicine" @click="Medicine()" v-if="flag">
        <img src="../../../assets/edit.png">
        开药单</button>
      </transition>
      <transition name="show3">
      <button id="D_doctor" @click="Record()" v-if="flag">
        <img src="../../../assets/order_unread.png">
        诊治记录</button>
      </transition>
      <transition name="show4">
      <button id="D_out" @click="quit()" v-if="flag">
        <img src="../../../assets/exit.png">
        退出</button>
      </transition>
    </div>
    <booking-list :No="No" v-if="isShow1"></booking-list>
    <record v-if="isShow2"></record>
    <medicine @event1="event1" :No="No" v-if="isShow3"></medicine>
    <div id="cover" v-if="showCover" @click="closeCover()">
    </div>
    <write-medicine v-if="showCover" :patient="patient"></write-medicine>
  </div>
</template>

<script>
    import BookingList from '@/page/Doctor/component/BookingList'
    import Record from '@/page/Doctor/component/Record'
    import Medicine from '@/page/Doctor/component/Medicine'
    import WriteMedicine from '@/page/Doctor/component/WriteMedicine'
    export default {
        name: "DoctorNav",
        props:{
          Dno:String
        },
        data(){
          return{
            No: '',
            isShow1:false,
            isShow2:false,
            isShow3:false,
            showCover:false,
            patient:{},
            flag:false
          }
        },
        components:{
          BookingList,
          Record,
          Medicine,
          WriteMedicine
        },
        mounted(){
          this.flag = true
        },
        methods:{
          quit(){
            window.location.href = '/'
          },
          getDno(){
            this.No = this.Dno
          },
          Book(){
            if(this.isShow1){
              this.isShow1 = false
            }else{
              this.isShow1 = true
              this.isShow2 = false
              this.isShow3 = false
            }
          },
          Record(){
            if(this.isShow2){
              this.isShow2 = false
            }else{
              this.isShow2 = true
              this.isShow1 = false
              this.isShow3 = false
            }
          },
          Medicine(){
            if(this.isShow3){
              this.isShow3 = false
            }else{
              this.isShow3 = true
              this.isShow1 = false
              this.isShow2 = false
            }
          },
          event1(data){
            this.showCover = true;
            this.patient = data
          },
          closeCover(){
            this.showCover = false;
          }
        },
        created(){
          this.getDno();
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

  #D_turn
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
  #D_Nav
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
  #D_book
    width 300px
    height 100px
    background-color black
    color white
    border 1px solid
    font-size 35px
    text-align center
    line-height 100px
  #D_book:hover
    font-size 45px
    color #333333
    background-color white
  #D_medicine
    width 300px
    height 100px
    background-color black
    color white
    border 1px solid
    font-size 35px
    text-align center
    line-height 100px
  #D_medicine:hover
    font-size 45px
    color #333333
    background-color white
  #D_doctor
    width 300px
    height 100px
    background-color black
    color white
    border 1px solid
    font-size 35px
    text-align center
    line-height 100px
  #D_doctor:hover
    font-size 45px
    color #333333
    background-color white
  #D_out
    width 300px
    height 100px
    background-color black
    color white
    border 1px solid
    font-size 35px
    text-align center
    line-height 100px
  #D_out:hover
    font-size 45px
    color #333333
    background-color white
  #cover
    z-index 101
    background-color black
    position absolute
    top 0
    width 100%
    height 100%
    overflow hidden
    opacity 0.8
</style>
