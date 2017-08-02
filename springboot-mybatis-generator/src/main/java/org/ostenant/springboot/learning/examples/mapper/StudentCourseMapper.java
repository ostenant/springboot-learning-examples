package org.ostenant.springboot.learning.examples.mapper;

import org.ostenant.springboot.learning.examples.model.StudentCourse;

import java.util.List;

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