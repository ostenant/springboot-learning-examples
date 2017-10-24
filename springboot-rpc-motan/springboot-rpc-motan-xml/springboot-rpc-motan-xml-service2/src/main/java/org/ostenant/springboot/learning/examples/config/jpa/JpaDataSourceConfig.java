package org.ostenant.springboot.learning.examples.config.jpa;

import org.ostenant.springboot.learning.examples.config.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@Import({DataSourceConfig.class})
@EnableJpaRepositories(
        // 设置Repository所在位置
        basePackages = {JpaDataSourceConfig.REPOSITORY_PACKAGE})
public class JpaDataSourceConfig {

    /**
     * 实体类所在包
     */
    private final static String ENTITY_PACKAGE = "org.ostenant.springboot.learning.examples.model";
    /**
     * 数据访问层类所在包
     */
    final static String REPOSITORY_PACKAGE = "org.ostenant.springboot.learning.examples.repository";
    /**
     * 持久化单元
     */
    private final static String PERSISTENCE_UNIT = "persistenceUnit";

    private final DataSource dataSource;
    private final JpaProperties jpaProperties;

    @Autowired
    public JpaDataSourceConfig(
            JpaProperties jpaProperties,
            @Qualifier("dataSource") DataSource dataSource) {
        this.jpaProperties = jpaProperties;
        this.dataSource = dataSource;
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource)
                // 数据源相关配置信息
                .properties(getDataSourceProperties(dataSource))
                // 设置实体类所在位置
                .packages(ENTITY_PACKAGE)
                .persistenceUnit(PERSISTENCE_UNIT)
                .build();
    }

    @Primary
    @Bean(name = "entityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactory(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        EntityManagerFactory entityManagerFactory = entityManagerFactory(builder).getObject();
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Map<String, String> getDataSourceProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

}
