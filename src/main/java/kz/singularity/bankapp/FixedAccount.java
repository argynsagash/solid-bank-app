package kz.singularity.bankapp;

import kz.singularity.bankapp.features.accounts.domain.models.AccountType;

public class FixedAccount extends AccountDeposit{
    public FixedAccount(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
