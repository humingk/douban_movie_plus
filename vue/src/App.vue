<template>
  <div id="app">
    <headernav></headernav>
    <router-view></router-view>
  </div>
</template>

<script>
  import headernav from "./components/top"

  export default {
    name: 'App',
    components: {
      headernav: headernav
    }
  }
</script>

<style>
  .el-header, .el-footer {
    text-align: left;
  }
  .el-aside {
    text-align: left;
  }

  .el-main {
    overflow: hidden;
    text-align: left;
  }
</style>
