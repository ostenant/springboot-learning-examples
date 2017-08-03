package org.ostenant.springboot.learning.examples.service.impl;

import org.ostenant.springboot.learning.examples.entities.User;
import org.ostenant.springboot.learning.examples.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> userList = new ArrayList<>();
    private static volatile Long serial = 1L;

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
                Optional.of(result.get(id).stream().findFirst().get()) :
                Optional.empty();
    }

    @Override
    public Long save(User user) {
        user.setId(serial++);
        userList.add(user);
        return 1L;
    }

    @Override
    public Long update(Long id, User user) {
        Objects.requireNonNull(userList);
        Map<Long, Set<User>> result = userList.stream().collect(
                Collectors.groupingBy(User::getId, Collectors.toSet()));

        if (result.containsKey(id)) {
            result.put(id, result.get(id).stream().map(u -> {
                u.setUsername(user.getUsername());
                u.setAccountName(user.getAccountName());
                return u;
            }).collect(Collectors.toSet()));

            List<User> userList = result.values().stream()
                    .flatMap(userSet ->
                            userSet.stream()
                                    .sorted((u1, u2) -> u1.getId() < u2.getId() ? 1 : -1)
                                    .map(u -> Stream.of(u))
                    ).map(userStream -> userStream.collect(Collectors.toList()))
                    .map(list -> list.get(0))
                    .collect(Collectors.toList());
            userList.forEach(System.out::println);
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
            userList = result.values().stream()
                    .flatMap(userSet ->
                            userSet.stream()
                                    .sorted((u1, u2) -> u1.getId() < u2.getId() ? 1 : -1)
                                    .map(u -> Stream.of(u))
                    ).map(userStream -> userStream.collect(Collectors.toList()))
                    .map(list -> list.get(0))
                    .collect(Collectors.toList());
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

        Long count = ids.stream()
                .filter(result::containsKey)
                .map(id -> {
                    result.remove(id);
                    return result;
                }).count();


        if (count > 0L) {
            userList = result.values().stream()
                    .flatMap(userSet ->
                            userSet.stream()
                                    .sorted((u1, u2) -> u1.getId() < u2.getId() ? 1 : -1)
                                    .map(u -> Stream.of(u))
                    ).map(userStream -> userStream.collect(Collectors.toList()))
                    .map(list -> list.get(0))
                    .collect(Collectors.toList());
            userList.forEach(System.out::println);
        }
        return count;
    }

}
