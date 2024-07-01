package dev.esternit.runnerz.orders;

import dev.esternit.runnerz.user.MyUser;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface OrderedProductRepository  extends ListCrudRepository<OrderedProduct, UUID> {
}
