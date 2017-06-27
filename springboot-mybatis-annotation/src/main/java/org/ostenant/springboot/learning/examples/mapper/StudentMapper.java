package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.ostenant.springboot.learning.examples.model.Student;
import org.ostenant.springboot.learning.examples.model.StudentExample;

import java.util.List;

@Mapper
public interface StudentMapper {

    @SelectProvider(type = StudentSqlProvider.class, method = "countByExample")
    long countByExample(StudentExample example);

    @DeleteProvider(type = StudentSqlProvider.class, method = "deleteByExample")
    int deleteByExample(StudentExample example);

    @Delete({
            "delete from student",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into student (id, name, ",
            "stu_number, grade, ",
            "class_number, department_id)",
            "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
            "#{stuNumber,jdbcType=INTEGER}, #{grade,jdbcType=VARCHAR}, ",
            "#{classNumber,jdbcType=INTEGER}, #{departmentId,jdbcType=VARCHAR})"
    })
    int insert(Student record);

    @InsertProvider(type = StudentSqlProvider.class, method = "insertSelective")
    int insertSelective(Student record);

    @SelectProvider(type = StudentSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "stu_number", property = "stuNumber", jdbcType = JdbcType.INTEGER),
            @Result(column = "grade", property = "grade", jdbcType = JdbcType.VARCHAR),
            @Result(column = "class_number", property = "classNumber", jdbcType = JdbcType.INTEGER),
            @Result(column = "department_id", property = "departmentId", jdbcType = JdbcType.VARCHAR)
    })
    List<Student> selectByExample(StudentExample example);

    @Select({
            "select",
            "id, name, stu_number, grade, class_number, department_id",
            "from student",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "stu_number", property = "stuNumber", jdbcType = JdbcType.INTEGER),
            @Result(column = "grade", property = "grade", jdbcType = JdbcType.VARCHAR),
            @Result(column = "class_number", property = "classNumber", jdbcType = JdbcType.INTEGER),
            @Result(column = "department_id", property = "departmentId", jdbcType = JdbcType.VARCHAR)
    })
    Student selectByPrimaryKey(String id);

    @UpdateProvider(type = StudentSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type = StudentSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type = StudentSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);

    @Update({
            "update student",
            "set name = #{name,jdbcType=VARCHAR},",
            "stu_number = #{stuNumber,jdbcType=INTEGER},",
            "grade = #{grade,jdbcType=VARCHAR},",
            "class_number = #{classNumber,jdbcType=INTEGER},",
            "department_id = #{departmentId,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Student record);
}