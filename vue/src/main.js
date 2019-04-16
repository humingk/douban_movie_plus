// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

// // axios
// import axios from 'axios'
// import VueAxios from 'vue-axios'
// Vue.use(VueAxios,axios);

// jsonp
import VueJsonp from 'vue-jsonp'
Vue.use(VueJsonp);

// element-ui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

// 瀑布流加载数据
import infiniteScroll from 'vue-infinite-scroll';
Vue.use(infiniteScroll);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {
    "App":App
  },
  template: "<App/>"
});
