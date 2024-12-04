package com.hs.mapper;

import com.hs.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuhuisheng
 * @since 2024-12-04
 */
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> getByName(@Param("userName") String userName);
}
