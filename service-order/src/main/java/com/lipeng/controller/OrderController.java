package com.lipeng.controller;

import com.lipeng.entity.Order;
import com.lipeng.entity.User;
import com.lipeng.feign.UserFeignClient;
import com.lipeng.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order/")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;
    /**
     * 根据Id查询订单
     * @param id
     * @return
     */
    @RequestMapping("getOrderById")
    public Order getOrderById(@RequestParam("id")Integer id){
        Order order = orderService.getOrderById(id);
        //service-user1是被调用服务名称，spring.application.name的名称
        //User user=restTemplate.getForObject("http://service-user1/user/getById?id="+order.getUserId(), User.class);
        //User user = userFeignClient.getById(id);
        User userParam=new User();
        userParam.setId(1);
        User user = userFeignClient.getUserByUser(userParam);
        log.info("user:{}",user);
        order.setUsername(user.getUsername());
        return order;
    }










}
