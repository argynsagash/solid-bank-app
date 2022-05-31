package kz.singularity.bankapp.features.transactions.presentation.controller;

import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.domain.services.AccountListingService;
import kz.singularity.bankapp.features.transactions.domain.services.TransactionWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@AllArgsConstructor
public class TransactionWithdrawCLI {
    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public void withdrawMoney(String clientID) {
        Account account = accountListingService.getClientAccount(clientID, withdrawDepositOperationCLIUI.requestClientAccountNumber());
        transactionWithdraw.execute(account, withdrawDepositOperationCLIUI.requestClientAmount());
    }

    public void withdrawFromAccount(Double amount, String accountID) {
        Account account = accountListingService.getClientAccount("1", accountID);
        transactionWithdraw.execute(account, amount);

    }
}
