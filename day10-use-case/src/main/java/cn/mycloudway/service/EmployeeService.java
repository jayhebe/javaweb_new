package cn.mycloudway.service;

import cn.mycloudway.pojo.Employee;
import cn.mycloudway.pojo.PageBean;

import java.time.LocalDate;

public interface EmployeeService {
    public PageBean<Employee> selectByConditionAndPagination(String name, Short gender, LocalDate startDate, LocalDate endDate, Integer index, Integer size);
}
