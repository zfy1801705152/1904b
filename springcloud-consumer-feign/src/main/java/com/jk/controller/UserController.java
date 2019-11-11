package com.jk.controller;

import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.UserServiceFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserServiceFeign userServiceFeign;


    @RequestMapping("test")
    public void test(){
        userServiceFeign.test();
    }

    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> queryTree(HttpServletResponse response) throws IOException {
        List<Tree> trees = userServiceFeign.queryTree();
        if(trees==null){
            response.setContentType("text/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！！！");
            printWriter.flush();
            printWriter.close();
        }
        return trees;
    }

    //跳主页
    @RequestMapping("toIndex")
    public String toInde(){
        return "index";
    }

    //商品查询  分页
    @RequestMapping("queryGoods")
    @ResponseBody
    public HashMap<String,Object> queryGoods(Integer page, Integer rows, HttpServletResponse response) throws IOException {
        HashMap<String, Object> goods = userServiceFeign.queryGoods(page, rows);
        if(goods == null){
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！！！");
            printWriter.flush();
            printWriter.close();
        }
        return goods;
    }
     //get请求传入实体类对象传入解决方案

    @RequestMapping("toAddUser")
    public String toAddUser() {
        return "adduser";
    }

    @RequestMapping("toEditUser")
    public String toEditUser() {
        return "edituser";
    }

    //跳查询页
    @RequestMapping("toquery")
    public String toquery(){
        return "query";
    }

    @RequestMapping("saveUser")
    @ResponseBody
    public void saveUser(User user) {

        userServiceFeign.saveUser(user);
    }

    @RequestMapping("deluser")
    @ResponseBody
    public void deluser(String id){
        userServiceFeign.deluser(id);
    }

    @RequestMapping("queryUserById")
    @ResponseBody
    public User queryUserById(Integer userId) {

        return userServiceFeign.queryUserById(userId);
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public void updateUser(User user) {
        userServiceFeign.updateUser(user);
    }

   
}
