<template>
  <div id="wrapper">
    <div id="root" class="root">
      <div class="sc-gqjmRU hbWVez">
        <div class="_m86ylb9ba">
          <h1 class="_wqlzpvxb7">
            搜索 {{$route.query.search_text}}
          </h1>
          <h1 v-html="noMovie"></h1>
        </div>
        <div v-show="sResult && sResult.length!=0" class="_b6i42sib8"
             style="font: 12px Helvetica,Arial,sans-serif;line-height: 1.62;">
          <div class="_rvqzudtbb">
            <div v-for="result in sResult">
              <div class="sc-bZQynM jWOXeW sc-bxivhb hRIaFd" v-if="result.data && result.data.length!=0"
                   v-for="(item,index) in result.data">
                <div class="item-root">
                  <a :href="url_vue_base+'/subject/'+item.movieId" target="_blank" class="cover-link">
                    <!--<img :src="'../../static/images/m/m'+index%4+'.png'" :alt="item.name" class="cover">-->
                    <img v-if="item.image" :src="item.image" :alt="item.name" rel="noreferrer" class="cover">
                  </a>
                  <div class="detail">
                    <div class="title">
                      <a :href="url_vue_base+'/subject/'+item.movieId" target="_blank" class="title-text">
                        {{item.name}}<span style="color: #9b9b9b" v-if="item.year">({{item.year}})</span>
                      </a>
                    </div>
                    <div class="rating sc-bwzfXH hxNRHc">
                      <span :class="getRateType(item.rate)" class="rating-stars"></span>
                      <span class="rating_nums" style="color:#e018a4;">{{item.rate}}</span>
                    </div>
                    <div class="meta abstract">
                       <span v-if="item.types" v-for="itemType in item.types">
                         {{itemType.typeName+' / '}}
                       </span>
                      <span v-if="item.alias">
                        {{item.alias}}
                      </span>
                    </div>
                    <div class="meta abstract_2">
                       <span v-if="item.directors && item.directors.length!=0"
                             v-for="(itemDirector,indexDirector) in item.directors">
                         {{itemDirector.name}}{{indexDirector === itemDirector.length-1?"":" / "}}
                       </span>
                      <span v-if="item.writers" v-for="(itemWriter,indexWriter) in item.writers">
                         {{itemWriter.name}}{{indexWriter === itemWriter.length-1?"":" / "}}
                       </span>
                      <span v-if="item.leadingactors && item.leadingactors.length!=0"
                            v-for="(itemLeadingactor,indexLeadingactor) in item.leadingactors">
                        {{itemLeadingactor.name}}{{indexLeadingactor === item.leadingactors.length-1?"":" / "}}
                      </span>
                    </div>

                    <!--我是否看过这部电影-->
                    <!--<p class="_dpth8dwb5 sc-ifAKCX jVmQgr">-->
                    <!--<div class="status-text">我看过这部电影</div>-->
                    <!--</p>-->
                  </div>
                </div>
              </div>
            </div>
            <!--瀑布流加载-->
            <!--infinite-scroll-disabled -->
            <!--true : 禁止滚动-->
            <!--false：允许滚动-->
            <!--infinite-scroll-distance-->
            <!--距离底部开始加载的距离 单位 px-->
            <!--infinite-scroll-throttle-delay-->
            <!--两次检查的间隔 默认200-->
            <div v-infinite-scroll="loadMore"
                 infinite-scroll-disabled="busy"
                 infinite-scroll-distance="100"
                 infinite-scroll-throttle-delay="200">
              <div>
                {{isOver==false?'下拉加载更多 ~ ':'已经到底啦 ~ '}}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import axios from 'axios';
  import {
    url_ssm_base, url_vue_base, url_douban, url_api_douban, apikey_api_douban
  } from '../config';

  export default {
    name: "search",
    data() {
      return {
        url_douban: url_douban,
        url_vue_base: url_vue_base,
        busy: true,
        subTitle: " + 1s + 搜索",
        apiResult: {},
        sResult: [],
        // 目前已收到的电影条数
        start: 0,
        // 设置每次最多收到电影条数
        count: 10,
        // 是否加载到底了
        isOver: false,
        // 搜索不到电影提示
        noMovie: "",
        // 确定搜索失败提示时间
        noMovieTime: 2000,
        // 从base(true)加载数据还是从API(false)加载数据
        isBaseOrApi:true
      }
    },
    created: function () {
      // 设置标题
      document.title = this.$route.query.search_text + this.subTitle;
      // 第一次加载数据
      // this.getSearchResult(this.$route.query.search_text, this.start, this.count);
      // 定时器 是否搜到电影
      this.isMovieSearched(this.$route.query.search_text);
      // 从api加载数据
      this.getApiSearch(this.$route.query.search_text, this.start, this.count);
    },
    methods: {

      // 服务器获取搜索结果 start - end
      getSearchResult: function (keyword, start, count) {
        axios.get(url_ssm_base + "/subject_search", {
          params: {
            search_text: keyword,
            start: start,
            count: count
          }
        }).then(response => {
          // console.log("search result :");
          // console.log(response);
          if (response.data && response.data.code && response.data.message) {
            if (response.data.code == 200 && response.data.message == "success" && response.data.data) {
              this.sResult.push({
                start: this.start,
                data: response.data.data
              });
              //----------------懒加载start
              this.start = this.start + this.count;
              // 非第一次加载数据
              if (start != 0) {
                // 如果此次收到电影个数小于count,表示最后一次数据
                if (response.data.data.length < this.count) {
                  // 禁止滚动
                  this.busy = true;
                  // 加载到底
                  this.isOver = true;
                }
                //服务器还有数据
                else {
                  // 允许滚动
                  this.busy = false;
                }
              }
              // 第一次加载数据
              else {
                // 第一次加载后，允许滚动
                this.busy = false;
              }
              //----------------懒加载end
            } else {
              console.log("get search result fail...(server error)");
            }
          } else {
            console.log("get search result fail...(connect error)");
          }
        }).catch(error => {
          console.log("get search result fail...");
          console.log(error);
        });
      },

      // API 搜索结果 start count
      getApiSearch: function (keyword, start, count) {
        //  标记从API加载数据
        this.isBaseOrApi=false;
        this.$jsonp(url_api_douban + "/v2/movie/search?q=" + keyword + "&start=" + start + "&count=" + count+"&apikey="+apikey_api_douban).then(response => {
            if (response.subjects && response.subjects.length != 0) {
              let movies = response.subjects;
              // console.log("douban movie search:");
              // console.log(response);
              this.apiResult = response;

              let data = [];
              for (let i = 0; i < movies.length; i++) {
                let movie = movies[i];
                let directors = [];
                let leadingactors = [];
                let types = [];

                if (movie.directors && movie.directors.length != 0) {
                  for (let j = 0; j < movie.directors.length; j++) {
                    directors.push({
                      name: movie.directors[j].name
                    });
                  }
                }
                if (movie.casts && movie.casts.length != 0) {
                  for (let j = 0; j < movie.casts.length; j++) {
                    leadingactors.push({
                      name: movie.casts[j].name
                    });
                  }
                }
                if (movie.genres && movie.genres.length != 0) {
                  for (let j = 0; j < movie.genres.length; j++) {
                    types.push({
                      typeName: movie.genres[j]
                    });
                  }
                }

                data.push({
                  movieId: movie.id,
                  name: movie.title,
                  rate: movie.rating ? movie.rating.average : "",
                  year: movie.year ? movie.year : "",
                  alias: movie.original_title ? movie.original_title : "",
                  image: movie.images ? movie.images.large : "",
                  directors: directors,
                  leadingactors: leadingactors,
                  types: types
                });
              }
              this.sResult.push({
                start: this.start,
                data: data
              });
              //----------------懒加载start
              this.start = this.start + this.count;
              // 非第一次加载数据
              if (start != 0) {
                // 如果此次收到电影个数小于count,表示最后一次数据
                if (response.subjects && response.subjects.length < this.count) {
                  // 禁止滚动
                  this.busy = true;
                  // 加载到底
                  this.isOver = true;
                }
                //服务器还有数据
                else {
                  // 允许滚动
                  this.busy = false;
                }
              }
              // 第一次加载数据
              else {
                // 第一次加载后，允许滚动
                this.busy = false;
              }
              //----------------懒加载end
            } else {
              console.log("get douban movie search fail...(server error)");
            }
          }
        ).catch(error => {
          console.log("get douban movie search fail...");
          console.log(error);
        });
      },

      // 连续加载
      loadMore: function () {
        if (!this.isOver) {
          this.busy = true;
          // 延迟，以防止滚动条滚动的时候频繁地请求数据
          setTimeout(load => {
            this.isBaseOrApi?this.getSearchResult:this.getApiSearch(this.$route.query.search_text, this.start, this.count);
            this.busy = false;
          }, 500);
        }
      }
      ,

      // 搜索不到电影提示
      isMovieSearched: function (keyword) {
        setTimeout(no => {
          if (this.sResult.length == 0) {
            this.noMovie =
              `搜索不到你想找的电影<br>
                           请尝试其他关键字<br>
                         或
                         <a href="` + url_douban + `/subject_search?search_text=` + keyword + `">
                         点击此处
                         </a>
                         跳转到豆瓣电影搜索...`;
          }
        }, this.noMovieTime);
      }
      ,

      // 评分图标
      getRateType: function (rate) {
        if (rate <= 10 && rate > 8) {
          return 'allstar40';
        } else if (rate <= 8 && rate > 6) {
          return 'allstar30';
        } else if (rate <= 6 && rate > 4) {
          return 'allstar20';
        } else if (rate <= 4 && rate > 2) {
          return 'allstar10';
        }
      }
    },
  }
</script>
<style>
  @import "../../static/douban/css/search.css";
</style>
