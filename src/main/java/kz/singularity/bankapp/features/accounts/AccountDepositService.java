package kz.singularity.bankapp.features.accounts;

import kz.singularity.bankapp.features.accounts.domain.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.AccountWithdraw;

public interface AccountDepositService {
    void deposit (double amount, AccountWithdraw account);
    void deposit (double amount, AccountDeposit account);
}
