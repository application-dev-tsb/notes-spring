package dev.codefactory.springdataaccess.core.ports;

import dev.codefactory.springdataaccess.core.entities.Order;

public interface OrderDatastore {

    Order create(Order order);
    Order update(Order order);
    Order findById(String id);
}
