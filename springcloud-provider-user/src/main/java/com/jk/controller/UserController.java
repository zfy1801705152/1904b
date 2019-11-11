package com.jk.controller;

import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.service.UserServiceFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController implements UserServiceFeign {

    @Resource
    private UserService userService;

    @GetMapping("test")
    public void test() {
        System.out.println("进来了");
    }

    @GetMapping("queryTree")
    public List<Tree> queryTree() {
        return userService.queryTree();
    }

    @GetMapping("queryGoods")
    public HashMap<String, Object> queryGoods(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows) {
        return userService.queryGoods(page,rows);
    }
    @PostMapping("saveUser")
    @Override
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }
    @GetMapping("deluser")
    @Override
        public void deluser(@RequestParam("id") String id) {
        userService.deluser(id);
    }
    @GetMapping("queryUserById")
    @Override
    public User queryUserById(@RequestParam("userId") Integer userId) {
        return userService.queryUserById(userId);
    }
    @PostMapping("updateUser")
    @Override
    public void updateUser(User user) {
        userService.updateUser(user);
    }

}
