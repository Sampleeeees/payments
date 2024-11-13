package ua.com.project.payments.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.project.payments.entity.Account;
import ua.com.project.payments.repository.AccountRepository;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Flux<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Mono<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Mono<Account> createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Mono<Account> updateAccount(Long id, Account account) {
        return accountRepository.findById(id)
                .flatMap(existingAccount -> {
                    existingAccount.setBalance(account.getBalance());
                    existingAccount.setBlocked(account.isBlocked());
                    return accountRepository.save(existingAccount);
                });
    }

    public Mono<Void> deleteAccount(Long id) {
        return accountRepository.deleteById(id);
    }

    public Mono<Account> blockAccount(Long id) {
        return accountRepository.findById(id)
                .flatMap(account -> {
                    account.setBlocked(true);
                    return accountRepository.save(account);
                });
    }

    public Mono<Account> replenishAccount(Long id, double amount) {
        return accountRepository.findById(id)
                .flatMap(account -> {
                    if (!account.isBlocked()) {
                        account.replenish(amount);
                        return accountRepository.save(account);
                    } else {
                        return Mono.error(new IllegalStateException("Account is blocked"));
                    }
                });
    }
}
