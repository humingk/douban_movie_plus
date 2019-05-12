<template>
  <!--新片榜-->
  <div id="new" v-if="doubanNew.subjects && doubanNew.subjects.length!=0" class="s" data-dstat-areaid="70" data-dstat-mode="click,expose">
    <div class="screening-hd">
        <span><a :href="url_douban+'/chart'" target="_blank">查看更多>></a></span>
    </div>
    <div class="screening-bd" v-if="doubanNew.subjects">
      <div data-v-3e982be2="" class="list-wp">
        <a v-for="item in doubanNew.subjects"
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
    name: 'doubanNew',
    data: function () {
      return {
        url_douban: url_douban,
        doubanNew: {},
      }
    },
    created: function () {
      // new
      this.getNew();
    },
    methods: {
      // 新片榜
      getNew: function () {
        this.$jsonp(url_api_douban + "/v2/movie/new_movies?apikey=" + apikey_api_douban).then(response => {
          if (response.subjects && response.subjects.length != 0) {
            console.log("douban new movies: ");
            console.log(response);
            this.doubanNew = response;
          } else {
            console.log("get new movies failed...count 0...(server error)");
          }
        }).catch(error => {
          console.log("get new movies failed...");
          console.log(error);
        });
      },
    }
  }
</script>
<style>
  @import "../../../static/douban/css/home.css";
</style>
