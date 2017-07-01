package org.ostenant.springboot.learning.examples.controller;

import org.ostenant.springboot.learning.examples.model.Student;
import org.ostenant.springboot.learning.examples.service.StudentService;
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
public class StudentController implements BasicController<Student, String> {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/api/course/{id}", method = RequestMethod.DELETE)
    public int deleteById(@PathVariable("id") String id) {
        return studentService.deleteById(id);
    }

    @RequestMapping(value = "/api/course", method = RequestMethod.POST)
    public int save(Student student) {
        return studentService.save(student);
    }

    @RequestMapping(value = "/api/courses", method = RequestMethod.GET)
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @RequestMapping(value = "/api/course/{id}", method = RequestMethod.GET)
    public Student findById(@PathVariable("id") String id) {
        return studentService.findById(id);
    }

    @RequestMapping(value = "/api/course", method = RequestMethod.PUT)
    public int update(Student student) {
        return studentService.update(student);
    }
}
