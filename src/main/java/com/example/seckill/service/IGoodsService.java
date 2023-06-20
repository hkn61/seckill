package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Goods;
import com.example.seckill.vo.GoodsVo;

import java.util.List;

/**
 * 
 *
 * @author hkn
 * @date 2023-06-19
 */
public interface IGoodsService extends IService<Goods> {

    // get goods list
    List<GoodsVo> findGoodsVo();

    // get goods detail
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
