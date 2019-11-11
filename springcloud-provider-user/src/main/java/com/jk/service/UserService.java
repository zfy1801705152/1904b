package com.jk.service;

import com.jk.model.Tree;
import com.jk.model.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    List<Tree> queryTree();

    HashMap<String, Object> queryGoods(Integer page, Integer rows);

    void saveUser(User user);

    void deluser(String id);

    User queryUserById(Integer userId);

    void updateUser(User user);
}
