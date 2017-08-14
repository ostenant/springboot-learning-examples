package org.ostenant.springboot.learning.examples.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable {

    private Integer id;

    private String name;

    private Double lessonPeriod;

    private Double score;

    public Course withId(Integer id) {
        this.setId(id);
        return this;
    }

    public Course withName(String name) {
        this.setName(name);
        return this;
    }

    public Course withLessonPeriod(Double lessonPeriod) {
        this.setLessonPeriod(lessonPeriod);
        return this;
    }

    public Course withScore(Double score) {
        this.setScore(score);
        return this;
    }

}