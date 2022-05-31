package kz.singularity.bankapp.features.accounts.presentation.controller;

import kz.singularity.bankapp.core.domain.model.BankCore;
import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.data.services.AccountCreationServiceImpl;
import kz.singularity.bankapp.features.accounts.data.services.AccountListingServiceImpl;
import kz.singularity.bankapp.features.accounts.domain.models.AccountRequest;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;
import kz.singularity.bankapp.features.students.data.entities.Student;
import kz.singularity.bankapp.features.students.data.services.StudentService;
import kz.singularity.bankapp.features.students.domain.models.StudentRequest;
import kz.singularity.bankapp.features.transactions.data.entities.Transaction;
import kz.singularity.bankapp.features.transactions.presentation.controller.TransactionDepositCLI;
import kz.singularity.bankapp.features.transactions.presentation.controller.TransactionWithdrawCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//указывает, что данные, возвращаемые каждым методом, будут записаны прямо в текст ответа вместо отображения шаблона.
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountCreationServiceImpl accountCreationService;
    @Autowired
    private AccountListingServiceImpl accountListingService;
    @Autowired
    private BankCore bankCore;
    @Autowired
    private TransactionWithdrawCLI transactionWithdrawCLI;
    @Autowired
    private TransactionDepositCLI transactionDepositCLI;






    //    POST    /accounts                               Создание нового счета
    @PostMapping
    public String createAccount(AccountType accountType) {
        bankCore.createNewAccount(accountType, "1");
        return "Bank account created";
    }

    //    GET     /accounts                               Получение списка счетов
    @GetMapping()
    public List<Account> getAccounts() {
        return accountListingService.getAllAccounts();
    }

    //    GET     /accounts/{account_id}                  Получение информации об одном счете
    @GetMapping("/{account_id}") // указывает, что в аргументах ожидается id - /student/2.
    public Account getAccountById(String id) { //указывает на считываемое значение из URI.
        return accountListingService.getClientAccount("1", id);
    }

    //    POST    /accounts/{account_id}/withdraw         Снятие денег со счета
    @PostMapping("/{account_id}/withdraw")
    public String withdraw(Double amount, String accountID) {
         transactionWithdrawCLI.withdrawFromAccount(amount,accountID);
        return String.format("%.2f transferred from %s account", amount, accountID);
    }

    //    POST    /accounts/{account_id}/deposit          Внесение денег на счет
    @PutMapping("/{account_id}/deposit")
    public String deposit(Double amount, String accountID) {
        transactionDepositCLI.depositToAccount(amount,accountID);
        return String.format("%.2f transferred to %s account", amount, accountID);
    }

    //    GET     /accounts/{account_id}/transactions     Получение списка всех транзакций
//    @GetMapping()
//    public List<Transaction> getTransactionsByAccountID(String accountID) {
//        return accountListingService.getAllAccounts();
//    }

    //    DELETE  /accounts/{account_id}                  Удаление счета
    @DeleteMapping("/{account_id}")
    public boolean deleteStudent(String id) {
        accountListingService.deleteAccountById(id);
        return true;
    }


}