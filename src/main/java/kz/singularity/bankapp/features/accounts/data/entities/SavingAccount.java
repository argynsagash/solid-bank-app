package kz.singularity.bankapp.features.accounts.data.entities;

import kz.singularity.bankapp.features.accounts.data.entities.AccountWithdraw;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String id, AccountType accountType, String clientID, double balance, boolean withdrawAllowed) {
        super(id, accountType, clientID, balance, withdrawAllowed);
    }
}
