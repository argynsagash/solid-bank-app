package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.entities.AccountEntity;
import kz.singularity.bankapp.features.accounts.data.repositories.AccountDAO;
import kz.singularity.bankapp.features.accounts.data.repositories.AccountRepository;
import kz.singularity.bankapp.features.accounts.domain.models.Account;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;
import kz.singularity.bankapp.features.accounts.domain.services.AccountCreationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;
    private AccountRepository accountRepository;

    @Override
    public void createE(AccountType accountType, long bankID, String clientID, long accountID) {
        boolean b = !accountType.equals(AccountType.FIXED);
        String accountNumber = String.format("%03d%06d", 1, accountID);
        accountRepository.save(new AccountEntity(accountNumber, accountType, clientID, 0.0, b));
        System.out.println("Bank account created");
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        boolean b = !accountType.equals(AccountType.FIXED);
        String accountNumber = String.format("%03d%06d", 1, accountID);
        accountDAO.createNewAccount(new Account(accountType, accountNumber, clientID, 0.0, b));
    }
}
