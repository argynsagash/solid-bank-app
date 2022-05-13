package kz.singularity.bankapp.features.transactions.presentation.controller;

import kz.singularity.bankapp.features.transactions.domain.services.TransactionDeposit;
import kz.singularity.bankapp.features.accounts.domain.models.Account;
import kz.singularity.bankapp.features.accounts.domain.models.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.models.AccountWithdraw;
import kz.singularity.bankapp.features.accounts.domain.services.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public void depositMoney(String clientID) {
        Account account = accountListingService.getClientAccount(clientID, withdrawDepositOperationCLIUI.requestClientAccountNumber());

        if (account instanceof AccountWithdraw) {
            transactionDeposit.execute((AccountWithdraw) account,
                    withdrawDepositOperationCLIUI.requestClientAmount());
        } else {
            transactionDeposit.execute((AccountDeposit) account,
                    withdrawDepositOperationCLIUI.requestClientAmount());
        }


    }
}
