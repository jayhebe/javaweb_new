package cn.mycloudway.mapper;

import cn.mycloudway.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    public List<Employee> selectByCondition(String name, Short gender, LocalDate startDate, LocalDate endDate);

    public Employee selectById(Integer id);

    public void add(Employee employee);

    public void edit(Employee employee);

    public void deleteByIds(Integer[] ids);

    public void deleteByDeptId(Integer deptId);

    public Employee selectByUsernameAndPassword(Employee employee);
}
