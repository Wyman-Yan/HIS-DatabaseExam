<template>
  <div id="B_list">
    <table v-model="showList">
      <tr>
        <th>诊单号</th>
        <th>诊科</th>
        <th>病人编号</th>
        <th>病人姓名</th>
        <th>预约日期</th>
      </tr>
      <tr v-for="item of showList">
        <td>{{item[2]}}</td>
        <td>{{item[5]}}</td>
        <td>{{item[1]}}</td>
        <td>{{item[0]}}</td>
        <td>{{item[4]}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
  export default {
    name: "BookingList",
    props:{
      No:String
    },
    data(){
      return{
        bookingList: [],
        Dno:'',
        InDno:{
          InDno:''
        },
        showList:[]
      }
    },
    methods:{
      getBookingList(){
        this.Dno = this.No
        let _this = this
        this.InDno.InDno = this.Dno
        this.$axios.post('/api/booking/showall').then(function (response1) {
          console.log(response1.data)
          _this.showList = response1.data
          console.log(_this.showList)
        })
      }
    },
    created(){
      this.getBookingList();
    }
  }
</script>

<style lang="stylus" scoped>
  #B_list
    position absolute
    top 80px
    left 400px
    width 600px
    height 500px
    padding 50px
    background-color dimgrey
    color white
    border 1px solid
    border-radius 50px
    opacity 0.6
    font-size 30px
    table
      font-size 16px
      color white
      border: 1px solid white
      font-weight bold
      text-align center
      tr
        border: 1px solid white
        color white
        width 100px
      th
        border: 1px solid white
        color white
        width 100px
      th:hover
        background-color white
        color dimgrey
        opacity 1
      td
        border: 1px solid white
        color white
        width 100px
      td:hover
        background-color white
        color dimgrey
        opacity 1
</style>
