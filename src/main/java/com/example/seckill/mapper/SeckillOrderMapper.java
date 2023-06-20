package com.example.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.pojo.SeckillOrder;

/**
 *  Mapper 接口
 *
 * @author hkn
 * @date 2023-06-19
 */
public interface SeckillOrderMapper extends BaseMapper<SeckillOrder> {

    void insertSeckillOrder(SeckillOrder seckillOrder);

    SeckillOrder selectSeckillOrder(Long id, Long goodsId);
}
