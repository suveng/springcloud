package com.free.system.id.mapper;

import com.free.system.id.model.UniqueIdLog;
import com.free.system.service.common.db.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UniqueIdLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UniqueIdLog record);

    int insertSelective(UniqueIdLog record);

    UniqueIdLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UniqueIdLog record);

    int updateByPrimaryKey(UniqueIdLog record);

    int selectTotal(@Param("record") UniqueIdLog record);

    List<UniqueIdLog> selectList(@Param("record") UniqueIdLog record, @Param("order") Order order, @Param("offset") int offset, @Param("count") int count);
}
