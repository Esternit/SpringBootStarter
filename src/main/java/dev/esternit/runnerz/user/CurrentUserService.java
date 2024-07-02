package dev.esternit.runnerz.user;

import dev.esternit.runnerz.orders.OrdersController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrentUserService {

    private static final Logger log = LoggerFactory.getLogger(CurrentUserService.class);

    @Autowired
    private MyUserRepository myUserRepository;

    public MyUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return myUserRepository.findByUsername(auth.getName())
                .orElseThrow(() -> {
                    log.info("User not found: " + auth.getName());
                    return new UsernameNotFoundException(auth.getName());
                });
    }


}
