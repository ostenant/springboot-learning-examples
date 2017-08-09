package org.ostenant.springboot.learning.examples.entities;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
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
    public void testCreate() throws Exception {
        // 从会话工厂获取一个session
        Session session = sessionFactory.openSession();
        // 开启一个新的事务
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

        city1.setRegion(region);
        city2.setRegion(region);
        city3.setRegion(region);

        // 提交事务
        transaction.commit();
        session.close();
    }

    @Test
    public void testCreateAutoCommit() throws Exception {
        // 从会话工厂获取一个session
        Session session = sessionFactory.openSession();

        City city = new City();
        city.setCityName("成都");

        session.save(city);

        // 刷新缓存里的数据到数据库中
        session.flush();
        session.close();
    }

    @Test
    public void testGet() throws Exception {
        // 从会话工厂获取一个session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Region region = session.get(Region.class, 1L);
        log.warn("Region ==> {}", region);

        City city = session.get(City.class, 1L);
        log.warn("City ==> {}", city);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testLoad() throws Exception {
        // 从会话工厂获取一个session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Region region = session.load(Region.class, 1L);
        log.warn("Region ==> {}", region);

        City city = session.load(City.class, 1L);
        log.warn("City ==> {}", city);
        city.getRegion();

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdate() throws Exception {
        // 从会话工厂获取一个session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        City city = session.load(City.class, 1L);

        Region region = new Region();
        region.setRegionName("西部地区");
        session.save(region);

        city.setRegion(region);
        session.saveOrUpdate(city);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDelete() throws Exception {
        // 从会话工厂获取一个session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        City city = session.load(City.class, 1L);

        session.delete(city);

        session.getTransaction().commit();
        session.close();

    }

}
