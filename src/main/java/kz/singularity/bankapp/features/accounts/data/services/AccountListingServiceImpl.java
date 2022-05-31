package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.data.repositories.AccountRepository;
import kz.singularity.bankapp.features.accounts.domain.services.AccountListingService;
import kz.singularity.bankapp.features.students.data.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public List<Account> getAllAccounts(){
        return Streamable.of(accountRepository.findAll()).toList();
    }

    public void deleteAccountById(String accountID){
        accountRepository.deleteById(accountID);
    }
}
