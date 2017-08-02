package org.ostenant.springboot.learning.examples.mapper;

import java.util.List;
import org.ostenant.springboot.learning.examples.model.Course;

public interface CourseMapper {
    int deleteById(Integer id);

    int save(Course record);

    Course findById(Integer id);

    int update(Course record);

    List<Course> findAll();

    List<Course> findByIds(List<Integer> list);

    int deleteByIds(List<Integer> list);

    int saveBatch(List<Course> list);

    int updateBatch(List<Course> list);
}