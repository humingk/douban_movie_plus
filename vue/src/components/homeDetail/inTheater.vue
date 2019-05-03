<template>
  <!--正在上映-->
  <div id="screening" v-if="inTheaters.subjects && inTheaters.subjects.length!=0" class="s" data-dstat-areaid="70"
       data-dstat-mode="click,expose">
    <div class="screening-hd">
      <span><a :href="url_douban+'/cinema/nowplaying'">全部正在热映>></a></span>
      <span><a :href="url_douban+'/cinema/later'">即将上映>></a></span>
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
            <span data-v-2c455d87="" class="rate">{{item.rating.average=='0'?'':item.rating.average}}</span>
          </p>
        </a>
      </div>
    </div>
  </div>
</template>
<script>
  import {
    url_api_douban, apikey_api_douban, url_douban
  } from '../../config';

  export default {
    name: 'inTheater',
    data: function () {
      return {
        url_douban: url_douban,
        inTheaters: {}
      }
    },
    created: function () {
      // 获取豆瓣Api 最近上映 start count
      this.getInTheaters(0, 21);
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
    }
  }
</script>
<style>
  @import "../../../static/douban/css/home.css";
</style>
