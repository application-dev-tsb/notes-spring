package dev.codefactory.springdataaccess.adapters.dynamodb;

import dev.codefactory.springdataaccess.config.featureflag.WireIfDatastoreIsDynamoDB;
import dev.codefactory.springdataaccess.core.entities.Order;
import dev.codefactory.springdataaccess.core.ports.OrderDatastore;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.UUID;

@RequiredArgsConstructor
@WireIfDatastoreIsDynamoDB
public class DynamoDBOrderDatastore implements OrderDatastore {

    private final DynamoDbClient client;
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
