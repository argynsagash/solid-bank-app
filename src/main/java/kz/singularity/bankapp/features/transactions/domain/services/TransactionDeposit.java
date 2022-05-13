package kz.singularity.bankapp.features.transactions.domain.services;

import kz.singularity.bankapp.features.accounts.domain.models.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.models.AccountWithdraw;
import kz.singularity.bankapp.features.accounts.domain.services.AccountDepositService;
import kz.singularity.bankapp.features.transactions.data.repositories.TransactionDAO;
import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    AccountDepositService accountDepositService;
    TransactionDAO transactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(AccountWithdraw accountWithdraw, double amount) {
        accountDepositService.deposit(amount, accountWithdraw);
    }
    public void execute(AccountDeposit accountDeposit, double amount) {
        accountDepositService.deposit(amount, accountDeposit);
    }
}
