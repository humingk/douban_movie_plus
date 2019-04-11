<template>
  <h1>home</h1>

</template>
<script>

  var url_base = "http://localhost:8080";
  // 豆瓣V2 API url apiKey
  var url_douban = "https://api.douban.com";
  var apikey_douban = "apikey=0b2bdeda43b5688921839c8ecb20399b";
  export default {
    name: 'home',
    data: function () {
      return {

      }
    },
    created() {
      // this.$jsonp(url_douban +"/v2/movie/subject/" + movieId + "?" + apikey_douban)
      this.$jsonp(url_base + "/subject/1292720")
        .then(json => {
          console.log("movieAll API:");
          console.log(json);
        }).catch(error => {
        console.log("get mnovieAll api failed...");
      });
    }


    // methods:{
    //   getDoubanApiMovieAll(){
    //     this.$jsonp(url_douban +"/v2/movie/subject/" + movieId + "?" + apikey_douban)
    //       .then(json =>{
    //         console.log("movieAll API:");
    //         console.log(json);
    //       }).catch(error=>{
    //         console.log("get mnovieAll api failed...");
    //     });
    //   }
    // }


  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
