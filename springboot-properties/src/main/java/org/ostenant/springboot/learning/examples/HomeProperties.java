package org.ostenant.springboot.learning.examples;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Madison on 2017/6/27.
 */
@Component
@ConfigurationProperties(prefix = "home", ignoreNestedProperties = true)
public class HomeProperties implements Serializable {

    private String province;

    private String city;

    private String desc;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "HomeProperties{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
