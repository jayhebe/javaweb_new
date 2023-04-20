package cn.mycloudway.dao.impl;

import cn.mycloudway.dao.EmpDao;
import cn.mycloudway.pojo.Emp;
import cn.mycloudway.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        return empList;
    }
}
