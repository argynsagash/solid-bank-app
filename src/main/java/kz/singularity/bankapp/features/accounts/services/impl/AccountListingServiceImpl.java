package kz.singularity.bankapp.features.accounts.services.impl;

import kz.singularity.bankapp.features.accounts.domain.*;
import kz.singularity.bankapp.features.accounts.services.AccountListingService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountListingServiceImpl implements AccountListingService {
    private AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {

        return accountDAO.getClientAccountsByType(clientID, accountType);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }
}