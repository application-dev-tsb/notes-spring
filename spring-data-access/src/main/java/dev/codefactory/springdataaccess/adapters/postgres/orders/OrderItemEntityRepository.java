package dev.codefactory.springdataaccess.adapters.postgres.orders;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemEntityRepository extends CrudRepository<OrderItemEntity, UUID> {
}
