package dev.codefactory.springdataaccess.api;

import dev.codefactory.springdataaccess.core.entities.Order;
import dev.codefactory.springdataaccess.core.ports.OrderDatastore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * we dont want to overcomplicate things since this is not a clean architecture code
 */
@RequiredArgsConstructor
@RestController("/orders")
public class OrderAPI {

    private final OrderDatastore orderDatastore;

    @PostMapping
    public Order createOrder(Order order) {
        return orderDatastore.create(order);
    }
}
