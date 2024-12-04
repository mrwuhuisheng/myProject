package com.hs.service;

import com.hs.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuhuisheng
 * @since 2024-12-04
 */
public interface StudentService extends IService<Student> {

    List<Student> getByName(String name);
}
