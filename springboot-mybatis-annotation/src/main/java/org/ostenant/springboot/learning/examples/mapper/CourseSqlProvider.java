package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.Course;

public class CourseSqlProvider {

    public String update(Course course) {
        return new SQL() {
            {
                UPDATE("course");

                if (course.getName() != null) {
                    SET("name = #{name,jdbcType=VARCHAR}");
                }

                if (course.getLessonPeriod() != null) {
                    SET("lesson_period = #{lessonPeriod,jdbcType=DOUBLE}");
                }

                if (course.getScore() != null) {
                    SET("score = #{score,jdbcType=DOUBLE}");
                }

                WHERE("id = #{id,jdbcType=INTEGER}");
            }
        }.toString();
    }

}