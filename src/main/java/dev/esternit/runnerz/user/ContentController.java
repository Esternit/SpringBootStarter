package dev.esternit.runnerz.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContentController {


    @GetMapping("/home")
    public String handleWelcome() {
        System.out.println("home");
        return "home";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome() {
        System.out.println("admin home");
        return "home_admin";
    }

    @GetMapping("/user/home")
    public String handleUserHome() {
        System.out.println("user home");
        return "home_user";
    }

    @GetMapping("/login")
    public String handleLogin() {
        System.out.println("login");
        return "custom_login";
    }

    @GetMapping("/register/user")
    public String handleRegister() {
        System.out.println("register");
        return "register";
    }


}