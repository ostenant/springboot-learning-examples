package org.ostenant.springboot.learning.examples.service.impl;

import org.ostenant.springboot.learning.examples.mapper.StudentMapper;
import org.ostenant.springboot.learning.examples.model.Student;
import org.ostenant.springboot.learning.examples.model.StudentExample;
import org.ostenant.springboot.learning.examples.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Madison on 2017/6/29.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public int deleteById(String id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    public int save(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentMapper.selectByExample(new StudentExample());
    }

    @Transactional(readOnly = true)
    public Student findById(String id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public int update(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }
}
