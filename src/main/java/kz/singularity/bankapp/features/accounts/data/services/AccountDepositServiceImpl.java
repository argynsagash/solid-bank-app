package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.repositories.AccountDAO;
import kz.singularity.bankapp.features.accounts.domain.models.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.models.AccountWithdraw;
import kz.singularity.bankapp.features.accounts.domain.services.AccountDepositService;
import org.springframework.stereotype.Component;

@Component
public class AccountDepositServiceImpl implements AccountDepositService {
    AccountDAO accountDAO;

    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(double amount, AccountWithdraw account) {

        String message = String.format("%.2f transferred to %s account", amount, account.getId());
        System.out.println(message);
        account.setBalance(account.getBalance() + amount);
        accountDAO.updateAccount(account);


    }

    @Override
    public void deposit(double amount, AccountDeposit account) {
        String message = String.format("%.2f transferred to %s account", amount, account.getId());
        System.out.println(message);
        account.setBalance(account.getBalance() + amount);
        accountDAO.updateAccount(account);
    }
}
