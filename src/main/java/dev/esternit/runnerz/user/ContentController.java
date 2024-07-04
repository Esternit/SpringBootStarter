package dev.esternit.runnerz.user;


import dev.esternit.runnerz.orders.OrdersController;
import dev.esternit.runnerz.products.ProductRU;
import dev.esternit.runnerz.products.ProductRURepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Controller
public class ContentController {

    private static final Logger log = LoggerFactory.getLogger(ContentController.class);


    @Autowired
    MyUserRepository MyUserRepository;
    @Autowired
    ProductRURepository productRURepository;

    @GetMapping("/home")
    public String handleWelcome(Model model) {
        List<ProductRU> products = productRURepository.findAll();

        model.addAttribute("products", products);

        return "home";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome() {
        System.out.println("admin home");
        return "home_admin";
    }

    @GetMapping("/product/{slug}")
    public String handleProduct() {
        return "product_detail";
    }

    @GetMapping("/user/home")
    public String handleUserHome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        Optional<MyUser> user = MyUserRepository.findByUsername(auth.getName());

        if(user.isEmpty()) {
            return "redirect:/login";
        }
        else{
            System.out.println(user.get().getUsername());
            model.addAttribute("user", user.get());
        }


        return "home_user";
    }

    @GetMapping("/login")
    public String handleLogin() {
        return "custom_login";
    }

    @GetMapping("/register/user")
    public String handleRegister() {

        return "register";
    }


    @GetMapping("/createOrder")
    public String handleError(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        Optional<MyUser> user = MyUserRepository.findByUsername(auth.getName());

        if(user.isEmpty()) {
            return "redirect:/login";
        }

        log.info("User: " + user.get().getUsername());

        model.addAttribute("user", user.get());

        return "order_creation";
    }

    @GetMapping("/static/scripts/{name}")
    public ResponseEntity<byte[]> getScript(@PathVariable String name) throws IOException {

        Resource resource = new ClassPathResource("static/scripts/"+name);


        Path path = resource.getFile().toPath();
        byte[] scriptContent = Files.readAllBytes(path);


        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/javascript");

        return new ResponseEntity<>(scriptContent, headers, HttpStatus.OK);
    }

    @GetMapping("/static/styles/{name}")
    public ResponseEntity<byte[]> getStyle(@PathVariable String name) throws IOException {

        Resource resource = new ClassPathResource("static/styles/"+name);


        Path path = resource.getFile().toPath();
        byte[] scriptContent = Files.readAllBytes(path);


        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "text/css");

        return new ResponseEntity<>(scriptContent, headers, HttpStatus.OK);
    }

}