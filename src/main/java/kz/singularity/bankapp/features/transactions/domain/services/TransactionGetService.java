package kz.singularity.bankapp.features.transactions.domain.services;

import kz.singularity.bankapp.features.transactions.data.entities.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TransactionGetService {


    public List<Transaction> getByAccountId(String accountID);
}
