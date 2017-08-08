package org.ostenant.springboot.learning.examples.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {

    @Test
    public void testSave() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-datasource.xml");
        SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
        //从会话工厂获取一个session
        Session session = sessionFactory.openSession();
        //开启一个新的事务
        Transaction transaction = session.beginTransaction();

        City city1 = new City();
        city1.setCityName("重庆");

        City city2 = new City();
        city2.setCityName("云南");

        City city3 = new City();
        city3.setCityName("贵州");

        // Region设置了CascadeType为CascadeType.ALL或CascadeType.SAVE可注释以下内容
        session.save(city1);
        session.save(city2);
        session.save(city3);

        Region region = new Region();
        region.setRegionName("西南地区");
        region.getCities().add(city1);
        region.getCities().add(city2);
        region.getCities().add(city3);

        session.save(region);


        //提交事务
        transaction.commit();
    }

}
