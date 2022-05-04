package kz.singularity.bankapp;

import kz.singularity.bankapp.features.accounts.domain.models.Account;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;

import java.util.List;

public class MemoryAccountDAO implements AccountDAO {
    private List<Account> accountList;

    @Override
    public List<Account> getClientAccounts(String clientID) {
        List<Account> list = null;
        for (Account a : accountList) {
            if (a.getClientID().equals(clientID)) {
                list.add(a);
            }
        }
        return list;
    }

    // TODO: 04.05.2022 looks like it is wrong
    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);

    }

    @Override
    public void updateAccount(Account account) {
        int i = 0;
        for (Account a : accountList) {
            if (a.getId().equals(account.getId())) {
                i = accountList.indexOf(a);
            }
        }
        accountList.set(i, account);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> list = null;
        for (Account a : accountList) {
            if (a.getClientID().equals(clientID) && a.getAccountType().equals(accountType)) {
                list.add(a);
            }
        }
        return list;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        for (Account a : accountList) {
            if (a.getClientID().equals(clientID) && a.getId().equals(accountID)) {
                if (a.isWithdrawAllowed()) return (AccountWithdraw) a;
            }
        }
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        for (Account a : accountList) {
            if (a.getClientID().equals(clientID) && a.getId().equals(accountID)) {
                return a;
            }
        }
        return null;
    }
}
