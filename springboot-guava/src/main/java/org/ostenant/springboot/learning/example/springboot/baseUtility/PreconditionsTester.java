package org.ostenant.springboot.learning.example.springboot.baseUtility;

import com.google.common.base.Preconditions;
import org.junit.Test;

public class PreconditionsTester {

    @Test
    public void testCheckArgument() throws Exception {
        Customer customer = new Customer("Vodka", 10, false);
        Preconditions.checkArgument(customer.vip);
        Preconditions.checkArgument(customer.vip, "Not VIP!");
        Preconditions.checkArgument(customer.vip, "Customer %s, age %s isn't vip!", customer.name, customer.age);
    }

    @Test
    public void testCheckNotNull() throws Exception {
        Customer customer = new Customer("Vodka", 10, false);
        Preconditions.checkNotNull(customer);
        Preconditions.checkNotNull(customer, "customer is empty!");
        Preconditions.checkNotNull(customer, "Customer %s, age %s isn't vip!", customer.name, customer.age);
    }

    @Test
    public void testCheckState() throws Exception {
        Customer customer = new Customer("Vodka", 10, false);
        Preconditions.checkState(customer.age < 10);
        Preconditions.checkNotNull(customer.age < 10, "Age < 10!");
        Preconditions.checkNotNull(customer.age < 10, "Customer %s, age < 10!", customer.name);
    }

    class Customer {
        String name;
        int age;
        boolean vip;


        Customer(String name, Integer age, Boolean vip) {
            this.name = name;
            this.age = age;
            this.vip = vip;
        }
    }

    class Address {
    }
}
