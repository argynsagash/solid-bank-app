package kz.singularity.bankapp.features.transactions.data.services;

import kz.singularity.bankapp.features.transactions.data.entities.Transaction;
import kz.singularity.bankapp.features.transactions.data.repositories.TransactionRepository;
import kz.singularity.bankapp.features.transactions.domain.services.TransactionGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionGetService {
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getByAccountId(String accountID) {
        return transactionRepository.findAllByAccountID(accountID);
    }
}
