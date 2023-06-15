package com.example.seckill.controller;

import com.example.seckill.pojo.User;
import jakarta.servlet.http.Cookie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequestMapping("/goods")
public class GoodsController {

    // redirect to the goods list page
    @RequestMapping("/toList")
    public String toList(HttpSession session, Model model, @CookieValue("userTicket") String ticket){
        log.info("ticket: ", ticket);
//        String t = ticket.getValue();
//        ticket = "db085ab86a31438eaa9f414013cbb380";
        if(StringUtils.isEmpty(ticket)){
            return "login";
        }
        User user = (User) session.getAttribute(String.valueOf(ticket));
        if(user == null){
            return "login";
        }
        model.addAttribute("user", user);
        return "goodsList";
    }

}
