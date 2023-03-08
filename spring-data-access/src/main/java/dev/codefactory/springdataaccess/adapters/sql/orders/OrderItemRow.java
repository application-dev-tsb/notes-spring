package dev.codefactory.springdataaccess.adapters.sql.orders;

import dev.codefactory.springdataaccess.core.entities.OrderItem;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@Table("order_item")
public class OrderItemRow {

    @Id
    private UUID orderItemId;

    @Column("order_id")
    private UUID orderId;

    Integer sortPosition;
    String description;
    Integer quantity;
    BigDecimal unitPrice;
    BigDecimal amount;

    public static OrderItemRow from(OrderItem orderItem) {
        return OrderItemRow.builder()
                .sortPosition(orderItem.getSortPosition())
                .description(orderItem.getDescription())
                .quantity(orderItem.getQuantity())
                .unitPrice(orderItem.getUnitPrice())
                .amount(orderItem.getAmount())
                .build();
    }
}
