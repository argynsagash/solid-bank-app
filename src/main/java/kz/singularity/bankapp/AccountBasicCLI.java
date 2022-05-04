package kz.singularity.bankapp;

import kz.singularity.bankapp.features.accounts.domain.services.AccountListingService;

public class AccountBasicCLI {
    CreateAccountOperationUI createAccountOperationUI;
    BankCore bankCore;
    AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(String clientID) {
        bankCore.createNewAccount(createAccountOperationUI.requestAccountType(), clientID);
    }

    public void getAccounts(String clientID) {
        accountListing.getClientAccounts(clientID);
    }
}
