package ua.com.project.payments.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long accountId;
    private Double balance;
    private boolean isBlocked;


    public void replenish(double amount) {
        if (!isBlocked) {
            this.balance += amount;
        } else {
            throw new IllegalStateException("Account is blocked");
        }
    }


    public void makePayment(double amount) {
        if (!isBlocked && this.balance >= amount) {
            this.balance -= amount;
        } else if (isBlocked) {
            throw new IllegalStateException("Account is blocked");
        } else {
            throw new IllegalStateException("Insufficient balance");
        }
    }


    public void blockAccount() {
        this.isBlocked = true;
    }
}