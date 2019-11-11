package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;


    @Override
    public List<Tree> queryTree() {
        List<Tree> treeList = queryTreeByPid(0);
        return treeList;
    }

    @Override
    public HashMap<String, Object> queryGoods(Integer page, Integer rows) {
        page = (page-1)*rows;
        HashMap<String, Object> map = new HashMap<>();
        Integer sum = userMapper.queryGoodsSum();
        List<User> goodsList = userMapper.queryGoodsList(page,rows);
        map.put("rows",goodsList);
        map.put("total",sum);
        return map;
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public void deluser(String id) {
        String[] split = id.split(",");
        userMapper.deluser(split);
    }

    @Override
    public User queryUserById(Integer userId) {
        return  userMapper.queryUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    private List<Tree> queryTreeByPid(Integer id){
        List<Tree> treeList = userMapper.queryTreeList(id);
        for (Tree tree : treeList) {
            List<Tree> nodeList = queryTreeByPid(tree.getId());
            if(nodeList == null || nodeList.size() <= 0) {
                tree.setSelectable(true);
                tree.setLeaf(true);
            } else {
                tree.setSelectable(false);
                tree.setNodes(nodeList);
            }

        }
        return treeList;
    }

}
