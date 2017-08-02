package org.ostenant.springboot.learning.examples.mapper;

import java.util.List;
import org.ostenant.springboot.learning.examples.model.StudentCourse;

public interface StudentCourseMapper {
    int deleteById(Integer id);

    int save(StudentCourse record);

    StudentCourse findById(Integer id);

    int update(StudentCourse record);

    List<StudentCourse> findAll();

    List<StudentCourse> findByIds(List<Integer> list);

    int deleteByIds(List<Integer> list);

    int saveBatch(List<StudentCourse> list);

    int updateBatch(List<StudentCourse> list);
}