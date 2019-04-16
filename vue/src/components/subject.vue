<template>
  <div id="subject" v-if="movieBase.movieId">
    <div id="wrapper">
      <div id="content">
        <h1>
          <span>{{movieBase.name}}</span>
          <span v-if="movieApi.original_title"> {{movieApi.original_title|isEnglish()}}</span>
          <span class="year" v-if="movieApi.year">({{movieApi.year}})</span>
          <span v-if="!movieApi.id" style="font-size: 16px">(资料不全,查看更多请<a
            :href="url_douban+'/subject/'+movieBase.movieId" target="_blank">点击此处</a>去豆瓣电影)</span>
        </h1>
        <div class="grid-16-8 clearfix">
          <div class="article">
            <div class="indent clearfix">
              <div class="subjectwrap clearfix">
                <div class="subject clearfix">
                  <div id="mainpic" class="" v-if="movieApi.images">
                    <a class="nbgnbg" v-if="movieApi.images" :href="movieApi.images.large"><img
                      :src="movieApi.images.large" rel="noreferrer"></a>
                    <p class="gact"></p>
                  </div>
                  <div style="line-height: 16px;" class="info">
                    <span class="pl" v-if="movieBase.directors.length">导演: </span>
                    <span class="attrs" v-for="(item,index) in movieBase.directors"><a
                      target="_blank" :href="'/celebrity/'+item.actorId">{{item.name}}</a>{{ index === movieBase.directors.length-1 ? "" : " / " }}</span><br>
                    <span class="pl" v-if="movieBase.writers.length">编剧: </span>
                    <span class="attrs" v-for="(item,index) in movieBase.writers"><a target="_blank"
                                                                                     :href="'/celebrity/'+item.actorId">{{item.name}}</a>{{ index === movieBase.writers.length-1 ? "" : " / " }}</span><br>
                    <span class="actor">
                      <div style="width: 34px;float: left;line-height:16px;">
                    <span class="pl" v-if="movieBase.leadingactors.length">演员: </span>
                      </div>
                      <div style="overflow:hidden">
                    <span class="attrs" v-for="(item,index) in movieBase.leadingactors" v-if="index < 10">
                      <a target="_blank" :href="'/celebrity/'+item.actorId">{{item.name}}</a>
                      {{ index === movieBase.leadingactors.length-1 ? "" : " / " }}
                    </span>

                      <span class="attrs" v-for="(item,index) in movieBase.leadingactors"
                            v-if="index >= 10 && !brandOrFold">
                      <a target="_blank" :href="'/celebrity/'+item.actorId">{{item.name}}</a>
                      {{ index === movieBase.leadingactors.length-1 ? "" : " / " }}
                    </span>

                      <span @click="moreActor()" v-if="movieBase.leadingactors.length>10"
                            style="color: #8c169b;font-size: 11px">
                       <i style="font-size: 13px">{{brandOrFold?'...(展开)':'(收起)'}}</i>
                      </span>
                      <br>
                      </div>
                    </span>
                    <span class="pl" v-if="movieBase.types.length">类型: </span>
                    <span class="attrs" v-for="(item,index) in movieBase.types"><a target="_blank"
                                                                                   :href="'/type/'+item.typeName">{{item.typeName}}</a>{{ index === movieBase.types.length-1 ? "" : " / " }}</span><br>
                    <span class="pl" v-if="movieBase.tags.length">标签: </span>
                    <span class="attrs" v-for="(item,index) in movieBase.tags"><a target="_blank"
                                                                                  :href="'/tag/'+item.tagName">{{item.tagName}}</a>{{ index === movieBase.tags.length-1 ? "" : " / " }}</span><br>
                    <span class="pl" v-if="movieBase.types.length">上映时间: </span>
                    <span class="attrs" v-for="(item,index) in movieBase.releasetimes">{{item.timeArea}}{{ index === movieBase.releasetimes.length-1 ? "" : " / " }}</span><br>
                    <span class="pl" v-if="movieBase.movieId">豆瓣电影: </span>
                    <span class="attrs"><a target="_blank"
                                           :href="url_douban+'/subject/'+movieBase.movieId">{{movieBase.movieId}}</a></span><br>
                    <span class="pl" v-if="movieBase.imdbId">IMDB: </span>
                    <span class="attrs"><a target="_blank"
                                           :href="url_imdb+'/title/'+movieBase.imdbId">{{movieBase.imdbId}}</a></span>
                  </div>
                </div>
                <div id="interest_sectl">
                  <!--豆瓣评分-->
                  <div class="rating_wrap clearbox">
                    <div class="clearfix">
                      <div class="rating_logo ll">
                        <a :href="url_douban" target="_blank">
                          豆瓣电影
                        </a>
                      </div>
                      <div class="output-btn-wrap rr" style="">
                      </div>
                    </div>
                    <div class="rating_self clearfix">
                      <strong class="ll rating_num">{{movieBase.rate==0?'囧':movieBase.rate}}</strong>
                      <span content="10.0"></span>
                      <div class="rating_right ">
                        <div :class="'ll bigstar '+getBigRateType(movieBase.rate)"></div>
                        <div class="rating_sum">
                          <div class="rating_people"><span>
                            <a :href="url_douban+'/subject/'+movieBase.movieId+'/collections'" target="_blank"
                               v-if="movieApi.id">
                            {{movieApi.rating.average==0?'仅':''}}{{movieApi.ratings_count|thousands()}}人评价
                            </a>
                          </span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!--IMDB评分-->
                  <div v-if="imdbApi.imdbID" class="rating_wrap clearbox">
                    <div class="clearfix">
                      <div class="rating_logo ll">
                        <a :href="url_imdb" target="_blank">
                          IMDB
                        </a>
                      </div>
                      <div class="output-btn-wrap rr" style="">
                      </div>
                    </div>
                    <div class="rating_self clearfix">
                      <strong class="ll rating_num">{{imdbApi.imdbRating=='N/A'?'囧':imdbApi.imdbRating}}</strong>
                      <span content="10.0"></span>
                      <div class="rating_right ">
                        <div :class="'ll bigstar '+getBigRateTypeForImdb(imdbApi.imdbRating)"></div>
                        <div class="rating_sum">
                          <div class="rating_people">
                            <span>
                            <a target="_blank" :href="url_imdb+'/title/'+movieBase.imdbId">
                              {{imdbApi.imdbVotes=='N/A'?'暂时无':imdbApi.imdbVotes}}人评价
                            </a>
                            </span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div v-if="imdbApi.Ratings && imdbApi.Ratings.length>1">
                    <!--Metacritic-->
                    <div v-if="item.Source=='Rotten Tomatoes'" class="rating_wrap clearbox"
                         v-for="item in imdbApi.Ratings">
                      <div class="clearfix">
                        <div class="rating_logo ll">
                          <a :href="url_metacritic" target="_blank">
                            MTC
                          </a>
                        </div>
                        <div class="output-btn-wrap rr" style="">
                        </div>
                      </div>
                      <div class="rating_self clearfix">
                        <strong class="ll rating_num">{{item.Value|fixSlish()}}</strong>
                        <span content="10.0"></span>
                        <div class="rating_right ">
                          <div :class="'ll bigstar '+getBigRateTypeForMetacritic(item.Value)"></div>
                          <div class="rating_sum">
                            <div class="rating_people" v-if="movieApi.original_title">
                              <a target="_blank"
                                 :href="url_metacritic+'/movie/'+getMetacriticName(movieApi.original_title)">
                                Metacritic -->
                              </a>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!--烂番茄评分-->
                    <div v-if="item.Source=='Metacritic'" class="rating_wrap clearbox" v-for="item in imdbApi.Ratings">
                      <div class="clearfix">
                        <div class="rating_logo ll">
                          <a :href="url_tomato" target="_blank">
                            烂番茄
                          </a>
                        </div>
                        <div class="output-btn-wrap rr" style="">
                        </div>
                      </div>
                      <div class="rating_self clearfix">
                        <strong class="ll rating_num">{{item.Value|fixPercent()}}</strong>
                        <span content="10.0"></span>
                        <div class="rating_right ">
                          <div :class="'ll bigstar '+getBigRateTypeForTomatoes(item.Value)"></div>
                          <div class="rating_sum" v-if="movieApi.original_title">
                            <a target="_blank" :href="url_tomato+'/m/'+getTomatoName(movieApi.original_title)">
                              RTomatoes -->
                            </a>
                          </div>
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
                      <img :src="item.avatars.large" v-if="item.avatars" rel="noreferrer">
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
                      <img :src="item.avatars.large" v-if="item.avatars" rel="noreferrer">
                    </div>
                  </a>
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="info">
                      <span class="name">{{item.name}}</span>
                    </div>
                  </a>
                </li>
                <li class="celebrity" v-for="(item,index) in movieApi.casts" v-if="index < 3">
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="avatar">
                      <img :src="item.avatars.large" v-if="item.avatars" rel="noreferrer">
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
                                    target="_blank">(共计{{movieApi.photos_count?movieApi.photos_count:"..."}}张)</a></span>
              </h2>
              <ul class="related-pic-bd wide_videos">
                <li v-for="(item,index) in movieApi.photos">
                  <a :href="item.alt" target="_blank">
                    <img :src="item.image" alt="图片" rel="noreferrer" style="padding: 8px;box-sizing: border-box">
                  </a>
                </li>
              </ul>
            </div>
            <div id="comments-section">
              <div class="mod-hd">
                <h2>
                  <i class>热门短评......</i>
                  <span class="pl">
                  <a :href="url_douban+'/subject/'+movieBase.movieId+'/comments'"
                     target="_blank">(共计{{movieApi.comments_count?movieApi.comments_count:"..."}}条)</a>
                </span>
                </h2>
              </div>
              <div class="mod-bd">
                <div class="tab-bd">
                  <div id="hot-comments" class="tab">
                    <div class="comment-item" v-for=" (item,index) in movieApi.popular_comments" v-if="index < 5">
                      <div class="comment">
                        <h3>
                            <span class="comment-vote">
                              <span class="votes">{{item.useful_count}} 有用</span>
                            </span>
                          <span class="comment-info">
                            <a :href="url_douban+'/people/'+item.author.id" target="_blank" class="">{{item.author.name}}</a>
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
                  <i class>热门影评......</i>
                  <span class="pl">
                                    <a :href="url_douban+'/subject/'+movieBase.movieId+'/reviews'" target="_blank">
                    (共计{{movieApi.reviews_count?movieApi.reviews_count:"..."}}条)
                                    </a>
                  </span>
                </h2>
              </header>
              <div class="review-list">
                <div v-for="(item,index) in movieApi.popular_reviews" v-if="index < 5" class="main review-item">
                  <header class="main-hd">
                    <a :href="url_douban+'/people/'+item.author.id" class="avator">
                      <img width="24" height="24" :src="item.author.avatar">
                    </a>
                    <a :href="url_douban+'/people/'+item.author.id" class="name"
                       target="_blank">{{item.author.name}}</a>
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

            <!--网易云音乐-->
            <div id="all-songs" v-for="item in neteaseSongs" v-if="item.data.hotComments.length !== 0">
              <div id="songs-section">
                <div class="mod-hd">
                  <h2>
                    <i class>网易云音乐单曲 <span style="color:#79078f">< {{item.name}} ></span> 热门评论......<a
                      :href="url_netease+'/song?id='+item.id"
                      target="_blank"><i style="font-size:13px;">查看更多</i></a></i>
                    <span class="pl">
                </span>
                  </h2>
                </div>
                <div class="mod-bd">
                  <div class="tab-bd">
                    <div id="song-hot-comments" class="tab">
                      <div class="comment-item" v-for=" (itemOfSong,index) in item.data.hotComments" v-if="index < 5">
                        <div class="comment">
                          <h3>
                            <span class="comment-vote">
                              <span class="votes">{{itemOfSong.likedCount}} 喜欢</span>
                            </span>
                            <span class="comment-info">
                              <a :href="url_netease+'/user/home?id='+itemOfSong.user.userId" target="_blank" class=""> {{itemOfSong.user.nickname}} </a>
                            <span class="comment-time" style="font-size: 11px;"> &nbsp;&nbsp; 创建于 {{itemOfSong.time | formatDate()}}</span>
                          </span>
                          </h3>
                          <p class="">
                            <span class="short">{{itemOfSong.content}}</span>
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div id="all-albums" v-for="item in neteaseAlbums" v-if="item.data.hotComments.length !== 0">
              <div id="albums-section">
                <div class="mod-hd">
                  <h2>
                    <i class>网易云音乐专辑 <span style="color:#79078f">< {{item.name}} ></span> 热门评论......<a
                      :href="url_netease+'/album?id='+item.id"
                      target="_blank"><i style="font-size:13px;">查看更多</i></a>
                    </i>
                    <span class="pl">
                </span>
                  </h2>
                </div>
                <div class="mod-bd">
                  <div class="tab-bd">
                    <div id="album-hot-comments" class="tab">
                      <div class="comment-item" v-for=" (itemOfAlbum,index) in item.data.hotComments" v-if="index < 5">
                        <div class="comment">
                          <h3>
                            <span class="comment-vote">
                              <span class="votes">{{itemOfAlbum.likedCount}} 喜欢</span>
                            </span>
                            <span class="comment-info">
                              <a :href="url_netease+'/user/home?id='+itemOfAlbum.user.userId" target="_blank" class=""> {{itemOfAlbum.user.nickname}} </a>
                            <span class="comment-time" style="font-size: 11px;"> &nbsp;&nbsp; 创建于 {{itemOfAlbum.time | formatDate()}}</span>
                          </span>
                          </h3>
                          <p class="">
                            <span class="short">{{itemOfAlbum.content}}</span>
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div id="all-playlists" v-for="item in neteasePlaylists" v-if="item.data.hotComments.length !== 0">
              <div id="playlists-section">
                <div class="mod-hd">
                  <h2>
                    <i class>网易云音乐歌单 <span style="color:#79078f">< {{item.name}} ></span> 热门评论......<a
                      :href="url_netease+'/playlist?id='+item.id"
                      target="_blank"><i style="font-size:13px;">查看更多</i></a></i>
                    <span class="pl">
                </span>
                  </h2>
                </div>
                <div class="mod-bd">
                  <div class="tab-bd">
                    <div id="playlist-hot-comments" class="tab">
                      <div class="comment-item" v-for=" (itemOfPlaylist,index) in item.data.hotComments"
                           v-if="index < 5">
                        <div class="comment">
                          <h3>
                            <span class="comment-vote">
                              <span class="votes">{{itemOfPlaylist.likedCount}} 喜欢</span>
                            </span>
                            <span class="comment-info">
                              <a :href="url_netease+'/user/home?id='+itemOfPlaylist.user.userId" target="_blank"
                                 class=""> {{itemOfPlaylist.user.nickname}} </a>
                            <span class="comment-time" style="font-size: 11px;"> &nbsp;&nbsp; 创建于 {{itemOfPlaylist.time | formatDate()}}</span>
                          </span>
                          </h3>
                          <p class="">
                            <span class="short">{{itemOfPlaylist.content}}</span>
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <br>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  import {
    url_ssm_base, url_netease, url_imdb, url_douban, url_metacritic, url_tomato,
    url_api_netease, url_omdb, apikey_omdb, url_api_douban, apikey_api_douban,
  } from '../config';

  export default {
    name: 'subject',
    data: function () {
      return {
        url_imdb: url_imdb,
        url_douban: url_douban,
        url_netease: url_netease,
        url_metacritic: url_metacritic,
        url_tomato: url_tomato,
        // 网易云最大展示数
        numOfSongs: 2,
        numOfAlbums: 3,
        numOfPlaylists: 4,
        // 演员的展开与收起
        brandOrFold: true,
        subTitle: " (1s)",
        neteaseSearch: {},
        neteaseSongs: [],
        neteaseAlbums: [],
        neteasePlaylists: [],
        imdbApi: {
          imdbId: "",
          Ratings: []
        },
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
      this.getMovieApi(this.$route.params.movieId);

    },

    methods: {

      // axios 方法集合---------------------start

      // 从豆瓣电影API获取电影信息
      getMovieApi: function (movieId) {
        this.$jsonp(url_api_douban + "/v2/movie/subject/" + movieId,{
          params:{
            apikey:apikey_api_douban
          }
        }).then(responseApi => {
          if (responseApi.id) {
            console.log("movie douban API :");
            console.log(responseApi);
            this.movieApi = responseApi;
            /**
             * 获取 movie base
             * 获取 IMDB
             * 获取 netease songs albums playlists
             * 更新 rate
             * 更新 movie base
             *
             */
            // 第一级axios流程
            // param2==null ： 更新base
            this.getMovieBase(movieId, responseApi);
          }
          // 获取movie API 失败
          else {
            // 第二级axios流程
            // param2!=null ： 不更新base
            this.getMovieBase(movieId, null);
            console.log("get movie api fail....(server error)")
          }
        }).catch(error => {
          console.log("during get movie douban api fail...");
          console.log(error);
        });
      },

      // 从服务器获取电影基础信息
      getMovieBase: function (movieId, responseApi) {
        axios.get(url_ssm_base + "/subject/" + movieId).then(responseBase => {
          // 服务端有这部电影
          if (responseBase.data && responseBase.data.code && responseBase.data.message) {
            if (responseBase.data.code == 200 && responseBase.data.message == "success") {
              console.log("movie base :");
              console.log(responseBase);
              this.movieBase = responseBase.data.data;
              // 设置标题
              document.title = responseBase.data.data.name + this.subTitle;
              // 获取 imdb 相关
              // 豆瓣API没有imdbID...所以仅此情况可以获取
              if (this.movieBase.imdbId && this.movieBase.imdbId != '') {
                this.getImdb(this.movieBase.imdbId);
              } else {
                console.log("sorry there is no imdbID from base...");
              }
            }
            // 服务端没有这部电影
            else if (responseBase.data.message == "fail") {
              console.log("get moviebase failed...(server error)");
              // 需要更新base
              if (responseApi) {
                console.log("there is no movie base...");
                // 更新服务器 base
                this.updateMovieBase(responseApi);
                // 设置标题
                document.title = responseApi.title + this.subTitle;
              }
            }
          }else {
            console.log("get moviebase failed...(connect error)");
          }
          // 更新服务端 评分
          this.updateRate(responseApi.id, responseApi.rating.average);
          // 获取网易云音乐 通过 moviebase 电影搜索相关
          this.getNetease(this.movieBase.name);
        }).catch(error => {
          console.log("during get movie base failed...(client fail)");
          console.log(error);
        });
      },

      // movie base 上传到服务器
      updateMovieBase: function (responseApi) {
        // 先赋值base
        this.copyBase(responseApi);
        // 更新
        axios.post(url_ssm_base + "/subject/addMovieAll", this.movieBase).then(
          response => {
            if (response.data && response.data.code && response.data.message) {
              if (response.data.code == 200 && response.data.message == "success") {
                console.log("update movie base success...");
                console.log(this.movieBase);
              } else if (response.data.message == "fail") {
                console.log("update movie base fail...(server fail)");
              }
            } else {
              console.log("update movie base fail...(connect fail)");
            }
          }).catch(error => {
          console.log("update movie base fail...(client fail)");
          console.log(error);
        });
      },

      // api的值给base
      copyBase: function (responseApi) {
        this.movieBase.movieId = responseApi.id;
        this.movieBase.name = responseApi.title;
        if (responseApi.rating) {
          this.movieBase.rate = responseApi.rating.average;
        }
        if (responseApi.aka && responseApi.aka != '') {
          this.movieBase.alias = responseApi.aka.toString().replace(/,/g, "/");
        }
        if (responseApi.directors) {
          for (let i = 0; i < responseApi.directors.length; i++) {
            this.movieBase.directors.push({
              "actorId": responseApi.directors[i].id,
              "name": responseApi.directors[i].name
            });
          }
        }
        if (responseApi.writers) {
          for (let i = 0; i < responseApi.writers.length; i++) {
            this.movieBase.writers.push({
              "actorId": responseApi.writers[i].id,
              "name": responseApi.writers[i].name
            });
          }
        }
        if (responseApi.casts) {
          for (let i = 0; i < responseApi.casts.length; i++) {
            this.movieBase.leadingactors.push({
              "actorId": responseApi.casts[i].id,
              "name": responseApi.casts[i].name
            });
          }
        }
        if (responseApi.pubdates) {
          for (let i = 0; i < responseApi.pubdates.length; i++) {
            this.movieBase.releasetimes.push({timeArea: responseApi.pubdates[i]});
          }
        }
        if (responseApi.genres) {
          for (let i = 0; i < responseApi.genres.length; i++) {
            this.movieBase.types.push({typeName: responseApi.genres[i]});
          }
        }
        if (responseApi.tags) {
          for (let i = 0; i < responseApi.tags.length; i++) {
            this.movieBase.tags.push({"tagName": responseApi.tags[i]});
          }
        }
      },

      // rate 上传至服务器
      updateRate: function (movieId, rate) {
        axios.get(url_ssm_base + "/subject/updateRate", {
          params: {
            movieId: movieId,
            rate: rate
          }
        }).then(response => {
          if (response.data && response.data.code && response.data.message) {
            if (response.data.code == 200 && response.data.message == "success") {
              console.log("update movie rate success...");
            } else if (response.data.message == "fail") {
              console.log("update movie rate fail...(service error)");
            }
          } else {
            console.log("update movie rate fail...(connect error)");
          }
        }).catch(error => {
          console.log("update movie rate fail...");
          console.log(error);
        });
      },

      // 获取网易云音乐 电影搜索相关
      getNetease: function (movieName) {
        axios.get(url_api_netease + "/search/suggest?keywords=" + movieName).then(result => {
          if (result.data) {
            console.log("netease movie search:");
            console.log(result);
            this.neteaseSearch = result.data;
            if (result.data.result) {
              // 获取网易云音乐 歌曲评论
              if (result.data.result.songs) {
                let songs = result.data.result.songs;
                for (let i = 0; i < songs.length && i < this.numOfSongs; i++) {
                  this.getNeteaseSongs(songs[i].id, songs[i].name);
                }
                console.log("netease songs comments:");
                console.log(this.neteaseSongs);
              }
              // 获取网易云音乐 专辑评论
              if (result.data.result.albums) {
                let albums = result.data.result.albums;
                for (let i = 0; i < albums.length && i < this.numOfAlbums; i++) {
                  this.getNeteaseAlbums(albums[i].id, albums[i].name);
                }
                console.log("netease albums comments:");
                console.log(this.neteaseAlbums);
              }
              // 获取网易云音乐 歌单评论
              if (result.data.result.playlists) {
                let playlists = result.data.result.playlists;
                for (let i = 0; i < playlists.length && i < this.numOfPlaylists; i++) {
                  this.getNeteasePlaylists(playlists[i].id, playlists[i].name);
                }
                console.log("netease playlist comments:");
                console.log(this.neteasePlaylists);
              }
            }
          } else {
            console.log("during get netease serch failed...(server error)");
          }
        }).catch(error => {
          console.log("during get netease serch failed...");
          console.log(error);
        });
      },

      // 获取网易云音乐 歌曲评论
      getNeteaseSongs: function (song_id, name) {
        axios.get(url_api_netease + "/comment/music?id=" + song_id).then(resultSongs => {
          if (resultSongs.data) {
            this.neteaseSongs.push({
              id: song_id,
              name: name,
              data: resultSongs.data
            });
            // console success 在 netease search 方法
          } else {
            console.log("get netease song " + song_id + " failed...(server error)");
          }
        }).catch(error => {
          console.log("get netease song-" + song_id + " 's comments failed:");
          console.log(error);
        });
      },

      // 获取网易云音乐 专辑评论
      getNeteaseAlbums: function (album_id, name) {
        axios.get(url_api_netease + "/comment/album?id=" + album_id).then(resultAlbums => {
          if (resultAlbums.data) {
            this.neteaseAlbums.push({
              id: album_id,
              name: name,
              data: resultAlbums.data
            });
            // console success 在 netease search 方法
          } else {
            console.log("get netease album " + album_id + " failed...(server error)");
          }
        }).catch(error => {
          console.log("get netease album-" + album_id + " 's comments failed:");
          console.log(error);
        });
      },

      // 获取网易云音乐 歌单评论
      getNeteasePlaylists: function (playlist_id, name) {
        axios.get(url_api_netease + "/comment/playlist?id=" + playlist_id).then(resultPlaylists => {
          if (resultPlaylists.data) {
            this.neteasePlaylists.push({
              id: playlist_id,
              name: name,
              data: resultPlaylists.data
            });
            // console success 在 netease search 方法
          } else {
            console.log("get netease playlist " + playlist_id + " failed...(server error)");
          }
        }).catch(error => {
          console.log("get netease playlist-" + playlist_id + " 's comments failed:");
          console.log(error);
        });
      }
      ,

      // 获取IMDB信息
      getImdb: function (imdbId) {
        axios.get(url_omdb + "/",{
          params:{
            apikey:apikey_omdb,
            plot:'full',
            i:imdbId
          }
        }).then(response => {
          if (response.data && response.data.imdbID) {
            this.imdbApi = response.data;
            console.log("imdb Api :");
            console.log(response.data);
          } else {
            console.log("get imdb api fail...(server fail)");
          }
        }).catch(error => {
          console.log("get imdb api fail...");
          console.log(error);
        });
      }
      ,

      // axios 方法集合---------------------end

      // 判断是否展开更多actors
      moreActor: function () {
        if (this.brandOrFold) {
          this.brandOrFold = false;
        } else {
          this.brandOrFold = true;
        }
      }
      ,

      // 获取 metacritic 对应的电影名
      getMetacriticName(val) {
        return val.toString().replace(/ |: /g, '-').toLowerCase();
      }
      ,

      // 获取 rottentomato 对应的电影名
      getTomatoName(val) {
        return val.toString().replace(/ |: /g, '_').toLowerCase();
      }
      ,

      // 返回 豆瓣电影 小星星
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
      ,

      // 返回 豆瓣电影 大星星
      getBigRateType: function (rate) {
        if (rate <= 10 && rate > 9) {
          return 'bigstar45';
        } else if (rate <= 9 && rate > 8) {
          return 'bigstar40';
        } else if (rate <= 8 && rate > 7) {
          return 'bigstar35';
        } else if (rate <= 7 && rate > 6) {
          return 'bigstar30';
        } else if (rate <= 6 && rate > 5) {
          return 'bigstar25';
        } else if (rate <= 5 && rate > 4) {
          return 'bigstar20';
        } else if (rate <= 4 && rate > 3) {
          return 'bigstar15';
        } else if (rate <= 3 && rate > 2) {
          return 'bigstar10';
        } else {
          return 'bigstar5';
        }
      }
      ,

      // 返回 烂番茄 星星
      getBigRateTypeForTomatoes: function (rateT) {
        let rate = parseFloat(rateT.toString().replace(/%/g, '')) / 10;
        if (rate <= 10 && rate > 9) {
          return 'bigTomato45';
        } else if (rate <= 9 && rate > 8) {
          return 'bigTomato40';
        } else if (rate <= 8 && rate > 7) {
          return 'bigTomato35';
        } else if (rate <= 7 && rate > 6) {
          return 'bigTomato30';
        } else if (rate <= 6 && rate > 5) {
          return 'bigTomato25';
        } else if (rate <= 5 && rate > 4) {
          return 'bigTomato20';
        } else if (rate <= 4 && rate > 3) {
          return 'bigTomato15';
        } else if (rate <= 3 && rate > 2) {
          return 'bigTomato10';
        } else {
          return 'bigTomato5';
        }
      }
      ,

      // 返回 Imdb 星星
      getBigRateTypeForImdb: function (rate) {
        if (rate <= 10 && rate > 9) {
          return 'bigImdbStar45';
        } else if (rate <= 9 && rate > 8) {
          return 'bigImdbStar40';
        } else if (rate <= 8 && rate > 7) {
          return 'bigImdbStar35';
        } else if (rate <= 7 && rate > 6) {
          return 'bigImdbStar30';
        } else if (rate <= 6 && rate > 5) {
          return 'bigImdbStar25';
        } else if (rate <= 5 && rate > 4) {
          return 'bigImdbStar20';
        } else if (rate <= 4 && rate > 3) {
          return 'bigImdbStar15';
        } else if (rate <= 3 && rate > 2) {
          return 'bigImdbStar10';
        } else {
          return 'bigImdbStar5';
        }
      }
      ,

      // 返回 metacritic 星星
      getBigRateTypeForMetacritic: function (rateM) {
        let rate = parseFloat(rateM.toString().replace(/\/100/g, '')) / 10;
        if (rate <= 10 && rate > 9) {
          return 'bigMetacriticStar45';
        } else if (rate <= 9 && rate > 8) {
          return 'bigMetacriticStar40';
        } else if (rate <= 8 && rate > 7) {
          return 'bigMetacriticStar35';
        } else if (rate <= 7 && rate > 6) {
          return 'bigMetacriticStar30';
        } else if (rate <= 6 && rate > 5) {
          return 'bigMetacriticStar25';
        } else if (rate <= 5 && rate > 4) {
          return 'bigMetacriticStar20';
        } else if (rate <= 4 && rate > 3) {
          return 'bigMetacriticStar15';
        } else if (rate <= 3 && rate > 2) {
          return 'bigMetacriticStar10';
        } else {
          return 'bigMetacriticStar5';
        }
      }
    }
    ,

    filters: {

      // 判断 origin_name 是不是英文名，中文名就不要重复了
      isEnglish: function (val) {
        let first = val.toString().charAt(0);
        return ((first >= 'A' && first <= 'Z') || (first >= 'a' && first <= 'z')) ? val.toString() : '';
      }
      ,

      // 网易云音乐 Unix时间戳 转换
      formatDate: function (value) {
        if (!value) return '';
        let date = new Date(value);
        let year = date.getFullYear();
        let month = date.getMonth() + 1;
        let day = date.getDate();
        let hour = date.getHours();
        let minute = date.getMinutes();
        return year + '-' + month + '-' + day + ' ' + hour + ':' + minute;
      }
      ,

      // 豆瓣评价人数千分位转换
      thousands: function (val) {
        return val.toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,');
      }
      ,

      // 烂番茄去除百分号并且两个数之间加小数点
      fixPercent: function (val) {
        return parseFloat(val.toString().replace(/%/g, '')) / 10;
      }
      ,

      // Metacritic 去除斜杠
      fixSlish: function (val) {
        return parseFloat(val.toString().replace(/\/100/g, '')) / 10;
      }

    }
    ,

    // 渲染页面之后
    mounted: function () {

    }
    ,
  }
</script>
<style>
  @import "../../static/douban/css/subject.css";
</style>
