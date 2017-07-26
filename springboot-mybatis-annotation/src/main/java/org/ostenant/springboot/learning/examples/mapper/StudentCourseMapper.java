package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.ostenant.springboot.learning.examples.model.StudentCourse;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentCourseMapper {

    @Delete({
            "delete from student_course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteById(Integer id);


    @Insert({
            "insert into student_course (student_id, ",
            "course_id, score)",
            "values (#{studentId,jdbcType=INTEGER}, ",
            "#{courseId,jdbcType=INTEGER}, #{score,jdbcType=DOUBLE})"
    })
    @SelectKey(statement = "select last_insert_id()", keyProperty = "studentCourse.id", before = false, resultType = int.class)
    int save(StudentCourse studentCourse);


    @Select({
            "select",
            "id, student_id, course_id, score",
            "from student_course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "student_id", property = "studentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "course_id", property = "courseId", jdbcType = JdbcType.INTEGER),
            @Result(column = "score", property = "score", jdbcType = JdbcType.DOUBLE)
    })
    StudentCourse findById(Integer id);


    @UpdateProvider(type = StudentCourseSqlProvider.class, method = "update")
    int update(StudentCourse studentCourse);

}