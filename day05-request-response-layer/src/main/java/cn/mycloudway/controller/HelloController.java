package cn.mycloudway.controller;

import cn.mycloudway.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
public class HelloController {
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
        String name = request.getParameter("name");

        return "Hello, " + name;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false) String username, Integer age) {
        return "Hello " + username + ", your age is " + age;
    }

    @RequestMapping("/getUser")
    public User getUser(User user) {
        return user;
    }

    @RequestMapping("/getComplexUser")
    public User getComplexUser(User user) {
        return user;
    }

    @RequestMapping("/getHobbies")
    public String getHobbies(String[] hobby) {
        return Arrays.toString(hobby);
    }

    @RequestMapping("/getUserInfo")
    public User getUserInfo(User user) {
        return user;
    }
}
