package dev.codefactory.springdataaccess.core.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderItem {
    UUID id;
    Integer sortPosition;
    String description;
    Integer quantity;
    BigDecimal unitPrice;
    BigDecimal amount;
}
