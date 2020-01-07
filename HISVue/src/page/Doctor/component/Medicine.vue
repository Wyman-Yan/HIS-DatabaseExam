<template>
    <div id="D_Medicine">
      <table v-model="patientList">
        <tr>
          <th>诊单号</th>
          <th>诊科</th>
          <th>病人编号</th>
          <th>病人姓名</th>
          <th>诊治日期</th>
          <th>开药</th>
        </tr>
        <tr v-for="item of patientList">
          <td>{{item[0]}}</td>
          <td>{{item[3]}}</td>
          <td>{{item[1]}}</td>
          <td>{{item[4]}}</td>
          <td>{{item[2]}}</td>
          <td @click="toParentMeth(item)" id="giveMedi" >开药</td>
        </tr>
      </table>
    </div>
</template>

<script>
  import qs from 'qs'
    export default {
      name: "Medicine",
      props:{
        No:String
      },
      data(){
        return{
          Dno:'',
          InDno:{
            InDno:''
          },
          patientList:[],
          isShow:false,
          toP:true
        }
      },
      methods: {
        getMyPatient() {
          this.Dno = this.No
          let _this = this
          this.InDno.InDno = this.Dno
          let params = this.InDno
          this.$axios.post('/api/consult/serach', qs.stringify(params)).then(function (response) {
            _this.patientList = response.data;
            console.log(_this.patientList)
          })
        },
        toParentMeth(item){
          this.$emit('event1',item)
        }
      },
      created(){
        this.getMyPatient()
      }
    }
</script>

<style lang="stylus" scoped>
  #D_Medicine
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
    line-height 80px
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
      #giveMedi:hover
        background-color red
        color white
        opacity 1
        font-size 22px
</style>
