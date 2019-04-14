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
              <input id="inp-query" size="22" maxlength="60" placeholder="搜索电影、影人" autocomplete="off"
                     type="text" v-model="keyword"
                     @blur="clearSearchTips()"
                     @keyup.esc="clearinput"
                     @keyup="get($event)"
                     @keydown.enter="search()"
                     @keydown.down="selectDown()"
                     @keydown.up.prevent="selectUp()">
              <span class="search-reset" @click="clearInput()">&times;</span>
              <span></span>
            </div>
            <div class="inp-btn">
              <input @click="search()">
            </div>
            <div @keyup.esc="clearInput"></div>

            <div id="search_suggest" class="search-select"
                 style="position:fixed;top: 65px;left: 255px;width: 470px;">
              <transition-group name="itemfade" tag="ul" mode="out-in"
                                v-cloak :modal-append-to-body="false">
                <li v-for="(item,index) in searchResult"
                    style="background-color: #d7fbe3;"
                    :class="{selectback:index==now}" class="search-select-option search-select-list"
                    @mouseover="selectHover(index)" @click="selectClick(index)" :key="item.movieId">
                  <span>{{item.name}}</span>
                  <span style="float: right;color: #f7097a;"><i>{{item.rate}}</i></span>
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
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  // ssm的url
  var url_ssm_base = "http://localhost:8080";
  import axios from 'axios';

  export default {
    name: "top",
    data() {
      return {
        // 绑定search输入框的数据
        keyword: "",
        // 接收服务器传来的数据
        searchResult: [],
        now: -1
      }
    },
    methods: {
      // 只清除 提示框
      clearSearchTips:function(){
        this.searchResult=null;
      },
      get: function (ev) {
        // 按键是上或者下，不需要异步调取数据
        if (ev.keyCode == 38 || ev.keyCode == 40) {
          return;
        }
        if (this.keyword == '') {
          this.searchResult = null;
          return;
        } else {
          axios.get(url_ssm_base + "/searchTips?keyword=" + this.keyword).then(response => {
            if (response.data.code == 200 && response.data.message == "success") {
              this.searchResult = response.data.data;
            }
          }).catch(error => {
            console.log("search tips fail...");
            console.log(error);
          });
        }
      },
      // down
      selectDown: function () {
        this.now++;
        // 底部最后一个跳转第一个
        if (this.now == this.searchResult.length) {
          this.now = 0;
        }
        if (this.searchResult) {
          this.keyword = this.searchResult[this.now].name;
        }
      },
      // up
      selectUp: function () {
        this.now--;
        if (this.now == -1) {
          this.now = this.searchResult.length - 1;
        }
        if (this.searchResult) {
          this.keyword = this.searchResult[this.now].name;
        }
      },
      // 搜索页面跳转
      search: function () {
        if (this.keyword == '') {
          return;
        } else if (this.now == -1) {
          window.open("/search?keyword=" + this.keyword);
        } else {
          if (this.searchResult) {
            window.open("/subject/" + this.searchResult[this.now].movieId);
          }
        }
      },
      selectHover: function (index) {
        // this.now = index;
      },
      selectClick: function (index) {
        window.open("/subject/" + this.searchResult[index].movieId);
      },
      clearInput: function () {
        this.keyword = "";
        this.searchResult = null;
      },
    },
    // 页面渲染完成后...
    mounted: function () {

    }
  }
</script>
<style>
  @import "../../static/douban/css/top.css";
  .search-reset {
    width: 21px;
    height: 21px;
    position: absolute;
    display: block;
    line-height: 21px;
    text-align: center;
    cursor: pointer;
    font-size: 20px;
    left: 450px;
    top: 13px
  }

  .selectback {
    background-color: #f56fbe !important;
    cursor: pointer
  }
</style>
