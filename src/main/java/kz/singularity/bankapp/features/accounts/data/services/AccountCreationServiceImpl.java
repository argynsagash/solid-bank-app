package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.repositories.AccountDAO;
import kz.singularity.bankapp.features.accounts.domain.models.Account;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;
import kz.singularity.bankapp.features.accounts.domain.services.AccountCreationService;
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
