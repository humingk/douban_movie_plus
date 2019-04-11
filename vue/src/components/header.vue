<template>
  <div id="header">
    <div id="db-nav-movie" class="nav">
      <div id="nav-wrap">
        <div class="nav-primary">
          <div class="nav-logo">
            <a href="/">豆瓣电影Plus</a>
          </div>
          <div class="nav-search">
            <form action="/search" method="get">
              <fieldset>
                <legend>搜索</legend>
                <label for="inp-query"></label>
                <div id="inp">
                  <input id="inp-query" name="search_text" size="22"
                         maxlength="60" placeholder="搜索电影" autocomplete="off">
                </div>
                <div class="inp-btn">
                  <input type="submit" value="搜索">
                </div>
                <input type="hidden" name="cat" value="1002">
              </fieldset>
            </form>
          </div>
        </div>
      </div>
      <div id="nav-secondary">
        <div class="nav-items">
          <ul>
            <li>
              <a href="/mine">我的电影</a>
            </li>
            <li>
              <a href="/chart">排行榜</a>
            </li>
            <li>
              <a href="/expore">选电影</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>
<style>
  @import "../../static/douban/css/header.css";
</style>
<script>
  export default {
    name: "header",
    data() {
      return {}
    }
  }
</script>
