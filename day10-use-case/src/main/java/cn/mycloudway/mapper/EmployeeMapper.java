package cn.mycloudway.mapper;

import cn.mycloudway.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    public Long getCountByCondition(String name, Short gender, LocalDate startDate, LocalDate endDate);
    public List<Employee> selectByConditionAndPagination(String name, Short gender, LocalDate startDate, LocalDate endDate, Integer index, Integer size);
}
