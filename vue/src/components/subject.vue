<template>
  <div id="subject">
    <div id="wrapper">
      <div id="content">
        <h1>
          <span>{{movieBase.name}}</span>
          <span class="year">({{movieApi.year}})</span>
        </h1>
        <div class="grid-16-8 clearfix">
          <div class="article">
            <div class="indent clearfix">
              <div class="subjectwrap clearfix">
                <div class="subject clearfix">
                  <div id="mainpic" class="">
                    <a class="nbgnbg" v-if="movieApi.images" :href="movieApi.images.large"><img
                      :src="movieApi.images.large" rel="noreferrer"></a>
                  </div>
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
                <!--豆瓣评分-->
                <div id="interest_sectl">
                  <div class="rating_wrap clearbox" rel="v:rating">
                    <div class="clearfix">
                      <div class="rating_logo ll">豆瓣评分</div>
                      <div class="output-btn-wrap rr" style="">
                      </div>
                    </div>
                    <div class="rating_self clearfix" typeof="v:Rating">
                      <strong class="ll rating_num" property="v:average">9.4</strong>
                      <span property="v:best" content="10.0"></span>
                      <div class="rating_right ">
                        <div class="ll bigstar bigstar45"></div>
                        <div class="rating_sum">
                          <a href="collections" class="rating_people"><span property="v:votes">1093575</span>人评价</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="related-info">
              <a name="intro"></a>
              <h2>
                <i class="">剧情简介......</i>
              </h2>
              <div class="indent" id="link-report">
                        <span class="summary" v-if="movieApi.summary">
                        {{movieApi.summary}}
                       </span>
              </div>
            </div>
            <div id="celebrities" class="celebrities related-celebrities">
              <h2>
                <i class>演职员列表......</i>
                <span class="pl"><a :href="'/subject/'+movieBase.movieId+'/celebrities'"
                                    target="_blank">
                  (共计{{movieBase.directors.length+movieBase.writers.length + movieBase.leadingactors.length}}人)</a></span>
              </h2>
              <ul class="celebrities-list from-subject __oneline">
                <li class="celebrity" v-for="item in movieApi.directors">
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="avatar">
                      <img :src="item.avatars.large" rel="noreferrer">
                    </div>
                  </a>
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="info">
                      <span class="name">{{item.name}}</span>
                    </div>
                  </a>
                </li>
                <li class="celebrity" v-for="item in movieApi.writers">
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="avatar">
                      <img :src="item.avatars.large" rel="noreferrer">
                    </div>
                  </a>
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="info">
                      <span class="name">{{item.name}}</span>
                    </div>
                  </a>
                </li>
                <li class="celebrity" v-for="(item,index) in movieApi.casts">
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="avatar">
                      <img :src="item.avatars.large" rel="noreferrer">
                    </div>
                  </a>
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="info">
                      <span class="name">{{item.name}}</span>
                    </div>
                  </a>
                </li>
              </ul>
            </div>
            <div id="related-pic" class="related-pic">
              <h2>
                <i class>图片列表......</i>
                <span class="pl"><a :href="'/subject/'+movieBase.movieId+'/all_photos'"
                                    target="_blank">(共计{{movieApi.photos_count}}张)</a></span>
              </h2>
              <ul class="related-pic-bd wide_videos">
                <li v-for="(item,index) in movieApi.photos">
                  <a :href="item.alt" target="_blank">
                    <img :src="item.image" alt="图片" rel="noreferrer" style="padding: 3px;box-sizing: border-box">
                  </a>
                </li>
              </ul>
            </div>
            <div id="comments-section">
              <div class="mod-hd">
                <h2>
                  <i class>所有短评......</i>
                  <span class="pl">
                  <a :href="'/subject/'+movieBase.movieId+'/comments'"
                     target="_blank">(共计{{movieApi.comments_count}}条)</a>
                </span>
                </h2>
              </div>
              <!--短评分类-->
              <div class="mod-bd">
                <div class="tab-bd">
                  <div id="hot-comments" class="tab">
                    <div class="comment-item" v-for=" item in movieApi.popular_comments">
                      <div class="comment">
                        <h3>
                            <span class="comment-vote">
                              <span class="votes">{{item.useful_count}} 有用</span>
                            </span>
                          <span class="comment-info">
                            <a :href="'/people/'+item.author.id" target="_blank" class="">{{item.author.name}}</a>
                            <span :class="getRateType(item.rating.value)+' rating'"></span>
                            <span class="comment-time">{{item.created_at}}</span>
                          </span>
                        </h3>
                        <p class="">
                          <span class="short">{{item.content}}</span>
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <section class="reviews mod movie-content">
              <header>
                <h2>
                  <i class>所有影评......</i>
                  <span class="pl">
                                    <a :href="'/subject/'+movieBase.movieId+'/reviews'" target="_blank">
                    (共计{{movieApi.reviews_count}}条)
                                    </a>
                  </span>
                </h2>
              </header>
              <div class="review-list">
                <div v-for="item in movieApi.popular_reviews" class="main review-item">
                  <header class="main-hd">
                    <a :href="'/people/'+item.author.id" class="avator">
                      <img width="24" height="24" :src="item.author.avatar">
                    </a>
                    <a :href="'/people/'+item.author.id" class="name" target="_blank">{{item.author.name}}</a>
                    <span :class="getRateType(item.rating.value)+' main-title-rating'"></span>
                    <!--影评时间-->
                    <span class="main-meta"></span>
                  </header>
                  <div class="main-bd">
                    <h2>
                      <a :href="item.alt" target="_blank">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{item.title}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </h2>
                    <div class="review-short">
                      {{item.summary}}
                    </div>
                  </div>
                </div>
              </div>
            </section>
            <br>
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
  import head from './top'

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
    beforeCreate: function () {


      // 获取 movie API
      // 标记是否成功获得douban API数据
      let isDoubanApi = false;
      this.$jsonp(url_api_douban + "/v2/movie/subject/" + this.$route.params.movieId + "?" + apikey_api_douban).then(responseApi => {
        console.log("movie douban API :");
        console.log(responseApi);
        this.movieApi = responseApi;
        if (responseApi.id) {
          isDoubanApi = true;
        }
        // 获取movie base
        axios.get(url_ssm_base + "/subject/" + this.$route.params.movieId).then(responseBase => {
          console.log("movie base :");
          console.log(responseBase);
          // 服务端有这部电影
          if (responseBase.data.code == 200 && responseBase.data.message == "OK") {
            this.movieBase = responseBase.data.data;
          }
          // 服务端没有这部电影
          // start------------上传
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
                  console.log(this.movieBase);
                } else if (response.data.message == "fail") {
                  console.log("update movie base fail...(server fail)");
                }
              }
            ).catch(error => {
              console.log("update movie base fail...(client fail)")
              console.log(error);
            });
          }
          // end ------------- 上传
        }).catch(error => {
          console.log("during get movie base failed...(client fail)");
          console.log(error);
        });
        // 更新服务端 评分
        axios.get(url_ssm_base + "/subject/updateRate", {
          params: {
            movieId: this.movieApi.id,
            rate: this.movieApi.rating.average
          }
        }).then(response => {
          if (response.data.code == 200 && response.data.message == "success") {
            console.log("update movie rate success...");
          } else if (response.data.message == "fail") {
            console.log("update movie rate fail...(service error)");
            console.log(error);
          }
        }).catch(error => {
          console.log("update movie rate fail...");
          console.log(error);
        });
      }).catch(error => {
        console.log("during get movie douban api failed...");
        console.log(error);
        // 获取APi失败，再次获取 movie base
        if (!isDoubanApi) {
          axios.get(url_ssm_base + "/subject/" + this.$route.params.movieId)
            .then(responseBase => {
              console.log("Api failed then movie base :");
              console.log(responseBase);
              if (responseBase.data.code == 200 && responseBase.data.message == "OK") {
                this.movieBase = responseBase.data.data;
              }
            });
        }
      });

    },
    created: function () {
      // 获取网易云音乐
    },
    methods: {
      // 评分图标
      getRateType: function (rate) {
        switch (rate) {
          case 1.0:
            return 'allstar10';
            break;
          case 2.0:
            return 'allstar20';
            break;
          case 3.0:
            return 'allstar30';
            break;
          case 4.0:
            return 'allstar40';
            break;
          case 5.0:
            return 'allstar50';
            break;
          default:
            return '';
        }
      }
    }
  }
</script>
<style>
  @import "../../static/douban/css/subject.css";
  /*字体*/
  .attrs {
    font-size: 13px;
  }

  .review-short {
    font-size: 13px;
    text-indent: 26px;
  }

  /*summary换行*/
  .summary {
    font-size: 13px;
    text-indent: 26px;
    white-space: pre-line;
  }

  .article .related-info h2, #celebrities h2, .related-pic h2, #recommendations h2 {
    margin-top: 0px;
    margin-bottom: 0px;
  }

  .subjectwrap {
    margin-bottom: 0px;
  }

  .indent {
    margin-bottom: 20px;
  }

  .related-pic {
    margin-top: 20px;
    margin-bottom: 20px;
  }

  #comments-section {
    margin-bottom: 20px;
  }

  .pl {
    color: #0aa236;
  }

  h1 {
    color: #f7097a;
  }

  h2 {
    color: #0aa236;
  }

  #interest_sectl .rating_num {
    color: #f7097a;
  }
</style>
