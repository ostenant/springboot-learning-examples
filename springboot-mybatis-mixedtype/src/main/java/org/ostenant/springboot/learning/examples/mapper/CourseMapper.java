package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ostenant.springboot.learning.examples.model.Course;

public interface CourseMapper {
    @Delete({
        "delete from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into course (id, name, ",
        "lesson_period, score)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{lessonPeriod,jdbcType=DOUBLE}, #{score,jdbcType=DOUBLE})"
    })
    int insert(Course record);

    int insertSelective(Course record);

    @Select({
        "select",
        "id, name, lesson_period, score",
        "from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.mapper.CourseMapper.BaseResultMap")
    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    @Update({
        "update course",
        "set name = #{name,jdbcType=VARCHAR},",
          "lesson_period = #{lessonPeriod,jdbcType=DOUBLE},",
          "score = #{score,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
}