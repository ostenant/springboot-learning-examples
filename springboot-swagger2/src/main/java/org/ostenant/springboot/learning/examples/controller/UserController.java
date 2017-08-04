package org.ostenant.springboot.learning.examples.controller;

import io.swagger.annotations.*;
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
@Api(value = "UserController", description = "用户操作API接口", protocols = "HTTP 1.1")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "查询所有的用户",
            httpMethod = "GET",
            response = ResponseEntity.class,
            notes = "无请求参数"
    )
    @ApiResponse(code = 200, message = "Success")
    public ResponseEntity<?> findAll() throws Exception {
        return userService.findAll()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Empty list []"));
    }

    @GetMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "根据ID查询指定用户",
            httpMethod = "GET",
            response = ResponseEntity.class,
            notes = "传入用户ID"
    )
    @ApiResponse(code = 200, message = "Success")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", dataType = "Long", paramType = "query", required = true)
    )
    public ResponseEntity<?> findById(@PathVariable("id") Long id) throws Exception {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Empty list []"));
    }

    @PostMapping("/api/user")
    @ApiOperation(value = "保存新增用户",
            httpMethod = "POST",
            response = ResponseEntity.class,
            notes = "{" +
                    "   \"username\": \"用户名\"," +
                    "   \"accountName\": \"账户名\"" +
                    "}"
    )
    @ApiResponse(code = 201, message = "Created")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "user", dataType = "User", paramType = "body", required = true)
    )
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
    @ApiOperation(value = "修改已有用户",
            httpMethod = "POST",
            response = ResponseEntity.class,
            notes = "{" +
                    "   \"username\": \"用户名\"," +
                    "   \"accountName\": \"账户名\"" +
                    "}"
    )
    @ApiResponse(code = 204, message = "No Content")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "Long", paramType = "query", required = true),
            @ApiImplicitParam(name = "user", dataType = "User", paramType = "body", required = true)
    })
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
        final Long affectRows = userService.update(id, user);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Affected rows: " + affectRows);
    }

    @DeleteMapping("/api/users/{id}")
    @ApiOperation(value = "根据ID删除用户",
            httpMethod = "DELETE",
            response = ResponseEntity.class,
            notes = "传入用户ID"
    )
    @ApiResponse(code = 200, message = "Success")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", dataType = "Long", paramType = "query", required = true)
    )
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        final Long affectRows = userService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Affected rows: " + affectRows);
    }

    @DeleteMapping("/api/users")
    @ApiOperation(value = "根据ID批量删除用户",
            httpMethod = "DELETE",
            response = ResponseEntity.class,
            notes = "传入带ID的用户集合"
    )
    @ApiResponse(code = 200, message = "Success")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "users", dataType = "Collection<User>", paramType = "body", required = true)
    )
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
