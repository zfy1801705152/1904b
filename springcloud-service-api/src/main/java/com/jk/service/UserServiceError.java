package com.jk.service;

import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
@Component
public class UserServiceError implements UserServiceFeign {
    public void test() {
        System.out.println("测试方法请求失败");
    }

    public List<Tree> queryTree() {
        System.out.println("查询树失败");
        return null;
    }

    public HashMap<String, Object> queryGoods(Integer page, Integer rows) {
        System.out.println("查询失败");
        return null;
    }

    public void saveUser(User user) {
        System.out.println("新增失败");
    }

    public void deluser(String id) {
        System.out.println("删除失败");
    }


    public User queryUserById(Integer userId) {
        System.out.println("回显失败");
        return null;
    }

    public void updateUser(User user) {
        System.out.println("修改失败");
    }
}
