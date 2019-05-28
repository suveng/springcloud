package com.free.system.service.common.modules.user.mapper;

import com.free.system.service.common.db.Order;
import com.free.system.service.common.modules.user.model.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectTotal(@Param("record") User record);

    List<User> selectList(@Param("record") User record, @Param("order") Order order, @Param("offset") int offset, @Param("count") int count);
}
