package org.ostenant.springboot.learning.examples.controller;

import org.ostenant.springboot.learning.examples.model.slaver.Course;
import org.ostenant.springboot.learning.examples.service.CourseService;
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
public class CourseController implements BasicController<Course, String> {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public int deleteById(@PathVariable("id") String id) {
        return courseService.deleteById(id);
    }

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public int save(Course course) {
        return courseService.save(course);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public Course findById(@PathVariable("id") String id) {
        return courseService.findById(id);
    }

    @RequestMapping(value = "/course", method = RequestMethod.PUT)
    public int update(Course course) {
        return courseService.update(course);
    }
}
