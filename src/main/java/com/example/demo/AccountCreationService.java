package com.example.demo;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
