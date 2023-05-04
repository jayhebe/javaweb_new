package cn.mycloudway.controller;

import cn.mycloudway.pojo.Employee;
import cn.mycloudway.pojo.PageBean;
import cn.mycloudway.pojo.Result;
import cn.mycloudway.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Result selectByConditionAndPagination(String name, Short gender,
                                                 @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                                                 @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                                                 @RequestParam(name = "page", defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "10") Integer pageSize) {

        PageBean<Employee> employeePageBean = employeeService.selectByConditionAndPagination(name, gender, begin, end, pageNum, pageSize);
        log.info("按条件分页查询员工数据，姓名：{} 性别：{} 开始时间：{} 结束时间：{} 页码：{} 数据条数：{}", name, gender, begin, end, pageNum, pageSize);

        return Result.success(employeePageBean);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        Employee employee = employeeService.selectById(id);
        log.info("根据ID查询员工，ID值为：{}", id);

        return Result.success(employee);
    }

    @PostMapping
    public Result add(@RequestBody Employee employee) {
        employeeService.add(employee);
        log.info("添加新员工：{}", employee);

        return Result.success();
    }

    @PutMapping
    public Result edit(@RequestBody Employee employee) {
        employeeService.edit(employee);
        log.info("修改员工信息：{}", employee);

        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable Integer[] ids) {
        employeeService.deleteByIds(ids);
        log.info("根据ID删除员工，ID数组值为：{}：", Arrays.toString(ids));

        return Result.success();
    }
}
