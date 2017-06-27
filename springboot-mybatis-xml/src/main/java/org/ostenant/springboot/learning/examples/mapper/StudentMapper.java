package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Param;
import org.ostenant.springboot.learning.examples.model.Student;
import org.ostenant.springboot.learning.examples.model.StudentExample;

import java.util.List;

public interface StudentMapper {

    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}