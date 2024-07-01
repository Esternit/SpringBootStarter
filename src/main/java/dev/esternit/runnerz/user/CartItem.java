package dev.esternit.runnerz.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("CartItem")
public class CartItem {

    @Id
    private UUID id;

    private UUID productId;

    @Version
    private Integer version;

    // Getters and Setters
}
