package kz.singularity.bankapp.features.transactions.data.repositories;

import kz.singularity.bankapp.features.transactions.domain.models.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
