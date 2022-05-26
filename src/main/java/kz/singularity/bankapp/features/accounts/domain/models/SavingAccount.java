package kz.singularity.bankapp.features.accounts.domain.models;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String id, AccountType accountType, String clientID, double balance, boolean withdrawAllowed) {
        super(id, accountType, clientID, balance, withdrawAllowed);
    }
}
