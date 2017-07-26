package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.ostenant.springboot.learning.examples.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    @Delete({
            "delete from course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteById(Integer id);


    @Insert({
            "insert into course (name, ",
            "lesson_period, score)",
            "values (#{name,jdbcType=VARCHAR}, ",
            "#{lessonPeriod,jdbcType=DOUBLE}, #{score,jdbcType=DOUBLE})"
    })
    @SelectKey(statement = "select last_insert_id()", keyProperty = "course.id", before = false, resultType = int.class)
    int save(Course course);


    @Select({
            "select",
            "id, name, lesson_period, score",
            "from course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "lesson_period", property = "lessonPeriod", jdbcType = JdbcType.DOUBLE),
            @Result(column = "score", property = "score", jdbcType = JdbcType.DOUBLE)
    })
    Course findById(Integer id);


    @UpdateProvider(type = CourseSqlProvider.class, method = "update")
    int update(Course course);

    @Select({
            "select",
            "id, name, lesson_period, score",
            "from course"
    })
    List<Course> findAll();

}