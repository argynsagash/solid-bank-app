package kz.singularity.bankapp.features.accounts;

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
        transactionWithdraw.execute(accountListingService.getClientWithdrawAccount(clientID,
                        withdrawDepositOperationCLIUI.requestClientAccountNumber()),
                withdrawDepositOperationCLIUI.requestClientAmount());
    }
}
