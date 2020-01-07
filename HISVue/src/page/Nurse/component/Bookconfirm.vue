<template>
  <div id="B_list">
    <table v-model="showList">
      <tr>
        <th>诊单号</th>
        <th>诊科</th>
        <th>病人编号</th>
        <th>病人姓名</th>
        <th>预约日期</th>
        <th>就诊确认</th>
      </tr>
      <tr v-for="item of showList">
        <td>{{item[2]}}</td>
        <td>{{item[5]}}</td>
        <td>{{item[1]}}</td>
        <td>{{item[0]}}</td>
        <td>{{item[4]}}</td>
        <td id="book_confirm" @click="finishBook(item[2],item[3],item[1],item[4])">已就诊</td>
      </tr>
    </table>
  </div>
</template>

<script>
    import qs from 'qs'
    export default {
        name: "Bookconfirm",
        inject:['reload'],
      data(){
        return{
          bookingList: [],
          Dno:'',
          InDno:{
            InDno:''
          },
          consultInfo:{
            Pno:'',
            Dno:'',
            CDate:''
          },
          deleteInfo:{
            Bno:''
          },
          showList:[]
        }
      },
      methods:{
         refresh(){
           this.reload()
         } ,
        getBookingList(){
          this.Dno = this.No
          let _this = this
          this.InDno.InDno = this.Dno
          this.$axios.post('/api/booking/showall').then(function (response1) {
            console.log(response1.data)
            _this.showList = response1.data
            console.log(_this.showList)
          })
        },
        finishBook(Bno,Dno,Pno,BDay){
          this.consultInfo.Dno = Dno
          this.consultInfo.Pno = Pno
          this.consultInfo.CDate = BDay
          let params1 = this.consultInfo
          this.deleteInfo.Bno = Bno
          let _this = this
          this.$axios.post('/api/consult/save',qs.stringify(params1)).then(function (response1) {
            let params2 = _this.deleteInfo
            _this.$axios.post('/api/booking/delete',qs.stringify(params2)).then(function (response2) {
              alert("完成确认")
              _this.refresh()
            })
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
      #book_confirm:hover
        background-color red
        color white
        opacity 1
        font-size 22px
</style>
