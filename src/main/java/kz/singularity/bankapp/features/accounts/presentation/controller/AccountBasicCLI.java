package kz.singularity.bankapp.features.accounts.presentation.controller;

import kz.singularity.bankapp.features.accounts.domain.services.AccountListingService;
import kz.singularity.bankapp.core.domain.model.BankCore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountBasicCLI {
    CreateAccountOperationCLIUI createAccountOperationUI;
    BankCore bankCore;
    AccountListingService accountListingService;

    public void createAccountRequest(String clientID) {
        bankCore.createNewAccount(createAccountOperationUI.requestAccountType(), clientID);
    }

    public void getAccounts(String clientID) {
        System.out.println(accountListingService.getClientAccounts(clientID));
    }
}
