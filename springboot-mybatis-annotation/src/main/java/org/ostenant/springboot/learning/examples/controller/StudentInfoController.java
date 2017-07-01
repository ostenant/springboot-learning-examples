package org.ostenant.springboot.learning.examples.controller;

import org.ostenant.springboot.learning.examples.model.StudentInfo;
import org.ostenant.springboot.learning.examples.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Madison on 2017/6/25.
 */
@RestController
public class StudentInfoController implements BasicController<StudentInfo, String> {

    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping(value = "/api/course/{id}", method = RequestMethod.DELETE)
    public int deleteById(@PathVariable("id") String id) {
        return studentInfoService.deleteById(id);
    }

    @RequestMapping(value = "/api/course", method = RequestMethod.POST)
    public int save(StudentInfo studentInfo) {
        return studentInfoService.save(studentInfo);
    }

    @RequestMapping(value = "/api/courses", method = RequestMethod.GET)
    public List<StudentInfo> findAll() {
        return studentInfoService.findAll();
    }

    @RequestMapping(value = "/api/course/{id}", method = RequestMethod.GET)
    public StudentInfo findById(@PathVariable("id") String id) {
        return studentInfoService.findById(id);
    }

    @RequestMapping(value = "/api/course", method = RequestMethod.PUT)
    public int update(StudentInfo studentInfo) {
        return studentInfoService.update(studentInfo);
    }
}
