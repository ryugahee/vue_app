import Home from "@/pages/Home.vue";
import Login from "@/pages/login/Login.vue";
import Join from "@/pages/login/Join.vue";
import Post from "@/pages/item/Post.vue";
import {createRouter, createWebHistory} from "vue-router";
import ProductDetail from "@/pages/ProductDetail.vue";
import UserInfo from "@/pages/mypage/UserInfo.vue";

const routes = [
    {path:'/', component: Home},
    {path:'/login', component: Login},
    {path:'/join', component: Join},
    {path:'/post', component: Post},
    {path:'/product/detail', component: ProductDetail},
    {path:'/mypage/info', component: UserInfo},
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;
