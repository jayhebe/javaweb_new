package cn.mycloudway.service.impl;

import cn.mycloudway.mapper.EmployeeMapper;
import cn.mycloudway.pojo.Employee;
import cn.mycloudway.pojo.PageBean;
import cn.mycloudway.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageBean<Employee> selectByConditionAndPagination(String name, Short gender, LocalDate startDate, LocalDate endDate, Integer page, Integer pageSize) {
        Long total = employeeMapper.getCountByCondition(name, gender, startDate, endDate);
        int index = (page - 1) * pageSize;
        List<Employee> employeeList = employeeMapper.selectByConditionAndPagination(name, gender, startDate, endDate, index, pageSize);

        PageBean<Employee> employeePageBean = new PageBean<>();
        employeePageBean.setTotal(total);
        employeePageBean.setRows(employeeList);

        return employeePageBean;
    }
}
