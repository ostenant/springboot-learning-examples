package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
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

    @InsertProvider(type=StudentCourseSqlProvider.class, method="insertSelective")
    int insertSelective(StudentCourse record);

    @Select({
        "select",
        "id, student_id, course_id, score",
        "from student_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.DOUBLE)
    })
    StudentCourse selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StudentCourseSqlProvider.class, method="updateByPrimaryKeySelective")
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