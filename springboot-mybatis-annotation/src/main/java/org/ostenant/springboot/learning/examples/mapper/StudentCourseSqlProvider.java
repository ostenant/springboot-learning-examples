package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.StudentCourse;

public class StudentCourseSqlProvider {


    public String insertSelective(StudentCourse record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("student_course");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }

        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=DOUBLE}");
        }

        if (record.getCourseId() != null) {
            sql.VALUES("course_id", "#{courseId,jdbcType=VARCHAR}");
        }

        if (record.getStudentId() != null) {
            sql.VALUES("student_id", "#{studentId,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }


    public String updateByPrimaryKeySelective(StudentCourse record) {
        SQL sql = new SQL();
        sql.UPDATE("student_course");

        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }

        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=DOUBLE}");
        }

        if (record.getCourseId() != null) {
            sql.SET("course_id = #{courseId,jdbcType=VARCHAR}");
        }

        if (record.getStudentId() != null) {
            sql.SET("student_id = #{studentId,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=VARCHAR}");

        return sql.toString();
    }

}