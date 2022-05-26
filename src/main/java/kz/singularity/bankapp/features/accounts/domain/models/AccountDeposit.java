package kz.singularity.bankapp.features.accounts.domain.models;

import kz.singularity.bankapp.features.accounts.data.entities.Account;

public class AccountDeposit extends Account {
    public AccountDeposit(String id, AccountType accountType, String clientID, double balance, boolean withdrawAllowed) {
        super(id, accountType, clientID, balance, withdrawAllowed);
    }
}
