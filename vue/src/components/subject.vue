<template>
  <div id="subject">
    <div class="wrapper" v-if="movieBase.movieId">
      <div class="content">
        <h1>{{movieBase.name}}</h1>
        <div class="grid-16-8 clearfix">
          <div class="article">
            <div class="indent clearfix">
              <div class="subjectwrap clearfix">
                <div id="mainpic" class>
                  <a class="nbgnbg" v-if="movieApi.images" :href="movieApi.images.large"><img
                    :src="movieApi.images.large" rel="noreferrer"></a>
                </div>
                <!--电影基础资料-->
                <div class="info">
                  <span class="pl" v-if="movieBase.directors.length">导演: </span>
                  <span class="attrs" v-for="(item,index) in movieBase.directors"><a
                    target="_blank" :href="'/celebrity/'+item.actorId">{{item.name}}</a>{{ index === movieBase.directors.length-1 ? "" : " / " }}</span><br>
                  <span class="pl" v-if="movieBase.writers.length">编剧: </span>
                  <span class="attrs" v-for="(item,index) in movieBase.writers"><a target="_blank"
                                                                                   :href="'/celebrity/'+item.actorId">{{item.name}}</a>{{ index === movieBase.writers.length-1 ? "" : " / " }}</span><br>
                  <span class="pl" v-if="movieBase.leadingactors.length">演员: </span>
                  <span class="attrs" v-for="(item,index) in movieBase.leadingactors"><a target="_blank"
                                                                                         :href="'/celebrity/'+item.actorId">{{item.name}}</a>{{ index === movieBase.leadingactors.length-1 ? "" : " / " }}</span><br>
                  <span class="pl" v-if="movieBase.types.length">类型: </span>
                  <span class="attrs" v-for="(item,index) in movieBase.types"><a target="_blank"
                                                                                 :href="'/type/'+item.typeName">{{item.typeName}}</a>{{ index === movieBase.types.length-1 ? "" : " / " }}</span><br>
                  <span class="pl" v-if="movieBase.tags.length">标签: </span>
                  <span class="attrs" v-for="(item,index) in movieBase.tags"><a target="_blank"
                                                                                :href="'/tag/'+item.tagName">{{item.tagName}}</a>{{ index === movieBase.tags.length-1 ? "" : " / " }}</span><br>
                  <span class="pl" v-if="movieBase.types.length">上映时间: </span>
                  <span class="attrs" v-for="(item,index) in movieBase.releasetimes">{{item.timeArea}}{{ index === movieBase.releasetimes.length-1 ? "" : " / " }}</span><br>
                  <span class="pl" v-if="movieBase.imdbId">IMDB: </span>
                  <span class="attrs"><a target="_blank"
                                         :href="url_imdb+'/title/'+movieBase.imdbId">{{movieBase.imdbId}}</a></span>
                </div>

              </div>
              <!--我的评分评论-->
              <div class="j a_stars"></div>
              <!--添加评分-->
              <div class="gtleft"></div>
            </div>
            <div class="related-info">
              <div class="indent">
                  <span v-if="movieApi.summary">
                    {{movieApi.summary}}
                  </span>
              </div>
            </div>
            <div id="celebrities" class="celebrities related-celebrities">
              <h2>
                <span class="pl"><a :href="'/subject/'+movieBase.movieId+'/celebrities'"
                                    target="_blank">演职员列表</a></span>
              </h2>
              <ul class="celebrities-list from-subject __oneline">
                <li class="celebrity" v-for="item in movieApi.directors">
                  <a :href="'/celebrity/'+item.id" target="_blank">
                    <img class="avatar" :src="item.avatars.large" rel="noreferrer">
                    <div class="info">
                      <span class="name">{{item.name}}</span>
                    </div>
                  </a>
                </li>
                <li class="celebrity" v-for="item in movieApi.casts">
                  <a :href="'/celebrity/'+item.id" target="_blank">
                    <img class="avatar" :src="item.avatars.large" rel="noreferrer">
                  </a>
                  <div class="info">
                    <span class="name">{{item.name}}</span>
                  </div>
                </li>
              </ul>
            </div>
            <div id="related-pic" class="related-pic">
              <h2>
                <span class="pl"><a :href="'/subject/'+movieBase.movieId+'/all_photos'"
                                    target="_blank">图片列表</a></span>
              </h2>
              <ul class="related-pic-bd  wide_videos">
                <li v-for="(item,index) in movieApi.photos.slice(0,5)">
                  <a :href="item.alt" target="_blank">
                    <img :src="item.image" rel="noreferrer">
                  </a>
                </li>
              </ul>
            </div>
            <div id="comments-section">
              <div class="mod-hd">
                <h2>
                <span class="pl">
                  <a :href="'/subject/'+movieBase.movieId+'/comments'">所有短评(共计 {{movieApi.comments_count}} 条)</a>
                </span>
                </h2>
                <div class="mod-hd">
                  <div class="tab-bd">
                    <div id="hot-comments" class="tab">
                      <div class="comment-item" v-for=" item in movieApi.popular_comments">
                        <div class="comment">
                          <h3>
                          <span class="comment-info">
                            <span>{{item.rating.value}}</span>
                          </span>
                          </h3>
                          <p class>
                            <span class="short">{{item.content}}</span>
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <section class="reviews mod movie-content">
              <header>
                <h2>

                  <span class="pl">
                                    <a :href="'/subject/'+movieBase.movieId+'/reviews'">
                    所有影评(共计 {{movieApi.reviews_count}} 条)
                                    </a>
                  </span>
                </h2>
              </header>
              <div class="review-list">
                <div v-for="item in movieApi.popular_reviews">
                  <div class="main review-item">
                    <header class="main-hd">
                      <span>{{item.rating.value}}</span>
                    </header>
                    <div class="main-bd">
                      <h2>
                        <a :href="item.alt">{{item.title}}</a>
                      </h2>
                      <div class="review-short">
                        <div class="short-content">
                          {{item.summary}}
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

  // vue的url
  var url_vue_base = "http://localhost:8081";

  // ssm的url
  var url_ssm_base = "http://localhost:8080";

  // neteaseMusic api url
  var url_netease = "http://localhost:3000";

  // IMDB OMDB api url
  var url_omdb = "http://www.omdbapi.com";
  var apikey_omdb = "apikey=e409ce71";


  // 豆瓣V2 API url apiKey
  var url_api_douban = "https://api.douban.com";
  var apikey_api_douban = "apikey=0b2bdeda43b5688921839c8ecb20399b";

  // 豆瓣V2 API url apikey 备用
  var url_api_douban_bak = "https://douban.uieee.com";
  var apikey_api_douban_bak = "apikey=0df993c66c0c636e29ecbb5344252a4a";

  // 吉卜力工作室 API
  var url_gbl = "https://ghibliapi.herokuapp.com";

  // 时光网 API url
  var url_time = "https://api-m.mtime.cn";

  import axios from 'axios'
  import head from './header'

  export default {
    name: 'subject',
    data: function () {
      return {
        // IMDB url
        url_imdb: "https://www.imdb.com",
        url_douban: "https://movie.douban.com",
        movieApi: {},
        movieBase: {
          movieId: "",
          name: "",
          rate: "",
          alias: "",
          imdbId: "",
          directors: [],
          writers: [],
          leadingactors: [],
          types: [],
          tags: [],
          releasetimes: []
        }
      }
    },
    created: function () {

      // 获取 movie API
      this.$jsonp(url_api_douban + "/v2/movie/subject/" + this.$route.params.movieId + "?" + apikey_api_douban)
        .then(responseApi => {
          console.log("movie douban API :");
          console.log(responseApi);
          this.movieApi = responseApi;

          // 获取movie base
          axios.get(url_ssm_base + "/subject/" + this.$route.params.movieId)
            .then(responseBase => {
              console.log("movie base :");
              console.log(responseBase);
              // 服务端有这部电影
              if (responseBase.data.code == 200 && responseBase.data.message == "OK") {
                this.movieBase = responseBase.data.data;
              }
              // 服务端没有这部电影
              else if (responseBase.data.message == "NONE") {
                console.log("no movie base...");
                // base 从API加载
                // -----start
                this.movieBase.movieId = responseApi.id;
                this.movieBase.movieId = responseApi.id;
                this.movieBase.name = responseApi.title;
                this.movieBase.rate = responseApi.rating.average;
                this.movieBase.alias = responseApi.aka.toString().replace(/,/g, "/");
                for (let i = 0; i < responseApi.directors.length; i++) {
                  this.movieBase.directors.push({
                    "actorId": responseApi.directors[i].id,
                    "name": responseApi.directors[i].name
                  });
                }
                for (let i = 0; i < responseApi.writers.length; i++) {
                  this.movieBase.writers.push({
                    "actorId": responseApi.writers[i].id,
                    "name": responseApi.writers[i].name
                  });
                }
                for (let i = 0; i < responseApi.casts.length; i++) {
                  this.movieBase.leadingactors.push({
                    "actorId": responseApi.casts[i].id,
                    "name": responseApi.casts[i].name
                  });
                }
                for (let i = 0; i < responseApi.pubdates.length; i++) {
                  this.movieBase.releasetimes.push({timeArea: responseApi.pubdates[i]});
                }
                for (let i = 0; i < responseApi.genres.length; i++) {
                  this.movieBase.types.push({typeName: responseApi.genres[i]});
                }
                for (let i = 0; i < responseApi.tags.length; i++) {
                  this.movieBase.tags.push({"tagName": responseApi.tags[i]});
                }
                // ------end
                // 上传至服务器
                axios.post(url_ssm_base + "/subject/addMovieAll", this.movieBase).then(
                  response => {
                    if (response.data.code == 200 && response.data.message == "success") {
                      console.log("update movie base success...");
                    } else if (response.data.message == "fail") {
                      console.log("update movie base fail...");
                    }
                  }
                )
              }
            }).catch(error => {
            console.log("get movie base failed...");
          });
        }).catch(error => {
        console.log("get movie douban api failed...");
      });
    }
  }
</script>
<style>
  @import "../../static/douban/css/subject.css";
</style>
