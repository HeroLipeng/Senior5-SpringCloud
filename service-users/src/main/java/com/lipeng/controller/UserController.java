package com.lipeng.controller;

import com.lipeng.service.OrderService;
import com.lipeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("getUser")
    public Object list(){
        return userService.getAll();
    }
    @RequestMapping("getOrder")
    public Object list2(){
        return orderService.getAll();
    }
}
