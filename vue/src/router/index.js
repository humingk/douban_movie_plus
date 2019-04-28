import Vue from 'vue'
import Router from 'vue-router'
import home from '../components/home'
import subject from "../components/subject";
import search from '../components/search'
import celebrity from '../components/celebrity'
import tag from '../components/tag'
import chart from '../components/chart'
import people from '../components/people'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: home
    },
    {
      path: '/subject/:movieId',
      name: 'subject',
      component: subject
    },
    {
      path: '/subject_search',
      name: 'search',
      component: search
    },
    {
      path: '/celebrity/:actorId',
      name: 'celebrity',
      component: celebrity
    },
    {
      path:'/tag/:tagName',
      name:'tag',
      component:tag
    },
    {
      path:'/chart',
      name:'chart',
      component:chart
    },
    {
      path:'/people/:userId',
      name:'people',
      component:people
    }
  ]
})
