package org.ostenant.springboot.learning.examples.mapper;

import java.util.List;
import org.ostenant.springboot.learning.examples.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> findByIds(List<Integer> list);
}