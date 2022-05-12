package kz.singularity.bankapp.features.accounts;

import kz.singularity.bankapp.features.accounts.domain.Account;
import kz.singularity.bankapp.features.accounts.domain.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.AccountWithdraw;
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
