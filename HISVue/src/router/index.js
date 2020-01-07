import Vue from 'vue'
import Router from 'vue-router'
import Welcome from '@/page/welcome/Welcome'
import Create from '@/page/create/Create'
import Login from '@/page/login/Login'
import PatientHome from '@/page/patient/PatientHome'
import DoctorHome from '@/page/Doctor/DoctorHome'
import NurseHome from '@/page/Nurse/NurseHome'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '',
      name: 'Welcome',
      component: Welcome
    },
    {
      path: '/create',
      name: 'Create',
      component: Create
    },
    {
      path:'/login',
      name: 'Login',
      component: Login
    },
    {
      path:'/patienthome',
      name:'PatientHome',
      component:PatientHome
    },
    {
      path: '/doctorhome',
      name: 'DoctorHome',
      component: DoctorHome
    },
    {
      path: '/nursehome',
      name: 'NurseHome',
      component: NurseHome
    }
  ]
})
