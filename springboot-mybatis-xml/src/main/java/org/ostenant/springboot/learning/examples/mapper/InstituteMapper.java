package org.ostenant.springboot.learning.examples.mapper;

import org.ostenant.springboot.learning.examples.model.Institute;

public interface InstituteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Institute record);

    int insertSelective(Institute record);

    Institute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Institute record);

    int updateByPrimaryKey(Institute record);
}