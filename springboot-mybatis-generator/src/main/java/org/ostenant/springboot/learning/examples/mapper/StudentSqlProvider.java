package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.Student;

public class StudentSqlProvider {

    public String insertSelective(Student record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("student");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            sql.VALUES("grade", "#{grade,jdbcType=VARCHAR}");
        }
        
        if (record.getClassNumber() != null) {
            sql.VALUES("class_number", "#{classNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getInstituteId() != null) {
            sql.VALUES("institute_id", "#{instituteId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Student record) {
        SQL sql = new SQL();
        sql.UPDATE("student");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            sql.SET("grade = #{grade,jdbcType=VARCHAR}");
        }
        
        if (record.getClassNumber() != null) {
            sql.SET("class_number = #{classNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getInstituteId() != null) {
            sql.SET("institute_id = #{instituteId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}