package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.ostenant.springboot.learning.examples.model.Department;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Insert({
            "insert into department (id, name, ",
            "description)",
            "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
            "#{description,jdbcType=VARCHAR})"
    })
    int insert(Department record);

    @InsertProvider(type = DepartmentSqlProvider.class, method = "insertSelective")
    int insertSelective(Department record);

    @Delete({
            "delete from department",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);


    @Select({
            "select id, name, description",
            "from department",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR)
    })
    Department selectByPrimaryKey(String id);

    @Update({
            "update department",
            "set"
    })
    int updateByPrimaryKeySelective(Department record);

    @Select({
            "select id, name, description",
            "from department"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR)
    })
    List<Department> selectAll();
}