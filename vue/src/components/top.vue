<template>
  <div id="top">
    <div id="db-nav-movie" class="nav">
      <div class="nav-wrap">
        <div class="nav-primary">
          <div class="nav-logo">
            <a href="/">豆瓣电影Plus</a>
          </div>
          <div class="nav-search">
            <form action="/search" method="get">
              <fieldset>
                <legend>搜索：</legend>
                <label for="inp-query">
                </label>
                <div class="inp"><input id="inp-query" name="search_text" size="22" maxlength="60" placeholder="搜索电影、影人" value="" autocomplete="off"></div>
                <div class="inp-btn"><input type="submit" value="搜索"></div>
                <input type="hidden" name="cat" value="1002">
              </fieldset>
            </form>
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
  export default {
    name: "top",
    data() {
      return {}
    }
  }
</script>
<style>
  @import "../../static/douban/css/top.css";

</style>
