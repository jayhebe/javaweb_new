package cn.mycloudway.controller;

import cn.mycloudway.pojo.Emp;
import cn.mycloudway.pojo.Result;
import cn.mycloudway.service.EmpService;
import cn.mycloudway.service.impl.EmpServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    private EmpService empService = new EmpServiceImpl();
    @RequestMapping("/listEmp")
    public Result list() {
        List<Emp> empList = empService.listEmp();
        return Result.success(empList);
    }
}
