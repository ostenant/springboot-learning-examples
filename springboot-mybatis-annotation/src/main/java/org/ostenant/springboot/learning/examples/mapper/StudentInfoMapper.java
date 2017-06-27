package org.ostenant.springboot.learning.examples.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.ostenant.springboot.learning.examples.model.StudentInfo;
import org.ostenant.springboot.learning.examples.model.StudentInfoExample;

import java.util.List;

@Mapper
public interface StudentInfoMapper {

    @SelectProvider(type = StudentInfoSqlProvider.class, method = "countByExample")
    long countByExample(StudentInfoExample example);

    @DeleteProvider(type = StudentInfoSqlProvider.class, method = "deleteByExample")
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

    @InsertProvider(type = StudentInfoSqlProvider.class, method = "insertSelective")
    int insertSelective(StudentInfo record);

    @SelectProvider(type = StudentInfoSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER),
            @Result(column = "phone_number", property = "phoneNumber", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.BIT),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR)
    })
    List<StudentInfo> selectByExample(StudentInfoExample example);

    @Select({
            "select",
            "id, age, phone_number, gender, email, address",
            "from student_info",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER),
            @Result(column = "phone_number", property = "phoneNumber", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.BIT),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR)
    })
    StudentInfo selectByPrimaryKey(String id);

    @UpdateProvider(type = StudentInfoSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    @UpdateProvider(type = StudentInfoSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    @UpdateProvider(type = StudentInfoSqlProvider.class, method = "updateByPrimaryKeySelective")
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