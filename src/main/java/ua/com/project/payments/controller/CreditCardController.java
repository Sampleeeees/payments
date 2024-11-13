package ua.com.project.payments.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.project.payments.entity.CreditCard;
import ua.com.project.payments.service.CreditCardService;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {
    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping
    public Flux<CreditCard> getAllCreditCards() {
        return creditCardService.getAllCreditCards();
    }

    @GetMapping("/{id}")
    public Mono<CreditCard> getCreditCardById(@PathVariable Long id) {
        return creditCardService.getCreditCardById(id);
    }

    @PostMapping
    public Mono<CreditCard> createCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardService.createCreditCard(creditCard);
    }

    @PutMapping("/{id}")
    public Mono<CreditCard> updateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCard) {
        return creditCardService.updateCreditCard(id, creditCard);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCreditCard(@PathVariable Long id) {
        return creditCardService.deleteCreditCard(id);
    }
}
