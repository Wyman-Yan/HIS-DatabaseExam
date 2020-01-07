<template>
    <div id="create_body">
        <h2>注册用户</h2>
        <span>
            <label>用户身份：</label>
            <select  v-model="statue">
              <option value="病人">病人</option>
              <option value="医生">医生</option>
              <option value="护士">护士</option>
            </select><br/>
        </span>
        <span v-if="!isShow">
            <label>工号</label>
            <input type="text" v-model="CreateInfo.workno" /><br/>
        </span>
        <span>
          <label>姓名：</label>
          <input type="text" v-model="CreateInfo.username" /><br/>
        </span>
        <span v-if="isShow">
          <label>性别:</label>
          <select  v-model="sex">
              <option value="男">男</option>
              <option value="女">女</option>
            </select><br/>
        </span>
        <span>
          <label>密码：</label>
          <input type="password" v-model="CreateInfo.password" /><br/>
        </span>
        <span>
          <label>确认密码：</label>
          <input type="password" v-model="CreateInfo.pwdcomfirm" /><br/>
        </span>
        <span v-if="isShow">
          <label>手机号码：</label>
          <input type="text" v-model="CreateInfo.tel" /><br/>
        </span>
        <span v-if="isShow">
          <label>家庭住址：</label>
          <input type="text" v-model="CreateInfo.address" /><br/>
        </span>
        <span v-if="isShow">
          <label>年龄：</label>
          <input type="text" v-model="CreateInfo.age" /><br/>
        </span>
        <span>
          <input id="create_submit" type="submit" value="注册" @click="submit()" />
        </span>
    </div>
</template>

<script>
  import qs from 'qs'
  import md5 from 'js-md5';
    export default {
        name: "CreateBody",
      data() {
        return {
          statue: '',
          sex: '',
          isShow: true,
          CreateInfo: {
            workno: '',
            username: '',
            password: '',
            pwdcomfirm: '',
            tel: '',
            address: '',
            age: ''
          },
          worker:{
            Uno: '',
            Uname: '',
            Upwd: '',
            Uide: ''
          },
          patient: {
            Pno: '',
            Pname: '',
            Psex: '',
            Page: '',
            Paddr: '',
            Ptel: ''
          }
        }
      },
      watch:{
        statue: 'changeStatue'
      },
      methods:{
        changeStatue(statue){
          if (statue != '病人') {
            this.isShow = false
          }else {
            this.isShow = true
          }
        },
        submit(){
          if (this.statue == ''){
            alert("身份不能为空")
          }
          if (this.statue == '医生' || this.statue == '护士'){
            if (this.CreateInfo.workno == '' || this.CreateInfo.username == '' || this.CreateInfo.password == '' || this.CreateInfo.pwdcomfirm == ''){
              alert("填项不能为空");
            }else{
              if (this.CreateInfo.password != this.CreateInfo.pwdcomfirm) {
                alert("两次密码不一致");
                this.CreateInfo.password = '';
                this.CreateInfo.pwdcomfirm = '';
              }else{
                this.worker.Uno = this.CreateInfo.workno,
                this.worker.Uname = this.CreateInfo.username,
                this.worker.Upwd = md5(this.CreateInfo.password),
                this.worker.Uide = this.statue
                encodeURIComponent(this.worker)
                let params = this.worker
                console.log(this.worker);
                let _this = this
                this.$axios.post('/api/user/save',qs.stringify(params)
                ).then(function (response) {
                  if(response.status == 200){
                    alert("注册成功！用户账号为：" + _this.worker.Uno);
                    window.location.href = '/';
                  }
                }).catch(function (res) {
                  console.log(error);
                })
              }
            }
          }
          if (this.statue == '病人'){
            if (this.CreateInfo.username == '' || this.CreateInfo.password == '' || this.CreateInfo.pwdcomfirm == '' || this.CreateInfo.tel == '' || this.CreateInfo.address == '' || this.CreateInfo.age == ''){
              alert("填项不能为空");
            }else {
              if (this.CreateInfo.password != this.CreateInfo.pwdcomfirm) {
                alert("两次密码不一致");
                this.CreateInfo.password = '';
                this.CreateInfo.pwdcomfirm = '';
              }else{
                var len;
                var _this = this
                this.$axios.get('/api/patient/patientnum').then(function (resp) {
                  len = resp.data;
                  console.log(resp)
                  if (len == undefined){
                    len = 0;
                  }
                  _this.patient.Pno = 1000000 + len + 1;
                  _this.patient.Pname = _this.CreateInfo.username;
                  _this.patient.Paddr = _this.CreateInfo.address;
                  _this.patient.Page = _this.CreateInfo.age;
                  _this.patient.Psex = _this.sex;
                  _this.patient.Ptel = _this.CreateInfo.tel;
                  encodeURIComponent(_this.patient)
                  let params1 = _this.patient
                  let success1 = 0;
                  let success2 = 0;
                  _this.$axios.post('/api/patient/save', qs.stringify(params1)
                  ).then(function (response1) {
                    if (response1.status == 200) {
                      success1 == 1;
                    }
                  }).catch(function (res1) {
                    console.log(error);
                  })

                  _this.worker.Uno = _this.patient.Pno,
                    _this.worker.Uname = _this.CreateInfo.username,
                    _this.worker.Upwd = md5(_this.CreateInfo.password),
                    _this.worker.Uide = _this.statue
                  encodeURIComponent(_this.worker)
                  let params2 = _this.worker
                  _this.$axios.post('/api/user/save', qs.stringify(params2)
                  ).then(function (response2) {
                    if (response2 == 200){
                      success2 = 1;
                    }
                  }).catch(function (res2) {
                    console.log(error);
                  })
                  alert("注册成功！账号为：" + _this.worker.Uno );
                  window.location.href = '/';
                })

              }
            }
          }
        }
      }
    }
</script>

<style lang="stylus" scoped>
  #create_body
    z-index 100px
    position absolute
    background white
    opacity 0.70
    top 100px
    left 500px
    height 630px
    width 500px
    border-radius 50px
    text-align center
    font-size 20px
    input
      height 25px
      position relative
      margin-top 20px
      padding 5px
      border-radius 5px
      font-size 18px
    select
      height 28px
      position relative
      margin-top 20px
      padding 5px
      border-radius 5px
    #create_submit
      height 40px
      width 100px
      border-radius 10px

</style>
