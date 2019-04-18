import Vue from 'vue'
import Router from 'vue-router'
import home from '../components/home'
import subject from "../components/subject";
import search from '../components/search'
import celebrity from '../components/celebrity'

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
    },
    {
      path:'/subject_search',
      name:'search',
      component:search
    },
    {
      path:'/celebrity/:actorId',
      name:'celebrity',
      component:celebrity
    }
  ]
})
