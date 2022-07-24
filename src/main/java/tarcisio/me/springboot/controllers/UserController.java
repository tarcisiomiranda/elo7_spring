package tarcisio.me.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tarcisio.me.springboot.model.User;
import tarcisio.me.springboot.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    // GET
    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {
        System.out.println("Meuid: " + id);
        // Não existe mais a instacia user
        // User user = new User();
        // user.setId(1L);
        // user.setName("Tarcisio");
        // user.setUsername("tm");

        // Usando apenas as classes
        // Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();
        Optional<User> userFind = this.userRepository.findById(id);

        if(userFind.isPresent()) {
            return userFind.get();
        }

        return null;
    }

    @PostMapping("/") 
    public User user(@RequestBody User user) {
        this.userRepository.save(user);
        // users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> list() {
        users = this.userRepository.findAll();
        return users;
    }

    // {} é para receber como parametro e PathVariable
    @GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id) {
        return this.userRepository.findByIdGreaterThan(id);
    }

    @GetMapping("/findByName/{name}")
    public List<User> findByName(@PathVariable("name") String name) {
        return this.userRepository.findByNameIgnoreCase(name);
    }

}
