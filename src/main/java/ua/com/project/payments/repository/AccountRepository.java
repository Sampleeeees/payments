package ua.com.project.payments.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.project.payments.entity.Account;

public interface AccountRepository extends ReactiveCrudRepository<Account, Long> {
}
