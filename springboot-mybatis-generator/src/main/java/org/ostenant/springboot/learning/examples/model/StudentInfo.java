package org.ostenant.springboot.learning.examples.model;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.Objects;
import org.ostenant.springboot.learning.examples.mybatis.utils.JSONAttrGetter;

public class StudentInfo implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 学生年龄
     */
    private Integer age;

    /**
     * 家庭地址
     */
    private String address;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 学生ID
     */
    private Integer studentId;

    public Integer getId() {
        return id;
    }

    public StudentInfo withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public StudentInfo withAge(Integer age) {
        this.setAge(age);
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public StudentInfo withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public StudentInfo withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public StudentInfo withStudentId(Integer studentId) {
        this.setStudentId(studentId);
        return this;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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
        StudentInfo other = (StudentInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, address, email, studentId);
    }

    public static StudentInfo fromJson(JSONObject fromJsonObj) {
        if (fromJsonObj == null || fromJsonObj.isEmpty()){
            return null;
        }
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(JSONAttrGetter.getInteger(fromJsonObj, StudentInfoKey.ID));
        studentInfo.setAge(JSONAttrGetter.getInteger(fromJsonObj, StudentInfoKey.AGE));
        studentInfo.setAddress(JSONAttrGetter.getString(fromJsonObj, StudentInfoKey.ADDRESS));
        studentInfo.setEmail(JSONAttrGetter.getString(fromJsonObj, StudentInfoKey.EMAIL));
        studentInfo.setStudentId(JSONAttrGetter.getInteger(fromJsonObj, StudentInfoKey.STUDENT_ID));
        return studentInfo;
    }

    public JSONObject toJson() {
        JSONObject toJsonObj = new JSONObject();
        toJsonObj.put(StudentInfoKey.ID, id);
        toJsonObj.put(StudentInfoKey.AGE, age);
        toJsonObj.put(StudentInfoKey.ADDRESS, address);
        toJsonObj.put(StudentInfoKey.EMAIL, email);
        toJsonObj.put(StudentInfoKey.STUDENT_ID, studentId);
        return toJsonObj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", age=").append(age);
        sb.append(", address=").append(address);
        sb.append(", email=").append(email);
        sb.append(", studentId=").append(studentId);
        sb.append("]");
        return sb.toString();
    }

    public static final class StudentInfoKey {
        /**
         * 主键ID
         */
        public static final String ID = "id";

        /**
         * 学生年龄
         */
        public static final String AGE = "age";

        /**
         * 家庭地址
         */
        public static final String ADDRESS = "address";

        /**
         * 邮箱地址
         */
        public static final String EMAIL = "email";

        /**
         * 学生ID
         */
        public static final String STUDENT_ID = "student_id";
    }
}