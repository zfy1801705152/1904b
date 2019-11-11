package com.jk.service;

import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@FeignClient(value= "provider-user", fallback = UserServiceError.class)
public interface UserServiceFeign {

    @GetMapping("test")
    void test();

    @GetMapping("queryTree")
    List<Tree> queryTree();

    @GetMapping("queryGoods")
    HashMap<String, Object> queryGoods(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows);

    @PostMapping("saveUser")
    void saveUser(@RequestBody User user);

    @GetMapping("deluser")
    void deluser(@RequestParam("id") String id);

    @GetMapping("queryUserById")
    User queryUserById(@RequestParam("userId") Integer userId);

    @PostMapping("updateUser")
    void updateUser(@RequestBody User user);
}
