package com.afaqy.service.concurrency.moneytransfer;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private Long number;
    private BigDecimal amount;
    private final Lock lock;

    public Account() {
        this.lock = new ReentrantLock();
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void withdraw(BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(number, account.number) && Objects.equals(amount, account.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, amount);
    }

}
