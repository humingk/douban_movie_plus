<template>
     
  <div> {{msg}}</div>
</template>
<style></style>
<script>

  import top from './top'

  export default {
    components: {
      'movie-top':top
    },
    data() {
      return {msg: 'vue模板页'}
    }
  }
</script>
