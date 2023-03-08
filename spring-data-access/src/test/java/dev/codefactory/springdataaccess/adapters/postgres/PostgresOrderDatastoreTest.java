package dev.codefactory.springdataaccess.adapters.postgres;

import dev.codefactory.springdataaccess.core.entities.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = "spring.profiles.active=test")
class PostgresOrderDatastoreTest {

    @Autowired
    private PostgresOrderDatastore orderDatastore;

    @Test
    void createShouldSaveData() {
        Order order = Order.builder()
                .description("Test")
                .build();

        var result = orderDatastore.create(order);

        assertNotNull(result);
    }
}