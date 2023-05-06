package cn.mycloudway;

import cn.mycloudway.controller.DepartmentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class SpringbootTheoryTests {
    @Autowired
    private ApplicationContext applicationContext;
    @Test
    public void testGetBean() {
        DepartmentController bean1 = (DepartmentController) applicationContext.getBean("departmentController");
        System.out.println(bean1);

        DepartmentController bean2 = applicationContext.getBean(DepartmentController.class);
        System.out.println(bean2);

        DepartmentController bean3 = applicationContext.getBean("departmentController", DepartmentController.class);
        System.out.println(bean3);
    }
    
    @Test
    public void testScope() {
        for (int i = 0; i < 10; i++) {
            DepartmentController bean = applicationContext.getBean(DepartmentController.class);
            System.out.println(bean);
        }
    }
}
