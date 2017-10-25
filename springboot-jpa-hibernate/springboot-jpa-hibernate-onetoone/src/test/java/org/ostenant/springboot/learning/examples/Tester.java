package org.ostenant.springboot.learning.examples;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ostenant.springboot.learning.examples.entities.Phone;
import org.ostenant.springboot.learning.examples.entities.PhoneDetails;
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

        Phone phone = new Phone("123-456-7890");
        session.save(phone);

        PhoneDetails phoneDetails = new PhoneDetails("移动", "4G");
        session.save(phoneDetails);

        // MappedBy设置为phoneDetails, 表明PhoneDetails为被维护的一方, Phone为主表。
        phone.setPhoneDetails(phoneDetails);

        session.getTransaction().commit();
        session.close();
    }

    @After
    public void destroy() throws Exception {
        sessionFactory.close();
    }

}
