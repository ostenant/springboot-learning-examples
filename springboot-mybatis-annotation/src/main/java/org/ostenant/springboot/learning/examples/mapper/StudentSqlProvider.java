package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.Student;

public class StudentSqlProvider {


    public String insertSelective(Student record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("student");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }

        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getStuNumber() != null) {
            sql.VALUES("stu_number", "#{stuNumber,jdbcType=INTEGER}");
        }

        if (record.getGrade() != null) {
            sql.VALUES("grade", "#{grade,jdbcType=VARCHAR}");
        }

        if (record.getClassNumber() != null) {
            sql.VALUES("class_number", "#{classNumber,jdbcType=INTEGER}");
        }

        if (record.getDepartmentId() != null) {
            sql.VALUES("department_id", "#{departmentId,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }


    public String updateByPrimaryKeySelective(Student record) {
        SQL sql = new SQL();
        sql.UPDATE("student");

        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getStuNumber() != null) {
            sql.SET("stu_number = #{stuNumber,jdbcType=INTEGER}");
        }

        if (record.getGrade() != null) {
            sql.SET("grade = #{grade,jdbcType=VARCHAR}");
        }

        if (record.getClassNumber() != null) {
            sql.SET("class_number = #{classNumber,jdbcType=INTEGER}");
        }

        if (record.getDepartmentId() != null) {
            sql.SET("department_id = #{departmentId,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=VARCHAR}");

        return sql.toString();
    }

}