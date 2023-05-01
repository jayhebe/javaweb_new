package cn.mycloudway.controller;

import cn.mycloudway.pojo.Employee;
import cn.mycloudway.pojo.Result;
import cn.mycloudway.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public Result selectByConditionAndPagination(String name, Short gender, String begin, String end, Integer page, Integer pageSize) {
        LocalDate startDate = null;
        LocalDate endDate = null;

        if (begin != null && begin.length() != 0) {
            startDate = LocalDate.parse(begin, DateTimeFormatter.ISO_DATE);
        }

        if (end != null && end.length() != 0) {
            endDate = LocalDate.parse(end, DateTimeFormatter.ISO_DATE);
        }

        int total = employeeService.getCountByCondition(name, gender, startDate, endDate);
        List<Employee> employeeList = employeeService.selectByConditionAndPagination(name, gender, startDate, endDate, page, pageSize);
        log.info("按条件分页查询员工数据");

        Map<String, Object> result = new HashMap<>();
        result.put("total", total);
        result.put("rows", employeeList);

        return Result.success(result);
    }
}
