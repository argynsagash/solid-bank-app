package kz.singularity.bankapp.features.accounts.domain.services;

import kz.singularity.bankapp.features.accounts.domain.models.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.models.AccountWithdraw;

public interface AccountDepositService {
    void deposit (double amount, AccountWithdraw account);
    void deposit (double amount, AccountDeposit account);
}
