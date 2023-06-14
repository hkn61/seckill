package com.example.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.pojo.User;
import com.example.seckill.mapper.UserMapper;
import com.example.seckill.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author hkn
 * @date 2023-06-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
