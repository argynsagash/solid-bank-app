package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.data.repositories.AccountRepository;
import kz.singularity.bankapp.features.accounts.domain.services.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountRepository accountRepository;

    @Override
    public void deposit(double amount, Account account) {
        String message = String.format("%.2f transferred to %s account", amount, account.getId());
        account.setBalance(account.getBalance() + amount);
        accountRepository.updateCustomerById(account.getId(),account.getBalance());
        System.out.println(message);

    }

}
