package dev.codefactory.springdataaccess.core.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.SortedSet;

@Data
public class Order {
    String id;
    String description;
    BigDecimal total;
    SortedSet<OrderItem> items;
}
