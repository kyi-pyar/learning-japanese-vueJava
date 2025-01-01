import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import EnglishToKanji from '../views/EnglishToKanji.vue'
import RomajitoKanji from '../views/RomajitoKanji.vue'
import KanjiDetails from '@/views/KanjiDetails.vue'
import StudyKanjiAll from '@/views/StudyKanjiAll.vue'
import LoginView from '@/views/LoginView.vue'
import TakeExamView from '@/views/TakeExamView.vue'
import RegistrationView from '@/views/RegistrationView.vue'
import RetrieveUserView from '@/views/RetrieveUserView'
import RegisterationRequriementView from '@/views/RegisterationRequriementView'
import StudiedKanji from '@/views/StudiedKanji.vue'
import RetrieveStudiedKanji from "@/views/RetrieveStudiedKanji.vue"
import DetailsMemorizedKanji from "@/views/DetailsMemorizedKanji.vue"


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/engKan',
    name: 'EnglishToKanji',
    component: EnglishToKanji
  },
  {
    path: '/rmjKan',
    name: 'RomajitoKanji',
    component: RomajitoKanji
  },
  {
    path: '/kjdetail:kanji',
    name: 'KanjiDetail',
    component: KanjiDetails,
    props: true
  },
  {
    path: '/kjall',
    name: 'StudyKanji',
    component: StudyKanjiAll

  }, {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/takeExam',
    name: 'TakeExam',
    component: TakeExamView
  },
  {
    path: '/registration',
    name: 'registeration',
    component: RegistrationView

  },
  {
    path: '/aboutMe',
    name: 'aboutme',
    component: RetrieveUserView

  },
  {
    path: '/userInfo',
    name: 'userInfo',
    component: RegisterationRequriementView

  },
  {
    path: '/saveStudiedKanji',
    name: 'saveStudiedKanji',
    component: StudiedKanji

  },
  {
    path: '/retrieveStudiedKanji',
    name: 'retrieveStudiedKanji',
    component: RetrieveStudiedKanji

  },
  {
    path: '/detailsMemorizedKanji/:id',
    name: 'detailsMemorizedKanji',
    component: DetailsMemorizedKanji,
    props: true

  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
