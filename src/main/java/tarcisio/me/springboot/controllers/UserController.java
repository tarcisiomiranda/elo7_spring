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
    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {
        System.out.println("Meuid: " + id);
        // Não existe mais a instacia user
        // User user = new User();
        // user.setId(1L);
        // user.setName("Tarcisio");
        // user.setUsername("tm");

        Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();

        if(userFind.isPresent()) {
            return userFind.get();
        }

        return null;
    }

    @PostMapping("/") 
    public User user(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> list() {
        return users;
    }

}
