package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.StudentCourse;

public class StudentCourseSqlProvider {

    public String update(StudentCourse record) {
        return new SQL() {
            {
                UPDATE("student_course");

                if (record.getStudentId() != null) {
                    SET("student_id = #{studentId,jdbcType=INTEGER}");
                }

                if (record.getCourseId() != null) {
                    SET("course_id = #{courseId,jdbcType=INTEGER}");
                }

                if (record.getScore() != null) {
                    SET("score = #{score,jdbcType=DOUBLE}");
                }

                WHERE("id = #{id,jdbcType=INTEGER}");
            }
        }.toString();
    }

}