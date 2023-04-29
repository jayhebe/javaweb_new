package cn.mycloudway.mapper;

import cn.mycloudway.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("SELECT * FROM emp WHERE id = #{id}")
    public Emp getById(Integer id);

    @Select("SELECT * FROM emp WHERE name LIKE concat('%', #{name}, '%') AND gender = #{gender} AND entrydate BETWEEN #{startDate} AND #{endDate} ORDER BY update_time DESC")
    public List<Emp> getByCondition(String name, Short gender, LocalDate startDate, LocalDate endDate);
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUES (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    @Update("UPDATE emp SET " +
            "username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, entrydate = #{entryDate}, dept_id = #{deptId}, update_time = #{updateTime} WHERE id = #{id}")
    public void update(Emp emp);

    @Delete("DELETE FROM emp WHERE id = #{id}")
    public void delete(Integer id);
}
