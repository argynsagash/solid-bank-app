package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.core.domain.model.BankCore;
import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.data.repositories.AccountRepository;
import kz.singularity.bankapp.features.accounts.domain.models.*;
import kz.singularity.bankapp.features.accounts.domain.services.AccountCreationService;
import kz.singularity.bankapp.features.students.data.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountRepository accountRepository;

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        boolean b = !accountType.equals(AccountType.FIXED);
        String accountNumber = String.format("%03d%06d", 1, accountID);
        accountRepository.save(new Account(accountNumber, accountType, clientID, 0.0, b));
        System.out.println("Bank account created");

    }

}
