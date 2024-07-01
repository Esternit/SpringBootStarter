package dev.esternit.runnerz.orders;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("Ordered_Products")
public class OrderedProduct {

    @Id
    private UUID id;

    private UUID orderId;
    private String productStatus;
    private UUID productIdRU;
    private UUID productIdEU;
    private String trackingNumber;

    @Version
    private Integer version;

    // Getters and Setters
}
