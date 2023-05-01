package cn.mycloudway.mapper;

import cn.mycloudway.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    public Emp getById(Integer id);

    public List<Emp> getByCondition(String name, Short gender, LocalDate startDate, LocalDate endDate);

    public void insert(Emp emp);

    public void update(Emp emp);

    public void delete(Integer id);

    public void deleteByIds(List<Integer> ids);
}
