package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Param;
import org.ostenant.springboot.learning.examples.model.Course;
import org.ostenant.springboot.learning.examples.model.CourseExample;

import java.util.List;

public interface CourseMapper {

    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(String id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}