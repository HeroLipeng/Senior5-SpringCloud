package com.lipeng.student.dao;

import com.lipeng.student.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClazzRepository extends JpaRepository<Clazz,Integer> {
}
