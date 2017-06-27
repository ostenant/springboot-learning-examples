package org.ostenant.springboot.learning.examples.service.impl;

import org.ostenant.springboot.learning.examples.mapper.master.DepartmentMapper;
import org.ostenant.springboot.learning.examples.model.master.Department;
import org.ostenant.springboot.learning.examples.model.master.DepartmentExample;
import org.ostenant.springboot.learning.examples.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Madison on 2017/6/25.
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public int deleteById(String id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int save(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Department> findAll() {
        return departmentMapper.selectByExample(new DepartmentExample());
    }

    @Override
    @Transactional(readOnly = true)
    public Department findById(String id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

}
