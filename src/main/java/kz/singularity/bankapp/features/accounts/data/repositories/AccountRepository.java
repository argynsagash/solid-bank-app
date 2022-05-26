package kz.singularity.bankapp.features.accounts.data.repositories;

import kz.singularity.bankapp.features.accounts.data.entities.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

    Account getAccountEntityByClientIDAndId(String clientID, String accountID);
    List<Account> getAccountEntityByClientID(String clientID);

    @Modifying
    @Query("update Account a set a.balance = :balance where a.id = :accountNumber")
    void updateCustomerById(String accountNumber, double balance);
}
