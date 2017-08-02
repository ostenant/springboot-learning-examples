package org.ostenant.springboot.learning.examples.mapper;

import java.util.List;
import org.ostenant.springboot.learning.examples.model.Student;

public interface StudentMapper {
    int deleteById(Integer id);

    int save(Student record);

    Student findById(Integer id);

    int update(Student record);

    List<Student> findAll();

    List<Student> findByIds(List<Integer> list);

    int deleteByIds(List<Integer> list);

    int saveBatch(List<Student> list);

    int updateBatch(List<Student> list);
}