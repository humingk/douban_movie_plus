<template>
  <div id="subject" v-if="movieBase.movieId">
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
                  <div class="rating_wrap clearbox">
                    <div class="clearfix">
                      <div class="rating_logo ll">豆瓣评分</div>
                      <div class="output-btn-wrap rr" style="">
                      </div>
                    </div>
                    <div class="rating_self clearfix">
                      <strong class="ll rating_num">{{movieApi.rating.average==0?'无':movieApi.rating.average}}</strong>
                      <span content="10.0"></span>
                      <div class="rating_right ">
                        <div :class="'ll bigstar '+getBigRateType(movieApi.rating.average)"></div>
                        <div class="rating_sum">
                          <div class="rating_people"><span>{{movieApi.ratings_count}}</span>人评价</div>
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
                  <a :href="'/subject/'+movieBase.movieId+'/comments'"
                     target="_blank">(共计{{movieApi.comments_count}}条)</a>
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
                  <i class>热门影评......</i>
                  <span class="pl">
                                    <a :href="'/subject/'+movieBase.movieId+'/reviews'" target="_blank">
                    (共计{{movieApi.reviews_count}}条)
                                    </a>
                  </span>
                </h2>
              </header>
              <div class="review-list">
                <div v-for="(item,index) in movieApi.popular_reviews" v-if="index < 5" class="main review-item">
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

            <!--网易云音乐-->
            <div id="all-songs" v-for="item in neteaseSongs" v-if="item.data.hotComments.length !== 0">
              <div id="songs-section">
                <div class="mod-hd">
                  <h2>
                    <i class>网易云音乐单曲 < {{item.name}} > 热门评论......<a :href="url_netease+'/song?id='+item.id"
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
                    <i class>网易云音乐专辑 < {{item.name}} > 热门评论......<a :href="url_netease+'/album?id='+item.id"
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
            <div id="all-playlists" v-for="item in neteaseAlbums" v-if="item.data.hotComments.length !== 0">
              <div id="playlists-section">
                <div class="mod-hd">
                  <h2>
                    <i class>网易云音乐歌单 < {{item.name}} > 热门评论......<a :href="url_netease+'/playlist?id='+item.id"
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
  // vue的url
  var url_vue_base = "http://localhost:8081";
  // ssm的url
  var url_ssm_base = "http://localhost:8080";
  // neteaseMusic base url
  var url_netease = "https://music.163.com";
  // neteaseMusic api url
  var url_api_netease = "http://localhost:3000";
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

  export default {
    name: 'subject',
    data: function () {
      return {
        // IMDB url
        url_imdb: "https://www.imdb.com",
        url_douban: "https://movie.douban.com",
        url_netease: "https://music.163.com",
        neteaseSearch: {},
        neteaseSongs: [],
        neteaseAlbums: [],
        neteasePlaylists: [],
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
      // 标记是否成功获得douban API数据
      let isDoubanApi = false;

      // axios主要执行流程------------------start
      // 获取 movie API
      this.$jsonp(url_api_douban + "/v2/movie/subject/" + this.$route.params.movieId + "?" + apikey_api_douban).then(responseApi => {
        console.log("movie douban API :");
        console.log(responseApi);
        this.movieApi = responseApi;
        // 获取电影基础资料
        getMovieBase(this.$route.params.movieId, this, responseApi);
        // 更新服务端 评分
        updateRate(responseApi.id, responseApi.rating.average);
        // 获取网易云音乐 电影搜索相关
        getNetease(responseApi.title, this);
        if (responseApi.id) {
          isDoubanApi = true;
        }
      }).catch(error => {
        console.log("during get movie douban api failed...");
        console.log(error);
        // 获取APi失败，再次获取 movie base
        if (!isDoubanApi) {
          getMovieBase(this.$route.params.movieId, null, null);
          console.log("get movieApi fail, get movie base again...");
        }
      });
      // axios主要执行流程------------------end

      // axios 方法集合---------------------start
      // 从服务器获取 movieBase
      function getMovieBase(movieId, _this, responseApi) {
        axios.get(url_ssm_base + "/subject/" + movieId).then(responseBase => {
          console.log("movie base :");
          console.log(responseBase);
          // 服务端有这部电影
          if (responseBase.data.code == 200 && responseBase.data.message == "OK") {
            _this.movieBase = responseBase.data.data;
          }
          // 服务端没有这部电影
          // base上传------------------start
          else if (responseBase.data.message == "NONE") {
            if (responseApi != null) {
              console.log("no movie base...");
              // API赋值base-----start
              _this.movieBase.movieId = responseApi.id;
              _this.movieBase.movieId = responseApi.id;
              _this.movieBase.name = responseApi.title;
              _this.movieBase.rate = responseApi.rating.average;
              _this.movieBase.alias = responseApi.aka.toString().replace(/,/g, "/");
              for (let i = 0; i < responseApi.directors.length; i++) {
                _this.movieBase.directors.push({
                  "actorId": responseApi.directors[i].id,
                  "name": responseApi.directors[i].name
                });
              }
              for (let i = 0; i < responseApi.writers.length; i++) {
                _this.movieBase.writers.push({
                  "actorId": responseApi.writers[i].id,
                  "name": responseApi.writers[i].name
                });
              }
              for (let i = 0; i < responseApi.casts.length; i++) {
                _this.movieBase.leadingactors.push({
                  "actorId": responseApi.casts[i].id,
                  "name": responseApi.casts[i].name
                });
              }
              for (let i = 0; i < responseApi.pubdates.length; i++) {
                _this.movieBase.releasetimes.push({timeArea: responseApi.pubdates[i]});
              }
              for (let i = 0; i < responseApi.genres.length; i++) {
                _this.movieBase.types.push({typeName: responseApi.genres[i]});
              }
              for (let i = 0; i < responseApi.tags.length; i++) {
                _this.movieBase.tags.push({"tagName": responseApi.tags[i]});
              }
              // API赋值base-----end
              axios.post(url_ssm_base + "/subject/addMovieAll", _this.movieBase).then(
                response => {
                  if (response.data.code == 200 && response.data.message == "success") {
                    console.log("update movie base success...");
                    console.log(_this.movieBase);
                  } else if (response.data.message == "fail") {
                    console.log("update movie base fail...(server fail)");
                  }
                }
              ).catch(error => {
                console.log("update movie base fail...(client fail)");
                console.log(error);
              });
            }
          }
          // base上传------------------end
        }).catch(error => {
          console.log("during get movie base failed...(client fail)");
          console.log(error);
        });
      }

      // rate 上传至服务器
      function updateRate(movieId, rate) {
        axios.get(url_ssm_base + "/subject/updateRate", {
          params: {
            movieId: movieId,
            rate: rate
          }
        }).then(response => {
          if (response.data.code == 200 && response.data.message == "success") {
            console.log("update movie rate success...");
          } else if (response.data.message == "fail") {
            console.log("update movie rate fail...(service error)");
          }
        }).catch(error => {
          console.log("update movie rate fail...");
          console.log(error);
        });
      }

      // 获取网易云音乐 电影搜索相关
      function getNetease(movieName, _this) {
        axios.get(url_api_netease + "/search/suggest?keywords=" + movieName).then(result => {
          console.log("netease movie search:");
          console.log(result);
          _this.neteaseSearch = result.data;
          if (result.data.result != null) {
            // 获取网易云音乐 歌曲评论
            if (result.data.result.songs != null) {
              let songs = result.data.result.songs;
              for (let i = 0; i < songs.length && i < 2; i++) {
                getNeteaseSongs(songs[i].id, _this, songs[i].name);
              }
              console.log("netease songs comments:");
              console.log(_this.neteaseSongs);
            }
            // 获取网易云音乐 专辑评论
            if (result.data.result.albums != null) {
              let albums = result.data.result.albums;
              for (let i = 0; i < albums.length && i < 2; i++) {
                getNeteaseAlbums(albums[i].id, _this, albums[i].name);
              }
              console.log("netease albums comments:");
              console.log(_this.neteaseAlbums);
            }
            // 获取网易云音乐 歌单评论
            if (result.data.result.playlists != null) {
              let playlists = result.data.result.playlists;
              for (let i = 0; i < playlists.length && i < 2; i++) {
                getNeteasePlaylists(playlists[i].id, _this, playlists[i].name);
              }
              console.log("netease playlist comments:");
              console.log(_this.neteasePlaylists);
            }
          }
        }).catch(error => {
          console.log("during get netease serch failed...");
          console.log(error);
        });
      }

      // 获取网易云音乐 歌曲评论
      function getNeteaseSongs(song_id, _this, name) {
        axios.get(url_api_netease + "/comment/music?id=" + song_id).then(resultSongs => {
          if (resultSongs.data != null) {
            _this.neteaseSongs.push({
              id: song_id,
              name: name,
              data: resultSongs.data
            });
          }
        }).catch(error => {
          console.log("get netease song-" + song_id + " 's comments failed:");
          console.log(error);
        });
      }

      // 获取网易云音乐 专辑评论
      function getNeteaseAlbums(album_id, _this, name) {
        axios.get(url_api_netease + "/comment/album?id=" + album_id).then(resultAlbums => {
          if (resultAlbums.data != null) {
            _this.neteaseAlbums.push({
              id: album_id,
              name: name,
              data: resultAlbums.data
            });
          }
        }).catch(error => {
          console.log("get netease album-" + album_id + " 's comments failed:");
          console.log(error);
        });
      }

      // 获取网易云音乐 歌单评论
      function getNeteasePlaylists(playlist_id, _this, name) {
        axios.get(url_api_netease + "/comment/playlist?id=" + playlist_id).then(resultPlaylists => {
          if (resultPlaylists.data != null) {
            _this.neteasePlaylists.push({
              id: playlist_id,
              name: name,
              data: resultPlaylists.data
            });
          }
        }).catch(error => {
          console.log("get netease playlist-" + playlist_id + " 's comments failed:");
          console.log(error);
        });
      }


      // axios 方法集合---------------------end

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
      },
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
        }else {
          return 'bigstar5';
        }
      }
    },
    filters: {
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

  .pl {
    color: #0aa236;
  }

  h1 {
    color: #f7097a;
  }

  #interest_sectl .rating_num {
    color: #f7097a;
  }
</style>
