package dev.esternit.runnerz.products;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.esternit.runnerz.run.JdbcClientRunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@Component
public class ProductJsonDataLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(ProductJsonDataLoader.class);
    private final ObjectMapper objectMapper;
    @Autowired
    ProductRURepository productRURepository;

    @Autowired
    ImageRepository imageRepository;

    public ProductJsonDataLoader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override
    public void run(String... args) throws Exception {
        if(productRURepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/ready_data.json")) {
                ProductsRU allProducts = objectMapper.readValue(inputStream, ProductsRU.class);
                log.info("Reading {} products from JSON data and saving to a database.", allProducts.products().size());
                for(ProductRU productRU : allProducts.products()) {
                    productRU.setId(UUID.randomUUID());
                }
                productRURepository.saveAll(allProducts.products());

                if(imageRepository.count() == 0) {
                    try (InputStream inputStreamImage = TypeReference.class.getResourceAsStream("/data/photos.json")) {
                        ImagesRecord images = objectMapper.readValue(inputStreamImage, ImagesRecord.class);
                        log.info("Reading {} images from JSON data and saving to a database.", images.images().size());

                        for(Image image : images.images()) {
                            image.setId(UUID.randomUUID());
                            image.setProductId(productRURepository.findAllByslug(image.getSlug()).getFirst().getId());
                        }
                        imageRepository.saveAll(images.images());
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to read JSON data from photos.json", e);
                    }
                } else {
                    log.info("Not loading images from JSON data because the collection contains data.");
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data from data/ready_data.json", e);
            }
        } else {
            log.info("Not loading products from JSON data because the collection contains data.");
        }
    }
}
