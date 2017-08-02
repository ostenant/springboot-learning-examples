package org.ostenant.springboot.learning.examples.page.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ostenant.springboot.learning.examples.page.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    int deleteById(Integer id);

    int deleteByIds(List<Integer> list);

    Student findById(Integer id);

    List<Student> findByIds(List<Integer> list);

    List<Student> findAll();

    int save(Student record);

    int saveBatch(List<Student> list);

    int update(Student record);

    int updateBatch(List<Student> list);
}