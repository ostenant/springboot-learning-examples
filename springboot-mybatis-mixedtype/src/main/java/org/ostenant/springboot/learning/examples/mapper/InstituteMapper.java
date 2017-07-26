package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ostenant.springboot.learning.examples.model.Institute;

public interface InstituteMapper {
    @Delete({
        "delete from institute",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into institute (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Institute record);

    int insertSelective(Institute record);

    @Select({
        "select",
        "id, name",
        "from institute",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.mapper.InstituteMapper.BaseResultMap")
    Institute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Institute record);

    @Update({
        "update institute",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Institute record);
}