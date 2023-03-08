package dev.codefactory.springdataaccess.adapters.sql;

import dev.codefactory.springdataaccess.adapters.sql.orders.OrderItemRow;
import dev.codefactory.springdataaccess.adapters.sql.orders.OrderItemRowRepository;
import dev.codefactory.springdataaccess.adapters.sql.orders.OrderRow;
import dev.codefactory.springdataaccess.adapters.sql.orders.OrderRowRepository;
import dev.codefactory.springdataaccess.config.featureflag.WireIfDatastoreIsSQL;
import dev.codefactory.springdataaccess.core.entities.Order;
import dev.codefactory.springdataaccess.core.ports.OrderDatastore;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@WireIfDatastoreIsSQL
public class SQLOrderDatastore implements OrderDatastore {

    private final OrderRowRepository orderRowRepository;
    private final OrderItemRowRepository orderItemRowRepository;
    @Override
    public Order create(Order order) {
        OrderRow orderTable = OrderRow.from(order);
        var createdOrder = orderRowRepository.save(orderTable);

        if (order.getItems()!=null && !order.getItems().isEmpty()) {
            List<OrderItemRow> items = order.getItems().stream()
                    .map(OrderItemRow::from)
                    .map(it-> it.withOrderId(orderTable.getOrderId()))
                    .toList();

            orderItemRowRepository.saveAll(items);
        }

        return createdOrder.toModel();
    }

    @Override
    public Order update(Order order) {
        OrderRow asRow = OrderRow.from(order);
        var updatedRow = orderRowRepository.save(asRow);

        // TODO handle items

        return updatedRow.toModel();
    }

    @Override
    public Order findById(UUID id) {
        return orderRowRepository.findById(id)
                .orElseThrow()
                .toModel();
    }
}
