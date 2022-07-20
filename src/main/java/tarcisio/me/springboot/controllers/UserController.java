package tarcisio.me.springboot.controllers;

// import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tarcisio.me.springboot.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

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
        return user;
    }


}
