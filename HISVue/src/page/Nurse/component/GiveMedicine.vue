<template>
  <div id="give">
    <table v-model="MedicineInfo">
      <tr>
        <th>诊治号</th>
        <th>药单号</th>
        <th>药品号</th>
        <th>病人编号</th>
        <th>药品数量</th>
        <th>药库取药</th>
      </tr>
      <tr v-for="item of MedicineInfo">
        <td>{{item.cno}}</td>
        <td>{{item.mno}}</td>
        <td>{{item.sno}}</td>
        <td>{{item.pno}}</td>
        <td>{{item.mnum}}</td>
        <th id="getM" @click="reduce(item)">取药</th>
      </tr>
    </table>
  </div>
</template>

<script>
  import qs from 'qs'
    export default {
        name: "GiveMedicine",
      inject:['reload'],
      data(){
        return{
          MedicineInfo:[],
          getRemain:{
            InSno:''
          },
          remain:'',
          reduceInfo:{
            Sno:'',
            Sname:'',
            Scount:'',
            Svalue:''
          },
          deleteInfo:{
            InMno:''
          }
        }
      },
      methods:{
        refresh(){
          this.reload()
        },
        getMedicine(){
          let _this = this
          this.$axios.get('/api/medicine/list').then(function (response) {
            _this.MedicineInfo = response.data
            console.log(_this.MedicineInfo)
          })
        },
        reduce(item){
          this.getRemain.InSno = item.sno
          this.deleteInfo.InMno = item.mno
          let params = this.getRemain
          let _this = this
          this.$axios.post('/api/storage/remain',qs.stringify(params)).then(function (response) {
            _this.remain = response.data[0]
            _this.reduceInfo.Sno = _this.remain[0]
            _this.reduceInfo.Sname = _this.remain[1]
            _this.reduceInfo.Svalue = _this.remain[3]
            _this.reduceInfo.Scount = _this.remain[2] - item.mnum
            let params2 = _this.reduceInfo
            _this.$axios.post('/api/storage/save',qs.stringify(params2)).then(function (response) {
              let params3 = _this.deleteInfo
              _this.$axios.post('/api/medicine/delete',qs.stringify(params3)).then(function (response) {
                alert("取药成功")
                _this.refresh()
              })
            })
          })
        }
      },
      created(){
          this.getMedicine();
      }
    }
</script>

<style lang="stylus" scoped>
  #give
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
        width 90px
      th
        padding 5px 5px
        border: 1px solid white
        color white
        width 90px
      th:hover
        background-color white
        color dimgrey
        opacity 1
      td
        padding 5px 5px
        border: 1px solid white
        color white
        width 90px
      td:hover
        background-color white
        color dimgrey
        opacity 1
      #getM:hover
        background-color red
        color white
</style>
