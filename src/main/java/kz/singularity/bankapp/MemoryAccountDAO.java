package kz.singularity.bankapp;

import kz.singularity.bankapp.features.accounts.domain.models.*;

import java.util.ArrayList;
import java.util.List;

public class MemoryAccountDAO implements AccountDAO {
    private List<Account> accountList = new ArrayList<>();

    @Override
    public List<Account> getClientAccounts(String clientID) {
        List<Account> list = new ArrayList<>();
        for (Account a : accountList) {
            if (a.getClientID().equals(clientID)) {
                list.add(a);
            }
        }
        return list;
    }

    @Override
    public void createNewAccount(Account account) {
        if (account.getAccountType().equals(AccountType.SAVING)) {
            accountList.add(new SavingAccount(account.getAccountType(), account.getId(), account.getClientID(),
                    account.getBalance(), account.isWithdrawAllowed()));
            System.out.println("Bank account created");
        } else if (account.getAccountType().equals(AccountType.CHECKING)) {
            accountList.add(new CheckingAccount(account.getAccountType(), account.getId(), account.getClientID(),
                    account.getBalance(), account.isWithdrawAllowed()));
            System.out.println("Bank account created");
        } else {
            accountList.add(new FixedAccount(account.getAccountType(), account.getId(), account.getClientID(),
                    account.getBalance(), account.isWithdrawAllowed()));
            System.out.println("Bank account created");
        }


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
