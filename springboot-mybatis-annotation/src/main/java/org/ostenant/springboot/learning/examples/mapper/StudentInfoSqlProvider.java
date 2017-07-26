package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.StudentInfo;

public class StudentInfoSqlProvider {

    public String update(StudentInfo record) {
        return new SQL() {
            {
                UPDATE("student_info");

                if (record.getAge() != null) {
                    SET("age = #{age,jdbcType=INTEGER}");
                }

                if (record.getAddress() != null) {
                    SET("address = #{address,jdbcType=VARCHAR}");
                }

                if (record.getEmail() != null) {
                    SET("email = #{email,jdbcType=VARCHAR}");
                }

                if (record.getStudentId() != null) {
                    SET("student_id = #{studentId,jdbcType=INTEGER}");
                }

                WHERE("id = #{id,jdbcType=INTEGER}");
            }
        }.toString();
    }
}