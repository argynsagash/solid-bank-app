package kz.singularity.bankapp.features.transactions.domain.services;

import kz.singularity.bankapp.features.accounts.domain.models.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.models.AccountWithdraw;
import kz.singularity.bankapp.features.accounts.domain.services.AccountWithdrawService;
import kz.singularity.bankapp.features.transactions.data.repositories.TransactionDAO;
import org.springframework.stereotype.Component;

@Component
public class TransactionWithdraw {
    AccountWithdrawService accountWithdrawService;
    TransactionDAO transactionDAO;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(AccountWithdraw accountWithdraw, double amount) {
        accountWithdrawService.withdraw(amount, accountWithdraw);
    }
    public void execute(AccountDeposit accountDeposit, double amount) {
        accountWithdrawService.withdraw(amount, accountDeposit);
    }
}
