package cn.mycloudway.service;

import cn.mycloudway.pojo.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    public Integer getCountByCondition(String name, Short gender, LocalDate startDate, LocalDate endDate);
    public List<Employee> selectByConditionAndPagination(String name, Short gender, LocalDate startDate, LocalDate endDate, Integer index, Integer size);
}
