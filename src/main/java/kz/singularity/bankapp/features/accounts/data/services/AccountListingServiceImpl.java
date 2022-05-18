package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.repositories.AccountDAO;
import kz.singularity.bankapp.features.accounts.domain.models.Account;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;
import kz.singularity.bankapp.features.accounts.domain.models.AccountWithdraw;
import kz.singularity.bankapp.features.accounts.domain.services.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountListingServiceImpl implements AccountListingService {
    private AccountDAO accountDAO;

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
