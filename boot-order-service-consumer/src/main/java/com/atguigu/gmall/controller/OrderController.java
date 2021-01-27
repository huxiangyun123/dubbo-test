package com.atguigu.gmall.controller;

import java.util.List;

import com.atguigu.gmall.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.gmall.bean.UserAddress;

@Controller
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @ResponseBody
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid") String userId) {
        List<UserAddress> list = orderService.initOrder(userId);
        return list;
    }

}
