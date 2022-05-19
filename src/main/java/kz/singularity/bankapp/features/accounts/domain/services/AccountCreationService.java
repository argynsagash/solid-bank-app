package kz.singularity.bankapp.features.accounts.domain.services;

import kz.singularity.bankapp.features.accounts.domain.models.AccountType;

public interface AccountCreationService {
    void createE(AccountType accountType, long bankID, String clientID, long accountID);
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
