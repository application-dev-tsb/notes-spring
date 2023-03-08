package dev.codefactory.springdataaccess.adapters.dynamodb;

import dev.codefactory.springdataaccess.config.featureflag.WireIfDatastoreIsDynamoDB;
import dev.codefactory.springdataaccess.core.entities.Order;
import dev.codefactory.springdataaccess.core.ports.OrderDatastore;

import java.util.UUID;

@WireIfDatastoreIsDynamoDB
public class DynamoDBOrderDatastore implements OrderDatastore {
    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order findById(UUID id) {
        return Order.builder().build();
    }
}
