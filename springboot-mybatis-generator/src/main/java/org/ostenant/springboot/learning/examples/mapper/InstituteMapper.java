package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
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

    @InsertProvider(type=InstituteSqlProvider.class, method="insertSelective")
    int insertSelective(Institute record);

    @Select({
        "select",
        "id, name",
        "from institute",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Institute selectByPrimaryKey(Integer id);

    @UpdateProvider(type=InstituteSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Institute record);

    @Update({
        "update institute",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Institute record);
}