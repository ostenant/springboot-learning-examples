package org.ostenant.springboot.learning.examples.mapper;

import java.util.List;
import org.ostenant.springboot.learning.examples.model.StudentInfo;

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