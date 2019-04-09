<template>
  <div class="hello">
    <span v-for="post in posts">{{post}}</span>
  </div>
</template>


<script>

  // 豆瓣V2 API url apiKey
  var url_douban = "https://api.douban.com";
  var apikey_douban = "apikey=0b2bdeda43b5688921839c8ecb20399b";
  var movieId=1292720;

export default {
  name: 'HelloWorld',
  data:{
    return:{
      movieAll:null
    }
  },
  created () {
    var vm = this;
    this.$jsonp(url_douban +"/v2/movie/subject/" + movieId + "?" + apikey_douban)
      .then(json =>{
        vm.d=json;
        console.log("movieAll API:");
        console.log(json);
      }).catch(error=>{
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
