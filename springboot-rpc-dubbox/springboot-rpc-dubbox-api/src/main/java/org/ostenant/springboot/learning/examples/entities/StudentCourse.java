package org.ostenant.springboot.learning.examples.entities;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentCourse implements Serializable {

    private Integer id;

    private Integer studentId;

    private Integer courseId;

    private Double score;

    private List<Course> courses = new ArrayList<>();


    public StudentCourse withId(Integer id) {
        this.setId(id);
        return this;
    }

    public StudentCourse withStudentId(Integer studentId) {
        this.setStudentId(studentId);
        return this;
    }

    public StudentCourse withCourseId(Integer courseId) {
        this.setCourseId(courseId);
        return this;
    }

    public StudentCourse withScore(Double score) {
        this.setScore(score);
        return this;
    }

    public StudentCourse withStudentCourse(List<Course> courses) {
        if (CollectionUtils.isNotEmpty(courses)) {
            getCourses().addAll(courses);
        }
        return this;
    }
}