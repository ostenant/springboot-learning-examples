package org.ostenant.springboot.learning.examples.page.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Madison on 2017/6/24.
 */
@Configuration
@MapperScan(basePackages = SlaverDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "slaverSqlSessionFactory")
public class SlaverDataSourceConfig {

    // Slaver Mapper接口的的基础包
    protected static final String PACKAGE = "org.ostenant.springboot.learning.examples.mapper.slaver";
    // Slaver Mapper.xml配置文件的路径
    protected static final String MAPPER_LOCATION = "classpath:mapper/slaver/*.xml";
    // Slaver Model所在包
    protected static final String TYPE_ALIAS_PACKAGE = "org.ostenant.springboot.learning.examples.model.slaver";

    @Value("${slaver.datasource.url}")
    private String url;

    @Value("${slaver.datasource.username}")
    private String username;

    @Value("${slaver.datasource.password}")
    private String password;

    @Value("${slaver.datasource.driverClassName}")
    private String driverClassName;

    @Bean(name = "slaverDataSource")
    public DruidDataSource slaverDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "slaverTransactionManager")
    public DataSourceTransactionManager slaverTransactionManager(@Qualifier("slaverDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "slaverSqlSessionFactory")
    public SqlSessionFactory slaverSqlSessionFactory(@Qualifier("slaverDataSource") DataSource masterDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sessionFactoryBean.setDataSource(masterDataSource);
        // 设置Model别名所在包路径
        sessionFactoryBean.setTypeAliasesPackage(SlaverDataSourceConfig.TYPE_ALIAS_PACKAGE);
        // 设置Mapper.xml所在包路径
        sessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources(SlaverDataSourceConfig.MAPPER_LOCATION)
        );

        return sessionFactoryBean.getObject();
    }

}
