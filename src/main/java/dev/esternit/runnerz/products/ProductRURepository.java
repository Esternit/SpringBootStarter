package dev.esternit.runnerz.products;

import dev.esternit.runnerz.user.MyUser;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRURepository  extends ListCrudRepository<ProductRU, UUID> {


    List<ProductRU> findAllByslug(String slug);

    @Query("SELECT p.slug, p.main_photo, p.name, p.cost_price_in_rubles FROM products_ru p")
    List<ProductRU> selectProducts();

    @Query("SELECT p.slug, p.main_photo, p.name, p.cost_price_in_rubles, p.description FROM products_ru p WHERE p.slug = :slug")
    List<ProductRU> findBySlugProduct(String slug);
    ;// <3>
}
