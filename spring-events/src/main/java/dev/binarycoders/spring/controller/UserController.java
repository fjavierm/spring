package dev.binarycoders.spring.controller;

import dev.binarycoders.spring.persistence.model.User;
import dev.binarycoders.spring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestParam("firstname") final String firstname,
                         @RequestParam("lastname") final String lastname) {
        Objects.requireNonNull(firstname);
        Objects.requireNonNull(lastname);

        userService.register(new User().setFirstname(firstname).setLastname(lastname));
    }
}
