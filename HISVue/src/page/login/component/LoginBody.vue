<template>
  <div id="login_body">
    <h1>登陆用户</h1>
    <span>
          <label>用户账号：</label>
          <input v-model="LoginInfo.Uno" type="text"/><br/>
    </span>
    <span>
          <label>密码：</label>
          <input v-model="LoginInfo.Upwd" type="password"/><br/>
    </span>
    <span>
          <label>确认密码：</label>
          <input v-model="passwordconfirm" type="password"/><br/>
    </span>
    <span>
      <input @click="login()" id="login_submit" type="submit" value="登陆"/>
    </span>
  </div>
</template>

<script>
  import qs from 'qs'
  import md5 from 'js-md5';
    export default {
      name: "LoginBody",
      props:{
        statue:String
      },
      data(){
        return{
          LoginInfo: {
            Uno: '',
            Upwd: '',
            Uide: this.statue
          },
          tempInfo:{
            Uno: ''
          },
          passwordconfirm: ''
        }
      },
      methods:{
        login(){
          if (this.LoginInfo.Uno == '' || this.LoginInfo.Upwd == '' || this.passwordconfirm == ''){
            alert("填项不能为空");
          }else{
            if (this.passwordconfirm != this.LoginInfo.Upwd){
              alert("两次密码不一致");
              this.passwordconfirm = '';
              this.LoginInfo.Upwd = '';
            }else{
              let _this = this;
              this.tempInfo.Uno = this.LoginInfo.Uno
              encodeURIComponent(this.tempInfo)
              let params = this.tempInfo
              let pwd = md5(this.LoginInfo.Upwd);
              let sta = this.LoginInfo.Uide
              this.$axios.post('/api/user/singleuser',qs.stringify(params)
              ).then(function (response) {
                console.log(response)
                if (pwd != response.data.upwd) {
                  alert("密码错误");
                }else {
                  if (sta == "patient"){
                    _this.$router.push({
                      name : 'PatientHome' ,
                      params:{
                        loginuser: _this.LoginInfo
                      }
                    })
                  } else if (sta == "doctor"){
                    _this.$router.push({
                      name : 'DoctorHome',
                      params:{
                        loginuser: _this.LoginInfo
                      }
                    })
                  } else if (sta == "nurse"){
                    _this.$router.push({
                      name : 'NurseHome' ,
                      params:{
                        loginuser: _this.LoginInfo
                      }
                    })
                  }
                }
              })
            }
          }
        }
      }
    }
</script>

<style lang="stylus" scoped>
  #login_body
    z-index 100px
    position absolute
    background white
    opacity 0.40
    top 150px
    left 500px
    height 450px
    width 500px
    border-radius 50px
    text-align center
    font-size 20px
    input
      height 28px
      position relative
      margin-top 20px
      padding 5px
      border-radius 5px
    select
      height 28px
      position relative
      margin-top 20px
      padding 5px
      border-radius 5px
    #login_submit
      height 40px
      width 100px
      border-radius 10px
</style>
