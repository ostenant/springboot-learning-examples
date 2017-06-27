package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Param;
import org.ostenant.springboot.learning.examples.model.Department;
import org.ostenant.springboot.learning.examples.model.DepartmentExample;

import java.util.List;

public interface DepartmentMapper {

    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);
}