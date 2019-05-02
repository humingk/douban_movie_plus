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
    },
    data() {
      return {}
    },
  }
</script>

<style>

</style>
