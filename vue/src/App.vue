<template>
  <div id="app">

    <!--导航栏-->
    <el-container>
      <el-header>
        <keep-alive>
          <headernav></headernav>
        </keep-alive>
      </el-header>
    </el-container>
    <router-view></router-view>
  </div>
</template>

<script>
  import header from "./components/header"

  export default {
    name: 'App',
    components: {
      headernav: header
    }
  }
</script>

<style>

</style>
