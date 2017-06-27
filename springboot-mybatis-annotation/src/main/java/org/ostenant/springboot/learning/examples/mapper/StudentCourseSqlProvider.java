package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.StudentCourse;
import org.ostenant.springboot.learning.examples.model.StudentCourseExample;
import org.ostenant.springboot.learning.examples.model.StudentCourseExample.Criteria;
import org.ostenant.springboot.learning.examples.model.StudentCourseExample.Criterion;

import java.util.List;
import java.util.Map;

public class StudentCourseSqlProvider {

    public String countByExample(StudentCourseExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("student_course");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(StudentCourseExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("student_course");
        applyWhere(sql, example, false);
        return sql.toString();
    }

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

    public String selectByExample(StudentCourseExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("status");
        sql.SELECT("score");
        sql.SELECT("course_id");
        sql.SELECT("student_id");
        sql.FROM("student_course");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        StudentCourse record = (StudentCourse) parameter.get("record");
        StudentCourseExample example = (StudentCourseExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("student_course");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }

        if (record.getScore() != null) {
            sql.SET("score = #{record.score,jdbcType=DOUBLE}");
        }

        if (record.getCourseId() != null) {
            sql.SET("course_id = #{record.courseId,jdbcType=VARCHAR}");
        }

        if (record.getStudentId() != null) {
            sql.SET("student_id = #{record.studentId,jdbcType=VARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("student_course");

        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("score = #{record.score,jdbcType=DOUBLE}");
        sql.SET("course_id = #{record.courseId,jdbcType=VARCHAR}");
        sql.SET("student_id = #{record.studentId,jdbcType=VARCHAR}");

        StudentCourseExample example = (StudentCourseExample) parameter.get("example");
        applyWhere(sql, example, true);
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

    protected void applyWhere(SQL sql, StudentCourseExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}