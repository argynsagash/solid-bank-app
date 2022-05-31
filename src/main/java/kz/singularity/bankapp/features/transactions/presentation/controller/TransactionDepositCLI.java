package kz.singularity.bankapp.features.transactions.presentation.controller;

import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.domain.services.AccountListingService;
import kz.singularity.bankapp.features.transactions.domain.services.TransactionDeposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@AllArgsConstructor
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public void depositMoney(String clientID) {
        Account account = accountListingService.getClientAccount(clientID, withdrawDepositOperationCLIUI.requestClientAccountNumber());
        transactionDeposit.execute(account, withdrawDepositOperationCLIUI.requestClientAmount());


    }

    public void depositToAccount(Double amount, String accountID) {
        Account account = accountListingService.getClientAccount("1", accountID);
        transactionDeposit.execute(account, amount);

    }
}
