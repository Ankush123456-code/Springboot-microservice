package com.ankushkunwar.demo.Service;

import com.ankushkunwar.demo.DAO.UserRepository;
import com.ankushkunwar.demo.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UserRepository userRepository;

    //Constructor Injection or dependency injection
    @Autowired
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<com.ankushkunwar.demo.Models.User> getUsers() {
        return userRepository.findAll();

    }
    public Optional<User> getUserById(Long Id){
        return userRepository.findById(Id);
    }

    public User addUser(User user) {
        return userRepository.save(user);

    }

    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(user1 -> {
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
            return userRepository.save(user1);
        }).orElseThrow(() -> new RuntimeException("user Not found"));
    }

    public String DeleteById(Long id) {
        try {
            userRepository.deleteById(id);
            return "deleted user";
        } catch (Exception e) {
            return e.getMessage();
        }

    }


}
