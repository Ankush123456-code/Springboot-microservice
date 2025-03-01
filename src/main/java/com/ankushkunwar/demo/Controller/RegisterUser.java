package com.ankushkunwar.demo.Controller;

import com.ankushkunwar.demo.Models.User;
import com.ankushkunwar.demo.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/RegisterUser")
public class RegisterUser {
    UsersService usersService;

    @Autowired
    public RegisterUser(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping
    public List<User> fetchAll() {
        return usersService.getUsers();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getUserById(@PathVariable Long Id) {
        Optional<User> user = usersService.getUserById(Id);
        if (user.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return usersService.addUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            var user1 = usersService.updateUser(id, user);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteById(@PathVariable Long Id) {
        return ResponseEntity.ok(usersService.DeleteById(Id));
    }
}
