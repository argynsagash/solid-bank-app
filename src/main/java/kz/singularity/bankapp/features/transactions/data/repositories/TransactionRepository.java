package kz.singularity.bankapp.features.transactions.data.repositories;


import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.transactions.data.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {
    List<Transaction> findAllByAccountID(String accountID);
}
