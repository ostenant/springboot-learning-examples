package org.ostenant.springboot.learning.examples.service.impl;

import org.ostenant.springboot.learning.examples.mapper.CourseMapper;
import org.ostenant.springboot.learning.examples.model.Course;
import org.ostenant.springboot.learning.examples.model.CourseExample;
import org.ostenant.springboot.learning.examples.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Madison on 2017/6/25.
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int deleteById(String id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int save(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return courseMapper.selectByExample(new CourseExample());
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(String id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }

}
