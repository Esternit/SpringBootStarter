package dev.esternit.runnerz.products;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface ImageRepository extends ListCrudRepository<Image, UUID> {

    @Query("SELECT i.url FROM images i WHERE i.slug = :slug")
    List<Image> findBySlugImages(String slug);

}
