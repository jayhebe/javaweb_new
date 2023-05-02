package cn.mycloudway.service.impl;

import cn.mycloudway.mapper.EmployeeMapper;
import cn.mycloudway.pojo.Employee;
import cn.mycloudway.pojo.PageBean;
import cn.mycloudway.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageBean<Employee> selectByConditionAndPagination(String name, Short gender, LocalDate startDate, LocalDate endDate, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Employee> employeeList = employeeMapper.selectByCondition(name, gender, startDate, endDate);
        Page<Employee> page = (Page<Employee>) employeeList;

        PageBean<Employee> employeePageBean = new PageBean<>();
        employeePageBean.setTotal(page.getTotal());
        employeePageBean.setRows(page.getResult());

        return employeePageBean;
    }

    @Override
    public Employee selectById(Integer id) {
        return employeeMapper.selectById(id);
    }

    @Override
    public void add(Employee employee) {
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        employeeMapper.add(employee);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        employeeMapper.deleteByIds(ids);
    }
}
