package org.ostenant.springboot.learning.examples;

import com.github.pagehelper.PageHelper;
import org.ostenant.springboot.learning.examples.mapper.StudentMapper;
import org.ostenant.springboot.learning.examples.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PageHelper.startPage(0, 5);
        List<Student> students = studentMapper.findAll();
        students.forEach(System.out::println);
    }

}
