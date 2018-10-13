package com.wang.yml;

import com.wang.yml.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootConfigYmlApplicationTests {
    @Autowired
    Person person;
    /*1.测试Person类是否封装了application.yml配置的属性值*/
    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
