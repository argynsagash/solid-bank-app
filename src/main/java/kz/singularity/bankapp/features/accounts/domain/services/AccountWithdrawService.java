package kz.singularity.bankapp.features.accounts.domain.services;

import kz.singularity.bankapp.features.accounts.domain.models.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.models.AccountWithdraw;

public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);
    void withdraw(double amount, AccountDeposit account);
}
