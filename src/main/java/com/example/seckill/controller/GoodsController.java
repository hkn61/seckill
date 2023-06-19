package com.example.seckill.controller;

import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.IUserService;
import com.example.seckill.vo.GoodsVo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodsService goodsService;

    // redirect to the goods list page
    @RequestMapping("/toList")
    public String toList(Model model, User user){
//        log.info("ticket: ", ticket);
//        String t = ticket.getValue();
//        ticket = "db085ab86a31438eaa9f414013cbb380";
//        if(StringUtils.isEmpty(ticket)){
//            return "login";
//        }
////        User user = (User) session.getAttribute(String.valueOf(ticket));
//        User user = userService.getUserByCookie(ticket, request, response);
//        if(user == null){
//            return "login";
//        }
        model.addAttribute("user", user);
        List<GoodsVo> goodsVo = goodsService.findGoodsVo();
        model.addAttribute("goodsList", goodsService.findGoodsVo());
        return "goodsList";
    }

}
