package kz.singularity.bankapp.features.accounts.domain.models;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(String id,AccountType accountType,  String clientID, double balance, boolean withdrawAllowed) {
        super(id,accountType,  clientID, balance, withdrawAllowed);
    }
}
