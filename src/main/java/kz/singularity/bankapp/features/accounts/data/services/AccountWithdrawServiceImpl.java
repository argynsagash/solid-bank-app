package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.data.repositories.AccountRepository;
import kz.singularity.bankapp.features.accounts.domain.services.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountRepository accountRepository;

    @Override
    public void withdraw(double amount, Account account) {
        if(!account.isWithdrawAllowed()) {
            System.out.println("Not allowed withdraw");
            return;
        }

        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            String message = String.format("%.2f transferred from %s account", amount, account.getId());
            accountRepository.updateCustomerById(account.getId(), account.getBalance());
            System.out.println(message);
        } else System.out.println("You don't have enough money");
    }


}
