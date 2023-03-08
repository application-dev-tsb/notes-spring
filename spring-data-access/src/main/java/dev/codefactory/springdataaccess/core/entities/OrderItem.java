package dev.codefactory.springdataaccess.core.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    String id;
    Integer sortPosition;
    String description;
    Integer quantity;
    BigDecimal unitPrice;
    BigDecimal amount;
}
