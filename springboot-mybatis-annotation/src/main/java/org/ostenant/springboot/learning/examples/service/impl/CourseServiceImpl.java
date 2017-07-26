package org.ostenant.springboot.learning.examples.service.impl;

import org.ostenant.springboot.learning.examples.mapper.CourseMapper;
import org.ostenant.springboot.learning.examples.model.Course;
import org.ostenant.springboot.learning.examples.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public int deleteById(Integer id) {
        return courseMapper.deleteById(id);
    }

    public int save(Course record) {
        return courseMapper.save(record);
    }

    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    @Transactional(readOnly = true)
    public Course findById(Integer id) {
        return courseMapper.findById(id);
    }

    public int update(Course course) {
        return courseMapper.update(course);
    }

}
