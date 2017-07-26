package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ostenant.springboot.learning.examples.model.StudentCourse;

public interface StudentCourseMapper {
    @Delete({
        "delete from student_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into student_course (id, student_id, ",
        "course_id, score)",
        "values (#{id,jdbcType=INTEGER}, #{studentId,jdbcType=INTEGER}, ",
        "#{courseId,jdbcType=INTEGER}, #{score,jdbcType=DOUBLE})"
    })
    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    @Select({
        "select",
        "id, student_id, course_id, score",
        "from student_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.mapper.StudentCourseMapper.BaseResultMap")
    StudentCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentCourse record);

    @Update({
        "update student_course",
        "set student_id = #{studentId,jdbcType=INTEGER},",
          "course_id = #{courseId,jdbcType=INTEGER},",
          "score = #{score,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentCourse record);
}