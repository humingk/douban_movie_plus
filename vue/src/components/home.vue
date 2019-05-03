<template>
  <div id="home">
    <div id="wrapper">
      <div id="content">
        <div id="grid-16-8 clearfix">
          <div class="homeTabList">
            <span :class="'homeTab '+isCurrent('inTheaters')" @click="changeCurrent('inTheaters')">正在热映</span>
            <span :class="'homeTab '+isCurrent('doubanNew')" @click="changeCurrent('doubanNew')">最新上映</span>
            <span :class="'homeTab '+isCurrent('weekly')" @click="changeCurrent('weekly')">本周口碑</span>
            <span :class="'homeTab '+isCurrent('usBox')" @click="changeCurrent('usBox')">北美票房</span>
            <span :class="'homeTab '+isCurrent('top250')" @click="changeCurrent('top250')">Top250</span>
          </div>
          <inTheaters :is="current" keep-alive></inTheaters>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import inTheaters from './homeDetail/inTheater';
  import doubanNew from './homeDetail/doubanNew';
  import usBox from './homeDetail/usBox';
  import weekly from './homeDetail/weekly';
  import top250 from './homeDetail/top250';

  export default {
    name: 'home',
    data: function () {
      return {
        current: "inTheaters"
      }
    },

    components: {
      inTheaters,
      doubanNew,
      usBox,
      weekly,
      top250
    },

    created: function () {

    },

    methods: {
      // 切换组件
      changeCurrent: function (current) {
        this.current = current;
      },
      // 当前选中栏
      isCurrent: function (current) {
        if (current == this.current) {
          return "tabBoder";
        }else {
          return "";
        }
      }
    }
  }
</script>
<style>
  @import "../../static/douban/css/home.css";
</style>
