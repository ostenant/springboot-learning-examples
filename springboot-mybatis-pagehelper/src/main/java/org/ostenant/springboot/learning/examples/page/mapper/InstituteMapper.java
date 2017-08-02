package org.ostenant.springboot.learning.examples.page.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.ostenant.springboot.learning.examples.page.model.Institute;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InstituteMapper {

    int deleteById(Integer id);

    int save(Institute record);

    Institute findById(Integer id);

    int update(Institute record);

    List<Institute> findAll();

    List<Institute> findByIds(List<Integer> list);

    int deleteByIds(List<Integer> list);

    int saveBatch(List<Institute> list);

    int updateBatch(List<Institute> list);
}