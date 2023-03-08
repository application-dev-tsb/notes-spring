package dev.codefactory.springdataaccess.core.entities;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

@Data
@Builder
public class Order {
    UUID id;
    String description;
    BigDecimal total;

    @Builder.Default
    SortedSet<OrderItem> items = new TreeSet<>(Comparator.comparing(OrderItem::getSortPosition));
}
