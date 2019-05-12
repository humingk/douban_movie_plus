<template>
  <!--top250-->
  <div id="top250" v-if="top250.subjects && top250.subjects.length!=0" class="s" data-dstat-areaid="70" data-dstat-mode="click,expose">
    <div class="screening-hd">
        <span><a :href="url_douban+'/top250'" target="_blank">查看更多>></a></span>
    </div>
    <div class="screening-bd" v-if="top250.subjects">
      <div data-v-3e982be2="" class="list-wp">
        <a v-for="item in top250.subjects"
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
    url_api_douban, url_douban
  } from '../../config';
  export default {
    name: 'top250',
    data: function () {
      return {
        url_douban: url_douban,
        top250: {},
      }
    },
    created: function () {
      // Top250
      this.getTop250(0, 21);
    },
    methods: {
      // api top250
      getTop250: function (start, count) {
        this.$jsonp(url_api_douban + "/v2/movie/top250?start=" + start + "&count=" + count).then(response => {
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
    }
  }
</script>
<style>
  @import "../../../static/douban/css/home.css";
</style>
