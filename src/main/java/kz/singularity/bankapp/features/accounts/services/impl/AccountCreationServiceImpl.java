package kz.singularity.bankapp.features.accounts.services.impl;

import kz.singularity.bankapp.features.accounts.domain.AccountDAO;
import kz.singularity.bankapp.features.accounts.domain.Account;
import kz.singularity.bankapp.features.accounts.services.AccountCreationService;
import kz.singularity.bankapp.features.accounts.domain.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        boolean b = !accountType.equals(AccountType.FIXED);
        String accountNumber = String.format("%03d%06d", 1, accountID);
        accountDAO.createNewAccount(new Account(accountType, accountNumber, clientID, 0.0, b));
    }
}
