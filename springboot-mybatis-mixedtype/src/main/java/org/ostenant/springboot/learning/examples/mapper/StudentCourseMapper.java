package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.ostenant.springboot.learning.examples.model.StudentCourse;
import org.ostenant.springboot.learning.examples.model.StudentCourseExample;

import java.util.List;

public interface StudentCourseMapper {

    long countByExample(StudentCourseExample example);

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

    int insertSelective(StudentCourse record);

    List<StudentCourse> selectByExample(StudentCourseExample example);

    @Select({
            "select",
            "id, status, score, course_id, student_id",
            "from student_course",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.master.mapper.StudentCourseMapper.BaseResultMap")
    StudentCourse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

    int updateByExample(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

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