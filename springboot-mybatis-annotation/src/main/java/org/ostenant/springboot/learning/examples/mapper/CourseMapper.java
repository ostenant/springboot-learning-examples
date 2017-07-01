package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.ostenant.springboot.learning.examples.model.Course;

import java.util.List;

@Mapper
public interface CourseMapper {

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

    @InsertProvider(type = CourseSqlProvider.class, method = "insertSelective")
    int insertSelective(Course record);

    @Select({
            "select",
            "id, name, description, lesson_period, total_course",
            "from course",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "lesson_period", property = "lessonPeriod", jdbcType = JdbcType.DOUBLE),
            @Result(column = "total_course", property = "totalCourse", jdbcType = JdbcType.INTEGER)
    })
    Course selectByPrimaryKey(String id);


    @UpdateProvider(type = CourseSqlProvider.class, method = "updateByPrimaryKeySelective")
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

    @Select({
            "select",
            "id, name, description, lesson_period, total_course",
            "from course"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "lesson_period", property = "lessonPeriod", jdbcType = JdbcType.DOUBLE),
            @Result(column = "total_course", property = "totalCourse", jdbcType = JdbcType.INTEGER)
    })
    List<Course> selectAll();
}