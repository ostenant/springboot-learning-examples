package org.ostenant.springboot.learning.examples;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ostenant.springboot.learning.examples.entities.Person;
import org.ostenant.springboot.learning.examples.entities.Phone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        Person person = new Person("Abel");
        session.save(person);

        Phone phone1 = new Phone("123-456-7890");
        Phone phone2 = new Phone("321-654-0987");

        person.getPhones().add(phone1);
        person.getPhones().add(phone2);

        phone1.setPerson(person);
        phone2.setPerson(person);

        session.getTransaction().commit();
        session.close();
    }

    @After
    public void destroy() throws Exception {
        sessionFactory.close();
    }

}
