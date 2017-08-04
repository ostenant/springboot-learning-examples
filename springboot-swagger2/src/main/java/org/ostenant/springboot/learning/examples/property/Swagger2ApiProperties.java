package org.ostenant.springboot.learning.examples.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@Component
@PropertySource(value = "classpath:/swagger2.properties", encoding = "UTF-8")
@Data
public class Swagger2ApiProperties {
    /**
     * 允许Swagger扫描的基础包
     */
    @Value("${swagger2.metadata.base-package}")
    private String basePackage;

    /**
     * Api开发维护人员
     */
    @Value("${swagger2.metadata.author}")
    private String author;

    /**
     * Api的测试url
     */
    @Value("${swagger2.metadata.url}")
    private String url;

    /**
     * Api开发维护人员的邮箱
     */
    @Value("${swagger2.metadata.email}")
    private String email;

    /**
     * 项目的名称
     */
    @Value("${swagger2.metadata.title}")
    private String title;

    /**
     * 项目的具体描述信息
     */
    @Value("${swagger2.metadata.description}")
    private String description;

    /**
     * 项目的版本信息
     */
    @Value("${swagger2.metadata.version}")
    private String version;

}

