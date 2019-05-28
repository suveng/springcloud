package com.free.system.service.common.modules.user.service;

import com.free.system.service.common.db.Order;
import com.free.system.service.common.modules.user.mapper.UserMapper;
import com.free.system.service.common.modules.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int deleteByPrimaryKey(Integer id) {
        Assert.notNull(id,"id不能为空");
        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record) {
        Assert.notNull(record, "查询对象不能为空");
        return userMapper.insert(record);
    }

    public int insertSelective(User record) {
        Assert.notNull(record, "查询对象不能为空");
        return userMapper.insertSelective(record);
    }

    public User selectByPrimaryKey(Integer id) {
        Assert.notNull(id, "id不能为空");
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record) {
        Assert.notNull(record, "查询对象不能为空");
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int selectTotal(User record) {
        Assert.notNull(record, "查询对象不能为空");
        return userMapper.selectTotal(record);
    }

    public List<User> selectList(User record, Order order, int offset, int count) {
        Assert.notNull(record, "查询对象不能为空");
        return userMapper.selectList(record, order, offset, count);
    }

    public User selectOne(User record, Order order) {
        Assert.notNull(record, "查询对象不能为空");
        List<User> list = selectList(record, order, 0, 1);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
