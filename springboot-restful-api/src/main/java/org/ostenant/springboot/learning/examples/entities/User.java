package org.ostenant.springboot.learning.examples.entities;

import java.io.Serializable;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}