package org.ostenant.springboot.learning.examples.mapper;

import org.ostenant.springboot.learning.examples.model.StudentInfo;

import java.util.List;

public interface StudentInfoMapper {

    int deleteById(Integer id);

    int save(StudentInfo record);

    StudentInfo findById(Integer id);

    int update(StudentInfo record);

    List<StudentInfo> findAll();

    List<StudentInfo> findByIds(List<Integer> list);

    int deleteByIds(List<Integer> list);

    int saveBatch(List<StudentInfo> list);

    int updateBatch(List<StudentInfo> list);
}