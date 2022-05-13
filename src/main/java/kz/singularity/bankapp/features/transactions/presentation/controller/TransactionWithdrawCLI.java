package kz.singularity.bankapp.features.transactions.presentation.controller;

import kz.singularity.bankapp.features.transactions.domain.services.TransactionWithdraw;
import kz.singularity.bankapp.features.accounts.domain.models.Account;
import kz.singularity.bankapp.features.accounts.domain.models.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.models.AccountWithdraw;
import kz.singularity.bankapp.features.accounts.domain.services.AccountListingService;
import org.springframework.stereotype.Component;

@Component
public class TransactionWithdrawCLI {
    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw,
                                  WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                  AccountListingService accountListingService) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void withdrawMoney(String clientID) {
        Account account = accountListingService.getClientAccount(clientID, withdrawDepositOperationCLIUI.requestClientAccountNumber());

        if (account instanceof AccountWithdraw) {
            transactionWithdraw.execute((AccountWithdraw) account,
                    withdrawDepositOperationCLIUI.requestClientAmount());
        } else {
            transactionWithdraw.execute((AccountDeposit) account,
                    withdrawDepositOperationCLIUI.requestClientAmount());
        }
    }
}
