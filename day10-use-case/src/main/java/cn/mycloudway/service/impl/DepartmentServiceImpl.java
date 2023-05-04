package cn.mycloudway.service.impl;

import cn.mycloudway.mapper.DepartmentMapper;
import cn.mycloudway.mapper.EmployeeMapper;
import cn.mycloudway.pojo.Department;
import cn.mycloudway.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public Department selectById(Integer id) {
        return departmentMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        departmentMapper.deleteById(id);
        employeeMapper.deleteByDeptId(id);
    }

    @Override
    public void add(Department department) {
        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());

        departmentMapper.add(department);
    }

    @Override
    public void edit(Department department) {
        department.setUpdateTime(LocalDateTime.now());

        departmentMapper.edit(department);
    }
}