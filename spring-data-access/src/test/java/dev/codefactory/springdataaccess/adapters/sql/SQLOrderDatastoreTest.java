package dev.codefactory.springdataaccess.adapters.sql;

import dev.codefactory.springdataaccess.core.entities.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = "spring.profiles.active=test")
class SQLOrderDatastoreTest {

    @Autowired
    private SQLOrderDatastore orderDatastore;

    @Test
    void createShouldSaveData() {
        Order order = Order.builder()
                .description("Test")
                .total(BigDecimal.valueOf(10.05))
                .build();

        var result = orderDatastore.create(order);

        assertNotNull(result);
        assertNotNull(result.getId());
    }
}