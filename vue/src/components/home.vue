<template>
  <div id="home" v-if="inTheaters.title!=''">
    <div id="wrapper">
      <div id="content">
        <div id="grid-16-8 clearfix">
          <div id="screening" class="s" data-dstat-areaid="70" data-dstat-mode="click,expose">
            <div class="screening-hd">
              <h2>正在热映
                <span><a :href="url_douban+'/cinema/nowplaying'">全部正在热映>></a></span>
                <span><a :href="url_douban+'/cinema/later'">即将上映>></a></span>
              </h2>
            </div>
            <div class="screening-bd" v-if="inTheaters.subjects">
              <div data-v-3e982be2="" class="list-wp">
                <a v-for="item in inTheaters.subjects"
                   data-v-2c455d87="" data-v-3e982be2="" target="_blank"
                   :href="'/subject/'+item.id"
                   class="item">
                  <div data-v-2c455d87="" data-id="26728669" class="cover-wp">
              <span data-v-2c455d87="" class="pic">
                <img data-v-2c455d87="" :src="item.images.large" rel="noreferrer"
                     :alt="item.title" x="movie:cover_x" y="1920">
              </span>
                  </div>
                  <p data-v-2c455d87="">
              <span data-v-2c455d87="">
                <strong>{{item.title}}</strong>
              </span>
                    <span data-v-2c455d87="" class="rate">{{item.rating.average}}</span>
                  </p>
                </a>
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
    url_api_douban, apikey_api_douban, url_douban
  } from '../config';

  export default {
    name: 'home',
    data: function () {
      return {
        url_douban: url_douban,
        top250: {},
        weekly: {},
        new: {},
        usBox: {},
        inTheaters: {
          count: "",
          start: "",
          subjects: [],
          title: "",
          total: ""
        }
      }
    },

    created: function () {
      // 获取豆瓣Api 最近上映 start count
      this.getInTheaters(0, 14);
      // Top250
      this.getTop250(0,14);
      // weekly
      this.getWeekly();
      // new
      this.getNew();
      // us box
      this.getUsBox();
    },

    methods: {
      // 获取豆瓣Api 最近上映
      getInTheaters: function (start, count) {
        // params集合会导致获取信息不全,采用url拼接
        this.$jsonp(url_api_douban + "/v2/movie/in_theaters?start=" + start + "&count=" + count + "&apikey=" + apikey_api_douban).then(response => {
          if (response.total && response.total != 0) {
            console.log("douban theaters: ");
            console.log(response);
            this.inTheaters = response;
          } else {
            console.log("get in theaters failed...count 0...(server error)");
          }
        }).catch(error => {
          console.log("get in theaters failed...");
          console.log(error);
        });
      },

      // api top250
      getTop250: function (start,count) {
        this.$jsonp(url_api_douban + "/v2/movie/top250?start="+start+"&count="+count).then(response => {
          if (response.count && response.count != 0) {
            console.log("douban top250: ");
            console.log(response);
            this.top250 = response;
          } else {
            console.log("get top250 failed...count 0...(server error)");
          }
        }).catch(error => {
          console.log("get top250 failed...");
          console.log(error);
        });
      },

      // 周热榜
      getWeekly: function () {
        this.$jsonp(url_api_douban + "/v2/movie/weekly?apikey=" + apikey_api_douban).then(response => {
          if (response.subjects && response.subjects.length != 0) {
            console.log("douban weekly: ");
            console.log(response);
            this.weekly = response;
          } else {
            console.log("get weekly failed...count 0...(server error)");
          }
        }).catch(error => {
          console.log("get weekly failed...");
          console.log(error);
        });
      },

      // 新片榜
      getNew: function () {
        this.$jsonp(url_api_douban + "/v2/movie/new_movies?apikey=" + apikey_api_douban).then(response => {
          if (response.subjects && response.subjects.length != 0) {
            console.log("douban new movies: ");
            console.log(response);
            this.new = response;
          } else {
            console.log("get new movies failed...count 0...(server error)");
          }
        }).catch(error => {
          console.log("get new movies failed...");
          console.log(error);
        });
      },

      // 北美票房榜
      getUsBox: function () {
        this.$jsonp(url_api_douban + "/v2/movie/us_box").then(response => {
          if (response.subjects && response.subjects.length != 0) {
            console.log("douban us box: ");
            console.log(response);
            this.usBox = response;
          } else {
            console.log("get us box failed...count 0...(server error)");
          }
        }).catch(error => {
          console.log("get us box failed...");
          console.log(error);
        });
      }
    }
  }
</script>
<style>
  @import "../../static/douban/css/home.css";
</style>
