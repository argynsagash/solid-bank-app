package kz.singularity.bankapp;

import kz.singularity.bankapp.features.accounts.domain.models.Account;
import kz.singularity.bankapp.features.accounts.domain.services.AccountCreationService;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;

public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        boolean b = !accountType.equals(AccountType.FIXED);
        accountDAO.createNewAccount(new Account(accountType, String.valueOf(accountID), clientID, 0.0, b));
    }
}
