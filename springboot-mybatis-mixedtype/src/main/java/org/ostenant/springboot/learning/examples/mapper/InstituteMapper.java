package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.ostenant.springboot.learning.examples.model.Institute;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InstituteMapper {
    @Delete({
            "delete from institute",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteById(Integer id);

    @Insert({
            "insert into institute (id, name)",
            "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int save(Institute record);

    @Select({
            "select",
            "id, name",
            "from institute",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.mapper.InstituteMapper.BaseResultMap")
    Institute findById(Integer id);

    int update(Institute record);

    List<Institute> findAll();

    List<Institute> findByIds(List<Integer> list);

    int deleteByIds(List<Integer> list);

    int saveBatch(List<Institute> list);

    int updateBatch(List<Institute> list);
}