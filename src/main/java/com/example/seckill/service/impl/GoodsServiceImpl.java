package com.example.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.mapper.GoodsMapper;
import com.example.seckill.pojo.Goods;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 *
 * @author hkn
 * @date 2023-06-19
 */
@Service
@Primary
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    // get goods list
    @Override
    public List<GoodsVo> findGoodsVo() {
        List<GoodsVo> goodsVo = goodsMapper.findGoodsVo();
//        String g = goodsVo.get(0).getGoodsName();
        return goodsMapper.findGoodsVo();
    }
}
