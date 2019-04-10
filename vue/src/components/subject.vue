<template>
     
  <div class="content" v-if="movieAllBase.movieId">
    <h1>{{movieAllBase.name}}</h1>

    <div class="info">
      <span class="p1" v-if="movieAllBase.directors.length">导演: </span>
      <span v-for="(item,index) in movieAllBase.directors"><a class="attrs"
                                                      :href="'../celebrity/'+item.actorId">{{item.name}}</a>{{ index === movieAllBase.directors.length-1 ? "" : " / " }}</span><br>

      <span class="p1" v-if="movieAllBase.writers.length">编剧: </span>
      <span v-for="(item,index) in movieAllBase.writers"><a class="attrs"
                                                    :href="'../celebrity/'+item.actorId">{{item.name}}</a>{{ index === movieAllBase.writers.length-1 ? "" : " / " }}</span><br>

      <span class="p1" v-if="movieAllBase.leadingactors.length">演员: </span>
      <span v-for="(item,index) in movieAllBase.leadingactors"><a class="attrs"
                                                          :href="'../celebrity/'+item.actorId">{{item.name}}</a>{{ index === movieAllBase.leadingactors.length-1 ? "" : " / " }}</span><br>

      <span class="p1" v-if="movieAllBase.types.length">类型: </span>
      <span v-for="(item,index) in movieAllBase.types"><a class="attrs"
                                                  :href="'../tag/'+item.typeId">{{item.typeName}}</a>{{ index === movieAllBase.types.length-1 ? "" : " / " }}</span><br>
    </div>

  </div>
  </div>

</template>
<script>
  import axios from 'axios'

  var url_base = "http://localhost:8080";
  // 豆瓣V2 API url apiKey
  var url_douban = "https://api.douban.com";
  var apikey_douban = "apikey=0b2bdeda43b5688921839c8ecb20399b";
  export default {
    name: 'subject',
    data: function () {
      return {
        movieAllApi: null,
        movieAllBase: {
          name: String,
          directors: [
            {
              actorId: Number,
              name: String
            }
          ],
          leadingactors: [
            {
              actorId: Number,
              name: String
            }
          ]
        }
      }
    },
    created() {
      // 获取豆瓣API movie detail 数据
      this.$jsonp(url_douban + "/v2/movie/subject/" + this.$route.params.movieId + "?" + apikey_douban)
        .then(response => {
          console.log("movieAll douban API :");
          console.log(response);
          this.movieAllApi = response;
        }).catch(error => {
        console.log("get movieAll douban api failed...");
      });
      // 获取movie base 数据
      axios.get(url_base + "/subject/" + this.$route.params.movieId)
        .then(response => {
          console.log("movieAll base :");
          console.log(response);
          this.movieAllBase = response.data;
        }).catch(error => {
        console.log("get movieAll base failed...");
      });

    }
  }
</script>
<style rel="stylesheet/less" lang="less">
  @import "../assets/css/base.css";

  h1 {
    word-break: break-all;
    display: block;
    font-size: 25px;
    font-weight: bold;
    color: #494949;
    padding: 0 0 15px 0;
  }

  .content {
    min-height: 420px;
  }

  .info {
    float: left;
    max-width: 248px;
    word-wrap: break-word;
  }

  .p1 {
    line-height: 150%;
    color: #666666;
  }

  .attrs {
    color: #37a;
  }
</style>

