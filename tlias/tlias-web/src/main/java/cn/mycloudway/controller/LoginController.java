package cn.mycloudway.controller;

import cn.mycloudway.pojo.Employee;
import cn.mycloudway.pojo.Result;
import cn.mycloudway.service.EmployeeService;
import cn.mycloudway.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@RequestBody Employee employee) {
        log.info("用户登录验证：{}", employee);

        Employee loginEmployee = employeeService.login(employee);

        if (loginEmployee != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginEmployee.getId());
            claims.put("name", loginEmployee.getName());
            claims.put("username", loginEmployee.getUsername());

            String jwtToken = jwtUtils.getJWT(claims);

            return Result.success(jwtToken);
        } else {
            return Result.error("NOT_LOGIN");
        }
    }
}
