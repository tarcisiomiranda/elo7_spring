package tarcisio.me.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tarcisio.me.springboot.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    // GET
    @GetMapping("/")
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("Tarcisio");
        user.setUsername("tm");

        return user;
    }

    @PostMapping("/") 
    public User user(@RequestBody User user) {
        users.add(user);
        return user;
    }


}
