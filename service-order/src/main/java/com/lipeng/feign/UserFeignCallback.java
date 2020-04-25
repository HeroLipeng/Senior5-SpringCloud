package com.lipeng.feign;

import com.lipeng.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
//@Configuration
public class UserFeignCallback implements UserFeignClient{
    @Override
    public User getById(Integer id) {
        User user=new User();
        user.setUsername("固定值");
        return null;
    }

    @Override
    public User getUserByUser(User user) {
        User u=new User();
        u.setUsername("固定值："+123);
        return u;
    }

    @Override
    public String getUsernameById(Integer id) {
        return null;
    }
}
