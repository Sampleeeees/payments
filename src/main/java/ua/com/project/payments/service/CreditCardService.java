package ua.com.project.payments.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.project.payments.entity.CreditCard;
import ua.com.project.payments.repository.CreditCardRepository;

@Service
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public Flux<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    public Mono<CreditCard> getCreditCardById(Long id) {
        return creditCardRepository.findById(id);
    }

    public Mono<CreditCard> createCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public Mono<CreditCard> updateCreditCard(Long id, CreditCard creditCard) {
        return creditCardRepository.findById(id)
                .flatMap(existingCard -> {
                    existingCard.setCardNumber(creditCard.getCardNumber());
                    existingCard.setAccount(creditCard.getAccount());
                    return creditCardRepository.save(existingCard);
                });
    }

    public Mono<Void> deleteCreditCard(Long id) {
        return creditCardRepository.deleteById(id);
    }
}
