package kz.singularity.bankapp.features.accounts;

import kz.singularity.bankapp.features.accounts.domain.AccountDAO;
import kz.singularity.bankapp.features.accounts.domain.AccountWithdraw;
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
}
