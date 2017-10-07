package org.ostenant.springboot.learning.examples.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DataSourceConfig {

    @NotBlank
    private String driverClassName;
    @NotBlank
    private String url;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    private Integer maxActive;
    private Boolean poolPreparedStatements;
    private Integer maxPoolPreparedStatementPerConnectionSize;
    private Integer minIdle;
    private Long timeBetweenEvictionRunsMillis;
    private Long minEvictableIdleTimeMillis;
    private String validationQuery;

    private Boolean testWhileIdle;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    @Primary
    public DataSource primaryDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(getUrl());
        druidDataSource.setDriverClassName(getDriverClassName());
        druidDataSource.setUsername(getUsername());
        druidDataSource.setPassword(getPassword());

        druidDataSource.setMaxActive(getMaxActive());
        druidDataSource.setPoolPreparedStatements(getPoolPreparedStatements());

        druidDataSource.setTimeBetweenEvictionRunsMillis(getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinIdle(getMinIdle());
        druidDataSource.setMinEvictableIdleTimeMillis(getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(getValidationQuery());
        druidDataSource.setTestWhileIdle(getTestWhileIdle());
        druidDataSource.setTestOnBorrow(getTestOnBorrow());
        druidDataSource.setTestOnReturn(getTestOnReturn());

        return druidDataSource;
    }

}
