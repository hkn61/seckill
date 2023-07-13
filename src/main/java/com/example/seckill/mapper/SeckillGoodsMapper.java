package com.example.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.pojo.SeckillGoods;

/**
 *  Mapper 接口
 *
 * @author hkn
 * @date 2023-06-19
 */
public interface SeckillGoodsMapper extends BaseMapper<SeckillGoods> {

    SeckillGoods selectByGoodsId(Long id);

    void updateStockByGoodsId(int newStock, Long id);

    int updateStock(Long id);
}
