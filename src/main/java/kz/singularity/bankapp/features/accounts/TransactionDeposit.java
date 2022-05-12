package kz.singularity.bankapp.features.accounts;

import kz.singularity.bankapp.features.accounts.domain.Account;
import kz.singularity.bankapp.features.accounts.domain.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.AccountWithdraw;
import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    void execute(AccountWithdraw accountWithdraw, double amount) {
        accountDepositService.deposit(amount, accountWithdraw);
    }
    void execute(AccountDeposit accountDeposit, double amount) {
        accountDepositService.deposit(amount, accountDeposit);
    }
}
