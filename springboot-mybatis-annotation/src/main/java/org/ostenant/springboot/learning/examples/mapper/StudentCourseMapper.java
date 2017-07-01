package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.ostenant.springboot.learning.examples.model.StudentCourse;

import java.util.List;

@Mapper
public interface StudentCourseMapper {

    @SelectProvider(type = StudentCourseSqlProvider.class, method = "countByExample")
    long countByExample(StudentCourseExample example);

    @DeleteProvider(type = StudentCourseSqlProvider.class, method = "deleteByExample")
    int deleteByExample(StudentCourseExample example);

    @Delete({
            "delete from student_course",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into student_course (id, status, ",
            "score, course_id, ",
            "student_id)",
            "values (#{id,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
            "#{score,jdbcType=DOUBLE}, #{courseId,jdbcType=VARCHAR}, ",
            "#{studentId,jdbcType=VARCHAR})"
    })
    int insert(StudentCourse record);

    @InsertProvider(type = StudentCourseSqlProvider.class, method = "insertSelective")
    int insertSelective(StudentCourse record);

    @SelectProvider(type = StudentCourseSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "score", property = "score", jdbcType = JdbcType.DOUBLE),
            @Result(column = "course_id", property = "courseId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "student_id", property = "studentId", jdbcType = JdbcType.VARCHAR)
    })
    List<StudentCourse> selectByExample(StudentCourseExample example);

    @Select({
            "select",
            "id, status, score, course_id, student_id",
            "from student_course",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "score", property = "score", jdbcType = JdbcType.DOUBLE),
            @Result(column = "course_id", property = "courseId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "student_id", property = "studentId", jdbcType = JdbcType.VARCHAR)
    })
    StudentCourse selectByPrimaryKey(String id);

    @UpdateProvider(type = StudentCourseSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

    @UpdateProvider(type = StudentCourseSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

    @UpdateProvider(type = StudentCourseSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StudentCourse record);

    @Update({
            "update student_course",
            "set status = #{status,jdbcType=INTEGER},",
            "score = #{score,jdbcType=DOUBLE},",
            "course_id = #{courseId,jdbcType=VARCHAR},",
            "student_id = #{studentId,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(StudentCourse record);
}