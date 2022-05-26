package kz.singularity.bankapp.features.transactions.data.repositories;

import kz.singularity.bankapp.features.transactions.data.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {
    Transaction getAllById();
}
