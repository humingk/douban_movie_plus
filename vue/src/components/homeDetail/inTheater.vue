<template>
  <!--正在上映-->
  <div id="screening" v-if="inTheaters && inTheaters.length!=0" class="s" data-dstat-areaid="70"
       data-dstat-mode="click,expose">
    <div class="screening-hd">
      <span><a :href="url_douban+'/cinema/nowplaying'" target="_blank">全部正在热映>></a></span>
      <span><a :href="url_douban+'/cinema/later'" target="_blank">即将上映>></a></span>
    </div>
    <div class="screening-bd">
      <div data-v-3e982be2="" class="list-wp">
        <div v-for="items in inTheaters">
          <a v-for="item in items.data.subjects"
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
        <div v-infinite-scroll="loadMore"
             infinite-scroll-disabled="busy"
             infinite-scroll-distance="1000"
             infinite-scroll-throttle-delay="200">
        </div>
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
        busy: true,
        start: 0,
        count: 14,
        isOver:false,
        url_douban: url_douban,
        inTheaters: []
      }
    },
    created: function () {
      // 获取豆瓣Api 最近上映 start count
      this.getInTheaters(this.start, this.count);
    },
    methods: {
      // 获取豆瓣Api 最近上映
      getInTheaters: function (start, count) {
        // params集合会导致获取信息不全,采用url拼接
        this.$jsonp(url_api_douban + "/v2/movie/in_theaters?start=" + start + "&count=" + count + "&apikey=" + apikey_api_douban).then(response => {
          if (response.total && response.total != 0) {
            console.log("douban theaters: ");
            console.log(response);
            this.inTheaters.push({
              start: this.start,
              data: response
            });
            //----------------懒加载start
            this.start = this.start + this.count;
            // 非第一次加载数据
            if (start != 0) {
              // 如果此次收到电影个数小于count,表示最后一次数据
              if (response && response.length < this.count) {
                // 禁止滚动
                this.busy = true;
                // 加载到底
                this.isOver = true;
              }
              //服务器还有数据
              else {
                // 允许滚动
                this.busy = false;
              }
            }
            // 第一次加载数据
            else {
              // 第一次加载后，允许滚动
              this.busy = false;
            }
            //----------------懒加载end
          } else {
            console.log("get in theaters failed...count 0...(server error)");
          }
        }).catch(error => {
          console.log("get in theaters failed...");
          console.log(error);
        });
      },

      // 连续加载
      loadMore: function () {
        if (!this.isOver) {
          this.busy = true;
          // 延迟，以防止滚动条滚动的时候频繁地请求数据
          setTimeout(load => {
            this.getInTheaters(this.start, this.count);
            this.busy = false;
          }, 500);
        }
      }
      ,
    }
  }
</script>
<style>
  @import "../../../static/douban/css/home.css";
</style>
