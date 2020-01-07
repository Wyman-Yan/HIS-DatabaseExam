<template>
    <div id="patient_record">
      <span>
        <label>查询病人：</label>
        <input v-model="MohuSearch" type="text"/>
        <input id="searchSubmit" type="submit" value="search" @click="MSearch()"/>
      </span>
      <table v-model="record">
        <tr>
          <th>病人编号</th>
          <th>病人姓名</th>
          <th>病人性别</th>
          <th>诊治时间</th>
          <th>诊治科</th>
        </tr>
        <tr v-for="item of record">
          <td>{{item[0]}}</td>
          <td>{{item[1]}}</td>
          <td>{{item[2]}}</td>
          <td>{{item[3]}}</td>
          <td>{{item[4]}}</td>
        </tr>
      </table>
    </div>
</template>

<script>
  import qs from 'qs'
    export default {
        name: "Record",
      data(){
          return{
            record: [],
            MohuSearch:'',
            SearchInfo:{
              Mohu:''
            }
          }
      },
      methods:{
        getRecord(){
          let _this = this
          this.$axios.get('/api/consult/listall').then(function (response) {
            /*_this.Pno = response.data.pno
            _this.Dno = response.data.dno*/
            _this.record = response.data
            console.log(_this.record)

          })
        },
        MSearch()
        {
          this.SearchInfo.Mohu = this.MohuSearch
          let params = this.SearchInfo
          let _this = this
          this.$axios.post('/api/consult/mohuSearch',qs.stringify(params)).then(function (response) {
            console.log(response)
            _this.record = response.data
          })
        }
      },
      mounted(){
          this.getRecord()
      }
    }
</script>

<style lang="stylus" scoped>
  #patient_record
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
    input
      padding 5px 10px
      height 25px
      font-size 16px
    #searchSubmit
      height 45px
      border-radius 5px
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
