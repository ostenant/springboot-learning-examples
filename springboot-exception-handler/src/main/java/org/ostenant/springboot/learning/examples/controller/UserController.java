package org.ostenant.springboot.learning.examples.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.ostenant.springboot.learning.examples.entities.User;
import org.ostenant.springboot.learning.examples.exception.IllegalPropException;
import org.ostenant.springboot.learning.examples.exception.NullOrEmptyException;
import org.ostenant.springboot.learning.examples.exception.SessionNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @PostMapping("user")
    public ResponseEntity<?> save(HttpServletRequest request, HttpSession session) throws Exception {
        String loginId = (String) session.getAttribute("loginId");
        if (StringUtils.isBlank(loginId)) {
            throw new SessionNotFoundException();
        }

        String userStr = request.getParameter("user");
        if (StringUtils.isBlank(userStr) || StringUtils.equalsIgnoreCase("{}", userStr)) {
            throw new NullOrEmptyException();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userStr, User.class);

        String username = user.getUsername();
        if (StringUtils.isBlank(username)) {
            throw new IllegalPropException("username");
        }

        String accountName = user.getAccountName();
        if (StringUtils.isBlank(accountName)) {
            throw new IllegalPropException("accountName");
        }

        return ResponseEntity.ok("Successful");

    }
}
