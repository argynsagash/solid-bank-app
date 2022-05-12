package kz.singularity.bankapp.features.accounts;

import kz.singularity.bankapp.features.accounts.domain.AccountWithdraw;

public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);
}
