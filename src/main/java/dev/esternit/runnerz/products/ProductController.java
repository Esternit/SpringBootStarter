package dev.esternit.runnerz.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductRURepository repository;
    @Autowired
    ImageRepository imageRepository;

    @GetMapping
    List<ProductRU> findAll() {
        return repository.selectProducts();
    }

    @GetMapping("/images")
    List<Image> findAllImages() {
        return imageRepository.findAll();
    }

    @GetMapping("/{slug}")
    List<ProductRU> findBySlug(@PathVariable String slug) {
        return repository.findBySlugProduct(slug);
    }

    @GetMapping("/images/{slug}")
    List<Image> findBySlugImages(@PathVariable String slug) {
        return imageRepository.findBySlugImages(slug);
    }

}
