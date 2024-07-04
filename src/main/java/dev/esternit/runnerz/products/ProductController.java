package dev.esternit.runnerz.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        return repository.findAll();
    }

    @GetMapping("/images")
    List<Image> findBySlug() {
        return imageRepository.findAll();
    }

}
