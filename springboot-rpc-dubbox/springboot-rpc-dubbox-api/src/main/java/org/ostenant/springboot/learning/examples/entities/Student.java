package org.ostenant.springboot.learning.examples.entities;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Student implements Serializable {

    private Integer id;

    private String name;

    private String grade;

    private String classNumber;

    private Integer instituteId;

    private StudentInfo studentInfo;

    private List<StudentCourse> studentCourses = new ArrayList<>();

    public Student withId(Integer id) {
        this.setId(id);
        return this;
    }

    public Student withName(String name) {
        this.setName(name);
        return this;
    }

    public Student withGrade(String grade) {
        this.setGrade(grade);
        return this;
    }

    public Student withInstituteId(Integer instituteId) {
        this.setInstituteId(instituteId);
        return this;
    }

    public Student withClassNumber(String classNumber) {
        this.setClassNumber(classNumber);
        return this;
    }

    public Student withStudentInfo(StudentInfo studentInfo) {
        this.setStudentInfo(studentInfo);
        return this;
    }

    public Student withStudentCourses(List<StudentCourse> studentCourses) {
        if (CollectionUtils.isNotEmpty(studentCourses)) {
            getStudentCourses().addAll(studentCourses);
        }
        return this;
    }

}