package org.ostenant.springboot.learning.examples.controller;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Madison on 2017/6/26.
 */
public interface BasicController<E, I extends Serializable> {

    public int deleteById(I id);

    public int save(E entity);

    public List<E> findAll();

    public E findById(I id);

    public int update(E record);
}
