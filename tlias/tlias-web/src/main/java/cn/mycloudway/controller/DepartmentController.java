package cn.mycloudway.controller;

import cn.mycloudway.annotation.Log;
import cn.mycloudway.pojo.Department;
import cn.mycloudway.pojo.Result;
import cn.mycloudway.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public Result selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        log.info("查询所有部门数据");

        return Result.success(departmentList);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        Department department = departmentService.selectById(id);
        log.info("查询ID为 {} 的部门", id);

        return Result.success(department);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        departmentService.deleteById(id);
        log.info("删除ID为 {} 的数据", id);

        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Department department) {
        departmentService.add(department);
        log.info("添加部门：" + department.getName());

        return Result.success();
    }

    @Log
    @PutMapping
    public Result edit(@RequestBody Department department) {
        departmentService.edit(department);
        log.info("修改部门ID为 {} 的部门名称为：{}", department.getId(), department.getName());

        return Result.success();
    }
}
