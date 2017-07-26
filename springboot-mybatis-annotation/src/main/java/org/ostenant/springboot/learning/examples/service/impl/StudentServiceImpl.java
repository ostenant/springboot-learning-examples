package org.ostenant.springboot.learning.examples.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.ostenant.springboot.learning.examples.mapper.StudentMapper;
import org.ostenant.springboot.learning.examples.model.Student;
import org.ostenant.springboot.learning.examples.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public int deleteById(Integer id) {
        return studentMapper.deleteById(id);
    }

    public int save(Student record) {
        return studentMapper.save(record);
    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Transactional(readOnly = true)
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    public int update(Student record) {
        return studentMapper.update(record);
    }

    public List<Student> saveBatch(List<Student> students) {
        if (CollectionUtils.isNotEmpty(students)) {
            studentMapper.saveBatch(students);
            return students;
        }
        return null;
    }
}
