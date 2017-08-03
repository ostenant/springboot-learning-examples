package org.ostenant.springboot.learning.examples.controller;

import org.ostenant.springboot.learning.examples.entities.User;
import org.ostenant.springboot.learning.examples.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> findAll() throws Exception {
        return userService.findAll()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Empty list []"));
    }

    @GetMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findById(@PathVariable("id") Long id) throws Exception {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Empty list []"));
    }

    @PostMapping("/api/user")
    public ResponseEntity<?> save(@RequestBody User user) {
        final Long affectRows = userService.save(user);
        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body("Affected rows: " + affectRows);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
        final Long affectRows = userService.update(id, user);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Affected rows: " + affectRows);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        final Long affectRows = userService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Affected rows: " + affectRows);
    }

    @DeleteMapping("/api/users")
    public ResponseEntity<?> deleteBatch(@RequestBody User... users) throws Exception {
        Optional<List<Long>> optional = Optional.ofNullable(
                Arrays.asList(users).stream()
                        .filter(user -> !Objects.isNull(user) && !Objects.isNull(user.getId()))
                        .distinct()
                        .map(User::getId)
                        .collect(Collectors.toList())
        );

        optional.ifPresent(ids -> userService.deleteBatch(ids));
        optional.orElseThrow(() -> new Exception("Empty id list []"));

        return ResponseEntity.ok().build();
    }

}
