package com.lipeng.student.controller;

import com.lipeng.student.config.ResultEntity;
import com.lipeng.student.entity.Clazz;
import com.lipeng.student.entity.Domain;
import com.lipeng.student.entity.Student;
import com.lipeng.student.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("student")
public class StudentController {
    @Resource
    private StudentService studentService;
    //学生列表
    @RequestMapping("list")
    public ResultEntity list(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "3")Integer pageSize, Domain doamin){
        Page page = studentService.list(pageNum, pageSize, doamin);
        return ResultEntity.ok(page);
    }
    //班级查询
    @RequestMapping("list2")
    public ResultEntity list2(){
        return ResultEntity.ok(studentService.getAll());
    }
    //添加修改
    @RequestMapping("saveOrUpdate")
    public ResultEntity saveOrUpdate(@RequestBody Student student){
        boolean b=studentService.saveOrUpdate(student);
        return ResultEntity.ok(b);
    }
    //添加班级
    @RequestMapping("addCla")
    public ResultEntity add(@RequestBody Clazz clazz){
        boolean b=studentService.addCla(clazz);
        return ResultEntity.ok(b);
    }
    //单删/批量删除
    @RequestMapping("delete")
    public ResultEntity delete(@RequestParam("ids")Integer[] ids){
        boolean b=studentService.delete(ids);
        return ResultEntity.ok(b);
    }

}
