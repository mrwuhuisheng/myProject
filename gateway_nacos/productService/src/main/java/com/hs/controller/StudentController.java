package com.hs.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hs.entity.Student;
import com.hs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuhuisheng
 * @since 2024-12-04
 */
@RestController
@RequestMapping("/user")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getUser")
    public Student getUser(String name){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",name);
        Student student = studentService.getOne(queryWrapper);
        return student;
    }

    @RequestMapping("/getByName")
    public List<Student> getByName(String name){
        List<Student> studentList = studentService.getByName(name);
        return studentList;
    }

}
