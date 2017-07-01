package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.Course;

public class CourseSqlProvider {

    public String insertSelective(Course record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("course");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }

        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }

        if (record.getLessonPeriod() != null) {
            sql.VALUES("lesson_period", "#{lessonPeriod,jdbcType=DOUBLE}");
        }

        if (record.getTotalCourse() != null) {
            sql.VALUES("total_course", "#{totalCourse,jdbcType=INTEGER}");
        }

        return sql.toString();
    }


    public String updateByPrimaryKeySelective(Course record) {
        SQL sql = new SQL();
        sql.UPDATE("course");

        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }

        if (record.getLessonPeriod() != null) {
            sql.SET("lesson_period = #{lessonPeriod,jdbcType=DOUBLE}");
        }

        if (record.getTotalCourse() != null) {
            sql.SET("total_course = #{totalCourse,jdbcType=INTEGER}");
        }

        sql.WHERE("id = #{id,jdbcType=VARCHAR}");

        return sql.toString();
    }

}