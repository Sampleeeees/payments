package ua.com.project.payments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.com.project.payments.entity.Account;
import ua.com.project.payments.entity.Client;

import java.util.Arrays;
import java.util.List;

@RestController
public class PaymentController {

    @GetMapping("/test-clients")
    public Flux<Client> getClients() {
        // Створення акаунтів для кожного клієнта
        Account account1 = new Account(1L, 1000.0, false);
        Account account2 = new Account(2L, 1500.0, false);
        Account account3 = new Account(3L, 2000.0, true);

        // Створення клієнтів з акаунтами

        return Flux.just(
                        new Client(1L, "Vasya", "Pypkin", Arrays.asList(account1, account2)),
                        new Client(2L, "Iva", "Pypkina", List.of(account3)),
                        new Client(3L, "Inna", "Pypkina", Arrays.asList(account1, account3))
                )
                .skip(0)
                .take(2);
    }
}
