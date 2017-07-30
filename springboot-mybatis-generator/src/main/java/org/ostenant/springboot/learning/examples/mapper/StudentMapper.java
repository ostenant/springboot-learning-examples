package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.ostenant.springboot.learning.examples.model.Student;

public interface StudentMapper {
    @Delete({
        "delete from student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into student (id, name, ",
        "grade, class_number, ",
        "institute_id)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{grade,jdbcType=VARCHAR}, #{classNumber,jdbcType=VARCHAR}, ",
        "#{instituteId,jdbcType=INTEGER})"
    })
    int insert(Student record);

    @InsertProvider(type=StudentSqlProvider.class, method="insertSelective")
    int insertSelective(Student record);

    @Select({
        "select",
        "id, name, grade, class_number, institute_id",
        "from student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_number", property="classNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="institute_id", property="instituteId", jdbcType=JdbcType.INTEGER)
    })
    Student selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update student",
        "set name = #{name,jdbcType=VARCHAR},",
          "grade = #{grade,jdbcType=VARCHAR},",
          "class_number = #{classNumber,jdbcType=VARCHAR},",
          "institute_id = #{instituteId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
}