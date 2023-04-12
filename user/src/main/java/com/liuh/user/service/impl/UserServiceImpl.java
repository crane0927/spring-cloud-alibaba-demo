package com.liuh.user.service.impl;

import com.liuh.user.mapper.UserMapper;
import com.liuh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName: com.liuh.user.service.impl
 * @FileName: UserServiceImpl
 * @Description:
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
}
