package kz.singularity.bankapp.features.accounts.data.services;

import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.data.repositories.AccountRepository;
import kz.singularity.bankapp.features.accounts.domain.errors.AccountNotFound;
import kz.singularity.bankapp.features.accounts.domain.errors.WithdrawNotAllowed;
import kz.singularity.bankapp.features.accounts.domain.errors.WrongAccountType;
import kz.singularity.bankapp.features.accounts.domain.services.AccountWithdrawService;
import kz.singularity.bankapp.features.transactions.data.entities.Transaction;
import kz.singularity.bankapp.features.transactions.data.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    @Override
    public void withdraw(double amount, Account account) {
        accountRepository.findById(account.getId()).orElseThrow(() -> new AccountNotFound(account.getId()));
        if(!account.isWithdrawAllowed()) {
            throw new WithdrawNotAllowed(account.getId());
        }

        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            String message = String.format("%.2f transferred from %s account", amount, account.getId());
            Transaction transaction = Transaction.builder().
                    transactionInfo(message).accountID(account.getId()).build();
            Transaction createdTransaction = transactionRepository.save(transaction);
            accountRepository.updateCustomerById(account.getId(), account.getBalance());
            System.out.println(message);
        } else System.out.println("You don't have enough money");
    }


}
