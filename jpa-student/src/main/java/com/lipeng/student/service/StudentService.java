package com.lipeng.student.service;

import com.lipeng.student.dao.StudentRepository;
import com.lipeng.student.entity.Clazz;
import com.lipeng.student.entity.Domain;
import com.lipeng.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    //学生列表
    Page list(Integer pageNum, Integer pageSize, Domain domain);
    //学生的添加和修改
    boolean saveOrUpdate(Student student);
    //查询所有班级
    List<Clazz> getAll();
    //删除
    boolean delete(Integer[] ids);
    //添加班级
    boolean addCla(Clazz clazz);
}
