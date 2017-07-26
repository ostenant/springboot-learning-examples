package org.ostenant.springboot.learning.examples.mapper;

import org.ostenant.springboot.learning.examples.model.StudentCourse;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}