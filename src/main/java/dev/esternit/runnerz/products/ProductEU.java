package dev.esternit.runnerz.products;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("Products_EU")
public class ProductEU {

    @Id
    private UUID id;

    private String sourceUrl;
    private String name;
    private String productType;
    private String size;
    private String color;
    private Double weight;
    private Double purchasePrice;
    private Double customerDeliveryPrice;
    private Double packaging;
    private Double additionalExpense1;
    private Double additionalExpense2;
    private Double costPrice;
    private Double sellingPrice;
    private Double netProfit;

    @Version
    private Integer version;

    // Getters and Setters
}