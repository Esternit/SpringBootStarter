package dev.esternit.runnerz.products;

import dev.esternit.runnerz.user.MyUser;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface ProductEURepository  extends ListCrudRepository<ProductEU, UUID> {
}
