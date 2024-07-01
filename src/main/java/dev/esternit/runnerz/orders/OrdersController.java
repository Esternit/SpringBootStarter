package dev.esternit.runnerz.orders;

import dev.esternit.runnerz.run.Run;
import dev.esternit.runnerz.run.RunJsonDataLoader;
import dev.esternit.runnerz.user.MyUser;
import dev.esternit.runnerz.user.MyUserRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private static final Logger log = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderedProductRepository orderedProductRepository;
    @Autowired
    MyUserRepository myUserRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Order order){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        Optional<MyUser> user = myUserRepository.findByUsername(auth.getName());
        if(user.isEmpty()){
            log.info("User not found: " + auth.getName());
            throw new UsernameNotFoundException(auth.getName());
        }
        log.info("User: " + user.get().getId() + " " + user.get().getUsername());
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerId(user.get().getId());
        order.setId(UUID.randomUUID());
        orderRepository.save(order);
    }

    @GetMapping("")
    List<Order> findAll(){
        return orderRepository.findAll();
    }

}
