package org.ostenant.springboot.learning.examples.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentInfo implements Serializable {

    private Integer id;

    private Integer age;

    private String address;

    private String email;

    private Integer studentId;

    private Student student;

    public StudentInfo withId(Integer id) {
        this.setId(id);
        return this;
    }

    public StudentInfo withAge(Integer age) {
        this.setAge(age);
        return this;
    }

    public StudentInfo withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    public StudentInfo withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    public StudentInfo withStudentId(Integer studentId) {
        this.setStudentId(studentId);
        return this;
    }

    public StudentInfo withStudent(Student student) {
        this.setStudent(student);
        return this;
    }

}