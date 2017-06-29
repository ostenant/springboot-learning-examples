package org.ostenant.springboot.learning.examples.service.impl;

import org.ostenant.springboot.learning.examples.mapper.StudentInfoMapper;
import org.ostenant.springboot.learning.examples.model.StudentInfo;
import org.ostenant.springboot.learning.examples.model.StudentInfoExample;
import org.ostenant.springboot.learning.examples.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Madison on 2017/6/29.
 */
@Service
@Transactional
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    public int deleteById(String id) {
        return studentInfoMapper.deleteByPrimaryKey(id);
    }

    public int save(StudentInfo record) {
        return studentInfoMapper.insertSelective(record);
    }

    @Transactional(readOnly = true)
    public List<StudentInfo> findAll() {
        return studentInfoMapper.selectByExample(new StudentInfoExample());
    }

    @Transactional(readOnly = true)
    public StudentInfo findById(String id) {
        return studentInfoMapper.selectByPrimaryKey(id);
    }

    public int update(StudentInfo record) {
        return studentInfoMapper.updateByPrimaryKeySelective(record);
    }
}
