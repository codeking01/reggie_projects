package com.codeking.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.boot.entity.User;
import com.codeking.boot.mapper.UserMapper;
import com.codeking.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/27 1:34
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
