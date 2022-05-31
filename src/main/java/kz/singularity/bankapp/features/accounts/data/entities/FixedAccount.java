package kz.singularity.bankapp.features.accounts.data.entities;

import kz.singularity.bankapp.features.accounts.data.entities.AccountDeposit;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(String id, AccountType accountType, String clientID, double balance, boolean withdrawAllowed) {
        super(id,accountType,  clientID, balance, withdrawAllowed);
    }
}
