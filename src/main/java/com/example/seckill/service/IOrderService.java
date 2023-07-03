package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Order;
import com.example.seckill.pojo.User;
import com.example.seckill.vo.GoodsVo;
import com.example.seckill.vo.OrderDetailVo;

/**
 * 
 *
 * @author hkn
 * @date 2023-06-19
 */
public interface IOrderService extends IService<Order> {

    // seckill
    Order seckill(User user, GoodsVo goods);

    OrderDetailVo detail(Long orderId);
}
