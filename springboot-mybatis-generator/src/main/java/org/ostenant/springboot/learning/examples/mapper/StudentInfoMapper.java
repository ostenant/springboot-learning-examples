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

    @InsertProvider(type=StudentInfoSqlProvider.class, method="insertSelective")
    int insertSelective(StudentInfo record);

    @Select({
        "select",
        "id, age, address, email, student_id",
        "from student_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER)
    })
    StudentInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StudentInfoSqlProvider.class, method="updateByPrimaryKeySelective")
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