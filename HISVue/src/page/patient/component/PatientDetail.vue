<template>
    <div id="P_detail">
      <div >
        <label>编号（无法修改）</label>
        <input :value='MPno' disabled/>
      </div>
      <div >
        <label>姓名</label>
        <input v-model='MPname'/>
      </div>
      <div>
        <label>性别</label>
        <input v-model='MPsex'/>
      </div>
      <div >
        <label>年龄</label>
        <input v-model='MPage'/>
      </div>
      <div>
        <label>家庭住址</label>
        <input v-model='MPaddr'/>
      </div>
      <div>
        <label>电话号码</label>
        <input v-model='MPtel'/>
      </div>
      <div>
        <button id="changeM" @click="changeNew()">修改</button>
      </div>
    </div>
</template>

<script>
  import qs from 'qs'
    export default {
        name: "PatientDetail",
      inject:['reload'],
      data(){
          return{
            MyPno:'',
            searchMy:{
              MyP:''
            },
            MyMessage:[],
            MPno:'',
            MPname:'',
            MPsex:'',
            MPage:'',
            MPaddr:'',
            MPtel:'',
            changeInfo:{
              Pno:'',
              Pname:'',
              Psex:'',
              Page:'',
              Paddr:'',
              Ptel:'',
            }
          }
      },
      props:{
        No:String
      },
      methods:{
        refresh(){
          this.reload()
        },
        getMy(){
          this.MyPno = parseInt(this.No)
          this.searchMy.MyP = parseInt(this.MyPno)
          let params = this.searchMy
          let _this = this
          this.$axios.post('/api/patient/mymess',qs.stringify(params)).then(function (response) {
            _this.MyMessage = response.data
    /*        console.log(_this.MyMessage)*/
              _this.MPno = _this.MyMessage[0][0]
              _this.MPname = _this.MyMessage[0][1]
              _this.MPsex = _this.MyMessage[0][2]
              _this.MPage = _this.MyMessage[0][3]
              _this.MPaddr = _this.MyMessage[0][4]
              _this.MPtel = _this.MyMessage[0][5]
          })
        },
        changeNew(){
          this.changeInfo.Pno = this.MPno
          this.changeInfo.Pname = this.MPname
          this.changeInfo.Psex = this.MPsex
          this.changeInfo.Page = this.MPage
          this.changeInfo.Paddr = this.MPaddr
          this.changeInfo.Ptel = this.MPtel
          let params = this.changeInfo
          let _this = this
          this.$axios.post('/api/patient/save',qs.stringify(params)).then(function (response) {
              console.log(response)
              alert("修改成功")
              _this.refresh()
          })
        }
      },
      created(){
          this.getMy();
      }
    }
</script>

<style lang="stylus" scoped>
  #P_detail
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
    div
      margin-left 30px
      height 80px
      input
        margin-left 20px
        font-size 20px
        height 30px
        padding 5px 10px
  #changeM
    position absolute
    right 40px
    bottom 20px
    width 150px
    height 50px
    border-radius 10px
    background-color #507fff
    font-size 16px
    color white
  #changeM:hover
    background-color red
    font-size 20px
    color white
</style>
