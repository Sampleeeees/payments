package ua.com.project.payments.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ua.com.project.payments.entity.Role;

@Repository

public interface RoleRepository extends ReactiveCrudRepository<Role, Long> {

    @Query("SELECT * FROM roles WHERE id = :id")
    Mono<Role> findById(Long id);

}
