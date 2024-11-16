package ua.com.project.payments.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ua.com.project.payments.entity.Client;

public interface ClientRepository extends ReactiveCrudRepository<Client, Long> {

    @Query("SELECT id, firstName, lastName FROM clients WHERE firstName = :firstName")
    Mono<Client> findByFirstName(String firstName);
}