package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.data.repositories.AccountRepository;
import kz.singularity.bankapp.features.accounts.domain.services.AccountDepositService;
import kz.singularity.bankapp.features.transactions.data.entities.Transaction;
import kz.singularity.bankapp.features.transactions.data.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    @Override
    public void deposit(double amount, Account account) {
        String message  = String.format("%.2f transferred to %s account", amount, account.getId());
        Transaction transaction = Transaction.builder().
                transactionInfo(message).accountID(account.getId()).build();
        Transaction createdTransaction = transactionRepository.save(transaction);
        account.setBalance(account.getBalance() + amount);
        accountRepository.updateCustomerById(account.getId(),account.getBalance());
        System.out.println(message);

    }

}

