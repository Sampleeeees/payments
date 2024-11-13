package ua.com.project.payments.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.project.payments.entity.Client;

public interface ClientRepository extends ReactiveCrudRepository<Client, Long> {
}