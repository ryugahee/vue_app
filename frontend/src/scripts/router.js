import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import Join from "@/pages/Join.vue";
import Post from "@/pages/Post.vue";
import {createRouter, createWebHistory} from "vue-router";
import BoardDetail from "@/pages/BoardDetail.vue";

const routes = [
    {path:'/', component: Home},
    {path:'/login', component: Login},
    {path:'/join', component: Join},
    {path:'/post', component: Post},
    {path:'/board/detail', component: BoardDetail},
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;
