package kz.singularity.bankapp.features.accounts.data.entities;

import kz.singularity.bankapp.features.accounts.domain.models.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;


@Data
@Builder
@AllArgsConstructor
public class AccountEntity implements Persistable {

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
    public boolean isNew() {
        return true;
    }
}
