package com.example.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.pojo.Goods;
import com.example.seckill.vo.GoodsVo;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author hkn
 * @date 2023-06-19
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    // get goods list
    List<GoodsVo> findGoodsVo();
}
