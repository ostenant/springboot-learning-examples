package org.ostenant.springboot.learning.examples.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Madison on 2017/6/25.
 */
public interface BasicDaoSupport<E, I extends Serializable> {

    int deleteById(I id);

    int save(E record);

    List<E> findAll();

    E findById(I id);

    int update(E record);
}
