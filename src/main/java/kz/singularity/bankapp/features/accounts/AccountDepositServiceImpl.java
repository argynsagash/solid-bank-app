package kz.singularity.bankapp.features.accounts;

import kz.singularity.bankapp.features.accounts.domain.AccountDAO;
import kz.singularity.bankapp.features.accounts.domain.AccountWithdraw;
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
}
