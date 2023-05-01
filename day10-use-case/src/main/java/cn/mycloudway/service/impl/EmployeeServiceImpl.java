package cn.mycloudway.service.impl;

import cn.mycloudway.mapper.EmployeeMapper;
import cn.mycloudway.pojo.Employee;
import cn.mycloudway.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Integer getCountByCondition(String name, Short gender, LocalDate startDate, LocalDate endDate) {
        return employeeMapper.getCountByCondition(name, gender, startDate, endDate);
    }

    @Override
    public List<Employee> selectByConditionAndPagination(String name, Short gender, LocalDate startDate, LocalDate endDate, Integer page, Integer pageSize) {
        int index = (page - 1) * pageSize;

        return employeeMapper.selectByConditionAndPagination(name, gender, startDate, endDate, index, pageSize);
    }
}
