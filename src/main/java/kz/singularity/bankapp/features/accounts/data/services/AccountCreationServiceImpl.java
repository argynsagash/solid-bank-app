package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.domain.services.AccountCreationService;
import kz.singularity.bankapp.AccountDAO;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;

public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {

    }
}
