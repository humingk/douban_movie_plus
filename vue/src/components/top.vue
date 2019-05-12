<template>
  <div id="top">
    <div id="db-nav-movie" class="nav">
      <div class="nav-wrap">
        <div class="nav-primary">
          <a href="/" ><img class="nav-logo" src="../../static/images/logo.png"></a>
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
            <div id="search_suggest" style="position:fixed;margin:5px 300px 0 0;width: 465px;">
              <transition-group name="itemfade" tag="ul" mode="out-in"
                                v-cloak :modal-append-to-body="false">
                <li v-for="(item,index) in searchResult"
                    v-if="item.name!=''"
                    style="background-color: #b0eae7;border-top: 1px solid;border-color: #c7cbff;height: auto;"
                    :class="{selectback:index==now}"
                    class="search-select-option search-select-list"
                    @mouseover="selectHover(index)"
                    @mouseout="resetNow()"
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
              <a href="/people" target="_blank">个人中心</a>
            </li>
            <li>
              <a href="/chart" target="_blank">排行榜</a>
            </li>
            <li>
              <a href="/tag" target="_blank">分类</a>
            </li>
            <li>
              <a href="/subject/1889243" target="_blank">星际穿越</a>
            </li>
          </ul>
        </div>
      </div>
      <div id="github">
        <a title="访问Github仓库" href="https://github.com/humingk/douban_movie"
           target="_blank">
          <svg viewBox="0 0 250 250" style="position:absolute;top: 0;right: 0;"  width="111.53px" height="111.53px" aria-hidden="true">
            <path d="m0,-0.18282l115,115l27,27l108,108l0,-250c-83.33333,0 -166.66667,0 -250,0zm115,115c-0.1,0.1 3.7,1.5 4.8,0.4l6.95,-7.16316c-5.15026,-1.57317 -13.00742,-5.41018 -15.56632,-7.93246c-2.5589,-2.52229 -0.66473,-14.59258 -3.15524,-15.76615c-2.4905,-1.17356 -4.39185,-7.23412 -4.82385,-9.27639c-0.43201,-2.04227 5.44511,-0.88909 8.92823,1.48788c3.48312,2.37697 5.16772,16.80688 6.11034,18.64254c0.94263,1.83568 7.56678,9.79925 15.80772,6.0323c8.24094,-3.76695 5.84912,-3.02456 8.14912,-2.82456c-8.4,-10.6 -14.7,-24.2 1.6,-40.6c4.7,-4.6 10.2,-6.8 15.9,-7c0.6,-1.6 3.5,-7.4 11.7,-10.9c0,0 4.7,2.4 7.4,16.1c4.3,2.4 8.4,5.6 12.1,9.2c3.6,3.6 6.8,7.8 9.2,12.2c13.7,2.6 16.2,7.3 16.2,7.3c-3.6,8.2 -9.4,11.1 -10.9,11.7c-0.3,5.8 -2.4,11.2 -7.1,15.9c-16.4,16.4 -30,10 -40.6,1.6c0.2,2.8 -1,6.8 -5,10.8l-11.7,11.6c-1.2,1.2 0.6,5.4 0.8,5.3l-26.8,-26.8z"
                  stroke-width="1.5" fill="#409eff">
            </path>
          </svg>
        </a>
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
        searchResult: [],
        // 原始输入的关键字
        oldKeyword: ""
      }
    },

    // 向父组件传值
    props: {},

    created: function () {

      // 跳转到搜索页面,保留关键字
      if (this.$route.path == "/subject_search") {
        this.keyword = this.$route.query.search_text;
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
          axios.get(url_ssm_base + "/searchTips", {
            params: {
              keyword: this.keyword
            }
          }).then(response => {
            if (response.data.code == 200) {
              if (response.data.message == "success") {
                this.searchResult = response.data.data;
              } else if (response.data.message == "fail") {

                // 初始化
                this.searchResult = [];

                this.searchResult.push({
                  movieId: "404",
                  rate: "11",
                  name: "请回车进入搜索页面",
                  alias: "PS  智能提示采用本站数据,搜索结果采用豆瓣电影官网数据..."
                });

                // this.searchResult.push({
                //   movieId: "404",
                //   rate: "11",
                //   name: "请点击此处跳转到 < 豆瓣电影 > 搜索页面",
                //   alias: "PS 在豆瓣找到你心仪的电影后，在域名'douban'后面加'1s'即可跳转到本站 ~ ~ ~"
                // });

              }
            } else {
              // 初始化
              this.searchResult = [];
              this.searchResult.push({
                movieId: "403",
                name: '连接服务器失败...请与管理员联系...'
              });
            }
            // 上下选择期间保留原始输入关键字
            this.oldKeyword = this.keyword;
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
          if ((this.searchResult[this.now] && this.searchResult[this.now].movieId == '404') ||
            (this.searchResult.length == 1 && this.searchResult[0].rate == "11")) {
            this.now = 0;
          } else {
            // this.keyword = this.searchResult[this.now].name;
          }

        }
      },

      // up 搜索提示框按键
      selectUp: function () {
        if (this.now == -1) {
          return;
        }
        // 从第一个向上到输入框，输入框赋值原始关键字
        else if (this.now == 0) {
          this.now--;
          this.keyword = this.oldKeyword;
        } else if (this.searchResult) {
          this.now--;
          // this.keyword = this.searchResult[this.now].name;
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
          if (this.$route.path == "/subject_search") {
            // 本页面跳转
            window.location.href = "/subject_search?search_text=" + this.keyword;
          } else {
            // 新页面跳转
            window.open("/subject_search?search_text=" + this.keyword);
          }
        }
        // 选中电影跳转
        else {
          if (this.searchResult) {
            // 服务器没有此电影，跳转豆瓣电影官网搜索
            if ((this.searchResult[this.now] && this.searchResult[this.now].movieId == '404') ||
              (this.searchResult.length == 1 && this.searchResult[0].rate == "11")) {
              // 是否在搜索页面搜索

              // 无电影跳转
              if (this.$route.path == "/subject_search") {
                // 本页面跳转
                // window.location.href=this.url_douban + "/subject_search?search_text=" + this.keyword;
                window.location.href = "/subject_search?search_text=" + this.keyword;
              } else {
                // 新页面跳转
                // window.open(this.url_douban + "/subject_search?search_text=" + this.keyword);
                window.open("/subject_search?search_text=" + this.keyword);
              }

            } else {
              window.open("/subject/" + this.searchResult[this.now].movieId);
            }
          }
        }
      },

      // 鼠标悬在对应条目 实时改变now，但不改变输入框关键字
      selectHover: function (index) {
        this.now = index;
        // if (this.searchResult && !(this.searchResult[this.now].movieId == '404')) {
        // this.keyword = this.searchResult[this.now].name;
        // }
      },

      // 点击搜索提示框 对应电影条目
      selectClick: function (index) {
        // 404 情况
        if ((this.searchResult[this.now] && this.searchResult[this.now].movieId == '404') ||
          (this.searchResult.length == 1 && this.searchResult[0].rate == "11")) {
          // 是否在搜索页面搜索
          if (this.$route.path == "/subject_search") {
            // 本页面跳转
            // window.location.href=this.url_douban + "/subject_search?search_text=" + this.keyword;
            window.location.href = "/subject_search?search_text=" + this.keyword;
          } else {
            // 新页面跳转
            // window.open(this.url_douban + "/subject_search?search_text=" + this.keyword);
            window.open("/subject_search?search_text=" + this.keyword);
          }
        } else {
          window.open("/subject/" + this.searchResult[index].movieId);
        }
      },

      // 清理搜索提示框,赋值旧关键字
      clearInput: function () {
        // 设置定时器，为了避免在点击提示框对应电影的时候被清理
        setTimeout(clear => {
          this.keyword = this.oldKeyword;
          this.searchResult = null;
        }, 300);
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
