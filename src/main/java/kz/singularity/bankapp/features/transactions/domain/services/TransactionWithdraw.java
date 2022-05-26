package kz.singularity.bankapp.features.transactions.domain.services;

import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.domain.services.AccountWithdrawService;
import kz.singularity.bankapp.features.transactions.data.repositories.TransactionDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdraw {
    AccountWithdrawService accountWithdrawService;
    TransactionDAO transactionDAO;
    public void execute(Account account, double amount) {
        accountWithdrawService.withdraw(amount, account);
    }
}
