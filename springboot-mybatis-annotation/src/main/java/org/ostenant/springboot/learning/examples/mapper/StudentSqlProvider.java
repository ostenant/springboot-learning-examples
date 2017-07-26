package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.Student;

public class StudentSqlProvider {

    public String update(Student record) {
        return new SQL() {
            {
                UPDATE("student");

                if (record.getName() != null) {
                    SET("name = #{name,jdbcType=VARCHAR}");
                }

                if (record.getGrade() != null) {
                    SET("grade = #{grade,jdbcType=VARCHAR}");
                }

                if (record.getClassNumber() != null) {
                    SET("class_number = #{classNumber,jdbcType=VARCHAR}");
                }

                if (record.getInstituteId() != null) {
                    SET("institute_id = #{instituteId,jdbcType=INTEGER}");
                }

                WHERE("id = #{id,jdbcType=INTEGER}");
            }
        }.toString();
    }
}