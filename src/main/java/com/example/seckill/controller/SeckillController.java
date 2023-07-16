package com.example.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.seckill.mapper.OrderMapper;
import com.example.seckill.mapper.SeckillOrderMapper;
import com.example.seckill.pojo.Order;
import com.example.seckill.pojo.SeckillOrder;
import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.IOrderService;
import com.example.seckill.service.ISeckillOrderService;
import com.example.seckill.service.impl.SeckillOrderServiceImpl;
import com.example.seckill.vo.GoodsVo;
import com.example.seckill.vo.RespBean;
import com.example.seckill.vo.RespBeanEnum;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/seckill")
@Api(value = "秒杀", tags = "秒杀")
public class SeckillController implements InitializingBean {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ISeckillOrderService seckillOrderService;

    @Autowired
    private IOrderService orderService;
    @Autowired
    private SeckillOrderMapper seckillOrderMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    // seckill
    // QPS before optimization: 879
    // QPS after optimization: 1300
    @RequestMapping("/doSeckill2")
    public String doSeckill2(Model model, User user, Long goodsId){
        if(user == null){
            return "login";
        }
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        if(goods.getStockCount() < 1){
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "secKillFail";
        }

        // check whether ordered twice
//        QueryWrapper<SeckillOrder> eq = new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId);
//        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
        SeckillOrder seckillOrder = seckillOrderMapper.selectSeckillOrder(user.getId(), goodsId);
//        SeckillOrder seckillOrder = (SeckillOrder) redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodsId);
        if(seckillOrder != null){
            model.addAttribute("errmsg", RespBeanEnum.REPEAT_ERROR.getMessage());
            return "secKillFail";
        }
        Order order = orderService.seckill(user, goods);
//        Order order = orderMapper.selectOrder(user.getId(), goodsId);
        model.addAttribute("order", order);
        model.addAttribute("goods", goods);
        return "orderDetail";
    }


    @RequestMapping(value = "/doSeckill", method = RequestMethod.POST)
    @ResponseBody
    public RespBean doSeckill(Model model, User user, Long goodsId) {
        if(user == null){
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }

        ValueOperations valueOperations = redisTemplate.opsForValue();
        // check if ordered twice
        SeckillOrder seckillOrder = (SeckillOrder) redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodsId);
        if(seckillOrder != null){
//            model.addAttribute("errmsg", RespBeanEnum.REPEAT_ERROR.getMessage());
            return RespBean.error(RespBeanEnum.REPEAT_ERROR);
        }
        // pre deduct the stock
        Long stock = valueOperations.decrement("seckillGoods:" + goodsId);
        if(stock < 0){
            valueOperations.increment("seckillGoods:" + goodsId);
            return RespBean.error(RespBeanEnum.EMPTY_STOCK);
        }

        Order order = orderService.seckill(user, goods);
        return RespBean.success(order);

//        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
//        if(goods.getStockCount() < 1){
////            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
//            return RespBean.error(RespBeanEnum.EMPTY_STOCK);
//        }
//
//        // check whether ordered twice
////        QueryWrapper<SeckillOrder> eq = new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId);
////        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
////        SeckillOrder seckillOrder = seckillOrderMapper.selectSeckillOrder(user.getId(), goodsId);
//        SeckillOrder seckillOrder = (SeckillOrder) redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodsId);
//        if(seckillOrder != null){
////            model.addAttribute("errmsg", RespBeanEnum.REPEAT_ERROR.getMessage());
//            return RespBean.error(RespBeanEnum.REPEAT_ERROR);
//        }
//        Order order = orderService.seckill(user, goods);
////        Order order = orderMapper.selectOrder(user.getId(), goodsId);
//        return RespBean.success(order);


    }

    // initialize the system, load the goods stock to Redis
    @Override
    public void afterPropertiesSet() throws Exception {
        List<GoodsVo> list = goodsService.findGoodsVo();
        if(CollectionUtils.isEmpty(list)){
            return;
        }
        list.forEach(goodsVo -> {
            redisTemplate.opsForValue().set("seckillGoods:" + goodsVo.getId(), goodsVo.getStockCount());
        });
    }
}
