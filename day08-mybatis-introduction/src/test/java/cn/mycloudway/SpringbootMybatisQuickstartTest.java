package cn.mycloudway;

import cn.mycloudway.mapper.UserMapper;
import cn.mycloudway.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SpringbootMybatisQuickstartTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testListUser() {
        List<User> userList = userMapper.list();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
