package org.ostenant.springboot.learning.examples;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ostenant.springboot.learning.examples.entities.Address;
import org.ostenant.springboot.learning.examples.entities.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Slf4j
public class Tester {

    private SessionFactory sessionFactory;

    @Before
    public void setup() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-datasource.xml");
        sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
    }

    @Test
    public void test() throws Exception {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Person person1 = new Person("Abel");
        Person person2 = new Person("Babel");
        Person person3 = new Person("Carol");

        session.save(person1);
        session.save(person2);
        session.save(person3);

        Address address1 = new Address("陕西路", "720");
        Address address2 = new Address("蜀西街", "122");
        Address address3 = new Address("双林街", "88");
        Address address4 = new Address("草堂路", "120");

        session.save(address1);
        session.save(address2);
        session.save(address3);
        session.save(address4);

        session.flush();

        person1.setAddresses(Arrays.asList(address1, address2));
        person2.setAddresses(Arrays.asList(address3, address4));
        person3.setAddresses(Arrays.asList(address1, address2, address3, address4));

        session.getTransaction().commit();
        session.close();
    }

    @After
    public void destroy() throws Exception {
        sessionFactory.close();
    }

}
