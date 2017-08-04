package org.ostenant.springboot.learning.examples.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    /**
     * 用户ID
     */

    private Long id;
    /**
     * 登录名
     */
    private String username;

    /**
     * 用户真名
     */
    private String accountName;

}