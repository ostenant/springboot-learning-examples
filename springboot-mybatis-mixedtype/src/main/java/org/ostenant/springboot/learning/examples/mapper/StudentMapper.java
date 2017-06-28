package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.ostenant.springboot.learning.examples.model.Student;
import org.ostenant.springboot.learning.examples.model.StudentExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper {

    long countByExample(StudentExample example);

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

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    @Select({
            "select",
            "id, name, stu_number, grade, class_number, department_id",
            "from student",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.master.mapper.StudentMapper.BaseResultMap")
    Student selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

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