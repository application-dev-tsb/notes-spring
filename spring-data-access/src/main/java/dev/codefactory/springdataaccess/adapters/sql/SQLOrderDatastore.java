package dev.codefactory.springdataaccess.adapters.sql;

import dev.codefactory.springdataaccess.adapters.sql.orders.OrderRow;
import dev.codefactory.springdataaccess.adapters.sql.orders.OrderRowRepository;
import dev.codefactory.springdataaccess.adapters.sql.orders.OrderItemRow;
import dev.codefactory.springdataaccess.adapters.sql.orders.OrderItemRowRepository;
import dev.codefactory.springdataaccess.core.entities.Order;
import dev.codefactory.springdataaccess.core.ports.OrderDatastore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SQLOrderDatastore implements OrderDatastore {

    private final OrderRowRepository orderRowRepository;
    private final OrderItemRowRepository orderItemRowRepository;
    @Override
    public Order create(Order order) {
        OrderRow orderTable = OrderRow.from(order);
        var createdOrder = orderRowRepository.save(orderTable);

        List<OrderItemRow> items = order.getItems().stream()
                .map(OrderItemRow::from)
                .map(it-> it.withOrderId(orderTable.getOrderId()))
                .toList();

        orderItemRowRepository.saveAll(items);

        return createdOrder.toModel();
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order findById(String id) {
        return null;
    }
}
