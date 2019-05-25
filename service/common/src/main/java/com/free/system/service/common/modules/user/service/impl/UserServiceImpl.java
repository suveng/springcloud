package com.free.system.service.common.modules.user.service.impl;

import com.free.system.service.common.modules.user.entity.User;
import com.free.system.service.common.modules.user.mapper.UserMapper;
import com.free.system.service.common.modules.user.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author suveng@163.com
 * @since 2019-05-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
