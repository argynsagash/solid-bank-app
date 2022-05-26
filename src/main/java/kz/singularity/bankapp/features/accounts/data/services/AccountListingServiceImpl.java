package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.data.repositories.AccountRepository;
import kz.singularity.bankapp.features.accounts.domain.services.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountListingServiceImpl implements AccountListingService {
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts(String clientID) {
        return accountRepository.getAccountEntityByClientID(clientID);
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountRepository.getAccountEntityByClientIDAndId(clientID,accountID);
    }
}
