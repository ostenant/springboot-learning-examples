package org.ostenant.springboot.learning.examples.service.impl;

import org.ostenant.springboot.learning.examples.entities.User;
import org.ostenant.springboot.learning.examples.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> userList = new ArrayList<>();

    @Override
    public Optional<List<User>> findAll() {
        return Optional.ofNullable(userList);
    }

    @Override
    public Optional<User> findById(Long id) {
        Objects.requireNonNull(userList);
        Map<Long, Set<User>> result = userList.stream().collect(
                Collectors.groupingBy(User::getId, Collectors.toSet()));
        return result.containsKey(id) ?
                Optional.ofNullable(result.get(id).stream().findFirst().get()) :
                Optional.empty();
    }

    @Override
    public Long save(User user) {
        userList.add(user);
        return 1L;
    }

    @Override
    public Long update(Long id, User user) {
        Objects.requireNonNull(userList);
        Map<Long, Set<User>> result = userList.stream().collect(
                Collectors.groupingBy(User::getId, Collectors.toSet()));
        if (result.containsKey(id)) {
            result.remove(id);
            userList = Arrays.asList(user);
            userList.addAll(result.values()
                    .stream()
                    .reduce(Collections.EMPTY_SET, (u1Set, u2Set) -> {
                        u1Set.addAll(u2Set);
                        return new HashSet<User>(u1Set);
                    }));
            return 1L;
        } else {
            return 0L;
        }
    }

    @Override
    public Long deleteById(Long id) {
        Objects.requireNonNull(userList);
        Map<Long, Set<User>> result = userList.stream().collect(
                Collectors.groupingBy(User::getId, Collectors.toSet()));
        if (result.containsKey(id)) {
            result.remove(id);
            userList = new ArrayList<User>(result.values()
                    .stream()
                    .reduce(Collections.EMPTY_SET, (u1Set, u2Set) -> {
                        u1Set.addAll(u2Set);
                        return new HashSet<User>(u1Set);
                    }));
            return 1L;
        } else {
            return 0L;
        }
    }

    @Override
    public Long deleteBatch(List<Long> ids) {
        Objects.requireNonNull(userList);
        Map<Long, Set<User>> result = userList.stream().collect(
                Collectors.groupingBy(User::getId, Collectors.toSet()));

        Long count = result.keySet().stream()
                .filter(id -> result.containsKey(id))
                .map(id -> {
                    result.remove(id);
                    return result;
                }).count();


        if (count > 0L) {
            userList = new ArrayList<User>(result.values()
                    .stream()
                    .reduce(Collections.EMPTY_SET, (u1Set, u2Set) -> {
                        u1Set.addAll(u2Set);
                        return new HashSet<User>(u1Set);
                    }));
        }
        return count;
    }

}
