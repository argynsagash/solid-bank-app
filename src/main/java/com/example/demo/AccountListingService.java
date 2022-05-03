package com.example.demo;

import java.util.List;

public interface AccountListingService {
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType(String clientID,AccountType accountType);
    AccountWithdraw getClientWithdrawAccount(String clientID,String accountID);
    Account getClientAccount(String clientID,String accountID);
}
