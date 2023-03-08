package dev.codefactory.springdataaccess.api;

import dev.codefactory.springdataaccess.core.entities.Order;
import dev.codefactory.springdataaccess.core.ports.OrderDatastore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * we dont want to overcomplicate things since this is not a clean architecture code
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderAPI {

    private final OrderDatastore orderDatastore;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderDatastore.create(order);
    }

    @GetMapping("/{orderId}")
    public Order findById(@PathVariable("orderId") UUID id) {
        return orderDatastore.findById(id);
    }
}
