package org.ostenant.springboot.learning.examples.service.impl;

import org.ostenant.springboot.learning.examples.mapper.StudentInfoMapper;
import org.ostenant.springboot.learning.examples.model.StudentInfo;
import org.ostenant.springboot.learning.examples.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    public int deleteById(Integer id) {
        return studentInfoMapper.deleteById(id);
    }

    public int save(StudentInfo studentInfo) {
        return studentInfoMapper.save(studentInfo);
    }

    @Transactional(readOnly = true)
    public List<StudentInfo> findAll() {
        return studentInfoMapper.findAll();
    }

    @Transactional(readOnly = true)
    public StudentInfo findById(Integer id) {
        return studentInfoMapper.findById(id);
    }

    public int update(StudentInfo studentInfo) {
        return studentInfoMapper.update(studentInfo);
    }
}
