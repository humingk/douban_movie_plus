import Vue from 'vue'
import Router from 'vue-router'
import home from '../components/home'
import subject from "../components/subject";

Vue.use(Router);

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: home
    },
    {
      path:'/subject/:movieId',
      name:'subject',
      component:subject
    }
  ]
})
