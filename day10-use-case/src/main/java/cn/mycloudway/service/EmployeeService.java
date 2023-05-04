package cn.mycloudway.service;

import cn.mycloudway.pojo.Employee;
import cn.mycloudway.pojo.PageBean;

import java.time.LocalDate;

public interface EmployeeService {
    public PageBean<Employee> selectByConditionAndPagination(String name, Short gender, LocalDate startDate, LocalDate endDate, Integer pageNum, Integer pageSize);

    public Employee selectById(Integer id);

    public void add(Employee employee);

    public void edit(Employee employee);

    public void deleteByIds(Integer[] ids);

    public Employee login(Employee employee);
}
