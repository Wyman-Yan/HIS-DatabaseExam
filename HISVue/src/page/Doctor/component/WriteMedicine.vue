<template>
    <div id="D_Medicine">
      <table v-model="storageInfo">
        <tr>
          <th>CAS</th>
          <th>药品名</th>
          <th>药品库存</th>
          <th>药品单价</th>
          <th>添加</th>
        </tr>
        <tr v-for="item of storageInfo">
          <td>{{item.sno}}</td>
          <td>{{item.sname}}</td>
          <td>{{item.scount}}</td>
          <td>{{item.svalue}}</td>
          <td id="add" @click="addMedicine(item.sname,item.sno)">添加</td>
        </tr>
      </table>
      <div id="P_text">
        {{this.patientInfo[1]}}号病人{{this.patientInfo[0]}}的药单：
      </div>
      <div id="P_medicine" v-for="item of this.patientStorage">
        {{item.Sno}}   {{item.Sname}}
      </div>
      <button id="createMedicine" @click="insertMedicine()">创建药单</button>
    </div>
</template>

<script>
  import qs from 'qs'
    export default {
        name: "WriteMedicine",
      inject:['reload'],
        props:{
          patient:Array
        },
        data(){
          return{
            patientInfo:{},
            storageInfo:[],
            patientStorage:[],
            createM : {
              Pno:'',
              Sno:'',
              Mnum:'',
              Cno:''
            }
          }
        },
        methods:{
          refresh(){
            this.reload()
          } ,
          getPatient(){
            this.patientInfo = this.patient
            console.log("********" + this.patientInfo)
            let _this = this
            this.$axios.get('/api/storage/list').then(function (response) {
              _this.storageInfo = response.data
            })
          },
          addMedicine(name,sno) {
            let StorageItem = {
              Sno: '',
              Sname: '',
              Pno: this.patientInfo[1],
              Cno: this.patientInfo[0],
              Dno: this.patientInfo[4],
              Mnum: 1
            }
            StorageItem.Sno = sno
            StorageItem.Sname = name
            if (this.patientStorage.length == 0){
              this.patientStorage.push(StorageItem)
            } else {
              let count = 0
              this.patientStorage.forEach(item => {
                if (item.Sno == StorageItem.Sno) {
                  let newnum = item.Mnum +1
                  this.$set(item,'Mnum',newnum)
                }else{
                  count++
                }
              })
              if (count == this.patientStorage.length ){
                this.patientStorage.push(StorageItem)
              }
            }
          },
          insertMedicine(){
            this.patientStorage.forEach(item => {
              this.createM.Pno = item.Pno
              this.createM.Sno = item.Sno
              this.createM.Mnum = item.Mnum
              this.createM.Cno = item.Cno
              alert(item.Cno)
              let params = this.createM
              let _this = this
              console.log(_this.createM)
              this.$axios.post('/api/medicine/save',qs.stringify(params)).then(function (response) {
                alert("成功书写药单")
                _this.refresh();
              })
            })
          }
        },
        created(){
          this.getPatient();
        }
    }
</script>

<style lang="stylus" scoped>
  #D_Medicine
    z-index 120
    position absolute
    top 80px
    left 400px
    width 700px
    height 650px
    background-color white
    opacity 0.9
    border-radius 10px
    table
      margin-top 20px
      margin-left 20px
      font-size 16px
      background-color #333333
      color white
      border: 1px solid white
      font-weight bold
      text-align center
      tr
        border: 1px solid white
        color white
        width 120px
      th
        border: 1px solid white
        color white
        width 120px
      th:hover
        background-color white
        color dimgrey
        opacity 1
      td
        border: 1px solid white
        color white
        width 120px
      td:hover
        background-color white
        color dimgrey
        opacity 1
      #add:hover
        background-color red
        color white
  #P_text
    color #333333
    font-weight bolder
    font-size 18px
    margin-top 15px
    margin-left 30px
  #P_medicine
    color #333333
    font-weight bolder
    font-size 14px
    margin-top 15px
    margin-left 50px
    line-height 8px
  #createMedicine
    position absolute
    right 5px
    bottom 5px
    width 150px
    height 50px
    border-radius 10px
    background-color #507fff
    font-size 16px
    color white
  #createMedicine:hover
    background-color red
    font-size 20px
    color white
</style>
