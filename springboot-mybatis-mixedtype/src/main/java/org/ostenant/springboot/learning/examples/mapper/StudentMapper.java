package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    int insertSelective(Student record);

    @Select({
        "select",
        "id, name, grade, class_number, institute_id",
        "from student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.mapper.StudentMapper.BaseResultMap")
    Student selectByPrimaryKey(Integer id);

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