package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.ostenant.springboot.learning.examples.model.Department;
import org.ostenant.springboot.learning.examples.model.DepartmentExample;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @SelectProvider(type = DepartmentSqlProvider.class, method = "countByExample")
    long countByExample(DepartmentExample example);

    @DeleteProvider(type = DepartmentSqlProvider.class, method = "deleteByExample")
    int deleteByExample(DepartmentExample example);

    @Insert({
            "insert into department (id, name, ",
            "description)",
            "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
            "#{description,jdbcType=VARCHAR})"
    })
    int insert(Department record);

    @InsertProvider(type = DepartmentSqlProvider.class, method = "insertSelective")
    int insertSelective(Department record);

    @SelectProvider(type = DepartmentSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR)
    })
    List<Department> selectByExample(DepartmentExample example);

    @UpdateProvider(type = DepartmentSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    @UpdateProvider(type = DepartmentSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);
}