package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.repositories.AccountDAO;
import kz.singularity.bankapp.features.accounts.domain.models.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.models.AccountWithdraw;
import kz.singularity.bankapp.features.accounts.domain.services.AccountWithdrawService;
import org.springframework.stereotype.Component;

@Component
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    AccountDAO accountDAO;

    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            String message = String.format("%.2f transferred from %s account", amount, account.getId());
            System.out.println(message);
            accountDAO.updateAccount(account);
        } else System.out.println("You don't have enough money");
    }

    @Override
    public void withdraw(double amount, AccountDeposit account) {
        System.out.println("Cant withdraw money from Deposit account");
    }
}
