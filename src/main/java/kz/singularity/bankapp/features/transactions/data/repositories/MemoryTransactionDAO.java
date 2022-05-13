package kz.singularity.bankapp.features.transactions.data.repositories;

import kz.singularity.bankapp.features.transactions.domain.models.Transaction;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MemoryTransactionDAO implements TransactionDAO {
    List<Transaction> transactions;

    @Override
    public List<Transaction> getTransactions() {
        return null;
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }
}
