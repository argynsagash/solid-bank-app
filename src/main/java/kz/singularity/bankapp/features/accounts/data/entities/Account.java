package kz.singularity.bankapp.features.accounts.data.entities;

import kz.singularity.bankapp.features.accounts.domain.models.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;


@Data
@Builder
@AllArgsConstructor
public class Account implements Persistable {

    @NonNull
    @Id
    private String id;
    private AccountType accountType;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;

    @Override
    public String toString() {
        return "Account{" + "id='" + id + ", clientID='" + clientID + ", balance=" + balance + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Override
    public boolean isNew() {
        return true;
    }
}
