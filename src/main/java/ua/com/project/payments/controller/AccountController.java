package ua.com.project.payments.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.project.payments.entity.Account;
import ua.com.project.payments.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public Flux<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Mono<Account> getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    public Mono<Account> createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/{id}")
    public Mono<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }

    @PostMapping("/{id}/block")
    public Mono<Account> blockAccount(@PathVariable Long id) {
        return accountService.blockAccount(id);
    }

    @PostMapping("/{id}/replenish")
    public Mono<Account> replenishAccount(@PathVariable Long id, @RequestParam double amount) {
        return accountService.replenishAccount(id, amount);
    }
}
