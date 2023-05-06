package cn.mycloudway;

import cn.mycloudway.pojo.Result;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AutoConfigurationTest {
    @Autowired
    private Gson gson;
    @Test
    public void testJson() {
        System.out.println(gson.toJson(Result.success()));
    }
}
