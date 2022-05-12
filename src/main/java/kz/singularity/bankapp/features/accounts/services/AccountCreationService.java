package kz.singularity.bankapp.features.accounts.services;

import kz.singularity.bankapp.features.accounts.domain.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
