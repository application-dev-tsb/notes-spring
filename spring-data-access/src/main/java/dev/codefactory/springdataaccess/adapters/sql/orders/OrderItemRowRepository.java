package dev.codefactory.springdataaccess.adapters.sql.orders;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemRowRepository extends CrudRepository<OrderItemRow, UUID> {
}
