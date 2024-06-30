package dev.esternit.runnerz.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestingControllers {
    @Autowired
    private MyUserRepository userRepository;

    @GetMapping("/findAllUsers")
    public List<MyUser> findAllUsers() {
        System.out.println("finding all users");
        return userRepository.findAll();
    }
}
