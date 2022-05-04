package kz.singularity.bankapp.features.accounts.domain.services;

import kz.singularity.bankapp.features.accounts.domain.models.Account;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;
import kz.singularity.bankapp.AccountWithdraw;

import java.util.List;

public interface AccountListingService{
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    Account getClientAccount(String clientID,String accountID);
}
