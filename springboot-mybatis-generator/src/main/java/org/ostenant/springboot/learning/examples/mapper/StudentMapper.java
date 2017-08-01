package org.ostenant.springboot.learning.examples.mapper;

import org.ostenant.springboot.learning.examples.model.Student;

import java.util.List;

public interface StudentMapper {

    int deleteById(Integer id);

    int save(Student record);

    Student findById(Integer id);

    int update(Student record);

    List<Student> findByIds(List<Integer> list);

    int deleteByIds(List<Integer> list);

    int saveAll(List<Student> list);
}