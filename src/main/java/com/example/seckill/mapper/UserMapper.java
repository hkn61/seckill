package com.example.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 *  Mapper 接口
 *
 * @author hkn
 * @date 2023-06-13
 */
@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
