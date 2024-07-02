package dev.esternit.runnerz.user;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private CurrentUserService currentUserService;

    /**
     * TODO
     * Remove setUserId from random to user.getId()
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody CartItem cartItem) {
//        MyUser user = currentUserService.getCurrentUser();
        cartItem.setUserId(UUID.randomUUID());
        cartItem.setId(UUID.randomUUID());
        cartItemRepository.save(cartItem);
    }

    @GetMapping("")
    List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }




}
