<template>
    <el-form ref='LoginForm' :model='account' :rules='rules'
             label-position='left' label-width='0px'
             class='demo-ruleForm login-container'>
        <h1 class='title'>账号登录</h1>
        <el-form-item prop='useremail'>
            <el-input type='text' v-model='account.useremail' auto-complete='false' placeholder='请输入邮箱'></el-input>
        </el-form-item>
        <el-form-item prop='password'>
            <el-input type='password' v-model='account.password' auto-complete='false' placeholder='请输入密码'></el-input>
        </el-form-item>
        <el-checkbox v-model='checked' checked class='rememberMe'>记住我</el-checkbox>
        <el-form-item style='width: 100%;'>
            <el-button type='primary' style='width: 100%;'>登录</el-button>
        </el-form-item>
    </el-form>
</template>
<style>
    body {
        background-image: url('../assets/login_background.jpg');
    }

    .login-container {
        width: 350px;
        margin-left: 35%;
    }
</style>

<script>
    import {requestLogin} from "../api/api";

    export default {
        name: '登录',
        data () {
            return {
                logging: false,
                account: {
                    useremail: 'admin',
                    password: '123456'
                },
                rules: {
                    useremail: [
                        {
                            required: true,
                            message: '请输入邮箱',
                            trigger: 'blur'
                        }
                    ],
                    password: [
                        {
                            required: true,
                            message: '请输入密码',
                            trigger: 'blur'
                        }
                    ]
                },
                checked: true
            }
        },
        method:{
            handleLogin(){
                this.$refs.LoginForm.validate((valid)=>{
                    if(valid){
                        this.logging=true;
                        var loginParams={
                            useremail:this.account.useremail,
                            password:this,account.password
                        };
                        requestLogin(loginParams).then(data=>{
                            debugger;
                            this.logging=false;
                            let
                        })
                    }
                })
            }
        }
    }
</script>
