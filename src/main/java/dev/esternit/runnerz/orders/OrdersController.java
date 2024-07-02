package dev.esternit.runnerz.orders;

import dev.esternit.runnerz.run.Run;
import dev.esternit.runnerz.run.RunJsonDataLoader;
import dev.esternit.runnerz.user.*;
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
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    private CurrentUserService currentUserService;


    /**
     * TODO
     * Set setUserId to user.getId()
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Order order){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        MyUser user = currentUserService.getCurrentUser();
        order.setOrderDate(LocalDateTime.now());
//        order.setCustomerId(user.getId());
        order.setId(UUID.randomUUID());

        List<CartItem> cartItems = cartItemRepository.findAllByUserId(order.getCustomerId());
        for(CartItem cartItem : cartItems){
            OrderedProduct orderedProduct = new OrderedProduct();
            orderedProduct.setOrderId(order.getId());
            orderedProduct.setId(UUID.randomUUID());
            orderedProduct.setProductStatus(ItemStatuses.ORDERED);
            orderedProduct.setProductId(cartItem.getProductId());
            orderedProduct.setProductLocation(cartItem.getProductLocation());
            orderedProductRepository.save(orderedProduct);
            cartItemRepository.delete(cartItem);
        }



        orderRepository.save(order);
    }

    @GetMapping("")
    List<Order> findAll(){
        return orderRepository.findAll();
    }

    @GetMapping("/items")
    List<OrderedProduct> findAllItems(){
        return orderedProductRepository.findAll();
    }

}
