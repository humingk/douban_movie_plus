<template>
  <div id="top">
    <div id="db-nav-movie" class="nav">
      <div class="nav-wrap">
        <div class="nav-primary">
          <div class="nav-logo">
            <a href="/">豆瓣电影Plus</a>
          </div>
          <div class="nav-search">
            <div class="inp">
              <!--keyup事件           即时搜索-->
              <!--keydown.enter时间   进入搜索内容-->
              <!--focus 获得焦点-->
              <!--blur 失去焦点-->
              <!--使用blur自动关闭搜索提示框-->
              <!--使用focus自动打开搜索提示框-->
              <input id="inp-query" ref="searchInput" size="22" maxlength="60" placeholder="搜索电影、影人" autocomplete="off"
                     type="text" v-model="keyword"
                     @click="resetNow()"
                     @blur="clearInput()"
                     @focus="get($event,'yes')"
                     @keyup.esc="clearInput()"
                     @keyup="get($event,'no')"
                     @keydown.enter="search()"
                     @keydown.down="selectDown()"
                     @keydown.up.prevent="selectUp()">
              <!--消除按钮-->
              <!--<span class="search-reset" @click="clearInput()">&times;</span>-->
              <span></span>
            </div>
            <div class="inp-btn">
              <input @click="search()">
            </div>
            <div @keyup.esc="clearInput"></div>
            <div id="search_suggest" class="search-select"
                 style="position:fixed;top: 65px;left: 275px;width: 465px;">
              <transition-group name="itemfade" tag="ul" mode="out-in"
                                v-cloak :modal-append-to-body="false">
                <!--style="background-color: #d7fbe3;"-->
                <li v-for="(item,index) in searchResult"
                    v-if="item.name!=''"
                    style="background-color: #b0eae7;border-top: 1px solid;border-color: #c7cbff;height: auto;"
                    :class="{selectback:index==now}"
                    class="search-select-option search-select-list"
                    @mouseover="selectHover(index)"
                    @click="selectClick(index)"
                    :key="item.movieId">
                  <span><strong>{{item.name}}</strong></span>
                  <span style="color: #f7097a;"><i>&nbsp;&nbsp;&nbsp;{{item.rate=='11'?'-->':item.rate}}</i></span><br>
                  <span style="font-size: 11px;color:#787878">
                    {{item.alias}}
                  </span>
                </li>
              </transition-group>
            </div>
          </div>
        </div>
      </div>
      <div class="nav-secondary">
        <div class="nav-items">
          <ul>
            <li>
              <a href="/mine" target="_blank">个人中心</a>
            </li>
            <li>
              <a href="/chart" target="_blank">排行榜</a>
            </li>
            <li>
              <a href="/explore" target="_blank">选电影</a>
            </li>
            <li>
              <a href="/subject/1292720" target="_blank">阿甘正传</a>
            </li>
            <li>
              <a href="/subject/1889243" target="_blank">星际穿越</a>
            </li>
            <li>
              <a href="/subject_search?search_text=星球大战" target="_blank">搜索页面</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  import {
    url_ssm_base, url_douban
  } from '../config';

  export default {
    name: "top",
    data() {
      return {
        url_douban: url_douban,
        // 绑定search输入框的关键字
        keyword: "",
        // 当前选中电影
        now: -1,
        // 实时获取的搜索提示
        searchResult: [
          {
            movieId: "",
            name: "",
            alias: "",
            imdbId: "",
            rate: ""
          }
        ],
      }
    },

    // 向父组件传值
    props: {},

    created:function(){

      // 跳转到搜索页面,保留关键字
      if(this.$route.path=="/subject_search"){
        this.keyword=this.$route.query.search_text;
      }
    },
    methods: {

      // 实时获取搜索提示内容
      get: function (ev, isFocus) {
        // 按键是上或者下，不需要异步调取数据
        if (ev.keyCode == 38 || ev.keyCode == 40) {
          return;
        }
        if (this.keyword == '') {
          this.searchResult = null;
          return;
        } else {
          // 如果是focus，即输入框重新获得焦点，自动进行查询
          if (isFocus == "yes") {
            this.keyword = this.$refs.searchInput.value;
          }
          axios.get(url_ssm_base + "/searchTips",{
            params:{
              keyword:this.keyword
            }
          }).then(response => {
            if (response.data.code == 200) {
              if (response.data.message == "success") {
                this.searchResult = response.data.data;
              } else if (response.data.message == "fail") {
                // 初始化
                // this.searchResult=null;
                this.searchResult = [
                  {
                    movieId: "",
                    name: "",
                    alias: "",
                    imdbId: "",
                    rate: ""
                  }
                ];
                this.searchResult.push({
                  movieId: "404",
                  rate: "11",
                  name: "请点击此处跳转到 < 豆瓣电影 > 搜索页面",
                  alias: "PS 在豆瓣找到你心仪的电影后，在域名'douban'后面加'1s'即可跳转到本站 ~ ~ ~"
                });
              }
            } else {
              // 初始化
              this.searchResult = [
                {
                  movieId: "404",
                  name: "",
                  alias: "",
                  imdbId: "",
                  rate: ""
                }
              ];
              this.searchResult.push({
                movieId: "403",
                name: '连接服务器失败...请与管理员联系...'
              });
            }
          }).catch(error => {
            console.log("search tips fail...");
            console.log(error);
          });
        }
      },

      // 重置 now
      resetNow: function () {
        this.now = -1;
      },

      // down 搜索提示框
      selectDown: function () {
        this.now++;
        // 底部最后一个跳转第一个
        if (this.now == this.searchResult.length) {
          this.now = 0;
        }
        if (this.searchResult) {
          // 服务器找不到此电影的情况
          if (this.searchResult.length == 2 && (this.searchResult[0].rate == "11" || this.searchResult[1].rate == "11")) {
            this.now = 1;
          } else {
            this.keyword = this.searchResult[this.now].name;
          }
        }
      },

      // up 搜索提示框按键
      selectUp: function () {
        if (this.now == -1) {
          return;
        }
        // 从第一个向上到输入框，清空输入框
        else if (this.now == 0) {
          this.keyword = "";
        } else if (this.searchResult) {
          this.now--;
          this.keyword = this.searchResult[this.now].name;
        }
      },

      // 搜索页面跳转 回车 点击
      search: function () {
        if (this.keyword == '') {
          return;
        }
        // keyword 不为空
        // 直接搜索页跳转
        else if (this.now == -1) {
          // 是否在搜索页面搜索
          if(this.$route.path=="/subject_search"){
            // 本页面跳转
            window.location.href="/subject_search?search_text=" + this.keyword;
          }else {
            // 新页面跳转
            window.open("/subject_search?search_text=" + this.keyword);
          }
        }
        // 选中电影跳转
        else {
          if (this.searchResult) {
            // 服务器没有此电影，跳转豆瓣电影官网搜索
            if (this.searchResult[this.now].movieId == '404') {
              // 是否在搜索页面搜索
              if(this.$route.path=="/subject_search"){
                // 本页面跳转
                window.location.href=this.url_douban + "/subject_search?search_text=" + this.keyword;
              }else {
                // 新页面跳转
                window.open(this.url_douban + "/subject_search?search_text=" + this.keyword);
              }
            } else {
              window.open("/subject/" + this.searchResult[this.now].movieId);
            }
          }
        }
      },

      // 鼠标悬在对应条目 实时改变now
      selectHover: function (index) {
        this.now = index;
        if (this.searchResult && !(this.searchResult[this.now].movieId == '404')) {
          this.keyword = this.searchResult[this.now].name;
        }
      },

      // 点击搜索提示框 对应电影条目
      selectClick: function (index) {
        // 404 情况
        if ( (this.searchResult[this.now] && this.searchResult[this.now].movieId == '404') ||
          (this.searchResult.length == 2 &&
            (this.searchResult[0].rate == "11" || this.searchResult[1].rate == "11"))) {
          // 是否在搜索页面搜索
          if(this.$route.path=="/subject_search"){
            // 本页面跳转
            window.location.href=this.url_douban + "/subject_search?search_text=" + this.keyword;
          }else {
            // 新页面跳转
            window.open(this.url_douban + "/subject_search?search_text=" + this.keyword);
          }
        } else {
          window.open("/subject/" + this.searchResult[index].movieId);
        }
      },

      // 清理搜索提示框
      clearInput: function () {
        // 设置定时器，为了避免在点击提示框对应电影的时候被清理
        setTimeout(clear => {
          this.keyword = "";
          this.searchResult = null;
        }, 180);
      }
    },

    // 页面渲染完成后...
    mounted() {

    },

    // 过滤器
    filters: {}
  }
</script>
<style>
  @import "../../static/douban/css/top.css";
</style>
