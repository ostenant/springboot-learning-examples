package org.ostenant.springboot.learning.examples.controller;

import org.ostenant.springboot.learning.examples.model.Institute;
import org.ostenant.springboot.learning.examples.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class InstituteController implements BaseController<Institute, Integer> {

    @Autowired
    private InstituteService instituteService;

    @RequestMapping(value = "/api/institute/{id}", method = RequestMethod.DELETE)
    public int deleteById(@PathVariable("id") Integer id) {
        return instituteService.deleteById(id);
    }

    @RequestMapping(value = "/api/institute", method = RequestMethod.POST)
    public int save(Institute institute) {
        return instituteService.save(institute);
    }

    @RequestMapping(value = "/api/institutes", method = RequestMethod.GET)
    public List<Institute> findAll() {
        return instituteService.findAll();
    }

    @RequestMapping(value = "/api/institute/{id}", method = RequestMethod.GET)
    public Institute findById(@PathVariable("id") Integer id) {
        return instituteService.findById(id);
    }

    @RequestMapping(value = "/api/institute", method = RequestMethod.PUT)
    public int update(Institute institute) {
        return instituteService.update(institute);
    }
}
