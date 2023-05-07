package cn.mycloudway.service;

import cn.mycloudway.pojo.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> selectAll();

    public Department selectById(Integer id);

    public void deleteById(Integer id);

    public void add(Department department);

    public void edit(Department department);
}
