package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.SeckillOrder;
import com.example.seckill.pojo.User;

/**
 * 
 *
 * @author hkn
 * @date 2023-06-19
 */
public interface ISeckillOrderService extends IService<SeckillOrder> {

    // get seckill result
    Long getResult(User user, Long goodsId);
}
