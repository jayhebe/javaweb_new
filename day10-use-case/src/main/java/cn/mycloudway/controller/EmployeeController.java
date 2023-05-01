package cn.mycloudway.controller;

import cn.mycloudway.pojo.Employee;
import cn.mycloudway.pojo.PageBean;
import cn.mycloudway.pojo.Result;
import cn.mycloudway.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public Result selectByConditionAndPagination(String name, Short gender, String begin, String end, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        LocalDate startDate = null;
        LocalDate endDate = null;

        if (begin != null && begin.length() != 0) {
            startDate = LocalDate.parse(begin, DateTimeFormatter.ISO_DATE);
        }

        if (end != null && end.length() != 0) {
            endDate = LocalDate.parse(end, DateTimeFormatter.ISO_DATE);
        }

        PageBean<Employee> employeePageBean = employeeService.selectByConditionAndPagination(name, gender, startDate, endDate, page, pageSize);
        log.info("按条件分页查询员工数据");

        return Result.success(employeePageBean);
    }
}
