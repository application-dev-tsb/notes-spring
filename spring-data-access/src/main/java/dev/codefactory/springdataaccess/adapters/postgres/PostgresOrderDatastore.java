package dev.codefactory.springdataaccess.adapters.postgres;

import dev.codefactory.springdataaccess.adapters.postgres.orders.OrderEntity;
import dev.codefactory.springdataaccess.adapters.postgres.orders.OrderEntityRepository;
import dev.codefactory.springdataaccess.adapters.postgres.orders.OrderItemEntity;
import dev.codefactory.springdataaccess.adapters.postgres.orders.OrderItemEntityRepository;
import dev.codefactory.springdataaccess.core.entities.Order;
import dev.codefactory.springdataaccess.core.ports.OrderDatastore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PostgresOrderDatastore implements OrderDatastore {

    private final OrderEntityRepository orderEntityRepository;
    private final OrderItemEntityRepository orderItemEntityRepository;
    @Override
    public Order create(Order order) {
        OrderEntity orderEntity = OrderEntity.from(order);
        var createdOrder = orderEntityRepository.save(orderEntity);

        List<OrderItemEntity> items = order.getItems().stream()
                .map(OrderItemEntity::from)
                .map(it-> it.withOrderId(orderEntity.getOrderId()))
                .collect(Collectors.toList());

        orderItemEntityRepository.saveAll(items);

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
