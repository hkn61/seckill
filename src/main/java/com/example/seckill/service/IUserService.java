package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.User;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;

/**
 * 
 *
 * @author hkn
 * @date 2023-06-13
 */
public interface IUserService extends IService<User> {
    RespBean doLogin(LoginVo loginVo);
}
