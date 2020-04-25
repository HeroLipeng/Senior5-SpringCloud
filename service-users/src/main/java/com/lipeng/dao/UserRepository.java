package com.lipeng.dao;

import com.lipeng.entity.Order;
import com.lipeng.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
}
