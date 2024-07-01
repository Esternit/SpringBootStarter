package dev.esternit.runnerz.orders;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("orders")
public class Order {

    @Id
    private UUID id;

    private UUID customerId;
    private String address;
    private LocalDateTime orderDate;
    private LocalDateTime receiptDate;
    private LocalDateTime fullPaymentDate;

    @Version
    private Integer version;

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getReceiptDate() {
        return receiptDate;
    }

    public LocalDateTime getFullPaymentDate() {
        return fullPaymentDate;
    }

    public Integer getVersion() {
        return version;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setReceiptDate(LocalDateTime receiptDate) {
        this.receiptDate = receiptDate;
    }

    public void setFullPaymentDate(LocalDateTime fullPaymentDate) {
        this.fullPaymentDate = fullPaymentDate;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
