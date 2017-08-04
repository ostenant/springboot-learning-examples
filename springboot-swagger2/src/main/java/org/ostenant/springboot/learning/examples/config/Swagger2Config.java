package org.ostenant.springboot.learning.examples.config;

import org.ostenant.springboot.learning.examples.property.Swagger2ApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

    @Autowired
    @Qualifier("swagger2ApiProperties")
    private Swagger2ApiProperties swagger2ApiProperties;

    @Bean
    public Docket createRestfulApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swagger2ApiProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                swagger2ApiProperties.getAuthor(),
                swagger2ApiProperties.getUrl(),
                swagger2ApiProperties.getEmail()
        );
        return new ApiInfoBuilder()
                .title(swagger2ApiProperties.getTitle())
                .description(swagger2ApiProperties.getDescription())
                .contact(contact)
                .version(swagger2ApiProperties.getVersion())
                .build();
    }
}
