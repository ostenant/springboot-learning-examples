package org.ostenant.springboot.learning.examples.controller;

import org.ostenant.springboot.learning.examples.model.Student;
import org.ostenant.springboot.learning.examples.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController implements BaseController<Student, Integer> {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/api/student/{id}", method = RequestMethod.DELETE)
    public int deleteById(@PathVariable("id") Integer id) {
        return studentService.deleteById(id);
    }

    @RequestMapping(value = "/api/student", method = RequestMethod.POST)
    public int save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @RequestMapping(value = "/api/students", method = RequestMethod.GET)
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @RequestMapping(value = "/api/student/{id}", method = RequestMethod.GET)
    public Student findById(@PathVariable("id") Integer id) {
        return studentService.findById(id);
    }

    @RequestMapping(value = "/api/student", method = RequestMethod.PUT)
    public int update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @RequestMapping(value = "/api/students", method = RequestMethod.POST)
    public List<Student> saveBatch(@RequestBody List<Student> students) {
        List<Student> studentList = studentService.saveBatch(students);
        return studentList;
    }

}
