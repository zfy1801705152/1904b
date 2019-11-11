package com.jk.mapper;

import com.jk.model.Tree;
import com.jk.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<Tree> queryTreeList(Integer id);

    Integer queryGoodsSum();

    List<User> queryGoodsList(@Param("page") Integer page, @Param("rows")Integer rows);

    void saveUser(User user);

    void deluser(String[] split);

    User queryUserById(Integer userId);

    void updateUser(User user);
}
