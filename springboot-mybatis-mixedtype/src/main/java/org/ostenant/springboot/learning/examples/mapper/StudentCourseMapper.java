package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.ostenant.springboot.learning.examples.model.StudentCourse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentCourseMapper {
    @Delete({
            "delete from student_course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteById(Integer id);

    @Insert({
            "insert into student_course (id, student_id, ",
            "course_id, score)",
            "values (#{id,jdbcType=INTEGER}, #{studentId,jdbcType=INTEGER}, ",
            "#{courseId,jdbcType=INTEGER}, #{score,jdbcType=DOUBLE})"
    })
    int save(StudentCourse record);

    @Select({
            "select",
            "id, student_id, course_id, score",
            "from student_course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.mapper.StudentCourseMapper.BaseResultMap")
    StudentCourse findById(Integer id);

    int update(StudentCourse record);

    List<StudentCourse> findAll();

    List<StudentCourse> findByIds(List<Integer> list);

    int deleteByIds(List<Integer> list);

    int saveBatch(List<StudentCourse> list);

    int updateBatch(List<StudentCourse> list);
}