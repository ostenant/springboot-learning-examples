package org.ostenant.springboot.learning.examples.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Madison on 2017/6/24.
 */
@Configuration
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    // Master Mapper接口的的基础包
    protected static final String PACKAGE = "org.ostenant.springboot.learning.examples.mapper.master";
    // Master Mapper.xml配置文件的路径
    protected static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";
    // Master Model所在包
    protected static final String TYPE_ALIAS_PACKAGE = "org.ostenant.springboot.learning.examples.model.master";

    @Value("${master.datasource.url}")
    private String url;

    @Value("${master.datasource.username}")
    private String username;

    @Value("${master.datasource.password}")
    private String password;

    @Value("${master.datasource.driverClassName}")
    private String driverClassName;

    @Bean(name = "masterDataSource")
    @Primary
    public DruidDataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sessionFactoryBean.setDataSource(masterDataSource);
        // 设置Model别名所在包路径
        sessionFactoryBean.setTypeAliasesPackage(MasterDataSourceConfig.TYPE_ALIAS_PACKAGE);
        // 设置Mapper.xml所在包路径
        sessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources(MasterDataSourceConfig.MAPPER_LOCATION)
        );

        return sessionFactoryBean.getObject();
    }

}
