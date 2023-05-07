package cn.mycloudway.mapper;

import cn.mycloudway.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    public List<Department> selectAll();

    public Department selectById(Integer id);

    public void deleteById(Integer id);

    public void add(Department department);

    public void edit(Department department);
}
