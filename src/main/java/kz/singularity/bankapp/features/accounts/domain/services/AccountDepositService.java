package kz.singularity.bankapp.features.accounts.domain.services;

import kz.singularity.bankapp.features.accounts.data.entities.Account;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
