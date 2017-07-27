package org.ostenant.springboot.learning.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ostenant.springboot.learning.examples.mapper.InstituteMapper;
import org.ostenant.springboot.learning.examples.model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private InstituteMapper instituteMapper;

    @Test
    public void contextLoads() {
        List<Institute> list = new ArrayList<>();
        list.add(new Institute().withName("数学学院"));
        list.add(new Institute().withName("物理学院"));
        list.add(new Institute().withName("机械学院"));
        list.add(new Institute().withName("医药学院"));
        instituteMapper.saveBatch(list);
        list.stream()
                .map(Institute::getId)
                .forEach(System.out::println);
    }

}
