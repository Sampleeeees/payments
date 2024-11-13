package ua.com.project.payments.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.project.payments.entity.CreditCard;

public interface CreditCardRepository extends ReactiveCrudRepository<CreditCard, Long> {
}
