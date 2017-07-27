package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ostenant.springboot.learning.examples.model.Institute;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InstituteMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Institute record);

    int insertSelective(Institute record);

    Institute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Institute record);

    int updateByPrimaryKey(Institute record);

    int saveBatch(List<Institute> list);

}