package dev.esternit.runnerz.products;

import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface ImageRepository extends ListCrudRepository<Image, UUID> {
}
