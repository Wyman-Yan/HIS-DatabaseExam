<template>
  <div>
  <div id="P_Nav">
    <div id="P_turn">
      <div id="Img1"><img id="listImg" src="../../../assets/list.png"></div>
    </div>
    <transition name="show1">
    <button id="P_book" @click="Book()" v-if="flag">
      <img src="../../../assets/time.png">
      预约
    </button>
    </transition>
    <transition name="show2">
    <button id="P_medicine" @click="GetMedicine()" v-if="flag">
      <img src="../../../assets/order_unread.png">
      药单
    </button>
    </transition>
      <transition name="show3">
    <button id="P_doctor" @click="changeMes()" v-if="flag">
      <img src="../../../assets/edit.png">
      修改信息
    </button>
      </transition>
    <transition name="show4">
    <button id="P_out" @click="quit()" v-if="flag">
      <img src="../../../assets/exit.png">
      退出
    </button>
    </transition>
  </div>
    <patient-book :No="No" v-if="isShow1"></patient-book>
    <patient-medicine :No="No" v-if="isShow2"></patient-medicine>
    <patient-detail :No="No" v-if="isShow3"></patient-detail>
  </div>
</template>

<script>
    import PatientBook from '@/page/patient/component/PatientBook'
    import PatientMedicine from '@/page/patient/component/PatientMedicine'
    import PatientDetail from '@/page/patient/component/PatientDetail'
    export default {
        name: "PatientNav",
        props:{
          Pno:String
        },
        data(){
          return{
            isShow1:false,
            isShow2:false,
            isShow3:false,
            No: '',
            flag:false
          }
        },
        created(){
          this.getPno();
        },
        mounted(){
          this.flag = true
        },
        components:{
          PatientBook,
          PatientMedicine,
          PatientDetail
        },
        methods:{
          quit(){
            window.location.href = '/'
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
          GetMedicine(){
            if(this.isShow2){
              this.isShow2 = false
            }else{
              this.isShow2 = true
              this.isShow1 = false
              this.isShow3 = false
            }
          },
          changeMes(){
            if(this.isShow3){
              this.isShow3 = false
            }else{
              this.isShow3 = true
              this.isShow1 = false
              this.isShow2 = false
            }
          },
          getPno(){
            this.No = this.Pno;
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

  #P_Nav
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
  #P_turn
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
  #P_book
    width 300px
    height 100px
    background-color black
    color white
    border 1px solid
    font-size 35px
    text-align center
    line-height 100px
  #P_book:hover
    font-size 45px
    color #333333
    background-color white
  #P_medicine
    width 300px
    height 100px
    background-color black
    color white
    border 0.5px solid
    font-size 35px
    text-align center
    line-height 100px
  #P_medicine:hover
    font-size 45px
    color #333333
    background-color white
  #P_doctor
    width 300px
    height 100px
    background-color black
    color white
    border 0.5px solid
    font-size 35px
    text-align center
    line-height 100px
  #P_doctor:hover
    font-size 45px
    color #333333
    background-color white
  #P_out
    width 300px
    height 100px
    background-color black
    color white
    border 0.5px solid
    font-size 35px
    text-align center
    line-height 100px
  #P_out:hover
    font-size 45px
    color #333333
    background-color white
</style>
