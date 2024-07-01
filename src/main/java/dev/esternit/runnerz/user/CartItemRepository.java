package dev.esternit.runnerz.user;

import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface CartItemRepository  extends ListCrudRepository<CartItem, UUID> {
}
