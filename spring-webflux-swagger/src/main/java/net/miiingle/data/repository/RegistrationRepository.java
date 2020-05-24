package net.miiingle.data.repository;

import net.miiingle.data.entity.Registration;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RegistrationRepository extends ReactiveCrudRepository<Registration, Long> {
}
