package kz.singularity.bankapp.features.accounts.domain.services;

import kz.singularity.bankapp.features.accounts.data.entities.Account;

public interface AccountWithdrawService {
    void withdraw(double amount, Account account);

}
