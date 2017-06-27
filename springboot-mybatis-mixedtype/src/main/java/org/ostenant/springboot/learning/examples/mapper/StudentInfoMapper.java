package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.ostenant.springboot.learning.examples.model.StudentInfo;
import org.ostenant.springboot.learning.examples.model.StudentInfoExample;

import java.util.List;

public interface StudentInfoMapper {

    long countByExample(StudentInfoExample example);

    int deleteByExample(StudentInfoExample example);

    @Delete({
            "delete from student_info",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into student_info (id, age, ",
            "phone_number, gender, ",
            "email, address)",
            "values (#{id,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, ",
            "#{phoneNumber,jdbcType=VARCHAR}, #{gender,jdbcType=BIT}, ",
            "#{email,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR})"
    })
    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    List<StudentInfo> selectByExample(StudentInfoExample example);

    @Select({
            "select",
            "id, age, phone_number, gender, email, address",
            "from student_info",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.master.mapper.StudentInfoMapper.BaseResultMap")
    StudentInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByExample(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByPrimaryKeySelective(StudentInfo record);

    @Update({
            "update student_info",
            "set age = #{age,jdbcType=INTEGER},",
            "phone_number = #{phoneNumber,jdbcType=VARCHAR},",
            "gender = #{gender,jdbcType=BIT},",
            "email = #{email,jdbcType=VARCHAR},",
            "address = #{address,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(StudentInfo record);
}