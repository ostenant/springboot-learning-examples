package org.ostenant.springboot.learning.examples;

import com.github.pagehelper.PageHelper;
import org.ostenant.springboot.learning.examples.mapper.InstituteMapper;
import org.ostenant.springboot.learning.examples.model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private InstituteMapper instituteMapper;

    @Autowired
    public void setInstituteMapper(InstituteMapper instituteMapper) {
        this.instituteMapper = instituteMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Institute> list = new ArrayList<>();

        list.add(new Institute().withName("建筑学院"));
        list.add(new Institute().withName("数学学院"));
        list.add(new Institute().withName("机械学院"));
        list.add(new Institute().withName("金融学院"));
        instituteMapper.saveBatch(list);
        list.stream()
                .map(Institute::getId)
                .forEach(System.out::println);

        PageHelper.startPage(1, 10);
        instituteMapper.findAll().stream().forEach(System.out::println);

    }
}
