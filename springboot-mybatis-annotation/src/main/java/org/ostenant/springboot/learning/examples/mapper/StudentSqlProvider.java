package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.Student;
import org.ostenant.springboot.learning.examples.model.StudentExample;
import org.ostenant.springboot.learning.examples.model.StudentExample.Criteria;
import org.ostenant.springboot.learning.examples.model.StudentExample.Criterion;

import java.util.List;
import java.util.Map;

public class StudentSqlProvider {

    public String countByExample(StudentExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("student");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(StudentExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("student");
        applyWhere(sql, example, false);
        return sql.toString();
    }

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

    public String selectByExample(StudentExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("stu_number");
        sql.SELECT("grade");
        sql.SELECT("class_number");
        sql.SELECT("department_id");
        sql.FROM("student");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Student record = (Student) parameter.get("record");
        StudentExample example = (StudentExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("student");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }

        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }

        if (record.getStuNumber() != null) {
            sql.SET("stu_number = #{record.stuNumber,jdbcType=INTEGER}");
        }

        if (record.getGrade() != null) {
            sql.SET("grade = #{record.grade,jdbcType=VARCHAR}");
        }

        if (record.getClassNumber() != null) {
            sql.SET("class_number = #{record.classNumber,jdbcType=INTEGER}");
        }

        if (record.getDepartmentId() != null) {
            sql.SET("department_id = #{record.departmentId,jdbcType=VARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("student");

        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("stu_number = #{record.stuNumber,jdbcType=INTEGER}");
        sql.SET("grade = #{record.grade,jdbcType=VARCHAR}");
        sql.SET("class_number = #{record.classNumber,jdbcType=INTEGER}");
        sql.SET("department_id = #{record.departmentId,jdbcType=VARCHAR}");

        StudentExample example = (StudentExample) parameter.get("example");
        applyWhere(sql, example, true);
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

    protected void applyWhere(SQL sql, StudentExample example, boolean includeExamplePhrase) {
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