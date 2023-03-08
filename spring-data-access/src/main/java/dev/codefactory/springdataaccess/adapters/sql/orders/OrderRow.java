package dev.codefactory.springdataaccess.adapters.sql.orders;

import dev.codefactory.springdataaccess.core.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("order")
public class OrderRow {

    @Id
    private UUID orderId;

    String description;
    BigDecimal total;

    public static OrderRow from(Order order) {
        return OrderRow.builder()
                .orderId(order.getId())
                .total(order.getTotal())
                .description(order.getDescription())
                .build();
    }

    public Order toModel() {
        return Order.builder()
                .id(orderId)
                .total(total)
                .description(description)
                .build();
    }
}
