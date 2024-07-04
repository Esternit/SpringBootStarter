package dev.esternit.runnerz.products;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("products_ru")
public class ProductRU {

    @Id
    private UUID id;

    private String sourceUrl;
    private String name;
    private String productType;
    private String size;
    private String color;
    private Double weight;
    private Double purchasePrice;
    private Double tax;
    private Double deliveryPriceNP;
    private Double deliveryPriceRB;
    private Double deliveryPriceRU;
    private Double packaging1;
    private Double packaging2;
    private Double additionalExpense;
    private Double costPrice;
    private Double costPriceInRubles;
    private Double sellingPriceInRubles;
    private Double netProfit;
    private String slug;
    private String mainPhoto;

    @Version
    private Integer version;

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getDeliveryPriceNP() {
        return deliveryPriceNP;
    }

    public void setDeliveryPriceNP(Double deliveryPriceNP) {
        this.deliveryPriceNP = deliveryPriceNP;
    }

    public Double getDeliveryPriceRB() {
        return deliveryPriceRB;
    }

    public void setDeliveryPriceRB(Double deliveryPriceRB) {
        this.deliveryPriceRB = deliveryPriceRB;
    }

    public Double getDeliveryPriceRU() {
        return deliveryPriceRU;
    }

    public void setDeliveryPriceRU(Double deliveryPriceRU) {
        this.deliveryPriceRU = deliveryPriceRU;
    }

    public Double getPackaging1() {
        return packaging1;
    }

    public void setPackaging1(Double packaging1) {
        this.packaging1 = packaging1;
    }

    public Double getPackaging2() {
        return packaging2;
    }

    public void setPackaging2(Double packaging2) {
        this.packaging2 = packaging2;
    }

    public Double getAdditionalExpense() {
        return additionalExpense;
    }

    public void setAdditionalExpense(Double additionalExpense) {
        this.additionalExpense = additionalExpense;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getCostPriceInRubles() {
        return costPriceInRubles;
    }

    public String getSlug() {
        return slug;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }


}
