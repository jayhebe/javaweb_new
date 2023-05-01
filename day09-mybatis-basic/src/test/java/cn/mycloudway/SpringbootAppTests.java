package cn.mycloudway;

import cn.mycloudway.mapper.EmpMapper;
import cn.mycloudway.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class SpringbootAppTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(15);
        System.out.println(emp);
    }

    @Test
    public void testGetByCondition() {
        String name = "张";
        Short gender = (short) 1;
        LocalDate startDate = LocalDate.of(2010, 1, 1);
        LocalDate endDate = LocalDate.of(2020, 1, 1);

        List<Emp> empList = empMapper.getByCondition(name, gender, startDate, endDate);
        System.out.println(empList);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("zhaoliu");
        emp.setName("赵六");
        emp.setGender((short) 1);
        emp.setImage("101.jpg");
        emp.setJob((short) 1);
        emp.setEntryDate(LocalDate.of(2016, 12, 31));
        emp.setDeptId(1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("lisiaaaaaa");
        emp.setName("李四");
        emp.setGender((short) 1);
        emp.setImage("99.jpg");
        emp.setJob((short) 1);
        emp.setEntryDate(LocalDate.of(2016, 12, 31));
        emp.setDeptId(1);
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);
    }

    @Test
    public void testUpdate2() {
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("Lisa");
        emp.setName("李萨222");
        emp.setGender((short) 1);
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);
    }

    @Test
    public void testDelete() {
        empMapper.delete(16);
    }

    @Test
    public void testDeleteByIds() {
        List<Integer> ids = new ArrayList<>();
        Collections.addAll(ids, 15);

        empMapper.deleteByIds(ids);
    }
}
