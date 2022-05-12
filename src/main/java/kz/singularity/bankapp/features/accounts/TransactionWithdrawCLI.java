package kz.singularity.bankapp.features.accounts;

import kz.singularity.bankapp.features.accounts.domain.Account;
import kz.singularity.bankapp.features.accounts.domain.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.AccountWithdraw;
import kz.singularity.bankapp.features.accounts.services.AccountListingService;
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

    void withdrawMoney(String clientID) {
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
