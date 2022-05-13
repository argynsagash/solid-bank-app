package kz.singularity.bankapp.features.accounts.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Account {
    private AccountType accountType;
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;

    @Override
    public String toString() {
        return "Account{" + "id='" + id + ", clientID='" + clientID + ", balance=" + balance + '}';
    }
}
