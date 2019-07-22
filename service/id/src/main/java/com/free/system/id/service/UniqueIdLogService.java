package com.free.system.id.service;

import com.free.system.id.mapper.UniqueIdLogMapper;
import com.free.system.id.model.UniqueIdLog;
import com.free.system.service.common.db.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UniqueIdLogService {
    @Autowired
    private UniqueIdLogMapper uniqueIdLogMapper;

    public int deleteByPrimaryKey(Long id) {
        Assert.notNull(id,"id不能为空");
        return uniqueIdLogMapper.deleteByPrimaryKey(id);
    }

    public int insert(UniqueIdLog record) {
        Assert.notNull(record, "查询对象不能为空");
        return uniqueIdLogMapper.insert(record);
    }

    public int insertSelective(UniqueIdLog record) {
        Assert.notNull(record, "查询对象不能为空");
        return uniqueIdLogMapper.insertSelective(record);
    }

    public UniqueIdLog selectByPrimaryKey(Long id) {
        Assert.notNull(id, "id不能为空");
        return uniqueIdLogMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(UniqueIdLog record) {
        Assert.notNull(record, "查询对象不能为空");
        return uniqueIdLogMapper.updateByPrimaryKeySelective(record);
    }

    public int selectTotal(UniqueIdLog record) {
        Assert.notNull(record, "查询对象不能为空");
        return uniqueIdLogMapper.selectTotal(record);
    }

    public List<UniqueIdLog> selectList(UniqueIdLog record, Order order, int offset, int count) {
        Assert.notNull(record, "查询对象不能为空");
        return uniqueIdLogMapper.selectList(record, order, offset, count);
    }

    public UniqueIdLog selectOne(UniqueIdLog record, Order order) {
        Assert.notNull(record, "查询对象不能为空");
        List<UniqueIdLog> list = selectList(record, order, 0, 1);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
