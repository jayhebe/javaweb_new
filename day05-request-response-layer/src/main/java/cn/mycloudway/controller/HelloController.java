package cn.mycloudway.controller;

import cn.mycloudway.pojo.Result;
import cn.mycloudway.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Result hello(@RequestParam(name = "name", required = false) String username, Integer age) {
        String message = "Hello " + username + ", your age is " + age;
        return Result.success(message);
    }

    @RequestMapping("/getUser")
    public Result getUser(User user) {
        return Result.success(user);
    }

    @RequestMapping("/getComplexUser")
    public Result getComplexUser(User user) {
        return Result.success(user);
    }

    @RequestMapping("/getHobbies")
    public Result getHobbies(String[] hobby) {
        return Result.success(Arrays.toString(hobby));
    }

    @RequestMapping("/getUserInfo")
    public Result getUserInfo(User user) {
        return Result.success(user);
    }

    @RequestMapping("/getJsonParam")
    public Result getJsonParam(@RequestBody User user) {
        return Result.success(user);
    }

    @RequestMapping("/path/{id}")
    public Result getPathId(@PathVariable Integer id) {
        return Result.success("ID is " + id);
    }
}
