package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Param;
import org.ostenant.springboot.learning.examples.model.StudentCourse;
import org.ostenant.springboot.learning.examples.model.StudentCourseExample;

import java.util.List;

public interface StudentCourseMapper {

    long countByExample(StudentCourseExample example);

    int deleteByExample(StudentCourseExample example);

    int deleteByPrimaryKey(String id);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    List<StudentCourse> selectByExample(StudentCourseExample example);

    StudentCourse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

    int updateByExample(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}