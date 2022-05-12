package kz.singularity.bankapp.features.accounts;

import kz.singularity.bankapp.features.accounts.services.AccountListingService;
import org.springframework.stereotype.Component;

@Component
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public TransactionDepositCLI(TransactionDeposit transactionDeposit,
                                 WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                 AccountListingService accountListingService) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    void depositMoney(String clientID) {
        transactionDeposit.execute(accountListingService.getClientWithdrawAccount(clientID,
                        withdrawDepositOperationCLIUI.requestClientAccountNumber()),
                withdrawDepositOperationCLIUI.requestClientAmount());
    }
}
