package com.afaqy.service.concurrency.moneytransfer;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;

class BalanceTransferService {

    void transfer(Account from, Account to, BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Amount must be positive");
        }

        if(from.equals(to)) {
            throw new RuntimeException("You cannot transfer to the same account");
        }

        Lock lock1 = from.getNumber() < to.getNumber() ? from.getLock() : to.getLock();
        Lock lock2 = from.getNumber() < to.getNumber() ? to.getLock() : from.getLock();

        lock1.lock();
        lock2.lock();

        try {
            if(amount.compareTo(from.getAmount()) <= 0) {
                from.withdraw(amount);
                to.deposit(amount);
            } else {
                throw new RuntimeException("There is no enough balance");
            }
        } finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

}
