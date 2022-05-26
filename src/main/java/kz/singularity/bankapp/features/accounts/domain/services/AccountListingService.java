package kz.singularity.bankapp.features.accounts.domain.services;

import kz.singularity.bankapp.features.accounts.data.entities.Account;

import java.util.List;

public interface AccountListingService {
    List<Account> getAccounts(String clientID);
    Account getClientAccount(String clientID, String accountID);
}
