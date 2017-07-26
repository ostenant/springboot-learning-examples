package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.ostenant.springboot.learning.examples.model.Institute;

public class InstituteSqlProvider {

    public String update(Institute record) {
        return new SQL() {
            {
                UPDATE("institute");

                if (record.getName() != null) {
                    SET("name = #{name,jdbcType=VARCHAR}");
                }
                WHERE("id = #{id,jdbcType=INTEGER}");
            }
        }.toString();
    }
}