package kz.singularity.bankapp.features.accounts.data.repositories;

import kz.singularity.bankapp.features.accounts.data.entities.AccountEntity;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, String> {

    //    @Query("insert into Account_Entity a values (a.id = :accountNumber, a.account_type = :accountType," +
//            "a.client_id = :customerId, a.balance = :b, a.withdraw_allowed = :w)")
    @Query("insert into Account_Entity values (id, account_type,client_id, balance, withdraw_allowed)")
    void greateAccount(String accountNumber, AccountType accountType, String customerId, double b, boolean w);
}
