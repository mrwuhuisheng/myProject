package com.hs.service.impl;

import com.hs.entity.Student;
import com.hs.mapper.StudentMapper;
import com.hs.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuhuisheng
 * @since 2024-12-04
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getByName(String name) {
        return studentMapper.getByName(name);
    }
}
