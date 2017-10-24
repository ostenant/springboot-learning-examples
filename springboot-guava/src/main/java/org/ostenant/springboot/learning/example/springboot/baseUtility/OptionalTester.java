package org.ostenant.springboot.learning.example.springboot.baseUtility;

import com.google.common.base.Optional;
import org.junit.Assert;
import org.junit.Test;

public class OptionalTester {

    @Test
    public void testOf() throws Exception {
        Optional<Integer> possible = Optional.of(5);
        Assert.assertTrue(possible.isPresent());
        Assert.assertEquals(possible.get(), Integer.valueOf(5));
    }

    @Test
    public void testAbsent() throws Exception {
        Optional<Integer> possible = Optional.absent();
        Assert.assertFalse(possible.isPresent());
        Assert.assertEquals(possible.orNull(), null);
    }


    @Test
    public void testFromNullable() throws Exception {
        Optional<Integer> possible = Optional.fromNullable(5);
        Assert.assertTrue(possible.isPresent());
        Assert.assertEquals(possible.get(), Integer.valueOf(5));


        possible = Optional.fromNullable(null);
        Assert.assertFalse(possible.isPresent());
        // Optional.fromNullable(null).get()直接抛出异常
        Assert.assertEquals(possible.orNull(), null);
    }

    @Test
    public void testAsSet() throws Exception {
        Optional<Integer> possible = Optional.fromNullable(5);
        Assert.assertTrue(possible.isPresent());
        Assert.assertEquals(possible.asSet().size(), 1);
        Assert.assertEquals(possible.asSet().toArray(new Integer[1])[0], Integer.valueOf(5));
    }


}
