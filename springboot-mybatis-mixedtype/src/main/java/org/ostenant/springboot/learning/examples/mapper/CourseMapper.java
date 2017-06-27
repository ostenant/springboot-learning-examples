package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.ostenant.springboot.learning.examples.model.Course;
import org.ostenant.springboot.learning.examples.model.CourseExample;

import java.util.List;

public interface CourseMapper {

    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    @Delete({
            "delete from course",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into course (id, name, ",
            "description, lesson_period, ",
            "total_course)",
            "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
            "#{description,jdbcType=VARCHAR}, #{lessonPeriod,jdbcType=DOUBLE}, ",
            "#{totalCourse,jdbcType=INTEGER})"
    })
    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    @Select({
            "select",
            "id, name, description, lesson_period, total_course",
            "from course",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.master.mapper.CourseMapper.BaseResultMap")
    Course selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    @Update({
            "update course",
            "set name = #{name,jdbcType=VARCHAR},",
            "description = #{description,jdbcType=VARCHAR},",
            "lesson_period = #{lessonPeriod,jdbcType=DOUBLE},",
            "total_course = #{totalCourse,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Course record);
}