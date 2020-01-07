<template>
    <div id="PatientMedicine">
      <table v-model="myList">
        <tr>
          <th>诊治号</th>
          <th>药单号</th>
          <th>药品号</th>
          <th>药品名</th>
          <th>药品数量</th>
        </tr>
        <tr v-for="item of myList">
          <td>{{item[0]}}</td>
          <td>{{item[1]}}</td>
          <td>{{item[2]}}</td>
          <td>{{item[4]}}</td>
          <td>{{item[3]}}</td>
        </tr>
      </table>
    </div>
</template>

<script>
  import qs from 'qs'
    export default {
        name: "PatientMedicine",
        props:{
          No:String
        },
      data(){
          return{
            Pno:'',
            getList:{
              Pa:''
            },
            myList:[]
          }
      },
      methods:{
        getMedicineList(){
          this.Pno = parseInt(this.No)
          this.getList.Pa = parseInt(this.Pno)
          let params = this.getList
          let _this = this
          this.$axios.post('/api/medicine/mymedicine',qs.stringify(params)).then(function (response) {
            _this.myList = response.data
            console.log(_this.myList)
          })
        }
      },
      created(){
          this.getMedicineList();
      }
    }
</script>

<style lang="stylus" scoped>
  #PatientMedicine
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
      margin-top 20px
      font-size 12px
      color white
      border: 1px solid white
      font-weight bold
      text-align center
      tr
        padding 5px 5px
        border: 1px solid white
        color white
        width 100px
      th
        padding 5px 5px
        border: 1px solid white
        color white
        width 100px
      th:hover
        background-color white
        color dimgrey
        opacity 1
      td
        padding 5px 5px
        border: 1px solid white
        color white
        width 100px
      td:hover
        background-color white
        color dimgrey
        opacity 1
</style>
