<template>
  <div id="P_Book">
    <span>
      <label>选择医生：</label>
      <select v-model="Dno">
        <option v-for="item of doctorList" :value='item.dno'>{{item.dname}}</option>
      </select>
    </span><br>
    <span>
      <label>预约日期:</label>
      <input type="date" v-model="date" />
    </span><br>
    <span>
      <input id="book_submit" type="button" value="预约" @click="submitBook()"/>
    </span>
  </div>
</template>

<script>
  import qs from 'qs'
    export default {
        name: "PatientBoot",
        inject:['reload'],
        props:{
          No:String
        },
        data(){
          return{
            doctorList: [],
            Pno: '',
            BookInfo:{
              Pno: '',
              Dno: '',
              BDay: ''
            },
            Dno: '',
            date: ''
          }
        },
        created(){
          this.getPno();
        },
        mounted(){
          this.getDoctorList()
        },
        methods:{
          refresh(){
            this.reload();
          },
          getDoctorList(){
            let _this = this
            this.$axios.get('/api/worker/list').then(function (response) {
              _this.doctorList = response.data
              console.log(_this.doctorList)
            })
          },
          submitBook(){
            console.log(this.Pno)
            this.BookInfo.Pno = this.Pno
            this.BookInfo.Dno = this.Dno
            this.BookInfo.BDay = this.date
            let params = this.BookInfo
            let _this = this
            this.$axios.post('/api/booking/save',qs.stringify(params)).then(function (response) {
                console.log(response)
                alert("预约成功")
                _this.refresh()
            })
          },
          getPno(){
            this.Pno = this.No
          }
        }
    }
</script>

<style lang="stylus" scoped>
  #P_Book
    position absolute
    padding 100px 100px
    top 130px
    left 500px
    width 300px
    height 300px
    background-color dimgrey
    color white
    border 1px solid
    border-radius 50px
    line-height 80px
    opacity 0.6
    font-size 30px
    select
      height 30px
      font-size 20px
    input
      height 30px
      font-size 20px
    #book_submit
      width 100px
      height 50px
      border-radius 15px
      margin-left 100px
</style>
