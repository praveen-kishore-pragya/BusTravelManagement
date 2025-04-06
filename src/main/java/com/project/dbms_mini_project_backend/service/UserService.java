package com.project.dbms_mini_project_backend.service;

import com.project.dbms_mini_project_backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dbms_mini_project_backend.repository.UserRepository;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User register(User user) {
        user.setRole("USER");
        return userRepo.save(user);
    }

    public User loginUser(String email, String password) {
        Optional<User> user = userRepo.findByEmail(email);
        if (user != null && user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null;
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }
}
