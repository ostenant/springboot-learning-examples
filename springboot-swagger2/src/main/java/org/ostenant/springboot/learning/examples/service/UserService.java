package org.ostenant.springboot.learning.examples.service;

import org.ostenant.springboot.learning.examples.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<List<User>> findAll();

    Optional<User> findById(Long id);

    Long save(User user);

    Long update(Long id, User user);

    Long deleteById(Long id);

    Long deleteBatch(List<Long> ids);
}
