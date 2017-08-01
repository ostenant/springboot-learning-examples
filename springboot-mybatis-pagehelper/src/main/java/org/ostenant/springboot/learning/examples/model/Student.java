package org.ostenant.springboot.learning.examples.model;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String grade;

    private String classNumber;

    private Integer instituteId;

    public Integer getId() {
        return id;
    }

    public Student withId(Integer id) {
        this.setId(id);
        return this;
    }

    public Student withName(String name) {
        this.setName(name);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGrade() {
        return grade;
    }

    public Student withGrade(String grade) {
        this.setGrade(grade);
        return this;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getClassNumber() {
        return classNumber;
    }

    public Student withClassNumber(String classNumber) {
        this.setClassNumber(classNumber);
        return this;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber == null ? null : classNumber.trim();
    }

    public Integer getInstituteId() {
        return instituteId;
    }

    public Student withInstituteId(Integer instituteId) {
        this.setInstituteId(instituteId);
        return this;
    }

    public void setInstituteId(Integer instituteId) {
        this.instituteId = instituteId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getClassNumber() == null ? other.getClassNumber() == null : this.getClassNumber().equals(other.getClassNumber()))
            && (this.getInstituteId() == null ? other.getInstituteId() == null : this.getInstituteId().equals(other.getInstituteId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getClassNumber() == null) ? 0 : getClassNumber().hashCode());
        result = prime * result + ((getInstituteId() == null) ? 0 : getInstituteId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", grade=").append(grade);
        sb.append(", classNumber=").append(classNumber);
        sb.append(", instituteId=").append(instituteId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}