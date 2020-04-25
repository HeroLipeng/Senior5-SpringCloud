package com.lipeng.feign;

import com.lipeng.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 指定服务名称：service-user1
 */
@Component
@FeignClient(name = "service-user1"/*,fallback = UserFeignCallback.class*/)
public interface UserFeignClient {

    @RequestMapping("/user/getById")
    public User getById(@RequestParam("id")Integer id);

    @RequestMapping("/user/getUserByUser")
    public User getUserByUser(@RequestBody User user);


    /**
     * 根据Id，查询用户名称
     * @param id
     * @return
     */
    @RequestMapping("/user/getUsernameById")
    public String getUsernameById(@RequestParam("id")Integer id);

}
