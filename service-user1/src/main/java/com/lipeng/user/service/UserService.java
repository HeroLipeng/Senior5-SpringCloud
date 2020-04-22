package com.lipeng.user.service;

import com.lipeng.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * 根据Id，查询user
     * @param id
     * @return
     */
    public User getById(Integer id){
        //实例化一个对象
        User user=new User();
        user.setId(1);
        user.setUsername("username"+id);
        user.setPassword("123456");
        return user;
    }

    /**
     * 根据Id，查询用户名称
     * @param id
     * @return
     */
   /* public String getUsernameById(Integer id){
        User user=getById(1);
        return user.getUsername();
    }*/
    public String getUsernameById(Integer id){
        User user=getById(1);
        return user.getUsername();

    }



}
