package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ostenant.springboot.learning.examples.model.StudentInfo;

public interface StudentInfoMapper {
    @Delete({
        "delete from student_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into student_info (id, age, ",
        "address, email, ",
        "student_id)",
        "values (#{id,jdbcType=INTEGER}, #{age,jdbcType=INTEGER}, ",
        "#{address,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{studentId,jdbcType=INTEGER})"
    })
    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    @Select({
        "select",
        "id, age, address, email, student_id",
        "from student_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("org.ostenant.springboot.learning.examples.mapper.StudentInfoMapper.BaseResultMap")
    StudentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentInfo record);

    @Update({
        "update student_info",
        "set age = #{age,jdbcType=INTEGER},",
          "address = #{address,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "student_id = #{studentId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentInfo record);
}